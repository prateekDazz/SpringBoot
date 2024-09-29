package com.eCommerce.Ecommerce.Application.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    @Size(min=3,max=20,message = "size should be between 3 and 20")
    public String categoryName;
    @NotNull
    public String categoryDescription;
}
