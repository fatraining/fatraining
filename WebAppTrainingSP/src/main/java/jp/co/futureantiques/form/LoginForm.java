package jp.co.futureantiques.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginForm {

  @NotBlank
  @Size(max = 10)
  private String id;

  @NotBlank
  @Size(max = 10)
  private String password;
}
