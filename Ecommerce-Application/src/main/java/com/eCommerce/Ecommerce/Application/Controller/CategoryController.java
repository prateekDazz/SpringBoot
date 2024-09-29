package com.eCommerce.Ecommerce.Application.Controller;

import com.eCommerce.Ecommerce.Application.Service.CategoryService;
import com.eCommerce.Ecommerce.Application.dto.CategoryDto;
import com.eCommerce.Ecommerce.Application.dto.CategoryResponseDto;
import com.eCommerce.Ecommerce.Application.model.Category;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CategoryController {
@Autowired
    private CategoryService categoryService;

@Autowired
private ModelMapper modelMapper;
@PostMapping("/admin/category")
    public ResponseEntity<String> createCategory(@Valid @RequestBody CategoryDto categoryDto)
    {
Category category = modelMapper.map(categoryDto,Category.class);
        categoryService.createCategory(category);
        return ResponseEntity.ok("Data saved successfully");
    }

    @GetMapping("/public/categories")
    public ResponseEntity<CategoryDto>fetchCategoryByCategoryId(@RequestParam("id")Long id)
    {
        Category cat = categoryService.retrieveCategory(id);
        CategoryDto categoryDto = modelMapper.map(cat,CategoryDto.class);
        return ResponseEntity.ok(categoryDto);
    }
    @DeleteMapping("/admin/categories")
    public ResponseEntity<String>deleteCategoryByCategoryId(@RequestParam("id")Long id)
    {
        String s = categoryService.deleteCatgory(id);
        return ResponseEntity.ok(s);
    }
    @GetMapping("/admin/categories")
    public ResponseEntity<CategoryResponseDto>fetchAllCategory(@RequestParam(name = "pageNo",defaultValue = "0",required = false)int pageNo, @RequestParam(name="pageSize",defaultValue = "10",required = false)int pageSize,
                                                               @RequestParam(name="sortBy",required = false,defaultValue = "categoryId")String sortBy,@RequestParam(name="sortDir",required = false,defaultValue = "desc")String sortDir)
    {
        CategoryResponseDto categoryResponseDto=  categoryService.fetchAllCategory(pageNo,pageSize,sortBy,sortDir);



        return ResponseEntity.ok(categoryResponseDto);
    }
}
