package com.yui.study.jvm.javassist;

import com.yui.study.jvm.javassist.demo.service.CodeService;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.NotFoundException;
import javassist.bytecode.FieldInfo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author XuZhuohao
 * @date 2019/10/31
 */
public class JavassistApplication {
    public static void main(String[] args) throws Exception {
        // ClassPool，CtClass ，CtMethod 以及 CtField
        final ClassPool classPool = ClassPool.getDefault();
        final CtClass ctClass = classPool.get(T1.class.getName());
        for (FieldInfo field : ctClass.getClassFile().getFields()) {
            System.out.println(field.getName());
        }
        Map<String, String> im = new HashMap<>(16);
        im.put("key","");
        im.put("key1","");
        im.put("key2","");
        final String[] objects = im.values().toArray(new String[0]);
    }

    static class T1{
        private String t1;
    }
    static class T2 extends T1{
        private String t2;
    }
}
