package jp.co.futureantiques.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.futureantiques.entity.Restaurant;
import jp.co.futureantiques.form.RestaurantSearchForm;
import jp.co.futureantiques.repository.RestaurantRepository;

@Service
@Transactional
public class RestaurantService {

  @Autowired
  RestaurantRepository restaurantRepository;

  public List<Restaurant> findAll() {
    return restaurantRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
  }

  public List<Restaurant> findAll(List<Integer> ids) {
    return restaurantRepository.findAll(ids);
  }

  public Restaurant save(Restaurant restaurant) {
    return restaurantRepository.save(restaurant);
  }

  public Restaurant saveAndFlush(Restaurant restaurant) {
    return restaurantRepository.saveAndFlush(restaurant);
  }

  public void delete(int id) {
    restaurantRepository.delete(id);
  }

  public Restaurant find(int id) {
    return restaurantRepository.findOne(id);
  }

  public List<Restaurant> findListByCondition(RestaurantSearchForm form) {
//    Integer _stars = null;
//    Integer _areaId = null;
//    if (form.getStars() != null && form.getStars().length() != 0) {
//      _stars = Integer.valueOf(form.getStars());
//    }
//    if (form.getAreaId() != -1) {
//      _areaId = Integer.valueOf(form.getAreaId());
//    }
//    return restaurantRepository.findListByCondition(form.getName(), _stars, _areaId);
    return restaurantRepository.findListByCondition(form);
  }

}
