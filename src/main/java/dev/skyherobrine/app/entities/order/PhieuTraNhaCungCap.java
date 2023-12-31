package dev.skyherobrine.app.entities.order;

import dev.skyherobrine.app.enums.TinhTrangTraHang;

import java.time.LocalDateTime;

/**
 * Thực thể "Phiếu Trả Nhà Cung Cấp", thực thể này dùng để lưu trữ thông tin việc trả những món hàng bị lỗi
 * về cho nhà cung cấp.
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class PhieuTraNhaCungCap {
    private String maPhieuTra;
    private PhieuNhapHang phieuNhap;
    private LocalDateTime ngayHenLay;
    private LocalDateTime ngayLap;
    private TinhTrangTraHang tinhTrang;

    public PhieuTraNhaCungCap(String maPhieuTra, PhieuNhapHang phieuNhap, LocalDateTime ngayHenLay, LocalDateTime ngayLap, TinhTrangTraHang tinhTrang) throws Exception{
        this.setMaPhieuTra(maPhieuTra);
        this.setPhieuNhap(phieuNhap);
        this.setNgayHenLay(ngayHenLay);
        this.setNgayLap(ngayLap);
        this.setTinhTrang(tinhTrang);
    }

    public String getMaPhieuTra() {
        return maPhieuTra;
    }

    public void setMaPhieuTra(String maPhieuTra) {
        this.maPhieuTra = maPhieuTra;
    }

    public PhieuNhapHang getPhieuNhap() {
        return phieuNhap;
    }

    public void setPhieuNhap(PhieuNhapHang phieuNhap) {
        this.phieuNhap = phieuNhap;
    }

    public LocalDateTime getNgayHenLay() {
        return ngayHenLay;
    }
    /**
     * Set ngày hẹn lấy phải lớn hơn ngày lập phiếu trả hàng nhà cung cấp <br></br>
     * Nếu ngày hẹn lấy nhỏ hơn ngày lập phiếu thì sẽ xuất ra exception "Ngày hẹn lấy không được sớm hơn ngày lập!"
     */
    public void setNgayHenLay(LocalDateTime ngayHenLay) throws Exception {
        if(!ngayHenLay.isBefore(this.ngayLap))
            this.ngayHenLay = ngayLap;
        else
            throw new Exception("Ngày hẹn lấy không được sớm hơn ngày lập!");
    }

    public LocalDateTime getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDateTime ngayLap) {
        this.ngayLap = ngayLap;
    }

    public TinhTrangTraHang getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(TinhTrangTraHang tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "PhieuTraNhaCungCap{" +
                "maPhieuTra='" + maPhieuTra + '\'' +
                ", phieuNhap=" + phieuNhap +
                ", ngayHenLay=" + ngayHenLay +
                ", ngayLap=" + ngayLap +
                ", tinhTrang=" + tinhTrang +
                '}';
    }
}
