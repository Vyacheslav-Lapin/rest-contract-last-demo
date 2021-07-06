package ru.vlapin.demo.restcontractlastdemo.dao;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(authorities = "ADMIN")
@SuppressWarnings("ClassCanBeRecord")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class CatDaoTest {

  MockMvc mockMvc;

  @Test
  @SneakyThrows
  @DisplayName("Rest service works correctly")
  void restServiceWorksCorrectlyTest() {
    mockMvc.perform(get("/cats"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(HAL_JSON_VALUE))
        .andExpect(jsonPath("$.page.totalElements").isNumber())
        .andExpect(jsonPath("$.page.totalElements").value(3))
    //        .andExpect(mvcResult -> assertEquals(3,
    //            parse(mvcResult.getResponse().getContentAsString())
    //                .<Integer>read("$.page.totalElements").intValue()))
    ;
  }
}
