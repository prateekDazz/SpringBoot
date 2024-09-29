package com.eCommerce.Ecommerce.Application.Service;

import com.eCommerce.Ecommerce.Application.Exception.CategoryNotFoundException;
import com.eCommerce.Ecommerce.Application.dto.CategoryResponseDto;
import com.eCommerce.Ecommerce.Application.model.Category;

public interface CategoryService {

    public String createCategory(Category category);

    public String deleteCatgory(Long categoryId) throws CategoryNotFoundException;


    public Category retrieveCategory(Long categoryId) throws CategoryNotFoundException;

    public CategoryResponseDto fetchAllCategory(int pageNo, int pageSize, String sortBy, String sortDir);

    public Category updateCategory(Long categoryId,String categoryName) throws CategoryNotFoundException;

}
