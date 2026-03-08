package ex03;

import ex02.ViewableResult;
import ex02.View;

/** Реалізує фабричний метод для створення ViewTable */
public class ViewableTable extends ViewableResult {
    @Override
    public View getView() {
        return new ViewTable();
    }
}