package ru.vlapin.demo.restcontractlastdemo.model.jsonplaceholder;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder(toBuilder = true)
@SuppressWarnings("ClassCanBeRecord")
public class Company {

  String name;

  String catchPhrase;

  @JsonProperty("bs")
  String business;
}
