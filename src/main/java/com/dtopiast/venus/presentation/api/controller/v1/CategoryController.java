package com.dtopiast.venus.presentation.api.controller.v1;
import com.dtopiast.venus.core.service.category.ICategoryService;
import com.dtopiast.venus.domain.category.dto.*;
import com.dtopiast.venus.domain.category.model.Category;
import com.dtopiast.venus.domain.role.dto.RoleType;
import com.dtopiast.venus.domain.role.model.Role;
import com.dtopiast.venus.presentation.api.controller.base.MyController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/v1/category")
@Api(value = "Category Management System")
public class CategoryController extends MyController {
    private final ICategoryService categoryService;

    @Autowired
    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ApiOperation(value = "Add a course to a category")
    @PostMapping("/addCourse")
    @PreAuthorize("hasRole('ADMIN')")

    public ResponseEntity<Category> addCourseInCategory(
            @ApiParam(value = "Course and Category IDs", required = true)
            @Valid @RequestBody AddCourseInCategoryDto dto) {
        Category category = categoryService.addCourseInCategory(dto);
        return ResponseEntity.ok(category);
    }

    @ApiOperation(value = "Delete a course from a category")
    @DeleteMapping("/deleteCourse")
    @PreAuthorize("hasRole('ADMIN')")

    public ResponseEntity<Boolean> deleteCourseInCategory(
            @ApiParam(value = "Course and Category IDs", required = true)
            @Valid @RequestBody DeleteCourseInCategoryDto dto) {
        Boolean result = categoryService.deleteCourseInCategory(dto);
        return ResponseEntity.ok(result);
    }

    @ApiOperation(value = "Create a new category")
    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")

    public ResponseEntity<Category> createCategory(
            @ApiParam(value = "Category Details", required = true)
            @Valid @RequestBody CreateCategoryDto dto) {
        Category category = categoryService.createCategory(dto);
        return ResponseEntity.ok(category);
    }

    @ApiOperation(value = "Delete a category")
    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")

    public ResponseEntity<Boolean> deleteCategory(
            @ApiParam(value = "Category ID", required = true)
            @Valid @RequestBody DeleteCategoryDto dto) {
        Boolean result = categoryService.deleteCategory(dto);
        return ResponseEntity.ok(result);
    }

    @ApiOperation(value = "Update the name of a category")
    @PutMapping("/updateName")
    @PreAuthorize("hasRole('ADMIN')")

    public ResponseEntity<Category> updateCategoryName(
            @ApiParam(value = "Category ID and new name", required = true)
            @Valid @RequestBody UpdateCategoryNameDto dto) {
        Category category = categoryService.updateCategoryName(dto);
        return ResponseEntity.ok(category);
    }

    @ApiOperation(value = "Get all categories")
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @ApiOperation(value = "Get category by name")
    @GetMapping("/byName/{name}")

    public ResponseEntity<Category> getCategoryByName(
            @ApiParam(value = "Category name", required = true)
            @PathVariable String name) {
        Category category = categoryService.getCategoryByName(name);
        return ResponseEntity.ok(category);
    }

    @ApiOperation(value = "Get category by ID")
    @GetMapping("/byId/{id}")
    public ResponseEntity<Category> getCategoryById(
            @ApiParam(value = "Category ID", required = true)
            @PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }
}