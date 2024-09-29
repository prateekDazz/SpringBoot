package com.eCommerce.Ecommerce.Application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDto {

    private List<CategoryDto> categoryDtoList;
    private int pageNo;
    private int pageSize;
    private int totalElements;
    private boolean lastPage;
}
