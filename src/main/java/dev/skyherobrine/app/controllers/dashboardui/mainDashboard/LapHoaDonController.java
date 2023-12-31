package dev.skyherobrine.app.controllers.dashboardui.mainDashboard;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import dev.skyherobrine.app.controllers.loginui.mainLogin.LoginController;
import dev.skyherobrine.app.daos.ConnectDB;
import dev.skyherobrine.app.daos.order.ChiTietHoaDonDAO;
import dev.skyherobrine.app.daos.order.ChiTietPhieuNhapHangDAO;
import dev.skyherobrine.app.daos.order.HoaDonDAO;
import dev.skyherobrine.app.daos.person.KhachHangDAO;
import dev.skyherobrine.app.daos.person.NhanVienDAO;
import dev.skyherobrine.app.daos.product.ChiTietPhienBanSanPhamDAO;
import dev.skyherobrine.app.daos.product.SanPhamDAO;
import dev.skyherobrine.app.entities.order.ChiTietHoaDon;
import dev.skyherobrine.app.entities.order.HoaDon;
import dev.skyherobrine.app.entities.person.KhachHang;
import dev.skyherobrine.app.entities.person.NhanVien;
import dev.skyherobrine.app.entities.product.ChiTietPhienBanSanPham;
import dev.skyherobrine.app.entities.product.SanPham;
import dev.skyherobrine.app.views.dashboard.component.LapHoaDon;
import dev.skyherobrine.app.views.dashboard.component.haiNut.TableActionEvent1;

import dev.skyherobrine.app.views.dashboard.component.motNut.TableActionEvent;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static java.lang.Math.abs;

public class LapHoaDonController implements KeyListener, Runnable, ThreadFactory, ActionListener, TableModelListener, TableActionEvent1, TableActionEvent {
    private LapHoaDon lapHoaDon;
    private ChiTietHoaDonDAO chiTietHoaDonDAO;
    private DefaultListModel<String> listModel;
    private ChiTietPhienBanSanPhamDAO chiTietPhienBanSanPhamDAO;
    private WebcamPanel pnCam = null;
    private Webcam webcam = null;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    private SanPhamDAO sanPhamDAO;
    private NhanVienDAO nhanVienDAO;
    private KhachHangDAO khachHangDAO;
    private HoaDonDAO hoaDonDAO;
    private DefaultListModel<String> listModelKH;
    private ChiTietPhieuNhapHangDAO chiTietPhieuNhapHangDAO;
    private ConnectDB connectDB;
    private static Map<String, Object> dsSPTAM = new HashMap<>();
    private static Map<String, Integer> dsSPLuuTam = new HashMap<>();
    private static int count = 0;
    public LapHoaDonController(LapHoaDon lapHoaDon) {
        this.lapHoaDon = lapHoaDon;
        try {
            this.chiTietPhienBanSanPhamDAO = new ChiTietPhienBanSanPhamDAO();
            this.chiTietPhieuNhapHangDAO = new ChiTietPhieuNhapHangDAO();
            this.sanPhamDAO = new SanPhamDAO();
            this.nhanVienDAO = new NhanVienDAO();
            this.khachHangDAO = new KhachHangDAO();
            this.hoaDonDAO = new HoaDonDAO();
            this.chiTietHoaDonDAO = new ChiTietHoaDonDAO();
            this.connectDB = new ConnectDB();
            loadTTNV();
            setCamera();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void setCamera(){
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0);
        if(webcam.isOpen()){
            webcam.close();
        }
        webcam.setViewSize(size);

        pnCam = new WebcamPanel(webcam);
        pnCam.setPreferredSize(size);
        pnCam.setFPSDisplayed(true);
//       pnCam.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5) );
        pnCam.setSize(new Dimension(463,350));
        pnCam.setLocation(30, 60);
//       lapHoaDon.getPnCamera().add(avb);
        lapHoaDon.getPnCamera().add(pnCam);
        executor.execute(this);
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            if(e.getSource().equals(lapHoaDon.getTxtTimKiemSanPham())){
                lapHoaDon.getListProduct().setSelectedIndex(lapHoaDon.getListProduct().getSelectedIndex()+1);
                lapHoaDon.getListProduct().requestFocus();
            }else if(e.getSource().equals(lapHoaDon.getTxtSoDienThoaiKh())){
                lapHoaDon.getListKhachHang().setSelectedIndex(lapHoaDon.getListKhachHang().getSelectedIndex()+1);
                lapHoaDon.getListKhachHang().requestFocus();
            }
        }else if(e.getKeyCode()==KeyEvent.VK_ENTER) {
            if (e.getSource().equals(lapHoaDon.getListProduct())) {
                String row = lapHoaDon.getListProduct().getSelectedValue().toString();

                if(themSP(row)){
                    lapHoaDon.getTxtTimKiemSanPham().setText("");
                    lapHoaDon.getTxtTimKiemSanPham().requestFocus(true);
                    lapHoaDon.getMenuProduct().setVisible(false);
                }else{
                    lapHoaDon.getTxtTimKiemSanPham().requestFocus(true);
                }
            }else if(e.getSource().equals(lapHoaDon.getTxtTienKhachDua())){
                if(Double.parseDouble(lapHoaDon.getTxtTienKhachDua().getText().toString())-Double.parseDouble(lapHoaDon.getTxtTongTIen().getText().toString())>0){
                    lapHoaDon.getTxtTienDu().setText((Double.parseDouble(lapHoaDon.getTxtTienKhachDua().getText().toString())-Double.parseDouble(lapHoaDon.getTxtTongTIen().getText().toString()))+"");
                }else{
                    JOptionPane.showMessageDialog(lapHoaDon, "Số tiền khách đưa không đủ");
                }
            }else{
                loadTTKH(lapHoaDon.getListKhachHang().getSelectedValue().toString());
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        String textSP = lapHoaDon.getTxtTimKiemSanPham().getText().trim();
        String textKH = lapHoaDon.getTxtSoDienThoaiKh().getText().trim();
       if(e.getKeyCode()!=KeyEvent.VK_DOWN && e.getKeyCode()!=KeyEvent.VK_UP && e.getKeyCode()!=KeyEvent.VK_ENTER ){
           if(e.getSource().equals(lapHoaDon.getTxtTimKiemSanPham())){
               if(!textSP.equalsIgnoreCase("")) {
                   searchSuggestSP(textSP);
               }else{
                   lapHoaDon.getMenuProduct().setVisible(false);
               }
           }else if(e.getSource().equals(lapHoaDon.getTxtTimKiemHoaDonLuuTam())){
               TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) lapHoaDon.getTbHoaDonLuuTam().getModel());
               lapHoaDon.getTbHoaDonLuuTam().setRowSorter(sorter);
               sorter.setRowFilter(RowFilter.regexFilter(lapHoaDon.getTxtTimKiemHoaDonLuuTam().getText().toLowerCase()));
           }
           else{
               if(!textKH.equalsIgnoreCase("")){
                   searchSuggestKH(textKH);
                   if(textKH.length()>=10&& !loadTTKH(textKH)){
                       JOptionPane.showMessageDialog(lapHoaDon, "Không tìm thấy khách hàng");
                       xoaTTKH();
                   }
                   if(textKH.length()<10){
                       xoaTTKH();
                   }
               }else{
                   lapHoaDon.getMenuKhachHang().setVisible(false);
               }
           }
       }
    }
    public void loadTTNV() throws Exception {
        // TODO implement here
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("TenTaiKhoan", LoginController.luuTkNhanVien());
        List<NhanVien> nhanViens = nhanVienDAO.timKiem(conditions);

        lapHoaDon.getTxtTenNhanVien().setText(nhanViens.get(0).getHoTen());
        lapHoaDon.getTxtMaNhanVien().setText(nhanViens.get(0).getMaNV());
        lapHoaDon.getTxtSoDienTHoaiNv().setText(nhanViens.get(0).getSoDienThoai());
    }
    public boolean loadTTKH(String soDienThoai) {
        // TODO implement here
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("SoDienThoai", soDienThoai);
        try {
            List<KhachHang> khachHang = khachHangDAO.timKiem(conditions);
            if(khachHang.size()!=0) {
                lapHoaDon.getTxtSoDienThoaiKh().setText(khachHang.get(0).getSoDienThoai());
                lapHoaDon.getTxtTenKhachHang().setText(khachHang.get(0).getHoTen());
                lapHoaDon.getMenuKhachHang().setVisible(false);
                loadHD();
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public void xoaTTKH(){
        lapHoaDon.getTxtTenKhachHang().setText("");
    }
    public void searchSuggestSP(String textSP){
        listModel = new DefaultListModel<>();
        lapHoaDon.getListProduct().setModel(listModel);
        listModel.removeAllElements();
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("MaPhienBanSP", textSP);
        String []colNames= {"MaPhienBanSP", "KichThuoc", "SoLuong"};
        DefaultTableModel tmGioHang = (DefaultTableModel) lapHoaDon.getTbDanhSachCacSanPhamTrongGioHang().getModel();
        Map<String, Object> dsSP = new HashMap<>();
        for(int i = 0; i < tmGioHang.getRowCount(); i++){
            dsSP.put(tmGioHang.getValueAt(i, 1).toString(), tmGioHang.getValueAt(i, 4));
        }
        try {
            List<Map<String, Object>> listCTPBSP = chiTietPhienBanSanPhamDAO.timKiem(conditions, false, colNames);
            if (listCTPBSP.size() == 0) {
                lapHoaDon.getMenuProduct().setVisible(false);
            } else {
                int soLuong = 0;
                for (int i = 0; i < listCTPBSP.size(); i++) {
                    soLuong = Integer.parseInt(listCTPBSP.get(i).get("SoLuong").toString());
                    if(dsSPLuuTam.containsKey(listCTPBSP.get(i).get("MaPhienBanSP").toString())) {
                        soLuong = soLuong - Integer.parseInt(dsSPLuuTam.get(listCTPBSP.get(i).get("MaPhienBanSP").toString()).toString());
                    }
                    if(dsSP.containsKey(listCTPBSP.get(i).get("MaPhienBanSP").toString())){
                        soLuong = soLuong - Integer.parseInt(dsSP.get(listCTPBSP.get(i).get("MaPhienBanSP").toString()).toString());
                        listModel.addElement(listCTPBSP.get(i).get("MaPhienBanSP").toString()+" Số lượng:"+ soLuong+"");
                    }else{
                        listModel.addElement(listCTPBSP.get(i).get("MaPhienBanSP").toString()+" Số lượng:"+soLuong+"");
                    }
                }
                lapHoaDon.getMenuProduct().show(lapHoaDon.getTxtTimKiemSanPham(), 0, lapHoaDon.getTxtTimKiemSanPham().getHeight());
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    public void searchSuggestKH(String textKH){
        listModelKH = new DefaultListModel<>();
        lapHoaDon.getListKhachHang().setModel(listModelKH);
        listModelKH.removeAllElements();
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("SoDienThoai", textKH);
        try {
            List<Map<String, Object>> listKH = khachHangDAO.timKiem(conditions, false, "SoDienThoai");
            if(listKH.size()==0){
                lapHoaDon.getMenuKhachHang().setVisible(false);
            }else{
                for(int i = 0; i < listKH.size(); i++){
                    listModelKH.addElement(listKH.get(i).get("SoDienThoai").toString());
                }
                lapHoaDon.getMenuKhachHang().show(lapHoaDon.getTxtSoDienThoaiKh(), 0, lapHoaDon.getTxtSoDienThoaiKh().getHeight());
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    public void loadHD(){
        String maHD = "HD-";
        String nl = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")).toString();
        maHD = maHD+nl+"-";
        String SDT = lapHoaDon.getTxtSoDienThoaiKh().getText().trim();
        if(SDT.equalsIgnoreCase("") && lapHoaDon.getjCheckBox1().isSelected()){
            SDT = "KVL";
        }else{
            SDT = SDT.substring(SDT.length()-3);
        }
        maHD = maHD + SDT + "-";
        maHD = maHD + formatNumber(laySoHoaDon());
        lapHoaDon.getTxtMaHoaDon().setText(maHD);
        LocalDateTime local = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        lapHoaDon.getTxtNgayLapHoaDon().setText(local.format(dateTimeFormatter));
    }
//    public void loadTTHD(){
//        LocalDateTime local = LocalDateTime.now();
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//    }
    public int laySoHoaDon(){
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
        HoaDon hd = hoaDons.get(hoaDons.size()-1);
        int soHD = Integer.parseInt(hd.getMaHD().substring(hd.getMaHD().length()-3));
        return soHD+1;
    }
    public void LapHoaDon(){
        DefaultTableModel tmGioHang = (DefaultTableModel) lapHoaDon.getTbDanhSachCacSanPhamTrongGioHang().getModel();
        if(tmGioHang.getRowCount()==0){
            JOptionPane.showMessageDialog(lapHoaDon, "Vui lòng thêm sản phẩm vào giỏ hàng");
        }else {
            if (checkSDT(lapHoaDon.getTxtSoDienThoaiKh().getText().trim())) {
                String maHD = lapHoaDon.getTxtMaHoaDon().getText().trim();
                String maNV = lapHoaDon.getTxtMaNhanVien().getText().trim();
                String ngayLap = lapHoaDon.getTxtNgayLapHoaDon().getText().trim();
                LocalDateTime nl = LocalDateTime.parse(ngayLap, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
                String tienKHTra = lapHoaDon.getTxtTienKhachDua().getText().trim();

                Map<String, Object> conditions = new HashMap<>();
                conditions.put("SoDienThoai", lapHoaDon.getTxtSoDienThoaiKh().getText().trim());
                try {
                    List<KhachHang> khachHangs = khachHangDAO.timKiem(conditions);
                    HoaDon hd = new HoaDon(maHD, nl, nhanVienDAO.timKiem(maNV).get(), khachHangs.get(0), new BigDecimal(tienKHTra), null);
                    hoaDonDAO.them(hd);
                    int sl = 0;
                    Optional<ChiTietPhienBanSanPham> pbsp = Optional.empty();
                    for(int i = 0; i < tmGioHang.getRowCount(); i++){
                        pbsp = chiTietPhienBanSanPhamDAO.timKiem(tmGioHang.getValueAt(i, 1).toString());
                        sl = Integer.parseInt(tmGioHang.getValueAt(i, 4).toString());
                        ChiTietHoaDon cthd = new ChiTietHoaDon(hd, pbsp.get(), sl);
                        System.out.println(cthd);
                        chiTietHoaDonDAO.them(cthd);
                        pbsp.get().setSoLuong(pbsp.get().getSoLuong()-sl);
                        chiTietPhienBanSanPhamDAO.capNhat(pbsp.get());
                    }
                    xuatPDF();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public void xuatPDF(){
        try {
            DefaultTableModel tmHoaDon = (DefaultTableModel) lapHoaDon.getTbDanhSachCacSanPhamTrongGioHang().getModel();
            JasperDesign jd = JRXmlLoader.load("src/main/resources/HoaDon/hoadon.jrxml");
            Map<String, Object> data= new HashMap<>();
            JasperReport report = JasperCompileManager.compileReport(jd);
            for(int i = 0; i < tmHoaDon.getRowCount(); i++){
                data.put("ThanhTien", tmHoaDon.getValueAt(i, 5).toString());

            }
            double tienTT = Double.parseDouble(lapHoaDon.getTxtTongTIen().getText());
            double tienKhachDua = Double.parseDouble(lapHoaDon.getTxtTienKhachDua().getText());
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
    public String formatNumber(int number) {
        if(number < 10)
            return String.format("00%d", number);
        else if((number >= 10) && (number < 100))
            return String.format("0%d", number);
        else
            return String.format("%d", number);
    }
    public boolean themSP(String maPBSP){
        Optional<ChiTietPhienBanSanPham> pbsp = null;
        DefaultTableModel tmGioHang = (DefaultTableModel) lapHoaDon.getTbDanhSachCacSanPhamTrongGioHang().getModel();
        String SL = "1";
        if(maPBSP.contains(" ")){
            SL = maPBSP.substring(maPBSP.indexOf(":")+1);
            maPBSP = maPBSP.substring(0, maPBSP.indexOf(" "));
        }
        try {
            pbsp = chiTietPhienBanSanPhamDAO.timKiem(maPBSP);
            int index = maPBSP.indexOf("-");
            String maSP = maPBSP.substring(0, index);
            Optional<SanPham> sp  = sanPhamDAO.timKiem(maSP);
            Map<String, Object> conditions = new HashMap<>();
            conditions.put("MaSP", maSP);
            sp.get().setChiTietPhieuNhapHangs(chiTietPhieuNhapHangDAO.timKiem(conditions));
            int stt = tmGioHang.getRowCount() + 1;
//            String pbsp = maPBSP.substring(0, maPBSP.indexOf(" "));
            for(int i = 0; i < tmGioHang.getRowCount(); i++){
                if(tmGioHang.getValueAt(i, 1).toString().equalsIgnoreCase(pbsp.get().getMaPhienBanSP())){
                    int soLuong = Integer.parseInt(tmGioHang.getValueAt(i, 4).toString())+1;
                    if(Integer.parseInt(SL)>0){
                        tmGioHang.setValueAt((soLuong*Double.parseDouble(tmGioHang.getValueAt(i, 5).toString())), i,6);
                        tmGioHang.setValueAt(soLuong, i, 4);
                        lapHoaDon.getTxtTongTIen().setText(tinhTT()+"");
                        return true;
                    }else{
                        JOptionPane.showMessageDialog(lapHoaDon, "Sản phẩm không đủ số lượng");
                        return false;
                    }
                }
            }
            int sl = 1;
            DecimalFormat format = new DecimalFormat("0.00");
            double dongia = sp.get().giaBan();
            String []rows = {stt+"", maPBSP, sp.get().getTenSP(), pbsp.get().getKichThuoc(), sl+"", format.format(dongia), format.format(sl*dongia), null};
            tmGioHang.addRow(rows);
            lapHoaDon.getTxtTongTIen().setText(tinhTT()+"");
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public boolean checkSDT(String sdtKH){
        if(sdtKH.equalsIgnoreCase("")){
            if(!lapHoaDon.getjCheckBox1().isSelected()){
                JOptionPane.showMessageDialog(lapHoaDon, "Vui lòng nhập số điện thoại khách hàng!");
                return false;
            }else{
                JOptionPane.showMessageDialog(lapHoaDon, "Không thể lưu tạm khách hàng chưa có thông tin!");
                return false;
            }
        }else{
            if(dsSPTAM.containsKey(sdtKH)) {
                JOptionPane.showMessageDialog(null, "Khách hàng này đã tồn tại hóa đơn lưu tạm");
                return false;
            }
        }
        return true;
    }
    public double tinhTT(){
        DefaultTableModel tmGioHang = (DefaultTableModel) lapHoaDon.getTbDanhSachCacSanPhamTrongGioHang().getModel();
        double tt = 0;
        for(int i = 0; i < tmGioHang.getRowCount(); i++){
            tt+=(Double.parseDouble(tmGioHang.getValueAt(i, 6).toString())*1.08);
        }

        return tt;
    }
    @Override
    public void run() {
        do{
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Result result = null;
            BufferedImage image = null;

            if(webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }
            LuminanceSource source = null;
            source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try{
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                //e.printStackTrace();
            }

            if(result!=null){
                System.out.println(result);
            }
        }while(true);
    }
    public void xoaTrang(){
        DefaultTableModel tmGioHang = (DefaultTableModel) lapHoaDon.getTbDanhSachCacSanPhamTrongGioHang().getModel();
        lapHoaDon.getTxtMaHoaDon().setText("");
        lapHoaDon.getTxtNgayLapHoaDon().setText("");
        lapHoaDon.getTxtTenKhachHang().setText("");
        lapHoaDon.getTxtSoDienThoaiKh().setText("");
        lapHoaDon.getTxtTienKhachDua().setText("");
        lapHoaDon.getTxtTienDu().setText("");
        lapHoaDon.getTxtTongTIen().setText("");
        tmGioHang.setRowCount(0);
    }
    public void loadTbTam(){
        DefaultTableModel tmTam = (DefaultTableModel) lapHoaDon.getTbHoaDonLuuTam().getModel();
        Map<String, Integer> tam = (Map<String, Integer>) dsSPTAM.get(lapHoaDon.getTxtSoDienThoaiKh().getText().trim());
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("SoDienThoai", lapHoaDon.getTxtSoDienThoaiKh().getText().trim());
        try {
            String tenKH = khachHangDAO.timKiem(conditions).get(0).getHoTen().toString();
            String[] rows = {(tmTam.getRowCount()+1)+"", tenKH, lapHoaDon.getTxtSoDienThoaiKh().getText().trim()};
            tmTam.addRow(rows);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(lapHoaDon.getBtnLuuTam())) {
            if (checkSDT(lapHoaDon.getTxtSoDienThoaiKh().getText().trim())) {
                DefaultTableModel tmGioHang = (DefaultTableModel) lapHoaDon.getTbDanhSachCacSanPhamTrongGioHang().getModel();
                Map<String, Integer> pbsp = new HashMap<>();
                if(tmGioHang.getRowCount()==0){
                    JOptionPane.showMessageDialog(lapHoaDon, "Vui lòng thêm sản phẩm vào giỏ hàng");
                }else{
                    int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn lưu tạm hóa đơn này không?", "Lưu tạm hóa đơn", JOptionPane.YES_NO_OPTION);
                    if(result == JOptionPane.YES_OPTION){
                        for(int i = 0; i < tmGioHang.getRowCount(); i++){
                            pbsp.put(tmGioHang.getValueAt(i, 1).toString(), Integer.parseInt(tmGioHang.getValueAt(i, 4).toString()));
                            dsSPLuuTam.put(tmGioHang.getValueAt(i, 1).toString(), Integer.parseInt(tmGioHang.getValueAt(i, 4).toString()));
                        }
                        dsSPTAM.put(lapHoaDon.getTxtSoDienThoaiKh().getText().trim(), pbsp);
                        loadTbTam();
                        xoaTrang();
                    }
//                    Map<String, Integer> tam = (Map<String, Integer>) dsSPTAM.get(lapHoaDon.getTxtSoDienThoaiKh().getText().trim());
//                    for(Map.Entry<String, Integer> entry : tam.entrySet()){
//                        System.out.println(entry.getKey() + " " + entry.getValue());
//                    }

                }
                try {

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }else if(e.getSource().equals(lapHoaDon.getjCheckBox1())){
            if(lapHoaDon.getjCheckBox1().isSelected()){
                lapHoaDon.getTxtSoDienThoaiKh().setEnabled(false);
                lapHoaDon.getTxtTenKhachHang().setText("Khách vãng lai");
                lapHoaDon.getTxtTenKhachHang().setEnabled(false);
                lapHoaDon.getTxtSoDienThoaiKh().setText("");
                loadHD();
            }else{
                lapHoaDon.getTxtSoDienThoaiKh().setText("");
                lapHoaDon.getTxtSoDienThoaiKh().setEnabled(true);
                lapHoaDon.getTxtTenKhachHang().setText("");
                lapHoaDon.getTxtMaHoaDon().setText("");
                lapHoaDon.getTxtNgayLapHoaDon().setText("");
            }
        }else if(e.getSource().equals(lapHoaDon.getBtnLapHoaDon())){
            System.out.println("LapHoaDon");
            int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn lập hóa đơn này không?", "Lập hóa đơn", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                LapHoaDon();
                xoaTrang();
            }
        }
    }
    @Override
    public void tableChanged(TableModelEvent e) {
        if(e.getColumn()==4){
            DefaultTableModel tmGioHang = (DefaultTableModel) lapHoaDon.getTbDanhSachCacSanPhamTrongGioHang().getModel();
            int row = e.getFirstRow();
            int count = Integer.parseInt(tmGioHang.getValueAt(row, 4).toString());
            ChiTietPhienBanSanPham pbsp = null;
            double tta = 0;
            try {
                pbsp = chiTietPhienBanSanPhamDAO.timKiem(tmGioHang.getValueAt(row, 1).toString()).get();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            String ptThue = lapHoaDon.getTxtThue().getText();
            int index = ptThue.indexOf(" ");
            if(count<0) {
                tmGioHang.setValueAt("1", row, 4);
            } else if (count > pbsp.getSoLuong()){
                JOptionPane.showMessageDialog(null, "Số lượng không đủ để thực hiện giao dịch");
                tmGioHang.setValueAt("1", row, 4);
                return;
            }
            tmGioHang.setValueAt(count*Double.parseDouble(tmGioHang.getValueAt(row, 5).toString()), row, 6);
            double tt = tinhTT();
            lapHoaDon.getTxtTongTIen().setText(tt+"");
        }
    }
    @Override
    public void onDuyet(int row) {
        if(!(lapHoaDon.getTbDanhSachCacSanPhamTrongGioHang().getRowCount()==0)){
            JOptionPane.showMessageDialog(null, "Hiện tại còn hóa đơn chưa được xử lý chưa thể duyệt hóa đơn này");
        }else{
            DefaultTableModel tmTam = (DefaultTableModel) lapHoaDon.getTbHoaDonLuuTam().getModel();
            DefaultTableModel tmGioHang = (DefaultTableModel) lapHoaDon.getTbDanhSachCacSanPhamTrongGioHang().getModel();
            String soDT = tmTam.getValueAt(row, 2).toString();
            loadTTKH(soDT);
            Map<String, Integer> tam = (Map<String, Integer>) dsSPTAM.get(soDT);
            String maPBSP = "";
            int i = 0;
            for(Map.Entry<String, Integer> entry : tam.entrySet()){
                maPBSP = entry.getKey();
                themSP(maPBSP);
                tmGioHang.setValueAt(entry.getValue(), i, 4);
                i++;
            }
            dsSPTAM.remove(soDT);
            tmTam.removeRow(row);
        }

    }
    @Override
    public void onHuy(int row) {
        int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn hủy hóa đơn này không?", "Hủy hóa đơn", JOptionPane.YES_NO_OPTION);
        if(result == JOptionPane.YES_OPTION){
            if(lapHoaDon.getTbDanhSachCacSanPhamTrongGioHang().isEditing()){
                lapHoaDon.getTbDanhSachCacSanPhamTrongGioHang().getCellEditor().stopCellEditing();
            }
            DefaultTableModel tmTam = (DefaultTableModel) lapHoaDon.getTbHoaDonLuuTam().getModel();
            String soDT = tmTam.getValueAt(row, 2).toString();
            Map<String, Integer> tam = (Map<String, Integer>) dsSPTAM.get(soDT);
            for(Map.Entry<String, Integer> entry : tam.entrySet()){
                if(dsSPLuuTam.containsKey(entry.getKey())) {
                    dsSPLuuTam.remove(entry.getKey());
                }
            }
            dsSPTAM.remove(soDT);
            tmTam.removeRow(row);
            for(int i = 0; i < tmTam.getRowCount(); i++){
                tmTam.setValueAt((i+1), i, 0);
            }
        }
    }
    @Override
    public void onDelete(int row) {
        if(lapHoaDon.getTbDanhSachCacSanPhamTrongGioHang().isEditing()){
            lapHoaDon.getTbDanhSachCacSanPhamTrongGioHang().getCellEditor().stopCellEditing();
        }
        DefaultTableModel tmGioHang = (DefaultTableModel) lapHoaDon.getTbDanhSachCacSanPhamTrongGioHang().getModel();
        tmGioHang.removeRow(row);
        for(int i = 0; i < tmGioHang.getRowCount(); i++){
            tmGioHang.setValueAt((i+1), i, 0);
        }
        lapHoaDon.getTxtTongTIen().setText(tinhTT()+"");
    }
}
