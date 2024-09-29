package com.eCommerce.Ecommerce.Application.Exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String message)
    {
        super(message);
    }
}
