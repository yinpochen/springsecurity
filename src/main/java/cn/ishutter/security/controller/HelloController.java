package cn.ishutter.security.controller;


import cn.ishutter.security.model.User;
import cn.ishutter.security.model.UserProfile;
import cn.ishutter.security.service.UserProfileService;
import cn.ishutter.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;


/**
 * Created by chenyinpo on 2017/6/20.
 */

@Controller
public class HelloController {

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    UserService userService;
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

    @RequestMapping(value = "/newUser",method = RequestMethod.GET)
    public String newRegistration(ModelMap model){
        User user = new User();
        model.addAttribute("user",user);

        return "newuser";
    }
    @RequestMapping(value = "/newUser",method = RequestMethod.POST)
    public String saveRegistration(@Valid User user, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            System.out.println("error");
            return "newuser";
        }
        userService.save(user);
        model.addAttribute("success","User "+user.getFirstName() + " has bean registeried successfully");
        return "regsuccess";

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

    @ModelAttribute("userroles")
    public List<UserProfile> initalizeProfiles(){
        List<UserProfile> userProfiles = userProfileService.findAll();
        return userProfiles;
    }

}
