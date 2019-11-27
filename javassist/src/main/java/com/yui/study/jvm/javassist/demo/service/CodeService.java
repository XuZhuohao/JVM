package com.yui.study.jvm.javassist.demo.service;

/**
 * @author XuZhuohao
 * @date 2019/10/31
 */
public class CodeService {

    public void display(String text){
        System.out.println(String.format("%s - %s - start: %s ", this.getClass().getName(), "display", text));
        final RuntimeException runtimeException = new RuntimeException();
        for (StackTraceElement stackTraceElement : runtimeException.getStackTrace()) {
            System.out.println(stackTraceElement.getClassName());
        }
        System.out.println(String.format("%s - %s - end: %s", this.getClass().getName(), "display", text));

    }
}
