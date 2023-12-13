package dev.skyherobrine.app.controllers.dashboardui.product;

import dev.skyherobrine.app.daos.product.DanhMucSanPhamDAO;
import dev.skyherobrine.app.daos.product.LoaiSanPhamDAO;
import dev.skyherobrine.app.daos.product.SanPhamDAO;
import dev.skyherobrine.app.daos.product.ThuongHieuDAO;
import dev.skyherobrine.app.entities.product.DanhMucSanPham;
import dev.skyherobrine.app.entities.product.LoaiSanPham;
import dev.skyherobrine.app.entities.product.SanPham;
import dev.skyherobrine.app.entities.product.ThuongHieu;
import dev.skyherobrine.app.enums.DoTuoi;
import dev.skyherobrine.app.enums.MauSac;
import dev.skyherobrine.app.enums.PhongCachMac;
import dev.skyherobrine.app.enums.TinhTrangSanPham;
import dev.skyherobrine.app.views.dashboard.component.QuanLySanPham;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class ProductController implements ActionListener, MouseListener, KeyListener {
    private QuanLySanPham sanPhamUI;
    private  List<SanPham> dsSanPham;
    private SanPhamDAO sanPhamDAO;
    private List<LoaiSanPham> dsLoaiSanPham;
    private LoaiSanPhamDAO loaiSanPhamDAO;
    private ThuongHieuDAO thuongHieuDAO;
    private List<ThuongHieu> dsThuongHieu;
    private List<DanhMucSanPham> dsDanhMucSanPham;
    private DanhMucSanPhamDAO danhMucSanPhamDAO;

    private static int trangThaiNutXoa = 0;
    private static int trangThaiNutThem = 0;
    private static int trangThaiNutSua = 0;

    private static String fileAnh = "";

    public ProductController(QuanLySanPham sanPhamUI) {
        try {
            sanPhamDAO = new SanPhamDAO();
            loaiSanPhamDAO = new LoaiSanPhamDAO();
            thuongHieuDAO = new ThuongHieuDAO();
            danhMucSanPhamDAO = new DanhMucSanPhamDAO();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.sanPhamUI = sanPhamUI;
    }

//  Load data từ CSDL lên table
    public void loadDsSanPham() {
        DefaultTableModel clearTable = (DefaultTableModel) sanPhamUI.getTbDanhSachSanPham().getModel();
        clearTable.setRowCount(0);
        sanPhamUI.getTbDanhSachSanPham().setModel(clearTable);
        try {
            dsSanPham = sanPhamDAO.timKiem();
            DefaultTableModel tmSanPham = (DefaultTableModel) sanPhamUI.getTbDanhSachSanPham().getModel();
            for(SanPham sp : dsSanPham){
                String row[] = {sp.getMaSP(), sp.getTenSP(), sp.getXuatXu(), sp.getThuongHieu().getTenTH()+"", sp.getLoaiSanPham().getDanhMucSanPham().getTenDM()+"", sp.getLoaiSanPham().getTenLoai()+"", sp.getPhanTramLoi()+"%", sp.getTinhTrang()+""};
                tmSanPham.addRow(row);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        trangThaiNutThem = 0;
        trangThaiNutSua = 0;
        trangThaiNutXoa = 0;
    }

    private List<SanPham> dsTim;
    private List<SanPham> dsTam = new ArrayList<>();

    @Override
    public void actionPerformed(ActionEvent e){
        Object op = e.getSource();
        if (op.equals(sanPhamUI.getBtnThemPBSP())){
            sanPhamUI.getWinThemPBSP().setVisible(true);
        }

        /*NÚT THÊM*/
        if(op.equals(sanPhamUI.getButtonThem())){
            // Thực hiện biến đổi các nút thành nút chức năng của nghiệp vụ thêm sản phẩm
            if (trangThaiNutThem==0) {
                sanPhamUI.getButtonThem().setText("Xác nhận thêm");
                sanPhamUI.getButtonSua().setText("Xóa trắng");
                sanPhamUI.getButtonXoa().setText("Thoát thêm");
                trangThaiNutXoa = 1;
                trangThaiNutThem = 1;
                trangThaiNutSua = 1;

                //Mở tương tác với thông tin
                tuongTac(true);
                tuongTacTimKiem(false);

                //Xóa trắng dữ liệu
                xoaTrangAll();
                //load sẵn tình trang còn bán
                sanPhamUI.getCbTinhTrang().setSelectedItem("CON_BAN");
            }
            // Thực hiện chức năng nghiệp vụ thêm sản phẩm
//            else if(trangThaiNutThem==1) {
//                SanPham sp = layDataThem();
//                if ((JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thêm sản phẩm mới", "Lựa chọn", JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION){
//                    try {
//                        if(sanPhamDAO.them(sp)){
//                            loadDsSanPham();
//                            xoaTrangAll();
//                            JOptionPane.showMessageDialog(null, "Thêm thành công!");
//                            trangThaiNutThem = 1;
//                            trangThaiNutXoa = 1;
//                        }else{
//                            JOptionPane.showMessageDialog(null, "Thêm thất bại!");
//                        }
//                    } catch (Exception ex) {
//                        throw new RuntimeException(ex);
//                    }
//                }
//
//            }
            //Thực hiện chức năng nghiệp vụ sửa sản phẩm
//            else if(trangThaiNutThem==2){
//                if (sanPhamUI.getTxtMaSanPham().getText().equals("")) {
//                    JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần sửa!");
//                }else {
//                    SanPham spSua = layDataSua();
//                    if ((JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa sản phẩm có mã" +spSua.getMaSP()+" không?", "Lựa chọn", JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION){
//                        try {
//                            if(sanPhamDAO.capNhat(spSua)){
//                                loadDsSanPham();
//                                xoaTrangAll();
//                                JOptionPane.showMessageDialog(null, "Sửa thành công!");
//                                trangThaiNutThem = 2;
//                            }else{
//                                JOptionPane.showMessageDialog(null, "Sửa thất bại!");
//                            }
//                        } catch (Exception ex) {
//                            throw new RuntimeException(ex);
//                        }
//                    }
//                }
//                trangThaiNutXoa = 1;
//            }
        }

        /*NÚT SỬA*/
        if(op.equals(sanPhamUI.getButtonSua())){
            // Thực hiện biến đổi các nút thành nút chức năng của nghiệp vụ sửa sản phẩm
            if (trangThaiNutSua==0) {
                //Mở tương tác với thông tin
                tuongTac(true);

                sanPhamUI.getButtonThem().setText("Xác nhận sửa");
                sanPhamUI.getButtonSua().setText("Xóa trắng");
                sanPhamUI.getButtonXoa().setText("Thoát sửa");
                trangThaiNutThem = 2;
                trangThaiNutSua = 1;
                trangThaiNutXoa = 1;
            }
            // Thực hiện xóa trắng dữ liệu ở nghiệp vụ sửa thông tín sản phẩm
            else if(trangThaiNutSua==1) {
                xoaTrangSua();
            }
        }

        /*NÚT XÓA*/
        if (op == sanPhamUI.getButtonXoa()) {
            // Thực hiện chức năng nghiệp vụ xóa sản phẩm
            if (trangThaiNutXoa==0) {
                if (sanPhamUI.getTxtMaSanPham().getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần xóa!");
                } else {
                    String ma = sanPhamUI.getTxtMaSanPham().getText();
                    if ((JOptionPane.showConfirmDialog(null,
                            "Bạn có chắc muốn ngừng bán sản phẩm có mã " + sanPhamUI.getTxtMaSanPham().getText() + " không?", "Lựa chọn",
                            JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION) {
                        try {
                            if (sanPhamDAO.xoa(ma)){
                                loadDsSanPham();
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
            // Thực hiện trả các nút về giao diện quản lý sản phẩm
            else if(trangThaiNutXoa==1) {
                tuongTac(false);
                tuongTacTimKiem(true);
                xoaTrangAll();
                sanPhamUI.getButtonThem().setText("Thêm sản phẩm");
                sanPhamUI.getButtonSua().setText("Sửa sản phẩm");
                sanPhamUI.getButtonXoa().setText("Xóa sản phẩm");
                trangThaiNutXoa = 0;
                trangThaiNutThem = 0;
                trangThaiNutSua = 0;
            }
        }
        /*LỌC SẢN PHẨM*/
//        if (op.equals(sanPhamUI.getCbTkDanhMuc()) ||
//                op.equals(sanPhamUI.getCbTkLoaiSanPham()) || op.equals(sanPhamUI.getCbTkTinhTrang()) ||
//                op.equals(sanPhamUI.getCbTkThuongHieu()) || op.equals(sanPhamUI.getCbTkKichThuocSp()) ||
//                op.equals(sanPhamUI.getCbTkPhongCachMac())){
//            dsTim = new ArrayList<>();
//            List<DanhMucSanPham> dsDanhMucTim;
//            List<LoaiSanPham> dsLoaiTim;
//            List<ThuongHieu> dsThuongHieuTim;
//            //Lọc tuần tự từ trái sang phải
//            if(!sanPhamUI.getCbTkDanhMuc().getSelectedItem().toString().equals("--Danh mục--")){
//                Map<String, Object> conditionsDanhMuc = new HashMap<>();
//                conditionsDanhMuc.put("TenDM", sanPhamUI.getCbTkDanhMuc().getSelectedItem().toString());
//                try {
//                    dsDanhMucTim = danhMucSanPhamDAO.timKiem(conditionsDanhMuc);
//                } catch (Exception ex) {
//                    throw new RuntimeException(ex);
//                }
//                //
//                Map<String, Object> conditionsLoai = new HashMap<>();
//                conditionsLoai.put("MaDM", dsDanhMucTim.get(0).getMaDM().toString());
//                try {
//                    dsLoaiTim = loaiSanPhamDAO.timKiem(conditionsLoai);
//                } catch (Exception ex) {
//                    throw new RuntimeException(ex);
//                }
//                //
//                for(int i=0; i<dsLoaiTim.size(); i++){
//                    Map<String, Object> conditionsSp = new HashMap<>();
//                    conditionsSp.put("MaLoai", dsLoaiTim.get(i).getMaLoai().toString());
//                    try {
//                        dsTim.addAll(sanPhamDAO.timKiem(conditionsSp));
//                    } catch (Exception ex) {
//                        throw new RuntimeException(ex);
//                    }
//                }
//                if(!sanPhamUI.getCbTkLoaiSanPham().getSelectedItem().toString().equals("--Loại--")){
//                    for(int i=0; i<dsTim.size(); i++){
//                        if(sanPhamUI.getCbTkLoaiSanPham().getSelectedItem().toString().equals(dsTim.get(i).getLoaiSanPham().getTenLoai())){
//                            dsTam.add(dsTim.get(i));
//                        }
//                    }
//                    dsTim = dsTam;
//                    dsTam = new ArrayList<>();
//                    if (!sanPhamUI.getCbTkTinhTrang().getSelectedItem().toString().equals("--Tình trạng--")){
//                        for(int i=0; i<dsTim.size(); i++){
//                            if(sanPhamUI.getCbTkTinhTrang().getSelectedItem().toString().equals(dsTim.get(i).getTinhTrang().toString())){
//                                dsTam.add(dsTim.get(i));
//                            }
//                        }
//                        dsTim = dsTam;
//                        dsTam = new ArrayList<>();
//                        if(!sanPhamUI.getCbTkThuongHieu().getSelectedItem().toString().equals("--Thương hiệu--")){
//                            for(int i=0; i<dsTim.size(); i++){
//                                if(sanPhamUI.getCbTkThuongHieu().getSelectedItem().toString().equals(dsTim.get(i).getThuongHieu().getTenTH().toString())){
//                                    dsTam.add(dsTim.get(i));
//                                }
//                            }
//                            dsTim = dsTam;
//                            dsTam = new ArrayList<>();
//                            if(!sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals("--Kích thước--")){
//                                for(int i=0; i<dsTim.size(); i++){
//                                    if(sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals(dsTim.get(i).getKichThuoc().toString())){
//                                        dsTam.add(dsTim.get(i));
//                                    }
//                                }
//                                dsTim = dsTam;
//                                dsTam = new ArrayList<>();
//                                if(!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")){
//                                    for(int i=0; i<dsTim.size(); i++){
//                                        if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                            dsTam.add(dsTim.get(i));
//                                        }
//                                    }
//                                    dsTim = dsTam;
//                                    dsTam = new ArrayList<>();
//                                }
//                            }
//                            else if (!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")) {
//                                for(int i=0; i<dsTim.size(); i++){
//                                    if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                        dsTam.add(dsTim.get(i));
//                                    }
//                                }
//                                dsTim = dsTam;
//                                dsTam = new ArrayList<>();
//                            }
//                        }
//                        else if (!sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals("--Kích thước--")) {
//                            for(int i=0; i<dsTim.size(); i++){
//                                if(sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals(dsTim.get(i).getKichThuoc().toString())){
//                                    dsTam.add(dsTim.get(i));
//                                }
//                            }
//                            dsTim = dsTam;
//                            dsTam = new ArrayList<>();
//                            if(!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")){
//                                for(int i=0; i<dsTim.size(); i++){
//                                    if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                        dsTam.add(dsTim.get(i));
//                                    }
//                                }
//                                dsTim = dsTam;
//                                dsTam = new ArrayList<>();
//                            }
//                        }
//                        else if (!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")) {
//                            for(int i=0; i<dsTim.size(); i++){
//                                if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                    dsTam.add(dsTim.get(i));
//                                }
//                            }
//                            dsTim = dsTam;
//                            dsTam = new ArrayList<>();
//                        }
//                    }
//                    else if (!sanPhamUI.getCbTkThuongHieu().getSelectedItem().toString().equals("--Thương hiệu--")) {
//                        for(int i=0; i<dsTim.size(); i++){
//                            if(sanPhamUI.getCbTkThuongHieu().getSelectedItem().toString().equals(dsTim.get(i).getThuongHieu().getTenTH().toString())){
//                                dsTam.add(dsTim.get(i));
//                            }
//                        }
//                        dsTim = dsTam;
//                        dsTam = new ArrayList<>();
//                        if(!sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals("--Kích thước--")){
//                            for(int i=0; i<dsTim.size(); i++){
//                                if(sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals(dsTim.get(i).getKichThuoc().toString())){
//                                    dsTam.add(dsTim.get(i));
//                                }
//                            }
//                            dsTim = dsTam;
//                            dsTam = new ArrayList<>();
//                            if(!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")){
//                                for(int i=0; i<dsTim.size(); i++){
//                                    if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                        dsTam.add(dsTim.get(i));
//                                    }
//                                }
//                                dsTim = dsTam;
//                                dsTam = new ArrayList<>();
//                            }
//                        }
//                        else if (!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")) {
//                            for(int i=0; i<dsTim.size(); i++){
//                                if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                    dsTam.add(dsTim.get(i));
//                                }
//                            }
//                            dsTim = dsTam;
//                            dsTam = new ArrayList<>();
//                        }
//                    }
//                    else if (!sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals("--Kích thước--")) {
//                        for(int i=0; i<dsTim.size(); i++){
//                            if(sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals(dsTim.get(i).getKichThuoc().toString())){
//                                dsTam.add(dsTim.get(i));
//                            }
//                        }
//                        dsTim = dsTam;
//                        dsTam = new ArrayList<>();
//                        if(!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")){
//                            for(int i=0; i<dsTim.size(); i++){
//                                if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                    dsTam.add(dsTim.get(i));
//                                }
//                            }
//                            dsTim = dsTam;
//                            dsTam = new ArrayList<>();
//                        }
//                    }
//                    else if(!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")){
//                        for(int i=0; i<dsTim.size(); i++){
//                            if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                dsTam.add(dsTim.get(i));
//                            }
//                        }
//                        dsTim = dsTam;
//                        dsTam = new ArrayList<>();
//                    }
//                }
//                else if(!sanPhamUI.getCbTkTinhTrang().getSelectedItem().toString().equals("--Tình trạng--")){
//                    for(int i=0; i<dsTim.size(); i++){
//                        if(sanPhamUI.getCbTkTinhTrang().getSelectedItem().toString().equals(dsTim.get(i).getTinhTrang().toString())){
//                            dsTam.add(dsTim.get(i));
//                        }
//                    }
//                    dsTim = dsTam;
//                    dsTam = new ArrayList<>();
//                    if(!sanPhamUI.getCbTkThuongHieu().getSelectedItem().toString().equals("--Thương hiệu--")){
//                        for(int i=0; i<dsTim.size(); i++){
//                            if(sanPhamUI.getCbTkThuongHieu().getSelectedItem().toString().equals(dsTim.get(i).getThuongHieu().getTenTH().toString())){
//                                dsTam.add(dsTim.get(i));
//                            }
//                        }
//                        dsTim = dsTam;
//                        dsTam = new ArrayList<>();
//                        if(!sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals("--Kích thước--")){
//                            for(int i=0; i<dsTim.size(); i++){
//                                if(sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals(dsTim.get(i).getKichThuoc().toString())){
//                                    dsTam.add(dsTim.get(i));
//                                }
//                            }
//                            dsTim = dsTam;
//                            dsTam = new ArrayList<>();
//                            if(!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")){
//                                for(int i=0; i<dsTim.size(); i++){
//                                    if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                        dsTam.add(dsTim.get(i));
//                                    }
//                                }
//                                dsTim = dsTam;
//                                dsTam = new ArrayList<>();
//                            }
//                        }
//                    }
//                    else if (!sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals("--Kích thước--")) {
//                        for(int i=0; i<dsTim.size(); i++){
//                            if(sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals(dsTim.get(i).getKichThuoc().toString())){
//                                dsTam.add(dsTim.get(i));
//                            }
//                        }
//                        dsTim = dsTam;
//                        dsTam = new ArrayList<>();
//                        if(!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")){
//                            for(int i=0; i<dsTim.size(); i++){
//                                if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                    dsTam.add(dsTim.get(i));
//                                }
//                            }
//                            dsTim = dsTam;
//                            dsTam = new ArrayList<>();
//                        }
//                    }
//                    else if (!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")) {
//                        for(int i=0; i<dsTim.size(); i++){
//                            if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                dsTam.add(dsTim.get(i));
//                            }
//                        }
//                        dsTim = dsTam;
//                        dsTam = new ArrayList<>();
//                    }
//                }
//                else if(!sanPhamUI.getCbTkThuongHieu().getSelectedItem().toString().equals("--Thương hiệu--")){
//                    for(int i=0; i<dsTim.size(); i++){
//                        if(sanPhamUI.getCbTkThuongHieu().getSelectedItem().toString().equals(dsTim.get(i).getThuongHieu().getTenTH().toString())){
//                            dsTam.add(dsTim.get(i));
//                        }
//                    }
//                    dsTim = dsTam;
//                    dsTam = new ArrayList<>();
//                    if(!sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals("--Kích thước--")){
//                        for(int i=0; i<dsTim.size(); i++){
//                            if(sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals(dsTim.get(i).getKichThuoc().toString())){
//                                dsTam.add(dsTim.get(i));
//                            }
//                        }
//                        dsTim = dsTam;
//                        dsTam = new ArrayList<>();
//                        if(!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")){
//                            for(int i=0; i<dsTim.size(); i++){
//                                if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                    dsTam.add(dsTim.get(i));
//                                }
//                            }
//                            dsTim = dsTam;
//                            dsTam = new ArrayList<>();
//                        }
//                    }
//                    else if(!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")){
//                        for(int i=0; i<dsTim.size(); i++){
//                            if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                dsTam.add(dsTim.get(i));
//                            }
//                        }
//                        dsTim = dsTam;
//                        dsTam = new ArrayList<>();
//                    }
//                }
//                else if(!sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals("--Kích thước--")){
//                    for(int i=0; i<dsTim.size(); i++){
//                        if(sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals(dsTim.get(i).getKichThuoc().toString())){
//                            dsTam.add(dsTim.get(i));
//                        }
//                    }
//                    dsTim = dsTam;
//                    dsTam = new ArrayList<>();
//                    if(!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")){
//                        for(int i=0; i<dsTim.size(); i++){
//                            if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                dsTam.add(dsTim.get(i));
//                            }
//                        }
//                        dsTim = dsTam;
//                        dsTam = new ArrayList<>();
//                    }
//                }
//                else if(!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")){
//                    for(int i=0; i<dsTim.size(); i++){
//                        if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                            dsTam.add(dsTim.get(i));
//                        }
//                    }
//                    dsTim = dsTam;
//                    dsTam = new ArrayList<>();
//                }
//            }
//            else if(!sanPhamUI.getCbTkLoaiSanPham().getSelectedItem().toString().equals("--Loại--")){
//                Map<String, Object> conditionsLoai = new HashMap<>();
//                conditionsLoai.put("TenLoai", sanPhamUI.getCbTkLoaiSanPham().getSelectedItem().toString());
//                try {
//                    dsLoaiTim = loaiSanPhamDAO.timKiem(conditionsLoai);
//                } catch (Exception ex) {
//                    throw new RuntimeException(ex);
//                }
//                //
//                for(int i=0; i<dsLoaiTim.size(); i++){
//                    Map<String, Object> conditionsSp = new HashMap<>();
//                    conditionsSp.put("MaLoai", dsLoaiTim.get(i).getMaLoai().toString());
//                    try {
//                        dsTim.addAll(sanPhamDAO.timKiem(conditionsSp));
//                    } catch (Exception ex) {
//                        throw new RuntimeException(ex);
//                    }
//                }
//                if (!sanPhamUI.getCbTkTinhTrang().getSelectedItem().toString().equals("--Tình trạng--")){
//                    for(int i=0; i<dsTim.size(); i++){
//                        if(sanPhamUI.getCbTkTinhTrang().getSelectedItem().toString().equals(dsTim.get(i).getTinhTrang().toString())){
//                            dsTam.add(dsTim.get(i));
//                        }
//                    }
//                    dsTim = dsTam;
//                    dsTam = new ArrayList<>();
//                    if(!sanPhamUI.getCbTkThuongHieu().getSelectedItem().toString().equals("--Thương hiệu--")){
//                        for(int i=0; i<dsTim.size(); i++){
//                            if(sanPhamUI.getCbTkThuongHieu().getSelectedItem().toString().equals(dsTim.get(i).getThuongHieu().getTenTH().toString())){
//                                dsTam.add(dsTim.get(i));
//                            }
//                        }
//                        dsTim = dsTam;
//                        dsTam = new ArrayList<>();
//                        if(!sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals("--Kích thước--")){
//                            for(int i=0; i<dsTim.size(); i++){
//                                if(sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals(dsTim.get(i).getKichThuoc().toString())){
//                                    dsTam.add(dsTim.get(i));
//                                }
//                            }
//                            dsTim = dsTam;
//                            dsTam = new ArrayList<>();
//                            if(!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")){
//                                for(int i=0; i<dsTim.size(); i++){
//                                    if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                        dsTam.add(dsTim.get(i));
//                                    }
//                                }
//                                dsTim = dsTam;
//                                dsTam = new ArrayList<>();
//                            }
//                        }
//                        else if (!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")) {
//                            for(int i=0; i<dsTim.size(); i++){
//                                if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                    dsTam.add(dsTim.get(i));
//                                }
//                            }
//                            dsTim = dsTam;
//                            dsTam = new ArrayList<>();
//                        }
//                    }
//                    else if (!sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals("--Kích thước--")) {
//                        for(int i=0; i<dsTim.size(); i++){
//                            if(sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals(dsTim.get(i).getKichThuoc().toString())){
//                                dsTam.add(dsTim.get(i));
//                            }
//                        }
//                        dsTim = dsTam;
//                        dsTam = new ArrayList<>();
//                        if(!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")){
//                            for(int i=0; i<dsTim.size(); i++){
//                                if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                    dsTam.add(dsTim.get(i));
//                                }
//                            }
//                            dsTim = dsTam;
//                            dsTam = new ArrayList<>();
//                        }
//                    }
//                    else if (!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")) {
//                        for(int i=0; i<dsTim.size(); i++){
//                            if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                dsTam.add(dsTim.get(i));
//                            }
//                        }
//                        dsTim = dsTam;
//                        dsTam = new ArrayList<>();
//                    }
//                }
//                else if(!sanPhamUI.getCbTkThuongHieu().getSelectedItem().toString().equals("--Thương hiệu--")){
//                    for(int i=0; i<dsTim.size(); i++){
//                        if(sanPhamUI.getCbTkThuongHieu().getSelectedItem().toString().equals(dsTim.get(i).getThuongHieu().getTenTH().toString())){
//                            dsTam.add(dsTim.get(i));
//                        }
//                    }
//                    dsTim = dsTam;
//                    dsTam = new ArrayList<>();
//                    if(!sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals("--Kích thước--")){
//                        for(int i=0; i<dsTim.size(); i++){
//                            if(sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals(dsTim.get(i).getKichThuoc().toString())){
//                                dsTam.add(dsTim.get(i));
//                            }
//                        }
//                        dsTim = dsTam;
//                        dsTam = new ArrayList<>();
//                        if(!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")){
//                            for(int i=0; i<dsTim.size(); i++){
//                                if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                    dsTam.add(dsTim.get(i));
//                                }
//                            }
//                            dsTim = dsTam;
//                            dsTam = new ArrayList<>();
//                        }
//                    }
//                    else if (!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")) {
//                        for(int i=0; i<dsTim.size(); i++){
//                            if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                dsTam.add(dsTim.get(i));
//                            }
//                        }
//                        dsTim = dsTam;
//                        dsTam = new ArrayList<>();
//                    }
//                }
//                else if(!sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals("--Kích thước--")){
//                    for(int i=0; i<dsTim.size(); i++){
//                        if(sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals(dsTim.get(i).getKichThuoc().toString())){
//                            dsTam.add(dsTim.get(i));
//                        }
//                    }
//                    dsTim = dsTam;
//                    dsTam = new ArrayList<>();
//                    if(!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")){
//                        for(int i=0; i<dsTim.size(); i++){
//                            if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                dsTam.add(dsTim.get(i));
//                            }
//                        }
//                        dsTim = dsTam;
//                        dsTam = new ArrayList<>();
//                    }
//                    else if(!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")){
//                        for(int i=0; i<dsTim.size(); i++){
//                            if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                dsTam.add(dsTim.get(i));
//                            }
//                        }
//                        dsTim = dsTam;
//                        dsTam = new ArrayList<>();
//                    }
//                }
//                else if (!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")) {
//                    for(int i=0; i<dsTim.size(); i++){
//                        if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                            dsTam.add(dsTim.get(i));
//                        }
//                    }
//                    dsTim = dsTam;
//                    dsTam = new ArrayList<>();
//                }
//            }
//            else if (!sanPhamUI.getCbTkTinhTrang().getSelectedItem().toString().equals("--Tình trạng--")) {
//                Map<String, Object> conditionsTinhTrang = new HashMap<>();
//                conditionsTinhTrang.put("TinhTrang", sanPhamUI.getCbTkTinhTrang().getSelectedItem().toString());
//                try {
//                    dsTim = sanPhamDAO.timKiem(conditionsTinhTrang);
//                } catch (Exception ex) {
//                    throw new RuntimeException(ex);
//                }
//                if(!sanPhamUI.getCbTkThuongHieu().getSelectedItem().toString().equals("--Thương hiệu--")){
//                    for(int i=0; i<dsTim.size(); i++){
//                        if(sanPhamUI.getCbTkThuongHieu().getSelectedItem().toString().equals(dsTim.get(i).getThuongHieu().getTenTH().toString())){
//                            dsTam.add(dsTim.get(i));
//                        }
//                    }
//                    dsTim = dsTam;
//                    dsTam = new ArrayList<>();
//                    if(!sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals("--Kích thước--")){
//                        for(int i=0; i<dsTim.size(); i++){
//                            if(sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals(dsTim.get(i).getKichThuoc().toString())){
//                                dsTam.add(dsTim.get(i));
//                            }
//                        }
//                        dsTim = dsTam;
//                        dsTam = new ArrayList<>();
//                        if(!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")){
//                            for(int i=0; i<dsTim.size(); i++){
//                                if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                    dsTam.add(dsTim.get(i));
//                                }
//                            }
//                            dsTim = dsTam;
//                            dsTam = new ArrayList<>();
//                        }
//                    }
//                    else if (!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")) {
//                        for(int i=0; i<dsTim.size(); i++){
//                            if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                dsTam.add(dsTim.get(i));
//                            }
//                        }
//                        dsTim = dsTam;
//                        dsTam = new ArrayList<>();
//                    }
//                }
//                else if (!sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals("--Kích thước--")) {
//                    for(int i=0; i<dsTim.size(); i++){
//                        if(sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals(dsTim.get(i).getKichThuoc().toString())){
//                            dsTam.add(dsTim.get(i));
//                        }
//                    }
//                    dsTim = dsTam;
//                    dsTam = new ArrayList<>();
//                    if(!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")){
//                        for(int i=0; i<dsTim.size(); i++){
//                            if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                dsTam.add(dsTim.get(i));
//                            }
//                        }
//                        dsTim = dsTam;
//                        dsTam = new ArrayList<>();
//                    }
//                }
//                else if (!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")) {
//                    for(int i=0; i<dsTim.size(); i++){
//                        if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                            dsTam.add(dsTim.get(i));
//                        }
//                    }
//                    dsTim = dsTam;
//                    dsTam = new ArrayList<>();
//                }
//            }
//            else if(!sanPhamUI.getCbTkThuongHieu().getSelectedItem().toString().equals("--Thương hiệu--")){
//                Map<String, Object> conditionsTenThuongHieu = new HashMap<>();
//                conditionsTenThuongHieu.put("TenTH", sanPhamUI.getCbTkThuongHieu().getSelectedItem().toString());
//                try {
//                    dsThuongHieuTim = thuongHieuDAO.timKiem(conditionsTenThuongHieu);
//                } catch (Exception ex) {
//                    throw new RuntimeException(ex);
//                }
//                //
//                Map<String, Object> conditionsSanPham = new HashMap<>();
//                conditionsSanPham.put("MaTH", dsThuongHieuTim.get(0).getMaTH().toString());
//                try {
//                    dsTim = sanPhamDAO.timKiem(conditionsSanPham);
//                } catch (Exception ex) {
//                    throw new RuntimeException(ex);
//                }
//                if(!sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals("--Kích thước--")){
//                    for(int i=0; i<dsTim.size(); i++){
//                        if(sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals(dsTim.get(i).getKichThuoc().toString())){
//                            dsTam.add(dsTim.get(i));
//                        }
//                    }
//                    dsTim = dsTam;
//                    dsTam = new ArrayList<>();
//                    if(!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")){
//                        for(int i=0; i<dsTim.size(); i++){
//                            if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                                dsTam.add(dsTim.get(i));
//                            }
//                        }
//                        dsTim = dsTam;
//                        dsTam = new ArrayList<>();
//                    }
//                }
//                else if (!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")) {
//                    for(int i=0; i<dsTim.size(); i++){
//                        if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                            dsTam.add(dsTim.get(i));
//                        }
//                    }
//                    dsTim = dsTam;
//                    dsTam = new ArrayList<>();
//                }
//            }
//            else if(!sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString().equals("--Kích thước--")){
//                Map<String, Object> conditionsKichThuoc = new HashMap<>();
//                conditionsKichThuoc.put("KichThuoc", sanPhamUI.getCbTkKichThuocSp().getSelectedItem().toString());
//                try {
//                    dsTim = sanPhamDAO.timKiem(conditionsKichThuoc);
//                } catch (Exception ex) {
//                    throw new RuntimeException(ex);
//                }
//                if(!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")){
//                    for(int i=0; i<dsTim.size(); i++){
//                        if(sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals(dsTim.get(i).getPhongCachMac().toString())){
//                            dsTam.add(dsTim.get(i));
//                        }
//                    }
//                    dsTim = dsTam;
//                    dsTam = new ArrayList<>();
//                    System.out.println(1);
//                }
//            }
//            else if(!sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString().equals("--Phong cách--")){
//                System.out.println(2);
//                Map<String, Object> conditionsPhongCach = new HashMap<>();
//                conditionsPhongCach.put("PhongCachMac", sanPhamUI.getCbTkPhongCachMac().getSelectedItem().toString());
//                try {
//                    dsTim = sanPhamDAO.timKiem(conditionsPhongCach);
//                } catch (Exception ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//            else {
//                try {
//                    dsTim = sanPhamDAO.timKiem();
//                } catch (Exception ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//
//            //Load lọc
//            DefaultTableModel clearTable = (DefaultTableModel) sanPhamUI.getTbDanhSachSanPham().getModel();
//            clearTable.setRowCount(0);
//            sanPhamUI.getTbDanhSachSanPham().setModel(clearTable);
//
//            DefaultTableModel tmSanPham = (DefaultTableModel) sanPhamUI.getTbDanhSachSanPham().getModel();
//            for(SanPham sp : dsTim){
//                String row[] = {sp.getMaSP(), sp.getTenSP(), sp.getXuatXu(), sp.getThuongHieu().getTenTH()+"", sp.getLoaiSanPham().getDanhMucSanPham().getTenDM()+"", sp.getLoaiSanPham().getTenLoai()+"", sp.getKichThuoc(), sp.getPhongCachMac()+"", sp.getPhanTramLoi()+"%", sp.getTinhTrang()+""};
//                tmSanPham.addRow(row);
//            }
//        }

        /*NÚT LẤY ẢNH TỪ MÁY*/
//        if(op.equals(sanPhamUI.getBtnThemAnhSanPham())){
//            JFileChooser fileChooser = new JFileChooser();
//            fileChooser.setFileFilter(new FileNameExtensionFilter("Hình ảnh", "jpg", "jpeg", "png"));
//            int result = fileChooser.showOpenDialog(null);
//
//            if (result == JFileChooser.APPROVE_OPTION) {
//                File selectedFile = fileChooser.getSelectedFile();
//                // Lấy tên file và đuôi file
//                fileAnh = selectedFile.getName();
//                URL path = getClass().getResource("/img/imgSanPham/"+fileAnh);
//                if(path==null){
//                    path = getClass().getResource("/img/imgSanPham/Image_not_available.png");
//                }
//
//                ImageIcon iconGoc = new ImageIcon(path);
//                Image anh = iconGoc.getImage();
//                Image tinhChinhAnh = anh.getScaledInstance(200, 320, Image.SCALE_SMOOTH);
//                ImageIcon icon = new ImageIcon(tinhChinhAnh);
//                JLabel picLabel = new JLabel();
//                sanPhamUI.getPnImgSanPham().removeAll();
//                sanPhamUI.getPnImgSanPham().add(picLabel);
//                picLabel.setSize(new Dimension(240,320));
//                picLabel.setIcon(icon);
//            }
//        }
    }

    //Hàm lấy sản phẩm từ phần thông tin sản phẩm
//    private SanPham layDataThem() {
//        SanPham sp;
//        String ten = sanPhamUI.getTxtTenSanPham().getText();
//
//        // Lấy ngày từ JDateChooser
//        Date selectedDate = sanPhamUI.getJDateChooserNgaySanXuat().getDate();
//
//        // Chuyển đổi từ Date sang LocalDate
//        LocalDate localDate = dateToLocalDate(selectedDate);
//
//        String xuatXu = sanPhamUI.getTxtXuatXu().getText();
//        DoTuoi doTuoi = DoTuoi.layGiaTri(sanPhamUI.getCbDoTuoi().getSelectedItem().toString());
//        List<DanhMucSanPham> danhMucs = new ArrayList<>();
//        List<LoaiSanPham> loaiSanPhams = new ArrayList<>();
//        List<ThuongHieu> thuongHieu = new ArrayList<>();
//        try {
//            Map<String, Object> dm = new HashMap<>();
//            dm.put("TenDM", sanPhamUI.getDanhMuc().getSelectedItem().toString());
//            danhMucs = danhMucSanPhamDAO.timKiem(dm);
//
//
//
//            Map<String, Object> loai = new HashMap<>();
//            loai.put("TenLoai", sanPhamUI.getCbLoai().getSelectedItem().toString());
//            loaiSanPhams = loaiSanPhamDAO.timKiem(loai);
//
//            Map<String, Object> th = new HashMap<>();
//            th.put("TenTH", sanPhamUI.getCbThuongHieu().getSelectedItem().toString());
//            thuongHieu = thuongHieuDAO.timKiem(th);
//
//        } catch (Exception ex) {
//            throw new RuntimeException(ex);
//        }
//
//        MauSac ms = MauSac.layGiaTri(sanPhamUI.getCbMauSac().getSelectedItem().toString());
//        String kt = sanPhamUI.getTxtKichThuoc().getText().toString();
//        float ptl = Float.parseFloat(sanPhamUI.getTxtPhamTramLoi().getText().toString());
//        PhongCachMac pcm = PhongCachMac.layGiaTri(sanPhamUI.getCbKieuNguoiMac().getSelectedItem().toString());
//
//        //Hình ảnh
//        String anh = fileAnh;
//
//        TinhTrangSanPham tt = TinhTrangSanPham.layGiaTri(sanPhamUI.getCbTinhTrang().getSelectedItem().toString());
//        int soLuong = Integer.parseInt(sanPhamUI.getTxtSoLuongSanPham().getText());
//
//        //Mã sản phẩm
//        String ma = laymaSP();
//        try {
//            sp = new SanPham(ma,ten,loaiSanPhams.get(0),pcm,doTuoi,xuatXu,soLuong,thuongHieu.get(0),ptl,ms,kt,anh,localDate,tt);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return sp;
//    }

    //Hàm lấy sản phẩm để update
//    private SanPham layDataSua() {
//        SanPham sps;
//        String ten = sanPhamUI.getTxtTenSanPham().getText();
//
//        // Lấy ngày từ JDateChooser
//        Date selectedDate = sanPhamUI.getJDateChooserNgaySanXuat().getDate();
//
//        // Chuyển đổi từ Date sang LocalDate
//        LocalDate localDate = dateToLocalDate(selectedDate);
//
//        String xuatXu = sanPhamUI.getTxtXuatXu().getText();
//        DoTuoi doTuoi = DoTuoi.layGiaTri(sanPhamUI.getCbDoTuoi().getSelectedItem().toString());
//        List<DanhMucSanPham> danhMucs = new ArrayList<>();
//        List<LoaiSanPham> loaiSanPhams = new ArrayList<>();
//        List<ThuongHieu> thuongHieu = new ArrayList<>();
//        try {
//            Map<String, Object> dm = new HashMap<>();
//            dm.put("TenDM", sanPhamUI.getDanhMuc().getSelectedItem().toString());
//            danhMucs = danhMucSanPhamDAO.timKiem(dm);
//
//
//
//            Map<String, Object> loai = new HashMap<>();
//            loai.put("TenLoai", sanPhamUI.getCbLoai().getSelectedItem().toString());
//            loaiSanPhams = loaiSanPhamDAO.timKiem(loai);
//
//            Map<String, Object> th = new HashMap<>();
//            th.put("TenTH", sanPhamUI.getCbThuongHieu().getSelectedItem().toString());
//            thuongHieu = thuongHieuDAO.timKiem(th);
//
//        } catch (Exception ex) {
//            throw new RuntimeException(ex);
//        }
//
//        MauSac ms = MauSac.layGiaTri(sanPhamUI.getCbMauSac().getSelectedItem().toString());
//        String kt = sanPhamUI.getTxtKichThuoc().getText().toString();
//        float ptl = Float.parseFloat(sanPhamUI.getTxtPhamTramLoi().getText().toString());
//        PhongCachMac pcm = PhongCachMac.layGiaTri(sanPhamUI.getCbKieuNguoiMac().getSelectedItem().toString());
//
//        //Hình ảnh
//        String anh = fileAnh;
//        TinhTrangSanPham tt = TinhTrangSanPham.layGiaTri(sanPhamUI.getCbTinhTrang().getSelectedItem().toString());
//        int soLuong = Integer.parseInt(sanPhamUI.getTxtSoLuongSanPham().getText());
//
//        //Mã sản phẩm
//        String ma = sanPhamUI.getTxtMaSanPham().getText();
//        try {
//            sps = new SanPham(ma,ten,loaiSanPhams.get(0),pcm,doTuoi,xuatXu,soLuong,thuongHieu.get(0),ptl,ms,kt,anh,localDate,tt);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return sps;
//    }

    //Hàm sinh mã sản phẩm
    public String laymaSP(){
        String maSP = getInitials(sanPhamUI.getTxtTenSanPham().getText())+"-";
        String nl = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")).toString();
        maSP = maSP+nl+"-";
//        String mau = sanPhamUI.getCbMauSac().getSelectedItem().toString();
//        maSP = maSP + mau + "-";
//        maSP = maSP + sanPhamUI.getTxtKichThuoc().getText();
        return maSP;
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

    //Hàm xóa trắng dữ liệu nhập
    public void xoaTrangAll(){
        loadComboBoxPhanThongTinSP();
        sanPhamUI.getTxtMaSanPham().setText("");
        sanPhamUI.getTxtTenSanPham().setText("");
        sanPhamUI.getJDateChooserNgaySanXuat().setDate(null);
        sanPhamUI.getTxtXuatXu().setText("");
//        sanPhamUI.getTxtKichThuoc().setText("");
        sanPhamUI.getTxtPhamTramLoi().setText("");
//        sanPhamUI.getTxtSoLuongSanPham().setText("");
//        sanPhamUI.getPnImgSanPham().removeAll();
//        sanPhamUI.getPnImgSanPham().revalidate();
//        sanPhamUI.getPnImgSanPham().repaint();
    }

    //Xóa trắng khi sửa
    public void xoaTrangSua(){
        loadComboBoxPhanThongTinSP();
        sanPhamUI.getTxtTenSanPham().setText("");
        sanPhamUI.getJDateChooserNgaySanXuat().setDate(null);
        sanPhamUI.getTxtXuatXu().setText("");
//        sanPhamUI.getTxtKichThuoc().setText("");
        sanPhamUI.getTxtPhamTramLoi().setText("");
//        sanPhamUI.getTxtSoLuongSanPham().setText("");
    }

    //Load các comboBox phần thông tin
    public void loadComboBoxPhanThongTinSP(){
        //Lấy độ tuổi từ enum
        DoTuoi[] dsDoTuoi = DoTuoi.values();
        String[] itemsDoTuoi = new String[dsDoTuoi.length + 1];
        itemsDoTuoi[0] = "--Select--";
        for (int i = 0; i < dsDoTuoi.length; i++) {
            itemsDoTuoi[i + 1] = dsDoTuoi[i].toString();
        }
        DefaultComboBoxModel<String> doTuoiCb = new DefaultComboBoxModel<>(itemsDoTuoi);
        sanPhamUI.getCbDoTuoi().setModel(doTuoiCb);

        //Lấy tình trạng từ enum
        TinhTrangSanPham[] dsTinhTrang = TinhTrangSanPham.values();
        String[] itemsTinhTrang = new String[dsTinhTrang.length + 1];
        itemsTinhTrang[0] = "--Select--";
        for (int i = 0; i < dsTinhTrang.length; i++) {
            itemsTinhTrang[i + 1] = dsTinhTrang[i].toString();
        }
        DefaultComboBoxModel<String> tinhTrangCb = new DefaultComboBoxModel<>(itemsTinhTrang);
        sanPhamUI.getCbTinhTrang().setModel(tinhTrangCb);

        //Lấy màu sắc từ enum
        MauSac[] dsMauSac = MauSac.values();
        String[] itemsMauSac = new String[dsMauSac.length + 1];
        itemsMauSac[0] = "--Select--";
        for (int i = 0; i < dsMauSac.length; i++) {
            itemsMauSac[i + 1] = dsMauSac[i].toString();
        }
        DefaultComboBoxModel<String> mauSacCb = new DefaultComboBoxModel<>(itemsMauSac);
//        sanPhamUI.getCbMauSac().setModel(mauSacCb);

        //Lấy tình trạng từ enum
        PhongCachMac[] dsPhongCachMac = PhongCachMac.values();
        String[] itemsPhongCachMac = new String[dsPhongCachMac.length + 1];
        itemsPhongCachMac[0] = "--Select--";
        for (int i = 0; i < dsPhongCachMac.length; i++) {
            itemsPhongCachMac[i + 1] = dsPhongCachMac[i].toString();
        }
        DefaultComboBoxModel<String> PhongCachMacCb = new DefaultComboBoxModel<>(itemsPhongCachMac);
        sanPhamUI.getCbKieuNguoiMac().setModel(PhongCachMacCb);

        //Load cbDanhMuc
        try {
            dsDanhMucSanPham = danhMucSanPhamDAO.timKiem();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String[] danhMucArray = dsDanhMucSanPham.stream().map(DanhMucSanPham::getTenDM).toArray(String[]::new);
        String[] itemsDanhMuc = new String[danhMucArray.length + 1];
        itemsDanhMuc[0] = "--Select--";
        System.arraycopy(danhMucArray, 0, itemsDanhMuc, 1, danhMucArray.length);
        DefaultComboBoxModel<String> danhMucComboBoxModel = new DefaultComboBoxModel<>(itemsDanhMuc);
        sanPhamUI.getDanhMuc().setModel(danhMucComboBoxModel);

        //Load cbLoaiSanPham
        try {
            dsLoaiSanPham = loaiSanPhamDAO.timKiem();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String[] loaiArray = dsLoaiSanPham.stream().map(LoaiSanPham::getTenLoai).toArray(String[]::new);
        String[] itemsLoai = new String[loaiArray.length + 1];
        itemsLoai[0] = "--Select--";
        System.arraycopy(loaiArray, 0, itemsLoai, 1, loaiArray.length);
        DefaultComboBoxModel<String> loaiComboBoxModel = new DefaultComboBoxModel<>(itemsLoai);
        sanPhamUI.getCbLoai().setModel(loaiComboBoxModel);

        //Load cbThuongHieu
        try {
            dsThuongHieu = thuongHieuDAO.timKiem();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String[] thuongHieuArray = dsThuongHieu.stream().map(ThuongHieu::getTenTH).toArray(String[]::new);
        String[] itemsThuongHieu = new String[thuongHieuArray.length + 1];
        itemsThuongHieu[0] = "--Select--";
        System.arraycopy(thuongHieuArray, 0, itemsThuongHieu, 1, thuongHieuArray.length);
        DefaultComboBoxModel<String> thuongHieuComboBoxModel = new DefaultComboBoxModel<>(itemsThuongHieu);
        sanPhamUI.getCbThuongHieu().setModel(thuongHieuComboBoxModel);
    }

    //Load các comboBox phần tìm kiếm
    public void loadComboBoxPhanTimKiem(){
        //Load cbDanhMuc
        try {
            dsDanhMucSanPham = danhMucSanPhamDAO.timKiem();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String[] danhMucArray = dsDanhMucSanPham.stream().map(DanhMucSanPham::getTenDM).toArray(String[]::new);
        String[] itemsDanhMuc = new String[danhMucArray.length + 1];
        itemsDanhMuc[0] = "--Danh mục--";
        System.arraycopy(danhMucArray, 0, itemsDanhMuc, 1, danhMucArray.length);
        DefaultComboBoxModel<String> danhMucComboBoxModel = new DefaultComboBoxModel<>(itemsDanhMuc);
        sanPhamUI.getCbTkDanhMuc().setModel(danhMucComboBoxModel);

        //Load cbLoaiSanPham
        try {
            dsLoaiSanPham = loaiSanPhamDAO.timKiem();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String[] loaiArray = dsLoaiSanPham.stream().map(LoaiSanPham::getTenLoai).toArray(String[]::new);
        String[] itemsLoai = new String[loaiArray.length + 1];
        itemsLoai[0] = "--Loại--";
        System.arraycopy(loaiArray, 0, itemsLoai, 1, loaiArray.length);
        DefaultComboBoxModel<String> loaiComboBoxModel = new DefaultComboBoxModel<>(itemsLoai);
        sanPhamUI.getCbTkLoaiSanPham().setModel(loaiComboBoxModel);

        //Lấy tình trạng từ enum
        TinhTrangSanPham[] dsTinhTrang = TinhTrangSanPham.values();
        String[] itemsTinhTrang = new String[dsTinhTrang.length + 1];
        itemsTinhTrang[0] = "--Tình trạng--";
        for (int i = 0; i < dsTinhTrang.length; i++) {
            itemsTinhTrang[i + 1] = dsTinhTrang[i].toString();
        }
        DefaultComboBoxModel<String> tinhTrangCb = new DefaultComboBoxModel<>(itemsTinhTrang);
        sanPhamUI.getCbTkTinhTrang().setModel(tinhTrangCb);

        //Load cbThuongHieu
        try {
            dsThuongHieu = thuongHieuDAO.timKiem();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String[] thuongHieuArray = dsThuongHieu.stream().map(ThuongHieu::getTenTH).toArray(String[]::new);
        String[] itemsThuongHieu = new String[thuongHieuArray.length + 1];
        itemsThuongHieu[0] = "--Thương hiệu--";
        System.arraycopy(thuongHieuArray, 0, itemsThuongHieu, 1, thuongHieuArray.length);
        DefaultComboBoxModel<String> thuongHieuComboBoxModel = new DefaultComboBoxModel<>(itemsThuongHieu);
        sanPhamUI.getCbTkThuongHieu().setModel(thuongHieuComboBoxModel);

        //Lấy kích thước
        String[] itemsKichThuoc = {"--Kích thước--", "S", "M", "L", "XL", "XXL", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42"};
        DefaultComboBoxModel<String> kichThuocComboBoxModel = new DefaultComboBoxModel<>(itemsKichThuoc);
        sanPhamUI.getCbTkKichThuocSp().setModel(kichThuocComboBoxModel);

        //Lấy PhongCachMac
        PhongCachMac[] dsPhongCachMac = PhongCachMac.values();
        String[] itemsPhongCachMac = new String[dsPhongCachMac.length + 1];
        itemsPhongCachMac[0] = "--Phong cách--";
        for (int i = 0; i < dsPhongCachMac.length; i++) {
            itemsPhongCachMac[i + 1] = dsPhongCachMac[i].toString();
        }
        DefaultComboBoxModel<String> PhongCachMacCb = new DefaultComboBoxModel<>(itemsPhongCachMac);
        sanPhamUI.getCbTkPhongCachMac().setModel(PhongCachMacCb);
    }

    //Hàm đóng/mở tương tác
    public void tuongTac(boolean c){
//        sanPhamUI.getTxtTenSanPham().setEnabled(c);
//        sanPhamUI.getJDateChooserNgaySanXuat().setEnabled(c);
//        sanPhamUI.getTxtXuatXu().setEnabled(c);
//        sanPhamUI.getCbDoTuoi().setEnabled(c);
//        sanPhamUI.getCbTinhTrang().setEnabled(c);
//        sanPhamUI.getDanhMuc().setEnabled(c);
//        sanPhamUI.getCbLoai().setEnabled(c);
//        sanPhamUI.getCbThuongHieu().setEnabled(c);
//        sanPhamUI.getCbMauSac().setEnabled(c);
//        sanPhamUI.getTxtKichThuoc().setEnabled(c);
//        sanPhamUI.getTxtPhamTramLoi().setEnabled(c);
//        sanPhamUI.getCbKieuNguoiMac().setEnabled(c);
//        sanPhamUI.getTxtSoLuongSanPham().setEnabled(c);
//        sanPhamUI.getBtnThemAnhSanPham().setEnabled(c);
    }
    //Hàm đóng/mở tương tác tìm kiếm
    public void tuongTacTimKiem(boolean o){
        sanPhamUI.getCbTkDanhMuc().setEnabled(o);
        sanPhamUI.getCbTkLoaiSanPham().setEnabled(o);
        sanPhamUI.getCbTkTinhTrang().setEnabled(o);
        sanPhamUI.getCbTkThuongHieu().setEnabled(o);
        sanPhamUI.getCbTkKichThuocSp().setEnabled(o);
        sanPhamUI.getCbTkPhongCachMac().setEnabled(o);
        sanPhamUI.getTxtTuKhoaTimKiem().setEnabled(o);
    }

//  Sự kiện click trên table load dữ liệu xuống phần thông tin
    @Override
    public void mouseClicked(MouseEvent event){
//        if(trangThaiNutThem==1){
//            JOptionPane.showMessageDialog(null, "Đang thực hiện chức năng thêm, không được click!!");
//        }
//        else {
//            int row = sanPhamUI.getTbDanhSachSanPham().getSelectedRow();
//            String ma = sanPhamUI.getTbDanhSachSanPham().getValueAt(row, 0).toString();
//            Optional<SanPham> spHienThuc = null;
//            try {
//                spHienThuc = sanPhamDAO.timKiem(ma);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//            sanPhamUI.getTxtMaSanPham().setText(spHienThuc.get().getMaSP());
//            sanPhamUI.getTxtTenSanPham().setText(spHienThuc.get().getTenSP());
//
//            //Xử lý ngày
//            String date = String.valueOf(spHienThuc.get().getNgaySanXuat());
//            Date date2 = null;
//            try {
//                date2 = new SimpleDateFormat("yyyy-mm-dd").parse(date);
//            } catch (ParseException e) {throw new RuntimeException(e);
//
//            }
//            sanPhamUI.getJDateChooserNgaySanXuat().setDate(date2);
//
//            sanPhamUI.getTxtXuatXu().setText(spHienThuc.get().getXuatXu());
//
//            sanPhamUI.getCbDoTuoi().setSelectedItem(spHienThuc.get().getDoTuoi().toString());
//            sanPhamUI.getCbTinhTrang().setSelectedItem(spHienThuc.get().getTinhTrang().toString());
//            sanPhamUI.getDanhMuc().setSelectedItem(spHienThuc.get().getLoaiSanPham().getDanhMucSanPham().getTenDM());
//            sanPhamUI.getCbLoai().setSelectedItem(spHienThuc.get().getLoaiSanPham().getTenLoai());
//            sanPhamUI.getCbThuongHieu().setSelectedItem(spHienThuc.get().getThuongHieu().getTenTH());
//            sanPhamUI.getCbMauSac().setSelectedItem(spHienThuc.get().getMauSac().toString());
//
//            sanPhamUI.getTxtKichThuoc().setText(spHienThuc.get().getKichThuoc());
//            sanPhamUI.getTxtPhamTramLoi().setText(String.valueOf(spHienThuc.get().getPhanTramLoi()));
//            sanPhamUI.getCbKieuNguoiMac().setSelectedItem(spHienThuc.get().getPhongCachMac().toString());
//            sanPhamUI.getTxtSoLuongSanPham().setText(String.valueOf(spHienThuc.get().getSoLuong()));
//
//            URL path = getClass().getResource("/img/imgSanPham/"+spHienThuc.get().getHinhAnh());
//            if(path==null){
//                path = getClass().getResource("/img/imgSanPham/Image_not_available.png");
//            }
//
//            ImageIcon iconGoc = new ImageIcon(path);
//            Image anh = iconGoc.getImage();
//            Image tinhChinhAnh = anh.getScaledInstance(200, 320, Image.SCALE_SMOOTH);
//            ImageIcon icon = new ImageIcon(tinhChinhAnh);
//            JLabel picLabel = new JLabel();
//            sanPhamUI.getPnImgSanPham().removeAll();
//            sanPhamUI.getPnImgSanPham().add(picLabel);
//            picLabel.setSize(new Dimension(240,320));
//            picLabel.setIcon(icon);
//        }
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
}
