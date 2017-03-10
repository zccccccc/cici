package com.springboot.demo.util.base.entityvo;

/**
 * 返回状态字典
 * K 状态返回
 * M 提示消息
 * E 异常消息
 */
public class ReturnCodeDict<K extends Integer, M extends String, E extends String> {

    public static final ReturnCodeDict OK = new ReturnCodeDict(200, "成功");
    public static final ReturnCodeDict ERROR = new ReturnCodeDict(500, "异常了");
    public K k;
    public M m;
    public E e;


    public ReturnCodeDict(K k, M m) {
        this.k = k;
        this.m = m;
    }
    public ReturnCodeDict(K k, M m, E e) {
        this.k = k;
        this.m = m;
        this.e = e;
    }
}
