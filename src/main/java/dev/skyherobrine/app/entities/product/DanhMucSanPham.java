package dev.skyherobrine.app.entities.product;

/**
 * Thực thể "Danh Mục Sản Phẩm", thực thể này sẽ lưu trữ các danh mục bán hàng của cửa hàng, mỗi danh mục
 * sẽ có nhiều loại sản phẩm khác nhau và mỗi sản phẩm sẽ có nhiều phiên bản khác nhau.
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class DanhMucSanPham {
    private String maDM;
    private String tenDM;

    public DanhMucSanPham(String maDM, String tenDM) {
        this.maDM = maDM;
        this.tenDM = tenDM;
    }

    public String getMaDM() {
        return maDM;
    }

    public void setMaDM(String maDM) {
        this.maDM = maDM;
    }

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }

    @Override
    public String toString() {
        return "DanhMucSanPham{" +
                "maDM='" + maDM + '\'' +
                ", tenDM='" + tenDM + '\'' +
                '}';
    }
}
