import menu.OperationMenu;
import utility.InputGetter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice = -1;

        do{
            System.out.println("Chuong trinh quan ly danh ba");
            System.out.println("1. Xem danh sach");
            System.out.println("2. Them moi");
            System.out.println("3. Cap nhat");
            System.out.println("4. Xoa");
            System.out.println("5. Tim kiem");
            System.out.println("6. Doc tu file");
            System.out.println("7. Ghi vao file");
            System.out.println("8. Thoat");
            System.out.print("Chon chuc nang: ");

            choice = InputGetter.getInstance().getInt();

            switch (choice){
                case 1:
                    OperationMenu.getInstance().viewMenu(1);
                    break;
                case 2:
                    OperationMenu.getInstance().addMenu();
                    break;
                case 3:
                    OperationMenu.getInstance().updateMenu();
                    break;
                case 4:
                    OperationMenu.getInstance().deleteMenu();
                    break;
                case 5:
                    OperationMenu.getInstance().findMenu();
                    break;
                case 6:
                    OperationMenu.getInstance().readFileMenu();
                    break;
                case 7:
                    OperationMenu.getInstance().writeFile();
                    break;
                default:
                    break;
            }
        }
        while(choice != 8);
    }
}