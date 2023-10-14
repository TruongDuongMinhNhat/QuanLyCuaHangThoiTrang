package dev.skyherobrine.app.entities.product;

/**
 * Thực thể "Loại sản phẩm", thực thể này sẽ lưu trữ tất cả các sản phẩm tương ứng theo loại.
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class LoaiSanPham {
    private String maLoai;
    private String tenLoai;

    public LoaiSanPham(String maLoai, String tenLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
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

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    @Override
    public String toString() {
        return "LoaiSanPham{" +
                "maLoai='" + maLoai + '\'' +
                ", tenLoai='" + tenLoai + '\'' +
                '}';
    }
}
