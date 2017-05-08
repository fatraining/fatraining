package jp.co.futureantiques.controller.harasan;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.futureantiques.bean.UserBean;
import jp.co.futureantiques.entity.Restaurant;
import jp.co.futureantiques.form.RestaurantSearchForm;
import jp.co.futureantiques.service.RestaurantAreaService;
import jp.co.futureantiques.service.RestaurantService;

/**
 * 飲食店検索画面コントローラー
 *
 * @author harasan
 */
@Controller
@RequestMapping(value="/restaurant")
public class RestaurantSearchController {

  @Autowired
  RestaurantService restaurantService;
  @Autowired
  RestaurantAreaService restaurantAreaService;
  @Autowired
  UserBean userBean;

  /**
   * UserBeanをモデルに自動でインジェクションする
   * @return
   */
  @ModelAttribute("userBean")
  public UserBean setUpUserBean() {
    return this.userBean;
  }

  /**
   * areaMapをモデルに自動でインジェクションする
   * @return
   */
  @ModelAttribute("areaMap")
  public Map<String, String> setUpAreaMap() {
    return restaurantAreaService.createAreaMap();
  }

  /**
   * 飲食店検索画面の表示を行うアクションメソッド
   *
   * @param form
   * @param model
   * @return
   */
  @RequestMapping(value="", method=RequestMethod.GET)
  public String show(@ModelAttribute RestaurantSearchForm form, Model model) {
    return "harasan/restaurantSearch";
  }

  /**
   * リセットボタン押下時アクションメソッド
   *
   * @param model
   * @return
   */
  @RequestMapping(value="", params="reset", method=RequestMethod.POST)
  public String reset(Model model) {
    model.addAttribute(new RestaurantSearchForm());
    return "harasan/restaurantSearch";
  }

  /**
   * 検索ボタン押下時アクションメソッド
   *
   * @param form
   * @param model
   * @return
   */
  @RequestMapping(value="", params="search", method=RequestMethod.POST)
  public String search(@ModelAttribute RestaurantSearchForm form, Model model) {
    List<Restaurant> restaurantList = restaurantService.findListByCondition(form);
    model.addAttribute("resultList", restaurantList);
    return "harasan/restaurantSearch";
  }

  /**
   * 追加ボタン押下時アクションメソッド
   *
   * @param form
   * @param model
   * @param attributes
   * @return
   */
  @RequestMapping(value="", params="insert", method=RequestMethod.POST)
  public String insert(@ModelAttribute RestaurantSearchForm form, Model model, RedirectAttributes attributes) {
    return "redirect:/restaurant/edit";
  }

  /**
   * 更新ボタン押下時アクションメソッド
   *
   * @param form
   * @param model
   * @param attributes
   * @return
   */
  @RequestMapping(value="", params="update", method=RequestMethod.POST)
  public String update(@ModelAttribute RestaurantSearchForm form, Model model, RedirectAttributes attributes) {
    attributes.addFlashAttribute("updateId", form.getUpdateId());
    return "redirect:/restaurant/edit";
  }

  /**
   * 削除ボタン押下時アクションメソッド
   *
   * @param form
   * @param model
   * @param attributes
   * @return
   */
  @RequestMapping(value="", params="delete", method=RequestMethod.POST)
  public String delete(@ModelAttribute RestaurantSearchForm form, BindingResult result, Model model, RedirectAttributes attributes) {
    if (form.getDeleteId() == null || form.getDeleteId().length < 1) {
      // 検索結果が消えないように再建策する
      List<Restaurant> restaurantList = restaurantService.findListByCondition(form);
      model.addAttribute("resultList", restaurantList);
      result.reject("common.delete.required");
      return "harasan/restaurantSearch";
    }
    attributes.addFlashAttribute("deleteId", form.getDeleteId());
    return "redirect:/restaurant/delete";
  }
}
