package ru.vlapin.demo.restcontractlastdemo.integration;

import java.util.List;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.vlapin.demo.restcontractlastdemo.model.jsonplaceholder.User;

@FeignClient(
    name = "UserClient",
    url = UserClient.TYPICODE_COM,
    path = "users")
public interface UserClient {

  String TYPICODE_COM = "https://jsonplaceholder.typicode.com";

  @NotNull
  @GetMapping("{id}")
  @Contract(pure = true)
  ResponseEntity<@NotNull User> getById(@PathVariable @NotNull Integer id);

  @NotNull
  @GetMapping
  @Contract(pure = true)
  ResponseEntity<@NotNull List<@NotNull User>> get();
}
