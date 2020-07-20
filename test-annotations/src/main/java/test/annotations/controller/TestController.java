package test.annotations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.annotations.annotation.Log;
import test.annotations.entity.Person;

@RestController
public class TestController {
    @Autowired
    Person person;
    @Log(title = "测试模块")
   @RequestMapping("/test")
   public  String  test(String name){
       return  "Hello"+name+"附加消息:"+person.getName();
   }
}
