package com.mp.web.admin;

import com.mp.po.User;
import com.mp.service.UserService;
import com.mp.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

//这个admin包主要用于存放后台管理的控制器
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String loginpage(){
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes){
        User user = userService.checkUser(username,password);
        if(user!=null){
            //不能把密码传到前端
            user.setPassword(null);
            //把结果写入session
            session.setAttribute("user",user);
            return "admin/index";
        }
        else{
            //通过重定向到login页面下，走的是loginpage这个路径
            attributes.addFlashAttribute("message","用户名密码错误");
            return "redirect:/admin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
