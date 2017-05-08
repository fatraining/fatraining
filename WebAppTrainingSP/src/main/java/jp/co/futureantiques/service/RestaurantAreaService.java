package jp.co.futureantiques.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.futureantiques.entity.RestaurantArea;
import jp.co.futureantiques.repository.RestaurantAreaRepository;

@Service
@Transactional
public class RestaurantAreaService {

  @Autowired
  RestaurantAreaRepository restaurantAreaRepository;

  public List<RestaurantArea> findAll() {
    return restaurantAreaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
  }

  public RestaurantArea save(RestaurantArea restaurantArea) {
    return restaurantAreaRepository.save(restaurantArea);
  }

  public void delete(int id) {
    restaurantAreaRepository.delete(id);
  }

  public RestaurantArea find(int id) {
    return restaurantAreaRepository.findOne(id);
  }

  /**
   * DBから取得したエリア情報を元に
   * プルダウン用エリアマップを作成してセットする
   */
  public Map<String, String> createAreaMap() {
    Map<String, String> areaMap = new LinkedHashMap<String, String>();
    // エリア未選択時用
    areaMap.put("-1", "エリアを選択する");
    areaMap.putAll(
        this.findAll().stream().collect(
          () -> new LinkedHashMap<String, String>(),
          (map, area) -> map.put(String.valueOf(area.getId()), area.getName()),
          (map, area) -> map.putAll(map)
        )
    );
    return areaMap;
  }

}
