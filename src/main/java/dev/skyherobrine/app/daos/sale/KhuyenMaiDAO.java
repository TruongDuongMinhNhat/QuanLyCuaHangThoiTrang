package dev.skyherobrine.app.daos.sale;

import dev.skyherobrine.app.daos.ConnectDB;
import dev.skyherobrine.app.daos.IDAO;
import dev.skyherobrine.app.entities.product.ThuongHieu;
import dev.skyherobrine.app.entities.sale.KhuyenMai;
import dev.skyherobrine.app.enums.TinhTrangThuongHieu;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class KhuyenMaiDAO implements IDAO<KhuyenMai> {
    private ConnectDB connectDB;
    public KhuyenMaiDAO() throws Exception{
        connectDB = new ConnectDB();
    }
    @Override
    public boolean them(KhuyenMai khuyenMai) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("Insert KhuyenMai values(?, ?, ?)");
        preparedStatement.setString(1, khuyenMai.getMaKM());
        preparedStatement.setDate(2, Date.valueOf(khuyenMai.getNgayApDung()));
        preparedStatement.setDate(3, Date.valueOf(khuyenMai.getNgayHetHan()));

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean capNhat(KhuyenMai target) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("Update KhuyenMai set NgayApDung = ?, NgayHetHan = ? where MaKM = ?");
        preparedStatement.setDate(1, Date.valueOf(target.getNgayApDung()));
        preparedStatement.setDate(2, Date.valueOf(target.getNgayHetHan()));

        return preparedStatement.executeUpdate() > 0;
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
    public List<KhuyenMai> timKiem() throws Exception {
        ResultSet resultSet = connectDB.getConnection().createStatement().executeQuery
                ("select * from KhuyenMai");
        List<KhuyenMai> khuyenMais = new ArrayList<>();
        while(resultSet.next()) {
            KhuyenMai khuyenMai = new KhuyenMai(resultSet.getString( "MaKM"),
                    resultSet.getDate("NgayApDung").toLocalDate(), resultSet.getDate("NgayHetHan").toLocalDate());
            khuyenMais.add(khuyenMai);
        }
        return khuyenMais;
    }

    @Override
    public List<KhuyenMai> timKiem(Map<String, Object> conditions) throws Exception {
        return null;
    }

    @Override
    public Optional<KhuyenMai> timKiem(String id) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("select * from KhuyenMai where MaKM = ?");
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return Optional.of(new KhuyenMai(resultSet.getString("MaKM"),
                    resultSet.getDate("NgayApDung").toLocalDate(), resultSet.getDate("NgayHetHan").toLocalDate()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<KhuyenMai> timKiem(String... ids) throws Exception {
        String query = "select * from KhuyenMai where ";
        String[] listID = (String[]) Arrays.stream(ids).toArray();
        for(int i = 0; i < listID.length; ++i) {
            query += ("MaKM = '" + listID[i] + "'");
            if((i + 1) >= listID.length) break;
            else query += ", ";
        }

        List<KhuyenMai> khuyenMais = new ArrayList<>();
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            KhuyenMai khuyenMai = new KhuyenMai(resultSet.getString( "MaKM"),
                    resultSet.getDate("NgayApDung").toLocalDate(), resultSet.getDate("NgayHetHan").toLocalDate());
            khuyenMais.add(khuyenMai);
        }
        return khuyenMais;
    }
}
