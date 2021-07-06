package ru.vlapin.demo.restcontractlastdemo;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import ru.vlapin.demo.restcontractlastdemo.model.JavaConfigBasedSetterPropertiesPlaceholderExample;

@SpringBootApplication
@ConfigurationPropertiesScan
@ComponentScan(includeFilters = @ComponentScan.Filter(Aspect.class))
public class RestContractLastDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(RestContractLastDemoApplication.class, args);
  }

  @Bean
  @ConfigurationProperties("my-properties2")
  JavaConfigBasedSetterPropertiesPlaceholderExample mySetterProperties2() {
    return new JavaConfigBasedSetterPropertiesPlaceholderExample();
  }
}
