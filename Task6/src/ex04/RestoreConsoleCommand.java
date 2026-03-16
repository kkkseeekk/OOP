package ex04;

import ex02.View;

public class RestoreConsoleCommand implements ConsoleCommand {
    private View view;

    public RestoreConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() { return 'r'; }

    @Override
    public String toString() { return "'r'estore"; }

    @Override
    public void execute() {
        try {
            System.out.println("Відновлення даних...");
            view.viewRestore();
            view.viewShow();
        } catch (Exception e) {
            System.err.println("Помилка відновлення: " + e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "Restore data";
    }
}