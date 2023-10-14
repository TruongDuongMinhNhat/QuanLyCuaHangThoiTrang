package dev.skyherobrine.app.entities.order;

import dev.skyherobrine.app.entities.product.SanPham;

/**
 * Thực thể "Chi Tiết Phiếu Nhập", thực thể này dùng để lưu trữ thông tin chi tiết về nhập hàng, sản phẩm
 * nhập với số lượng là bao nhiêu? Số tiền nhập hàng ứng với sản phẩm đó là bao nhiêu?
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class ChiTietPhieuNhapHang {
    private PhieuNhapHang phieuNhapHang;
    private SanPham sanPham;
    private int soLuong;
    private double giaNhap;

    public ChiTietPhieuNhapHang(PhieuNhapHang phieuNhapHang, SanPham sanPham, int soLuong, double giaNhap) throws Exception{
        this.setPhieuNhapHang(phieuNhapHang);
        this.setSanPham(sanPham);
        this.setSoLuong(soLuong);
        this.setGiaNhap(giaNhap);
    }

    public PhieuNhapHang getPhieuNhapHang() {
        return phieuNhapHang;
    }

    public void setPhieuNhapHang(PhieuNhapHang phieuNhapHang) {
        this.phieuNhapHang = phieuNhapHang;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    /**
     * Tính tiền nhập hàng. Công thức tính: <b>Giá Nhập * Số Lượng Nhập = Giá Tiền Trả</b>
     * @return {@link double} trả về số thực là số tiền nhập ứng với sản phẩm này.
     */
    public double tinhTien() {
        return giaNhap * soLuong;
    }

    @Override
    public String toString() {
        return "ChiTietPhieuNhap{" +
                "phieuNhapHang=" + phieuNhapHang +
                ", sanPham=" + sanPham +
                ", soLuong=" + soLuong +
                ", giaNhap=" + giaNhap +
                '}';
    }
}
