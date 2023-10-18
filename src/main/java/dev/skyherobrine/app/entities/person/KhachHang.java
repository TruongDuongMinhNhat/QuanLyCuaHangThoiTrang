package dev.skyherobrine.app.entities.person;

import java.time.LocalDate;

/**
 * Thực thể khách hàng, khách hàng sẽ là người thực hiên mua hàng tại cửa hàng, hệ thống cửa hàng sẽ lưu trữ
 * thông tin của khách hàng khi khách đến mua hàng tại cửa hàng và thông tin của khách cũng sẽ chứng minh khách
 * có mua món hàng ở cửa hàng và khi có trả hàng thì cửa hàng sẽ dựa vào thông tin hoá đơn mà khách hàng có
 * được khi mua sẽ tiến hành lập phiếu trả hàng.
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class KhachHang {
    private String maKH;
    private String hoTen;
    private String soDienThoai;
    private boolean gioiTinh;
    private LocalDate ngaySinh;
    private float diemTichLuy;

    public KhachHang(String maKH, String hoTen, String soDienThoai, boolean gioiTinh, LocalDate ngaySinh, float diemTichLuy) throws Exception{
        this.setMaKH(maKH);
        this.setHoTen(hoTen);
        this.setSoDienThoai(soDienThoai);
        this.setGioiTinh(gioiTinh);
        this.setNgaySinh(ngaySinh);
        this.setDiemTichLuy(diemTichLuy);
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public float getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(float diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }
}
