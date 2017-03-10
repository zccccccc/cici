package com.springboot.demo.util.sqlutil;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 读取xml 并反射到指定空间中
 */
public enum LoadingSqlXml {

    INSTANCE;

    //获取dbsql绝对路径
    private final static String dbSqlPath = ClassUtils.getDefaultClassLoader().getResource("dbsql").getPath();
    //定义私有SQLMap  XML中的namespace,version 该文件下的sql集合
    private static final Map<String, HashMap<Double, HashMap<String, String>>> myHashMaps = new HashMap<String, HashMap<Double, HashMap<String, String>>>();

    //定义私有SQLMap集合
    private static HashMap sqlMap = null;

    //定义版本集合
    private static final HashMap<Double, HashMap<String, String>> versionMap = new HashMap();


    //根据名称找到当前实现类下需要使用的SQL集合
    //如:   private HashMap<String, String> dbSqlMap = LoadingSqlXml.INSTANCE.findSqlMap(this.getClass().getName());
    //  dbSqlMap.get("sqlId");
    public HashMap<String, String> findSqlMap(String c) {

        if (myHashMaps.isEmpty()) {
            try {
                init();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        HashMap<String, String> _h = null;
        for (Map.Entry<Double, HashMap<String, String>> entry0 : myHashMaps.get(c).entrySet()) {
            _h = entry0.getValue();
        }
        return _h;
    }

    //初始化执行
    public void init() throws InitDataSqlReaderException, DocumentException {
        if (!myHashMaps.isEmpty()) {
            return;
        }
        File file = new File(dbSqlPath);
        File[] files = file.listFiles();
        for (File f : files) {
            ReadDbSqlXml(f);
        }
    }

    //读取文件XML并解析到 数据集合中
    private void ReadDbSqlXml(File f) throws InitDataSqlReaderException, DocumentException {

        SAXReader reader = new SAXReader();
        Document doc = reader.read(f);
        Element root = doc.getRootElement();
        Element fo;
        Element value;
        String fileName = f.getName();

        //迭代器查看有几个
        for (Iterator i = root.elementIterator("mapper"); i.hasNext(); ) {

            fo = (Element) i.next();

            List<String> attributes = fo.attributes();
            if (attributes.size() == 0) {
                throw new InitDataSqlReaderException(fileName.concat(" 在mapper节点找不到属性,请定义 [namespace,version] "));
            }

            String namespace = fo.attribute("namespace").getValue();
            String version = fo.attribute("version").getValue();

            if (StringUtils.isEmpty(namespace)) {
                throw new InitDataSqlReaderException(fileName.concat(" 在mapper节点找不到属性,请定义 namespace "));
            }
            if (StringUtils.isEmpty(version)) {
                throw new InitDataSqlReaderException(fileName.concat(" 在mapper节点找不到属性,请定义 version "));
            }

            if (myHashMaps.get(namespace) != null) {
                throw new InitDataSqlReaderException(fileName.concat(" 在mapper节点 中的 namespace 定义重复 ==>" + namespace));
            }

            for (Iterator k = fo.elementIterator("sql"); k.hasNext(); ) {
                sqlMap = new HashMap();
                value = (Element) k.next();
                String id = value.attribute("id").getValue();

                if (id.equals("")) {
                    throw new InitDataSqlReaderException(fileName.concat("在mapper下sql未定义id"));
                }

                String sql = String.valueOf(value.getData());
                if (sqlMap.get(id) == null) {
                    sqlMap.put(id, sql);
                } else {
                    throw new InitDataSqlReaderException(fileName.concat("sql 节点 ID 定义重复 当前ID=" + id));
                }

            }
            versionMap.put(Double.parseDouble(version), sqlMap);
            myHashMaps.put(namespace, versionMap);
        }
    }
}
