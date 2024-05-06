package org.minsait.service;

import org.minsait.controller.dto.request.TariffRequest;
import org.minsait.controller.dto.response.TariffResponseDto;
import org.minsait.controller.dto.response.PriceResponseDto;

import java.util.List;

public interface PriceService {

    List<PriceResponseDto> findAllPrices();

    TariffResponseDto findTariff(TariffRequest request);
}
