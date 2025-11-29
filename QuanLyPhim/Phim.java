public abstract class Phim {
    protected String ID;
    protected String tenPhim;
    protected String theLoai;
    protected int thoiLuong;
    protected double giaCoBan;
    
    // Constructors
    public Phim() {}
    
    public Phim(String ID, String tenPhim, String theLoai, int thoiLuong, double giaCoBan) {
        this.ID = ID;
        this.tenPhim = tenPhim;
        this.theLoai = theLoai;
        this.thoiLuong = thoiLuong;
        this.giaCoBan = giaCoBan;
    }
    
    // Getter và Setter
    public String getID() { return ID; }
    public void setID(String ID) { this.ID = ID; }
    
    public String getTenPhim() { return tenPhim; }
    public void setTenPhim(String tenPhim) { this.tenPhim = tenPhim; }
    
    public String getTheLoai() { return theLoai; }
    public void setTheLoai(String theLoai) { this.theLoai = theLoai; }
    
    public int getThoiLuong() { return thoiLuong; }
    public void setThoiLuong(int thoiLuong) { this.thoiLuong = thoiLuong; }
    
    public double getGiaCoBan() { return giaCoBan; }
    public void setGiaCoBan(double giaCoBan) { this.giaCoBan = giaCoBan; }
    
    // Abstract methods
    public abstract boolean kiemTraDoTuoi();
    public abstract double tinhGiaBanPhim();
    
    @Override
    public String toString() {
        return String.format("ID: %s, Tên: %s, Thể loại: %s, Thời lượng: %d phút, Giá cơ bản: %.2f",
                ID, tenPhim, theLoai, thoiLuong, giaCoBan);
    }
}