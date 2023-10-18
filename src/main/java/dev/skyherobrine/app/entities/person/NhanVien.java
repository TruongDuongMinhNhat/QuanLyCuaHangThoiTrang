package dev.skyherobrine.app.entities.person;

import dev.skyherobrine.app.enums.CaLamViec;
import dev.skyherobrine.app.enums.ChucVu;
import dev.skyherobrine.app.enums.TinhTrangNhanVien;

import java.time.LocalDate;

/**
 * Thực thể nhân viên, nhân viên có trách nhiệm làm các công việc của cửa hàng từ quản lý bán hàng đến các quản
 * lý sản phẩm, hoá đơn,...</br>
 * Nhân viên có 2 dạng: <b>Nhân viên bán hàng</b> và <b>nhân viên quản lý nhân sự</b>.</br>
 * <ul>
 *     <li>Nhân viên bán hàng sẽ làm các công việc liên quan đến cửa hàng.</li>
 *     <li>Nhân viên quản lý nhân sự sẽ làm các công việc liên quan đến quản lý nhân viên, mọi sự hoạt động của nhân viên
 *         trong cửa hàng.</li>
 * </ul>
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class NhanVien {
    private String maNV;
    private String hoTen;
    private String soDienThoai;
    private boolean gioiTinh;
    private LocalDate ngaySinh;
    private String email;
    private String diaChi;
    private ChucVu chucVu;
    private CaLamViec caLamViec;
    private String tenTaiKhoan;
    private String matKhau;
    private TinhTrangNhanVien tinhTrang;

    public NhanVien(String maNV, String hoTen, String soDienThoai, boolean gioiTinh, LocalDate ngaySinh, String email, String diaChi, ChucVu chucVu, CaLamViec caLamViec, String tenTaiKhoan, String matKhau, TinhTrangNhanVien tinhTrang) {
        this.setMaNV(maNV);
        this.setHoTen(hoTen);
        this.setSoDienThoai(soDienThoai);
        this.setGioiTinh(gioiTinh);
        this.setNgaySinh(ngaySinh);
        this.setEmail(email);
        this.setDiaChi(diaChi);
        this.setChucVu(chucVu);
        this.setCaLamViec(caLamViec);
        this.setTenTaiKhoan(tenTaiKhoan);
        this.setMaNV(matKhau);
        this.setTinhTrang(tinhTrang);
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    public CaLamViec getCaLamViec() {
        return caLamViec;
    }

    public void setCaLamViec(CaLamViec caLamViec) {
        this.caLamViec = caLamViec;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public TinhTrangNhanVien getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(TinhTrangNhanVien tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
