package dev.skyherobrine.app.controllers.dashboardui.order;

import dev.skyherobrine.app.daos.order.PhieuNhapHangDAO;
import dev.skyherobrine.app.entities.order.PhieuNhapHang;
import dev.skyherobrine.app.views.dashboard.component.QuanLyNhapHang;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class NhapHangController implements MouseListener {
    private QuanLyNhapHang nhapHangUI;
    private PhieuNhapHangDAO phieuNhapHangDAO;
    private List<PhieuNhapHang> dsPhieuNhap;

    private static int trangThaiNutXoaPN = 0;
    private static int trangThaiNutThemPN = 0;
    private static int trangThaiNutNhapFilePN = 0;

    public NhapHangController(QuanLyNhapHang nhapHangUI) {
        try {
            phieuNhapHangDAO = new PhieuNhapHangDAO();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.nhapHangUI = nhapHangUI;
    }

    public void loadPhieuNhap() {
        DefaultTableModel clearTable = (DefaultTableModel) nhapHangUI.getTbDanhSachPheiNhap().getModel();
        clearTable.setRowCount(0);
        nhapHangUI.getTbDanhSachPheiNhap().setModel(clearTable);
        try {
            dsPhieuNhap = phieuNhapHangDAO.timKiem();
            DefaultTableModel tmKhachHang = (DefaultTableModel) nhapHangUI.getTbDanhSachPheiNhap().getModel();
            for(PhieuNhapHang pn : dsPhieuNhap){
                String row[] = {pn.getMaPhieuNhap(), pn.getNhaCungCap().getTenNCC(), pn.getNgayLapPhieu().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), pn.getNgayHenGiao().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), pn.getTinhTrang().toString()};
                tmKhachHang.addRow(row);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(trangThaiNutThemPN==1){
            JOptionPane.showMessageDialog(null, "Đang thực hiện chức năng thêm, không được click!!");
        }else {
            int row = nhapHangUI.getTbDanhSachPheiNhap().getSelectedRow();
            String ma = nhapHangUI.getTbDanhSachPheiNhap().getValueAt(row, 0).toString();
            Optional<PhieuNhapHang> pnHienThuc = null;
            try {
                pnHienThuc = phieuNhapHangDAO.timKiem(ma);
            } catch (Exception event) {
                throw new RuntimeException(event);
            }

            nhapHangUI.getTxtMaPhieuNhap().setText(pnHienThuc.get().getMaPhieuNhap());
            nhapHangUI.getTxtNhaCungCap().setText(pnHienThuc.get().getNhaCungCap().getTenNCC());
            nhapHangUI.getTxtDiaChi().setText(pnHienThuc.get().getNhaCungCap().getDiaChiNCC());
            nhapHangUI.getTxtDiaChi().setCaretPosition(0);
            nhapHangUI.getTxtEmailNhaCungCap().setText(pnHienThuc.get().getNhaCungCap().getEmail());
            nhapHangUI.getTxtNgayLapPhieu().setText(pnHienThuc.get().getNgayLapPhieu().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

            //Xử lý ngày
            String date = String.valueOf(pnHienThuc.get().getNgayHenGiao());
            Date ngayHenGiao = null;
            try {
                ngayHenGiao = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            nhapHangUI.getjDateChooserNgayHenGiao().setDate(ngayHenGiao);
            nhapHangUI.getTxtTongTienSanPham().setText(String.valueOf(tongTienSanPhamNhap()));
        }
    }

    private double tongTienSanPhamNhap() {
        DefaultTableModel tmGioHang = (DefaultTableModel) nhapHangUI.getTbDanhSachSpTrongGioHang().getModel();
        double tongTien = 0;
        for(int i = 0; i < tmGioHang.getRowCount(); i++){
            tongTien+=(Double.parseDouble(tmGioHang.getValueAt(i, 6).toString())*1.08);
        }
        return tongTien;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
