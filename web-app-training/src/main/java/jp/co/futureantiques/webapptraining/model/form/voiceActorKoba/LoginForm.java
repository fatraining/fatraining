package jp.co.futureantiques.webapptraining.model.form.voiceActorKoba;

import javax.validation.constraints.Size;

import lombok.Data;


@Data
public class LoginForm {

    // データの有効性を制約、Controllerで @Validated アノテーションと一緒に使ったらいい
    @Size(min = 6, max = 30, message = "login.error.invalid.username")
    private String username;

    @Size(min = 4, max = 30, message = "login.error.invalid.password")
    private String password;
}
