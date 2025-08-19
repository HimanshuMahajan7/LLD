package commanddesignpattern.src;

import java.util.Stack;

public class MyRemoteControl {

    ICommand command;
    Stack<ICommand> acCommandHistory = new Stack<>();

    public MyRemoteControl() {
    }

    public void setCommand(ICommand command) {
        this.command = command;
        acCommandHistory.add(command);
    }

    public void pressButton() {
        command.execute();
    }

    public void undo() {
        if (!acCommandHistory.isEmpty()) {
            ICommand lastCommand = acCommandHistory.pop();
            lastCommand.undo();
        }
    }
}
