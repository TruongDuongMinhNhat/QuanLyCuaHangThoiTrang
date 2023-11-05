package dev.skyherobrine.app.daos.product;

import dev.skyherobrine.app.daos.ConnectDB;
import dev.skyherobrine.app.daos.IDAO;
import dev.skyherobrine.app.entities.product.DanhMucSanPham;
import dev.skyherobrine.app.entities.product.ThuongHieu;
import dev.skyherobrine.app.enums.TinhTrangThuongHieu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class DanhMucSanPhamDAO implements IDAO<DanhMucSanPham> {
    private ConnectDB connectDB;
    public DanhMucSanPhamDAO() throws Exception{
        connectDB = new ConnectDB();
    }
    @Override
    public boolean them(DanhMucSanPham danhMucSanPham) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("insert DanhMucSanPham values(?, ?)");
        preparedStatement.setString(1, danhMucSanPham.getMaDM());
        preparedStatement.setString(2, danhMucSanPham.getTenDM());
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean capNhat(DanhMucSanPham target) throws Exception {
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
    public List<DanhMucSanPham> timKiem() throws Exception {
        ResultSet resultSet = connectDB.getConnection().createStatement().executeQuery
                ("select * from DanhMucSanPham");
        List<DanhMucSanPham> danhMucSanPhams = new ArrayList<>();
        while (resultSet.next()) {
            DanhMucSanPham danhMucSanPham = new DanhMucSanPham(resultSet.getString("MaDM"), resultSet.getString("TenDM"));
            danhMucSanPhams.add(danhMucSanPham);
        }
        return danhMucSanPhams;
    }

    @Override
    public List<DanhMucSanPham> timKiem(Map<String, Object> conditions) throws Exception {
        return null;
    }

    @Override
    public Optional<DanhMucSanPham> timKiem(String id) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("select * from DanhMucSanPham where MaDM = ?");
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            DanhMucSanPham danhMucSanPham = new DanhMucSanPham(resultSet.getString("MaDM"), resultSet.getString("TenDM"));
            return Optional.of(danhMucSanPham);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<DanhMucSanPham> timkiem(String... ids) throws Exception {
        String query = "select * from DanhMucSanPham where ";
        String[] listID = (String[]) Arrays.stream(ids).toArray();
        for(int i = 0; i < listID.length; ++i) {
            query += ("MaDM = '" + listID[i] + "'");
            if((i + 1) >= listID.length) break;
            else query += ", ";
        }

        List<DanhMucSanPham> danhMucSanPhams = new ArrayList<>();
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            DanhMucSanPham danhMucSanPham = new DanhMucSanPham(resultSet.getString("MaDM"), resultSet.getString("TenDM"));
            danhMucSanPhams.add(danhMucSanPham);
        }
        return danhMucSanPhams;
    }
}