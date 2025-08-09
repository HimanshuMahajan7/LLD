package splitwise.src.expense.split.impl;

import splitwise.src.expense.split.ExpenseSplit;
import splitwise.src.expense.split.Split;

import java.util.List;

public class EqualExpenseSplit implements ExpenseSplit {
    @Override
    public void validateSplitRequest(List<Split> splitDetails, double expenseAmount) {
        double equallySplitAmount = expenseAmount / splitDetails.size();
        for (Split split: splitDetails) {
            if (split.getAmountOwe() != equallySplitAmount) {
                System.out.println("Invalid Split");
                // throw new Exception("Invalid Split");
            }
        }
    }
}
