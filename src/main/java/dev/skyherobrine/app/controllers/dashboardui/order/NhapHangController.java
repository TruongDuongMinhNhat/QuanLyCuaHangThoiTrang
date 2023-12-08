package dev.skyherobrine.app.controllers.dashboardui.order;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import dev.skyherobrine.app.daos.order.PhieuNhapHangDAO;
import dev.skyherobrine.app.daos.person.NhaCungCapDAO;
import dev.skyherobrine.app.daos.product.ChiTietPhienBanSanPhamDAO;
import dev.skyherobrine.app.daos.product.SanPhamDAO;
import dev.skyherobrine.app.entities.order.ChiTietPhieuNhapHang;
import dev.skyherobrine.app.entities.order.ChiTietPhieuNhapHangPhienBanSP;
import dev.skyherobrine.app.entities.order.PhieuNhapHang;
import dev.skyherobrine.app.entities.person.KhachHang;
import dev.skyherobrine.app.entities.person.NhaCungCap;
import dev.skyherobrine.app.entities.person.NhanVien;
import dev.skyherobrine.app.entities.product.ChiTietPhienBanSanPham;
import dev.skyherobrine.app.entities.product.SanPham;
import dev.skyherobrine.app.enums.TinhTrangNhanVien;
import dev.skyherobrine.app.enums.TinhTrangNhapHang;
import dev.skyherobrine.app.views.dashboard.component.QuanLyNhapHang;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class NhapHangController implements MouseListener, KeyListener, TableModelListener, ActionListener, PropertyChangeListener {
    private QuanLyNhapHang nhapHangUI;
    private PhieuNhapHangDAO phieuNhapHangDAO;
    private List<PhieuNhapHang> dsPhieuNhap;
    private NhaCungCapDAO nhaCungCapDAO;
    private DefaultListModel<String> modelNCC;
    private ChiTietPhienBanSanPhamDAO chiTietPhienBanSanPhamDAO;
    private SanPhamDAO sanPhamDAO;


    private static Map<String, Integer> dsSPLuuTam = new HashMap<>();
    private static int trangThaiNutXuatFilePN = 0;
    private static int trangThaiNutThemPN = 0;
    private static int trangThaiNutSuaPN = 0;

    private static List<PhieuNhapHang> dsLoc;
    private List<PhieuNhapHang> dsTam = new ArrayList<>();

    public NhapHangController(QuanLyNhapHang nhapHangUI) {
        try {
            phieuNhapHangDAO = new PhieuNhapHangDAO();
            chiTietPhienBanSanPhamDAO = new ChiTietPhienBanSanPhamDAO();
            nhaCungCapDAO = new NhaCungCapDAO();
            sanPhamDAO = new SanPhamDAO();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.nhapHangUI = nhapHangUI;
    }

    //Ham load phieu nhap hang
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
        tuongTac(false);
    }

    //Su kien click tren table phieu nhap
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

    //Ham tinh tong tien san pham
    private double tongTienSanPhamNhap() {
        DefaultTableModel tmGioHang = (DefaultTableModel) nhapHangUI.getTbDanhSachSpTrongGioHang().getModel();
        double tongTien = 0;
        for(int i = 0; i < tmGioHang.getRowCount(); i++){
            tongTien+=(Double.parseDouble(tmGioHang.getValueAt(i, 6).toString())*1.08);
        }
        return tongTien;
    }

    //Tim kiem san pham de nhap
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            if(e.getSource().equals(nhapHangUI.getTxtTimKiemSanPhamNhap())){
                nhapHangUI.getListSPNhap().setSelectedIndex(nhapHangUI.getListSPNhap().getSelectedIndex()+1);
                nhapHangUI.getListSPNhap().requestFocus();
            }else if(e.getSource().equals(nhapHangUI.getTxtNhaCungCap())){
                nhapHangUI.getListNCCNhap().setSelectedIndex(nhapHangUI.getListNCCNhap().getSelectedIndex()+1);
                nhapHangUI.getListNCCNhap().requestFocus();
            }
        }else if(e.getKeyCode()==KeyEvent.VK_ENTER) {
            if (e.getSource().equals(nhapHangUI.getListSPNhap())) {
                String sp = nhapHangUI.getListSPNhap().getSelectedValue().toString();
                if(themSP(sp)){
                    nhapHangUI.getFmPBSP().setVisible(true);
                    nhapHangUI.getTxtTimKiemSanPhamNhap().setText("");
                    nhapHangUI.getTxtTimKiemSanPhamNhap().requestFocus(true);
                    nhapHangUI.getMenuSPNhap().setVisible(false);
                }else{
                    nhapHangUI.getTxtTimKiemSanPhamNhap().requestFocus(true);
                }
            }else{
                loadTTNCC(nhapHangUI.getListNCCNhap().getSelectedValue().toString());
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String textSP = nhapHangUI.getTxtTimKiemSanPhamNhap().getText().trim();
        String textNCC = nhapHangUI.getTxtNhaCungCap().getText().trim();
        if(e.getKeyCode()!=KeyEvent.VK_DOWN && e.getKeyCode()!=KeyEvent.VK_UP && e.getKeyCode()!=KeyEvent.VK_ENTER ){
            if(e.getSource().equals(nhapHangUI.getTxtTimKiemSanPhamNhap())){
                if(!textSP.equalsIgnoreCase("")) {
                    searchSuggestSP(textSP);
                }else{
                    nhapHangUI.getMenuSPNhap().setVisible(false);
                }
            }
            else{
                if(!textNCC.equalsIgnoreCase("")){
                    searchSuggestNCC(textNCC);
                }else{
                    nhapHangUI.getMenuNCCNhap().setVisible(false);
                }
            }
        }
    }

    //Tìm sản phẩm
    public void searchSuggestSP(String textSP){
        DefaultListModel<String> listModelSP = new DefaultListModel<>();
        nhapHangUI.getListSPNhap().setModel(listModelSP);
        listModelSP.removeAllElements();
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("MaPhienBanSP", textSP);
        String []colNames= {"MaPhienBanSP", "KichThuoc", "SoLuong"};
        try {
            List<Map<String, Object>> listSP = chiTietPhienBanSanPhamDAO.timKiem(conditions, false, colNames);
            if(listSP.size()==0){
                nhapHangUI.getMenuSPNhap().setVisible(false);
            }else{
                int soLuong = 0;
                for(int i = 0; i < listSP.size(); i++){
                    soLuong = Integer.parseInt(listSP.get(i).get("SoLuong").toString());
                    listModelSP.addElement(listSP.get(i).get("MaPhienBanSP").toString()+"   ||   Số lượng: "+soLuong);
                }
                nhapHangUI.getMenuSPNhap().show(nhapHangUI.getTxtTimKiemSanPhamNhap(), 0, nhapHangUI.getTxtTimKiemSanPhamNhap().getHeight());
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    //Tìm nhà cung cấp
    public void searchSuggestNCC(String textNCC){
        List<NhaCungCap> listNCC;
        DefaultListModel<String> listModelNCC = new DefaultListModel<>();
        nhapHangUI.getListNCCNhap().setModel(listModelNCC);
        listModelNCC.removeAllElements();
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("TenNCC", textNCC);
        try {
            listNCC = nhaCungCapDAO.timKiem(conditions);
            if(listNCC.size()==0){
                nhapHangUI.getMenuNCCNhap().setVisible(false);
            }else{
                for(int i = 0; i < listNCC.size(); i++){
                    listModelNCC.addElement(listNCC.get(i).getTenNCC());
                }
                nhapHangUI.getMenuNCCNhap().show(nhapHangUI.getTxtNhaCungCap(), 0, nhapHangUI.getTxtNhaCungCap().getHeight());
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    //load thông tin nhà cung cấp
    public boolean loadTTNCC(String tenNCC) {
        // TODO implement here
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("TenNCC", tenNCC);
        try {
            List<NhaCungCap> ncc = nhaCungCapDAO.timKiem(conditions);
            if(ncc.size()!=0) {
                nhapHangUI.getTxtNhaCungCap().setText(ncc.get(0).getTenNCC());
                nhapHangUI.getTxtDiaChi().setText(ncc.get(0).getDiaChiNCC());
                nhapHangUI.getTxtEmailNhaCungCap().setText(ncc.get(0).getEmail());
                nhapHangUI.getMenuNCCNhap().setVisible(false);
                return true;
            }
//            nhapHangUI.getTxtMaPhieuNhap().setText(layMaPhieuNhap());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    //Thêm sản phẩm vào giỏ hàng
    public boolean themSP(String maPBSP){
        Optional<ChiTietPhienBanSanPham> pbsp = null;
        DefaultTableModel tmGioHang = (DefaultTableModel) nhapHangUI.getTbDanhSachSpTrongGioHang().getModel();
        String mapbsp = "";
        mapbsp = maPBSP.substring(0, maPBSP.indexOf(" "));
//        System.out.println(mapbsp);
        String maSP = "";
        maSP = mapbsp.substring(0, mapbsp.indexOf("-"));
//        System.out.println(maSP);
        Optional<SanPham> sp  = null;
        try {
            sp = sanPhamDAO.timKiem(maSP);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int stt = tmGioHang.getRowCount() + 1;
        int sl = 10;
        double gia = 0;
        String []row = {stt+"", maSP, sp.get().getTenSP(),null, sl+"", gia+"", thanhTien(sl, gia)+"", null};
        tmGioHang.addRow(row);
        nhapHangUI.getTxtTongTienSanPham().setText(tinhTT()+"");
        return true;
    }

    //Tính thành tiền
    private double thanhTien(int sl, Double gia) {
        double tt = 0;
        tt = sl*gia;
        return tt;
    }

    //Tính tổng tiền sản phẩm
    public double tinhTT(){
        DefaultTableModel tmGioHang = (DefaultTableModel) nhapHangUI.getTbDanhSachSpTrongGioHang().getModel();
        double tt = 0;
        for(int i = 0; i < tmGioHang.getRowCount(); i++){
            tt+=(Double.parseDouble(tmGioHang.getValueAt(i, 6).toString()));
        }
        return tt;
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        if(e.getColumn()==5){
            DefaultTableModel tmGioHang = (DefaultTableModel) nhapHangUI.getTbDanhSachSpTrongGioHang().getModel();
            int row = e.getFirstRow();
            int sl = Integer.parseInt(tmGioHang.getValueAt(row, 4).toString());
            double gia = Double.parseDouble(tmGioHang.getValueAt(row, 5).toString());
            tmGioHang.setValueAt(sl*gia, row, 6);
            double tt = 0;
            for(int i = 0; i < tmGioHang.getRowCount(); i++){
                tt += Double.parseDouble(tmGioHang.getValueAt(i, 6).toString());
            }
            nhapHangUI.getTxtTongTienSanPham().setText(tt+"");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object op = e.getSource();
        /*NÚT THÊM*/
        if(op.equals(nhapHangUI.getBtnThemPhieuNhap())){
            // Thực hiện biến đổi các nút thành nút chức năng của nghiệp vụ thêm phieu nhap
            if (trangThaiNutThemPN==0) {
                nhapHangUI.getBtnThemPhieuNhap().setText("Thêm và duyệt");
                nhapHangUI.getBtnSuaPhieuNhap().setText("Thêm phiếu");
                nhapHangUI.getBtnXuatFile().setText("Thoát thêm");
                trangThaiNutXuatFilePN = 1;
                trangThaiNutThemPN = 1;
                trangThaiNutSuaPN = 1;

                //Mở tương tác với thông tin
                tuongTac(true);
                tuongTacTimKiem(false);

                //Xóa trắng dữ liệu
                xoaTrangAll();
                nhapHangUI.getTxtMaPhieuNhap().setEnabled(false);
            }
            // Thực hiện chức năng nghiệp vụ thêm phiếu nhập và duyệt
            else if(trangThaiNutThemPN==1) {

            }
            //Thực hiện chức năng nghiệp vụ sửa nhân viên
            else if(trangThaiNutThemPN==2){
//                if (nhapHangUI.getTxtMaNhanVien().getText().equals("")) {
//                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần sửa!");
//                }else {
//                    NhanVien nvSua = layDataSua();
//                    if ((JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa nhân viên có mã " +nvSua.getMaNV()+" không?", "Lựa chọn", JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION){
//                        try {
//                            if(nhanVienDAO.capNhat(nvSua)){
//                                loadDsNhanVien();
//                                xoaTrangAll();
//                                JOptionPane.showMessageDialog(null, "Sửa thành công!");
//                                trangThaiNutThemPN = 2;
//                            }else{
//                                JOptionPane.showMessageDialog(null, "Sửa thất bại!");
//                            }
//                        } catch (Exception ex) {
//                            throw new RuntimeException(ex);
//                        }
//                    }
//                }
//                trangThaiNutXuatFilePN = 1;
            }
        }

        /*NÚT SỬA*/
//        if(op.equals(nhapHangUI.getBtnSuaPhieuNhap())){
//            // Thực hiện biến đổi các nút thành nút chức năng của nghiệp vụ sửa nhân viên
//            if (trangThaiNutSuaPN==0) {
//                //Mở tương tác với thông tin
//                tuongTac(true);
//
//                nhapHangUI.getBtnThemPhieuNhap().setText("Xác nhận sửa");
//                nhapHangUI.getBtnSuaPhieuNhap().setText("Xóa trắng");
//                nhapHangUI.getBtnXuatFile().setText("Thoát sửa");
//                trangThaiNutThemPN = 2;
//                trangThaiNutSuaPN = 1;
//                trangThaiNutXuatFilePN = 1;
//                nhapHangUI.getTxtMaNhanVien().setEnabled(false);
//            }
//            // Thực hiện xóa trắng dữ liệu ở nghiệp vụ sửa thông tín nhân viên
//            else if(trangThaiNutSuaPN==1) {
//                xoaTrangSua();
//            }
//        }

        /*NÚT XÓA*/
        if (op.equals(nhapHangUI.getBtnXuatFile())) {
            // Thực hiện chức năng nghiệp vụ xóa nhân viên
            if (trangThaiNutXuatFilePN==0) {
//                if (nhapHangUI.getTxtMatKhauNhanVien().getText().equals("")) {
//                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần xóa!");
//                } else {
//                    String ma = nhapHangUI.getTxtMaNhanVien().getText();
//                    if ((JOptionPane.showConfirmDialog(null,
//                            "Bạn có chắc muốn ngừng bán nhân viên có mã " + nhapHangUI.getTxtMaNhanVien().getText() + " không?", "Lựa chọn",
//                            JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION) {
//                        try {
//                            if (nhanVienDAO.xoa(ma)){
//                                loadDsNhanVien();
//                                xoaTrangAll();
//                                JOptionPane.showMessageDialog(null, "Xóa thành công!");
//                            }else {
//                                JOptionPane.showMessageDialog(null, "Xóa thất bại!");
//                            }
//                        } catch (Exception e1) {
//                            e1.printStackTrace();
//                        }
//                    }
//                }
            }
            // Thực hiện trả các nút về giao diện quản lý nhân viên
            else if(trangThaiNutXuatFilePN==1) {
                tuongTac(false);
                tuongTacTimKiem(true);
                xoaTrangAll();
                nhapHangUI.getBtnThemPhieuNhap().setText("Thêm phiếu nhập");
                nhapHangUI.getBtnSuaPhieuNhap().setText("Sửa phiếu nhập");
                nhapHangUI.getBtnXuatFile().setText("Xuất file");
                trangThaiNutXuatFilePN = 0;
                trangThaiNutThemPN = 0;
                trangThaiNutSuaPN = 0;
            }
        }

        /*LỌC PHIẾU NHẬP*/
        if(op.equals(nhapHangUI.getCbTkNhaCungCap()) || op.equals(nhapHangUI.getCbTkTinhTrang())){
            if(nhapHangUI.getjDateChooserTkNgayLapPhieu().getDate() == null && nhapHangUI.getjDateChooserTkNgayHenGiao().getDate() == null){
                if(!nhapHangUI.getCbTkNhaCungCap().getSelectedItem().equals("--Nhà cung cấp--")){
                    List<NhaCungCap> ncc;
                    Map<String, Object> conditions = new HashMap<>();
                    conditions.put("TenNCC", nhapHangUI.getCbTkNhaCungCap().getSelectedItem().toString());
                    try {
                        ncc = nhaCungCapDAO.timKiem(conditions);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    Map<String, Object> conditions1 = new HashMap<>();
                    conditions1.put("MaNCC", ncc.get(0).getMaNCC());
                    try {
                        dsLoc = phieuNhapHangDAO.timKiem(conditions1);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    if(!nhapHangUI.getCbTkTinhTrang().getSelectedItem().equals("--Tình trạng--")){
                        for(int i=0; i<dsLoc.size(); i++){
                            if(nhapHangUI.getCbTkTinhTrang().getSelectedItem().equals(dsLoc.get(i).getTinhTrang().toString())){
                                dsTam.add(dsLoc.get(i));
                            }
                        }
                        dsLoc = dsTam;
                        dsTam = new ArrayList<>();
                    }
                }
                else if (!nhapHangUI.getCbTkTinhTrang().getSelectedItem().equals("--Tình trạng--")) {
                    Map<String, Object> conditions = new HashMap<>();
                    conditions.put("TinhTrang", nhapHangUI.getCbTkTinhTrang().getSelectedItem().toString());
                    try {
                        dsLoc = phieuNhapHangDAO.timKiem(conditions);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else {
                    try {
                        dsLoc = phieuNhapHangDAO.timKiem();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
            else if (nhapHangUI.getjDateChooserTkNgayHenGiao().getDate() != null) {
                Map<String,Object> conditions = new HashMap<>();
                conditions.put("NgayHenGiao", dateToLocalDate(nhapHangUI.getjDateChooserTkNgayHenGiao().getDate()));
                try {
                    dsLoc = phieuNhapHangDAO.timKiem(conditions);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                if(nhapHangUI.getjDateChooserTkNgayLapPhieu().getDate() != null){
                    for (int i=0; i<dsLoc.size(); i++){
                        if(dateToLocalDate(nhapHangUI.getjDateChooserTkNgayLapPhieu().getDate()).equals(dsLoc.get(i).getNgayLapPhieu())){
                            dsTam.add(dsLoc.get(i));
                        }
                    }
                    dsLoc = dsTam;
                    dsTam = new ArrayList<>();
                    if (!nhapHangUI.getCbTkTinhTrang().getSelectedItem().equals("--Tình trạng--")){
                        for (int i=0; i<dsLoc.size(); i++){
                            if(nhapHangUI.getCbTkTinhTrang().getSelectedItem().equals(dsLoc.get(i).getTinhTrang().toString())){
                                dsTam.add(dsLoc.get(i));
                            }
                        }
                        dsLoc = dsTam;
                        dsTam = new ArrayList<>();
                        if(!nhapHangUI.getCbTkNhaCungCap().getSelectedItem().equals("--Nhà cung cấp--")){
                            for (int i=0; i<dsLoc.size(); i++){
                                if(nhapHangUI.getCbTkNhaCungCap().getSelectedItem().equals(dsLoc.get(i).getNhaCungCap().getTenNCC())){
                                    dsTam.add(dsLoc.get(i));
                                }
                            }
                            dsLoc = dsTam;
                            dsTam = new ArrayList<>();
                        }
                    }
                }
                else if (!nhapHangUI.getCbTkTinhTrang().getSelectedItem().equals("--Tình trạng--")) {
                    for (int i=0; i<dsLoc.size(); i++){
                        if(nhapHangUI.getCbTkTinhTrang().getSelectedItem().equals(dsLoc.get(i).getTinhTrang().toString())){
                            dsTam.add(dsLoc.get(i));
                        }
                    }
                    dsLoc = dsTam;
                    dsTam = new ArrayList<>();
                    if(!nhapHangUI.getCbTkNhaCungCap().getSelectedItem().equals("--Nhà cung cấp--")){
                        for (int i=0; i<dsLoc.size(); i++){
                            if(nhapHangUI.getCbTkNhaCungCap().getSelectedItem().equals(dsLoc.get(i).getNhaCungCap().getTenNCC())){
                                dsTam.add(dsLoc.get(i));
                            }
                        }
                        dsLoc = dsTam;
                        dsTam = new ArrayList<>();
                    }
                }
            }

            DefaultTableModel clearTable = (DefaultTableModel) nhapHangUI.getTbDanhSachPheiNhap().getModel();
            clearTable.setRowCount(0);
            nhapHangUI.getTbDanhSachPheiNhap().setModel(clearTable);
            try {
                DefaultTableModel tmKhachHang = (DefaultTableModel) nhapHangUI.getTbDanhSachPheiNhap().getModel();
                for(PhieuNhapHang pn : dsLoc){
                    String row[] = {pn.getMaPhieuNhap(), pn.getNhaCungCap().getTenNCC(), pn.getNgayLapPhieu().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), pn.getNgayHenGiao().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), pn.getTinhTrang().toString()};
                    tmKhachHang.addRow(row);
                }
            } catch (Exception ee) {
                throw new RuntimeException(ee);
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        handlePropertyChange(evt);
    }

    private void handlePropertyChange(PropertyChangeEvent evt) {
        Object source = evt.getSource();
        String propertyName = evt.getPropertyName();
        nhapHangUI.getjDateChooserTkNgayLapPhieu().setName("NgayLapTK");
        nhapHangUI.getjDateChooserTkNgayHenGiao().setName("NgayHenTK");
        if ("date".equals(propertyName) && source instanceof JDateChooser) {
            JDateChooser dateChooser = (JDateChooser) source;
            String dateChooserName = dateChooser.getName();

            if ("NgayLapTK".equals(dateChooserName) || "NgayHenTK".equals(dateChooserName)) {
                if(!nhapHangUI.getCbTkNhaCungCap().getSelectedItem().equals("--Nhà cung cấp--")){
                    List<NhaCungCap> ncc;
                    Map<String, Object> conditions = new HashMap<>();
                    conditions.put("TenNCC", nhapHangUI.getCbTkNhaCungCap().getSelectedItem().toString());
                    try {
                        ncc = nhaCungCapDAO.timKiem(conditions);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    Map<String, Object> conditions1 = new HashMap<>();
                    conditions1.put("MaNCC", ncc.get(0).getMaNCC());
                    try {
                        dsLoc = phieuNhapHangDAO.timKiem(conditions1);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    if(!nhapHangUI.getCbTkTinhTrang().getSelectedItem().equals("--Tình trạng--")){
                        for(int i=0; i<dsLoc.size(); i++){
                            if(nhapHangUI.getCbTkTinhTrang().getSelectedItem().equals(dsLoc.get(i).getTinhTrang().toString())){
                                dsTam.add(dsLoc.get(i));
                            }
                        }
                        dsLoc = dsTam;
                        dsTam = new ArrayList<>();
                        if(nhapHangUI.getjDateChooserTkNgayLapPhieu().getDate() != null){
                            for(int i=0; i<dsLoc.size(); i++){
                                if(dateToLocalDate(nhapHangUI.getjDateChooserTkNgayLapPhieu().getDate()).equals(dsLoc.get(i).getNgayLapPhieu())){
                                    dsTam.add(dsLoc.get(i));
                                }
                            }
                            dsLoc = dsTam;
                            dsTam = new ArrayList<>();
                        }
                        if(nhapHangUI.getjDateChooserTkNgayLapPhieu().getDate() != null){
                            for (int i=0; i<dsLoc.size(); i++){
                                if(dsLoc.get(i).getNgayLapPhieu().equals(dateToLocalDate(nhapHangUI.getjDateChooserTkNgayLapPhieu().getDate()))){
                                    dsTam.add(dsLoc.get(i));
                                }
                            }
                            dsLoc = dsTam;
                            dsTam = new ArrayList<>();
                            if(nhapHangUI.getjDateChooserTkNgayHenGiao().getDate() != null);{
                                for (int i=0; i<dsLoc.size(); i++){
                                    if(dsLoc.get(i).getNgayHenGiao().equals(dateToLocalDate(nhapHangUI.getjDateChooserTkNgayHenGiao().getDate()))){
                                        dsTam.add(dsLoc.get(i));
                                    }
                                }
                                dsLoc = dsTam;
                                dsTam = new ArrayList<>();
                            }
                        }
                    }


                }else if(!nhapHangUI.getCbTkTinhTrang().getSelectedItem().equals("--Tình trạng--")) {
                    Map<String, Object> conditions = new HashMap<>();
                    conditions.put("TinhTrang", nhapHangUI.getCbTkTinhTrang().getSelectedItem().toString());
                    try {
                        dsLoc = phieuNhapHangDAO.timKiem(conditions);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    for(int i=0; i<dsLoc.size(); i++){
                        if(nhapHangUI.getCbTkTinhTrang().getSelectedItem().equals(dsLoc.get(i).getTinhTrang().toString())){
                            dsTam.add(dsLoc.get(i));
                        }
                    }
                    dsLoc = dsTam;
                    dsTam = new ArrayList<>();
                    if(nhapHangUI.getjDateChooserTkNgayLapPhieu().getDate() != null){
                        for(int i=0; i<dsLoc.size(); i++){
                            if(dateToLocalDate(nhapHangUI.getjDateChooserTkNgayLapPhieu().getDate()).equals(dsLoc.get(i).getNgayLapPhieu())){
                                dsTam.add(dsLoc.get(i));
                            }
                        }
                        dsLoc = dsTam;
                        dsTam = new ArrayList<>();
                    }
                    if(nhapHangUI.getjDateChooserTkNgayLapPhieu().getDate() != null){
                        for (int i=0; i<dsLoc.size(); i++){
                            if(dsLoc.get(i).getNgayLapPhieu().equals(dateToLocalDate(nhapHangUI.getjDateChooserTkNgayLapPhieu().getDate()))){
                                dsTam.add(dsLoc.get(i));
                            }
                        }
                        dsLoc = dsTam;
                        dsTam = new ArrayList<>();
                        if(nhapHangUI.getjDateChooserTkNgayHenGiao().getDate() != null);{
                            for (int i=0; i<dsLoc.size(); i++){
                                if(dsLoc.get(i).getNgayHenGiao().equals(dateToLocalDate(nhapHangUI.getjDateChooserTkNgayHenGiao().getDate()))){
                                    dsTam.add(dsLoc.get(i));
                                }
                            }
                            dsLoc = dsTam;
                            dsTam = new ArrayList<>();
                        }
                    }
                }else if (nhapHangUI.getjDateChooserTkNgayLapPhieu().getDate() != null){
                    Map<String, Object> conditions = new HashMap<>();
                    conditions.put("NgayLapPhieu", dateToLocalDate(nhapHangUI.getjDateChooserTkNgayLapPhieu().getDate()));
                    try {
                        dsLoc = phieuNhapHangDAO.timKiem(conditions);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }

                DefaultTableModel clearTable = (DefaultTableModel) nhapHangUI.getTbDanhSachPheiNhap().getModel();
                clearTable.setRowCount(0);
                nhapHangUI.getTbDanhSachPheiNhap().setModel(clearTable);
                try {
                    DefaultTableModel tmKhachHang = (DefaultTableModel) nhapHangUI.getTbDanhSachPheiNhap().getModel();
                    for(PhieuNhapHang pn : dsLoc){
                        String row[] = {pn.getMaPhieuNhap(), pn.getNhaCungCap().getTenNCC(), pn.getNgayLapPhieu().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), pn.getNgayHenGiao().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), pn.getTinhTrang().toString()};
                        tmKhachHang.addRow(row);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        return instant.atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private void tuongTacTimKiem(boolean b) {
        nhapHangUI.getCbTkNhaCungCap().setEnabled(b);
        nhapHangUI.getCbTkTinhTrang().setEnabled(b);
        nhapHangUI.getjDateChooserTkNgayLapPhieu().setEnabled(b);
        nhapHangUI.getjDateChooserTkNgayHenGiao().setEnabled(b);
        nhapHangUI.getTxtTkPhieuNhap().setEnabled(b);
    }

    private void tuongTac(boolean b) {
        nhapHangUI.getTxtDiaChiCuaHang().setEnabled(b);
        nhapHangUI.getTxtDienThoaiCuaHang().setEnabled(b);
        nhapHangUI.getTxtEmailCUaHang().setEnabled(b);

        nhapHangUI.getTxtNhaCungCap().setEnabled(b);
        nhapHangUI.getTxtEmailNhaCungCap().setEnabled(b);
        nhapHangUI.getTxtDiaChi().setEnabled(b);

        nhapHangUI.getTxtMaPhieuNhap().setEnabled(b);
        nhapHangUI.getTxtNgayLapPhieu().setEnabled(b);
        nhapHangUI.getjDateChooserNgayHenGiao().setEnabled(b);
        nhapHangUI.getTxtTimKiemSanPhamNhap().setEnabled(b);
    }

    //Ham xoa trang
    public void xoaTrangAll(){
        nhapHangUI.getTxtNhaCungCap().setText("");
        nhapHangUI.getTxtDiaChi().setText("");
        nhapHangUI.getTxtEmailNhaCungCap().setText("");
        nhapHangUI.getTxtMaPhieuNhap().setText("");
        nhapHangUI.getTxtNgayLapPhieu().setText("");
        nhapHangUI.getjDateChooserNgayHenGiao().setDate(null);
        nhapHangUI.getTxtTongTienSanPham().setText("");
        nhapHangUI.getTxtTinhTrangPhieuNhap().setText("");
        DefaultTableModel clearTable = (DefaultTableModel) nhapHangUI.getTbDanhSachSpTrongGioHang().getModel();
        clearTable.setRowCount(0);
        nhapHangUI.getTbDanhSachSpTrongGioHang().setModel(clearTable);
    }
    //Load combobox tìm kiếm
    public void loadComboBoxPhanTimKiem(){
        //Tình trạng
        TinhTrangNhapHang[] dsTinhTrang = TinhTrangNhapHang.values();
        String[] itemsTinhTrang = new String[dsTinhTrang.length + 1];
        itemsTinhTrang[0] = "--Tình trạng--";
        for (int i = 0; i < dsTinhTrang.length; i++) {
            itemsTinhTrang[i + 1] = dsTinhTrang[i].toString();
        }
        DefaultComboBoxModel<String> tinhTrangCb = new DefaultComboBoxModel<>(itemsTinhTrang);
        nhapHangUI.getCbTkTinhTrang().setModel(tinhTrangCb);

        //Nhà cung cấp
        List<NhaCungCap> ncc;
        try {
            ncc = nhaCungCapDAO.timKiem();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String[] itemsNCC = new String[ncc.size() + 1];
        itemsNCC[0] = "--Nhà cung cấp--";
        for(int i=0; i<ncc.size(); i++){
            itemsNCC[i+1] = ncc.get(i).getTenNCC().toString();
        }
        DefaultComboBoxModel<String> nccCb = new DefaultComboBoxModel<>(itemsNCC);
        nhapHangUI.getCbTkNhaCungCap().setModel(nccCb);
    }

    //Lấy data để thêm
    private PhieuNhapHang layDataPhieuNhap() {
        PhieuNhapHang phieuNhapHang;
        String mapn = nhapHangUI.getTxtMaPhieuNhap().getText();
        List<NhaCungCap> nhaCC = new ArrayList<>();
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("TenNCC", nhapHangUI.getTxtNhaCungCap().toString());
        try {
            nhaCC = nhaCungCapDAO.timKiem(conditions);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        LocalDateTime ngayLapPhieu = LocalDateTime.parse(nhapHangUI.getTxtNgayLapPhieu().getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDateTime ngayHenGiao = LocalDateTime.of((nhapHangUI.getjDateChooserNgayHenGiao().getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalTime.of(0, 0, 0));
        String ghiChu = nhapHangUI.getTxtGhiChu().getText();
        TinhTrangNhapHang tt = TinhTrangNhapHang.layGiaTri(nhapHangUI.getTxtTinhTrangPhieuNhap().getText());
        phieuNhapHang = new PhieuNhapHang(mapn,nhaCC.get(0),ngayLapPhieu,ngayHenGiao,ghiChu,tt);
        return phieuNhapHang;
    }


//    private ChiTietPhieuNhapHangPhienBanSP layDataCTNHPBSP() {
//
//    }
//
//    private ChiTietPhieuNhapHang layDataChiTietPhieuNhap() {
//
//    }
}
