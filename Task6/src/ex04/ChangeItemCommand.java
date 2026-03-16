package ex04;

import ex01.Item2d;

/** Команда для зміни елемента з підтримкою скасування (Undo) */
public class ChangeItemCommand implements Command {
    private Item2d item;
    private double oldResult;
    private double newResult;

    public Item2d getItem() { return item; }
    public void setItem(Item2d item) { this.item = item; }

    /** Встановлює нове значення */
    public void setOffset(double offset) {
        this.newResult = item.getY() * offset;
    }

    @Override
    public void execute() {
        oldResult = item.getY();
        item.setY(newResult);
    }

    /** Повертає попередній стан даних */
    public void undo() {
        item.setY(oldResult);
    }
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }
}