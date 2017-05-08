package jp.co.futureantiques.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.futureantiques.entity.RestaurantArea;

@Repository
public interface RestaurantAreaRepository extends JpaRepository<RestaurantArea, Integer> {
}
