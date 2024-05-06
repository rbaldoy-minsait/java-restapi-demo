package org.minsait.service.impl;

import lombok.SneakyThrows;
import org.hibernate.FetchNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.minsait.controller.dto.request.TariffRequest;
import org.minsait.model.Price;
import org.minsait.repository.PriceRepository;
import org.minsait.service.mapper.PriceMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PriceServiceImplTest {

    @InjectMocks
    private PriceServiceImpl service;

    @Mock
    private PriceRepository repository;

    @Mock
    private PriceMapper mapper;

    @SneakyThrows
    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @SneakyThrows
    @Test
    void findAll_shouldReturnOneValue() {
        Price priceMock = mock(Price.class);
        List<Price> priceList = new ArrayList<>();
        priceList.add(priceMock);

        when(repository.findAll()).thenReturn(priceList);

        service.findAllPrices();

        verify(repository, times(1)).findAll();
        verify(mapper, times(1)).toDto(any());
    }

    @SneakyThrows
    @Test
    void findAll_shouldReturnMultipleValues() {
        Price priceMock1 = mock(Price.class);
        Price priceMock2 = mock(Price.class);
        Price priceMock3 = mock(Price.class);
        List<Price> priceList = new ArrayList<>();
        priceList.add(priceMock1);
        priceList.add(priceMock2);
        priceList.add(priceMock3);

        when(repository.findAll()).thenReturn(priceList);

        service.findAllPrices();

        verify(repository, times(1)).findAll();
        verify(mapper, times(3)).toDto(any());
    }

    @SneakyThrows
    @Test
    void findAll_shouldReturnNoValues() {
        when(repository.findAll()).thenReturn(new ArrayList<>());

        assertThatThrownBy(() -> service.findAllPrices())
                .isInstanceOf(FetchNotFoundException.class);
    }

    @SneakyThrows
    @Test
    void givenCorrectRequest_thenFindTariff_shouldReturnOk() {
        TariffRequest request = mock(TariffRequest.class);
        List<Price> priceList = new ArrayList<>();
        Price price = mock(Price.class);
        priceList.add(price);

        when(repository.findTariffs(any(), any(), any())).thenReturn(priceList);

        service.findTariff(request);

        verify(repository, times(1)).findTariffs(any(), any(), any());
        verify(mapper, times(1)).toTariffDto(any());
    }

    @SneakyThrows
    @Test
    void notFoundRequest_thenFindTariff_shouldThrowsException() {
        TariffRequest request = mock(TariffRequest.class);

        when(repository.findTariffs(any(), any(), any())).thenReturn(new ArrayList<>());

        assertThatThrownBy(() -> service.findTariff(request))
                .isInstanceOf(FetchNotFoundException.class);
    }
}
