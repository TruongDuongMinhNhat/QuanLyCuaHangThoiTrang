package dev.skyherobrine.app.entities.order;

import dev.skyherobrine.app.entities.product.SanPham;

/**
 * Thực thể "Chi Tiết Phiếu Trả Nhà Cung Cấp", thực thể này dùng để lưu trữ dữ liệu chi tiết thông tin về
 * sản phẩm sẽ trả lại cho nhà cung cấp, cùng với sản phẩm là lí do cũng như số lượng trả về.
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class ChiTietPhieuTraNhaCungCap {
    private PhieuTraNhaCungCap phieuTra;
    private SanPham sanPham;
    private int soLuongTra;
    private String liDoTra;

    public ChiTietPhieuTraNhaCungCap(PhieuTraNhaCungCap phieuTra, SanPham sanPham, int soLuongTra, String liDoTra) throws Exception {
        this.setPhieuTra(phieuTra);
        this.setSanPham(sanPham);
        this.setSoLuongTra(soLuongTra);
        this.setLiDoTra(liDoTra);
    }

    public PhieuTraNhaCungCap getPhieuTra() {
        return phieuTra;
    }

    public void setPhieuTra(PhieuTraNhaCungCap phieuTra) {
        this.phieuTra = phieuTra;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getSoLuongTra() {
        return soLuongTra;
    }
    /**
     * Set số lượng trả cho nhà cung cấp phải lớn hơn 0 <br></br>
     * Nếu số lượng trả cho nhà cung cấp lớn hơn thì sẽ xuất ra exception "Số lượng trả cho nhà cung cấp lớn hơn 0"
     */
    public void setSoLuongTra(int soLuongTra) throws Exception {
        if(soLuongTra>0)
            this.soLuongTra = soLuongTra;
        else
            throw new Exception("Số lượng mặt hàng trả cho nhà cung cấp lớn hơn 0!");
    }


    public String getLiDoTra() {
        return liDoTra;
    }

    public void setLiDoTra(String liDoTra) {
        this.liDoTra = liDoTra;
    }

    @Override
    public String toString() {
        return "ChiTietPhieuTraNhaCungCap{" +
                "phieuTra=" + phieuTra +
                ", sanPham=" + sanPham +
                ", soLuongTra=" + soLuongTra +
                ", liDoTra='" + liDoTra + '\'' +
                '}';
    }
}
