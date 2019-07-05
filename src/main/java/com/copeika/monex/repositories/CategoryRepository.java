package com.copeika.monex.repositories;

import com.copeika.monex.models.Category;

public interface CategoryRepository {
    Category addCategory(String name);
    Category deleteCategory();
    Category renameCategory(String id, String name);
    Category fetchCategory();
}
