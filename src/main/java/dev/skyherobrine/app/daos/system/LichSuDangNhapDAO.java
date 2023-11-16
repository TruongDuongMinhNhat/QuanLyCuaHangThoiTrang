package dev.skyherobrine.app.daos.system;

import dev.skyherobrine.app.daos.ConnectDB;
import dev.skyherobrine.app.daos.IDAO;
import dev.skyherobrine.app.daos.person.NhanVienDAO;
import dev.skyherobrine.app.entities.system.LichSuDangNhap;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class LichSuDangNhapDAO implements IDAO<LichSuDangNhap> {
    private ConnectDB connectDB;
    public LichSuDangNhapDAO() throws Exception{
        connectDB = new ConnectDB();
    }
    @Override
    public boolean them(LichSuDangNhap lichSuDangNhap) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("Insert LichSuDangNhap values(?, ?, ?, ?)");
        preparedStatement.setLong(1, lichSuDangNhap.getId());
        preparedStatement.setString(2, lichSuDangNhap.getMaNV().getMaNV());
        preparedStatement.setTimestamp(3, Timestamp.valueOf(lichSuDangNhap.getNgayDangNhap()));
        preparedStatement.setTimestamp(4, Timestamp.valueOf(lichSuDangNhap.getNgayDangXuat()));
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean capNhat(LichSuDangNhap target) throws Exception {
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
    public List<LichSuDangNhap> timKiem() throws Exception {
        ResultSet result = connectDB.getConnection().prepareStatement
                ("select * from LichSuDangNhap").executeQuery();
        List<LichSuDangNhap> lichSuDangNhaps = new ArrayList<>();
        while(result.next()) {
            LichSuDangNhap lichSuDangNhap = new LichSuDangNhap
                    (result.getLong("MaDangNhap"), new NhanVienDAO().timKiem(result.getString("MaNV")).get(),
                            result.getDate("NgayDangNhap").toLocalDate().atStartOfDay(), result.getDate("NgayDangXuat").toLocalDate().atStartOfDay());

            lichSuDangNhaps.add(lichSuDangNhap);
        }
        return lichSuDangNhaps;
    }

    @Override
    public List<LichSuDangNhap> timKiem(Map<String, Object> conditions) throws Exception {
        return null;
    }

    @Override
    public Optional<LichSuDangNhap> timKiem(String id) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("select * from LichSuDangNhap where MaDangNhap = ?");
        preparedStatement.setLong(1, Long.parseLong(id));
        ResultSet result = preparedStatement.executeQuery();
        if(result.next()) {
            return Optional.of(new LichSuDangNhap(result.getLong("MaDangNhap"), new NhanVienDAO().timKiem(result.getString("MaNV")).get(),
                    result.getTimestamp("NgayDangNhap").toLocalDateTime(), result.getTimestamp("NgayDangXuat").toLocalDateTime()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<LichSuDangNhap> timKiem(String... ids) throws Exception {
        String query = "select * from LichSuDangNhap where ";
        String[] listID = (String[]) Arrays.stream(ids).toArray();
        for(int i = 0; i < listID.length; ++i) {
            query += ("MaHoatDong like '%" + listID[i] + "%'");
            if((i + 1) >= listID.length) break;
            else query += ", ";
        }

        List<LichSuDangNhap> lichSuDangNhaps = new ArrayList<>();
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(query);
        ResultSet result = preparedStatement.executeQuery();
        while(result.next()) {
            LichSuDangNhap lichSuHoatDong = new LichSuDangNhap(result.getLong("MaDangNhap"), new NhanVienDAO().timKiem(result.getString("MaNV")).get(),
                    result.getTimestamp("NgayDangNhap").toLocalDateTime(), result.getTimestamp("NgayDangXuat").toLocalDateTime());

            lichSuDangNhaps.add(lichSuHoatDong);
        }
        return lichSuDangNhaps;
    }

    @Override
    public List<Map<String, Object>> timKiem(Map<String, Object> conditions, boolean isDuplicateResult, String... colNames) throws Exception {
        AtomicReference<String> query = new AtomicReference<>("select " + (isDuplicateResult ? "distinct " : ""));
        AtomicBoolean canPhay = new AtomicBoolean(false);
        AtomicBoolean canAnd = new AtomicBoolean(false);

        Arrays.stream(colNames).forEach(column -> {
            query.set(query.get() + (canPhay.get() ? "," : "") + column);
            canPhay.set(true);
        });

        query.set(query.get() + " from LichSuDangNhap where ");

        conditions.forEach((column, value) -> {
            query.set(query.get() + (canAnd.get() ? " AND " : "") + column + " like '%" + value + "%'");
            canAnd.set(true);
        });

        System.out.println(query);
        ResultSet resultSet = connectDB.getConnection().createStatement().executeQuery(query.get());

        List<Map<String, Object>> listResult = new ArrayList<>();
        while(resultSet.next()){
            Map<String, Object> rowDatas = new HashMap<>();
            for(String column : Arrays.stream(colNames).toList()) {
                rowDatas.put(column, resultSet.getString(column));
            }
            listResult.add(rowDatas);
        }
        return listResult;
    }
}
