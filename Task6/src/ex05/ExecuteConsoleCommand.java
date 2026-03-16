package ex05;

import ex02.View;
import ex04.Command;
import ex04.ConsoleCommand;

/** Команда для виконання паралельних обчислень */
public class ExecuteConsoleCommand implements Command, ConsoleCommand {
    private View view;
    private CommandQueue queue;

    public ExecuteConsoleCommand(View view, CommandQueue queue) {
        this.view = view;
        this.queue = queue;
    }

    @Override
    public char getKey() {
        return 'e'; // Клавіша 'e' для запуску з меню
    }

    @Override
    public String getName() {
        return "Execute (Parallel)";
    }

    @Override
    public void execute() {
        queue.put(new MaxCommand(view));
        queue.put(new AvgCommand(view));
        queue.put(new MinMaxCommand(view));
        System.out.println("Завдання відправлені в чергу на фонове виконання.");
    }
    
    @Override
    public String toString() {
        return "'e'xecute (parallel)";
    }
}