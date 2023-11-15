package dev.skyherobrine.app.daos.order;

import dev.skyherobrine.app.daos.ConnectDB;
import dev.skyherobrine.app.daos.IDAO;
import dev.skyherobrine.app.daos.person.KhachHangDAO;
import dev.skyherobrine.app.daos.person.NhanVienDAO;
import dev.skyherobrine.app.entities.order.HoaDon;
import dev.skyherobrine.app.entities.product.ThuongHieu;
import dev.skyherobrine.app.enums.TinhTrangThuongHieu;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.*;

public class HoaDonDAO implements IDAO<HoaDon> {
    private ConnectDB connectDB;
    public HoaDonDAO() throws Exception {
        connectDB = new ConnectDB();
    }
    @Override
    public boolean them(HoaDon hoaDon) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("?, ?, ?, ?, ?, ?");
        preparedStatement.setString(1, hoaDon.getMaHD());
        preparedStatement.setString(2, hoaDon.getNhanVienLap().getMaNV());
        preparedStatement.setString(3, hoaDon.getKhachHang().getMaKH());
        preparedStatement.setTimestamp(4, Timestamp.valueOf(hoaDon.getNgayLap()));
        preparedStatement.setBigDecimal(5, hoaDon.getSoTienKHTra());
        preparedStatement.setString(6, hoaDon.getGhiChu());

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean capNhat(HoaDon target) throws Exception {
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
    public List<HoaDon> timKiem() throws Exception {
        ResultSet resultSet = connectDB.getConnection().createStatement().executeQuery
                ("select * from HoaDon");
        List<HoaDon> hoaDons = new ArrayList<>();
        while (resultSet.next()) {
            HoaDon hoaDon = new HoaDon(
                    resultSet.getString("MaHD"),
                    resultSet.getTimestamp("NgayLap").toLocalDateTime(),
                    new NhanVienDAO().timKiem(resultSet.getString("MaNV")).get(),
                    new KhachHangDAO().timKiem(resultSet.getString("MaKH")).get(),
                    resultSet.getBigDecimal("SoTienKHTra"),
                    resultSet.getString("GhiChu")
            );
            hoaDons.add(hoaDon);
        }
        return hoaDons;
    }

    @Override
    public List<HoaDon> timKiem(Map<String, Object> conditions) throws Exception {
        return null;
    }

    @Override
    public Optional<HoaDon> timKiem(String id) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("select * from HoaDon where MaHD = ?");
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return Optional.of(new HoaDon(
                    resultSet.getString("MaHD"),
                    resultSet.getTimestamp("NgayLap").toLocalDateTime(),
                    new NhanVienDAO().timKiem(resultSet.getString("MaNV")).get(),
                    new KhachHangDAO().timKiem(resultSet.getString("MaKH")).get(),
                    resultSet.getBigDecimal("SoTienKHTra"),
                    resultSet.getString("GhiChu")
            ));
        }
        return Optional.empty();
    }

    @Override
    public List<HoaDon> timKiem(String... ids) throws Exception {
        String query = "select * from HoaDon where ";
        String[] listID = (String[]) Arrays.stream(ids).toArray();
        for(int i = 0; i < listID.length; ++i) {
            query += ("MaHD like '%" + listID[i] + "%'");
            if((i + 1) >= listID.length) break;
            else query += ", ";
        }

        List<HoaDon> hoaDons = new ArrayList<>();
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            HoaDon hoaDon = new HoaDon(
                    resultSet.getString("MaHD"),
                    resultSet.getTimestamp("NgayLap").toLocalDateTime(),
                    new NhanVienDAO().timKiem(resultSet.getString("MaNV")).get(),
                    new KhachHangDAO().timKiem(resultSet.getString("MaKH")).get(),
                    resultSet.getBigDecimal("SoTienKHTra"),
                    resultSet.getString("GhiChu")
            );
            hoaDons.add(hoaDon);
        }
        return hoaDons;
    }
}
