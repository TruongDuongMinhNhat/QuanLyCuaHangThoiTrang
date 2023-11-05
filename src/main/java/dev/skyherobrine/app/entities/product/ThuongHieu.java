package dev.skyherobrine.app.entities.product;

import dev.skyherobrine.app.enums.TinhTrangThuongHieu;

/**
 * Thực thể "Thương Hiệu", thực thể này dùng để lưu trữ thông tin của thương hiệu sản xuất ra sản phẩm.
 * Một sản phẩm có thể thuộc 1 thương hiệu nhưng một thương hiệu có thể sản xuất ra nhiều sản phẩm khác
 * nhau.
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class ThuongHieu {
    private String maTH;
    private String tenTH;
    private TinhTrangThuongHieu tinhTrang;

    public ThuongHieu(String maTH, String tenTH, TinhTrangThuongHieu tinhTrang) {
        this.maTH = maTH;
        this.tenTH = tenTH;
        this.tinhTrang = tinhTrang;
    }

    public String getMaTH() {
        return maTH;
    }

    public void setMaTH(String maTH) {
        this.maTH = maTH;
    }

    public String getTenTH() {
        return tenTH;
    }
    /**
     * Set tên thương hiệu không được rỗng <br></br>
     * Nếu tên thương hiệu rỗng thì sẽ xuất ra exception "Tên thương hiệu không được để trống!"
     */
    public void setTenTH(String tenTH) throws Exception {
        if(!tenTH.equalsIgnoreCase(""))
            this.tenTH = tenTH;
        else
            throw new Exception("Tên thương hiệu không được để trống!");
    }

    public TinhTrangThuongHieu getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(TinhTrangThuongHieu tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "ThuongHieu{" +
                "maTH='" + maTH + '\'' +
                ", tenTH='" + tenTH + '\'' +
                ", tinhTrang=" + tinhTrang +
                '}';
    }
}
