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

    public NhaCungCap(String maNCC, String tenNCC, String diaChiNCC, String email, TinhTrangNhaCungCap tinhTrang) throws Exception {
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
    /**
     * Set tên nhà cung cấp không được rỗng <br></br>
     * Nếu tên nhà cung cấp rỗng thì sẽ xuất ra exception "Tên nhà cung cấp không được rỗng!"
     */
    public void setTenNCC(String tenNCC) throws Exception {
        if(!(tenNCC.equalsIgnoreCase("")))
            this.tenNCC = tenNCC;
        else
            throw new Exception("Tên nhà cung cấp không được rỗng!");
    }

    public String getDiaChiNCC() {
        return diaChiNCC;
    }
    /**
     * Set địa chỉ nhà cung cấp không được rỗng <br></br>
     * Nếu địa chỉ nhà cung cấp rỗng thì sẽ xuất ra exception "Địa chỉ nhà cung cấp không được rỗng!"
     */
    public void setDiaChiNCC(String diaChiNCC) throws Exception {
        if(!(diaChiNCC.equalsIgnoreCase("")))
            this.diaChiNCC = diaChiNCC;
        else
            throw new Exception("Địa chỉ nhà cung cấp không được rỗng!");
    }

    public String getEmail() {
        return email;
    }
    /**
     * Set email nhà cung cấp không được rỗng <br></br>
     * Nếu email nhà cung cấp rỗng thì sẽ xuất ra exception "Email không được rỗng!" <br></br>
     * Kiểm tra email có đúng định dạng hay không <br></br>
     * Nếu email sai định dạng thì sẽ xuất ra exception "Email phải có định dạng [kí tự]@gmail.com. Ví dụ: 'abc@gmail.com' !"
     */
    public void setEmail(String email) throws Exception {
        if(!(email.equalsIgnoreCase(""))){
            if(!(email.matches("([\\w{1,}][.][\\w{1,}]|[\\w{1,}])+@gmail\\.com$")))
                throw new Exception("Email phải có định dạng [kí tự]@gmail.com. Ví dụ: 'abc@gmail.com' !");
            else
                this.email = email;
        }
        else
            throw new Exception("Email không được rỗng!");
    }

    public TinhTrangNhaCungCap getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(TinhTrangNhaCungCap tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
