package org.minsait.service.mapper;

import org.minsait.controller.dto.response.TariffResponseDto;
import org.minsait.controller.dto.response.PriceResponseDto;
import org.minsait.model.Price;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper {

    /**
     * This method map a price entity to a price response dto
     * @param entity price entity
     * @return price response dto
     */
    public PriceResponseDto toDto(Price entity) {
        return PriceResponseDto.builder()
                .brandId(entity.getBrandId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .priceList(entity.getPriceList())
                .productId(entity.getProductId())
                .priority(entity.getPriority())
                .price(entity.getPrice())
                .curr(entity.getCurr())
                .build();
    }

    /**
     * This method map a price entity to a tariff response
     * @param entity price entity
     * @return tariff response dto
     */
    public TariffResponseDto toTariffDto(Price entity) {
        return TariffResponseDto.builder()
                .productId(entity.getProductId())
                .brandId(entity.getBrandId())
                .tariff(entity.getPriceList())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .finalPrice(entity.getPrice())
                .build();
    }
}
