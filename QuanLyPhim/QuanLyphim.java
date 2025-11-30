import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyphim implements ReadWrite {
    private List<Phim> danhSachPhim;
    private Scanner scanner;
    
    public QuanLyphim() {
        this.danhSachPhim = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    
    // Getter và Setter
    public List<Phim> getDanhSachPhim() { return danhSachPhim; }
    public void setDanhSachPhim(List<Phim> danhSachPhim) { this.danhSachPhim = danhSachPhim; }
    
    // ========== THÊM PHIM ==========
    public void themPhim() {
        System.out.println("\n=== THÊM PHIM MỚI ===");
        System.out.println("1. Phim Trẻ Em");
        System.out.println("2. Phim Người Lớn");
        System.out.print("Chọn loại phim: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        
        System.out.print("Nhập ID phim: ");
        String id = scanner.nextLine();
        
        // Kiểm tra trùng ID
        if (timPhim(id) != null) {
            System.out.println("Lỗi: ID phim đã tồn tại!");
            return;
        }
        
        System.out.print("Nhập tên phim: ");
        String tenPhim = scanner.nextLine();
        
        System.out.print("Nhập thể loại: ");
        String theLoai = scanner.nextLine();
        
        System.out.print("Nhập thời lượng (phút): ");
        int thoiLuong = scanner.nextInt();
        
        System.out.print("Nhập giá cơ bản: ");
        double giaCoBan = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer
        
        if (choice == 1) {
            // Thêm phim trẻ em
            System.out.print("Có phụ đề tiếng Anh? (true/false): ");
            boolean phuDeTA = scanner.nextBoolean();
            
            System.out.print("Có nội dung giáo dục? (true/false): ");
            boolean noiDungGiaoDuc = scanner.nextBoolean();
            
            PhimTreEm phimTreEm = new PhimTreEm(id, tenPhim, theLoai, thoiLuong, giaCoBan, phuDeTA, noiDungGiaoDuc);
            danhSachPhim.add(phimTreEm);
            System.out.println("✅ Thêm phim trẻ em thành công!");
            
        } else if (choice == 2) {
            // Thêm phim người lớn
            System.out.print("Nhập tuổi tối thiểu: ");
            int tuoiToiThieu = scanner.nextInt();
            
            PhimNguoiLon phimNguoiLon = new PhimNguoiLon(id, tenPhim, theLoai, thoiLuong, giaCoBan, tuoiToiThieu);
            danhSachPhim.add(phimNguoiLon);
            System.out.println("✅ Thêm phim người lớn thành công!");
            
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
    }
    
    // Thêm phim từ đối tượng có sẵn
    public void themPhim(Phim phim) {
        if (timPhim(phim.getID()) == null) {
            danhSachPhim.add(phim);
            System.out.println("✅ Thêm phim thành công!");
        } else {
            System.out.println("❌ Lỗi: ID phim đã tồn tại!");
        }
    }
    
    // ========== TÌM PHIM ==========
    public Phim timPhim(String id) {
        for (Phim phim : danhSachPhim) {
            if (phim.getID().equals(id)) {
                return phim;
            }
        }
        return null;
    }
    
    public void timPhimTheoTen() {
        System.out.print("\nNhập tên phim cần tìm: ");
        String ten = scanner.nextLine();
        boolean found = false;
        
        System.out.println("\n=== KẾT QUẢ TÌM KIẾM ===");
        for (Phim phim : danhSachPhim) {
            if (phim.getTenPhim().toLowerCase().contains(ten.toLowerCase())) {
                System.out.println(phim);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("Không tìm thấy phim với tên: " + ten);
        }
    }
    
    // ========== SỬA PHIM ==========
    public void suaPhim() {
        System.out.print("\nNhập ID phim cần sửa: ");
        String id = scanner.nextLine();
        
        Phim phim = timPhim(id);
        if (phim == null) {
            System.out.println("❌ Không tìm thấy phim với ID: " + id);
            return;
        }
        
        System.out.println("Thông tin phim hiện tại:");
        System.out.println(phim);
        
        System.out.println("\nNhập thông tin mới (ấn Enter để giữ nguyên):");
        
        System.out.print("Tên phim [" + phim.getTenPhim() + "]: ");
        String tenMoi = scanner.nextLine();
        if (!tenMoi.isEmpty()) {
            phim.setTenPhim(tenMoi);
        }
        
        System.out.print("Thể loại [" + phim.getTheLoai() + "]: ");
        String theLoaiMoi = scanner.nextLine();
        if (!theLoaiMoi.isEmpty()) {
            phim.setTheLoai(theLoaiMoi);
        }
        
        System.out.print("Thời lượng [" + phim.getThoiLuong() + "]: ");
        String thoiLuongStr = scanner.nextLine();
        if (!thoiLuongStr.isEmpty()) {
            phim.setThoiLuong(Integer.parseInt(thoiLuongStr));
        }
        
        System.out.print("Giá cơ bản [" + phim.getGiaCoBan() + "]: ");
        String giaStr = scanner.nextLine();
        if (!giaStr.isEmpty()) {
            phim.setGiaCoBan(Double.parseDouble(giaStr));
        }
        
        // Sửa thông tin riêng cho từng loại phim
        if (phim instanceof PhimTreEm) {
            PhimTreEm phimTE = (PhimTreEm) phim;
            System.out.print("Phụ đề TA [" + phimTE.isPhuDeTA() + "] (true/false): ");
            String phuDeStr = scanner.nextLine();
            if (!phuDeStr.isEmpty()) {
                phimTE.setPhuDeTA(Boolean.parseBoolean(phuDeStr));
            }
            
            System.out.print("Nội dung giáo dục [" + phimTE.isNoiDungGiaoDuc() + "] (true/false): ");
            String ndStr = scanner.nextLine();
            if (!ndStr.isEmpty()) {
                phimTE.setNoiDungGiaoDuc(Boolean.parseBoolean(ndStr));
            }
            
        } else if (phim instanceof PhimNguoiLon) {
            PhimNguoiLon phimNL = (PhimNguoiLon) phim;
            System.out.print("Tuổi tối thiểu [" + phimNL.getTuoiToiThieu() + "]: ");
            String tuoiStr = scanner.nextLine();
            if (!tuoiStr.isEmpty()) {
                phimNL.setTuoiToiThieu(Integer.parseInt(tuoiStr));
            }
        }
        
        System.out.println("✅ Sửa phim thành công!");
    }
    
    // Phương thức sửa cũ (giữ lại cho tương thích)
    public Phim suaPhim(String id) {
        Phim phim = timPhim(id);
        if (phim != null) {
            suaPhim(); // Gọi phương thức sửa mới
            return phim;
        }
        return null;
    }
    
    // ========== XÓA PHIM ==========
    public void xoaPhim() {
        System.out.print("\nNhập ID phim cần xóa: ");
        String id = scanner.nextLine();
        
        Phim phim = timPhim(id);
        if (phim == null) {
            System.out.println("❌ Không tìm thấy phim với ID: " + id);
            return;
        }
        
        System.out.println("Thông tin phim sẽ xóa:");
        System.out.println(phim);
        
        System.out.print("Bạn có chắc chắn muốn xóa? (y/n): ");
        String confirm = scanner.nextLine();
        
        if (confirm.equalsIgnoreCase("y")) {
            danhSachPhim.remove(phim);
            System.out.println("✅ Xóa phim thành công!");
        } else {
            System.out.println("Đã hủy thao tác xóa.");
        }
    }
    
    // Phương thức xóa cũ (giữ lại cho tương thích)
    public void xoaPhim(String id) {
        Phim phim = timPhim(id);
        if (phim != null) {
            danhSachPhim.remove(phim);
            System.out.println("✅ Xóa phim thành công!");
        } else {
            System.out.println("❌ Không tìm thấy phim với ID: " + id);
        }
    }
    
    // ========== HIỂN THỊ ==========
    public void hienThi() {
        System.out.println("\n=== DANH SÁCH PHIM ===");
        if (danhSachPhim.isEmpty()) {
            System.out.println("Danh sách phim trống!");
            return;
        }
        
        for (int i = 0; i < danhSachPhim.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + danhSachPhim.get(i));
        }
        System.out.println("Tổng số: " + danhSachPhim.size() + " phim");
    }
    
    public void hienThiTheoLoai() {
        System.out.println("\n=== PHIM TRẺ EM ===");
        int countTE = 0;
        for (Phim phim : danhSachPhim) {
            if (phim instanceof PhimTreEm) {
                System.out.println(phim);
                countTE++;
            }
        }
        if (countTE == 0) System.out.println("Không có phim trẻ em");
        
        System.out.println("\n=== PHIM NGƯỜI LỚN ===");
        int countNL = 0;
        for (Phim phim : danhSachPhim) {
            if (phim instanceof PhimNguoiLon) {
                System.out.println(phim);
                countNL++;
            }
        }
        if (countNL == 0) System.out.println("Không có phim người lớn");
    }
    
    // ========== FILE OPERATIONS ==========
    @Override
    public void readFile() throws IOException {
        danhSachPhim.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("phim.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] parts = line.split(",");
                    if (parts.length >= 5) {
                        String id = parts[0].trim();
                        String tenPhim = parts[1].trim();
                        String theLoai = parts[2].trim();
                        int thoiLuong = Integer.parseInt(parts[3].trim());
                        double giaCoBan = Double.parseDouble(parts[4].trim());
                        
                        // Trong thực tế, cần thêm thông tin để phân biệt loại phim
                        Phim phim = new PhimTreEm(id, tenPhim, theLoai, thoiLuong, giaCoBan, false, false);
                        danhSachPhim.add(phim);
                    }
                }
            }
            System.out.println("✅ Đọc file thành công! Số lượng phim: " + danhSachPhim.size());
        } catch (FileNotFoundException e) {
            System.out.println("⚠️ File phim.txt không tồn tại!");
        }
    }
    
    @Override
    public void writeFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("phim.txt"))) {
            for (Phim phim : danhSachPhim) {
                String line = String.format("%s,%s,%s,%d,%.2f",
                    phim.getID(), phim.getTenPhim(), phim.getTheLoai(),
                    phim.getThoiLuong(), phim.getGiaCoBan());
                writer.write(line);
                writer.newLine();
            }
            System.out.println("✅ Ghi file thành công! Số lượng phim: " + danhSachPhim.size());
        }
    }
    
    // ========== MENU QUẢN LÝ ==========
    public void menuQuanLy() {
        while (true) {
            System.out.println("\n=== MENU QUẢN LÝ PHIM ===");
            System.out.println("1. Thêm phim mới");
            System.out.println("2. Hiển thị danh sách phim");
            System.out.println("3. Tìm phim theo tên");
            System.out.println("4. Sửa thông tin phim");
            System.out.println("5. Xóa phim");
            System.out.println("6. Hiển thị theo loại");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Đọc từ file");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            
            try {
                switch (choice) {
                    case 1:
                        themPhim();
                        break;
                    case 2:
                        hienThi();
                        break;
                    case 3:
                        timPhimTheoTen();
                        break;
                    case 4:
                        suaPhim();
                        break;
                    case 5:
                        xoaPhim();
                        break;
                    case 6:
                        hienThiTheoLoai();
                        break;
                    case 7:
                        writeFile();
                        break;
                    case 8:
                        readFile();
                        break;
                    case 0:
                        System.out.println("👋 Kết thúc chương trình!");
                        return;
                    default:
                        System.out.println("❌ Lựa chọn không hợp lệ!");
                }
            } catch (Exception e) {
                System.out.println("❌ Lỗi: " + e.getMessage());
            }
        }
    }
    
    // ========== TẠO DỮ LIỆU MẪU ==========
    public void khoiTaoDuLieuMau() {
        themPhim(new PhimTreEm("P001", "Doremon", "Hoạt hình", 90, 50000, true, true));
        themPhim(new PhimTreEm("P002", "Pokemon", "Hoạt hình", 85, 45000, false, true));
        themPhim(new PhimNguoiLon("P003", "Matrix", "Hành động", 120, 80000, 18));
        themPhim(new PhimNguoiLon("P004", "Inception", "Khoa học viễn tưởng", 148, 90000, 16));
        System.out.println("✅ Đã tạo dữ liệu mẫu!");
    }
}