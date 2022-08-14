/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Class_entity.PhieuKham;
import TienIch.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class PhieuKhamDao extends EduSysDAO<PhieuKham, Object>{
  String INSERT_SQL = "INSERT INTO Phieukham (MaPK,Yeucaukham,NgayKham,MaNV,MaBS,MaTC,MaPKToa) VALUES (?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE Phieukham SET Yeucaukham=?, NgayKham=?, MaNV=?, MaBS=?, MaTC=?,MaPKToa=? WHERE MaPK=?";
    String DELETE_SQL = "DELETE FROM Phieukham WHERE MaPK=?";
    String SELECT_ALL_SQL = "SELECT * FROM Phieukham";
    String SELECT_BY_ID_SQL = "SELECT * FROM Phieukham WHERE MaPK=?";
    @Override
    public void insert(PhieuKham entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaPK(), entity.getYeuCauKham(), entity.getNgayKham(),entity.getMaNV(),
                entity.getMaBS(),entity.getMaTC(),entity.getMaPKToa());
    }

    @Override
    public void update(PhieuKham entity) {
         jdbcHelper.update(UPDATE_SQL, entity.getYeuCauKham(), entity.getNgayKham(),entity.getMaNV(),
                entity.getMaBS(),entity.getMaTC(),entity.getMaPKToa(),entity.getMaPK());
    }

    @Override
    public void delete(Object id) {
        jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public PhieuKham selectById(Object id) {
         List<PhieuKham>list=this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);    }

    @Override
    public List<PhieuKham> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<PhieuKham> selectBySql(String sql, Object... args) {
      List<PhieuKham> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                PhieuKham entity = new PhieuKham();
                entity.setMaPK(rs.getString("MaPK"));
                entity.setYeuCauKham(rs.getString("Yeucaukham"));
                entity.setNgayKham(rs.getDate("NgayKham"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setMaBS(rs.getString("MaBS"));
                entity.setMaTC(rs.getString("MaTC"));
                entity.setMaPKToa(rs.getString("MaPKToa"));
                

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }   }
    public List<Integer> selectYears() {
        String sql="SELECT DISTINCT year(NgayKham) Year FROM Phieukham ORDER BY Year DESC";
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
