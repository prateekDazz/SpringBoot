package com.eCommerce.Ecommerce.Application.Service;

import com.eCommerce.Ecommerce.Application.Exception.CategoryNotFoundException;
import com.eCommerce.Ecommerce.Application.dto.CategoryDto;
import com.eCommerce.Ecommerce.Application.dto.CategoryResponseDto;
import com.eCommerce.Ecommerce.Application.model.Category;
import com.eCommerce.Ecommerce.Application.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public String createCategory(Category category) {
        categoryRepository.save(category);
        return "Data Saved";
    }

    @Override
    public String deleteCatgory(Long categoryId) throws CategoryNotFoundException {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new CategoryNotFoundException("category with id "+categoryId+" does not exists "));

        categoryRepository.deleteById(categoryId);
        return "data deleted";
    }

    @Override
    public Category retrieveCategory(Long categoryId) throws CategoryNotFoundException {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new CategoryNotFoundException("category with id "+categoryId+" does not exists "));
        return category;
    }

    @Override
    public CategoryResponseDto fetchAllCategory(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sortAndOrder = sortDir.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending()
                :Sort.by(sortBy).descending();
        Pageable pageDetails = PageRequest.of(pageNo,pageSize,sortAndOrder);
        Page<Category> categoryPage = categoryRepository.findAll(pageDetails);

        List<Category>categoryList = categoryPage.getContent();
                List<CategoryDto>categoryDtos  = categoryList.stream().map(x->modelMapper.map(x,CategoryDto.class)).collect(Collectors.toList());
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setCategoryDtoList(categoryDtos);
        categoryResponseDto.setPageNo(pageDetails.getPageNumber());
        categoryResponseDto.setLastPage(categoryPage.isLast());
        categoryResponseDto.setPageSize(pageDetails.getPageSize());
        categoryResponseDto.setTotalElements(categoryPage.getNumberOfElements());
        return categoryResponseDto;
    }

    @Override
    public Category updateCategory(Long categoryId,String categoryName) throws CategoryNotFoundException {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new CategoryNotFoundException("category with id "+categoryId+" does not exists "));
//        add ezxception check here
category.setCategoryName(categoryName);
categoryRepository.save(category);

        return category;
    }
}
