package org.minsait.controller.impl;

import lombok.RequiredArgsConstructor;
import org.minsait.controller.PriceController;
import org.minsait.controller.dto.request.TariffRequest;
import org.minsait.controller.dto.response.TariffResponseDto;
import org.minsait.controller.dto.response.PriceResponseDto;
import org.minsait.service.PriceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.minsait.controller.constant.Uris.PRICE_URI;

@RestController
@RequestMapping (value = PRICE_URI)
@RequiredArgsConstructor
public class PriceControllerImpl implements PriceController {

    private final PriceService service;

    /**
     * This method return a list of all prices
     * @return response entity with a list of all prices
     */
    @Override
    public ResponseEntity<List<PriceResponseDto>> findAllPrices() {
        return ResponseEntity.ok(service.findAllPrices());
    }

    /**
     * This method return a tariff information for a desired product
     * @param request body with the request fields to fetch the product tariff information
     * @return response entity with the tariff information
     */
    @Override
    public ResponseEntity<TariffResponseDto> getTariff(TariffRequest request) {
        return ResponseEntity.ok(service.findTariff(request));
    }
}
