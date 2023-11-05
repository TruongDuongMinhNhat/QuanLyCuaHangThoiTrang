package dev.skyherobrine.app.entities.product;

import dev.skyherobrine.app.enums.DoTuoi;
import dev.skyherobrine.app.enums.MauSac;
import dev.skyherobrine.app.enums.PhongCachMac;
import dev.skyherobrine.app.enums.TinhTrangSanPham;

import java.time.LocalDate;

/**
 * Thực thể "Sản Phẩm", thực thể này dùng để lưu trữ thông tin sản phẩm trong cửa hàng, thông tin sản phẩm
 * sẽ được hiển thị thông tin chi tiết trên ứng dụng để nhân viên bán hàng có thể đọc được và quản lý.
 * @author Trương Dương Minh Nhật
 * @version 1.1
 */
public class SanPham {
    private String maSP;
    private String tenSP;
    private LoaiSanPham loaiSanPham;
    private PhongCachMac phongCachMac;
    private DoTuoi doTuoi;
    private String xuatXu;
    private int soLuong;
    private ThuongHieu thuongHieu;
    private float phanTramLoi;
    private MauSac mauSac;
    private String kichThuoc;
    private String hinhAnh;
    private LocalDate ngaySanXuat;
    private TinhTrangSanPham tinhTrang;

    public SanPham(String maSP, String tenSP, LoaiSanPham loaiSanPham, PhongCachMac phongCachMac, DoTuoi doTuoi, String xuatXu, int soLuong, ThuongHieu thuongHieu, float phanTramLoi, MauSac mauSac, String kichThuoc, String hinhAnh, LocalDate ngaySanXuat, TinhTrangSanPham tinhTrang) throws Exception{
        this.setMaSP(maSP);
        this.setTenSP(tenSP);
        this.setLoaiSanPham(loaiSanPham);
        this.setPhongCachMac(phongCachMac);
        this.setDoTuoi(doTuoi);
        this.setXuatXu(xuatXu);
        this.setSoLuong(soLuong);
        this.setThuongHieu(thuongHieu);
        this.setPhanTramLoi(phanTramLoi);
        this.setMauSac(mauSac);
        this.setKichThuoc(kichThuoc);
        this.setHinhAnh(hinhAnh);
        this.setNgaySanXuat(ngaySanXuat);
        this.setTinhTrang(tinhTrang);
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public TinhTrangSanPham getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(TinhTrangSanPham tinhTrang) {
        this.tinhTrang = tinhTrang;
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
