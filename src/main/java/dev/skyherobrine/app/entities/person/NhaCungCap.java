package dev.skyherobrine.app.entities.person;

import dev.skyherobrine.app.enums.TinhTrangNhaCungCap;

/**
 * Thực thể nhà cung cấp, nhà cung cấp sẽ thực hiện cung cấp các sản phẩm đến cửa hàng, cửa hàng sẽ nhập các mặt
 * hàng do nhà cung cấp đến cung cấp. Mọi thông tin về sản phẩm được cung cấp từ ai sẽ lấy dữ liệu từ thực thể
 * này.
 * @author Trương Dương Minh Nhật
 * @version 1.0
 */
public class NhaCungCap {
    private String maNCC;
    private String tenNCC;
    private String diaChiNCC;
    private String email;
    private TinhTrangNhaCungCap tinhTrang;

    public NhaCungCap(String maNCC, String tenNCC, String diaChiNCC, String email, TinhTrangNhaCungCap tinhTrang) {
        this.setMaNCC(maNCC);
        this.setTenNCC(tenNCC);
        this.setDiaChiNCC(diaChiNCC);
        this.setEmail(email);
        this.setTinhTrang(tinhTrang);
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiaChiNCC() {
        return diaChiNCC;
    }

    public void setDiaChiNCC(String diaChiNCC) {
        this.diaChiNCC = diaChiNCC;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TinhTrangNhaCungCap getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(TinhTrangNhaCungCap tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
