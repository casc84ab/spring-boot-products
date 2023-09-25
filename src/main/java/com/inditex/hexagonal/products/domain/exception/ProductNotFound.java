package com.inditex.hexagonal.products.domain.exception;

public class ProductNotFound extends RuntimeException {

    public ProductNotFound(String message) {
        super(message);
    }

}
