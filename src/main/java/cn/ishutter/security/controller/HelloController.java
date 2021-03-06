package cn.ishutter.security.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by chenyinpo on 2017/6/20.
 */

@Controller
public class HelloController {

    @RequestMapping(value = {"/","/home"},method = RequestMethod.GET)
    public String homePage(ModelMap model){
        model.addAttribute("greeting","Welcome to ishutter.cn");
        return "welcome";
    }

    @RequestMapping(value = {"/admin"},method = RequestMethod.GET)
    public String adminPage(ModelMap model){
        model.addAttribute("user",getPrincipal());
        return "admin";
    }
    @RequestMapping(value = {"/login"},method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = {"/dba"},method = RequestMethod.GET)
    public String dbPage(ModelMap model){
        model.addAttribute("user",getPrincipal());
        return "dba";
    }

    @RequestMapping(value = {"/logout"},method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null){
            new SecurityContextLogoutHandler().logout(request,response,auth);
        }
        return "redirect:/login?logout";
    }

    @RequestMapping(value = "/Access_Denied",method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model){
        model.addAttribute("user",getPrincipal());
        return "accessDenied";
    }


    private String getPrincipal() {

        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            userName = ((UserDetails)principal).getUsername();
        } else {
          userName = principal.toString();
        }
        return userName;
    }

}
