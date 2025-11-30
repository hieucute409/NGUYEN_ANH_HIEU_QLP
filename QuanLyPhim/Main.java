
public class Main {
    public static void main(String[] args) {
        QuanLyphim qlPhim = new QuanLyphim();
        
        try {
            // Tạo dữ liệu mẫu
            qlPhim.khoiTaoDuLieuMau();
            
            // Chạy menu quản lý
            qlPhim.menuQuanLy();
            
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}