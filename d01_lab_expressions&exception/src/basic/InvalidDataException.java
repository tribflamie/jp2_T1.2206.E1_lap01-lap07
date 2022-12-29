/*
Cửa hàng kinh doanh bánh ngọt muốn xây dựng một chương trình quản lý thông tin khách hàng, bao
gồm các chức năng:
1. Thêm khách hàng mới
2. Liệt kê danh sách khách hàng
3. Tìm kiếm khách hàng theo tên
4. Thoát
 */
package basic;

public class InvalidDataException extends Exception {
    public InvalidDataException(){
        super("Loi sai nhap lieu...");
    }
    
    public InvalidDataException(String thongbaoLoi){
        super(thongbaoLoi);
    }
}
