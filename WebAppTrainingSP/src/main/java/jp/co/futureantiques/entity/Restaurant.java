package jp.co.futureantiques.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Restaurant {

  @Id
  @GeneratedValue
  private int id;

  private String name;

  private short stars;

  @Size(max = 255)
  private String comment;

  @Column(name = "restaurant_area_id")
  private int restaurantAreaId;

  @Column(name = "create_date")
  private Timestamp createDate;

  @Column(name = "create_user")
  private String createUser;

  @Column(name = "update_date")
  private Timestamp updateDate;

  @Column(name = "update_user")
  private String updateUser;

  @Version
  private int version;

  @ManyToOne(targetEntity=RestaurantArea.class)
  @JoinColumn(name="restaurant_area_id", referencedColumnName="id", insertable=false, updatable=false)
  private RestaurantArea restaurantArea;
}
