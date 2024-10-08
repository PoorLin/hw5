package com.systex.hwspring.service;

import com.systex.hwspring.model.lottery.LotteryForm;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.io.IOException;
import java.util.*;

@Service
public class LotteryService {





    public String generateLottery(HttpServletRequest request, LotteryForm lotteryForm, BindingResult br) throws IOException, ServletException {

        String[] excludedNumbersArr;
        LinkedList<Integer> excludedNumberList = new LinkedList<>();
        try{
            excludedNumbersArr = lotteryForm.getExcludedNumbers().split(" ");
            for(String nowNumber:excludedNumbersArr){
                excludedNumberList.add(Integer.valueOf(nowNumber));
            }
        }catch (Exception e){
            br.rejectValue("excludedNumbers","error.lotteryForm","請輸入正確的格式");
            return "lottery/main";
        }


        ArrayList<Integer>[]  res ;

        res=getNumbers(lotteryForm.getLotteryCount(),excludedNumberList);
        request.setAttribute("res",res);
        return "lottery/result";
    }

    public static ArrayList<Integer>[] getNumbers(int groups, LinkedList<Integer> excludes){
        ArrayList<Integer>[] res = new ArrayList[groups];
        for(int resIndex=0;resIndex<groups;resIndex++){
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int newNum = 1; newNum < 7; newNum++) {
                int randanNum = ((int) (Math.random() * 49) + 1);
                if (excludes.contains(randanNum)) {
                    newNum--;
                } else {
                    if (arrayList.contains(randanNum)) {
                        newNum--;
                    } else {
                        arrayList.add(randanNum);
                    }
                }
            }
            Collections.sort(arrayList);
            res[resIndex] = arrayList;

        }

        return res;
    }

}
