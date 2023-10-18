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
    private LocalDate ngayApDung;
    private LocalDate ngayHetHan;

    public KhuyenMai(String maKM, LocalDate ngayApDung, LocalDate ngayHetHan) throws Exception {
        this.setMaKM(maKM);
        this.setNgayApDung(ngayApDung);
        this.setNgayHetHan(ngayHetHan);
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
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

    public void setNgayHetHan(LocalDate ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" +
                "maKM='" + maKM + '\'' +
                ", ngayApDung=" + ngayApDung +
                ", ngayHetHan=" + ngayHetHan +
                '}';
    }
}
