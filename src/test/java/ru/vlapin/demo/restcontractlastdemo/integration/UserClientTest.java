package ru.vlapin.demo.restcontractlastdemo.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import ru.vlapin.demo.restcontractlastdemo.model.jsonplaceholder.Address;
import ru.vlapin.demo.restcontractlastdemo.model.jsonplaceholder.Geo;
import ru.vlapin.demo.restcontractlastdemo.model.jsonplaceholder.User;

@SpringBootTest
@SuppressWarnings("ClassCanBeRecord")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class UserClientTest {

  UserClient userClient;

  @Test
  @SneakyThrows
  @DisplayName("Feign client all works correctly")
  void feignClientWorksCorrectlyTest() {
    assertThat(userClient.get()).isNotNull()
        .matches(listResponseEntity -> listResponseEntity.getStatusCode().is2xxSuccessful())
        .matches(listResponseEntity -> listResponseEntity.getHeaders().getContentType().isCompatibleWith(APPLICATION_JSON))
        .extracting(ResponseEntity::getBody)
        .asList()
        .hasSize(10);
  }

  @Test
  @SneakyThrows
  @DisplayName("Feign client pointed works correctly")
  void feignClientPointedWorksCorrectlyTest() {
    assertThat(userClient.getById(1)).isNotNull()
        .matches(listResponseEntity -> listResponseEntity.getStatusCode().is2xxSuccessful())
        .matches(listResponseEntity -> listResponseEntity.getHeaders().getContentType().isCompatibleWith(APPLICATION_JSON))
        .extracting(ResponseEntity::getBody)
        .extracting(User::getAddress)
        .extracting(Address::getGeo)
        .extracting(Geo::getLatitude, Geo::getLongitude)
        .contains(-37.3159, 81.1496);
  }
}
