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

    public Menu(InputStream input, PrintStream out) {
        this.store = new MyStore();
        this.getActionName = new Vector<>();
        this.scanner = new Scanner(input);
        this.out = out;
        MenuAction show = new ShowNomenclature();
        getActionName.addInArray(show);
        MenuAction show2 =  new ShowProductByArticle(input,out);
        getActionName.addInArray(show2);
        MenuAction show3 = new AddProductByArticle(input,out);
        getActionName.addInArray(show3);
        MenuAction show4 = new DeleteProductFromCart(input,out);
        getActionName.addInArray(show4);
        MenuAction show5 = new ShowCart(input, out);
        getActionName.addInArray(show5);
        MenuAction show6 = new ChangeQuantityOnProduct(input, out);
        getActionName.addInArray(show6);
        MenuAction show7 = new Score(input, out);
        getActionName.addInArray(show7);
    }

    public boolean showMenu() throws IOException, ClassNotFoundException {
        out.println("    1. Просмотр списка товаров\n" +
                "    2. Просмотр подробной информации о товаре по его коду\n" +
                "    3. Добавление товара в корзину по его коду\n" +
                "    4. Удаление товара из корзины\n" +
                "    5. Просмотр товаров в корзине\n" +
                "    6. Изменение количества товаров в корзине\n" +
                "    7. Формирование заказа "
        );
        int answer = Integer.parseInt(scanner.nextLine());
//        responseToRequest(answer);
        answerMenu(answer);
        return answer != 7;
    }

    public void answerMenu(int answer) throws IOException {
/*   Остаточное состояние : почему дублируется цифра при выводе и строка первого запроса ->
    2
    Просмотр списка товаров
    Просмотр подробной информации о товаре по его коду
    */

        for (int i = 0; i < getActionName.getSize(); i++) {
            if (answer == getActionName.getIndex(i).getActionName(i)) {
                getActionName.getIndex(i).execute(this);
            }
        }
    }

    /*public void responseToRequest(int answer) throws IOException, ClassNotFoundException {
        if (answer == 1) {
            store.showNomenclature();
        }
        if (answer == 2) {
            System.out.println(" Введите артикль товара :");
            int a = Integer.parseInt(scanner.nextLine());
            store.showProductByArticle(a);
        }
        if (answer == 3) {
            System.out.println(" Введите артикль товара :");
            int a = Integer.parseInt(scanner.nextLine());
            System.out.println(" Введите количество товара :");
            int b = Integer.parseInt(scanner.nextLine());
            store.addProductByArticle(a, b);
        }
        if (answer == 4) {
            System.out.println(" Введите артикль товара :");
            int a = Integer.parseInt(scanner.nextLine());
            store.deleteProductFromCart(a);
        }
        if (answer == 5) {
            store.showCart();
        }
        if (answer == 6) {
            System.out.println(" Введите артикль товара :");
            int a = Integer.parseInt(scanner.nextLine());
            System.out.println(" Введите количество товара :");
            int b = Integer.parseInt(scanner.nextLine());
            store.changeQuantityOnProduct(a, b);
        }
        if (answer == 7){
            store.score();
            store.emptyTheCart();
            System.out.println(" Всего доброго!!!");
        }
    }*/
}
