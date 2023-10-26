package dev.skyherobrine.app.entities.product;

import dev.skyherobrine.app.enums.DoTuoi;
import dev.skyherobrine.app.enums.PhongCachMac;

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
    private PhongCachMac phongCachMac;
    private DoTuoi doTuoi;
    private String xuatXu;
    private ThuongHieu thuongHieu;
    private float phanTramLoi;

    public SanPham(String maSP, String tenSP, LoaiSanPham loaiSanPham, PhongCachMac phongCachMac, DoTuoi doTuoi, String xuatXu, ThuongHieu thuongHieu, float phanTramLoi) throws Exception{
        this.setMaSP(maSP);
        this.setTenSP(tenSP);
        this.setLoaiSanPham(loaiSanPham);
        this.setPhongCachMac(phongCachMac);
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
    /**
     * Set tên sản phẩm không được rỗng <br></br>
     * Nếu tên sản phẩm rỗng thì sẽ xuất ra exception "Tên sản phẩm không được để trống!"
     */
    public void setTenSP(String tenSP) throws Exception {
        if(!tenSP.equalsIgnoreCase(""))
            this.tenSP = tenSP;
        else
            throw new Exception("Tên sản phẩm không được để trống!");
    }

    public LoaiSanPham getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public PhongCachMac getPhongCachMac() {
        return phongCachMac;
    }

    public void setPhongCachMac(PhongCachMac phongCachMac) {
        this.phongCachMac = phongCachMac;
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

    public void setXuatXu(String xuatXu) throws Exception {
        if(!xuatXu.equalsIgnoreCase(""))
            this.xuatXu = xuatXu;
        else
            throw new Exception("Xuất xứ không được để trống!");
    }
    /**
     * Set xuất xứ không được rỗng <br></br>
     * Nếu xuất xứ rỗng thì sẽ xuất ra exception "Xuất xứ không được để trống!"
     */
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
                ", phongCachMac=" + phongCachMac +
                ", doTuoi=" + doTuoi +
                ", xuatXu='" + xuatXu + '\'' +
                ", thuongHieu=" + thuongHieu +
                ", phanTramLoi=" + phanTramLoi +
                '}';
    }
}
