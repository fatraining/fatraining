package jp.co.futureantiques.controller.harasan;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.futureantiques.bean.UserBean;
import jp.co.futureantiques.entity.Restaurant;
import jp.co.futureantiques.form.RestaurantEditForm;
import jp.co.futureantiques.service.RestaurantAreaService;
import jp.co.futureantiques.service.RestaurantService;

/**
 * 飲食店編集画面コントローラー
 *
 * @author harasan
 */
@Controller
@RequestMapping(value="/restaurant")
public class RestaurantEditController {

  @Autowired
  RestaurantService restaurantService;
  @Autowired
  RestaurantAreaService restaurantAreaService;
  @Autowired
  UserBean userBean;

  @ModelAttribute("userBean")
  public UserBean setUpUserBean() {
    return this.userBean;
  }

  @ModelAttribute("areaMap")
  public Map<String, String> setUpAreaMap() {
    return restaurantAreaService.createAreaMap();
  }

  @RequestMapping(value="/edit", method=RequestMethod.GET)
  public String show(@ModelAttribute RestaurantEditForm form, @ModelAttribute("updateId") Optional<String> updateId, Model model) {
    if (updateId.isPresent()) {
      Restaurant r = restaurantService.find(Integer.valueOf(updateId.get()));
      form.setUpdateId(r.getId());
      form.setName(r.getName());
      form.setStars(String.valueOf(r.getStars()));
      form.setAreaId(r.getRestaurantAreaId());
      form.setComment(r.getComment());
    }
    return "harasan/restaurantEdit";
  }

  @RequestMapping(value="/edit", method=RequestMethod.POST)
  public String save(@ModelAttribute @Validated RestaurantEditForm form, BindingResult bindingResult, Model model) {
    if (form.getAreaId() == -1) {
      bindingResult.rejectValue("areaId", "common.field.required");
    }
    if (bindingResult.hasErrors()) {
      return "harasan/restaurantEdit";
    }
    restaurantService.saveAndFlush(convertToEntity(form));
    return "redirect:/restaurant";
  }

  private Restaurant convertToEntity(RestaurantEditForm form) {
    Restaurant r = null;
    if (form.getUpdateId() != -1) {
      r = restaurantService.find(form.getUpdateId());
      r.setUpdateUser(userBean.getId());
      r.setUpdateDate(new Timestamp(new Date().getTime()));
    } else {
      r = new Restaurant();
    }
    r.setName(form.getName());
    r.setRestaurantAreaId(form.getAreaId());
    r.setStars(Short.valueOf(form.getStars()).shortValue());
    r.setComment(form.getComment());
    r.setCreateUser(userBean.getId());
    r.setCreateDate(new Timestamp(new Date().getTime()));
    return r;
  }
}
