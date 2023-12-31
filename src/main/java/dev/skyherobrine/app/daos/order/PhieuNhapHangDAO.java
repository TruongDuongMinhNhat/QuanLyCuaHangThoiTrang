package dev.skyherobrine.app.daos.order;

import dev.skyherobrine.app.daos.ConnectDB;
import dev.skyherobrine.app.daos.IDAO;
import dev.skyherobrine.app.daos.person.NhaCungCapDAO;
import dev.skyherobrine.app.entities.order.PhieuNhapHang;
import dev.skyherobrine.app.entities.product.ThuongHieu;
import dev.skyherobrine.app.enums.TinhTrangNhapHang;
import dev.skyherobrine.app.enums.TinhTrangThuongHieu;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class PhieuNhapHangDAO implements IDAO<PhieuNhapHang> {
    private ConnectDB connectDB;
    public PhieuNhapHangDAO() throws Exception{
        connectDB = new ConnectDB();
    }
    @Override
    public boolean them(PhieuNhapHang phieuNhapHang) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("Insert PhieuNhapHang values(?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, phieuNhapHang.getMaPhieuNhap());
        preparedStatement.setString(2, phieuNhapHang.getNhaCungCap().getMaNCC());
        preparedStatement.setTimestamp(3, Timestamp.valueOf(phieuNhapHang.getNgayHenGiao()));
        preparedStatement.setTimestamp(4, Timestamp.valueOf(phieuNhapHang.getNgayLapPhieu()));
        preparedStatement.setString(5, phieuNhapHang.getGhiChu());
        preparedStatement.setString(6, phieuNhapHang.getTinhTrang().toString());

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean capNhat(PhieuNhapHang target) throws Exception {
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
    public List<PhieuNhapHang> timKiem() throws Exception {
        ResultSet resultSet = connectDB.getConnection().createStatement().executeQuery
                ("select * from PhieuNhapHang");
        List<PhieuNhapHang> phieuNhapHangs = new ArrayList<>();
        while(resultSet.next()) {
            PhieuNhapHang phieuNhapHang = new PhieuNhapHang(resultSet.getString("MaPhieuNhap"),
                    new NhaCungCapDAO().timKiem(resultSet.getString("MaNCC")).get(),
                    resultSet.getTimestamp("NgayLapPhieu").toLocalDateTime(),
                    resultSet.getTimestamp("NgayHenGiao").toLocalDateTime(),
                    resultSet.getString("GhiChu"),
                    TinhTrangNhapHang.layGiaTri(resultSet.getString("TinhTrang")));

            phieuNhapHangs.add(phieuNhapHang);
        }
        return phieuNhapHangs;
    }

    @Override
    public List<PhieuNhapHang> timKiem(Map<String, Object> conditions) throws Exception {
        return null;
    }

    @Override
    public Optional<PhieuNhapHang> timKiem(String id) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("select * from PhieuNhapHang where MaPhieuNhap = ?");
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return Optional.of(new PhieuNhapHang(resultSet.getString("MaPhieuNhap"),
                    new NhaCungCapDAO().timKiem(resultSet.getString("MaNCC")).get(),
                    resultSet.getTimestamp("NgayLapPhieu").toLocalDateTime(),
                    resultSet.getTimestamp("NgayHenGiao").toLocalDateTime(),
                    resultSet.getString("GhiChu"),
                    TinhTrangNhapHang.layGiaTri(resultSet.getString("TinhTrang"))));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<PhieuNhapHang> timKiem(String... ids) throws Exception {
        String query = "select * from PhieuNhapHang where ";
        String[] listID = (String[]) Arrays.stream(ids).toArray();
        for(int i = 0; i < listID.length; ++i) {
            query += ("MaPhieuNhap = '" + listID[i] + "'");
            if((i + 1) >= listID.length) break;
            else query += ", ";
        }

        List<PhieuNhapHang> phieuNhapHangs = new ArrayList<>();
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            PhieuNhapHang phieuNhapHang = new PhieuNhapHang(resultSet.getString("MaPhieuNhap"),
                    new NhaCungCapDAO().timKiem(resultSet.getString("MaNCC")).get(),
                    resultSet.getTimestamp("NgayLapPhieu").toLocalDateTime(),
                    resultSet.getTimestamp("NgayHenGiao").toLocalDateTime(),
                    resultSet.getString("GhiChu"),
                    TinhTrangNhapHang.layGiaTri(resultSet.getString("TinhTrang")));

            phieuNhapHangs.add(phieuNhapHang);
        }
        return phieuNhapHangs;
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

        query.set(query.get() + " from PhieuNhapHang where ");

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
