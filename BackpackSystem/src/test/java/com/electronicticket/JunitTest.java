package com.electronicticket;

import org.junit.jupiter.api.*;

import java.lang.annotation.Annotation;


/**
 * @author Niubaiquan
 * @desc Junit常用注解
 * @date 2022年05月19日 2022/5/19
 */
//@SpringBootTest该注解可以让这测试类获取Springboot容器中的组件
//@DisplayName注解给测试类或者测试方法添加名字
@DisplayName("JunitTest类")
public class JunitTest {
    @DisplayName("这是")
    @Test
    void JunitTestMethod1(){
        System.out.println("tset1");
    }
    @Disabled//在测试中该方法不执行
    @Test
    void JunitTestMethod2(){
        System.out.println("tset2");
    }
    @BeforeEach//每一个测试执行之前
    void BeforeEachTest(){
        System.out.println("测试方法开始了");
    }
    @AfterEach//每一个测试执行之后
    void AfterEachTest(){
        System.out.println("测试方法结束了");
    }
    @BeforeAll//所有测试执行之前
    static void BeforeAllTest(){
        System.out.println("所有测试方法开始了");
    }
    @AfterAll//所有测试执行之后
    static void AfterAllTest(){
        System.out.println("所有测试方法结束了");
    }
    //测试自定义注解
    @Test
    void AnnotationTest() throws NoSuchMethodException {
        My my = new My();
        Class<? extends My> myClass = my.getClass();
        //获取类的注解
        Annotation[] annotations = myClass.getAnnotations();
        for (Annotation annotation: annotations) {
            if (annotation instanceof Myself){
                Myself temp = (Myself) annotation;
                //获取注解的值
                System.out.println(temp.value());
            }
        }
    }

}
