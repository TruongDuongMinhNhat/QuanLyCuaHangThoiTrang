package dev.skyherobrine.app.entities.product;

/**
 * Thực thể "Loại sản phẩm", thực thể này sẽ lưu trữ tất cả các sản phẩm tương ứng theo loại.
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class LoaiSanPham {
    private String maLoai;
    private String tenLoai;
    private DanhMucSanPham danhMucSanPham;

    public LoaiSanPham(String maLoai, String tenLoai, DanhMucSanPham danhMucSanPham) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
        this.danhMucSanPham = danhMucSanPham;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }
    /**
     * set loại danh mục không được rỗng <br></br>
     * nếu loại danh mục rỗng thì sẽ xuất ra exception "Loại danh mục không được rỗng!"
     */
    public void setTenLoai(String tenLoai) throws Exception {
        if(!tenLoai.equalsIgnoreCase(""))
            this.tenLoai = tenLoai;
        else
            throw new Exception("Tên loại không được để trống!");
    }

    public DanhMucSanPham getDanhMucSanPham() {
        return danhMucSanPham;
    }

    public void setDanhMucSanPham(DanhMucSanPham danhMucSanPham) {
        this.danhMucSanPham = danhMucSanPham;
    }

    @Override
    public String toString() {
        return "LoaiSanPham{" +
                "maLoai='" + maLoai + '\'' +
                ", tenLoai='" + tenLoai + '\'' +
                '}';
    }
}
