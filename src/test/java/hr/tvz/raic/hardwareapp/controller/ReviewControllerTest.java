package hr.tvz.raic.hardwareapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllReviews() throws Exception {
        mockMvc.perform(
            get("/review")
                .with(user("Admin")
                    .password("admin")
                    .roles("ADMIN")
            )
            .with(csrf())
            .accept(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(content().encoding(StandardCharsets.UTF_8))
        .andExpect(jsonPath("$", hasSize(6)));
    }

    @Test
    void getReviewsByHardwareCode() throws Exception {
        String hardwareCode = "1002";

        mockMvc.perform(
            get("/review")
                .with(user("Admin")
                    .password("admin")
                    .roles("ADMIN")
            )
            .param("hardwareCode", hardwareCode)
            .with(csrf())
            .accept(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(content().encoding(StandardCharsets.UTF_8))
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].title").value("Average"))
        .andExpect(jsonPath("$[0].text").value("Average, expected better."))
        .andExpect(jsonPath("$[0].rating").value(3));
    }

    @Test
    void getReview() throws Exception {
        String reviewTitle = "Ok";

        mockMvc.perform(
            get("/review/byText/" + reviewTitle)
                .with(user("Admin")
                    .password("admin")
                    .roles("ADMIN")
            )
            .with(csrf())
            .accept(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(content().encoding(StandardCharsets.UTF_8))
        .andExpect(jsonPath("$.title").value(reviewTitle));
    }
}