package carsharing.ui;

public interface ModelUI {
    void modelMenuShow(String nameModel); // показ списка операций
    void modelMenuProcess();// обработка выбора пользователя
    void addModel(); // добавление модели
    void modelsListMenuShow(); // показ списка моделей
    void modelsListMenuProcess(); // обработка выбора пользователя
}
