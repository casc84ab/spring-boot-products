package com.inditex.hexagonal.products.infrastructure.adapters.input.rest;

import com.inditex.hexagonal.products.infrastructure.adapters.input.rest.data.request.ProductGetPriceRequest;
import com.inditex.hexagonal.products.infrastructure.adapters.input.rest.data.response.ProductGetPriceResponse;
import com.inditex.hexagonal.products.infrastructure.adapters.output.customizedexception.data.response.ExceptionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
class ProductRestAdapterTest {

  @Autowired
  private WebTestClient webTestClient;

  static String PRODUCTS_URL = "/v1/products";

  @Test
  void get_product_price_test_01() {
    ProductGetPriceRequest productGetPriceRequest = ProductGetPriceRequest
        .builder()
        .applicationDate("2020-06-14 10:00:00")
        .productId("35455")
        .brandId(1).build();

    webTestClient
        .post()
        .uri(PRODUCTS_URL)
        .bodyValue(productGetPriceRequest)
        .exchange()
        .expectStatus()
        .is2xxSuccessful()
        .expectBody(ProductGetPriceResponse.class)
        .consumeWith(productGetPriceResponseEntityExchangeResult -> {
          assert productGetPriceResponseEntityExchangeResult.getResponseBody() != null;
          assertAll(() ->
              assertEquals(new BigDecimal("35.50"), productGetPriceResponseEntityExchangeResult.getResponseBody().getPrice()));
              assertEquals(1,productGetPriceResponseEntityExchangeResult.getResponseBody().getPriceList());
        });
  }

  @Test
  void get_product_price_test_02() {
    ProductGetPriceRequest productGetPriceRequest = ProductGetPriceRequest
        .builder()
        .applicationDate("2020-06-14 16:00:00")
        .productId("35455")
        .brandId(1).build();

    webTestClient
        .post()
        .uri(PRODUCTS_URL)
        .bodyValue(productGetPriceRequest)
        .exchange()
        .expectStatus()
        .is2xxSuccessful()
        .expectBody(ProductGetPriceResponse.class)
        .consumeWith(productGetPriceResponseEntityExchangeResult -> {
          assert productGetPriceResponseEntityExchangeResult.getResponseBody() != null;
          assertAll(() ->
              assertEquals(new BigDecimal("25.45"), productGetPriceResponseEntityExchangeResult.getResponseBody().getPrice()));
              assertEquals(2,productGetPriceResponseEntityExchangeResult.getResponseBody().getPriceList());
        });
  }

  @Test
  void get_product_price_test_03() {
    ProductGetPriceRequest productGetPriceRequest = ProductGetPriceRequest
        .builder()
        .applicationDate("2020-06-14 21:00:00")
        .productId("35455")
        .brandId(1).build();

    webTestClient
        .post()
        .uri(PRODUCTS_URL)
        .bodyValue(productGetPriceRequest)
        .exchange()
        .expectStatus()
        .is2xxSuccessful()
        .expectBody(ProductGetPriceResponse.class)
        .consumeWith(productGetPriceResponseEntityExchangeResult -> {
          assert productGetPriceResponseEntityExchangeResult.getResponseBody() != null;
          assertAll(() ->
              assertEquals(new BigDecimal("38.95"), productGetPriceResponseEntityExchangeResult.getResponseBody().getPrice()));
              assertEquals(4,productGetPriceResponseEntityExchangeResult.getResponseBody().getPriceList());
        });
  }

  @Test
  void get_product_price_test_04() {
    ProductGetPriceRequest productGetPriceRequest = ProductGetPriceRequest
        .builder()
        .applicationDate("2020-06-15 10:00:00")
        .productId("35455")
        .brandId(1).build();

    webTestClient
        .post()
        .uri(PRODUCTS_URL)
        .bodyValue(productGetPriceRequest)
        .exchange()
        .expectStatus()
        .is2xxSuccessful()
        .expectBody(ProductGetPriceResponse.class)
        .consumeWith(productGetPriceResponseEntityExchangeResult -> {
          assert productGetPriceResponseEntityExchangeResult.getResponseBody() != null;
          assertAll(() ->
              assertEquals(new BigDecimal("30.50"), productGetPriceResponseEntityExchangeResult.getResponseBody().getPrice()));
              assertEquals(3,productGetPriceResponseEntityExchangeResult.getResponseBody().getPriceList());
        });
  }

  @Test
  void get_product_price_test_05() {
    ProductGetPriceRequest productGetPriceRequest = ProductGetPriceRequest
        .builder()
        .applicationDate("2020-06-16 21:00:00")
        .productId("35455")
        .brandId(1).build();

    webTestClient
        .post()
        .uri(PRODUCTS_URL)
        .bodyValue(productGetPriceRequest)
        .exchange()
        .expectStatus()
        .is2xxSuccessful()
        .expectBody(ProductGetPriceResponse.class)
        .consumeWith(productGetPriceResponseEntityExchangeResult -> {
          assert productGetPriceResponseEntityExchangeResult.getResponseBody() != null;
          assertAll(() ->
              assertEquals(new BigDecimal("38.95"), productGetPriceResponseEntityExchangeResult.getResponseBody().getPrice()));
              assertEquals(4,productGetPriceResponseEntityExchangeResult.getResponseBody().getPriceList());
        });
  }

  @Test
  void get_product_price_test_not_found() {
    ProductGetPriceRequest productGetPriceRequest = ProductGetPriceRequest
        .builder()
        .applicationDate("2020-06-16 21:00:00")
        .productId("35451")
        .brandId(1).build();

    webTestClient
        .post()
        .uri(PRODUCTS_URL)
        .bodyValue(productGetPriceRequest)
        .exchange()
        .expectStatus()
        .isNotFound()
        .expectBody(ExceptionResponse.class)
        .value(message -> assertEquals("Product Price not found for: 2020-06-16 21:00:00", message.getMessage()));
  }

  @Test
  void get_product_price_test_bad_request_type() {
    ProductGetPriceRequest productGetPriceRequest = ProductGetPriceRequest
        .builder()
        .applicationDate("2020-06-16 21:00:00")
        .productId("35451")
        .brandId(-1).build();

    webTestClient
        .post()
        .uri(PRODUCTS_URL)
        .bodyValue(productGetPriceRequest)
        .exchange()
        .expectStatus()
        .isBadRequest()
        .expectBody(ExceptionResponse.class)
        .value(message -> {
          assert message.getMessage() != null;
          assertTrue(message.getMessage().contains("debe ser mayor que o igual a 0"));
        });
  }

  @Test
  void get_product_price_test_bad_request_not_null() {
    ProductGetPriceRequest productGetPriceRequest = ProductGetPriceRequest
        .builder()
        .applicationDate("2020-06-16 21:00:00")
        .brandId(-1).build();

    webTestClient
        .post()
        .uri(PRODUCTS_URL)
        .bodyValue(productGetPriceRequest)
        .exchange()
        .expectStatus()
        .isBadRequest()
        .expectBody(ExceptionResponse.class)
        .value(message -> {
          assert message.getMessage() != null;
          assertTrue(message.getMessage().contains("productId may not be empty"));
        });
  }

}