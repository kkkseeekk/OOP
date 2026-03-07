package ex02;

/** Клас-фабрика для створення об'єкта ViewResult */
public class ViewableResult implements Viewable {
    @Override
    public View getView() {
        return new ViewResult();
    }
}