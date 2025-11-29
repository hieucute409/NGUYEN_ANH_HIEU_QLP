public class Ghe {
    private String soGhe;
    private boolean loaiGhe; // true: VIP, false: Thường
    
    // Constructors
    public Ghe() {}
    
    public Ghe(String soGhe, boolean loaiGhe) {
        this.soGhe = soGhe;
        this.loaiGhe = loaiGhe;
    }
    
    // Getter và Setter
    public String getSoGhe() { return soGhe; }
    public void setSoGhe(String soGhe) { this.soGhe = soGhe; }
    
    public boolean isLoaiGhe() { return loaiGhe; }
    public void setLoaiGhe(boolean loaiGhe) { this.loaiGhe = loaiGhe; }
    
    @Override
    public String toString() {
        return String.format("Số ghế: %s, Loại: %s", soGhe, loaiGhe ? "VIP" : "Thường");
    }
}