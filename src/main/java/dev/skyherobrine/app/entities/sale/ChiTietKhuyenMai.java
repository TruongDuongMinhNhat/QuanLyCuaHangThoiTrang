package dev.skyherobrine.app.entities.sale;

import dev.skyherobrine.app.entities.product.SanPham;

/**
 * Thực thể "Chi Tiết Khuyến Mãi", thực thể này dùng để hiển thị chi tiết sản phẩm đó sẽ được áp dụng chương
 * trình khuyến mãi nào và được khuyến mãi bao nhiều phần trăm.
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class ChiTietKhuyenMai {
    private SanPham sanPham;
    private KhuyenMai khuyenMai;
    private float tiLe;

    public ChiTietKhuyenMai(SanPham sanPham, KhuyenMai khuyenMai, float tiLe) throws Exception {
        this.setSanPham(sanPham);
        this.setKhuyenMai(khuyenMai);
        this.setTiLe(tiLe);
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public KhuyenMai getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(KhuyenMai khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public float getTiLe() {
        return tiLe;
    }

    public void setTiLe(float tiLe) {
        this.tiLe = tiLe;
    }

    @Override
    public String toString() {
        return "ChiTietKhuyenMai{" +
                "sanPham=" + sanPham +
                ", khuyenMai=" + khuyenMai +
                ", tiLe=" + tiLe +
                '}';
    }
}
