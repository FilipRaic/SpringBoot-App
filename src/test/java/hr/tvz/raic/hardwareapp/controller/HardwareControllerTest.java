package hr.tvz.raic.hardwareapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tvz.raic.hardwareapp.command.HardwareCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class HardwareControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllHardwareTest() throws Exception {
        mockMvc.perform(
            get("/hardware")
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
        .andExpect(jsonPath("$", hasSize(4)));
    }

    @Test
    void getHardwareByCodeTest() throws Exception {
        String hardwareCode = "1001";

        mockMvc.perform(
            get("/hardware/" + hardwareCode)
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
        .andExpect(jsonPath("$.code").value(hardwareCode))
        .andExpect(jsonPath("$.name").value("AMD Ryzen 5 3600X"));
    }

    @Test
    void getHardwareByCodeTest_whenNonExistingHardwareCode() throws Exception {
        String hardwareCode = "1014";

        mockMvc.perform(
            get("/hardware/" + hardwareCode)
                .with(user("Admin")
                    .password("admin")
                    .roles("ADMIN")
                )
            .with(csrf())
            .accept(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void createHardwareTest() throws Exception {
        HardwareCommand hardwareCommand = new HardwareCommand();
        hardwareCommand.setCode("1005");
        hardwareCommand.setName("NEW-HARDWARE");
        hardwareCommand.setType("CPU");
        hardwareCommand.setAmount(20);
        hardwareCommand.setPrice(200D);

        mockMvc.perform(
            post("/hardware")
                .with(user("Admin")
                    .password("admin")
                    .roles("ADMIN")
                )
            .with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(hardwareCommand))
            .accept(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isCreated())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(content().encoding(StandardCharsets.UTF_8))
        .andExpect(jsonPath("$.code").value(hardwareCommand.getCode()))
        .andExpect(jsonPath("$.name").value(hardwareCommand.getName()))
        .andExpect(jsonPath("$.price").value(hardwareCommand.getPrice()));
    }

    @Test
    @Transactional
    void deleteHardwareTest() throws Exception {
        String hardwareCode = "1002";

        mockMvc.perform(
            delete("/hardware/" + hardwareCode)
                .with(user("Admin")
                    .password("admin")
                    .roles("ADMIN")
                )
            .with(csrf())
            .accept(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isNoContent());

        mockMvc.perform(
            get("/hardware")
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
        .andExpect(jsonPath("$", hasSize(3)));
    }
}