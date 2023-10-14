package dev.skyherobrine.app.enums;

public enum TinhTrangTraHang {
    CHUA_NHAN_HANG(0), DA_NHAN_HANG(1);
    private int value;
    TinhTrangTraHang(int value) {
        this.value = value;
    }

    public static TinhTrangTraHang layGiaTri(int value) {
        return value == 0 ? CHUA_NHAN_HANG : DA_NHAN_HANG;
    }

    public static int layGiaTri(TinhTrangTraHang tinhTrang) {
        return tinhTrang.value;
    }
}
