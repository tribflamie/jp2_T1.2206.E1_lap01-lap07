/*
5. Tạo class CustomerList , trong package basic, quản lý danh sách khách hàng bao gồm :
a. Các fields dữ liệu:
int max, next để lưu kích thước mảng, và sô lượng khách hàng lưu trữ trong hệ thống.
Customer[] cList để lưu danh sách khách hàng.
c. Method :
1. void add () : thêm 1 khách hàng vô danh sách cList.
2. void displayAll() : In toàn bộ danh sách khách hàng ra màn hình.
3. void searchByName(String name) : Tìm và in ra ds các khách hàng có tên chứa trong đối số
name
*/
package basic;

import java.util.Scanner;

public class CustomerList {
    int max=10, next=0;
    Customer[] cList = new Customer[max];
    
    public void add(){
        if(next==max){
            System.out.println("Loi sai: Het dung luong he thong...");
            return;
        }
        
        Customer c = new Customer();
        c.input();
        cList[next++] = c;
    }
    
    public void displayAll(){
        if (next == 0) {
            System.out.println("Loi sai: Khong co du lieu trong he thong...");
            return;
        }

        System.out.println("\n=== Danh sach khach hang ===");
        for (int i = 0; i < next; i++) {
            System.out.println(cList[i]);
        }
    }
    
    public void searchByName(String sname){
        if (next == 0) {
            System.out.println("Loi sai: Khong co du lieu trong he thong...");
            return;
        }
        System.out.printf("Tim kiem khach hang theo ten [%s]\n", sname);
        int cnt = 0;
        for (int i = 0; i < next; i++) {
            if (cList[i].name.contains(sname)) {
                System.out.println(cList[i]);
                cnt++;
            }
        }
        if (cnt == 0) {
            System.out.println("Loi sai: Khong tim thay khach hang...");
        }
    }
}
