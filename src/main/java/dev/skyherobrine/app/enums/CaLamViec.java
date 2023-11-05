package dev.skyherobrine.app.enums;

public enum CaLamViec {
    CA_1(1), CA_2(2);
    private int value;
    CaLamViec(int value) {
        this.value = value;
    }

    public static CaLamViec layGiaTri(int value) {
        return value == 1 ? CA_1 : CA_2;
    }

    public static int layGiaTri(CaLamViec ca){
        return ca.value;
    }
}
