package com.copeika.monex.repositories;

import com.copeika.monex.models.Category;

public interface CategoryRepository {
    Category addCategory(String name);
    void deleteCategory(String id);
    Category renameCategory(String id, String name);
    Category fetchCategory(String id);
    Category setLimit(String id, Integer limit);
    Category setMonetaryExpenditures(String id, Integer money_expenditures);
}
