package org.minsait.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class TariffRequest {

    @Schema(description = "Application date", example = "2020-06-13T22:00:00.000+00:00")
    @NotNull
    @JsonProperty("APPLICATION_DATE")
    private Date applicationDate;

    @Schema(description = "Product id", example = "1")
    @NotNull
    @JsonProperty("PRODUCT_ID")
    private Integer productId;

    @Schema(description = "Brand id", example = "1")
    @NotNull
    @JsonProperty("BRAND_ID")
    private Integer brandId;
}
