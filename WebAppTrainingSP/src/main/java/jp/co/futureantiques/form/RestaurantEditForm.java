package jp.co.futureantiques.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class RestaurantEditForm {
  private int updateId = -1;

  @NotBlank
  @Size(max = 255)
  private String name;

  @NotBlank
  private String stars;

  private int areaId = -1;

  @Size(max = 255)
  private String comment;
}
