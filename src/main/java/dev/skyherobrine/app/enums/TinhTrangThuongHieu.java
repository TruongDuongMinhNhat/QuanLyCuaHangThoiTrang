package dev.skyherobrine.app.enums;

public enum TinhTrangThuongHieu {
    HOP_TAC(1), TAM_NGUNG(0), KHONG_HOP_TAC(-1);
    private int value;
    TinhTrangThuongHieu(int value) { this.value = value; }

    public static TinhTrangThuongHieu layGiaTri(int value) {
        switch (value){
            case 1 -> { return HOP_TAC; }
            case 0 -> { return TAM_NGUNG; }
            case -1 -> {return  KHONG_HOP_TAC; }
            default -> throw new NullPointerException("Không tìm thấy loại tình trạng ứng với giá trị này.");
        }
    }

    public static int layGiaTri(TinhTrangThuongHieu tinhTrang) {
        return tinhTrang.value;
    }
}
