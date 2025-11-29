import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        QuanLyphim qlPhim = new QuanLyphim();
        
        try {
            // Tạo dữ liệu mẫu
            PhimTreEm phimTreEm = new PhimTreEm("P001", "Doremon", "Hoạt hình", 90, 50000, true, true);
            PhimNguoiLon phimNguoiLon = new PhimNguoiLon("P002", "Matrix", "Hành động", 120, 80000, 18);
            
            qlPhim.themPhim(phimTreEm);
            qlPhim.themPhim(phimNguoiLon);
            
            // Hiển thị danh sách
            qlPhim.hienThi();
            
            // Test các phương thức
            System.out.println("\n=== KIỂM TRA ĐỘ TUỔI ===");
            for (Phim phim : qlPhim.getDanhSachPhim()) {
                System.out.println(phim.getTenPhim() + " - Phù hợp: " + phim.kiemTraDoTuoi());
            }
            
            // Ghi và đọc file
            qlPhim.writeFile();
            qlPhim.readFile();
            
        } 
        catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        
    }
}