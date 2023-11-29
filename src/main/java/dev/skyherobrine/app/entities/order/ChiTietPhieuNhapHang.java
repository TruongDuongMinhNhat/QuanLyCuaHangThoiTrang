package dev.skyherobrine.app.entities.order;

import dev.skyherobrine.app.entities.product.SanPham;

/**
 * Thực thể "Chi Tiết Phiếu Nhập", thực thể này dùng để lưu trữ thông tin chi tiết về nhập hàng, sản phẩm
 * nhập với số lượng là bao nhiêu? Số tiền nhập hàng ứng với sản phẩm đó là bao nhiêu?
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class ChiTietPhieuNhapHang {
    private String maChiTietPhieuNhap;
    private PhieuNhapHang phieuNhapHang;
    private SanPham sanPham;
    private double giaNhap;

    public ChiTietPhieuNhapHang(String maChiTietPhieuNhap, PhieuNhapHang phieuNhapHang, SanPham sanPham, double giaNhap) throws Exception{
        this.setMaChiTietPhieuNhap(maChiTietPhieuNhap);
        this.setPhieuNhapHang(phieuNhapHang);
        this.setSanPham(sanPham);
        this.setGiaNhap(giaNhap);
    }

    public PhieuNhapHang getPhieuNhapHang() {
        return phieuNhapHang;
    }

    public void setPhieuNhapHang(PhieuNhapHang phieuNhapHang) {
        this.phieuNhapHang = phieuNhapHang;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }



    public double getGiaNhap() {
        return giaNhap;
    }
    /**
     * set số giá nhập phải lớn hơn 0
     * Nếu số giá nhập bằng 0 thì sẽ xuất ra exception "Giá nhập lớn hơn 0"
     */
    public void setGiaNhap(double giaNhap) throws Exception {
        if(giaNhap>0)
            this.giaNhap = giaNhap;
        else
            throw new Exception("Giá nhập phải lớn hơn 0!");
    }

    public String getMaChiTietPhieuNhap() {
        return maChiTietPhieuNhap;
    }

    public void setMaChiTietPhieuNhap(String maChiTietPhieuNhap) {
        this.maChiTietPhieuNhap = maChiTietPhieuNhap;
    }

    /**
     * Tính tiền nhập hàng. Công thức tính: <b>Giá Nhập * Số Lượng Nhập = Giá Tiền Trả</b>
     * @return {@link double} trả về số thực là số tiền nhập ứng với sản phẩm này.
     */

    @Override
    public String toString() {
        return "ChiTietPhieuNhapHang{" +
                "maChiTietPhieuNhap='" + maChiTietPhieuNhap +
                ", phieuNhapHang=" + phieuNhapHang +
                ", sanPham=" + sanPham +
                ", giaNhap=" + giaNhap +
                '}';
    }

}
