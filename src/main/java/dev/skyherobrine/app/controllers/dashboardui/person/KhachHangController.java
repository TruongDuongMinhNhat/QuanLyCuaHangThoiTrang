package dev.skyherobrine.app.controllers.dashboardui.person;

import dev.skyherobrine.app.daos.person.KhachHangDAO;
import dev.skyherobrine.app.entities.person.KhachHang;
import dev.skyherobrine.app.views.dashboard.component.KhachHangGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class KhachHangController implements MouseListener, ActionListener, PropertyChangeListener, KeyListener {
    private KhachHangGUI khachHangUI;
    private KhachHangDAO khachHangDAO;
    private List<KhachHang> dsKhachHang;


    private static int trangThaiNutXoaKH = 0;
    private static int trangThaiNutThemKH = 0;
    private static int trangThaiNutSuaKH = 0;


    public KhachHangController(KhachHangGUI khachHangUI) {
        try {
            khachHangDAO = new KhachHangDAO();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.khachHangUI = khachHangUI;
    }

    //load danh sách lên table
    public void loaddsKhachHang() {
        DefaultTableModel clearTable = (DefaultTableModel) khachHangUI.getTbDanhSachKhachHang().getModel();
        clearTable.setRowCount(0);
        khachHangUI.getTbDanhSachKhachHang().setModel(clearTable);
        try {
            dsKhachHang = khachHangDAO.timKiem();
            DefaultTableModel tmKhachHang = (DefaultTableModel) khachHangUI.getTbDanhSachKhachHang().getModel();
            for(KhachHang kh : dsKhachHang){
                String row[] = {kh.getMaKH(), kh.getHoTen(), kh.getSoDienThoai(), kh.isGioiTinh() ? "NAM" : "NỮ", kh.getNgaySinh()+"", kh.getDiemTichLuy()+""};
                tmKhachHang.addRow(row);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        trangThaiNutThemKH = 0;
        trangThaiNutSuaKH = 0;
        trangThaiNutXoaKH = 0;
    }
    private List<KhachHang> dsLoc;
    private List<KhachHang> dsTam = new ArrayList<KhachHang>();
    @Override
    public void actionPerformed(ActionEvent event) {
        Object op = event.getSource();
        /*NÚT THÊM*/
        if(op.equals(khachHangUI.getButtonThemKhachHang())){
            // Thực hiện biến đổi các nút thành nút chức năng của nghiệp vụ thêm khách hàng
            if (trangThaiNutThemKH==0) {
                khachHangUI.getButtonThemKhachHang().setText("Xác nhận thêm");
                khachHangUI.getButtonSuaKhachHang().setText("Xóa trắng");
                khachHangUI.getButtonXoaKhachHang().setText("Thoát thêm");
                trangThaiNutXoaKH = 1;
                trangThaiNutThemKH = 1;
                trangThaiNutSuaKH = 1;

                //Mở tương tác với thông tin
                tuongTac(true);
                tuongTacTimKiem(false);

                //Xóa trắng dữ liệu
                xoaTrangAll();
                //load sẵn tình trang còn bán
                khachHangUI.getTxtMaKhachHang().setEnabled(false);
                khachHangUI.getTxtMaKhachHang().setText(laymaNV());
            }
            // Thực hiện chức năng nghiệp vụ thêm khách hàng
            else if(trangThaiNutThemKH==1) {
                KhachHang kh = layDataThem();
                if ((JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thêm khách hàng mới", "Lựa chọn", JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION){
                    try {
                        if(khachHangDAO.them(kh)){
                            loaddsKhachHang();
                            xoaTrangAll();
                            JOptionPane.showMessageDialog(null, "Thêm thành công!");
                            trangThaiNutThemKH = 1;
                            trangThaiNutXoaKH = 1;
                        }else{
                            JOptionPane.showMessageDialog(null, "Thêm thất bại!");
                        }
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }

            }
            //Thực hiện chức năng nghiệp vụ sửa khách hàng
            else if(trangThaiNutThemKH==2){
                if (khachHangUI.getTxtMaKhachHang().getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng cần sửa!");
                }else {
                    KhachHang khSua = layDataSua();
                    if ((JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa khách hàng có mã " +khSua.getMaKH()+" không?", "Lựa chọn", JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION){
                        try {
                            if(khachHangDAO.capNhat(khSua)){
                                loaddsKhachHang();
                                xoaTrangAll();
                                JOptionPane.showMessageDialog(null, "Sửa thành công!");
                                trangThaiNutThemKH = 2;
                            }else{
                                JOptionPane.showMessageDialog(null, "Sửa thất bại!");
                            }
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                trangThaiNutXoaKH = 1;
            }
        }

        /*NÚT SỬA*/
        if(op.equals(khachHangUI.getButtonSuaKhachHang())){
            // Thực hiện biến đổi các nút thành nút chức năng của nghiệp vụ sửa khách hàng
            if (trangThaiNutSuaKH==0) {
                //Mở tương tác với thông tin
                tuongTac(true);

                khachHangUI.getButtonThemKhachHang().setText("Xác nhận sửa");
                khachHangUI.getButtonSuaKhachHang().setText("Xóa trắng");
                khachHangUI.getButtonXoaKhachHang().setText("Thoát sửa");
                trangThaiNutThemKH = 2;
                trangThaiNutSuaKH = 1;
                trangThaiNutXoaKH = 1;
                khachHangUI.getTxtMaKhachHang().setEnabled(false);
            }
            // Thực hiện xóa trắng dữ liệu ở nghiệp vụ sửa thông tín khách hàng
            else if(trangThaiNutSuaKH==1) {
                xoaTrangSua();
            }
        }

        /*NÚT XÓA*/
        if (op.equals(khachHangUI.getButtonXoaKhachHang())) {
            // Thực hiện chức năng nghiệp vụ xóa khách hàng
            if (trangThaiNutXoaKH==0) {
                if (khachHangUI.getTxtMaKhachHang().getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng cần xóa!");
                } else {
                    String ma = khachHangUI.getTxtMaKhachHang().getText();
                    if ((JOptionPane.showConfirmDialog(null,
                            "Bạn có chắc muốn ngừng bán khách hàng có mã " + khachHangUI.getTxtMaKhachHang().getText() + " không?", "Lựa chọn",
                            JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION) {
                        try {
                            if (khachHangDAO.xoa(ma)){
                                loaddsKhachHang();
                                xoaTrangAll();
                                JOptionPane.showMessageDialog(null, "Xóa thành công!");
                            }else {
                                JOptionPane.showMessageDialog(null, "Xóa thất bại!");
                            }
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
            // Thực hiện trả các nút về giao diện quản lý khách hàng
            else if(trangThaiNutXoaKH==1) {
                tuongTac(false);
                tuongTacTimKiem(true);
                xoaTrangAll();
                khachHangUI.getButtonThemKhachHang().setText("Thêm khách hàng");
                khachHangUI.getButtonSuaKhachHang().setText("Sửa khách hàng");
                khachHangUI.getButtonXoaKhachHang().setText("Xóa khách hàng");
                trangThaiNutXoaKH = 0;
                trangThaiNutThemKH = 0;
                trangThaiNutSuaKH = 0;
            }
        }

        /*LỌC KHÁCH HÀNG*/
//        if(op.equals(khachHangUI.getCbTkGioiTinh()) ||
//                op.equals(khachHangUI.getCbTkChucVu()) ||
//                op.equals(khachHangUI.getCbTkTinhTrang()) ||
//                op.equals(khachHangUI.getCbTkCaLamViec())){
//            DefaultTableModel clearTable = (DefaultTableModel) khachHangUI.getTbDanhSachKhachHang().getModel();
//            clearTable.setRowCount(0);
//            khachHangUI.getTbDanhSachKhachHang().setModel(clearTable);
//            try {
//                dsKhachHang = khachHangDAO.timKiem();
//                DefaultTableModel tmKhachHang = (DefaultTableModel) khachHangUI.getTbDanhSachKhachHang().getModel();
//                for(dev.skyherobrine.app.entities.person.KhachHang kh : dsKhachHang){
//                    String row[] = {kh.getMaKH(), kh.getHoTen(), kh.getSoDienThoai(), kh.isGioiTinh() ? "NAM" : "NỮ", kh.getNgaySinh()+"", kh.getEmail(), kh.getDiaChi(), kh.getChucVu()+"", kh.getCaLamViec()+"", kh.getTenTaiKhoan(), kh.getMatKhau(), kh.getTinhTrang()+""};
//                    tmKhachHang.addRow(row);
//                }
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }
    }


    //Hàm đóng/mở tương tác
    public void tuongTac(boolean c){
        khachHangUI.getTxtMaKhachHang().setEnabled(c);
        khachHangUI.getTxtSoDienThoaiKhachHang().setEnabled(c);
        khachHangUI.getjDateChooserNgaySinhKhachHang().setEnabled(c);
        khachHangUI.getTxtHoTenKhachHang().setEnabled(c);
        khachHangUI.getCbGioiTinh().setEnabled(c);
        khachHangUI.getTxtDiemTichLuy().setEnabled(c);
    }
    //Hàm đóng/mở tương tác tìm kiếm
    public void tuongTacTimKiem(boolean o){
        khachHangUI.getCbTkGioiTinh().setEnabled(o);
        khachHangUI.getjDateChooserTkNgaySinh().setEnabled(o);
        khachHangUI.getTxtTuKhoaTimKiem().setEnabled(o);
    }

    //Hàm xóa trắng sửa
    public void xoaTrangSua(){
        loadComboBoxPhanThongTinNV();
        khachHangUI.getTxtSoDienThoaiKhachHang().setText("");
        khachHangUI.getjDateChooserNgaySinhKhachHang().setDate(null);
        khachHangUI.getTxtHoTenKhachHang().setText("");
        khachHangUI.getTxtDiemTichLuy().setText("");
    }

    //Hàm xóa trắng dữ liệu nhập
    public void xoaTrangAll(){
        loadComboBoxPhanThongTinNV();
        khachHangUI.getTxtMaKhachHang().setText("");
        khachHangUI.getTxtSoDienThoaiKhachHang().setText("");
        khachHangUI.getjDateChooserNgaySinhKhachHang().setDate(null);
        khachHangUI.getTxtHoTenKhachHang().setText("");
        khachHangUI.getTxtDiemTichLuy().setText("");
    }

    //Load các comboBox phần thông tin
    public void loadComboBoxPhanThongTinNV(){
        String[] gioiTinh = {"--Select--", "NAM", "NỮ"};
        DefaultComboBoxModel<String> gioiTinhCb = new DefaultComboBoxModel<>(gioiTinh);
        khachHangUI.getCbGioiTinh().setModel(gioiTinhCb);

    }

    //Load các comboBox phần tìm kiếm
    public void loadComboBoxPhanTimKiem(){
        //Giới tính
        String[] gioiTinh = {"--Giới tính--", "NAM", "NỮ"};
        DefaultComboBoxModel<String> gioiTinhCb = new DefaultComboBoxModel<>(gioiTinh);
        khachHangUI.getCbTkGioiTinh().setModel(gioiTinhCb);
    }

    //Hàm lấy khách hàng từ phần thông tin
    private KhachHang layDataThem() {
        KhachHang kh;
        String sdt = khachHangUI.getTxtSoDienThoaiKhachHang().getText();

        // Lấy ngày từ JDateChooser
        Date selectedDate = khachHangUI.getjDateChooserNgaySinhKhachHang().getDate();
        // Chuyển đổi từ Date sang LocalDate
        LocalDate localDate = dateToLocalDate(selectedDate);

        String ten = khachHangUI.getTxtHoTenKhachHang().getText();
        Boolean gt;
        if(khachHangUI.getCbGioiTinh().getSelectedItem().toString().equals("NAM")){
            gt = true;
        }else {
            gt = false;
        }
        float dtl = Float.parseFloat(khachHangUI.getTxtDiemTichLuy().getText());

        //Mã khách hàng
        String ma = khachHangUI.getTxtMaKhachHang().getText();
        try {
            kh = new KhachHang(ma,ten,sdt,gt,localDate,dtl);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return kh;
    }

    //Hàm lấy khách hàng để update
    private KhachHang layDataSua() {
        KhachHang kh;
        String sdt = khachHangUI.getTxtSoDienThoaiKhachHang().getText();

        // Lấy ngày từ JDateChooser
        Date selectedDate = khachHangUI.getjDateChooserNgaySinhKhachHang().getDate();
        // Chuyển đổi từ Date sang LocalDate
        LocalDate localDate1 = dateToLocalDate(selectedDate);

        String ten = khachHangUI.getTxtHoTenKhachHang().getText();
        Boolean gt;
        if(khachHangUI.getCbGioiTinh().getSelectedItem().toString().equals("NAM")){
            gt = true;
        }else {
            gt = false;
        }
        float dtl = Float.parseFloat(khachHangUI.getTxtDiemTichLuy().getText());

        String ma = khachHangUI.getTxtMaKhachHang().getText();
        try {
            kh = new KhachHang(ma,ten,sdt,gt,localDate1,dtl);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return kh;
    }

    //Hàm sinh mã khách hàng
    private String laymaNV() {
        String ma = "NV-";
        String nThem = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")).toString();
        ma = ma+nThem;
        ma = ma+"-"+formatNumber(laysoDuoiMaKH());
        return ma;
    }
    //Hàm lấy số đuôi
    public int laysoDuoiMaKH(){
        String nThem = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")).toString();
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("MaKH", "%"+nThem+"%");
        List<KhachHang> KhachHangs = new ArrayList<>();
        try {
            KhachHangs = khachHangDAO.timKiem(conditions);
        } catch (Exception e) {
            return 1;
        }
        if(KhachHangs==null){
            return 1;
        }
        KhachHang kh = KhachHangs.get(KhachHangs.size()-1);
        int soHD = Integer.parseInt(kh.getMaKH().substring(kh.getMaKH().length()-3));
        return soHD+1;
    }

    //Hàm gán thêm số ví dụ 001
    public static String formatNumber(int number) {
        if(number < 10)
            return String.format("00%d", number);
        else if((number >= 10) && (number < 100))
            return String.format("0%d", number);
        else
            return String.format("%d", number);
    }

    //Hàm lấy viết tắt của tên
    public  String getInitials(String input) {
        String[] words = input.split("\\s+"); // Sử dụng "\\s+" để tách các từ dựa trên khoảng trắng

        // Lấy chữ cái đầu của từng từ ghép
        StringBuilder initials = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                initials.append(word.charAt(0));
            }
        }

        return initials.toString();
    }


    //Hàm đổi Date thành LocalDate
    public LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        return instant.atZone(ZoneId.systemDefault()).toLocalDate();
    }
    @Override
    public void mouseClicked(MouseEvent event) {
        if(trangThaiNutThemKH==1){
            JOptionPane.showMessageDialog(null, "Đang thực hiện chức năng thêm, không được click!!");
        }else {
            int row = khachHangUI.getTbDanhSachKhachHang().getSelectedRow();
            String ma = khachHangUI.getTbDanhSachKhachHang().getValueAt(row, 0).toString();
            Optional<KhachHang> khHienThuc = null;
            try {
                khHienThuc = khachHangDAO.timKiem(ma);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            khachHangUI.getTxtMaKhachHang().setText(khHienThuc.get().getMaKH());
            khachHangUI.getTxtHoTenKhachHang().setText(khHienThuc.get().getHoTen());
            khachHangUI.getTxtSoDienThoaiKhachHang().setText(khHienThuc.get().getSoDienThoai());
            khachHangUI.getTxtDiemTichLuy().setText(String.valueOf(khHienThuc.get().getDiemTichLuy()));


            //Xử lý ngày
            String date = String.valueOf(khHienThuc.get().getNgaySinh());
            Date date2 = null;
            try {
                date2 = new SimpleDateFormat("yyyy-mm-dd").parse(date);
            } catch (ParseException e) {throw new RuntimeException(e);

            }
            khachHangUI.getjDateChooserNgaySinhKhachHang().setDate(date2);
            khachHangUI.getCbGioiTinh().setSelectedItem(khHienThuc.get().isGioiTinh() ? "NAM" : "NỮ");
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
