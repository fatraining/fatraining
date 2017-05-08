package jp.co.futureantiques.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.futureantiques.bean.UserBean;
import jp.co.futureantiques.form.LoginForm;

/**
 * ログイン画面コントローラー
 *
 * @author harasan
 */
@Controller
public class LoginController {

  @Autowired
  UserBean userBean;

  /**
   * ログイン画面を表示するアクションメソッド
   *
   * @param form
   * @param model
   * @return
   */
  @RequestMapping(value="/", method=RequestMethod.GET)
  public String show(@ModelAttribute LoginForm form, Model model) {
    form.setId("Spring");
    form.setPassword("pass");
    return "login";
  }

  /**
   * 簡略化したユーザの認証を行うアクションメソッド
   * 正しいIDとパスワードが入力された場合、メニュー画面へリダイレクトを行う
   *
   * @param form
   * @param bindingResult
   * @param model
   * @return
   */
  @RequestMapping(value="/login", method=RequestMethod.POST)
  public String login(@ModelAttribute @Validated LoginForm form, BindingResult bindingResult, Model model) {
    if (!bindingResult.hasFieldErrors("id") && !form.getId().equals("Spring")) {
      bindingResult.rejectValue("id", "login.invalid.id");
    }
    if (!bindingResult.hasFieldErrors("password") && !form.getPassword().equals("pass")) {
      bindingResult.rejectValue("password", "login.invalid.password");
    }
    if (bindingResult.hasErrors()) {
      return "login";
    }
    userBean.setId(form.getId());
    userBean.setName("認証済みユーザ");
    return "redirect:/menu";
  }
}
