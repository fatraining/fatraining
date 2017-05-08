package jp.co.futureantiques.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * メニュー画面コントローラー
 *
 * @author harasan
 */
@Controller
@RequestMapping(value="/menu")
public class MenuController {

  /**
   * メニュー画面の表示を行うアクションメソッド
   *
   * @param model
   * @return
   */
  @RequestMapping(method=RequestMethod.GET)
  public String show(Model model) {
    return "menu";
  }

  /**
   * 飲食店検索画面へリダイレクトするアクションメソッド
   *
   * @param model
   * @return
   */
  @RequestMapping(params="gotoHarasan", method=RequestMethod.POST)
  public String harasan(Model model) {
    return "redirect:/restaurant";
  }
}
