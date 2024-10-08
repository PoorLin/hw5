package com.systex.hwspring.service;

import com.systex.hwspring.model.guess.GuessGame;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    public String guess(HttpServletRequest request,Integer guessNumber)  {

        HttpSession httpSession =request.getSession();
        GuessGame guessGame=(GuessGame)httpSession.getAttribute("guessGame");
        if(guessGame == null){
            guessGame = new GuessGame(10, ((int) (Math.random() * 10) + 1));
        }
        boolean isCorr= guessGame.guess(guessNumber);
        httpSession.setAttribute("guessGame",guessGame);

        if(isCorr){  //猜對
            return  "game/youWin";
        }else {      //猜錯
            if(guessGame.getRemains() == 0){
                                              // 次數用完
                httpSession.setAttribute("guessGame",null);
                return "game/youLose";
            }else {                           // 次數還沒用完
                return "game/guess";
            }
        }


    }
}
