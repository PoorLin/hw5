package com.systex.hwspring.controller;


import com.systex.hwspring.model.lottery.LotteryForm;
import com.systex.hwspring.model.user.LoginForm;
import com.systex.hwspring.service.LotteryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/lottery")
public class LotteryController  {

    @Autowired
    private LotteryService lotteryService;

    @GetMapping("/start")
    public String startGame(Model model){
        model.addAttribute("lotteryForm",new LotteryForm());
        return "lottery/main";
    }
    @PostMapping("/generateLottery")
    public String generateLottery(@Valid @ModelAttribute("lotteryForm") LotteryForm lotteryForm, BindingResult br, HttpServletRequest request) throws ServletException, IOException {
        if(br.hasErrors()){
            return "lottery/main";
        }
         return lotteryService.generateLottery(request,lotteryForm,br);
    }
}