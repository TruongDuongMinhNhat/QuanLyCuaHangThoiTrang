package dev.skyherobrine.app.daos.product;

import dev.skyherobrine.app.daos.ConnectDB;
import dev.skyherobrine.app.daos.IDAO;
import dev.skyherobrine.app.entities.product.LoaiSanPham;
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
                ("Insert SanPham values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, sanPham.getMaSP());
        preparedStatement.setString(2, sanPham.getTenSP());
        preparedStatement.setString(3, sanPham.getLoaiSanPham().getMaLoai());
        preparedStatement.setString(4, sanPham.getPhongCachMac().toString());
        preparedStatement.setString(5, sanPham.getDoTuoi().toString());
        preparedStatement.setString(6, sanPham.getXuatXu());
        preparedStatement.setString(7, sanPham.getThuongHieu().getMaTH());
        preparedStatement.setDouble(8, sanPham.getPhanTramLoi());
        preparedStatement.setString(9, sanPham.getMauSac().toString());
        preparedStatement.setDate(10, Date.valueOf(sanPham.getNgaySanXuat()));
        preparedStatement.setString(11, sanPham.getTinhTrang().toString());
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean capNhat(SanPham target) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("Update SanPham set TenSP = ?, MaLoai = ?, PhongCachMac = ?, DoTuoi = ?, XuatXu = ?, MaTH = ?, PhanTramLoi = ?, MauSac = ?, NgaySanXuat = ?, TinhTrang = ? where MaSP = ?");
        preparedStatement.setString(1, target.getTenSP());
        preparedStatement.setString(2, target.getLoaiSanPham().getMaLoai());
        preparedStatement.setString(3, target.getPhongCachMac().toString());
        preparedStatement.setString(4, target.getDoTuoi().toString());
        preparedStatement.setString(5, target.getXuatXu());
        preparedStatement.setString(6, target.getThuongHieu().getMaTH());
        preparedStatement.setDouble(7, target.getPhanTramLoi());
        preparedStatement.setString(8, target.getMauSac().toString());
        preparedStatement.setDate(9, Date.valueOf(target.getNgaySanXuat()));
        preparedStatement.setString(10, target.getTinhTrang().toString());
        preparedStatement.setString(11, target.getMaSP());

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean xoa(String id) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("Update SanPham set TinhTrang = ? where MaSP = ?");
        preparedStatement.setString(1, "KHONG_CON_BAN");
        preparedStatement.setString(2, id);

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public int xoa(String... ids) throws Exception {
        return 0;
    }

    @Override
    public List<SanPham> timKiem() throws Exception {
        ResultSet resultSet = connectDB.getConnection().createStatement().executeQuery("select TOP 10 * from SanPham");
        List<SanPham> sanPhams = new ArrayList<>();
        while(resultSet.next()) {
            SanPham sanPham = new SanPham(resultSet.getString("MaSP"),
                    resultSet.getString("TenSP"),
                    new LoaiSanPhamDAO().timKiem(resultSet.getString("MaLoai")).get(),
                    PhongCachMac.layGiaTri(resultSet.getString("PhongCachMac")),
                    DoTuoi.layGiaTri(resultSet.getString("DoTuoi")),
                    resultSet.getString("XuatXu"),
                    new ThuongHieuDAO().timKiem(resultSet.getString("MaTH")).get(),
                    resultSet.getFloat("PhanTramLoi"),
                    MauSac.layGiaTri(resultSet.getString("MauSac")),
                    resultSet.getDate("NgaySanXuat").toLocalDate(),
                    TinhTrangSanPham.layGiaTri(resultSet.getString("TinhTrang")));

            sanPhams.add(sanPham);
        }
        return sanPhams;
    }

    @Override
    public List<SanPham> timKiem(Map<String, Object> conditions) throws Exception {
        AtomicReference<String> query = new AtomicReference<>
                ("select * from SanPham sp where ");
        AtomicBoolean isNeedAnd = new AtomicBoolean(false);

        conditions.forEach((column, value) -> {
            query.set(query.get() + (isNeedAnd.get() ? " and " : "") + ("sp." + column + " = N'" + value + "'"));
            isNeedAnd.set(true);
        });

        List<SanPham> sanPhams = new ArrayList<>();
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(query.get());
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            SanPham sanPham = new SanPham(resultSet.getString("MaSP"),
                    resultSet.getString("TenSP"),
                    new LoaiSanPhamDAO().timKiem(resultSet.getString("MaLoai")).get(),
                    PhongCachMac.layGiaTri(resultSet.getString("PhongCachMac")),
                    DoTuoi.layGiaTri(resultSet.getString("DoTuoi")),
                    resultSet.getString("XuatXu"),
                    new ThuongHieuDAO().timKiem(resultSet.getString("MaTH")).get(),
                    resultSet.getFloat("PhanTramLoi"),
                    MauSac.layGiaTri(resultSet.getString("MauSac")),
                    resultSet.getDate("NgaySanXuat").toLocalDate(),
                    TinhTrangSanPham.layGiaTri(resultSet.getString("TinhTrang")));
            sanPhams.add(sanPham);
        }
        return sanPhams;
    }

    @Override
    public Optional<SanPham> timKiem(String id) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("select * from SanPham where MaSP = ?");
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            SanPham sanPham = new SanPham(resultSet.getString("MaSP"),
                    resultSet.getString("TenSP"),
                    new LoaiSanPhamDAO().timKiem(resultSet.getString("MaLoai")).get(),
                    PhongCachMac.layGiaTri(resultSet.getString("PhongCachMac")),
                    DoTuoi.layGiaTri(resultSet.getString("DoTuoi")),
                    resultSet.getString("XuatXu"),
                    new ThuongHieuDAO().timKiem(resultSet.getString("MaTH")).get(),
                    resultSet.getFloat("PhanTramLoi"),
                    MauSac.layGiaTri(resultSet.getString("MauSac")),
                    resultSet.getDate("NgaySanXuat").toLocalDate(),
                    TinhTrangSanPham.layGiaTri(resultSet.getString("TinhTrang")));

            return Optional.of(sanPham);
        }
        return Optional.empty();
    }

    @Override
    public List<SanPham> timKiem(String... ids) throws Exception {
        String query = "select * from SanPham where ";
        String[] listID = (String[]) Arrays.stream(ids).toArray();
        for(int i = 0; i < listID.length; ++i) {
            query += ("MaSP = '" + listID[i] + "'");
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
                    new ThuongHieuDAO().timKiem(resultSet.getString("MaTH")).get(),
                    resultSet.getFloat("PhanTramLoi"),
                    MauSac.layGiaTri(resultSet.getString("MauSac")),
                    resultSet.getDate("NgaySanXuat").toLocalDate(),
                    TinhTrangSanPham.layGiaTri(resultSet.getString("TinhTrang")));

            sanPhams.add(sanPham);
        }
        return sanPhams;
    }
}
