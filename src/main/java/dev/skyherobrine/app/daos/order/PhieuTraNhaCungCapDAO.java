package dev.skyherobrine.app.daos.order;

import dev.skyherobrine.app.daos.ConnectDB;
import dev.skyherobrine.app.daos.IDAO;
import dev.skyherobrine.app.entities.order.PhieuTraNhaCungCap;
import dev.skyherobrine.app.enums.TinhTrangTraHang;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class PhieuTraNhaCungCapDAO implements IDAO<PhieuTraNhaCungCap> {
    private ConnectDB connectDB;
    public PhieuTraNhaCungCapDAO() throws Exception{
        connectDB = new ConnectDB();
    }
    @Override
    public boolean them(PhieuTraNhaCungCap phieuTraNhaCungCap) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("Insert PhieuTraHangNhaCungCap values(?, ?, ?, ?, ?)");
        preparedStatement.setString(1, phieuTraNhaCungCap.getMaPhieuTra());
        preparedStatement.setString(2, phieuTraNhaCungCap.getPhieuNhap().getMaPhieuNhap());
        preparedStatement.setTimestamp(3, Timestamp.valueOf(phieuTraNhaCungCap.getNgayHenLay()));
        preparedStatement.setTimestamp(4, Timestamp.valueOf(phieuTraNhaCungCap.getNgayLap()));
        preparedStatement.setString(5, phieuTraNhaCungCap.getTinhTrang().toString());

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean capNhat(PhieuTraNhaCungCap target) throws Exception {
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
    public List<PhieuTraNhaCungCap> timKiem() throws Exception {
        ResultSet resultSet = connectDB.getConnection().createStatement().executeQuery
                ("select * from PhieuTraHangNhaCungCap");
        List<PhieuTraNhaCungCap> phieuTraNhaCungCaps = new ArrayList<>();
        while(resultSet.next()) {
            PhieuTraNhaCungCap phieuTraNhaCungCap = new PhieuTraNhaCungCap(resultSet.getString("MaPhieuTra"),
                            new PhieuNhapHangDAO().timKiem(resultSet.getString("MaPhieuNhap")).get(),
                            resultSet.getTimestamp("NgayHenLay").toLocalDateTime(),
                            resultSet.getTimestamp("NgayLap").toLocalDateTime(),
                            TinhTrangTraHang.layGiaTri(resultSet.getString("TinhTrang")));

            phieuTraNhaCungCaps.add(phieuTraNhaCungCap);
        }
        return phieuTraNhaCungCaps;
    }

    @Override
    public List<PhieuTraNhaCungCap> timKiem(Map<String, Object> conditions) throws Exception {
        return null;
    }

    @Override
    public Optional<PhieuTraNhaCungCap> timKiem(String id) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("select * from PhieuTraHangNhaCungCap where MaPhieuTra = ?");
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return Optional.of(new PhieuTraNhaCungCap(resultSet.getString("MaPhieuTra"),
                    new PhieuNhapHangDAO().timKiem(resultSet.getString("MaPhieuNhap")).get(),
                    resultSet.getTimestamp("NgayHenLay").toLocalDateTime(),
                    resultSet.getTimestamp("NgayLap").toLocalDateTime(),
                    TinhTrangTraHang.layGiaTri(resultSet.getString("TinhTrang"))));
        }
        return Optional.empty();
    }

    @Override
    public List<PhieuTraNhaCungCap> timKiem(String... ids) throws Exception {
        String query = "select * from PhieuTraNhaCungCap where ";
        String[] listID = (String[]) Arrays.stream(ids).toArray();
        for(int i = 0; i < listID.length; ++i) {
            query += ("MaPhieuTra like '%" + listID[i] + "%'");
            if((i + 1) >= listID.length) break;
            else query += ", ";
        }

        List<PhieuTraNhaCungCap> phieuTraNhaCungCaps = new ArrayList<>();
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            PhieuTraNhaCungCap phieuTraNhaCungCap = new PhieuTraNhaCungCap(resultSet.getString("MaPhieuTra"),
                    new PhieuNhapHangDAO().timKiem(resultSet.getString("MaPhieuNhap")).get(),
                    resultSet.getTimestamp("NgayHenLay").toLocalDateTime(),
                    resultSet.getTimestamp("NgayLap").toLocalDateTime(),
                    TinhTrangTraHang.layGiaTri(resultSet.getString("TinhTrang")));

            phieuTraNhaCungCaps.add(phieuTraNhaCungCap);
        }
        return phieuTraNhaCungCaps;
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

        query.set(query.get() + " from PhieuTraHangNhaCungCap where ");

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
