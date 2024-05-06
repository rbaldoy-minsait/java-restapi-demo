package org.minsait.service.mapper;

import org.junit.jupiter.api.Test;
import org.minsait.controller.dto.response.PriceResponseDto;
import org.minsait.controller.dto.response.TariffResponseDto;
import org.minsait.model.Price;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class PriceMapperTest {
    private static final String GENERIC_STRING = "TEST";
    private static final Integer GENERIC_INTEGER = 1;
    private static final Long GENERIC_LONG = 1L;
    private static final Double GENERIC_DOUBLE = 1.11;
    private static final Date GENERIC_DATE = new Date();

    private final PriceMapper mapper = new PriceMapper();

    @Test
    void mapFromEntityToDto() {
        Price price = Price.builder()
                .brandId(GENERIC_INTEGER)
                .startDate(GENERIC_DATE)
                .endDate(GENERIC_DATE)
                .priceList(GENERIC_INTEGER)
                .productId(GENERIC_LONG)
                .priority(GENERIC_INTEGER)
                .price(GENERIC_DOUBLE)
                .curr(GENERIC_STRING)
                .build();

        PriceResponseDto dto = mapper.toDto(price);

        assertThat(dto).isNotNull();
        assertThat(dto.getBrandId()).isEqualTo(price.getBrandId());
        assertThat(dto.getStartDate()).isEqualTo(price.getStartDate());
        assertThat(dto.getEndDate()).isEqualTo(price.getEndDate());
        assertThat(dto.getPriceList()).isEqualTo(price.getPriceList());
        assertThat(dto.getProductId()).isEqualTo(price.getProductId());
        assertThat(dto.getPriority()).isEqualTo(price.getPriority());
        assertThat(dto.getPrice()).isEqualTo(price.getPrice());
        assertThat(dto.getCurr()).isEqualTo(price.getCurr());
    }

    @Test
    void mapFromEntityToTariffDto() {
        Price price = Price.builder()
                .brandId(GENERIC_INTEGER)
                .startDate(GENERIC_DATE)
                .endDate(GENERIC_DATE)
                .priceList(GENERIC_INTEGER)
                .productId(GENERIC_LONG)
                .priority(GENERIC_INTEGER)
                .price(GENERIC_DOUBLE)
                .curr(GENERIC_STRING)
                .build();

        TariffResponseDto tariffDto = mapper.toTariffDto(price);

        assertThat(tariffDto.getProductId()).isEqualTo(price.getProductId());
        assertThat(tariffDto.getBrandId()).isEqualTo(price.getBrandId());
        assertThat(tariffDto.getTariff()).isEqualTo(price.getPriceList());
        assertThat(tariffDto.getStartDate()).isEqualTo(price.getStartDate());
        assertThat(tariffDto.getEndDate()).isEqualTo(price.getEndDate());
        assertThat(tariffDto.getFinalPrice()).isEqualTo(price.getPrice());
    }
}
