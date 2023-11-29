package dev.skyherobrine.app.entities.sale;

import java.time.LocalDate;

/**
 * Thực thể "Khuyến Mãi", thực thể này dùng để lưu trữ thông tin về khuyến mãi, cửa hàng sẽ áp dụng các
 * chương trình khuyến mãi cho các sản phẩm trong cửa hàng.
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class KhuyenMai {
    private String maKM;
    private String tenKM;
    private LocalDate ngayApDung;
    private LocalDate ngayHetHan;

    public KhuyenMai(String maKM, String tenKM, LocalDate ngayApDung, LocalDate ngayHetHan) throws Exception {
        this.setMaKM(maKM);
        this.setTenKM(tenKM);
        this.setNgayApDung(ngayApDung);
        this.setNgayHetHan(ngayHetHan);
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public LocalDate getNgayApDung() {
        return ngayApDung;
    }

    public void setNgayApDung(LocalDate ngayApDung) {
        this.ngayApDung = ngayApDung;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }
    /**
     * Set ngày hết hạn phải muộn hơn ngày ngày áp dụng <br></br>
     * Nếu ngày hết hạn trước ngày áp dụng thì sẽ xuất ra exception "Ngày hết hạn không được sớm hơn ngày áp dụng!"
     */
    public void setNgayHetHan(LocalDate ngayHetHan) throws Exception {
        if(!ngayHetHan.isBefore(ngayApDung))
            this.ngayHetHan = ngayHetHan;
        else
            throw new Exception("Ngày hết hạn không được sớm hơn ngày áp dụng!");
    }

    @Override
    public String toString() {
        return "KhuyenMai{" +
                "maKM='" + maKM + '\'' +
                ", tenKM='" + tenKM +
                ", ngayApDung=" + ngayApDung +
                ", ngayHetHan=" + ngayHetHan +
                '}';
    }
}
