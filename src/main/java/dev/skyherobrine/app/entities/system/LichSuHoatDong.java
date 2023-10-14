package dev.skyherobrine.app.entities.system;

import dev.skyherobrine.app.entities.person.NhanVien;
import dev.skyherobrine.app.enums.NhanVienHoatDong;

import java.time.LocalDate;

/**
 * Thực thể "Lịch Sử Hoạt Động", thực thể này dùng để lưu trữ thông tin liên quan đến vấn đề các nhân
 * viên tương tác, thực hiện hành động gì trong ứng dụng giúp cho các nhân viên quản lý có thể quản lý
 * nhân viên tốt hơn.
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class LichSuHoatDong {
    private long id;
    private NhanVien nhanVien;
    private NhanVienHoatDong hoatDong;
    private LocalDate thoiDiemThucHien;
    private String ghiChu;

    public LichSuHoatDong(long id, NhanVien nhanVien, NhanVienHoatDong hoatDong, LocalDate thoiDiemThucHien, String ghiChu) throws Exception {
        this.setId(id);
        this.setNhanVien(nhanVien);
        this.setHoatDong(hoatDong);
        this.setThoiDiemThucHien(thoiDiemThucHien);
        this.setGhiChu(ghiChu);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public NhanVienHoatDong getHoatDong() {
        return hoatDong;
    }

    public void setHoatDong(NhanVienHoatDong hoatDong) {
        this.hoatDong = hoatDong;
    }

    public LocalDate getThoiDiemThucHien() {
        return thoiDiemThucHien;
    }

    public void setThoiDiemThucHien(LocalDate thoiDiemThucHien) {
        this.thoiDiemThucHien = thoiDiemThucHien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public String toString() {
        return "LichSuHoatDong{" +
                "id=" + id +
                ", nhanVien=" + nhanVien +
                ", hoatDong=" + hoatDong +
                ", thoiDiemThucHien=" + thoiDiemThucHien +
                ", ghiChu='" + ghiChu + '\'' +
                '}';
    }
}
