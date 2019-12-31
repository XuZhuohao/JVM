package com.yui.study.jvm.loader;

import com.yui.study.jvm.loader.service.impl.MyClassLoader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author XuZhuohao
 * @date 2019/12/31
 */
public class ClassLoaderServiceApplication {

    public static void main(String[] args) throws Exception {
        // TODO: jar 包依赖于另一个 jar 怎么处理
        File file = new File("D:\\software\\apache-maven-3.5.4\\.m2\\cn\\com\\bluemoon\\short-message-api\\1.0.0\\short-message-api-1.0.0.jar");
        final List<String> clazzes = analysisJar(file);
        ///
//        final MyClassLoader classLoader = new MyClassLoader(new URL[]{file.toURI().toURL()});
        final URLClassLoader classLoader = new URLClassLoader(new URL[]{file.toURI().toURL()});

        for (String className : clazzes) {
            System.out.println(className);
            final Class<?> clazz = classLoader.loadClass(className);
            if (!clazz.isInterface()) {
                continue;
            }
            System.out.println(clazz.getName());
//            for (Field field : clazz.getFields()) {
//                System.out.println(" -" + field.getName());
//            }
//            for (Field declaredField : clazz.getDeclaredFields()) {
//                System.out.println(" -" + declaredField.getName());
//            }
            for (Method method : clazz.getMethods()) {
//                System.out.println(method);
                System.out.println(" -" + method.getName());
                for (Class<?> parameterType : method.getParameterTypes()) {
                    System.out.println(" --" + parameterType.getName());
                }
            }
        }

    }

    public static List<String> analysisJar(File file) throws IOException {
        List<String> result = new ArrayList<>(16);
        final JarFile jarFile = new JarFile(file);
        final Enumeration<JarEntry> entries = jarFile.entries();
        while(entries.hasMoreElements()){
            final JarEntry jarEntry = entries.nextElement();
            if (jarEntry.isDirectory() || !jarEntry.getName().endsWith(".class")){
                continue;
            }
            result.add(jarEntry.getName().replaceAll("/",".").replace(".class",""));
        }
        return result;
    }
}
