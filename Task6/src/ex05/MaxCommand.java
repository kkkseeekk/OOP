package ex05;

import ex01.Item2d;
import ex02.View;
import ex04.Command;

public class MaxCommand implements Command {
    private View view;
    private double result = -1.0;
    private boolean progress = false; 

    public MaxCommand(View view) {
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
        return "Max Sum of Digits";
    }

    @Override
    public void execute() {
        progress = true; 
        result = -1.0;
        for (Item2d item : view.getItems()) {
            if (item.getY() > result) {
                result = item.getY();
            }
        }
        System.out.printf("[ФОН] Максимальна сума цифр: %.0f%n", result);
        progress = false; 
    }
}