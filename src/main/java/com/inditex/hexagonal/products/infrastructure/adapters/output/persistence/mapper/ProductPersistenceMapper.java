package com.inditex.hexagonal.products.infrastructure.adapters.output.persistence.mapper;

import com.inditex.hexagonal.products.domain.model.ProductPrice;
import com.inditex.hexagonal.products.infrastructure.adapters.output.persistence.entity.ProductPriceEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProductPersistenceMapper {

  ProductPrice toProduct(ProductPriceEntity productPriceEntity);

}
