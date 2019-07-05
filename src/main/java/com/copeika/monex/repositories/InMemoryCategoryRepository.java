package com.copeika.monex.repositories;


import com.copeika.monex.models.Category;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class InMemoryCategoryRepository implements CategoryRepository {

    private Map<String, Category> categoryCache = new HashMap<>();

    public InMemoryCategoryRepository(){

    }

    @Override
    public Category addCategory(String name) {
        Category category = new Category();
        String id = UUID.randomUUID().toString();
        category.setId(id);
        category.setName(name);
        categoryCache.put(id, category);
        return category;
    }

    @Override
    public Category deleteCategory() {
        return null;
    }

    @Override
    public Category renameCategory(String id, String name) {
        Category category = categoryCache.get(id);
        category.setName(name);
        categoryCache.put(id, category);
        return category;
    }

    @Override
    public Category fetchCategory() {
        return null;
    }
}
