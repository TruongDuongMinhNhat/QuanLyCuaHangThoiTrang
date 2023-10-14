package dev.skyherobrine.app.entities.product;

import dev.skyherobrine.app.enums.MauSac;
import dev.skyherobrine.app.enums.TinhTrangSanPham;

import java.time.LocalDate;

/**
 * Thực thể "Chi Tiết Phiên Bản Sản Phẩm", thực thể này dùng để lưu trữ thông tin chi tiết về một kiểu
 * sản phẩm<br><br>
 * Ví dụ: Sản phẩm có tên là: quần jeans xanh đen (cùng các thuộc tính cơ bản ở thực thể "Sản Phẩm"),
 * nhưng nó nhiều màu sắc khác nhau chẳng hạn: xanh, đen, xám,... và có thể có nhiều kích thước khác
 * nhau,... và hơn hết không phải kiểu sản phẩm nào cũng đều chung một ngày sản xuất.
 *
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class ChiTietPhienBanSanPham {
    private SanPham sanPham;
    private MauSac mauSac;
    private String kichThuoc;
    private TinhTrangSanPham tinhTrang;
    private String hinhAnh;
    private int soLuong;
    private LocalDate ngaySanXuat;

    public ChiTietPhienBanSanPham(SanPham sanPham, MauSac mauSac, String kichThuoc, TinhTrangSanPham tinhTrang, String hinhAnh, int soLuong, LocalDate ngaySanXuat) throws Exception {
        this.setSanPham(sanPham);
        this.setMauSac(mauSac);
        this.setKichThuoc(kichThuoc);
        this.setTinhTrang(tinhTrang);
        this.setHinhAnh(hinhAnh);
        this.setSoLuong(soLuong);
        this.setNgaySanXuat(ngaySanXuat);
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
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

    public TinhTrangSanPham getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(TinhTrangSanPham tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    @Override
    public String toString() {
        return "ChiTietPhienBanSanPham{" +
                "sanPham=" + sanPham +
                ", mauSac=" + mauSac +
                ", kichThuoc='" + kichThuoc + '\'' +
                ", tinhTrang=" + tinhTrang +
                ", hinhAnh='" + hinhAnh + '\'' +
                ", soLuong=" + soLuong +
                ", ngaySanXuat=" + ngaySanXuat +
                '}';
    }
}
