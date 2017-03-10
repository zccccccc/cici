package com.springboot.demo.util.base.serve;

import com.springboot.demo.util.base.entityvo.BaseOutput;
import com.springboot.demo.util.base.entityvo.BasePage;
import com.springboot.demo.util.base.entityvo.ReturnCode;
import com.springboot.demo.util.base.entityvo.ReturnCodeDict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

/**
 * 综合实现
 */
public class P {


    /**
     * 包装输出
     */
    public static <T> BaseOutput wrapBaseOutput(Page<T> tPage) {

        BaseOutput baseOutput = new BaseOutput();
        BasePage basePage = new BasePage();
        basePage.setCurrentPage(tPage.getNumber());
        basePage.setSize(tPage.getSize());
        basePage.setTotalElement(tPage.getTotalElements());
        basePage.setTotalPages(tPage.getTotalPages());


        baseOutput.setPage(basePage);
        baseOutput.setData(tPage.getContent());
        baseOutput.setReturnCode(new ReturnCode(ReturnCodeDict.OK.k, ReturnCodeDict.OK.m));
        return baseOutput;

    }


    /***
     * 提取分业信息
     */
    public static Pageable extractPageable(BasePage basePageSearch) {

        Sort sort = null;
        if (!StringUtils.isEmpty(basePageSearch.getSortField())) {

            if (basePageSearch.getSortDirection().equals("DESC")) {
                sort = new Sort(Sort.Direction.DESC, basePageSearch.getSortField());
            }
            if (basePageSearch.getSortDirection().equals("ASC")) {
                sort = new Sort(Sort.Direction.ASC, basePageSearch.getSortField());
            }
        }

        Pageable pageable = null;

        if (sort != null) {
            pageable = new PageRequest(basePageSearch.getCurrentPage(), basePageSearch.getSize(), sort);
        } else if (sort == null) {
            pageable = new PageRequest(basePageSearch.getCurrentPage(), basePageSearch.getSize());
        }

        return pageable;

    }
}
