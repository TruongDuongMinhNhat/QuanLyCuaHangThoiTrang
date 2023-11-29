package dev.skyherobrine.app.entities.order;

import dev.skyherobrine.app.entities.product.ChiTietPhienBanSanPham;

public class ChiTietPhieuNhapHangPhienBanSP {
    private ChiTietPhieuNhapHang chiTietPhieuNhapHang;
    private ChiTietPhienBanSanPham chiTietPhienBanSanPham;
    private int soLuongNhap;
    public ChiTietPhieuNhapHangPhienBanSP(ChiTietPhieuNhapHang chiTietPhieuNhapHang, ChiTietPhienBanSanPham chiTietPhienBanSanPham, int soLuongNhap) throws Exception{
        this.setChiTietPhieuNhapHang(chiTietPhieuNhapHang);
        this.setChiTietPhienBanSanPham(chiTietPhienBanSanPham);
        this.setSoLuongNhap(soLuongNhap);
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
    /**
     * set số lượng nhập phải lớn hơn 0
     * Nếu số lượng nhập bằng 0 thì sẽ xuất ra exception "Số lượng nhập phải lớn hơn 0"
     */
    public void setSoLuongNhap(int soLuongNhap) throws Exception {
        if(soLuongNhap>0)
            this.soLuongNhap = soLuongNhap;
        else
            throw new Exception("Số lượng nhập phải lớn hơn 0!");
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
