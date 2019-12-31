package com.yui.study.jvm.loader.service.impl;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

/**
 * @author XuZhuohao
 * @date 2019/12/31
 */
public class MyClassLoader extends URLClassLoader {

    @Override
    public void addURL(URL url) {
        super.addURL(url);
    }

    public MyClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public MyClassLoader(URL[] urls) {
        super(urls);
    }

    public MyClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }
}
