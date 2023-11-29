package dev.skyherobrine.app.entities.order;

import dev.skyherobrine.app.entities.product.ChiTietPhienBanSanPham;
import dev.skyherobrine.app.entities.product.SanPham;

import java.util.List;

/**
 * Thực thể "Chi Tiết Hoá Đơn", thực thể này dùng để chứa thông tin chi tiết về sản phẩm mà khách hàng
 * mua và cũng như giá tiền tương ứng.
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class ChiTietHoaDon {
    private HoaDon hoaDon;
    private ChiTietPhienBanSanPham phienBanSanPham;
    private int soLuongMua;

    public ChiTietHoaDon(HoaDon hoaDon, ChiTietPhienBanSanPham phienBanSanPham, int soLuongMua) throws Exception {
        this.setHoaDon(hoaDon);
        this.setPhienBanSanPham(phienBanSanPham);
        this.setSoLuongMua(soLuongMua);
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public ChiTietPhienBanSanPham getChiTietPhienBanSanPham() {
        return phienBanSanPham;
    }

    public void setPhienBanSanPham(ChiTietPhienBanSanPham getChiTietPhienBanSanPham) {
        this.phienBanSanPham = phienBanSanPham;
    }

    public int getSoLuongMua() {
        return soLuongMua;
    }

    /**
     * Set số lượng mua phải lớn hơn 0 <br></br>
     * Nếu số lượng mua bằng 0 thì sẽ xuất ra exception "Số lượng mua lớn hơn 0"
     */
    public void setSoLuongMua(int soLuongMua) throws Exception {
        if(soLuongMua>0)
            this.soLuongMua = soLuongMua;
        else
            throw new Exception("Số lượng mua phải lớn hơn 0!");
    }

    public double giaTienSanPham() {
        return soLuongMua * phienBanSanPham.getSanPham().giaBan();
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" +
                "hoaDon=" + hoaDon +
                ", phienBanSanPham=" + phienBanSanPham +
                ", soLuongMua=" + soLuongMua +
                '}';
    }
}
