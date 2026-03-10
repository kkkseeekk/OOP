package ex04;

import ex02.View;

/** Консольна команда збереження результатів у файл */
public class SaveConsoleCommand implements ConsoleCommand {
    private View view;

    public SaveConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() { return 's'; }

    @Override
    public String toString() { return "'s'ave"; }

    @Override
    public void execute() {
        try {
            System.out.println("Збереження даних...");
            view.viewSave();
        } catch (Exception e) {
            System.err.println("Помилка збереження: " + e.getMessage());
        }
    }
}