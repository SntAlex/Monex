package com.copeika.monex.repositories;

import com.copeika.monex.models.Budget;
import org.springframework.stereotype.Repository;
import com.copeika.monex.exception.NotFoundException;

@Repository
public class InMemoryBudgetRepository implements BudgetRepository {
    private Budget budgetCache = new Budget();

    public InMemoryBudgetRepository(){
        budgetCache.setMoney(null);
    }

    @Override
    public Budget fetchBudget() {
        if (budgetCache == null) {
            throw new NotFoundException();
        }
        return budgetCache;
    }

    @Override
    public Budget createBudget(Integer cash) {
        budgetCache.setMoney(cash);
        Budget budget = budgetCache;
        return budget;
    }

    @Override
    public Budget updateBudget(Integer cash) {
        budgetCache.setMoney(cash);
        Budget budget = budgetCache;
        return budget;
    }

    @Override
    public void deleteBudget() {
        if (budgetCache == null) {
            throw new NotFoundException();
        }
        budgetCache.setMoney(null);
    }
}
