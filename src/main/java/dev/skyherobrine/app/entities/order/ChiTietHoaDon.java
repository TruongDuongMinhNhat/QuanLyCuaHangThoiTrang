package dev.skyherobrine.app.entities.order;

import dev.skyherobrine.app.entities.product.SanPham;

/**
 * Thực thể "Chi Tiết Hoá Đơn", thực thể này dùng để chứa thông tin chi tiết về sản phẩm mà khách hàng
 * mua và cũng như giá tiền tương ứng.
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class ChiTietHoaDon {
    private HoaDon hoaDon;
    private SanPham sanPham;
    private int soLuongMua;

    public ChiTietHoaDon(HoaDon hoaDon, SanPham sanPham, int soLuongMua) throws Exception {
        this.setHoaDon(hoaDon);
        this.setSanPham(sanPham);
        this.setSoLuongMua(soLuongMua);
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(int soLuongMua) {
        this.soLuongMua = soLuongMua;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" +
                "hoaDon=" + hoaDon +
                ", sanPham=" + sanPham +
                ", soLuongMua=" + soLuongMua +
                '}';
    }
}
