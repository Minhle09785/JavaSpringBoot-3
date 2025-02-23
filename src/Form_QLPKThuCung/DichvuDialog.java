/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form_QLPKThuCung;

import TienIch.ImageHelper;
import TienIch.MsgBox;

import Class_entity.DichVu;
import Dao.DichVuDao;
import java.awt.Color;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author minh
 */
public class DichvuDialog extends javax.swing.JDialog {

    /**
     * Creates new form DichvuDialog
     */
    public DichvuDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.init();

    }
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl = "jdbc:sqlserver://localhost:1433;database=QLPKTC_Nhom06";
    private static String username1 = "sa";
    private static String password = "songlong";

    Connection con1 = null;
    ResultSet rs1 = null;
    PreparedStatement pst = null;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbotendichvu = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtdongia = new javax.swing.JTextField();
        cbdongy = new javax.swing.JCheckBox();
        btnchapnhan = new javax.swing.JButton();
        btnketthuc = new javax.swing.JButton();
        lblMaNV = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(239, 200, 237));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(89, 89, 241));
        jLabel1.setText("DỊCH VỤ");

        cbotendichvu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn dịch vụ :" }));
        cbotendichvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotendichvuActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 102));
        jLabel2.setText("Tên dịch vụ:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 102));
        jLabel3.setText("Đơn giá:");

        txtdongia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtdongia.setForeground(new java.awt.Color(0, 51, 51));

        cbdongy.setBackground(new java.awt.Color(239, 200, 237));
        cbdongy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbdongy.setForeground(new java.awt.Color(0, 51, 255));
        cbdongy.setText("Bạn có đồng ý không?");
        cbdongy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbdongyMouseClicked(evt);
            }
        });

        btnchapnhan.setBackground(new java.awt.Color(255, 255, 255));
        btnchapnhan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnchapnhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon/tích xanh check.png"))); // NOI18N
        btnchapnhan.setText("Chấp nhận");
        btnchapnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchapnhanActionPerformed(evt);
            }
        });

        btnketthuc.setBackground(new java.awt.Color(255, 255, 255));
        btnketthuc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnketthuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon/Exit.png"))); // NOI18N
        btnketthuc.setText("Kết thúc");
        btnketthuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnketthucActionPerformed(evt);
            }
        });

        lblMaNV.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("VNĐ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(cbdongy)
                            .addComponent(cbotendichvu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtdongia)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnchapnhan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addComponent(btnketthuc)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addComponent(lblMaNV)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbotendichvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdongia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(33, 33, 33)
                .addComponent(cbdongy)
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnchapnhan)
                    .addComponent(btnketthuc))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnketthucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnketthucActionPerformed
        // TODO add your handling code here:
        this.Huy();
    }//GEN-LAST:event_btnketthucActionPerformed

    private void cbotendichvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotendichvuActionPerformed
        txtdongia.setText("");

        c();
    }//GEN-LAST:event_cbotendichvuActionPerformed

    private void btnchapnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchapnhanActionPerformed
        if (Check_Form()) {
            this.insert();
            LapPhieuKhamJdialog LPK = new LapPhieuKhamJdialog(null, rootPaneCheckingEnabled);
            LPK.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnchapnhanActionPerformed

    private void cbdongyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbdongyMouseClicked
        if (cbdongy.isSelected()) {
            btnchapnhan.setEnabled(true);
        } else {
            btnchapnhan.setEnabled(false);
        }
    }//GEN-LAST:event_cbdongyMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DichvuDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DichvuDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DichvuDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DichvuDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DichvuDialog dialog = new DichvuDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnchapnhan;
    private javax.swing.JButton btnketthuc;
    private javax.swing.JCheckBox cbdongy;
    private javax.swing.JComboBox<String> cbotendichvu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JTextField txtdongia;
    // End of variables declaration//GEN-END:variables

    private void Huy() {
        this.dispose();
    }

    void init() {
        this.setTitle("DỊCH VỤ");
        this.setLocationRelativeTo(null);
        this.setIconImage(ImageHelper.getAppIcon());
        this.cboDichVu();

        btnchapnhan.setEnabled(false);
        txtdongia.setEnabled(false);

    }

    void c() {
        //     DichVu n = new DichVu();
        // if(cbotendichvu.setSelectedItem(n)){
        String TT = txtdongia.getText();
        int index1 = cbotendichvu.getSelectedIndex();
        if (index1 == 0) {

            txtdongia.setText(txtdongia.getText() + "\n" + TT + "300000");

        }
        if (index1 == 1) {
            txtdongia.setText(txtdongia.getText() + "\n" + TT + "400000");
        }
        if (index1 == 2) {
            txtdongia.setText(txtdongia.getText() + "\n" + TT + "500000");
        }
        if (index1 == 3) {
            txtdongia.setText(txtdongia.getText() + "\n" + TT + "600000");
        }
        if (index1 == 4) {
            txtdongia.setText(txtdongia.getText() + "\n" + TT + "7000000");
        }
        if (index1 == 5) {
            txtdongia.setText(txtdongia.getText() + "\n" + TT + "8000000");
        }
        if (index1 == 6) {
            txtdongia.setText(txtdongia.getText() + "\n" + TT + "845000");
        }
        if (index1 == 6) {
            txtdongia.setText(txtdongia.getText() + "\n" + TT + "845000");
        }
        if (index1 == 7) {
            txtdongia.setText(txtdongia.getText() + "\n" + TT + "845000");
        }if (index1 == 8) {
            txtdongia.setText(txtdongia.getText() + "\n" + TT + "905000");
        }if (index1 == 9) {
            txtdongia.setText(txtdongia.getText() + "\n" + TT + "955000");
        }

        if (index1 == 10) {
            txtdongia.setText(txtdongia.getText() + "\n" + TT + "90000000");
        }
        
    }

    DichVu getForm() {
        // 
        DichVu tc = new DichVu();
        // tc.setMaDV(lblMaNV.getText());
        tc.setTenDV((String) cbotendichvu.getSelectedItem());
        tc.setDonGia(Double.valueOf(txtdongia.getText()));

        // tc.setMaTC(Auth.user.getMaNV());
        return tc;

    }

    DichVuDao dao = new DichVuDao();

    void insert() {
        DichVu tc = getForm();
        try {
            dao.insert(tc);

            MsgBox.alert(this, "Thêm mới thành công");
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm mới thất bại!");
        }
    }

    void cboDichVu() {
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con1 = DriverManager.getConnection(dburl, username1, password);
            Statement stm = con1.createStatement();
            rs1 = stm.executeQuery("select TenDV from Dichvu");
            while (rs1.next()) {
                String name = rs1.getString("TenDV");

                cbotendichvu.addItem(name);
            }
            con1.close();
        } catch (Exception e) {
        }
    }

    boolean Check_Form() {
        if (cbotendichvu.getSelectedIndex() == 0) {
            MsgBox.alert(this, "*Bạn phải chọn Dịch vụ! \n");
            cbotendichvu.setSelectedIndex(0);
            cbotendichvu.requestFocus();
            cbotendichvu.setBackground(Color.yellow);
            return false;
        } else {
            cbotendichvu.setBackground(Color.gray);
        }
        return true;
    }
}
// Khám sức khỏe định kỳ
//Tiểu phẫu, đại phẫu cho chó mèo
//Khách sạn chó mèo
//Tiêm phòng vacxin
//Chăm sóc răng miệng
//Cấp cứu 24/7
