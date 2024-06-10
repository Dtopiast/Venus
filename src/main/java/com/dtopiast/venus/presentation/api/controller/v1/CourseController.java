package com.dtopiast.venus.presentation.api.controller.v1;

import com.dtopiast.venus.core.service.course.ICourseService;
import com.dtopiast.venus.domain.course.dto.*;
import com.dtopiast.venus.domain.course.model.Course;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/courses")
@Api(value = "Course Management System")
public class CourseController {
    private final ICourseService courseService;

    @Autowired
    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @ApiOperation(value = "Add a category to a course")
    @PostMapping("/addCategory")
    @PreAuthorize("hasRole('ADMIN')")

    public ResponseEntity<Course> addCategoryInCourse(
            @ApiParam(value = "Course and Category IDs", required = true)
            @Valid @RequestBody AddCategoryInCourseDto dto) {
        Course course = courseService.addCategoryInCourse(dto);
        return ResponseEntity.ok(course);
    }

    @ApiOperation(value = "Delete a category from a course")
    @DeleteMapping("/deleteCategory")
    @PreAuthorize("hasRole('ADMIN')")

    public ResponseEntity<Boolean> deleteCategoryInCourse(
            @ApiParam(value = "Course and Category IDs", required = true)
            @Valid @RequestBody DeleteCategoryInCourseDto dto) {
        Boolean result = courseService.deleteCategoryInCourse(dto);
        return ResponseEntity.ok(result);
    }

    @ApiOperation(value = "Create a new course")
    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")

    public ResponseEntity<Course> createCourse(
            @ApiParam(value = "Course Details", required = true)
            @Valid @RequestBody CreateCourseDto dto) {
        Course course = courseService.createCourse(dto);
        return ResponseEntity.ok(course);
    }

    @ApiOperation(value = "Delete a course")
    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")

    public ResponseEntity<Boolean> deleteCourse(
            @ApiParam(value = "Course ID", required = true)
            @Valid @RequestBody DeleteCourseDto dto) {
        Boolean result = courseService.deleteCourse(dto);
        return ResponseEntity.ok(result);
    }

    @ApiOperation(value = "Update the name of a course")
    @PutMapping("/updateName")
    @PreAuthorize("hasRole('ADMIN')")

    public ResponseEntity<Course> updateCourseName(
            @ApiParam(value = "Course ID and new name", required = true)
            @Valid @RequestBody UpdateCourseNameDto dto) {
        Course course = courseService.updateCourseName(dto);
        return ResponseEntity.ok(course);
    }

    @ApiOperation(value = "Get all courses")
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @ApiOperation(value = "Get course by name")
    @GetMapping("/byName/{name}")
    public ResponseEntity<Course> getCourseByName(
            @ApiParam(value = "Course name", required = true)
            @PathVariable String name) {
        Course course = courseService.getCourseByName(name);
        return ResponseEntity.ok(course);
    }

    @ApiOperation(value = "Get course by ID")
    @GetMapping("/byId/{id}")
    public ResponseEntity<Course> getCourseById(
            @ApiParam(value = "Course ID", required = true)
            @PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        return ResponseEntity.ok(course);
    }
}
