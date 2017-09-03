package springframeboot.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springframeboot.dao.UserRepostory;
import springframeboot.entity.User;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepostory userRepostory;


    @RequestMapping("/users")
    public List<User> userList(){

       for(User u : userRepostory.findAll()){
           System.out.println(u.getName());
       }
       return userRepostory.findAll();
    }


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public void save(){
            User u = new User();
            u.setName("测试");
            u.setAge(100);
            userRepostory.save(u);
    }
}
