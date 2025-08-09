package splitwise.src.expense.split.impl;

import splitwise.src.expense.split.ExpenseSplit;
import splitwise.src.expense.split.Split;

import java.util.List;
import java.util.Optional;

public class UnequalExpenseSplit implements ExpenseSplit {
    @Override
    public void validateSplitRequest(List<Split> splitDetails, double expenseAmount) {
        Optional<Double> totalAmount = splitDetails.stream().map(Split::getAmountOwe).reduce(Double::sum);
        if (totalAmount.isPresent() && totalAmount.get() != expenseAmount) {
            System.out.println("Invalid Amount");
            // throw new Exception("Invalid Split");
        }
    }
}
