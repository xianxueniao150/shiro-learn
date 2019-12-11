package com.example.controller;

import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("name","黑马");
        return "test";
    }

    @RequestMapping("/add")
    public String add(Model model){
        return "/user/add";
    }

    @RequestMapping("/update")
    public String update(Model model){
        return "/user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        return "/login";
    }

    @RequestMapping("/Login")
    public String login(String name, String password,Model model){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        try {
            subject.login(token);
            return "redirect:/test";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","用户名不存在");
            return "login";

        }catch (IncorrectCredentialsException e) {
            model.addAttribute("msg","密码错误");
            return "login";

        }
    }

    @RequestMapping("/unAuth")
    public String noAuth(){
        return "/noAuth";
    }

}
