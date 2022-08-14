
package Dao;

import Class_entity.DichVu;

import TienIch.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author User
 */
public class DichVuDao extends EduSysDAO<DichVu, Object>{
String INSERT_SQL = "INSERT INTO Dichvu (TenDV,DonGia) VALUES ( ?, ?)";
  //  String UPDATE_SQL = "UPDATE Thuoc SET Tenthuoc=?, Dongia=?, Soluong=?, Cachdung=?, Congdung=?, Maloai=? WHERE Mathuoc=?";
  //  String DELETE_SQL = "DELETE FROM Thuoc WHERE Mathuoc=?";
    String SELECT_ALL_SQL = "SELECT * FROM Dichvu";
    String SELECT_BY_ID_SQL = "SELECT * FROM Dichvu WHERE MaDV=?";
    @Override
    public void insert(DichVu entity) {
   jdbcHelper.update(INSERT_SQL,  entity.getTenDV(), entity.getDonGia());}

    @Override
    public void update(DichVu entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DichVu selectById(Object id) {
 List<DichVu>list=this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);    }

    @Override
    public List<DichVu> selectAll() {
  return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<DichVu> selectBySql(String sql, Object... args) {
    List<DichVu> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                DichVu entity = new DichVu();
               // entity.setMaDV(rs.getInt("MaDV"));
               entity.setTenDV(rs.getString("TenDV"));
               entity.setDonGia(rs.getDouble("DonGia"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }    }
     public List<DichVu> selectDonGia(double DonGia){
        String sql="SELECT DonGia FROM Dichvu";
        return selectBySql(sql, DonGia);
    }
}
