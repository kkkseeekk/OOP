package ex05;

import ex01.Item2d;
import ex02.View;
import ex04.Command;

public class MinMaxCommand implements Command {
    private View view;
    private double minRes = 100.0; 
    private double maxRes = -1.0;
    private boolean progress = false; 

    public MinMaxCommand(View view) {
        this.view = view;
    }

    public double getResultMin() { return minRes; }
    public double getResultMax() { return maxRes; }

    public boolean running() {
        return progress;
    }

    @Override
    public String getName() {
        return "Min/Max Sum of Digits";
    }

    @Override
    public void execute() {
        progress = true; 
        // Скидаємо значення перед кожним розрахунком
        minRes = 100.0;
        maxRes = -1.0;
        
        for (Item2d item : view.getItems()) {
            if (item.getY() < minRes) minRes = item.getY();
            if (item.getY() > maxRes) maxRes = item.getY();
        }
        System.out.printf("[ФОН] Min: %.0f, Max: %.0f%n", minRes, maxRes);
        progress = false; 
    }
}