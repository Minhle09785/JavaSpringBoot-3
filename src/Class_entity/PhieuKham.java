/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_entity;

import java.util.Date;

/**
 *
 * @author User
 */
public class PhieuKham {
    private String maPK;
    private String yeuCauKham;
    private Date ngayKham = new Date();
    private String maNV;
    private String maBS;
    private String maTC;
    private String maPKToa;
    private int MaDV;

    public int getMaDV() {
        return MaDV;
    }

    public void setMaDV(int MaDV) {
        this.MaDV = MaDV;
    }
    
    
    

    public String getMaPK() {
        return maPK;
    }

    public void setMaPK(String maPK) {
        this.maPK = maPK;
    }

    public String getYeuCauKham() {
        return yeuCauKham;
    }

    public void setYeuCauKham(String yeuCauKham) {
        this.yeuCauKham = yeuCauKham;
    }

    public Date getNgayKham() {
        return ngayKham;
    }

    public void setNgayKham(Date ngayKham) {
        this.ngayKham = ngayKham;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaBS() {
        return maBS;
    }

    public void setMaBS(String maBS) {
        this.maBS = maBS;
    }

    public String getMaTC() {
        return maTC;
    }

    public void setMaTC(String maTC) {
        this.maTC = maTC;
    }

    public String getMaPKToa() {
        return maPKToa;
    }

    public void setMaPKToa(String maPKToa) {
        this.maPKToa = maPKToa;
    }
    
    
    
}
