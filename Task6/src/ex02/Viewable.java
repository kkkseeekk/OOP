package ex02;

/** Інтерфейс для створення об'єктів відображення (патерн Factory Method) */
public interface Viewable {
    /** Створює об'єкт, що реалізує інтерфейс View */
    public View getView();
}