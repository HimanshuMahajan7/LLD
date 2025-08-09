package splitwise.src.expense;

import splitwise.src.BalanceSheetController;
import splitwise.src.expense.split.ExpenseSplit;
import splitwise.src.expense.split.Split;
import splitwise.src.expense.split.SplitFactory;
import splitwise.src.user.User;

import java.util.List;

public class ExpenseController {

    BalanceSheetController balanceSheetController;

    public ExpenseController() {
        this.balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(
            String expenseId,
            String description,
            double expenseAmount,
            List<Split> splitDetails,
            ExpenseSplitType splitType,
            User paidByUser
    ) {
        ExpenseSplit expenseSplit = SplitFactory.getSplitObjet(splitType);
        expenseSplit.validateSplitRequest(splitDetails, expenseAmount);

        Expense expense = new Expense(expenseId, description, expenseAmount, paidByUser, splitType, splitDetails);

        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser, splitDetails, expenseAmount);
        return expense;
    }
}
