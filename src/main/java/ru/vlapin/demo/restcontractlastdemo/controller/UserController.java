package ru.vlapin.demo.restcontractlastdemo.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlapin.demo.restcontractlastdemo.integration.UserClient;
import ru.vlapin.demo.restcontractlastdemo.model.jsonplaceholder.User;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

  UserClient userClient;

  @NotNull
  @SneakyThrows
  @Contract(pure = true)
  @GetMapping("{id}")
  ResponseEntity<@NotNull User> getById(@PathVariable @NotNull Integer id) {
    val byId = userClient.getById(id);

    if (!byId.getStatusCode().is2xxSuccessful())
      return ResponseEntity.badRequest().build();

    return ResponseEntity.ok(byId.getBody());
  }

  @NotNull
  @Contract(pure = true)
  @GetMapping
  ResponseEntity<@NotNull List<User>> get() {
    val entity = userClient.get();

    if (!entity.getStatusCode().is2xxSuccessful())
      return ResponseEntity.badRequest().build();

    return ResponseEntity.ok(entity.getBody());
  }
}
