package org.minsait.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PriceResponseDto {

    @JsonProperty("BRAND_ID")
    private Integer brandId;

    @JsonProperty("START_DATE")
    private Date startDate;

    @JsonProperty("END_DATE")
    private Date endDate;

    @JsonProperty("PRICE_LIST")
    private Integer priceList;

    @JsonProperty("PRODUCT_ID")
    private Long productId;

    @JsonProperty("PRIORITY")
    private Integer priority;

    @JsonProperty("PRICE")
    private Double price;

    @JsonProperty("CURR")
    private String curr;
}
