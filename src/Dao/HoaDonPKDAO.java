/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Class_entity.HoaDonPK;
import TienIch.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class HoaDonPKDAO  extends EduSysDAO<HoaDonPK, String>{
    String INSERT_SQL = "INSERT INTO HoaDonPhongKham (NgayLapHoaDon,MaNV,MaTC,DonGia) VALUES ( ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE HoaDonPhongKham SET NgayLapHoaDon=?, MaNV=?, MaTC=?, DonGia=? WHERE MaHD=?";
    String DELETE_SQL = "DELETE FROM HoaDonPhongKham WHERE MaHD=?";
    String SELECT_ALL_SQL = "SELECT * FROM HoaDonPhongKham";
    String SELECT_BY_ID_SQL = "SELECT * FROM HoaDonPhongKham WHERE MaHD=?";
    
    
    @Override
    public void insert(HoaDonPK entity) {
        jdbcHelper.update(INSERT_SQL, entity.getNgayHD(), entity.getMaNV(),entity.getMaTC(),entity.getDonGia());
    }

    @Override
    public void update(HoaDonPK entity) {
        jdbcHelper.update(UPDATE_SQL, entity.getNgayHD(), entity.getMaNV(), entity.getMaTC(), entity.getDonGia(), entity.getMaHD());
    }

    @Override
    public void delete(String id) {
        jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<HoaDonPK> selectAll() {
        return (List<HoaDonPK>) selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public HoaDonPK selectById(String id) {
        List<HoaDonPK>list=(List<HoaDonPK>) this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
       

    @Override
    public List<HoaDonPK> selectBySql(String sql, Object... args) {
        List<HoaDonPK> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                HoaDonPK entity = new HoaDonPK();
                entity.setMaHD(rs.getString("MaHD"));
                entity.setNgayHD(rs.getDate("NgayLapHoaDon"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setMaTC(rs.getString("MaTC"));
                entity.setDonGia(rs.getDouble("DonGia"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        public List<HoaDonPK> selectByKeyword(String keyword){
        String sql = "SELECT * FROM NhanVien WHERE TenNV LIKE ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }

   public List<Integer> selectYears() {
        String sql="SELECT DISTINCT year(NgayLapHoaDon) Year FROM HoaDonPhongKham ORDER BY Year DESC";
        List<Integer> list=new ArrayList<>();
        try {
           ResultSet rs = jdbcHelper.query(sql);
           while(rs.next()){
                 list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } 
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
