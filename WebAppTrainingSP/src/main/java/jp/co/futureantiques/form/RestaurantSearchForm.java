package jp.co.futureantiques.form;

import lombok.Data;

@Data
public class RestaurantSearchForm {
  private String name;
  private String stars;
  private int areaId = -1;
  private String updateId;
  private String[] deleteId;
}
