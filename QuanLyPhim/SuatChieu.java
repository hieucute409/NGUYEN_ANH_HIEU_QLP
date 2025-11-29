import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SuatChieu {
    private Phim phim;
    private PhongChieu phongChieu;
    private List<LocalDateTime> ngayChieu;
    
    // Constructors
    public SuatChieu() {
        this.ngayChieu = new ArrayList<>();
    }
    
    public SuatChieu(Phim phim, PhongChieu phongChieu) {
        this();
        this.phim = phim;
        this.phongChieu = phongChieu;
    }
    
    // Getter và Setter
    public Phim getPhim() { return phim; }
    public void setPhim(Phim phim) { this.phim = phim; }
    
    public PhongChieu getPhongChieu() { return phongChieu; }
    public void setPhongChieu(PhongChieu phongChieu) { this.phongChieu = phongChieu; }
    
    public List<LocalDateTime> getNgayChieu() { return ngayChieu; }
    public void setNgayChieu(List<LocalDateTime> ngayChieu) { this.ngayChieu = ngayChieu; }
    
    // Phương thức thêm ngày chiếu
    public void themNgayChieu(LocalDateTime ngayChieu) {
        this.ngayChieu.add(ngayChieu);
    }
    
    @Override
    public String toString() {
        return String.format("Phim: %s, Phòng: %s, Số suất chiếu: %d",
                phim.getTenPhim(), phongChieu.getMaPhong(), ngayChieu.size());
    }
}