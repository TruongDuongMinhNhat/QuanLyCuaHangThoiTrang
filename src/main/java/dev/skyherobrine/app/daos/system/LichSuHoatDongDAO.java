package dev.skyherobrine.app.daos.system;

import dev.skyherobrine.app.daos.ConnectDB;
import dev.skyherobrine.app.daos.IDAO;
import dev.skyherobrine.app.daos.person.NhanVienDAO;
import dev.skyherobrine.app.entities.person.NhanVien;
import dev.skyherobrine.app.entities.system.LichSuHoatDong;
import dev.skyherobrine.app.enums.CaLamViec;
import dev.skyherobrine.app.enums.ChucVu;
import dev.skyherobrine.app.enums.NhanVienHoatDong;
import dev.skyherobrine.app.enums.TinhTrangNhanVien;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class LichSuHoatDongDAO implements IDAO<LichSuHoatDong> {
    private ConnectDB connectDB;
    public LichSuHoatDongDAO() throws Exception{
        connectDB = new ConnectDB();
    }
    @Override
    public boolean them(LichSuHoatDong lichSuHoatDong) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("Insert LichSuHoatDong values(?, ?, ?, ?, ?)");
        preparedStatement.setLong(1, lichSuHoatDong.getId());
        preparedStatement.setString(2, lichSuHoatDong.getNhanVien().getMaNV());
        preparedStatement.setString(3, lichSuHoatDong.getHoatDong().toString());
        preparedStatement.setDate(4, Date.valueOf(lichSuHoatDong.getThoiDiemThucHien()));
        preparedStatement.setString(5, lichSuHoatDong.getGhiChu());

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean capNhat(LichSuHoatDong target) throws Exception {
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
    public List<LichSuHoatDong> timKiem() throws Exception {
        ResultSet resultSet = connectDB.getConnection().createStatement().executeQuery("select * from LichSuHoatDong");
        List<LichSuHoatDong> lichSuHoatDongs = new ArrayList<>();
        while(resultSet.next()) {
            LichSuHoatDong lichSuHoatDong = new LichSuHoatDong(resultSet.getLong("MaHoatDong"
                    ), new NhanVienDAO().timKiem(resultSet.getString("MaNV")).get(),
                    NhanVienHoatDong.layGiaTri(resultSet.getString("KieuHoatDong")),
                    resultSet.getDate("ThoiDiemThucHien").toLocalDate(),
                    resultSet.getString("GhiChu"));

            lichSuHoatDongs.add(lichSuHoatDong);
        }
        return lichSuHoatDongs;
    }

    @Override
    public List<LichSuHoatDong> timKiem(Map<String, Object> conditions) throws Exception {
        return null;
    }

    @Override
    public Optional<LichSuHoatDong> timKiem(String id) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("select * from LichSuHoatDong where MaHoatDong = ?");
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            LichSuHoatDong lichSuHoatDong = new LichSuHoatDong(resultSet.getLong("MaHoatDong"),
                    new NhanVienDAO().timKiem(resultSet.getString("MaNV")).get(),
                    NhanVienHoatDong.layGiaTri(resultSet.getString("KieuHoatDong")),
                    resultSet.getDate("ThoiDiemThucHien").toLocalDate(),
                    resultSet.getString("GhiChu"));
            return Optional.of(lichSuHoatDong);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<LichSuHoatDong> timkiem(String... ids) throws Exception {
        String query = "select * from LichSuHoatDong where ";
        String[] listID = (String[]) Arrays.stream(ids).toArray();
        for(int i = 0; i < listID.length; ++i) {
            query += ("MaHoatDong = '" + listID[i] + "'");
            if((i + 1) >= listID.length) break;
            else query += ", ";
        }

        List<LichSuHoatDong> lichSuHoatDongs = new ArrayList<>();
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            LichSuHoatDong lichSuHoatDong = new LichSuHoatDong(resultSet.getLong("MaHoatDong"),
                    new NhanVienDAO().timKiem(resultSet.getString("MaNV")).get(),
                    NhanVienHoatDong.layGiaTri(resultSet.getString("KieuHoatDong")),
                    resultSet.getDate("ThoiDiemThucHien").toLocalDate(),
                    resultSet.getString("GhiChu"));

            lichSuHoatDongs.add(lichSuHoatDong);
        }
        return lichSuHoatDongs;
    }
}