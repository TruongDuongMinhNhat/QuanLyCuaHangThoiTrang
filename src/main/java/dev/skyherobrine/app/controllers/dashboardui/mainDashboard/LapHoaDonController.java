package dev.skyherobrine.app.controllers.dashboardui.mainDashboard;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import dev.skyherobrine.app.controllers.loginui.mainLogin.LoginController;
import dev.skyherobrine.app.daos.order.ChiTietPhieuNhapHangDAO;
import dev.skyherobrine.app.daos.order.HoaDonDAO;
import dev.skyherobrine.app.daos.person.KhachHangDAO;
import dev.skyherobrine.app.daos.person.NhanVienDAO;
import dev.skyherobrine.app.daos.product.ChiTietPhienBanSanPhamDAO;
import dev.skyherobrine.app.daos.product.SanPhamDAO;
import dev.skyherobrine.app.entities.order.ChiTietPhieuNhapHang;
import dev.skyherobrine.app.entities.order.HoaDon;
import dev.skyherobrine.app.entities.person.KhachHang;
import dev.skyherobrine.app.entities.person.NhanVien;
import dev.skyherobrine.app.entities.product.ChiTietPhienBanSanPham;
import dev.skyherobrine.app.entities.product.SanPham;
import dev.skyherobrine.app.views.dashboard.component.LapHoaDon;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class LapHoaDonController implements KeyListener, Runnable, ThreadFactory, ActionListener, TableModelListener {
    private LapHoaDon lapHoaDon;
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
    private static Map<String, Object> dsSPTAM = new HashMap<>();
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
            loadTTNV();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if(count == 0){
//            setCamera();
            count++;
        }
    }
    public void setCamera(){
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(size);

        pnCam = new WebcamPanel(webcam);
        pnCam.setPreferredSize(size);
        pnCam.setFPSDisplayed(true);
//        pnCam.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5) );
        pnCam.setSize(new Dimension(463,350));
        pnCam.setLocation(30, 60);

//        lapHoaDon.getPnCamera().add(avb);
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
                if(themSP(lapHoaDon.getListProduct().getSelectedValue().toString())){
                    lapHoaDon.getTxtTimKiemSanPham().setText("");
                    lapHoaDon.getTxtTimKiemSanPham().requestFocus(true);
                    lapHoaDon.getMenuProduct().setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(lapHoaDon, "Sản phẩm đã hết hàng");
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
           }else{
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
        try {
            List<Map<String, Object>> listCTPBSP = chiTietPhienBanSanPhamDAO.timKiem(conditions, false, "MaPhienBanSP");
            if (listCTPBSP.size() == 0) {
                lapHoaDon.getMenuProduct().setVisible(false);
            } else {
                for (int i = 0; i < listCTPBSP.size(); i++) {
                    listModel.addElement(listCTPBSP.get(i).get("MaPhienBanSP").toString() + "-" + listCTPBSP.get(i).get("SoLuong").toString());
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
        SDT = SDT.substring(SDT.length()-3);
        maHD = maHD + SDT + "-";
        maHD = maHD + formatNumber(laySoHoaDon());
//        lapHoaDon.setText(maHD);
        LocalDateTime local = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        lapHoaDon.getTxtNgayLap().setText(local.format(dateTimeFormatter));
    }
//    public void loadTTHD(){
//        LocalDateTime local = LocalDateTime.now();
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        lapHoaDon.getNgayLapHoaDonKh().setDate();
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
        try {
            pbsp = chiTietPhienBanSanPhamDAO.timKiem(maPBSP);
            int index = maPBSP.indexOf("-");
            String maSP = maPBSP.substring(0, index);
            Optional<SanPham> sp  = sanPhamDAO.timKiem(maSP);
            Map<String, Object> conditions = new HashMap<>();
            conditions.put("MaSP", maSP);
            sp.get().setChiTietPhieuNhapHangs(chiTietPhieuNhapHangDAO.timKiem(conditions));
            int stt = tmGioHang.getRowCount() + 1;
            for(int i = 0; i < tmGioHang.getRowCount(); i++){
                if(tmGioHang.getValueAt(i, 1).toString().equalsIgnoreCase(pbsp.get().getMaPhienBanSP())){
                    int soLuong = Integer.parseInt(tmGioHang.getValueAt(i, 4).toString());
                    tmGioHang.setValueAt((soLuong+1)*Double.parseDouble(tmGioHang.getValueAt(i, 5).toString()), i,6);
                    tmGioHang.setValueAt(soLuong+1, i, 4);
                    lapHoaDon.getTxtTongTIen().setText(tinhTT()+"");
                    return true;
                }
            }
            int sl = 1;
            double dongia = sp.get().giaBan();
            String []rows = {stt+"", maPBSP, sp.get().getTenSP(), pbsp.get().getKichThuoc(), sl+"", dongia+"", sl*dongia+"", "1"};
            tmGioHang.addRow(rows);
            lapHoaDon.getTxtTongTIen().setText(tinhTT()+"");
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public boolean checkSDT(String tenKH){
        if(tenKH.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(lapHoaDon, "Vui lòng nhập số điện thoại khách hàng");
            return false;
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
        lapHoaDon.getTxtTenKhachHang().setText("");
        lapHoaDon.getTxtSoDienThoaiKh().setText("");
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
                    for(int i = 0; i < tmGioHang.getRowCount(); i++){
                        pbsp.put(tmGioHang.getValueAt(i, 1).toString(), Integer.parseInt(tmGioHang.getValueAt(i, 4).toString()));
                    }
                    dsSPTAM.put(lapHoaDon.getTxtSoDienThoaiKh().getText().trim(), pbsp);
//                    Map<String, Integer> tam = (Map<String, Integer>) dsSPTAM.get(lapHoaDon.getTxtSoDienThoaiKh().getText().trim());
//                    for(Map.Entry<String, Integer> entry : tam.entrySet()){
//                        System.out.println(entry.getKey() + " " + entry.getValue());
//                    }
                    loadTbTam();
                    xoaTrang();
                }
                try {

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        if(e.getColumn()==3){
            DefaultTableModel tmGioHang = (DefaultTableModel) lapHoaDon.getTbDanhSachCacSanPhamTrongGioHang().getModel();
            int row = e.getFirstRow();
            int count = Integer.parseInt(tmGioHang.getValueAt(row, 3).toString());
            ChiTietPhienBanSanPham pbsp = null;
            double tta = 0;
            try {
                pbsp = chiTietPhienBanSanPhamDAO.timKiem(tmGioHang.getValueAt(row, 1).toString()).get();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            String ptThue = lapHoaDon.getTxtThue().getText();
            int index = ptThue.indexOf(" ");
            double thue = Double.parseDouble(ptThue.substring(0, index));
            if(count<0) {
                tmGioHang.setValueAt("1", row, 3);
            } else if (count > pbsp.getSoLuong()){
                JOptionPane.showMessageDialog(null, "Số lượng không đủ để thực hiện giao dịch");
            }

            double tt = tinhTT();
            lapHoaDon.getTxtTongTIen().setText(tt+"");
        }
    }
}
