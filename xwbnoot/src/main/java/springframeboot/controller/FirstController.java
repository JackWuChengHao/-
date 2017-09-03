package springframeboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

    @Autowired
    private xiaowu xw;

    public void setXw(xiaowu xw) {
        this.xw = xw;
    }

    //    @Value("${xiaowuname}")
//    private String name;
//
//    @Value("${xiaowu}")
//    private String xiaowu;

    @RequestMapping(value = {"/hello/{id}","/hello1"},method = RequestMethod.POST)

    public String hello(@PathVariable("id") Integer id,@RequestParam(value = "name" ,defaultValue = "-"/*   required = false*/) String name){
        System.out.println(id);
        System.out.println(name);
        return "zifuchuan";
    }
}
