package com.systex.hwspring.controller;

import com.systex.hwspring.model.user.GreateUsersForm;
import com.systex.hwspring.model.user.LoginForm;
import com.systex.hwspring.model.user.Users;
import com.systex.hwspring.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/user/login")
    public String loginPage(Model model,HttpSession httpSession){
        Users user= (Users)httpSession.getAttribute("user");
        //若已登入
        if(user !=null){
            return "redirect:/index";
        }

        model.addAttribute("loginForm", new LoginForm());
        return "/user/login";
    }

    // 非Ajax
//    @PostMapping("/user/login")
//    public String login(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult br, HttpSession session){
//        if(br.hasErrors()){
//            return "user/login";
//        }
//        return userService.login(loginForm,br,session);
//    }
    // Ajax
    @PostMapping("/user/login")
    public String loginAjax(@Valid @RequestBody LoginForm loginForm, BindingResult br, HttpSession session){
        System.out.println(loginForm);
        if(br.hasErrors()){
            return "user/login";
        }
        return userService.login(loginForm,br,session);
    }
    @GetMapping("/user/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("userForm", new GreateUsersForm());
        return "user/register";
    }


    @PostMapping("/user/addUser")
    public String register( @Valid @ModelAttribute("userForm") GreateUsersForm userForm, BindingResult br){
if(br.hasErrors()){
    return "user/register";
}

        Users users = Users.builder()
                .gender(userForm.getGender())
                .password(userForm.getPassword1())
                .name(userForm.getName())
                .email(userForm.getEmail())
                .build();
       return userService.register(users,br);
    }

    @GetMapping("/user/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/user/login";
    }


}