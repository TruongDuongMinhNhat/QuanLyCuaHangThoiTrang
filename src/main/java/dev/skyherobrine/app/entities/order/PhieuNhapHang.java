package dev.skyherobrine.app.entities.order;

import dev.skyherobrine.app.entities.person.NhaCungCap;
import dev.skyherobrine.app.enums.TinhTrangNhapHang;

import java.time.LocalDate;

/**
 * Thực thể "Phiếu Nhập Hàng", thực thể này dùng để lưu trữ thông tin phiếu nhập hàng của cửa hàng trong
 * việc nhập các sản phẩm từ nhà cung cấp đến.
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class PhieuNhapHang {
    private String maPhieuNhap;
    private NhaCungCap nhaCungCap;
    private LocalDate ngayLapPhieu;
    private LocalDate ngayHenGiao;
    private String ghiChu;
    private TinhTrangNhapHang tinhTrang;

    public PhieuNhapHang(String maPhieuNhap, NhaCungCap nhaCungCap, LocalDate ngayLapPhieu, LocalDate ngayHenGiao, String ghiChu, TinhTrangNhapHang tinhTrang) {
        this.maPhieuNhap = maPhieuNhap;
        this.nhaCungCap = nhaCungCap;
        this.ngayLapPhieu = ngayLapPhieu;
        this.ngayHenGiao = ngayHenGiao;
        this.ghiChu = ghiChu;
        this.tinhTrang = tinhTrang;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public LocalDate getNgayLapPhieu() {
        return ngayLapPhieu;
    }

    public void setNgayLapPhieu(LocalDate ngayLapPhieu) {
        this.ngayLapPhieu = ngayLapPhieu;
    }

    public LocalDate getNgayHenGiao() {
        return ngayHenGiao;
    }

    public void setNgayHenGiao(LocalDate ngayHenGiao) {
        this.ngayHenGiao = ngayHenGiao;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public TinhTrangNhapHang getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(TinhTrangNhapHang tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "PhieuNhapHang{" +
                "maPhieuNhap='" + maPhieuNhap + '\'' +
                ", nhaCungCap=" + nhaCungCap +
                ", ngayLapPhieu=" + ngayLapPhieu +
                ", ngayHenGiao=" + ngayHenGiao +
                ", ghiChu='" + ghiChu + '\'' +
                ", tinhTrang=" + tinhTrang +
                '}';
    }
}
