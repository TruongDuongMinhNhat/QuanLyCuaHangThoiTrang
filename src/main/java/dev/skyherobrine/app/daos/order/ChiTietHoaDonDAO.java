package dev.skyherobrine.app.daos.order;

import dev.skyherobrine.app.daos.ConnectDB;
import dev.skyherobrine.app.daos.IDAO;
import dev.skyherobrine.app.daos.product.SanPhamDAO;
import dev.skyherobrine.app.entities.order.ChiTietHoaDon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ChiTietHoaDonDAO implements IDAO<ChiTietHoaDon> {
    private ConnectDB connectDB;
    public ChiTietHoaDonDAO() throws Exception {
        connectDB = new ConnectDB();
    }
    @Override
    public boolean them(ChiTietHoaDon chiTietHoaDon) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("Insert ChiTietHoaDon values(?, ?, ?)");
        preparedStatement.setString(1, chiTietHoaDon.getHoaDon().getMaHD());
        preparedStatement.setString(2, chiTietHoaDon.getSanPham().getMaSP());
        preparedStatement.setInt(3, chiTietHoaDon.getSoLuongMua());

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean capNhat(ChiTietHoaDon target) throws Exception {
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
    public List<ChiTietHoaDon> timKiem() throws Exception {
        ResultSet resultSet = connectDB.getConnection().createStatement().executeQuery
                ("select * from ChiTietHoaDon");
        List<ChiTietHoaDon> chiTietHoaDons = new ArrayList<>();
        while(resultSet.next()) {
            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon
                    (new HoaDonDAO().timKiem(resultSet.getString("MaHD")).get(),
                     new SanPhamDAO().timKiem(resultSet.getString("MaSP")).get(),
                     resultSet.getInt("SoLuongMua"));

            chiTietHoaDons.add(chiTietHoaDon);
        }
        return chiTietHoaDons;
    }

    @Override
    public List<ChiTietHoaDon> timKiem(Map<String, Object> conditions) throws Exception {
        return null;
    }

    @Override
    @Deprecated
    public Optional<ChiTietHoaDon> timKiem(String id) throws Exception {
        throw new Exception("Phương thức này không được sử dụng");
    }

    @Override
    public List<ChiTietHoaDon> timKiem(String... ids) throws Exception {
        return null;
    }

    public Optional<ChiTietHoaDon> timKiem(String maHD, String maSP) throws Exception{
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("select * from ChiTietHoaDon where MaSP = ? and MaHD = ?");
        preparedStatement.setString(1, maSP);
        preparedStatement.setString(2, maHD);

        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return Optional.of(new ChiTietHoaDon(new HoaDonDAO().timKiem(resultSet.getString("MaHD")).get(),
                    new SanPhamDAO().timKiem(resultSet.getString("MaSP")).get(),
                    resultSet.getInt("SoLuongMua")));
        } else {
            return Optional.empty();
        }
    }
}
