package com.systex.hwspring.controller;



import com.systex.hwspring.model.guess.GuessForm;
import com.systex.hwspring.model.user.GreateUsersForm;
import com.systex.hwspring.service.GameService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("start")
    public String startGame(Model model){
        model.addAttribute("guessForm",new GuessForm());
        return "game/guess";
    }
    @PostMapping("guess")
    public String guess(@Valid @ModelAttribute("guessForm") GuessForm guessForm, BindingResult br, HttpServletRequest request, HttpServletResponse response){
        if(br.hasErrors()){
            return "game/guess";
        }
        return gameService.guess(request,guessForm.getGuessNumber());
    }

}