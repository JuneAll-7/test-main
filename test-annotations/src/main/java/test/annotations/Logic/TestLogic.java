package test.annotations.Logic;

import test.annotations.annotation.TestAnnotation;

import java.lang.reflect.Method;

public class TestLogic  {
    //个人测试代码
    private  static  void annotationLogic() throws ClassNotFoundException {
        Class useAnnotationClass =Class.forName("test.annotations.lsm.TestMain");
        useAnnotationClass.getAnnotation(TestAnnotation.class);
        for (Method method:useAnnotationClass.getMethods()){
            TestAnnotation testAnnotation = (TestAnnotation)method.getAnnotation(TestAnnotation.class);
            if(testAnnotation!=null){
                System.out.println(" Method Name : " + method.getName());
                System.out.println(" value : " + testAnnotation.value());
                System.out.println(" --------------------------- ");
            }
        }
    }

}
