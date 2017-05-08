package jp.co.futureantiques.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import lombok.Data;

/**
 * restaurant_areaテーブルと対応するモデル
 *
 * @author harasan
 */
@Data
@Entity
@Table(name = "restaurant_area")
public class RestaurantArea {

  @Id
  @GeneratedValue
  private int id;

  private String name;

  @Column(name = "create_date")
  private Timestamp createDate;

  @Column(name = "create_user")
  private String createUser;

  @Column(name = "update_date")
  private Timestamp updateDate;

  @Column(name = "update_user")
  private String updateUser;

  @Version
  @Column(name = "version")
  private int version;

  @Transient
  @OneToMany(targetEntity=Restaurant.class, mappedBy="restaurant_area")
  @JoinColumn(name="id", referencedColumnName="restaurant_area_id")
  private List<Restaurant> restaurantList;

}
