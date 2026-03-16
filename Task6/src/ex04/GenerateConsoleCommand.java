package ex04;

import ex02.View;

public class GenerateConsoleCommand implements ConsoleCommand {
    private View view;

    public GenerateConsoleCommand(View view) { // Приймаємо відразу View
        this.view = view;
    }

    @Override
    public char getKey() { return 'g'; }

    @Override
    public String toString() { return "'g'enerate"; }

    @Override
    public void execute() {
        System.out.println("Випадкова генерація даних.");
        view.viewInit();
        view.viewShow();
    }

    @Override
    public String getName() {
        return "Generate data";
    }
}