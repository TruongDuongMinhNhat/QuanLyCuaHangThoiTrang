package dev.skyherobrine.app.entities.order;

import dev.skyherobrine.app.entities.order.HoaDon;

import java.time.LocalDate;

/**
 * Thực thể "Phiếu Trả Khách Hàng", thực thể này dùng để chứa dữ liệu liên quan đến việc khách hàng
 * đến cửa hàng trả món hàng lại nếu như món hàng mà khách hàng mua có bị hỏng hay muốn trả để đổi
 * , mua cái khác.
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class PhieuTraKhachHang {
    private String maPhieuTraKhachHang;
    private LocalDate ngayLap;
    private HoaDon hoaDon;

    public PhieuTraKhachHang(String maPhieuTraKhachHang, LocalDate ngayLap, HoaDon hoaDon) throws Exception{
        this.setMaPhieuTraKhachHang(maPhieuTraKhachHang);
        this.setNgayLap(ngayLap);
        this.setHoaDon(hoaDon);
    }

    public String getMaPhieuTraKhachHang() {
        return maPhieuTraKhachHang;
    }

    public void setMaPhieuTraKhachHang(String maPhieuTraKhachHang) {
        this.maPhieuTraKhachHang = maPhieuTraKhachHang;
    }

    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDate ngayLap) {
        this.ngayLap = ngayLap;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    @Override
    public String toString() {
        return "PhieuTraKhachHang{" +
                "maPhieuTraKhachHang='" + maPhieuTraKhachHang + '\'' +
                ", ngayLap=" + ngayLap +
                ", hoaDon=" + hoaDon +
                '}';
    }
}
