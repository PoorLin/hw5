package com.systex.hwspring.service;

import com.systex.hwspring.dao.UsersDao;
import com.systex.hwspring.model.user.LoginForm;
import com.systex.hwspring.model.user.Users;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;

import static com.systex.hwspring.util.ShaEncoding.parseSHA256;

@Service
public class UserService {

    @Autowired
    private UsersDao usersDao;


    public String register(Users users, BindingResult br){

        if(usersDao.existsByEmail(users.getEmail())){
            br.rejectValue("email","error.userForm","此電子信箱已存在");
            return "/user/register";
        }
        users.setPassword(parseSHA256(users.getPassword()));
        usersDao.save(users);
        return "redirect:/user/login";
    }

    public String login(LoginForm user, BindingResult br, HttpSession session){
        Optional<Users> optUser=usersDao.findByEmailAndPassword(user.getEmail(),parseSHA256(user.getPassword()));
        if(optUser.isPresent()){
            session.setAttribute("user",optUser.get());
            return "/index";
        }else {
            br.rejectValue("email","error.loginForm","帳號密碼錯誤");
            return "user/login";
        }
    }


}
