package ru.vlapin.demo.restcontractlastdemo.config;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.vlapin.demo.restcontractlastdemo.dao.CatDao;
import ru.vlapin.demo.restcontractlastdemo.model.AnnotationBasedSetterPropertiesPlaceholderExample;
import ru.vlapin.demo.restcontractlastdemo.model.Cat;

@Component
@RequiredArgsConstructor
public class DbIniter implements CommandLineRunner {

  CatDao catDao;

  AnnotationBasedSetterPropertiesPlaceholderExample annotationBasedSetterPropertiesPlaceholderExampleImpl;

  @Override
  public void run(String... args) throws Exception {
    Arrays.stream("Мурзик, Барсик, Матроскин".split(", "))
        .map(Cat::new)
        .forEach(catDao::save);

    System.out.println("annotationBasedSetterPropertiesPlaceholderExample.getHost() = "
                           + annotationBasedSetterPropertiesPlaceholderExampleImpl.getHost());

    System.out.println("annotationBasedSetterPropertiesPlaceholderExample.getPort() = "
                           + annotationBasedSetterPropertiesPlaceholderExampleImpl.getPort());
  }
}
