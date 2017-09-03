package springframeboot.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;



@Component
@ConfigurationProperties(prefix = "xiaowu")
public class xiaowu {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "xiaowu{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
