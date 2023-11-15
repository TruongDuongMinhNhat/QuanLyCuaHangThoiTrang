package dev.skyherobrine.app.controllers.dashboardui.mainDashboard;

import dev.skyherobrine.app.controllers.loginui.mainLogin.LoginController;
import dev.skyherobrine.app.daos.ConnectDB;
import dev.skyherobrine.app.daos.order.ChiTietHoaDonDAO;
import dev.skyherobrine.app.daos.order.HoaDonDAO;
import dev.skyherobrine.app.daos.person.KhachHangDAO;
import dev.skyherobrine.app.daos.person.NhanVienDAO;
import dev.skyherobrine.app.daos.product.DanhMucSanPhamDAO;
import dev.skyherobrine.app.daos.product.LoaiSanPhamDAO;
import dev.skyherobrine.app.daos.product.SanPhamDAO;
import dev.skyherobrine.app.entities.order.ChiTietHoaDon;
import dev.skyherobrine.app.entities.order.HoaDon;
import dev.skyherobrine.app.entities.person.KhachHang;
import dev.skyherobrine.app.entities.person.NhanVien;
import dev.skyherobrine.app.entities.product.DanhMucSanPham;
import dev.skyherobrine.app.entities.product.LoaiSanPham;
import dev.skyherobrine.app.entities.product.SanPham;
import dev.skyherobrine.app.views.dashboard.component.LapHoaDon;
import dev.skyherobrine.app.views.dashboard.component.lapHoaDon.setting.danhSachSanPham.MultipleButton;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.Option;
import java.awt.event.*;
import java.awt.image.SampleModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.lang.Math.abs;


public class LapHoaDonController implements ActionListener, KeyListener, FocusListener, MouseListener, TableModelListener {
    private static LapHoaDon lapHoaDon;
    private static MultipleButton multipleButton;
    private static NhanVienDAO nhanVienDAO;
    private static SanPhamDAO  sanPhamDAO;
    private static HoaDonDAO hoaDonDAO;
    private static DanhMucSanPhamDAO danhMucSanPhamDAO;
    private static LoaiSanPhamDAO loaiSanPhamDAO;
    private static KhachHangDAO khachHangDAO;
    private static List<KhachHang> dsKH;
    private static List<SanPham> items;
    private static ConnectDB connectDB;
    private static ChiTietHoaDonDAO chiTietHoaDonDAO;
    private static double tt = 0;
    public LapHoaDonController(LapHoaDon lapHoaDon) {
        try {
            nhanVienDAO = new NhanVienDAO();
            sanPhamDAO =  new SanPhamDAO();
            khachHangDAO = new KhachHangDAO();
            hoaDonDAO = new HoaDonDAO();
            danhMucSanPhamDAO = new DanhMucSanPhamDAO();
            loaiSanPhamDAO =  new LoaiSanPhamDAO();
            this.connectDB = new ConnectDB();
            chiTietHoaDonDAO = new ChiTietHoaDonDAO();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        this.lapHoaDon = lapHoaDon;
        this.multipleButton = multipleButton;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o.toString().equalsIgnoreCase(lapHoaDon.getCbLoai().toString())){
            if(lapHoaDon.getCbLoai().getSelectedItem().equals("Tất cả")){
                try {
                    loadSP();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }else{
                JComboBox<String> cb = (JComboBox<String>) o;
                String value = cb.getSelectedItem().toString();
                Map<String, Object> conditions = new HashMap<>();
                conditions.put("MaLoai", getMaLoai(value));

                try {
                    List<SanPham> dsSP = sanPhamDAO.timKiem(conditions);
                    lapHoaDon.getMultipleButton1().removeAll();
                    lapHoaDon.getMultipleButton1().setItems(dsSP);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }else if(o.toString().equalsIgnoreCase(lapHoaDon.getCbDanhMuc().toString())){
            if(lapHoaDon.getCbDanhMuc().getSelectedItem().equals("Tất cả")){
                try {
                    loadSP();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }else{
                lapHoaDon.getCbLoai().setSelectedItem("Tất cả");
                JComboBox<String> cb = (JComboBox<String>) o;
                String valueDM = cb.getSelectedItem().toString();
                Map<String, Object> conditions = new HashMap<>();
                conditions.put("MaDM", getMaDM(valueDM));
                try {
                    List<LoaiSanPham> loaiSP = loaiSanPhamDAO.timKiem(conditions);
                    List<SanPham> dsSP = new ArrayList<>();

                    for(LoaiSanPham loai : loaiSP){
                        Map<String, Object> conditionsLoai = new HashMap<>();
                        conditionsLoai.put("MaLoai", loai.getMaLoai());
                        List<SanPham> listSP = sanPhamDAO.timKiem(conditionsLoai);
                        dsSP.addAll(listSP);
                    }
                    lapHoaDon.getMultipleButton1().removeAll();
                    lapHoaDon.getMultipleButton1().setItems(dsSP);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }else{
            lapHoaDon();
            xoaTrang();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if(lapHoaDon.getTxtSĐTKhachHang().isFocusable()==true){
                lapHoaDon.getTxtSĐTKhachHang().setFocusable(false);
                lapHoaDon.getTxtSĐTKhachHang().setFocusable(true);
            }
        }else{
            if(lapHoaDon.getTxtTimKiemDsSp().isFocusable()==true){
                lapHoaDon.getTxtTimKiemDsSp().setFocusable(false);
                lapHoaDon.getTxtTimKiemDsSp().setFocusable(true);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
//        if(e.getSource().toString().)
    }

    public static void loadTTNV() throws Exception {
        // TODO implement here
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("TenTaiKhoan", LoginController.luuTkNhanVien());
        List<NhanVien> nhanViens = nhanVienDAO.timKiem(conditions);

        lapHoaDon.getTxtTenNhanVien().setText(nhanViens.get(0).getHoTen());
        lapHoaDon.getTxtMaNhanVien().setText(nhanViens.get(0).getMaNV());
        lapHoaDon.getTxtSoDienThoaiNhanVien().setText(nhanViens.get(0).getSoDienThoai());
        lapHoaDon.getTxtThue().setText("8 %");
    }
    public static void loadTable(SanPham sp, double giaBan) throws Exception {
        DefaultTableModel tmHoaDon = (DefaultTableModel) lapHoaDon.getjTable1().getModel();
        int sl = 1;
        String rows[] = {sp.getMaSP(),sp.getTenSP(), sp.getKichThuoc(), sl+"", giaBan+"", sl*giaBan+""};
        tmHoaDon.addRow(rows);
        String thue = lapHoaDon.getTxtThue().getText();
        int index = thue.indexOf(" ");
        double thueSP = Double.parseDouble(thue.substring(0, index));
        tt += (giaBan+giaBan*(thueSP/100));
        lapHoaDon.getTxtChietKhau().setText(CheckCK(tt)+"");
        tt -= giaBan*CheckCK(tt)/100;

        lapHoaDon.getTxtTongSoTienThanhToan().setText(tt+"");
        lapHoaDon.getTxtTongSoTienThanhToan().setEditable(false);
    }

    public static String getMaLoai(String ten){
        try {
            Map<String, Object> conditions = new HashMap<>();
            conditions.put("TenLoai", ten);
            List<LoaiSanPham> maloai = loaiSanPhamDAO.timKiem(conditions);
            for(LoaiSanPham lsp : maloai){
                return lsp.getMaLoai().toString();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static String getMaDM(String ten){
        try {
            Map<String, Object> conditions = new HashMap<>();
            conditions.put("TenDM", ten);
            List<DanhMucSanPham> maDM = danhMucSanPhamDAO.timKiem(conditions);
            for(DanhMucSanPham dmsp : maDM){
                return dmsp.getMaDM().toString();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static int checkSP(String maSP){
        DefaultTableModel tmHoaDon = (DefaultTableModel) lapHoaDon.getjTable1().getModel();
        double tht = 0;
        for(int i = 0; i < tmHoaDon.getRowCount(); i++){
            if(tmHoaDon.getValueAt(i, 0).toString().equalsIgnoreCase(maSP)){

                tht = Double.parseDouble(tmHoaDon.getValueAt(i, 5).toString());
                tmHoaDon.removeRow(i);
                String thue = lapHoaDon.getTxtThue().getText();
                int index = thue.indexOf(" ");
                double thueSP = Double.parseDouble(thue.substring(0, index));
                tt = 0;
                for(int j = 0; j < tmHoaDon.getRowCount(); j++){
                    tt += Double.parseDouble(tmHoaDon.getValueAt(j, 5).toString());
                }

                lapHoaDon.getTxtChietKhau().setText(CheckCK(tht)+"");
                double tinhThue = tt*CheckCK(tt)/100 - tt*thueSP/100;
                tt -= (tinhThue);
                lapHoaDon.getTxtChietKhau().setText(CheckCK(tt)+"");
                lapHoaDon.getTxtTongSoTienThanhToan().setText(tt+"");
                return 1;
            }
        }
        return 0;
    }

    public static void loadSP() throws Exception {
        items =  sanPhamDAO.timKiem();
        lapHoaDon.getMultipleButton1().setItems(items);
    }

    private static void layDsKH(String SDT) {
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("SoDienThoai", SDT);


        try {
            dsKH = khachHangDAO.timKiem(conditions);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void xoaTrang() {
        tt = 0.00;
        DefaultTableModel tmHoaDon = (DefaultTableModel) lapHoaDon.getjTable1().getModel();
        tmHoaDon.setRowCount(0);
        lapHoaDon.getTxtNgayLap().setText("");
        lapHoaDon.getTxtMaHoaDon().setText("");
        lapHoaDon.getTxtTenKh().setText("");
        lapHoaDon.getTxtNgaySinhKh().setText("");
        lapHoaDon.getTxtSĐTKhachHang().setText("");
        lapHoaDon.getTxtSoTienKhachPhaiTra().setText("");
        lapHoaDon.getTxtTongSoTienThanhToan().setText("");
        lapHoaDon.getTxtAGhiChu().setText("");
        lapHoaDon.getTxtTongSoTienThanhToan().setText(tt+"");
    }

    public static void lapHoaDon(){
        try {
            DefaultTableModel tmHoaDon = (DefaultTableModel) lapHoaDon.getjTable1().getModel();
            Optional<NhanVien> nv = nhanVienDAO.timKiem(lapHoaDon.getTxtMaNhanVien().getText());
            LocalDateTime ngayLap = LocalDateTime.parse(lapHoaDon.getTxtNgayLap().getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
            HoaDon hd = new HoaDon(lapHoaDon.getTxtMaHoaDon().getText(), ngayLap, nv.get(),dsKH.get(0), new BigDecimal(lapHoaDon.getTxtSoTienKhachPhaiTra().getText()), lapHoaDon.getTxtAGhiChu().getText());
            hoaDonDAO.them(hd);
            for(int i = 0; i < tmHoaDon.getRowCount(); i++){
                Optional<SanPham> sp = sanPhamDAO.timKiem(tmHoaDon.getValueAt(i, 0).toString());
                ChiTietHoaDon cthd = new ChiTietHoaDon(hd, sp.get(), Integer.parseInt(tmHoaDon.getValueAt(i, 3).toString()));
                chiTietHoaDonDAO.them(cthd);
                sp.get().setSoLuong(sp.get().getSoLuong()-Integer.parseInt(tmHoaDon.getValueAt(i, 3).toString()));
                sanPhamDAO.capNhat(sp.get());
            }
            xuatPDF();
            loadSP();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void xuatPDF(){
        try {
            DefaultTableModel tmHoaDon = (DefaultTableModel) lapHoaDon.getjTable1().getModel();
            JasperDesign jd = JRXmlLoader.load("src/main/resources/HoaDon/hoadon.jrxml");
            Map<String, Object> data= new HashMap<>();
            JasperReport report = JasperCompileManager.compileReport(jd);
            for(int i = 0; i < tmHoaDon.getRowCount(); i++){
                data.put("ThanhTien", tmHoaDon.getValueAt(i, 5).toString());

            }
            double tienTT = Double.parseDouble(lapHoaDon.getTxtTongSoTienThanhToan().getText());
            double tienKhachDua = Double.parseDouble(lapHoaDon.getTxtSoTienKhachPhaiTra().getText());
            String maHD = lapHoaDon.getTxtMaHoaDon().getText();
            data.put("maHD", maHD);
            data.put("TongTien", tienTT);
            data.put("tienKhachDua", tienKhachDua);
            data.put("tienThua", abs(tienTT - tienKhachDua));
            JasperPrint print = JasperFillManager.fillReport(report, data, connectDB.getConnection());
            JasperViewer.viewReport(print, false);
            JasperExportManager.exportReportToPdfFile(print, "src/main/resources/HoaDon/DanhSachHoaDon/"+ lapHoaDon.getTxtMaHoaDon().getText() +".pdf");

        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadHD(){
        String maHD = "HD-";
        String nl = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")).toString();
        maHD = maHD+nl+"-";
        String SDT = lapHoaDon.getTxtSĐTKhachHang().getText();
        SDT = SDT.substring(SDT.length()-3);
        maHD = maHD + SDT + "-";
        maHD = maHD + formatNumber(laySoHoaDon());
        lapHoaDon.getTxtMaHoaDon().setText(maHD);
        LocalDateTime local = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        lapHoaDon.getTxtNgayLap().setText(local.format(dateTimeFormatter));
    }

    public static int laySoHoaDon(){
        String nlap = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")).toString();

        Map<String, Object> conditions = new HashMap<>();
        conditions.put("maHD", "%"+nlap+"%");
        List<HoaDon> hoaDons = new ArrayList<>();
        try {
            hoaDons = hoaDonDAO.timKiem(conditions);
        } catch (Exception e) {
            return 1;
        }
        if(hoaDons.size()==0){
            return 1;
        }
        System.out.println(hoaDons);
        HoaDon hd = hoaDons.get(hoaDons.size()-1);
        int soHD = Integer.parseInt(hd.getMaHD().substring(hd.getMaHD().length()-3));
        return soHD+1;
    }
    public static String formatNumber(int number) {
        if(number < 10)
            return String.format("00%d", number);
        else if((number >= 10) && (number < 100))
            return String.format("0%d", number);
        else
            return String.format("%d", number);
    }
    public static void loadDanhMuc(){
        try {
            List<DanhMucSanPham> dmsp = danhMucSanPhamDAO.timKiem();
            lapHoaDon.getCbDanhMuc().addItem("Tất cả");
            for(DanhMucSanPham sp : dmsp){
                lapHoaDon.getCbDanhMuc().addItem(sp.getTenDM());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void loadLoai(){
        try {
            List<LoaiSanPham> loaisp = loaiSanPhamDAO.timKiem();
            lapHoaDon.getCbLoai().addItem("Tất cả");
            for(LoaiSanPham sp : loaisp){
                lapHoaDon.getCbLoai().addItem(sp.getTenLoai());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        Object o = e.getSource();
        if(o.toString().equalsIgnoreCase(lapHoaDon.getTxtSĐTKhachHang().toString())){
            if(!lapHoaDon.getTxtSĐTKhachHang().toString().equalsIgnoreCase("")){
                layDsKH(lapHoaDon.getTxtSĐTKhachHang().getText());
                lapHoaDon.getTxtTenKh().setText(dsKH.get(0).getHoTen());
                lapHoaDon.getTxtNgaySinhKh().setText(dsKH.get(0).getNgaySinh().toString());
                loadHD();
            }
        }
        else{
            String tenSP = lapHoaDon.getTxtTimKiemDsSp().getText();
            Map<String, Object> conditions = new HashMap<>();
            conditions.put("TenSP", "%"+tenSP+"%");
            try {
                List<SanPham> dsSP = sanPhamDAO.timKiem(conditions);
                lapHoaDon.getMultipleButton1().removeAll();
                lapHoaDon.getMultipleButton1().setItems(dsSP);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    public static int CheckCK(double tt){
        if(tt < 500000){
            return 0;
        }
        else if(tt < 2000000){
            return 10;
        }
        else{
            return 15;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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

    @Override
    public void tableChanged(TableModelEvent e) {

        // TODO Auto-generated method stub
        if(e.getColumn()==3){
            DefaultTableModel tmHoaDon = (DefaultTableModel) lapHoaDon.getjTable1().getModel();
            int row = e.getFirstRow();
            int count = Integer.parseInt(tmHoaDon.getValueAt(row, 3).toString());
            SanPham sp = null;
            double tta = 0;
            try {
                sp = sanPhamDAO.timKiem(tmHoaDon.getValueAt(row, 0).toString()).get();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            String ptThue = lapHoaDon.getTxtThue().getText();
            int index = ptThue.indexOf(" ");
            double thue = Double.parseDouble(ptThue.substring(0, index));
            if(count<0) {
                tmHoaDon.setValueAt("1", row, 3);
            } else if (count > sp.getSoLuong()){
                tmHoaDon.setValueAt(sp.getSoLuong()+"", row, 3);
            }

            BigDecimal giaTien = new BigDecimal(tmHoaDon.getValueAt(row, 4).toString());
            double gia = giaTien.doubleValue()*count;
            tmHoaDon.setValueAt(gia+"", row, 5);
            for(int i = 0; i < tmHoaDon.getRowCount(); i++){
                tta += Double.parseDouble(tmHoaDon.getValueAt(i, 5).toString());
            }
            tt = tta;
            lapHoaDon.getTxtChietKhau().setText(CheckCK(tt)+"");
            double tinhThue = tt*CheckCK(tt)/100 - tt*thue/100;
            tt -= (tinhThue);


            if(tt < 0){
                lapHoaDon.getTxtTongSoTienThanhToan().setText(0+"");
            }else{
                lapHoaDon.getTxtTongSoTienThanhToan().setText(tt+"");
            }

        }

    }
}
