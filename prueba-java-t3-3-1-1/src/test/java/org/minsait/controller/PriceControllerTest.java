package org.minsait.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.minsait.controller.PriceController;
import org.minsait.controller.dto.response.PriceResponseDto;
import org.minsait.controller.dto.response.TariffResponseDto;
import org.minsait.controller.impl.PriceControllerImpl;
import org.minsait.service.PriceService;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.minsait.controller.constant.Uris.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PriceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PriceService service;

    @SneakyThrows
    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }


    @SneakyThrows
    @Test
    void findAllPrices_shouldReturnOk() {
        List<PriceResponseDto> priceResponseDtoList = new ArrayList<>();
        priceResponseDtoList.add(PriceResponseDto.builder().build());

        when(service.findAllPrices()).thenReturn(priceResponseDtoList);

        final ResultActions resultActions = this.mvc.perform(
                get(PRICE_URI + PRICES_URI)
                        .characterEncoding(StandardCharsets.UTF_8.name())
        );

        resultActions.andExpect(status().isOk());
    }

    @SneakyThrows
    @Test
    void getTariff_shouldReturnOk() {
        when(service.findTariff(any())).thenReturn(TariffResponseDto.builder().build());

        final ResultActions resultActions = this.mvc.perform(
                post(PRICE_URI + TARIFF_URI)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}")
                        .characterEncoding(StandardCharsets.UTF_8.name())
        );

        resultActions.andExpect(status().isOk());
    }

    @SneakyThrows
    @Test
    void getTariff_shouldBadRequest() {
        final ResultActions resultActions = this.mvc.perform(
                post(PRICE_URI + TARIFF_URI)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding(StandardCharsets.UTF_8.name())
        );

        resultActions.andExpect(status().isBadRequest());
    }
}
