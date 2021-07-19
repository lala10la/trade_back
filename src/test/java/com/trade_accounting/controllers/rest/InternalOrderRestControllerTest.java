package com.trade_accounting.controllers.rest;

import com.google.gson.Gson;
import com.trade_accounting.models.dto.InternalOrderDto;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Pavel Andrusov
 * @since 19.07.2021
 */

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {"spring.config.location = src/test/resources/application-test.yml"})
@Sql(value = "/InternalOrder-before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@WithUserDetails(value = "karimogon@mail.ru")
@RequiredArgsConstructor
class InternalOrderRestControllerTest {

    @Autowired
    private InternalOrderRestController internalOrderRestController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testExistence() {
        assertNotNull(internalOrderRestController, "Internal Order Rest Controller is null");
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/api/internalorder"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(authenticated())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    void getById() throws Exception {
        String internalOrderDtoJson = new Gson().toJson(InternalOrderDto.builder()
                .id(1L)
                .isSent(false)
                .isPrint(false)
                .companyId(1L)
                .comment("Комментарий 1")
                .date("1234-12-12 12:34")
                .build());

        mockMvc.perform(get("/api/internalorder/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(authenticated())
                .andExpect(content().json(internalOrderDtoJson));
    }

    @Test
    void create() throws Exception {
        String internalOrderDtoJson = new Gson().toJson(InternalOrderDto.builder()
                .date("1234-12-12 12:34")
                .isSent(true)
                .isPrint(true)
                .companyId(4L)
                .comment("Комментарий 1")
                .internalOrderProductsIds(List.of(1L, 2L, 3L))
                .build()
        );

        mockMvc.perform(post("/api/internalorder")
                .contentType(MediaType.APPLICATION_JSON).content(internalOrderDtoJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(authenticated())
                .andExpect(content().json(internalOrderDtoJson));

        mockMvc.perform(get("/api/internalorder"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(authenticated())
                .andExpect(jsonPath("$", hasSize(4)));
    }

    @Test
    void update() throws Exception {
        String internalOrderDtoJson = new Gson().toJson(InternalOrderDto.builder()
                .id(3L)
                .date("1234-12-12 12:34")
                .isSent(false)
                .isPrint(true)
                .comment("Комментарий 3 _UPDATED_")
                .companyId(3L)
                .internalOrderProductsIds(List.of(1L, 2L, 3L))
                .build()
        );

        mockMvc.perform(put("/api/internalorder")
                .contentType(MediaType.APPLICATION_JSON).content(internalOrderDtoJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(authenticated())
                .andExpect(content().json(internalOrderDtoJson));
        mockMvc.perform(get("/api/internalorder"))
                .andDo(print());
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(delete("/api/internalorder/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(authenticated());
        mockMvc.perform(get("/api/internalorder"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(authenticated())
                .andExpect(jsonPath("$", hasSize(2)));
    }
}