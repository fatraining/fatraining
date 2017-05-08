package jp.co.futureantiques.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.util.StringUtils;

import jp.co.futureantiques.entity.Restaurant;
import jp.co.futureantiques.form.RestaurantSearchForm;

public class RestaurantRepositoryImpl implements RestaurantRepositoryCustom {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<Restaurant> findListByCondition(RestaurantSearchForm form) {
    StringBuilder sb = new StringBuilder();
    sb.append("select distinct r ").
    append("from Restaurant r ").
    append("left join fetch r.restaurantArea ");
    if (!StringUtils.isEmpty(form.getName()) ||
        !StringUtils.isEmpty(form.getStars()) ||
        form.getAreaId() != -1) {
      sb.append("where ");
    }
    int length = sb.length();
    if (!StringUtils.isEmpty(form.getName())) {
      sb.append("r.name like :name ");
    }
    if (!StringUtils.isEmpty(form.getStars())) {
      appendQuery(sb, length, " r.stars >= :stars ");
    }
    if (form.getAreaId() != -1) {
      appendQuery(sb, length, " r.restaurantAreaId = :restaurantAreaId ");
    }
    sb.append("order by r.id asc");
    TypedQuery<Restaurant> query = entityManager.createQuery(sb.toString(), Restaurant.class);
    if (!StringUtils.isEmpty(form.getName())) {
      query.setParameter("name", "%" + form.getName() + "%");
    }
    if (!StringUtils.isEmpty(form.getStars())) {
      query.setParameter("stars", Short.valueOf(form.getStars()).shortValue());
    }
    if (form.getAreaId() != -1) {
      query.setParameter("restaurantAreaId", form.getAreaId());
    }
    return query.getResultList();
  }

  private StringBuilder appendQuery(StringBuilder sb, int length, String query) {
    if (length < sb.length()) {
      sb.append("and ");
    }
    sb.append(query);
    return sb;
  }
}
