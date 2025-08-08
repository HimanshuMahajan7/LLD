package adapterpattern.weightmachine.src.client;

import adapterpattern.weightmachine.src.adaptee.WeightMachineForBabies;
import adapterpattern.weightmachine.src.adapter.WeightMachineAdapter;
import adapterpattern.weightmachine.src.adapter.WeightMachineAdapterImpl;

public class Main {
    public static void main(String[] args) {
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        double weightInKg = weightMachineAdapter.getWeightInKg();
        System.out.println("Weight: " + weightInKg);
    }
}
