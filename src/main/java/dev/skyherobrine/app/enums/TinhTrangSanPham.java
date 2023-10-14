package dev.skyherobrine.app.enums;

public enum TinhTrangSanPham {
    CON_BAN(1), HET_HANG(0), KHONG_CON_BAN(-1);
    private int value;
    TinhTrangSanPham(int value) { this.value = value; }
    public static TinhTrangSanPham layGiaTri(int value) {
        return value == 1 ? CON_BAN : (value == 0 ? HET_HANG : KHONG_CON_BAN);
    }

    public static int layGiaTri(TinhTrangSanPham tinhTrang) {
        return tinhTrang.value;
    }
}
