package com.eCommerce.Ecommerce.Application.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    public Long categoryId;
@Size(min=3,max=20,message = "size should be between 3 and 20")
    public String categoryName;
@NotNull
public String categoryDescription;

}
