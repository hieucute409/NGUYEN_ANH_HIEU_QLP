import java.util.ArrayList;
import java.util.List;

public class PhongChieu {
    private String maPhong;
    private boolean loaiPhong; // true: IMAX, false: Thường
    private List<Ghe> danhSachGhe;
    
    // Constructors
    public PhongChieu() {
        this.danhSachGhe = new ArrayList<>();
    }
    
    public PhongChieu(String maPhong, boolean loaiPhong) {
        this();
        this.maPhong = maPhong;
        this.loaiPhong = loaiPhong;
    }
    
    // Getter và Setter
    public String getMaPhong() { return maPhong; }
    public void setMaPhong(String maPhong) { this.maPhong = maPhong; }
    
    public boolean isLoaiPhong() { return loaiPhong; }
    public void setLoaiPhong(boolean loaiPhong) { this.loaiPhong = loaiPhong; }
    
    public List<Ghe> getDanhSachGhe() { return danhSachGhe; }
    public void setDanhSachGhe(List<Ghe> danhSachGhe) { this.danhSachGhe = danhSachGhe; }
    
    // Phương thức thêm ghế
    public void themGhe(Ghe ghe) {
        danhSachGhe.add(ghe);
    }
    
    @Override
    public String toString() {
        return String.format("Mã phòng: %s, Loại phòng: %s, Số ghế: %d",
                maPhong, loaiPhong ? "IMAX" : "Thường", danhSachGhe.size());
    }
}