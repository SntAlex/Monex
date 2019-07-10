package com.copeika.monex.api;

import com.copeika.monex.models.Budget;
import com.copeika.monex.services.BudgetService;
import com.copeika.monex.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BudgetController {
    private static final String BUDGET_PATH = "/api/v001/budget";

    @Autowired
    private BudgetService service;
    private CategoryService catservice;

    @PostMapping(BUDGET_PATH)
    public ResponseEntity<Budget> createBudget(
            @RequestHeader String UserId,
            @RequestBody Integer money
    ) {
        Budget result = service.createBudget(UserId, money);
        return ResponseEntity.ok(result);
    }

    @GetMapping(BUDGET_PATH)
    public ResponseEntity<Budget> takeBudget(
        @RequestHeader String UserId
    ) {
        Budget result = service.provideBudget(UserId);
        return ResponseEntity.ok(result);
    }

    @PatchMapping(BUDGET_PATH)
    public ResponseEntity<Budget> updateBudget(
            @RequestHeader String UserId,
            @RequestBody Integer money
    ) {
        Budget update = service.updateBudget(UserId, money);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping(BUDGET_PATH)
    public ResponseEntity<?> deleteBudget(
            @RequestHeader String UserId
    ) {
        service.deleteBudget(UserId);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = BUDGET_PATH, params = "cash_balance")
    public ResponseEntity<Integer> getCashBalance(
            @RequestHeader String UserId
    ) {
        Integer cash = service.provideBudget(UserId).getMoney() - catservice.getSumMonetaryExpenditures(UserId);
        return ResponseEntity.ok(cash);
    }
}
