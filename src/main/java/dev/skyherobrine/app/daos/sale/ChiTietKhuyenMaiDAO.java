package dev.skyherobrine.app.daos.sale;

import dev.skyherobrine.app.daos.ConnectDB;
import dev.skyherobrine.app.daos.IDAO;
import dev.skyherobrine.app.daos.product.SanPhamDAO;
import dev.skyherobrine.app.entities.sale.ChiTietKhuyenMai;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ChiTietKhuyenMaiDAO implements IDAO<ChiTietKhuyenMai> {
    private ConnectDB connectDB;
    public ChiTietKhuyenMaiDAO() throws Exception{
        connectDB = new ConnectDB();
    }
    @Override
    public boolean them(ChiTietKhuyenMai chiTietKhuyenMai) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("Insert ChiTietKhuyenMai values(?, ?, ?)");
        preparedStatement.setString(1, chiTietKhuyenMai.getSanPham().getMaSP());
        preparedStatement.setString(2, chiTietKhuyenMai.getKhuyenMai().getMaKM());
        preparedStatement.setFloat(3, chiTietKhuyenMai.getTiLe());

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean capNhat(ChiTietKhuyenMai target) throws Exception {
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
    public List<ChiTietKhuyenMai> timKiem() throws Exception {
        ResultSet resultSet = connectDB.getConnection().createStatement().executeQuery("select * from ChiTietKhuyenMai");
        List<ChiTietKhuyenMai> chiTietKhuyenMais = new ArrayList<>();
        while (resultSet.next()) {
            ChiTietKhuyenMai chiTietKhuyenMai = new ChiTietKhuyenMai(
                    new SanPhamDAO().timKiem(resultSet.getString("MaSP")).get(),
                    new KhuyenMaiDAO().timKiem(resultSet.getString("MaKM")).get(),
                    resultSet.getFloat("TiLe"));

            chiTietKhuyenMais.add(chiTietKhuyenMai);
        }
        return chiTietKhuyenMais;
    }

    @Override
    public List<ChiTietKhuyenMai> timKiem(Map<String, Object> conditions) throws Exception {
        return null;
    }

    @Override
    public Optional<ChiTietKhuyenMai> timKiem(String id) throws Exception {
        return null;
    }

    @Override
    public List<ChiTietKhuyenMai> timKiem(String... ids) throws Exception {
        return null;
    }
}
