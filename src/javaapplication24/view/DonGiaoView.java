package javaapplication24.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javaapplication24.service.impl.DonGiaoSerVice;

import javaapplication24.service.impl.DonViVanChuyenSerVice;
import javaapplication24.service.impl.HoaDonSerVice;
import javaapplication24.viewmodel.DonGiaoViewModel;

import javaapplication24.viewmodel.DonViVanChuyenViewModel;

import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

public class DonGiaoView extends javax.swing.JPanel {

    private javaapplication24.service.impl.DonViVanChuyenSerVice donViVanChuyenSerVice;
    private javaapplication24.service.impl.DonGiaoSerVice donGiaoSerVice;
    private javaapplication24.service.impl.HoaDonSerVice hoaDonSerVice;

    private TaoDonGiao_HoaDon taoDonGiao_HoaDon;

    public DonGiaoView() {

        initComponents();

        taoDonGiao_HoaDon = new TaoDonGiao_HoaDon();

        donViVanChuyenSerVice = new DonViVanChuyenSerVice();
        donGiaoSerVice = new DonGiaoSerVice();
        hoaDonSerVice = new HoaDonSerVice();
       
        loadTableDVVC();
     loadTableDGAll();

    }

    public void setTextIDDVVC(String idDVVC) {
        txtTaoIDDVVC.setText(idDVVC);

    }

    public boolean ValidateDVVC() {
        if (txthotLine.getText().equals("") || txtTen.getText().equals("") || txtPhamViVC.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return false;
        }
        return true;
    }

    public boolean ValidateDG() {
        if (txtTaoNgayGiao.getText().equals("") || txtTaoNgayNhan.getText().equals("") || txtTaoDiaChiNhan.getText().equals("") || txtTaoIDHD.getText().equals("") || txtTaoIDDVVC.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin");
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            Date giao = sdf.parse(txtTaoNgayGiao.getText());
            Date nhan = sdf.parse(txtTaoNgayNhan.getText());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng đúng định dạng (Năm-Tháng-Ngày)");
            return false;
        }

        return true;
    }

    public void loadTableDGAll() {
        DefaultTableModel dtm = (DefaultTableModel) tblDG.getModel();

        dtm.setRowCount(0);
        List<DonGiaoViewModel> ds = donGiaoSerVice.all();
        for (DonGiaoViewModel ql : ds) {
            Object[] rowData = new Object[]{
                ql.getIdDonGiao(),
                ql.getIdHoaDon(),
                ql.getIdDonViVanChuyen(),
                ql.getTenDVVC(),
                ql.getNgayGiaoHang(),
                ql.getNgayNhanDK(),
                ql.getDiaChi(),
                ql.getTinhTrang()

            };
            dtm.addRow(rowData);

        }
    }

    public void loadTableDonDangGiao() {
        DefaultTableModel dtmDangGiao = (DefaultTableModel) tblDG.getModel();

        dtmDangGiao.setRowCount(0);
        List<DonGiaoViewModel> dsDangGiao = donGiaoSerVice.donDangGiao();
        for (DonGiaoViewModel ql : dsDangGiao) {
            Object[] rowData = new Object[]{
                ql.getIdDonGiao(),
                ql.getIdHoaDon(),
                ql.getIdDonViVanChuyen(),
                ql.getTenDVVC(),
                ql.getNgayGiaoHang(),
                ql.getNgayNhanDK(),
                ql.getDiaChi(),
                ql.getTinhTrang()

            };
            dtmDangGiao.addRow(rowData);

        }
    }

    public void loadTableDonDaGiao() {
        DefaultTableModel dtmDaGiao = (DefaultTableModel) tblDG.getModel();

        dtmDaGiao.setRowCount(0);
        List<DonGiaoViewModel> dsDaGiao = donGiaoSerVice.donDaGiao();
        for (DonGiaoViewModel ql : dsDaGiao) {
            Object[] rowData = new Object[]{
                ql.getIdDonGiao(),
                ql.getIdHoaDon(),
                ql.getIdDonViVanChuyen(),
                ql.getTenDVVC(),
                ql.getNgayGiaoHang(),
                ql.getNgayNhanDK(),
                ql.getDiaChi(),
                ql.getTinhTrang()

            };
            dtmDaGiao.addRow(rowData);

        }
    }

    public void loadTableDonDaHuy() {
        DefaultTableModel dtmDaHuy = (DefaultTableModel) tblDG.getModel();

        dtmDaHuy.setRowCount(0);
        
        List<DonGiaoViewModel> dsDaHuy = donGiaoSerVice.donDaHuy();
        for (DonGiaoViewModel ql : dsDaHuy) {
            Object[] rowData = new Object[]{
                ql.getIdDonGiao(),
                ql.getIdHoaDon(),
                ql.getIdDonViVanChuyen(),
                ql.getTenDVVC(),
                ql.getNgayGiaoHang(),
                ql.getNgayNhanDK(),
                ql.getDiaChi(),
                ql.getTinhTrang()

            };
            dtmDaHuy.addRow(rowData);

        }
    }

    public void loadTableDVVC() {
        DefaultTableModel dtm = (DefaultTableModel) tblDVVC.getModel();
        dtm.setRowCount(0);
        List<DonViVanChuyenViewModel> ds = donViVanChuyenSerVice.all();
        for (DonViVanChuyenViewModel ql : ds) {
            Object[] rowData = new Object[]{
                ql.getIdDVVC(),
                ql.getTen(),
                ql.getPhamViVC(),
                ql.getTrangThai() == 1 ? "Hoạt Động" : "Ngừng Hoạt Động",
                ql.getHotLine()
            };
            dtm.addRow(rowData);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbIDDG = new javax.swing.JLabel();
        cboTinhTrang = new javax.swing.JComboBox<>();
        lbIDHD = new javax.swing.JLabel();
        lbIDVVC = new javax.swing.JLabel();
        btnSuaDG = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDG = new javax.swing.JTable();
        cboDanhMuc = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnTao = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtTaoIDHD = new javax.swing.JTextField();
        txtTaoIDDVVC = new javax.swing.JTextField();
        btnThayDoi = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnVanChuyen = new javax.swing.JButton();
        txtTaoNgayNhan = new javax.swing.JTextField();
        txtTaoDiaChiNhan = new javax.swing.JTextField();
        txtTaoNgayGiao = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbID = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txthotLine = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPhamViVC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rdoHD = new javax.swing.JRadioButton();
        rdoNgungHD = new javax.swing.JRadioButton();
        btnThemDVVC = new javax.swing.JButton();
        btnSuaDVVC = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDVVC = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        jLabel7.setText("idDG");

        jLabel8.setText("idHD");

        jLabel12.setText("idDVVC");

        jLabel15.setText("Tình Trạng");

        lbIDDG.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cboTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã giao", "Đã hủy" }));
        cboTinhTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTinhTrangActionPerformed(evt);
            }
        });

        lbIDHD.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbIDHD.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbIDVVC.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSuaDG.setBackground(new java.awt.Color(102, 255, 255));
        btnSuaDG.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSuaDG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication24/image/outline_change_circle_black_24dp.png"))); // NOI18N
        btnSuaDG.setText("CẬP NHẬT");
        btnSuaDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbIDDG, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbIDHD, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                    .addComponent(lbIDVVC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(54, 54, 54)
                                .addComponent(btnSuaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(cboTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(lbIDDG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbIDHD, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnSuaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbIDVVC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cboTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        tblDG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idDG", "idHoaDon", "idDVVC", "Tên DVVC", "Ngày Giao", "Ngày Nhận Dự Kiến", "Địa Chỉ Nhận Hàng", "Tình Trạng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDGMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDG);

        cboDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đang giao", "Đã giao", "Đã hủy" }));
        cboDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDanhMucActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Danh Mục");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cboDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        jPanel4.setForeground(new java.awt.Color(255, 51, 51));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btnTao.setBackground(new java.awt.Color(153, 255, 255));
        btnTao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication24/image/click.png"))); // NOI18N
        btnTao.setText("Chọn");
        btnTao.setPreferredSize(new java.awt.Dimension(106, 30));
        btnTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoActionPerformed(evt);
            }
        });

        jLabel9.setText("idHD");

        jLabel16.setText("idDVVC");

        txtTaoIDHD.setEnabled(false);

        txtTaoIDDVVC.setEnabled(false);

        btnThayDoi.setBackground(new java.awt.Color(153, 255, 255));
        btnThayDoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThayDoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication24/image/rotation.png"))); // NOI18N
        btnThayDoi.setText("Thay Đổi");
        btnThayDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThayDoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTaoIDHD, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTaoIDDVVC, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(btnTao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThayDoi)
                .addGap(38, 38, 38))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThayDoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTaoIDHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTaoIDDVVC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(29, 29, 29))
        );

        jLabel13.setText("Ngày Giao");

        jLabel18.setText("Ngày Nhận Dự Kiến");

        jLabel10.setText("Địa Chỉ Nhận");

        btnVanChuyen.setBackground(new java.awt.Color(102, 255, 255));
        btnVanChuyen.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVanChuyen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication24/image/outline_local_shipping_black_24dp.png"))); // NOI18N
        btnVanChuyen.setText("VẬN CHUYỂN");
        btnVanChuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVanChuyenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVanChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel13)
                        .addGap(43, 43, 43)
                        .addComponent(txtTaoNgayGiao, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTaoNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTaoDiaChiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTaoNgayGiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtTaoNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTaoDiaChiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVanChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel11.setText("Thông tin đơn giao");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel20.setText("Danh sách đơn giao");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel21.setText("Tạo đơn giao");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20)
                    .addComponent(jLabel11)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(40, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21)
                        .addGap(183, 183, 183))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Đơn Giao ", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        jLabel1.setText("Id");

        jLabel3.setText("HotLine");

        jLabel4.setText("Tên");

        jLabel5.setText("Phạm vi VC ");

        jLabel6.setText("Trạng Thái");

        buttonGroup1.add(rdoHD);
        rdoHD.setText("Hoạt động");

        buttonGroup1.add(rdoNgungHD);
        rdoNgungHD.setText("Ngừng Hoạt động");

        btnThemDVVC.setBackground(new java.awt.Color(204, 255, 255));
        btnThemDVVC.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThemDVVC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication24/image/button.png"))); // NOI18N
        btnThemDVVC.setText("THÊM");
        btnThemDVVC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDVVCActionPerformed(evt);
            }
        });

        btnSuaDVVC.setBackground(new java.awt.Color(204, 255, 255));
        btnSuaDVVC.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSuaDVVC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication24/image/technics.png"))); // NOI18N
        btnSuaDVVC.setText("SỬA");
        btnSuaDVVC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDVVCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoHD)
                                .addGap(18, 18, 18)
                                .addComponent(rdoNgungHD))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPhamViVC, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(txthotLine))
                        .addContainerGap(93, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35)
                        .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(btnThemDVVC, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(btnSuaDVVC, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPhamViVC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rdoNgungHD)
                    .addComponent(rdoHD)
                    .addComponent(jLabel3)
                    .addComponent(txthotLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemDVVC, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaDVVC, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        tblDVVC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tên", "Phạm Vi VC", "Trạng Thái", "hotLine"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDVVC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDVVCMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDVVC);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel22.setText("Danh sách đơn vị vận chuyển");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel23.setText("Thông tin đơn vị vận chuyển");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 155, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel22)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Đơn vị vận chuyển", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1001, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDVVCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDVVCMouseClicked
        int row = tblDVVC.getSelectedRow();
        if (row == -1) {
            return;
        }
        String id = tblDVVC.getValueAt(row, 0).toString();

        String ten = tblDVVC.getValueAt(row, 1).toString();
        String pvi = tblDVVC.getValueAt(row, 2).toString();
        String trangThai = tblDVVC.getValueAt(row, 3).toString();
        String hotLine = tblDVVC.getValueAt(row, 4).toString();

        lbID.setText(id);
        txthotLine.setText(hotLine);
        txtTen.setText(ten);
        txtPhamViVC.setText(pvi);
        if (trangThai.equals("Hoạt Động")) {
            rdoHD.setSelected(true);
        } else {
            rdoNgungHD.setSelected(true);
        }

    }//GEN-LAST:event_tblDVVCMouseClicked

    private void btnSuaDVVCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDVVCActionPerformed
        if (ValidateDVVC()) {
            String id = lbID.getText();
            String hotLine = txthotLine.getText();
            String ten = txtTen.getText();
            String pvi = txtPhamViVC.getText();
            int trangThai;
            if (rdoHD.isSelected()) {
                trangThai = 1;
            } else {
                trangThai = 0;

            }
            donViVanChuyenSerVice.update(new DonViVanChuyenViewModel(id, ten, pvi, trangThai, hotLine));
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            this.loadTableDVVC();
        }
    }//GEN-LAST:event_btnSuaDVVCActionPerformed

    private void btnThemDVVCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDVVCActionPerformed
        if (ValidateDVVC()) {
            String hotLine = txthotLine.getText();
            String ten = txtTen.getText();
            String pvi = txtPhamViVC.getText();
            int trangThai;
            if (rdoHD.isSelected()) {
                trangThai = 1;
            } else {
                trangThai = 0;

            }
            donViVanChuyenSerVice.insert(new DonViVanChuyenViewModel("", ten, pvi, trangThai, hotLine));
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            this.loadTableDVVC();
        }
    }//GEN-LAST:event_btnThemDVVCActionPerformed

    private void tblDGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDGMouseClicked
        int row = tblDG.getSelectedRow();
        if (row == -1) {
            return;
        }
        String idDG = tblDG.getValueAt(row, 0).toString();
        String idHD = tblDG.getValueAt(row, 1).toString();
        String idDVVC = tblDG.getValueAt(row, 2).toString();

        String tinhTrang = tblDG.getValueAt(row, 7).toString();

        lbIDDG.setText(idDG);

        lbIDHD.setText(idHD);
        lbIDVVC.setText(idDVVC);
        cboTinhTrang.setSelectedItem(tinhTrang);


    }//GEN-LAST:event_tblDGMouseClicked

    private void btnTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoActionPerformed
        TaoDonGiao_HoaDon tdg = new TaoDonGiao_HoaDon();
        tdg.setVisible(true);
        tdg.setLocationRelativeTo(null);


    }//GEN-LAST:event_btnTaoActionPerformed

    private void btnThayDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThayDoiActionPerformed
        TaoID ti = new TaoID();

        txtTaoIDDVVC.setText(ti.getIdDVVC());
        txtTaoIDHD.setText(ti.getIdHD());
    }//GEN-LAST:event_btnThayDoiActionPerformed

    private void btnVanChuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVanChuyenActionPerformed
        if (ValidateDG()) {
            String idHD = txtTaoIDHD.getText();
            String idDVVC = txtTaoIDDVVC.getText();
            String ngayGiao = txtTaoNgayGiao.getText();
            String ngayNhanDK = txtTaoNgayNhan.getText();
            String diaChi = txtTaoDiaChiNhan.getText();
            donGiaoSerVice.insert(new DonGiaoViewModel("", idHD, idDVVC, "", ngayGiao, ngayNhanDK, diaChi, ""));
            JOptionPane.showMessageDialog(this, "Vận chuyển thành công");
            loadTableDGAll();
        }
    }//GEN-LAST:event_btnVanChuyenActionPerformed

    private void btnSuaDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDGActionPerformed
        String idDG = lbIDDG.getText();
        String idHD = lbIDHD.getText();
        String idDVVC = lbIDVVC.getText();
        String tinhTrang = cboTinhTrang.getSelectedItem().toString();
        donGiaoSerVice.update(new DonGiaoViewModel(idDG, idHD, idDVVC, "", "", "", "", tinhTrang));
        JOptionPane.showMessageDialog(this, "Cập nhật thành công");
        loadTableDGAll();
    }//GEN-LAST:event_btnSuaDGActionPerformed

    private void cboTinhTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTinhTrangActionPerformed
 
    }//GEN-LAST:event_cboTinhTrangActionPerformed

    private void cboDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDanhMucActionPerformed
        int index = cboDanhMuc.getSelectedIndex();
     
        if (index==0) {
            loadTableDGAll();
       
        }else
        if (index==1) {
            loadTableDonDangGiao();
            
        }else
        if (index==2) {
            loadTableDonDaGiao();
             
        }else
        if (index==3) {
            loadTableDonDaHuy();
             
        }
     
    }//GEN-LAST:event_cboDanhMucActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaDG;
    private javax.swing.JButton btnSuaDVVC;
    private javax.swing.JButton btnTao;
    private javax.swing.JButton btnThayDoi;
    private javax.swing.JButton btnThemDVVC;
    private javax.swing.JButton btnVanChuyen;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cboDanhMuc;
    private javax.swing.JComboBox<String> cboTinhTrang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbIDDG;
    private javax.swing.JLabel lbIDHD;
    private javax.swing.JLabel lbIDVVC;
    private javax.swing.JRadioButton rdoHD;
    private javax.swing.JRadioButton rdoNgungHD;
    private javax.swing.JTable tblDG;
    private javax.swing.JTable tblDVVC;
    private javax.swing.JTextField txtPhamViVC;
    private javax.swing.JTextField txtTaoDiaChiNhan;
    private javax.swing.JTextField txtTaoIDDVVC;
    private javax.swing.JTextField txtTaoIDHD;
    private javax.swing.JTextField txtTaoNgayGiao;
    private javax.swing.JTextField txtTaoNgayNhan;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txthotLine;
    // End of variables declaration//GEN-END:variables

}
