package dev.skyherobrine.app.entities.sale;

import java.time.LocalDateTime;

public class Thue {
    private String maThue;
    private double giaTri;
    private LocalDateTime ngayApDung;
    private boolean hieuLuc;

    public Thue(String maThue, double giaTri, LocalDateTime ngayApDung, boolean hieuLuc) {
        this.maThue = maThue;
        this.giaTri = giaTri;
        this.ngayApDung = ngayApDung;
        this.hieuLuc = hieuLuc;
    }

    public String getMaThue() {
        return maThue;
    }

    public void setMaThue(String maThue) {
        this.maThue = maThue;
    }

    public double getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(double giaTri) {
        this.giaTri = giaTri;
    }

    public LocalDateTime getNgayApDung() {
        return ngayApDung;
    }

    public void setNgayApDung(LocalDateTime ngayApDung) {
        this.ngayApDung = ngayApDung;
    }

    public boolean isHieuLuc() {
        return hieuLuc;
    }

    public void setHieuLuc(boolean hieuLuc) {
        this.hieuLuc = hieuLuc;
    }

    @Override
    public String toString() {
        return "Thue{" +
                "maThue='" + maThue + '\'' +
                ", giaTri=" + giaTri +
                ", ngayApDung=" + ngayApDung +
                ", hieuLuc=" + hieuLuc +
                '}';
    }
}
