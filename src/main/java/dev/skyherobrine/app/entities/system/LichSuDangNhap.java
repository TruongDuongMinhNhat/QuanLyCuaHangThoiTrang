package dev.skyherobrine.app.entities.system;

import dev.skyherobrine.app.entities.person.NhanVien;

import java.time.LocalDate;

/**
 * Thực thể "Lịch Sử Đăng Nhập", thực thể này sẽ chứa dữ liệu liên quan đến việc nhân viên sẽ đăng nhập ở trong
 * khoảng thời gian nào và đăng xuất (thoát) khỏi ứng dụng trong khoảng thời gian nào.
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class LichSuDangNhap {
    private long id;
    private NhanVien maNV;
    private LocalDate ngayDangNhap;
    private LocalDate ngayDangXuat;

    public LichSuDangNhap(long id, NhanVien maNV, LocalDate ngayDangNhap, LocalDate ngayDangXuat) {
        this.setId(id);
        this.setMaNV(maNV);
        this.setNgayDangNhap(ngayDangNhap);
        this.setNgayDangXuat(ngayDangXuat);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public NhanVien getMaNV() {
        return maNV;
    }

    public void setMaNV(NhanVien maNV) {
        this.maNV = maNV;
    }

    public LocalDate getNgayDangNhap() {
        return ngayDangNhap;
    }

    public void setNgayDangNhap(LocalDate ngayDangNhap) {
        this.ngayDangNhap = ngayDangNhap;
    }

    public LocalDate getNgayDangXuat() {
        return ngayDangXuat;
    }

    public void setNgayDangXuat(LocalDate ngayDangXuat) {
        this.ngayDangXuat = ngayDangXuat;
    }

    @Override
    public String toString() {
        return "LichSuDangNhap{" +
                "id='" + id + '\'' +
                ", maNV=" + maNV +
                ", ngayDangNhap=" + ngayDangNhap +
                ", ngayDangXuat=" + ngayDangXuat +
                '}';
    }
}
