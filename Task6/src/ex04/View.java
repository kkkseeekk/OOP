package ex04;

import java.util.List;
import ex01.Item2d;

/** Інтерфейс для доступу до даних */
public interface View {
    void viewInit();
    void show();
    List<Item2d> getItems();
}