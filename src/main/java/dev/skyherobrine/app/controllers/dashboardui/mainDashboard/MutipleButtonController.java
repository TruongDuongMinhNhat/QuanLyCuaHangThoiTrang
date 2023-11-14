package dev.skyherobrine.app.controllers.dashboardui.mainDashboard;

import dev.skyherobrine.app.daos.order.ChiTietPhieuNhapHangDAO;
import dev.skyherobrine.app.daos.product.SanPhamDAO;
import dev.skyherobrine.app.entities.order.ChiTietPhieuNhapHang;
import dev.skyherobrine.app.entities.product.SanPham;
import dev.skyherobrine.app.views.dashboard.component.LapHoaDon;
import dev.skyherobrine.app.views.dashboard.component.lapHoaDon.setting.danhSachSanPham.EventItemSelected;
import dev.skyherobrine.app.views.dashboard.component.lapHoaDon.setting.danhSachSanPham.Item;
import dev.skyherobrine.app.views.dashboard.component.lapHoaDon.setting.danhSachSanPham.MultipleButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Optional;

public class MutipleButtonController implements ActionListener, KeyListener, EventItemSelected {

    private static MultipleButton multipleButton;
    private static SanPhamDAO sanPhamDAO;
    private static int soLuongSP;
    private static ChiTietPhieuNhapHangDAO chiTietPhieuNhapHangDAO;
    public MutipleButtonController(MultipleButton multipleButton){
        try {
            sanPhamDAO = new SanPhamDAO();
            chiTietPhieuNhapHangDAO = new ChiTietPhieuNhapHangDAO();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.multipleButton = multipleButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public int loadSP(List<SanPham> dsSP) throws Exception {
        // TODO implement here
        soLuongSP = dsSP.size();
        multipleButton.removeAll();
        for(SanPham sp : dsSP){
            multipleButton.add(createItem("/img/imgSanPham/"+sp.getHinhAnh(), sp.getTenSP()+" - "+sp.getKichThuoc(), getGiaSP(sp.getMaSP(),sp.getPhanTramLoi())+"", sp.getSoLuong()+""));
        }
        multipleButton.repaint();
        multipleButton.revalidate();
        return soLuongSP;
    }
    public String fixTenSP(String name){
        String nameSP = name;
        if(name.length() > 27){
            nameSP = nameSP.substring(0, 18) +"..."+ nameSP.substring(name.length()-6);
        }
        return nameSP;
    }
    public double getGiaSP(String maSP, double ptLoi) throws Exception {

        Optional<ChiTietPhieuNhapHang> SP = chiTietPhieuNhapHangDAO.timKiem(maSP);

        if(SP.isPresent()){
            double giaSP = SP.get().getGiaNhap();
            double tienLoi = giaSP*(ptLoi/100);
            return giaSP + tienLoi;
        }
        else{
            throw new Exception("Không tìm thấy sản phẩm");
        }
    }
    private Item createItem(String url, String name, String price, String amount) {

        Item item = new Item(url, fixTenSP(name), price, amount);
        return item;
    }


    @Override
    public void selected(int index) {
        // TODO implement here
        SanPham sp = (SanPham) multipleButton.getItems().get(index);
        try {
            if(LapHoaDonController.checkSP(sp.getMaSP()) == 0){
                LapHoaDonController.loadTable(sp, getGiaSP(sp.getMaSP(), sp.getPhanTramLoi()));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
