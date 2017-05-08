package jp.co.futureantiques.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.futureantiques.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>, RestaurantRepositoryCustom {

//  @Query(
//      "select distinct r "
//      + "from Restaurant r "
//      + "left join fetch r.restaurantArea "
//      + "where r.name like %:name% "
//      + "and r.stars = :stars "
//      + "and r.restaurantAreaId = :restaurantAreaId "
//      + "order by r.id asc"
//  )
//  public List<Restaurant> findListByCondition(@Param("name") String name, @Param("stars") Integer stars, @Param("restaurantAreaId") Integer restaurantAreaId);
}
