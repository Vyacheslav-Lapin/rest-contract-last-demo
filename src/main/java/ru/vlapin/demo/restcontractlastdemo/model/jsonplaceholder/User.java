package ru.vlapin.demo.restcontractlastdemo.model.jsonplaceholder;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder(toBuilder = true)
@SuppressWarnings("ClassCanBeRecord")
public class User {

  Integer id;
  String name;

  @JsonProperty("username")
  String userName;

  String email; //todo 06.07.2021: Validate by email regexp

  Address address;

  String phone; //todo 06.07.2021: Validate by telephone regexp

  @JsonProperty("website")
  String webSite;

  Company company;
}
