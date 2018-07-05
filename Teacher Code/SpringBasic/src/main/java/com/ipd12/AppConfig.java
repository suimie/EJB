package com.ipd12;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="test")
public class AppConfig {
  // @Bean
   public Circle getCircle() {
      return new Circle();
   }
   
   @Bean
   public Triangle getTriangle() {
      return new Triangle();
   }
}
