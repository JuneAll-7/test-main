package test.annotations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import sun.net.www.protocol.jar.JarURLConnection;
import test.annotations.annotation.MyAnnotation;
import test.annotations.annotation.TestAnnotation;
import test.annotations.config.ApplicationContextProvider;
import test.annotations.entity.Person;
import test.annotations.lsm.TestMain;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@SpringBootTest
class TestAnnotationsApplicationTests {
 @Autowired
 ApplicationContext applicationContext;
    @Test
    void contextLoads() throws ClassNotFoundException {
//     Class c=Class.forName("test.annotations.lsm.TestMain");
//        System.out.println(c.getDeclaredFields().length);
//     for(Field field:c.getDeclaredFields()){
//         System.out.println(field.getName());
//     }
   TestMain testMain= (TestMain) ApplicationContextProvider.getBean("adc");
        System.out.println(testMain.getName());
    }
    @Test
    @MyAnnotation(name = "狗东西",id = 0,schools = {"北京第一学院"})
    void  t2(){

    }
    @Test
    void  t3() throws ClassNotFoundException {
        Class<?>  c=Class.forName("test.annotations.entity.User");
        Class<?>  c1=Class.forName("test.annotations.entity.User");
        Class<?>  c2=Class.forName("test.annotations.entity.User");
        Class<?>  c3=Class.forName("test.annotations.entity.User");
        System.out.println(c1.hashCode()==c2.hashCode());
        System.out.println(c.getFields());
    }
    @Autowired
   private Person person;
  @Test
  public   void  t4(){
      System.out.println(person.getName());
    }


}
