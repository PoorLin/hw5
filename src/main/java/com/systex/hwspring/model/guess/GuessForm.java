package com.systex.hwspring.model.guess;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class GuessForm {
    @Min(value = 1, message = "最小值为1")
    @Max(value = 10, message = "最大值为10")
    @NotNull(message = "請輸入數字")
    private Integer guessNumber;

    public GuessForm() {
    }
}
