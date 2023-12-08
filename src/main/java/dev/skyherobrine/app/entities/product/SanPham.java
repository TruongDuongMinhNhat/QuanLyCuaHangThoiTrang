package dev.skyherobrine.app.entities.product;

import dev.skyherobrine.app.entities.order.ChiTietPhieuNhapHang;
import dev.skyherobrine.app.entities.sale.Thue;
import dev.skyherobrine.app.enums.DoTuoi;
import dev.skyherobrine.app.enums.MauSac;
import dev.skyherobrine.app.enums.PhongCachMac;
import dev.skyherobrine.app.enums.TinhTrangSanPham;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
    private ThuongHieu thuongHieu;
    private float phanTramLoi;
    private MauSac mauSac;
    private LocalDate ngaySanXuat;
    private Thue thue;
    private TinhTrangSanPham tinhTrang;
    private List<ChiTietPhieuNhapHang> chiTietPhieuNhapHangs;

    public SanPham(String maSP, String tenSP, LoaiSanPham loaiSanPham, PhongCachMac phongCachMac, DoTuoi doTuoi, String xuatXu, ThuongHieu thuongHieu, float phanTramLoi, LocalDate ngaySanXuat, Thue thue, TinhTrangSanPham tinhTrang) throws Exception{
        this.setMaSP(maSP);
        this.setTenSP(tenSP);
        this.setLoaiSanPham(loaiSanPham);
        this.setPhongCachMac(phongCachMac);
        this.setDoTuoi(doTuoi);
        this.setXuatXu(xuatXu);
        this.setThuongHieu(thuongHieu);
        this.setPhanTramLoi(phanTramLoi);
        this.setNgaySanXuat(ngaySanXuat);
        this.thue = thue;
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

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public Thue getThue() {
        return thue;
    }

    public void setThue(Thue thue) {
        this.thue = thue;
    }

    public TinhTrangSanPham getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(TinhTrangSanPham tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public List<ChiTietPhieuNhapHang> getChiTietPhieuNhapHangs() {
        return chiTietPhieuNhapHangs;
    }

    public void setChiTietPhieuNhapHangs(List<ChiTietPhieuNhapHang> chiTietPhieuNhapHangs) {
        this.chiTietPhieuNhapHangs = chiTietPhieuNhapHangs;
    }

    public double giaBan() {
        return giaNhapGanNhat() * phanTramLoi * (1 + thue.getGiaTri() / 100);
    }

    public double giaNhapGanNhat() {
        double giaBan = 0;
        LocalDateTime ngayNhap = null;
        for(ChiTietPhieuNhapHang chiTietPhieuNhapHang : chiTietPhieuNhapHangs) {
            if(ngayNhap == null) {
                ngayNhap = chiTietPhieuNhapHang.getPhieuNhapHang().getNgayLapPhieu();
                giaBan = chiTietPhieuNhapHang.getGiaNhap();
            } else if(ngayNhap.isBefore(chiTietPhieuNhapHang.getPhieuNhapHang().getNgayLapPhieu())) {
                ngayNhap = chiTietPhieuNhapHang.getPhieuNhapHang().getNgayLapPhieu();
                giaBan = chiTietPhieuNhapHang.getGiaNhap();
            }
        }
        return giaBan;
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
