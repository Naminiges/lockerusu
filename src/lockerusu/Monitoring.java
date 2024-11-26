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
public class Monitoring extends javax.swing.JFrame {

    /**
     * Creates new form Monitoring
     */
    public Monitoring() {
        initComponents();
        refreshLockerStatus();
        
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateAllLockersTime();
            }
        }, 0, 1000); // Interval 1 detik
    }
    
    private void updateAllLockersTime() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Kurangi waktu sisa semua loker yang aktif
            String sql = "UPDATE locker SET waktu_sisa = SUBTIME(waktu_sisa, '00:00:01') WHERE waktu_sisa > '00:00:00'";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();

            // Refresh tampilan tombol loker
            refreshLockerStatus();
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    
    private void refreshLockerStatus() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT id, status, waktu_sisa FROM locker";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                boolean status = rs.getBoolean("status");
                String waktuSisa = rs.getString("waktu_sisa");

                javax.swing.JButton button = getLockerButton(id);

                if (button != null) {
                    if (status) {
                        button.setBackground(java.awt.Color.RED); // Loker terpakai
                        if (waktuSisa.equals("00:00:00")) {
                            button.setBackground(java.awt.Color.ORANGE); // Waktu habis
                        }
                    } else {
                        button.setBackground(java.awt.Color.GREEN); // Loker kosong
                    }
                }
            }
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    
    private void showLockerInfo(int id) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Ambil waktu sisa dari database
            String sql = "SELECT waktu_sisa FROM locker WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String waktuSisa = rs.getString("waktu_sisa");

                if (waktuSisa == null || waktuSisa.equals("00:00:00")) {
                    javax.swing.JOptionPane.showMessageDialog(this, 
                        "Loker " + id + " tidak memiliki waktu aktif atau sudah selesai.");
                    return;
                }

                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Loker " + id + " waktu sisa: " + waktuSisa);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Loker tidak ditemukan dalam database.");
            }
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
}

// Method untuk mendapatkan JButton berdasarkan ID loker
private javax.swing.JButton getLockerButton(int id) {
    switch (id) {
        case 1: return IDLoker1;
        case 2: return IDLoker2;
        case 3: return IDLoker3;
        case 4: return IDLoker4;
        case 5: return IDLoker5;
        case 6: return IDLoker6;
        case 7: return IDLoker7;
        case 8: return IDLoker8;
        case 9: return IDLoker9;
        case 10: return IDLoker10;
        case 11: return IDLoker11;
        case 12: return IDLoker12;
        case 13: return IDLoker13;
        case 14: return IDLoker14;
        case 15: return IDLoker15;
        case 16: return IDLoker16;
        case 17: return IDLoker17;
        case 18: return IDLoker18;
        case 19: return IDLoker19;
        case 20: return IDLoker20;
        case 21: return IDLoker21;
        case 22: return IDLoker22;
        case 23: return IDLoker23;
        case 24: return IDLoker24;
        case 25: return IDLoker25;
        case 26: return IDLoker26;
        case 27: return IDLoker27;
        case 28: return IDLoker28;
        case 29: return IDLoker29;
        case 30: return IDLoker30;
        case 31: return IDLoker31;
        case 32: return IDLoker32;
        case 33: return IDLoker33;
        case 34: return IDLoker34;
        case 35: return IDLoker35;
        case 36: return IDLoker36;
        case 37: return IDLoker37;
        case 38: return IDLoker38;
        case 39: return IDLoker39;
        case 40: return IDLoker40;
        case 41: return IDLoker41;
        case 42: return IDLoker42;
        case 43: return IDLoker43;
        case 44: return IDLoker44;
        case 45: return IDLoker45;
        case 46: return IDLoker46;
        case 47: return IDLoker47;
        case 48: return IDLoker48;
        case 49: return IDLoker49;
        default: return null;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        IDLoker1 = new javax.swing.JButton();
        IDLoker2 = new javax.swing.JButton();
        IDLoker3 = new javax.swing.JButton();
        IDLoker4 = new javax.swing.JButton();
        IDLoker5 = new javax.swing.JButton();
        IDLoker6 = new javax.swing.JButton();
        IDLoker7 = new javax.swing.JButton();
        IDLoker8 = new javax.swing.JButton();
        IDLoker9 = new javax.swing.JButton();
        IDLoker10 = new javax.swing.JButton();
        IDLoker11 = new javax.swing.JButton();
        IDLoker12 = new javax.swing.JButton();
        IDLoker13 = new javax.swing.JButton();
        IDLoker14 = new javax.swing.JButton();
        IDLoker19 = new javax.swing.JButton();
        IDLoker17 = new javax.swing.JButton();
        IDLoker20 = new javax.swing.JButton();
        IDLoker15 = new javax.swing.JButton();
        IDLoker21 = new javax.swing.JButton();
        IDLoker16 = new javax.swing.JButton();
        IDLoker18 = new javax.swing.JButton();
        IDLoker26 = new javax.swing.JButton();
        IDLoker24 = new javax.swing.JButton();
        IDLoker27 = new javax.swing.JButton();
        IDLoker22 = new javax.swing.JButton();
        IDLoker28 = new javax.swing.JButton();
        IDLoker23 = new javax.swing.JButton();
        IDLoker25 = new javax.swing.JButton();
        IDLoker33 = new javax.swing.JButton();
        IDLoker31 = new javax.swing.JButton();
        IDLoker34 = new javax.swing.JButton();
        IDLoker29 = new javax.swing.JButton();
        IDLoker35 = new javax.swing.JButton();
        IDLoker30 = new javax.swing.JButton();
        IDLoker32 = new javax.swing.JButton();
        IDLoker40 = new javax.swing.JButton();
        IDLoker38 = new javax.swing.JButton();
        IDLoker41 = new javax.swing.JButton();
        IDLoker36 = new javax.swing.JButton();
        IDLoker42 = new javax.swing.JButton();
        IDLoker37 = new javax.swing.JButton();
        IDLoker39 = new javax.swing.JButton();
        IDLoker47 = new javax.swing.JButton();
        IDLoker45 = new javax.swing.JButton();
        IDLoker48 = new javax.swing.JButton();
        IDLoker43 = new javax.swing.JButton();
        IDLoker49 = new javax.swing.JButton();
        IDLoker44 = new javax.swing.JButton();
        IDLoker46 = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(113, 189, 81));

        jPanel3.setBackground(new java.awt.Color(113, 189, 81));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(13, 103, 119));
        jLabel3.setText("Locker USU");

        IDLoker1.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker1.setText("1");
        IDLoker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker1ActionPerformed(evt);
            }
        });

        IDLoker2.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker2.setText("2");
        IDLoker2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker2ActionPerformed(evt);
            }
        });

        IDLoker3.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker3.setText("3");
        IDLoker3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker3ActionPerformed(evt);
            }
        });

        IDLoker4.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker4.setText("4");
        IDLoker4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker4ActionPerformed(evt);
            }
        });

        IDLoker5.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker5.setText("5");
        IDLoker5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker5ActionPerformed(evt);
            }
        });

        IDLoker6.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker6.setText("6");
        IDLoker6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker6ActionPerformed(evt);
            }
        });

        IDLoker7.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker7.setText("7");
        IDLoker7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker7ActionPerformed(evt);
            }
        });

        IDLoker8.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker8.setText("8");
        IDLoker8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker8ActionPerformed(evt);
            }
        });

        IDLoker9.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker9.setText("9");
        IDLoker9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker9ActionPerformed(evt);
            }
        });

        IDLoker10.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker10.setText("10");
        IDLoker10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker10ActionPerformed(evt);
            }
        });

        IDLoker11.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker11.setText("11");
        IDLoker11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker11ActionPerformed(evt);
            }
        });

        IDLoker12.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker12.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker12.setText("12");
        IDLoker12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker12ActionPerformed(evt);
            }
        });

        IDLoker13.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker13.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker13.setText("13");
        IDLoker13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker13ActionPerformed(evt);
            }
        });

        IDLoker14.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker14.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker14.setText("14");
        IDLoker14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker14ActionPerformed(evt);
            }
        });

        IDLoker19.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker19.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker19.setText("19");
        IDLoker19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker19ActionPerformed(evt);
            }
        });

        IDLoker17.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker17.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker17.setText("17");
        IDLoker17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker17ActionPerformed(evt);
            }
        });

        IDLoker20.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker20.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker20.setText("20");
        IDLoker20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker20ActionPerformed(evt);
            }
        });

        IDLoker15.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker15.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker15.setText("15");
        IDLoker15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker15ActionPerformed(evt);
            }
        });

        IDLoker21.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker21.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker21.setText("21");
        IDLoker21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker21ActionPerformed(evt);
            }
        });

        IDLoker16.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker16.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker16.setText("16");
        IDLoker16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker16ActionPerformed(evt);
            }
        });

        IDLoker18.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker18.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker18.setText("18");
        IDLoker18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker18ActionPerformed(evt);
            }
        });

        IDLoker26.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker26.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker26.setText("26");
        IDLoker26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker26ActionPerformed(evt);
            }
        });

        IDLoker24.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker24.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker24.setText("24");
        IDLoker24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker24ActionPerformed(evt);
            }
        });

        IDLoker27.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker27.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker27.setText("27");
        IDLoker27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker27ActionPerformed(evt);
            }
        });

        IDLoker22.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker22.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker22.setText("22");
        IDLoker22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker22ActionPerformed(evt);
            }
        });

        IDLoker28.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker28.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker28.setText("28");
        IDLoker28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker28ActionPerformed(evt);
            }
        });

        IDLoker23.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker23.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker23.setText("23");
        IDLoker23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker23ActionPerformed(evt);
            }
        });

        IDLoker25.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker25.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker25.setText("25");
        IDLoker25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker25ActionPerformed(evt);
            }
        });

        IDLoker33.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker33.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker33.setText("33");
        IDLoker33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker33ActionPerformed(evt);
            }
        });

        IDLoker31.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker31.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker31.setText("31");
        IDLoker31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker31ActionPerformed(evt);
            }
        });

        IDLoker34.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker34.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker34.setText("34");
        IDLoker34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker34ActionPerformed(evt);
            }
        });

        IDLoker29.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker29.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker29.setText("29");
        IDLoker29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker29ActionPerformed(evt);
            }
        });

        IDLoker35.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker35.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker35.setText("35");
        IDLoker35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker35ActionPerformed(evt);
            }
        });

        IDLoker30.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker30.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker30.setText("30");
        IDLoker30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker30ActionPerformed(evt);
            }
        });

        IDLoker32.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker32.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker32.setText("32");
        IDLoker32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker32ActionPerformed(evt);
            }
        });

        IDLoker40.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker40.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker40.setText("40");
        IDLoker40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker40ActionPerformed(evt);
            }
        });

        IDLoker38.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker38.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker38.setText("38");
        IDLoker38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker38ActionPerformed(evt);
            }
        });

        IDLoker41.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker41.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker41.setText("41");
        IDLoker41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker41ActionPerformed(evt);
            }
        });

        IDLoker36.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker36.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker36.setText("36");
        IDLoker36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker36ActionPerformed(evt);
            }
        });

        IDLoker42.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker42.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker42.setText("42");
        IDLoker42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker42ActionPerformed(evt);
            }
        });

        IDLoker37.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker37.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker37.setText("37");
        IDLoker37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker37ActionPerformed(evt);
            }
        });

        IDLoker39.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker39.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker39.setText("39");
        IDLoker39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker39ActionPerformed(evt);
            }
        });

        IDLoker47.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker47.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker47.setText("47");
        IDLoker47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker47ActionPerformed(evt);
            }
        });

        IDLoker45.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker45.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker45.setText("45");
        IDLoker45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker45ActionPerformed(evt);
            }
        });

        IDLoker48.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker48.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker48.setText("48");
        IDLoker48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker48ActionPerformed(evt);
            }
        });

        IDLoker43.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker43.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker43.setText("43");
        IDLoker43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker43ActionPerformed(evt);
            }
        });

        IDLoker49.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker49.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker49.setText("49");
        IDLoker49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker49ActionPerformed(evt);
            }
        });

        IDLoker44.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker44.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker44.setText("44");
        IDLoker44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker44ActionPerformed(evt);
            }
        });

        IDLoker46.setBackground(new java.awt.Color(113, 189, 81));
        IDLoker46.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        IDLoker46.setText("46");
        IDLoker46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoker46ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(75, 75, 75)
                        .addComponent(btnRefresh))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(IDLoker1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(IDLoker8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker11, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker12, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker13, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker14, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(IDLoker15, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker16, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker17, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker18, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker19, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker20, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker21, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(IDLoker22, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker23, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker24, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker25, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker26, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker27, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker28, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(IDLoker29, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker30, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker31, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker32, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker33, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker34, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker35, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(IDLoker36, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker37, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker38, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker39, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker40, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker41, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker42, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(IDLoker43, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker44, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker45, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker46, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker47, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker48, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLoker49, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDLoker1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDLoker8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDLoker15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker20, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker21, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDLoker22, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker23, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker24, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker25, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker26, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker27, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker28, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDLoker29, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker30, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker31, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker32, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker33, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker34, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker35, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDLoker36, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker37, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker38, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker39, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker40, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker41, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker42, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDLoker43, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker44, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker45, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker46, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker47, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker48, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLoker49, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IDLoker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker1ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(1);
    }//GEN-LAST:event_IDLoker1ActionPerformed

    private void IDLoker2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker2ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(2);
    }//GEN-LAST:event_IDLoker2ActionPerformed

    private void IDLoker3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker3ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(3);
    }//GEN-LAST:event_IDLoker3ActionPerformed

    private void IDLoker4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker4ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(4);
    }//GEN-LAST:event_IDLoker4ActionPerformed

    private void IDLoker5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker5ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(5);
    }//GEN-LAST:event_IDLoker5ActionPerformed

    private void IDLoker6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker6ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(6);
    }//GEN-LAST:event_IDLoker6ActionPerformed

    private void IDLoker7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker7ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(7);
    }//GEN-LAST:event_IDLoker7ActionPerformed

    private void IDLoker8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker8ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(8);
    }//GEN-LAST:event_IDLoker8ActionPerformed

    private void IDLoker9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker9ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(9);
    }//GEN-LAST:event_IDLoker9ActionPerformed

    private void IDLoker10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker10ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(10);
    }//GEN-LAST:event_IDLoker10ActionPerformed

    private void IDLoker11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker11ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(11);
    }//GEN-LAST:event_IDLoker11ActionPerformed

    private void IDLoker12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker12ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(12);
    }//GEN-LAST:event_IDLoker12ActionPerformed

    private void IDLoker13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker13ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(13);
    }//GEN-LAST:event_IDLoker13ActionPerformed

    private void IDLoker14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker14ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(14);
    }//GEN-LAST:event_IDLoker14ActionPerformed

    private void IDLoker19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker19ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(19);
    }//GEN-LAST:event_IDLoker19ActionPerformed

    private void IDLoker17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker17ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(17);
    }//GEN-LAST:event_IDLoker17ActionPerformed

    private void IDLoker20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker20ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(20);
    }//GEN-LAST:event_IDLoker20ActionPerformed

    private void IDLoker15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker15ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(15);
    }//GEN-LAST:event_IDLoker15ActionPerformed

    private void IDLoker21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker21ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(21);
    }//GEN-LAST:event_IDLoker21ActionPerformed

    private void IDLoker16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker16ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(16);
    }//GEN-LAST:event_IDLoker16ActionPerformed

    private void IDLoker18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker18ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(18);
    }//GEN-LAST:event_IDLoker18ActionPerformed

    private void IDLoker26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker26ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(26);
    }//GEN-LAST:event_IDLoker26ActionPerformed

    private void IDLoker24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker24ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(24);
    }//GEN-LAST:event_IDLoker24ActionPerformed

    private void IDLoker27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker27ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(27);
    }//GEN-LAST:event_IDLoker27ActionPerformed

    private void IDLoker22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker22ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(22);
    }//GEN-LAST:event_IDLoker22ActionPerformed

    private void IDLoker28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker28ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(28);
    }//GEN-LAST:event_IDLoker28ActionPerformed

    private void IDLoker23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker23ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(23);
    }//GEN-LAST:event_IDLoker23ActionPerformed

    private void IDLoker25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker25ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(25);
    }//GEN-LAST:event_IDLoker25ActionPerformed

    private void IDLoker33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker33ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(33);
    }//GEN-LAST:event_IDLoker33ActionPerformed

    private void IDLoker31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker31ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(31);
    }//GEN-LAST:event_IDLoker31ActionPerformed

    private void IDLoker34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker34ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(34);
    }//GEN-LAST:event_IDLoker34ActionPerformed

    private void IDLoker29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker29ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(29);
    }//GEN-LAST:event_IDLoker29ActionPerformed

    private void IDLoker35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker35ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(35);
    }//GEN-LAST:event_IDLoker35ActionPerformed

    private void IDLoker30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker30ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(30);
    }//GEN-LAST:event_IDLoker30ActionPerformed

    private void IDLoker32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker32ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(32);
    }//GEN-LAST:event_IDLoker32ActionPerformed

    private void IDLoker40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker40ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(40);
    }//GEN-LAST:event_IDLoker40ActionPerformed

    private void IDLoker38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker38ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(38);
    }//GEN-LAST:event_IDLoker38ActionPerformed

    private void IDLoker41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker41ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(41);
    }//GEN-LAST:event_IDLoker41ActionPerformed

    private void IDLoker36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker36ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(36);
    }//GEN-LAST:event_IDLoker36ActionPerformed

    private void IDLoker42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker42ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(42);
    }//GEN-LAST:event_IDLoker42ActionPerformed

    private void IDLoker37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker37ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(37);
    }//GEN-LAST:event_IDLoker37ActionPerformed

    private void IDLoker39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker39ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(39);
    }//GEN-LAST:event_IDLoker39ActionPerformed

    private void IDLoker47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker47ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(47);
    }//GEN-LAST:event_IDLoker47ActionPerformed

    private void IDLoker45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker45ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(45);
    }//GEN-LAST:event_IDLoker45ActionPerformed

    private void IDLoker48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker48ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(48);
    }//GEN-LAST:event_IDLoker48ActionPerformed

    private void IDLoker43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker43ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(43);
    }//GEN-LAST:event_IDLoker43ActionPerformed

    private void IDLoker49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker49ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(49);
    }//GEN-LAST:event_IDLoker49ActionPerformed

    private void IDLoker44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker44ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(44);
    }//GEN-LAST:event_IDLoker44ActionPerformed

    private void IDLoker46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoker46ActionPerformed
        // TODO add your handling code here:
        showLockerInfo(46);
    }//GEN-LAST:event_IDLoker46ActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        refreshLockerStatus();
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
            java.util.logging.Logger.getLogger(Monitoring.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Monitoring.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Monitoring.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Monitoring.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Monitoring().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton IDLoker1;
    private javax.swing.JButton IDLoker10;
    private javax.swing.JButton IDLoker11;
    private javax.swing.JButton IDLoker12;
    private javax.swing.JButton IDLoker13;
    private javax.swing.JButton IDLoker14;
    private javax.swing.JButton IDLoker15;
    private javax.swing.JButton IDLoker16;
    private javax.swing.JButton IDLoker17;
    private javax.swing.JButton IDLoker18;
    private javax.swing.JButton IDLoker19;
    private javax.swing.JButton IDLoker2;
    private javax.swing.JButton IDLoker20;
    private javax.swing.JButton IDLoker21;
    private javax.swing.JButton IDLoker22;
    private javax.swing.JButton IDLoker23;
    private javax.swing.JButton IDLoker24;
    private javax.swing.JButton IDLoker25;
    private javax.swing.JButton IDLoker26;
    private javax.swing.JButton IDLoker27;
    private javax.swing.JButton IDLoker28;
    private javax.swing.JButton IDLoker29;
    private javax.swing.JButton IDLoker3;
    private javax.swing.JButton IDLoker30;
    private javax.swing.JButton IDLoker31;
    private javax.swing.JButton IDLoker32;
    private javax.swing.JButton IDLoker33;
    private javax.swing.JButton IDLoker34;
    private javax.swing.JButton IDLoker35;
    private javax.swing.JButton IDLoker36;
    private javax.swing.JButton IDLoker37;
    private javax.swing.JButton IDLoker38;
    private javax.swing.JButton IDLoker39;
    private javax.swing.JButton IDLoker4;
    private javax.swing.JButton IDLoker40;
    private javax.swing.JButton IDLoker41;
    private javax.swing.JButton IDLoker42;
    private javax.swing.JButton IDLoker43;
    private javax.swing.JButton IDLoker44;
    private javax.swing.JButton IDLoker45;
    private javax.swing.JButton IDLoker46;
    private javax.swing.JButton IDLoker47;
    private javax.swing.JButton IDLoker48;
    private javax.swing.JButton IDLoker49;
    private javax.swing.JButton IDLoker5;
    private javax.swing.JButton IDLoker6;
    private javax.swing.JButton IDLoker7;
    private javax.swing.JButton IDLoker8;
    private javax.swing.JButton IDLoker9;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
