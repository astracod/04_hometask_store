package com.company.store;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/*твоя следующая задача сделать консольный магазин со следующим функционалом
    (Реализовать меню)
    1. Просмотр списка товаров
    2. Просмотр подробной информации о товаре по его коду
    3. Добавление товара в корзину по его коду
    4. Удаление товара из корзины
    5. Просмотр товаров в корзине
    6. Изменение количества товаров в корзине
    7. Формирование заказа (крассивый выывод содержимого корзины с заголовком (номер заказа) и итоговой суммой, после чего корзина очищается)
*/

    /*Переделать меню
    Создать интерфейс MenuAction (пункт меню)
    2 метода: getActionName (получить имя пункта) и execute(выполнить)

    Создать отдельные классы выполняющие каждое отдельное действие пункта меню

    В классе меню создать массив  пунктов(Vector<MenuAction>),
    для вывода меню использовать цикл с выводом имени пункта меню и его номера (индекс массива+1)
    При обработке пункта меню доставать из массива элемент по индексу и выполнять execute
    (таким образом огромный if больше не нужен)*/


public class Menu {

    private MyStore store;
    private Scanner scanner;
    private PrintStream out;
    private Vector<MenuAction> getActionName;


    public Menu() {
    }

    /*  MenuAction show = new ShowNomenclature( store);
            getActionName.addInArray(show);
    заменить на
    getActionName.addInArray(new ShowNomenclature( store));*/
    public Menu(InputStream input, PrintStream out) {
        this.store = new MyStore();
        this.getActionName = new Vector<>();
        this.scanner = new Scanner(input);
        this.out = out;
        getActionName.addInArray(new ShowNomenclature(store));
        getActionName.addInArray(new ShowProductByArticle(input, out, store));
        getActionName.addInArray(new AddProductByArticle(input, out, store));
        getActionName.addInArray(new DeleteProductFromCart(input, out, store));
        getActionName.addInArray(new ShowCart(input, out, store));
        getActionName.addInArray(new ChangeQuantityOnProduct(input, out, store));
        getActionName.addInArray(new Score(input, out, store));
    }

    public boolean showMenu() throws IOException {
        for (int i = 0; i < getActionName.getSize(); i++) {
            out.println((i + 1) + " -> " + getActionName.getIndex(i).getActionName());
        }
        int answer = Integer.parseInt(scanner.nextLine());
        answerMenu(answer);
        return answer != 7;
    }

    public void answerMenu(int answer) throws IOException {
        if (answer <= 0 || answer >= 8) {
            out.println(" Введите корректную дерективу.");
        } else {
            MenuAction action = getActionName.getIndex(answer - 1);
            action.execute(this);
        }
    }
}
