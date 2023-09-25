package com.haha;

/**
 * @author hhm
 * @version 1.0
 */
public class CpuNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        //获取当前电脑的cpu数量/核心数
        int cpuNums = runtime.availableProcessors();
        System.out.println("当前电脑cpu个数："+cpuNums);


    }
}
