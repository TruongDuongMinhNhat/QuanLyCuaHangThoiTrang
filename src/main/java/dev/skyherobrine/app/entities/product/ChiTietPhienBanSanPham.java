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
a
    public void setKichThuoc(String kichThuoc) throws Exception {
        if(!(kichThuoc.equalsIgnoreCase("")))
            this.kichThuoc = kichThuoc;
        else
            throw new Exception("Kích thước không được rỗng!");
    }
    /**
     * Set kích thước không được rỗng <br></br>
     * Nếu kích thước rỗng thì sẽ xuất ra exception "Kích thước không được rỗng!"
     */
    public TinhTrangSanPham getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(TinhTrangSanPham tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }
    /**
     * Set hình ảnh không được rỗng <br></br>
     * Nếu hình ảnh rỗng sẽ được set hình mặc định
     */
    public void setHinhAnh(String hinhAnh) {
        if(!hinhAnh.equalsIgnoreCase(""))
            this.hinhAnh = hinhAnh;
        else
            this.hinhAnh = "Ảnh mặc định nào có link chèn vô sau";
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
    /**
     * Set ngày sản xuất phải sớm hơn ngày hiện tại <br></br>
     * Nếu ngày sản xuất trễ hơn ngày hiện tại thì sẽ xuất ra exception "Ngày sản xuất không được trễ hơn ngày hiện tại!"
     */
    public void setNgaySanXuat(LocalDate ngaySanXuat) throws Exception {
        if(ngaySanXuat.isBefore(LocalDate.now()))
            this.ngaySanXuat = ngaySanXuat;
        else
            throw new Exception("Ngày sản xuất không được trễ hơn ngày hiện tại!");
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
