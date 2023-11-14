package dev.skyherobrine.app.daos.product;

import dev.skyherobrine.app.daos.ConnectDB;
import dev.skyherobrine.app.daos.IDAO;
import dev.skyherobrine.app.entities.product.DanhMucSanPham;
import dev.skyherobrine.app.entities.product.SanPham;
import dev.skyherobrine.app.entities.product.ThuongHieu;
import dev.skyherobrine.app.enums.*;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class SanPhamDAO implements IDAO<SanPham> {
    private ConnectDB connectDB;
    public SanPhamDAO() throws Exception{
        connectDB = new ConnectDB();
    }
    @Override
    public boolean them(SanPham sanPham) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("Insert SanPham values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, sanPham.getMaSP());
        preparedStatement.setString(2, sanPham.getTenSP());
        preparedStatement.setString(3, sanPham.getLoaiSanPham().getMaLoai());
        preparedStatement.setString(4, sanPham.getPhongCachMac().toString());
        preparedStatement.setString(5, sanPham.getDoTuoi().toString());
        preparedStatement.setString(6, sanPham.getXuatXu());
        preparedStatement.setInt(7, sanPham.getSoLuong());
        preparedStatement.setString(8, sanPham.getThuongHieu().getMaTH());
        preparedStatement.setString(9, sanPham.getMauSac().toString());
        preparedStatement.setString(10, sanPham.getKichThuoc());
        preparedStatement.setString(11, sanPham.getHinhAnh());
        preparedStatement.setDate(12, Date.valueOf(sanPham.getNgaySanXuat()));
        preparedStatement.setString(12, sanPham.getTinhTrang().toString());

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean capNhat(SanPham target) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("Update SanPham set TenSP = ?, MaLoai = ?, PhongCachMac = ?, DoTuoi = ?, XuatXu = ?, MaTH = ?, PhanTramLoi = ?, MauSac = ?, KichThuoc = ?, HinhAnh = ?, NgaySanXuat = ?, TinhTrang = ? where MaSP = ?");

        return false;
    }

    @Override
    public boolean xoa(String id) throws Exception {
        return false;
    }

    @Override
    public int xoa(String... ids) throws Exception {
        return 0;
    }

    @Override
    public List<SanPham> timKiem() throws Exception {
        ResultSet resultSet = connectDB.getConnection().createStatement().executeQuery("select * from SanPham");
        List<SanPham> sanPhams = new ArrayList<>();
        while(resultSet.next()) {
            SanPham sanPham = new SanPham(resultSet.getString("MaSP"),
                    resultSet.getString("TenSP"),
                    new LoaiSanPhamDAO().timKiem(resultSet.getString("MaLoai")).get(),
                    PhongCachMac.layGiaTri(resultSet.getString("PhongCachMac")),
                    DoTuoi.layGiaTri(resultSet.getString("DoTuoi")),
                    resultSet.getString("XuatXu"),
                    resultSet.getInt("SoLuong"),
                    new ThuongHieuDAO().timKiem(resultSet.getString("MaTH")).get(),
                    resultSet.getFloat("PhanTramLoi"),
                    MauSac.layGiaTri(resultSet.getString("MauSac")),
                    resultSet.getString("KichThuoc"),
                    resultSet.getString("HinhAnh"),
                    resultSet.getDate("NgaySanXuat").toLocalDate(),
                    TinhTrangSanPham.layGiaTri(resultSet.getString("TinhTrang")));

            sanPhams.add(sanPham);
        }
        return sanPhams;
    }

    @Override
    public List<SanPham> timKiem(Map<String, Object> conditions) throws Exception {
        AtomicReference<String> query = new AtomicReference<>
                ("select * from SanPham t where ");
        AtomicBoolean isNeedAnd = new AtomicBoolean(false);

        conditions.forEach((column, value) -> {
            query.set(query.get() + (isNeedAnd.get() ? " and " : "") + ("t." + column + " like '%" + value + "%'"));
            isNeedAnd.set(true);
        });

        List<SanPham> sanPhams = new ArrayList<>();
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(query.get());
        ResultSet result = preparedStatement.executeQuery();
        while(result.next()) {
            SanPham sanPham = new SanPham(
                    result.getString("MaSP"),
                    result.getString("TenSP"),
                    new LoaiSanPhamDAO().timKiem(result.getString("MaLoai")).get(),
                    PhongCachMac.layGiaTri(result.getString("PhongCachMac")),
                    DoTuoi.layGiaTri(result.getString("DoTuoi")),
                    result.getString("SoLuong"),
                    result.getInt("SoLuong"),
                    new ThuongHieuDAO().timKiem(result.getString("ThuongHieu")).get(),
                    result.getFloat("PhanTramLoi"),
                    MauSac.layGiaTri(result.getString("MauSac")),
                    result.getString("KichThuoc"),
                    result.getString("HinhAnh"),
                    result.getDate("NgaySanXuat").toLocalDate(),
                    TinhTrangSanPham.layGiaTri(result.getString("TinhTrang"))
            );

            sanPhams.add(sanPham);
        }
        return sanPhams;
    }

    @Override
    public Optional<SanPham> timKiem(String id) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("select * from SanPham where MaSP = ?");
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            SanPham sanPham = new SanPham(resultSet.getString("MaSP"),
                    resultSet.getString("TenSP"),
                    new LoaiSanPhamDAO().timKiem(resultSet.getString("MaLoai")).get(),
                    PhongCachMac.layGiaTri(resultSet.getString("PhongCachMac")),
                    DoTuoi.layGiaTri(resultSet.getString("DoTuoi")),
                    resultSet.getString("XuatXu"),
                    resultSet.getInt("SoLuong"),
                    new ThuongHieuDAO().timKiem(resultSet.getString("MaTH")).get(),
                    resultSet.getFloat("PhanTramLoi"),
                    MauSac.layGiaTri(resultSet.getString("MauSac")),
                    resultSet.getString("KichThuoc"),
                    resultSet.getString("HinhAnh"),
                    resultSet.getDate("NgaySanXuat").toLocalDate(),
                    TinhTrangSanPham.layGiaTri(resultSet.getString("TinhTrang")));

            return Optional.of(sanPham);
        }
        return Optional.empty();
    }

    @Override
    public List<SanPham> timkiem(String... ids) throws Exception {
        String query = "select * from SanPham where ";
        String[] listID = (String[]) Arrays.stream(ids).toArray();
        for(int i = 0; i < listID.length; ++i) {
            query += ("MaSP like '%" + listID[i] + "%'");
            if((i + 1) >= listID.length) break;
            else query += ", ";
        }

        List<SanPham> sanPhams = new ArrayList<>();
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            SanPham sanPham = new SanPham(resultSet.getString("MaSP"),
                    resultSet.getString("TenSP"),
                    new LoaiSanPhamDAO().timKiem(resultSet.getString("MaLoai")).get(),
                    PhongCachMac.layGiaTri(resultSet.getString("PhongCachMac")),
                    DoTuoi.layGiaTri(resultSet.getString("DoTuoi")),
                    resultSet.getString("XuatXu"),
                    resultSet.getInt("SoLuong"),
                    new ThuongHieuDAO().timKiem(resultSet.getString("MaTH")).get(),
                    resultSet.getFloat("PhanTramLoi"),
                    MauSac.layGiaTri(resultSet.getString("MauSac")),
                    resultSet.getString("KichThuoc"),
                    resultSet.getString("HinhAnh"),
                    resultSet.getDate("NgaySanXuat").toLocalDate(),
                    TinhTrangSanPham.layGiaTri(resultSet.getString("TinhTrang")));

            sanPhams.add(sanPham);
        }
        return sanPhams;
    }
}
