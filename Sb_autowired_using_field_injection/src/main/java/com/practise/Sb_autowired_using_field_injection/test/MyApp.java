package com.practise.Sb_autowired_using_field_injection.test;

import java.lang.reflect.Field;
/*Using ReflectionApi we are able to access private variable outside of class in java*/
public class MyApp {
    public static void main(String[] args) {
        try {
            // Loading class using class.forName()
            Class<?> clz = Class.forName("com.practise.Sb_autowired_using_field_injection.test.Demo");


            Object object = clz.getDeclaredConstructor().newInstance();

          //Getting field declared in class
            Field ageField = clz.getDeclaredField("age");

            // Access private variable accessible outside of class
            ageField.setAccessible(true);

            // Set value
            ageField.set(object, 30);

            // Get value
            System.out.println("Age = " + ageField.get(object));

        } catch (ClassNotFoundException |
                 NoSuchMethodException |
                 InstantiationException |
                 IllegalAccessException |
                 NoSuchFieldException |
                 java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
