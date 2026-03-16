package ex05;

import java.util.Vector;
import ex04.Command;

public class CommandQueue implements Runnable {
    private Vector<Command> tasks = new Vector<>();
    private boolean shutdown = false;

    public synchronized void put(Command task) {
        tasks.add(task);
        notifyAll();
    }

    public synchronized Command take() {
        while (tasks.isEmpty() && !shutdown) {
            try {
                wait();
            } catch (InterruptedException e) {
                return null;
            }
        }
        return tasks.isEmpty() ? null : tasks.remove(0);
    }

    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }

    @Override
    public void run() {
        while (!shutdown) {
            Command task = take();
            if (task != null) {
                task.execute();
            }
        }
    }
}