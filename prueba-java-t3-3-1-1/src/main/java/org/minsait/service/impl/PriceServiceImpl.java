package org.minsait.service.impl;

import lombok.AllArgsConstructor;
import org.hibernate.FetchNotFoundException;
import org.minsait.controller.dto.request.TariffRequest;
import org.minsait.controller.dto.response.TariffResponseDto;
import org.minsait.controller.dto.response.PriceResponseDto;
import org.minsait.model.Price;
import org.minsait.repository.PriceRepository;
import org.minsait.service.PriceService;
import org.minsait.service.mapper.PriceMapper;
import org.minsait.service.utils.PriceUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {

    private static final String EXCEPTION_CLASS_NAME = "PRICE_SERVICE";
    public static final String FETCH_ALL_ERROR_CODE = "001";
    public static final String FETCH_TARIFF_ERROR_CODE = "002";

    private final PriceRepository repository;
    private final PriceMapper mapper;

    /**
     * This method fetch all the prices
     * @return list of all prices
     */
    @Override
    public List<PriceResponseDto> findAllPrices() {
        List<Price> response = repository.findAll();

        if (CollectionUtils.isEmpty(response)) {
            throw new FetchNotFoundException(FETCH_ALL_ERROR_CODE, EXCEPTION_CLASS_NAME);
        }

        return response.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * This method fetch the most priority tariff for a desired product
     * @param request request entity with the product information
     * @return dto with the tariff information
     */
    @Override
    public TariffResponseDto findTariff(TariffRequest request) {
        List<Price> priceList = repository.findTariffs(
                request.getApplicationDate(),
                request.getProductId(),
                request.getBrandId());

        if (CollectionUtils.isEmpty(priceList)) {
            throw new FetchNotFoundException(FETCH_TARIFF_ERROR_CODE, EXCEPTION_CLASS_NAME);
        }

        return mapper.toTariffDto(PriceUtils.getMostPriorityPrice(priceList));
    }
}
