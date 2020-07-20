package test.annotations.lsm;

import org.springframework.stereotype.Component;
import test.annotations.annotation.TestAnnotation;
@Component(value = "adc")
public class TestMain {

    public void testMethod(){
        //do something here
    }
    private    String id;
    private    String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
