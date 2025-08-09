package splitwise.src.expense;

import splitwise.src.expense.split.Split;
import splitwise.src.user.User;

import java.util.List;

public class Expense {

    String expenseId;

    String description;

    double expenseAmount;

    User paidByUser;

    ExpenseSplitType splitType;

    List<Split> splitDetails;

    public Expense(String expenseId, String description, double expenseAmount, User paidByUser, ExpenseSplitType splitType, List<Split> splitDetails) {
        this.expenseId = expenseId;
        this.description = description;
        this.expenseAmount = expenseAmount;
        this.paidByUser = paidByUser;
        this.splitType = splitType;
        this.splitDetails = splitDetails;
    }
}
