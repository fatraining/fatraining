package jp.co.futureantiques.controller.harasan;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jp.co.futureantiques.bean.UserBean;
import jp.co.futureantiques.entity.Restaurant;
import jp.co.futureantiques.form.RestaurantDeleteForm;
import jp.co.futureantiques.service.RestaurantService;

@Controller
@RequestMapping(value="/restaurant")
@SessionAttributes(value="restaurantDeleteForm")
public class RestaurantDeleteController {

  @Autowired
  RestaurantService restaurantService;
  @Autowired
  UserBean userBean;

  @ModelAttribute("userBean")
  public UserBean setUpUserBean() {
    return this.userBean;
  }

  @ModelAttribute("restaurantDeleteForm")
  RestaurantDeleteForm restaurantDeleteForm() {
      return new RestaurantDeleteForm();
  }

  @RequestMapping(value="/delete", method=RequestMethod.GET)
  public String show(RestaurantDeleteForm form, @ModelAttribute("deleteId") String[] deleteId, Model model) {
    form.setDeleteId(deleteId);
    List<Integer> idList = Arrays.stream(deleteId).map(s -> Integer.valueOf(s)).collect(Collectors.toList());
    List<Restaurant> restaurantList = restaurantService.findAll(idList);
    model.addAttribute("resultList", restaurantList);
    return "harasan/restaurantDelete";
  }

  @RequestMapping(value="/delete", method=RequestMethod.POST)
  public String save(RestaurantDeleteForm form, Model model, SessionStatus sessionStatus) {
    for (String id : form.getDeleteId()) {
      restaurantService.delete(Integer.valueOf(id));
    }
    sessionStatus.setComplete();
    return "redirect:/restaurant";
  }

}
