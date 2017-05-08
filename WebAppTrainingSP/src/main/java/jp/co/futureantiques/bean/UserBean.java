package jp.co.futureantiques.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@Data
@Component
@SessionScope
public class UserBean implements Serializable {
  private String id;
  private String name;
}
