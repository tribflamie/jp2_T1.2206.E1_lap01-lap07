/*
6. Tạo java main class TestCustomer, trong package app, có menu để test chương trình
 */
package app;

import basic.*;
import java.util.Scanner;

public class TestCustomer {

    public static void main(String[] args) {
        TestCustomer m = new TestCustomer();
        m.menu();
    }
    
    CustomerList c = new CustomerList();

    private void menu() {
        Scanner sc = new Scanner(System.in);
        String op = "";
        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Them khach hang.");
            System.out.println("2. In danh sach khach hang.");
            System.out.println("3. Tim kiem khach hang theo ten.");
            System.out.println("4. Thoat.");
            System.out.println("================");
            System.out.print("Chon ma chuc nang tu [1-4]: ");
            op = sc.nextLine().trim();
            switch (op) {
                case "1":
                    c.add();
                    break;
                case "2":
                    c.displayAll();
                    break;
                case "3":
                    System.out.print("Nhap ten muon tim: ");
                    String sname = sc.nextLine().trim();
                    c.searchByName(sname);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Loi sai: Nhap sai ma chuc nang! Vui long nhap lai...");
            }
        }
    }
}
