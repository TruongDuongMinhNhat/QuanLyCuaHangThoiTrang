package dev.skyherobrine.app.entities.order;

import dev.skyherobrine.app.entities.product.ChiTietPhienBanSanPham;
import dev.skyherobrine.app.entities.product.SanPham;

/**
 * Thực thể "Chi Tiết Phiếu Trả Khách Hàng", thực thể này dùng để lưu thông tin chi tiết về sản phẩm
 * mà khách hàng đến trả và cũng như số lượng khách hàng muốn trả.
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class ChiTietPhieuTraKhachHang {
    private PhieuTraKhachHang phieuTra;
    private ChiTietPhienBanSanPham phienBanSanPham;
    private int soLuongTra;
    private String noiDungTra;

    public ChiTietPhieuTraKhachHang(PhieuTraKhachHang phieuTra, ChiTietPhienBanSanPham phienBanSanPham, int soLuongTra, String noiDungTra) throws Exception{
        this.setPhieuTra(phieuTra);
        this.setChiTietPhienBanSanPham(phienBanSanPham);
        this.setSoLuongTra(soLuongTra);
        this.setNoiDungTra(noiDungTra);
    }

    public PhieuTraKhachHang getPhieuTra() {
        return phieuTra;
    }

    public void setPhieuTra(PhieuTraKhachHang phieuTra) {
        this.phieuTra = phieuTra;
    }

    public ChiTietPhienBanSanPham getChiTietPhienBanSanPham() {
        return phienBanSanPham;
    }

    public void setChiTietPhienBanSanPham(ChiTietPhienBanSanPham phienBanSanPham) {
        this.phienBanSanPham = phienBanSanPham;
    }

    public int getSoLuongTra() {
        return soLuongTra;
    }
    /**
     * Set số lượng trả phải lớn hơn 0 <br></br>
     * Nếu số lượng trả lớn hơn thì sẽ xuất ra exception "Số lượng trả lớn hơn 0"
     */
    public void setSoLuongTra(int soLuongTra) throws Exception {
        if(soLuongTra>0)
            this.soLuongTra = soLuongTra;
        else
            throw new Exception("Số lượng mặt hàng trả phải lớn hơn 0!");
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
                ", phienBanSanPham=" + phienBanSanPham +
                ", soLuongTra=" + soLuongTra +
                ", noiDungTra='" + noiDungTra + '\'' +
                '}';
    }
}
