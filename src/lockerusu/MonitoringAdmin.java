/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lockerusu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author Putera Nami Shiddieqy
 */
public class MonitoringAdmin extends javax.swing.JFrame {

    /**
     * Creates new form MonitoringAdmin
     */
    public MonitoringAdmin() {
        initComponents();
        configureTable();
        loadLockerData("semua");
        
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateAllLockersTime();
            }
        }, 0, 1000); // 1000 ms = 1 detik
    }
    
    private void configureTable() {
        // Tambahkan Button Renderer
        tabelPeminjamanLoker.getColumnModel().getColumn(4).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if ("Reset".equals(value)) {
                    javax.swing.JButton button = new javax.swing.JButton("Reset");
                    button.setBackground(java.awt.Color.RED);
                    button.setForeground(java.awt.Color.WHITE);
                    return button;
                }
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        });

        // Tambahkan Button Editor
        tabelPeminjamanLoker.getColumnModel().getColumn(4).setCellEditor(new javax.swing.DefaultCellEditor(new javax.swing.JTextField()) {
            @Override
            public java.awt.Component getTableCellEditorComponent(javax.swing.JTable table, Object value, boolean isSelected, int row, int column) {
                javax.swing.JButton button = new javax.swing.JButton("Reset");
                button.setBackground(java.awt.Color.RED);
                button.setForeground(java.awt.Color.WHITE);
                button.addActionListener(evt -> {
                    int idLoker = (int) tabelPeminjamanLoker.getValueAt(row, 0);
                    resetLocker(idLoker);
                });
                return button;
            }
        });
    }

    
    private void resetLocker(int idLoker) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE locker SET status = FALSE, nim = NULL, waktu_sisa = NULL WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idLoker);

            pstmt.executeUpdate();
            javax.swing.JOptionPane.showMessageDialog(this, "Loker " + idLoker + " berhasil direset!");

            // Refresh data di tabel
            loadLockerData("semua");
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    
    private void updateAllLockersTime() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Mengurangi waktu sisa semua loker yang sedang digunakan
            String sql = "UPDATE locker SET waktu_sisa = SUBTIME(waktu_sisa, '00:00:01') WHERE waktu_sisa > '00:00:00'";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();

            // Refresh data di tabel
            loadLockerData("semua");
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    
    private void loadLockerData(String filter) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT id, nim, status, waktu_sisa FROM locker";
            if (filter.equals("terpakai")) {
                sql += " WHERE status = TRUE";
            } else if (filter.equals("kosong")) {
                sql += " WHERE status = FALSE";
            }

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            // Hapus data lama di tabel
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tabelPeminjamanLoker.getModel();
            model.setRowCount(0);

            // Tambahkan data baru ke tabel
            while (rs.next()) {
                boolean status = rs.getBoolean("status");
                String waktuSisa = rs.getString("waktu_sisa");

                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nim"),
                    status ? "Terpakai" : "Kosong",
                    waktuSisa,
                    status ? "Reset" : "" // Tombol reset jika status terpakai
                });
            }
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    
    private void tabelPeminjamanLokerMouseClicked(java.awt.event.MouseEvent evt) {
        int row = tabelPeminjamanLoker.rowAtPoint(evt.getPoint());
        int col = tabelPeminjamanLoker.columnAtPoint(evt.getPoint());

        if (col == 4) { // Kolom "Aksi"
            String aksi = (String) tabelPeminjamanLoker.getValueAt(row, col);
            if ("Reset".equals(aksi)) {
                int idLoker = (int) tabelPeminjamanLoker.getValueAt(row, 0);

                // Konfirmasi reset
                int confirm = javax.swing.JOptionPane.showConfirmDialog(this, 
                    "Apakah Anda yakin ingin mereset loker " + idLoker + "?",
                    "Konfirmasi Reset", javax.swing.JOptionPane.YES_NO_OPTION);

                if (confirm == javax.swing.JOptionPane.YES_OPTION) {
                    resetLocker(idLoker);
                }
            }
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel = new java.awt.Panel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnSemuaLoker = new javax.swing.JButton();
        btnLokerTerpakai = new javax.swing.JButton();
        btnLokerKosong = new javax.swing.JButton();
        Pencarian = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPeminjamanLoker = new javax.swing.JTable();
        btnOrganizeLocker = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(114, 189, 81));

        JPanel.setBackground(new java.awt.Color(114, 189, 81));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(13, 102, 118));
        jLabel2.setText("Panel Admin Loker USU");

        btnSemuaLoker.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSemuaLoker.setText("Semua Loker");
        btnSemuaLoker.setBorder(null);
        btnSemuaLoker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSemuaLokerActionPerformed(evt);
            }
        });

        btnLokerTerpakai.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnLokerTerpakai.setText("Loker Terpakai");
        btnLokerTerpakai.setBorder(null);
        btnLokerTerpakai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLokerTerpakaiActionPerformed(evt);
            }
        });

        btnLokerKosong.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnLokerKosong.setText("Loker Kosong");
        btnLokerKosong.setBorder(null);
        btnLokerKosong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLokerKosongActionPerformed(evt);
            }
        });

        Pencarian.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Pencarian.setForeground(new java.awt.Color(153, 153, 153));
        Pencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PencarianActionPerformed(evt);
            }
        });

        tabelPeminjamanLoker.setForeground(new java.awt.Color(153, 153, 153));
        tabelPeminjamanLoker.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID Loker", "NIM", "Status", "Waktu Sisa", "Aksi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true // Hanya kolom Aksi yang dapat diklik
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelPeminjamanLoker);

        btnOrganizeLocker.setBackground(new java.awt.Color(13, 103, 119));
        btnOrganizeLocker.setForeground(new java.awt.Color(255, 255, 255));
        btnOrganizeLocker.setText("Atur Locker");
        btnOrganizeLocker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrganizeLockerActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(13, 103, 119));
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel1.setText("Cari Loker:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOrganizeLocker))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnSemuaLoker, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnLokerTerpakai, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnLokerKosong, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(100, 100, 100)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(Pencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSemuaLoker, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLokerTerpakai, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLokerKosong, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOrganizeLocker)
                    .addComponent(btnRefresh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.getAccessibleContext().setAccessibleName("");
        jLabel2.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout JPanelLayout = new javax.swing.GroupLayout(JPanel);
        JPanel.setLayout(JPanelLayout);
        JPanelLayout.setHorizontalGroup(
            JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPanelLayout.setVerticalGroup(
            JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        JPanel.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PencarianActionPerformed
        // TODO add your handling code here:
        String keyword = Pencarian.getText().trim();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT id, nim, status, waktu_sisa FROM locker WHERE id LIKE ? OR nim LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");

            ResultSet rs = pstmt.executeQuery();

            // Hapus data lama di tabel
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tabelPeminjamanLoker.getModel();
            model.setRowCount(0);

            // Tambahkan data hasil pencarian ke tabel
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nim"),
                    rs.getBoolean("status") ? "Terpakai" : "Kosong",
                    rs.getTime("waktu_sisa"),
                    "Reset"
                });
            }
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_PencarianActionPerformed

    private void btnLokerKosongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLokerKosongActionPerformed
        // TODO add your handling code here:
        loadLockerData("kosong");
    }//GEN-LAST:event_btnLokerKosongActionPerformed

    private void btnSemuaLokerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSemuaLokerActionPerformed
        // TODO add your handling code here:
        loadLockerData("semua");
    }//GEN-LAST:event_btnSemuaLokerActionPerformed

    private void btnLokerTerpakaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLokerTerpakaiActionPerformed
        // TODO add your handling code here:
        loadLockerData("terpakai");
    }//GEN-LAST:event_btnLokerTerpakaiActionPerformed

    private void btnOrganizeLockerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrganizeLockerActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new OrganizeLocker().setVisible(true);
    }//GEN-LAST:event_btnOrganizeLockerActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        updateAllLockersTime();
    }//GEN-LAST:event_btnRefreshActionPerformed

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
            java.util.logging.Logger.getLogger(MonitoringAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MonitoringAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MonitoringAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MonitoringAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MonitoringAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Panel JPanel;
    private javax.swing.JTextField Pencarian;
    private javax.swing.JButton btnLokerKosong;
    private javax.swing.JButton btnLokerTerpakai;
    private javax.swing.JButton btnOrganizeLocker;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSemuaLoker;
    private javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelPeminjamanLoker;
    // End of variables declaration//GEN-END:variables
}
