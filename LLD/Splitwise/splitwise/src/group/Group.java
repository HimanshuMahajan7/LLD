package splitwise.src.group;

import splitwise.src.expense.Expense;
import splitwise.src.expense.ExpenseController;
import splitwise.src.expense.ExpenseSplitType;
import splitwise.src.expense.split.Split;
import splitwise.src.user.User;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String groupId;
    String groupName;
    List<User> groupMembers;
    List<Expense> expenseList;
    ExpenseController expenseController;

    public Group() {
        this.groupMembers = new ArrayList<>();
        this.expenseList = new ArrayList<>();
        this.expenseController = new ExpenseController();
    }

    public void addMember(User user) {
        groupMembers.add(user);
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Expense createExpense(
            String expenseId,
            String description,
            double expenseAmount,
            List<Split> splitDetails,
            ExpenseSplitType splitType,
            User paidByUser
    ) {
        Expense expense = expenseController.createExpense(expenseId, description, expenseAmount, splitDetails, splitType, paidByUser);
        expenseList.add(expense);
        return expense;
    }
}
