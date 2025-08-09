package splitwise.src.expense.split;

import java.util.List;

public interface ExpenseSplit {
    void validateSplitRequest(List<Split> splitDetails, double expenseAmount);
}
