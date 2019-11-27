package com.yui.study.jvm.agent.attach.transformer;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @author XuZhuohao
 * @date 2019/10/31
 */
public class ClassFileTransformerImpl implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        ///
//        System.out.println(className);
//        //如果加载Business类才拦截
//        String basePackage = "com/yui/study/jvm/agent/demo/AgentDemoApplication";
//        if (!basePackage.equals(className)) {
//            return null;
//        }
//
//        //javassist的包名是用点分割的，需要转换下
//        if (className != null && className.indexOf("/") != -1) {
//            className = className.replaceAll("/", ".");
//        }
//        try {
//            //通过包名获取类文件
//            CtClass cc = ClassPool.getDefault().get(className);
//            //获得指定方法名的方法
//            CtMethod m = cc.getDeclaredMethod("doSomeThing");
//            //在方法执行前插入代码
//            m.insertBefore("{ System.out.println(\"记录日志\"); }");
//            return cc.toBytecode();
//        } catch (NotFoundException e) {
//        } catch (CannotCompileException e) {
//        } catch (IOException e) {
//            //忽略异常处理
//        }
        return null;
    }
}
