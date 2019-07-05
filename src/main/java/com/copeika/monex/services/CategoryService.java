package com.copeika.monex.services;


import com.copeika.monex.models.Category;
import com.copeika.monex.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

     public Category addCategory(String name) {
         return categoryRepository.addCategory(name);
     }

     public Category renameCategory(String id, String name){
        return categoryRepository.renameCategory(id, name);
     }

     public Category fetchCategory(String id){
        return categoryRepository.fetchCategory(id);
     }

     public Category setLimit(String id, Integer limit) {
         return categoryRepository.setLimit(id, limit);
     }

     public Category addMonetaryExpenditures(String id, Integer money_expenditures) {
         return categoryRepository.addMonetaryExpenditures(id, money_expenditures);
     }

     public void deleteCategory(String id){
        categoryRepository.deleteCategory(id);
     }
}
