package dev.skyherobrine.app.entities.order;

import dev.skyherobrine.app.entities.product.SanPham;

/**
 * Thực thể "Chi Tiết Phiếu Trả Nhà Cung Cấp", thực thể này dùng để lưu trữ dữ liệu chi tiết thông tin về
 * sản phẩm sẽ trả lại cho nhà cung cấp, cùng với sản phẩm là lí do cũng như số lượng trả về.
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class ChiTietPhieuTraNhaCungCap {
    private PhieuTraNhaCungCap phieuTra;
    private SanPham sanPham;
    private int soLuongTra;
    private String liDoTra;

    public ChiTietPhieuTraNhaCungCap(PhieuTraNhaCungCap phieuTra, SanPham sanPham, int soLuongTra, String liDoTra) throws Exception {
        this.setPhieuTra(phieuTra);
        this.setSanPham(sanPham);
        this.setSoLuongTra(soLuongTra);
        this.setLiDoTra(liDoTra);
    }

    public PhieuTraNhaCungCap getPhieuTra() {
        return phieuTra;
    }

    public void setPhieuTra(PhieuTraNhaCungCap phieuTra) {
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

    public String getLiDoTra() {
        return liDoTra;
    }

    public void setLiDoTra(String liDoTra) {
        this.liDoTra = liDoTra;
    }

    @Override
    public String toString() {
        return "ChiTietPhieuTraNhaCungCap{" +
                "phieuTra=" + phieuTra +
                ", sanPham=" + sanPham +
                ", soLuongTra=" + soLuongTra +
                ", liDoTra='" + liDoTra + '\'' +
                '}';
    }
}
