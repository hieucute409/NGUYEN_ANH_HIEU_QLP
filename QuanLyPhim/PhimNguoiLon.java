public class PhimNguoiLon extends Phim {
    private int tuoiToiThieu;
    
    // Constructors
    public PhimNguoiLon() {}
    
    public PhimNguoiLon(String ID, String tenPhim, String theLoai, int thoiLuong, 
                        double giaCoBan, int tuoiToiThieu) {
        super(ID, tenPhim, theLoai, thoiLuong, giaCoBan);
        this.tuoiToiThieu = tuoiToiThieu;
    }
    
    // Getter và Setter
    public int getTuoiToiThieu() { return tuoiToiThieu; }
    public void setTuoiToiThieu(int tuoiToiThieu) { this.tuoiToiThieu = tuoiToiThieu; }
    
    @Override
    public boolean kiemTraDoTuoi() {
        return tuoiToiThieu >= 18; // Kiểm tra tuổi tối thiểu
    }
    
    @Override
    public double tinhGiaBanPhim() {
        return giaCoBan * 1.1; // Tăng 10% cho phim người lớn
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(", Tuổi tối thiểu: %d, Giá bán: %.2f",
                tuoiToiThieu, tinhGiaBanPhim());
    }
}