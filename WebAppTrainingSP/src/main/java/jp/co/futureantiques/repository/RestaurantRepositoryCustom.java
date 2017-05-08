package jp.co.futureantiques.repository;

import java.util.List;

import jp.co.futureantiques.entity.Restaurant;
import jp.co.futureantiques.form.RestaurantSearchForm;

public interface RestaurantRepositoryCustom {
  public List<Restaurant> findListByCondition(RestaurantSearchForm form);
}
