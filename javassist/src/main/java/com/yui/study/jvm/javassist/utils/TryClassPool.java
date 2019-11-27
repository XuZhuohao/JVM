package com.yui.study.jvm.javassist.utils;

import com.yui.study.jvm.javassist.demo.service.CodeService;
import javassist.*;
import javassist.bytecode.AttributeInfo;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author XuZhuohao
 * @date 2019/10/31
 */
public class TryClassPool {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, IOException {
        /// 测试代码
//        final CodeService codeService = new CodeService();
//        codeService.display("test01");
        final ClassPool classPool = ClassPool.getDefault();
        final CtClass ctClass = classPool.get(CodeService.class.getName());
        final CtMethod display = ctClass.getDeclaredMethod("display");
//        display.insertBefore("{ System.out.println(\"耗时：\");}");
//        display.insertBefore("{long begin = System.currentTimeMillis();}");
//        display.insertAfter("{" +
//                "long end = System.currentTimeMillis();\n" +
//                "System.out.println(\"耗时：\" + (begin - end) );" +
//                "}");
//        System.out.println(Arrays.toString(ctClass.toBytecode()));
        final CodeAttribute codeAttribute = display.getMethodInfo().getCodeAttribute();
        final LocalVariableAttribute attribute = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        int pos = Modifier.isStatic(display.getModifiers()) ? 0 : 1;
        System.out.println(attribute.variableName(pos));
        System.out.println(attribute.variableName(1 + pos));
//        System.out.println(attribute.variableName(2 + pos));
        // 冻结类
//        Class clazz = ctClass.toClass();
        ctClass.defrost();
    }

    public static String[] getMethodVariableName(String classname, String methodname) {
        try {
            ClassPool pool = ClassPool.getDefault();
            CtClass cc = pool.get(classname);
            CtMethod cm = cc.getDeclaredMethod(methodname);
            MethodInfo methodInfo = cm.getMethodInfo();
            CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
            String[] paramNames = new String[cm.getParameterTypes().length];
            LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
            if (attr != null) {
                int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
                for (int i = 0; i < paramNames.length; i++) {
                    paramNames[i] = attr.variableName(i + pos);
                }
                return paramNames;
            }
        } catch (Exception e) {
            System.out.println("getMethodVariableName fail " + e);
        }
        return null;
    }


}
