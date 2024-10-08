package com.systex.hwspring.model.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {


    @NotNull(message = "請輸入信箱")
    @Email(message = "請輸入有效信箱")
    private String email;

    @NotNull(message = "請輸入密碼")
    private String password;

}
