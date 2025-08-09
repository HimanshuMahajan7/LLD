package splitwise.src.expense.split;

import splitwise.src.expense.ExpenseSplitType;
import splitwise.src.expense.split.impl.EqualExpenseSplit;
import splitwise.src.expense.split.impl.PercentageExpenseSplit;
import splitwise.src.expense.split.impl.UnequalExpenseSplit;

public class SplitFactory {
    public static ExpenseSplit getSplitObjet(ExpenseSplitType splitType) {
        return switch (splitType) {
            case EQUAL -> new EqualExpenseSplit();
            case UN_EQUAL -> new UnequalExpenseSplit();
            case PERCENTAGE_WISE -> new PercentageExpenseSplit();
        };
    }
}
