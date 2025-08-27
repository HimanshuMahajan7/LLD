package mementodesignpattern.src;

import java.util.Stack;

public class ConfigurationCareTaker {
    private Stack<ConfigurationMemento> history = new Stack<>();

    public void addMemento(ConfigurationMemento configurationMemento) {
        history.push(configurationMemento);
    }

    public void undo(ConfigurationOriginator originator) {
        if (!history.empty()) {
            originator.restoreMemento(history.pop());
        }
    }
}
