package com.vincent;

import com.vincent.basic.AnnotationDemo;
import org.junit.Test;

import java.lang.annotation.Annotation;

/**
 * Created by Administrator on 2017/7/11.
 */
@AnnotationDemo("demo")
public class AnnotationDemoTest {

    @Test
    public void getValueTest() {
        Annotation[] annotations = AnnotationDemoTest.class.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof AnnotationDemo) {
                System.out.println(((AnnotationDemo) annotation).value());
            }
        }
        AnnotationDemo demo = AnnotationDemoTest.class.getAnnotation(AnnotationDemo.class);
        System.out.println(demo.value());
    }
}
