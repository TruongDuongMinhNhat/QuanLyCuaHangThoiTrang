package dev.skyherobrine.app.entities.order;

import dev.skyherobrine.app.entities.person.KhachHang;
import dev.skyherobrine.app.entities.person.NhanVien;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Thực thể "Hoá Đơn", dùng để lưu trữ thông tin về lập hoá đơn của khách hàng đã mua hàng tại cửa hàng.
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class HoaDon {
    private String maHD;
    private LocalDateTime ngayLap;
    private NhanVien nhanVienLap;
    private KhachHang khachHang;
    private BigDecimal soTienKHTra;
    private String ghiChu;

    private List<ChiTietHoaDon> chiTietHoaDons;

    public HoaDon(String maHD, LocalDateTime ngayLap, NhanVien nhanVienLap, KhachHang khachHang, BigDecimal soTienKHTra, String ghiChu) throws Exception {
        this.setMaHD(maHD);
        this.setNgayLap(ngayLap);
        this.setNhanVienLap(nhanVienLap);
        this.setKhachHang(khachHang);
        this.setSoTienKHTra(soTienKHTra);
        this.setGhiChu(ghiChu);
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public LocalDateTime getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDateTime ngayLap) {
        this.ngayLap = ngayLap;
    }

    public NhanVien getNhanVienLap() {
        return nhanVienLap;
    }

    public void setNhanVienLap(NhanVien nhanVienLap) {
        this.nhanVienLap = nhanVienLap;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public BigDecimal getSoTienKHTra() {
        return soTienKHTra;
    }

    public void setSoTienKHTra(BigDecimal soTienKHTra) {
        this.soTienKHTra = soTienKHTra;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public List<ChiTietHoaDon> getChiTietHoaDons() {
        return chiTietHoaDons;
    }

    public void setChiTietHoaDons(List<ChiTietHoaDon> chiTietHoaDons) {
        this.chiTietHoaDons = chiTietHoaDons;
    }

    public double tongTien() {
        double tongTien = 0;
        for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDons) {
            tongTien += chiTietHoaDon.giaTienSanPham();
        }
        return tongTien;

    }

    @Override
    public String toString() {
        return "HoaDon{" +
                "maHD='" + maHD + '\'' +
                ", ngayLap=" + ngayLap +
                ", nhanVienLap=" + nhanVienLap +
                ", khachHang=" + khachHang +
                ", soTienKHTra=" + soTienKHTra +
                ", ghiChu='" + ghiChu + '\'' +
                ", chiTietHoaDons=" + chiTietHoaDons +
                '}';
    }
}
