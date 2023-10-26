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
    /**
     * Set tên danh mục không được rỗng <br></br>
     * Nếu tên danh mục rỗng thì sẽ xuất ra exception "Tên danh mục không được rỗng!"
     */
    public void setTenDM(String tenDM) throws Exception {
        if(!tenDM.equalsIgnoreCase(""))
            this.tenDM = tenDM;
        else
            throw new Exception("Tên danh mục không được để trống!");
    }

    @Override
    public String toString() {
        return "DanhMucSanPham{" +
                "maDM='" + maDM + '\'' +
                ", tenDM='" + tenDM + '\'' +
                '}';
    }
}
