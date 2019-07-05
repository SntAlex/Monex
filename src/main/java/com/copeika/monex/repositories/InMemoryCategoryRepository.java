package com.copeika.monex.repositories;


import com.copeika.monex.exception.NotFoundException;
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
        category.setMoney_expenditures(0);
        categoryCache.put(id, category);
        return category;
    }

    @Override
    public void deleteCategory(String id) {
        if (!categoryCache.containsKey(id)) {
            throw new NotFoundException();
        }
        categoryCache.remove(id);
    }

    @Override
    public Category renameCategory(String id, String name) {
        if (!categoryCache.containsKey(id)) {
            throw new NotFoundException();
        }
        Category category = categoryCache.get(id);
        category.setName(name);
        categoryCache.put(id, category);
        return category;
    }

    @Override
    public Category fetchCategory(String id) {
        if (!categoryCache.containsKey(id)) {
            throw new NotFoundException();
        }
        return categoryCache.get(id);
    }

    @Override
    public Category setLimit(String id, Integer limit) {
        if (!categoryCache.containsKey(id)) {
            throw new NotFoundException();
        }
        Category category = categoryCache.get(id);
        category.setLimit(limit);
        categoryCache.put(id, category);
        return  category;
    }

    @Override
    public Category addMonetaryExpenditures(String id, Integer money_expenditures) {
        if (!categoryCache.containsKey(id)) {
            throw new NotFoundException();
        }
        Category category = categoryCache.get(id);
        category.addMoneyExpenditures(money_expenditures);
        categoryCache.put(id, category);
        return category;
    }
}
