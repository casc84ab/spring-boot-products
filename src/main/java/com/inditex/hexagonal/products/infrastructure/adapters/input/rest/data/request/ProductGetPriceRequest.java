package com.inditex.hexagonal.products.infrastructure.adapters.input.rest.data.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * Product Price request
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductGetPriceRequest {

    @NotEmpty(message = "applicationDate may not be empty")
    private String applicationDate;

    @NotEmpty(message = "productId may not be empty")
    private String productId;

    @Min(0)
    private int brandId;

}
