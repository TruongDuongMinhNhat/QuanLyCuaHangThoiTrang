package dev.skyherobrine.app.enums;

public enum TinhTrangNhapHang {
    DANG_CHUYEN(0), DA_NHAN(1);
    private int value;
    TinhTrangNhapHang(int value) {
        this.value = value;
    }

    public static TinhTrangNhapHang layGiaTri(int value) {
        return value == 0 ? DANG_CHUYEN : DA_NHAN;
    }

    public static int layGiaTri(TinhTrangNhapHang tinhTrang) {
        return tinhTrang.value;
    }

    public static TinhTrangNhapHang layGiaTri(String value) {
        return value.toUpperCase().equalsIgnoreCase(DANG_CHUYEN.toString()) ? DANG_CHUYEN : DA_NHAN;
    }
}
