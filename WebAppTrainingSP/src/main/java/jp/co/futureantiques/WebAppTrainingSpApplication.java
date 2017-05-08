package jp.co.futureantiques;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class WebAppTrainingSpApplication extends WebMvcConfigurerAdapter {

  public static void main(String[] args) {
    SpringApplication.run(WebAppTrainingSpApplication.class, args);
  }
}
