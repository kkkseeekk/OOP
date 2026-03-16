package ex02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import ex01.Item2d;

public class ViewResult implements View {
    private static final String FILE_NAME = "items.bin";
    private ArrayList<Item2d> items = new ArrayList<>();
    private int count = 10; 

    public ViewResult() { }

    public ViewResult(int n) {
        this.count = n;
    }

    @Override
    public List<Item2d> getItems() {
        return items;
    }

    @Override
    public void viewHeader() {
        System.out.println("Результати обчислень (Варіант 8)");
    }

    @Override
    public void viewBody() {
        for (Item2d item : items) {
            System.out.printf("X: %.0f | Сума цифр (Y): %.0f\n", item.getX(), item.getY());
        }
    }

    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        System.out.println("Кінець списку.");
    }

    @Override
    public void viewInit() {
        items.clear(); 
        for (int i = 0; i < count; i++) {
            double x = i;
            double y = Math.round(Math.random() * 27); 
            // ВАЖЛИВО: передаємо x та y в конструктор
            items.add(new Item2d(x, y));
        }
    }

    @Override
    public void viewSave() throws IOException {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            os.writeObject(items);
            System.out.println("Дані збережені.");
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void viewRestore() throws Exception {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            items = (ArrayList<Item2d>) is.readObject();
            System.out.println("Дані відновлені.");
        }
    }

    @Override public void viewFooter() { }
    @Override public List<Item2d> getItems1() { return items; }
}