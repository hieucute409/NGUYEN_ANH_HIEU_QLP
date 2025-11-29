import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyphim implements ReadWrite {
    private List<Phim> danhSachPhim;
    
    public QuanLyphim() {
        this.danhSachPhim = new ArrayList<>();
    }
    
    // Getter và Setter
    public List<Phim> getDanhSachPhim() { return danhSachPhim; }
    public void setDanhSachPhim(List<Phim> danhSachPhim) { this.danhSachPhim = danhSachPhim; }
    
    // Thêm phim
    public void themPhim(Phim phim) {
        if (timPhim(phim.getID()) == null) {
            danhSachPhim.add(phim);
            System.out.println("Thêm phim thành công!");
        } else {
            System.out.println("Lỗi: ID phim đã tồn tại!");
        }
    }
    
    // Tìm phim theo ID
    public Phim timPhim(String id) {
        for (Phim phim : danhSachPhim) {
            if (phim.getID().equals(id)) {
                return phim;
            }
        }
        return null;
    }
    
    // Sửa phim
    public Phim suaPhim(String id) {
        Phim phim = timPhim(id);
        if (phim != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập thông tin mới cho phim:");
            
            System.out.print("Tên phim: ");
            phim.setTenPhim(scanner.nextLine());
            
            System.out.print("Thể loại: ");
            phim.setTheLoai(scanner.nextLine());
            
            System.out.print("Thời lượng (phút): ");
            phim.setThoiLuong(scanner.nextInt());
            
            System.out.print("Giá cơ bản: ");
            phim.setGiaCoBan(scanner.nextDouble());
            
            System.out.println("Sửa phim thành công!");
            return phim;
        }
        System.out.println("Không tìm thấy phim với ID: " + id);
        return null;
    }
    
    
    // Xóa phim
    public void xoaPhim(String id) {
        Phim phim = timPhim(id);
        if (phim != null) {
            danhSachPhim.remove(phim);
            System.out.println("Xóa phim thành công!");
        } else {
            System.out.println("Không tìm thấy phim với ID: " + id);
        }
    }
    
    // Hiển thị danh sách phim
    public void hienThi() {
        System.out.println("\n=== DANH SÁCH PHIM ===");
        if (danhSachPhim.isEmpty()) {
            System.out.println("Danh sách phim trống!");
            return;
        }
        
        for (int i = 0; i < danhSachPhim.size(); i++) {
            System.out.println((i + 1) + ". " + danhSachPhim.get(i));
        }
    }
    
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
                        
                        // Tạo phim tạm thời (trong thực tế cần phân biệt loại phim)
                        Phim phim = new PhimTreEm(id, tenPhim, theLoai, thoiLuong, giaCoBan, false, false);
                        danhSachPhim.add(phim);
                    }
                }
            }
            System.out.println("Đọc file thành công! Số lượng phim: " + danhSachPhim.size());
        } catch (FileNotFoundException e) {
            System.out.println("File phim.txt không tồn tại!");
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
            System.out.println("Ghi file thành công! Số lượng phim: " + danhSachPhim.size());
        }
    }
}