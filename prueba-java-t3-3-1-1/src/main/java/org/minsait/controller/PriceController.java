package org.minsait.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.minsait.controller.dto.request.TariffRequest;
import org.minsait.controller.dto.response.TariffResponseDto;
import org.minsait.controller.dto.response.PriceResponseDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.minsait.controller.constant.Uris.PRICES_URI;
import static org.minsait.controller.constant.Uris.TARIFF_URI;

@Tag(name = "Price Controller")
public interface PriceController {

    @GetMapping(value = PRICES_URI, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Operation(description = "Get all prices.", responses = {
            @ApiResponse(responseCode = "200", description = "Info obtained ok"),
            @ApiResponse(responseCode = "404", description = "Resource not found"),
            @ApiResponse(responseCode = "200", description = "Internal Server Error")
    })
    ResponseEntity<List<PriceResponseDto>> findAllPrices();

    @PostMapping(value = TARIFF_URI, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Operation(description = "Get the discount on a product.", responses = {
            @ApiResponse(responseCode = "200", description = "Info obtained ok"),
            @ApiResponse(responseCode = "404", description = "Resource not found"),
            @ApiResponse(responseCode = "200", description = "Internal Server Error")
    })
    ResponseEntity<TariffResponseDto> getTariff(
            @RequestBody TariffRequest request
            );


}
