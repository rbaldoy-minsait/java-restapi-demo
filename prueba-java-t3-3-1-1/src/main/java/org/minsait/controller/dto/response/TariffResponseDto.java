package org.minsait.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TariffResponseDto {

    @JsonProperty("PRODUCT_ID")
    private Long productId;
    @JsonProperty("BRAND_ID")
    private Integer brandId;
    @JsonProperty("TARIFF")
    private Integer tariff;
    @JsonProperty("START_DATE")
    private Date startDate;
    @JsonProperty("END_DATE")
    private Date endDate;
    @JsonProperty("FINAL_PRICE")
    private Double finalPrice;
}
