package dev.skyherobrine.app.entities.order;

import dev.skyherobrine.app.entities.product.ChiTietPhienBanSanPham;

public class ChiTietPhieuNhapHangPhienBanSP {
    private ChiTietPhieuNhapHang chiTietPhieuNhapHang;
    private ChiTietPhienBanSanPham chiTietPhienBanSanPham;
    private int soLuongNhap;

    public ChiTietPhieuNhapHangPhienBanSP(ChiTietPhieuNhapHang chiTietPhieuNhapHang, ChiTietPhienBanSanPham chiTietPhienBanSanPham, int soLuongNhap) {
        this.chiTietPhieuNhapHang = chiTietPhieuNhapHang;
        this.chiTietPhienBanSanPham = chiTietPhienBanSanPham;
        this.soLuongNhap = soLuongNhap;
    }

    public ChiTietPhieuNhapHang getChiTietPhieuNhapHang() {
        return chiTietPhieuNhapHang;
    }

    public void setChiTietPhieuNhapHang(ChiTietPhieuNhapHang chiTietPhieuNhapHang) {
        this.chiTietPhieuNhapHang = chiTietPhieuNhapHang;
    }

    public ChiTietPhienBanSanPham getChiTietPhienBanSanPham() {
        return chiTietPhienBanSanPham;
    }

    public void setChiTietPhienBanSanPham(ChiTietPhienBanSanPham chiTietPhienBanSanPham) {
        this.chiTietPhienBanSanPham = chiTietPhienBanSanPham;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    @Override
    public String toString() {
        return "ChiTietPhieuNhapHangPhienBanSP{" +
                "chiTietPhieuNhapHang=" + chiTietPhieuNhapHang +
                ", chiTietPhienBanSanPham=" + chiTietPhienBanSanPham +
                ", soLuongNhap=" + soLuongNhap +
                '}';
    }
}
