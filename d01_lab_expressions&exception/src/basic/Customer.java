/*
a. Các fields dữ liệu:
- String id, name, phone, address.
- int yob.
b. Các contructors để khởi tạo giá trị ban đầu cho các field dữ liệu.
c. Method void input() : nhập và kiểm tra thông tin chi tiết cho khách hàng :
- id : Cxxxx với x là ký số.
- name : ít nhất 2 ký tự chữ từ A-Z.
- phone : từ 3 đến 10 ký số 0-9.
- yob: từ 6 – 100 tuổi.
 */
package basic;

import java.time.Year;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {

    /*
        Khai bao cac fields du lieu:
        -   String id, name, phone, address
        -   int yob
     */
    public String id, name, phone, address;
    public int yob;
    
    //Ham dung co tham so;
    public Customer() {
        id = "string";
        name = "string";
        phone = "xxxx-xxxx-xxx";
        address = "longstring";
        yob = 9999;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);

        //1. id: Cxxxx với x là ký số
        Pattern p1 = Pattern.compile("C\\d{4}");
        Matcher m1 = null;
        while (true) {
            try {
                System.out.print("nhap id: ");
                id = sc.nextLine().trim();
                m1 = p1.matcher(id);
                //thực hiện so khớp
                if (m1.matches()) {
                    break;
                } else {
                    throw new InvalidDataException("ID phai co dang Cxxxx, voi x la 1 ky so...");
                }
            } catch (Exception e) {
                System.out.println("Loi sai: " + e.getMessage());
            }
        }

        //2. name: ít nhất 2 ký tự chữ từ A-Z
        p1 = Pattern.compile("[a-z A-Z]{2,}"); //khởi tạo lại pattern cũ
        m1 = null;

        while (true) {
            try {
                System.out.print("nhap ten khach hang: ");
                name = sc.nextLine().trim();
                m1 = p1.matcher(name); //khởi tạo m1 so sánh với name
                //thực hiện so khớp
                if (m1.matches()) {
                    break;
                } else {
                    throw new InvalidDataException("Ten phai it nhat 2 ky tu chu A-Z...");
                }
            } catch (Exception e) {
                System.out.println("Loi sai: " + e.getMessage());
            }
        }

        //3. phone : từ 3 đến 10 ký số 0-9
        p1 = Pattern.compile("\\d{3,10}");
        m1 = null;
        while (true) {
            try {
                System.out.print("nhap so dien thoai: ");
                phone = sc.nextLine().trim();
                m1 = p1.matcher(phone);
                //thực hiện so khớp
                if (m1.matches()) {
                    break;
                } else {
                    throw new InvalidDataException("so dien thoai co tu [3-10] ky so...");
                }
            } catch (Exception e) {
                System.out.println("Loi sai: " + e.getMessage());
            }
        }

        //4. address
        System.out.print("nhap dia chi: ");
        address = sc.nextLine().trim();

        //5. yob: từ 6 – 100 tuổi.
        while (true) {
            try {
                System.out.print("nhap nam sinh: ");
                yob = Integer.parseInt(sc.nextLine().trim());
                //thực hiện so khớp
                if (tuoi()>=6&&tuoi()<=100) {
                    break;
                } else {
                    throw new InvalidDataException("Nam sinh khong hop le. Tuoi phai tu [6-100]...");
                }
            } catch (Exception e) {
                System.out.println("Loi sai: " + e.getMessage());
            }
        }
    }
    
    public int tuoi(){
        int namHienTai = Year.now().getValue();
        return namHienTai - yob;
    }
    
    public String standardlizeAddress(){
        return address.replaceAll("(Q.|q.)", "Quan ");
    }
    
    @Override 
    public String toString(){
        return String.format("%s - %s - %s - %s - %d", id, name, standardlizeAddress(), phone, tuoi());
    }
}
