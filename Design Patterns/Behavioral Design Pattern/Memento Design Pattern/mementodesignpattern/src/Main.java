package mementodesignpattern.src;

public class Main {
    public static void main(String[] args) {
        ConfigurationCareTaker configurationCareTaker = new ConfigurationCareTaker();
        ConfigurationOriginator configurationOriginator = new ConfigurationOriginator(10, 20);

        // Create Memento snapshot and save to history
        ConfigurationMemento snapshot1 = configurationOriginator.createMemento();
        configurationCareTaker.addMemento(snapshot1);

        // Change originator state
        configurationOriginator.setHeight(7);
        configurationOriginator.setWidth(14);

        // Create Memento snapshot and save to history
        ConfigurationMemento snapshot2 = configurationOriginator.createMemento();
        configurationCareTaker.addMemento(snapshot2);

        // Change originator state
        configurationOriginator.setHeight(20);
        configurationOriginator.setWidth(50);

        configurationCareTaker.undo(configurationOriginator);

        System.out.println("Height: " + configurationOriginator.height + ", Width: " + configurationOriginator.width);
    }
}
