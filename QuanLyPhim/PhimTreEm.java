public class PhimTreEm extends Phim {
    private boolean phuDeTA;
    private boolean noiDungGiaoDuc;
    
    public PhimTreEm() {}
    
    public PhimTreEm(String ID, String tenPhim, String theLoai, int thoiLuong, 
                     double giaCoBan, boolean phuDeTA, boolean noiDungGiaoDuc) {
        super(ID, tenPhim, theLoai, thoiLuong, giaCoBan);
        this.phuDeTA = phuDeTA;
        this.noiDungGiaoDuc = noiDungGiaoDuc;
    }
    
    // Getter và Setter
    public boolean isPhuDeTA() { return phuDeTA; }
    public void setPhuDeTA(boolean phuDeTA) { this.phuDeTA = phuDeTA; }
    
    public boolean isNoiDungGiaoDuc() { return noiDungGiaoDuc; }
    public void setNoiDungGiaoDuc(boolean noiDungGiaoDuc) { this.noiDungGiaoDuc = noiDungGiaoDuc; }
    
    @Override
    public boolean kiemTraDoTuoi() {
        return true; // Phim trẻ em phù hợp với mọi lứa tuổi
    }
    
    @Override
    public double tinhGiaBanPhim() {
        double giaBan = giaCoBan;
        if (noiDungGiaoDuc) {
            giaBan *= 0.9; // Giảm 10% cho phim có nội dung giáo dục
        }
        return giaBan;
    }
    
    @Override
    public String toString() {
        return "PhimTreEm{" +
                "ID='" + ID + '\'' +
                ", tenPhim='" + tenPhim + '\'' +
                ", theLoai='" + theLoai + '\'' +
                ", thoiLuong=" + thoiLuong +
                ", giaCoBan=" + giaCoBan +
                ", phuDeTA=" + phuDeTA +
                ", noiDungGiaoDuc=" + noiDungGiaoDuc +
                '}';
    }
}