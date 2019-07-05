package com.copeika.monex.api;

import com.copeika.monex.models.Category;
import com.copeika.monex.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class CategoryController {
    private static final String CATEGORY_PATH = "/api/v001/categories";

    @Autowired
    private CategoryService service;

    @PostMapping(CATEGORY_PATH)
    public ResponseEntity<?> addCategory(
            @RequestHeader String name
    ) {
        Category result = service.addCategory(name);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(CATEGORY_PATH + "/{name}")
    public ResponseEntity<?> deleteCategory(
            @PathVariable String name) {
        service.deleteCategory(name);
        return ResponseEntity.ok().build();
    }

    @GetMapping(CATEGORY_PATH + "/{name}")
    public ResponseEntity<Category> fetchCategory(
            @PathVariable String name) {
        Category result = service.fetchCategory(name);
        return ResponseEntity.ok(result);
    }

    @GetMapping(CATEGORY_PATH )
    public ResponseEntity<Collection<Category>> getAllCategories() {
        Collection<Category> categories = service.getAllCategories();
        return ResponseEntity.ok(categories);
    }



}
