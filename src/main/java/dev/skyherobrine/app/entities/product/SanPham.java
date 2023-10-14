package dev.skyherobrine.app.entities.product;

import dev.skyherobrine.app.enums.DoTuoi;

/**
 * Thực thể "Sản Phẩm", thực thể này dùng để lưu trữ thông tin sản phẩm trong cửa hàng, thông tin sản phẩm
 * sẽ được hiển thị thông tin chi tiết trên ứng dụng để nhân viên bán hàng có thể đọc được và quản lý.
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class SanPham {
    private String maSP;
    private String tenSP;
    private LoaiSanPham loaiSanPham;
    private boolean gioiTinh;
    private DoTuoi doTuoi;
    private String xuatXu;
    private ThuongHieu thuongHieu;
    private float phanTramLoi;

    public SanPham(String maSP, String tenSP, LoaiSanPham loaiSanPham, boolean gioiTinh, DoTuoi doTuoi, String xuatXu, ThuongHieu thuongHieu, float phanTramLoi) throws Exception{
        this.setMaSP(maSP);
        this.setTenSP(tenSP);
        this.setLoaiSanPham(loaiSanPham);
        this.setGioiTinh(gioiTinh);
        this.setDoTuoi(doTuoi);
        this.setXuatXu(xuatXu);
        this.setThuongHieu(thuongHieu);
        this.setPhanTramLoi(phanTramLoi);
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public LoaiSanPham getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public DoTuoi getDoTuoi() {
        return doTuoi;
    }

    public void setDoTuoi(DoTuoi doTuoi) {
        this.doTuoi = doTuoi;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public ThuongHieu getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(ThuongHieu thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public float getPhanTramLoi() {
        return phanTramLoi;
    }

    public void setPhanTramLoi(float phanTramLoi) {
        this.phanTramLoi = phanTramLoi;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "maSP='" + maSP + '\'' +
                ", tenSP='" + tenSP + '\'' +
                ", loaiSanPham=" + loaiSanPham +
                ", gioiTinh=" + gioiTinh +
                ", doTuoi=" + doTuoi +
                ", xuatXu='" + xuatXu + '\'' +
                ", thuongHieu=" + thuongHieu +
                ", phanTramLoi=" + phanTramLoi +
                '}';
    }
}
