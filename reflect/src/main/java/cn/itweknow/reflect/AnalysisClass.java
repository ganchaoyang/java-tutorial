package cn.itweknow.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class AnalysisClass {

    public static void main(String[] args) {

        Class cl = User.class;

        // 类的修饰符
        String modifiers = Modifier.toString(cl.getModifiers());
        Class superCl = cl.getSuperclass();
        if (modifiers != null && modifiers.length() > 0) {
            System.out.print(modifiers + " " + cl.getName());
        }
        System.out.println(cl.getName() + " ");
        if (superCl != null && superCl != Object.class) {
            System.out.println("extends " + superCl.getName() + " {");
        }
        // 属性
        printFields(cl);
        // 构造器、
        printConstructors(cl);
        // 方法
        printMethods(cl);
        // 结束的括号
        System.out.println("}");

    }

    private static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();

        for (Field field : fields) {
            Class type = field.getType();
            String name = field.getName();
            String modifiers = Modifier.toString(field.getModifiers());
            System.out.println("    " + modifiers + " " + type + " " + name + ";");
        }
    }

    private static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");
            Class[] paramTypes = c.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(paramTypes [j].getName()); }
            System.out.println(");");
        }
    }


    public static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            Class retType = m.getReturnType();
            String name = m.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(retType.getName() + " " + name + "(");
            Class [] paramTypes = m.getParameterTypes();

            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) System.out.print("f ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }
}
