package ex04;

import ex02.View;

/** Консольна команда відображення даних */
public class ViewConsoleCommand implements ConsoleCommand {
    private View view;

    public ViewConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() { return 'v'; }

    @Override
    public String toString() { return "'v'iew"; }

    @Override
    public void execute() {
        view.viewShow();
    }

    @Override
    public String getName() {
        return "View data";
    }
}