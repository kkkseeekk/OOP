package ex05;

import ex01.Item2d;
import ex02.View;
import ex04.Command;

public class AvgCommand implements Command {
    private View view;
    private double result = 0.0;
    private boolean progress = false; 

    public AvgCommand(View view) {
        this.view = view;
    }

    public double getResult() {
        return result;
    }

    public boolean running() {
        return progress;
    }

    @Override
    public String getName() {
        return "Average Sum of Digits";
    }

    @Override
    public void execute() {
        progress = true; 
        result = 0.0;
        int count = view.getItems().size();
        if (count > 0) {
            for (Item2d item : view.getItems()) {
                result += item.getY();
            }
            result /= count;
        }
        System.out.printf("[ФОН] Середня сума цифр: %.2f%n", result);
        progress = false; 
    }
}