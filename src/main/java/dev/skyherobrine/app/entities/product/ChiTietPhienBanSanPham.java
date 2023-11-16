package dev.skyherobrine.app.entities.product;

import dev.skyherobrine.app.enums.MauSac;

public class ChiTietPhienBanSanPham {
    private SanPham sanPham;
    private MauSac mauSac;
    private String kichThuoc;
    private int soLuong;
    private String hinhAnh;

    public ChiTietPhienBanSanPham(SanPham sanPham, MauSac mauSac, String kichThuoc, int soLuong, String hinhAnh) {
        setSanPham(sanPham);
        setMauSac(mauSac);
        setKichThuoc(kichThuoc);
        setSoLuong(soLuong);
        setHinhAnh(hinhAnh);
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    @Override
    public String toString() {
        return "ChiTietPhienBanSanPham{" +
                "sanPham=" + sanPham +
                ", mauSac=" + mauSac +
                ", kichThuoc='" + kichThuoc + '\'' +
                ", soLuong=" + soLuong +
                ", hinhAnh='" + hinhAnh + '\'' +
                '}';
    }
}
