package com.systex.hwspring.model.lottery;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@AllArgsConstructor
public class LotteryForm {
    @Min(value = 1, message = "最小值为1")
    @NotNull(message = "請輸入產生的組數")
    private Integer lotteryCount;

    @NotNull(message = "請輸入要排除的數字")
    private String excludedNumbers;

    public LotteryForm() {
    }
}
