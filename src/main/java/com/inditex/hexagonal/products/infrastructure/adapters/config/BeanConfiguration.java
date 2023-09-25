package com.inditex.hexagonal.products.infrastructure.adapters.config;

import com.inditex.hexagonal.products.domain.service.ProductPriceService;
import com.inditex.hexagonal.products.infrastructure.adapters.output.persistence.ProductPersistenceAdapter;
import com.inditex.hexagonal.products.infrastructure.adapters.output.persistence.mapper.ProductPersistenceMapper;
import com.inditex.hexagonal.products.infrastructure.adapters.output.persistence.repository.ProductPriceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean configuration between layers
 */
@Configuration
public class BeanConfiguration {
  @Bean
  public ProductPersistenceAdapter productPersistenceAdapter(ProductPriceRepository productPriceRepository, ProductPersistenceMapper productPersistenceMapper) {
    return new ProductPersistenceAdapter(productPriceRepository, productPersistenceMapper);
  }

  @Bean
  public ProductPriceService productPriceService(ProductPersistenceAdapter productPersistenceAdapter) {
    return new ProductPriceService(productPersistenceAdapter);
  }
}
