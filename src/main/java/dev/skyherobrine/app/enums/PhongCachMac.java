package dev.skyherobrine.app.enums;

public enum PhongCachMac {
    NAM(1), NU(2), NAM_NU(3);
    private int value;
    PhongCachMac(int value) {
        this.value = value;
    }
    public PhongCachMac layGiaTri(int value) {
        switch (value) {
            case 1 -> {return NAM;}
            case 2 -> {return NU;}
            case 3 -> {return NAM_NU;}
            default -> throw new NullPointerException("Không có giá trị nào ứng với phong cách mặc nào cả");
        }
    }

    public int layGiaTri(PhongCachMac phongCachMac){
        return phongCachMac.value;
    }
}
