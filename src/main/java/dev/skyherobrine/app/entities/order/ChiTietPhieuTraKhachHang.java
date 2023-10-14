package dev.skyherobrine.app.entities.order;

import dev.skyherobrine.app.entities.product.SanPham;

/**
 * Thực thể "Chi Tiết Phiếu Trả Khách Hàng", thực thể này dùng để lưu thông tin chi tiết về sản phẩm
 * mà khách hàng đến trả và cũng như số lượng khách hàng muốn trả.
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class ChiTietPhieuTraKhachHang {
    private PhieuTraKhachHang phieuTra;
    private SanPham sanPham;
    private int soLuongTra;
    private String noiDungTra;

    public ChiTietPhieuTraKhachHang(PhieuTraKhachHang phieuTra, SanPham sanPham, int soLuongTra, String noiDungTra) throws Exception{
        this.setPhieuTra(phieuTra);
        this.setSanPham(sanPham);
        this.setSoLuongTra(soLuongTra);
        this.setNoiDungTra(noiDungTra);
    }

    public PhieuTraKhachHang getPhieuTra() {
        return phieuTra;
    }

    public void setPhieuTra(PhieuTraKhachHang phieuTra) {
        this.phieuTra = phieuTra;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getSoLuongTra() {
        return soLuongTra;
    }

    public void setSoLuongTra(int soLuongTra) {
        this.soLuongTra = soLuongTra;
    }

    public String getNoiDungTra() {
        return noiDungTra;
    }

    public void setNoiDungTra(String noiDungTra) {
        this.noiDungTra = noiDungTra;
    }

    @Override
    public String toString() {
        return "ChiTietPhieuTraKhachHang{" +
                "phieuTra=" + phieuTra +
                ", sanPham=" + sanPham +
                ", soLuongTra=" + soLuongTra +
                ", noiDungTra='" + noiDungTra + '\'' +
                '}';
    }
}
