package dev.skyherobrine.app.daos.product;

import dev.skyherobrine.app.daos.ConnectDB;
import dev.skyherobrine.app.daos.IDAO;
import dev.skyherobrine.app.daos.sale.KhuyenMaiDAO;
import dev.skyherobrine.app.entities.product.ChiTietPhienBanSanPham;
import dev.skyherobrine.app.entities.sale.ChiTietKhuyenMai;
import dev.skyherobrine.app.enums.MauSac;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class ChiTietPhienBanSanPhamDAO implements IDAO<ChiTietPhienBanSanPham> {
    private ConnectDB connectDB;
    public ChiTietPhienBanSanPhamDAO() throws Exception {
        connectDB = new ConnectDB();
    }

    @Override
    public boolean them(ChiTietPhienBanSanPham chiTietPhienBanSanPham) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("Insert ChiTietPhienBanSanPham value(?, ?, ?, ?, ?)");
        preparedStatement.setString(1, chiTietPhienBanSanPham.getSanPham().getMaSP());
        preparedStatement.setString(2, chiTietPhienBanSanPham.getMauSac().toString());
        preparedStatement.setString(3, chiTietPhienBanSanPham.getKichThuoc());
        preparedStatement.setInt(4, chiTietPhienBanSanPham.getSoLuong());
        preparedStatement.setString(5, chiTietPhienBanSanPham.getHinhAnh());

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean capNhat(ChiTietPhienBanSanPham target) throws Exception {
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
    public List<ChiTietPhienBanSanPham> timKiem() throws Exception {
        ResultSet resultSet = connectDB.getConnection().createStatement().executeQuery("select * from ChiTietPhienBanSanPham");
        List<ChiTietPhienBanSanPham> chiTietPhienBanSanPhams = new ArrayList<>();
        while(resultSet.next()) {
            ChiTietPhienBanSanPham chiTietPhienBanSanPham = new ChiTietPhienBanSanPham(
                new SanPhamDAO().timKiem(resultSet.getString("MaSP")).get(),
                    MauSac.layGiaTri(resultSet.getString("MauSac")),
                    resultSet.getString("KichThuoc"),
                    resultSet.getInt("SoLuong"),
                    resultSet.getString("HinhAnh")
            );

            chiTietPhienBanSanPhams.add(chiTietPhienBanSanPham);
        }
        return chiTietPhienBanSanPhams;
    }

    @Override
    public List<ChiTietPhienBanSanPham> timKiem(Map<String, Object> conditions) throws Exception {
        AtomicReference<String> query = new AtomicReference<>
                ("select * from ChiTietPhienBanSanPham t where ");
        AtomicBoolean isNeedAnd = new AtomicBoolean(false);

        conditions.forEach((column, value) -> {
            query.set(query.get() + (isNeedAnd.get() ? " and " : "") + ("t." + column + " like '%" + value + "%'"));
            isNeedAnd.set(true);
        });

        List<ChiTietPhienBanSanPham> chiTietPhienBanSanPhams = new ArrayList<>();
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(query.get());
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            ChiTietPhienBanSanPham chiTietPhienBanSanPham = new ChiTietPhienBanSanPham(
                    new SanPhamDAO().timKiem(resultSet.getString("MaSP")).get(),
                    MauSac.layGiaTri(resultSet.getString("MauSac")),
                    resultSet.getString("KichThuoc"),
                    resultSet.getInt("SoLuong"),
                    resultSet.getString("HinhAnh")
            );

            chiTietPhienBanSanPhams.add(chiTietPhienBanSanPham);
        }
        return chiTietPhienBanSanPhams;
    }

    @Override
    public Optional<ChiTietPhienBanSanPham> timKiem(String id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<ChiTietPhienBanSanPham> timKiem(String... ids) throws Exception {
        return null;
    }

    public Optional<ChiTietPhienBanSanPham> timKiem(String maSP, MauSac mauSac, String kichThuoc) throws Exception{
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("select * from ChiTietPhienBanSanPham where MaSP = ? and MauSac = ? and KichThuoc = ?");
        preparedStatement.setString(1, maSP);
        preparedStatement.setString(2, mauSac.toString());
        preparedStatement.setString(3, kichThuoc);

        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return Optional.of(new ChiTietPhienBanSanPham(new SanPhamDAO().timKiem(resultSet.getString("MaSP")).get(),
                    MauSac.layGiaTri(resultSet.getString("MauSac")), resultSet.getString("KichThuoc"), resultSet.getInt("SoLuong"), resultSet.getString("HinhAnh")));
        } else {
            return Optional.empty();
        }
    }
}
