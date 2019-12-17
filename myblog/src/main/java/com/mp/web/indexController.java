package com.mp.web;

//import com.mp.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class indexController {

    @GetMapping("/")  //@PathVariable可以从请求中的到数据
    public String index(){
        //int i=8/0;
//        String blog=null;
//        if(blog==null){
//            throw   new NotFoundException("博客不存在");
//        }
        System.out.println("******index*******");
        return "index";
    }



}
