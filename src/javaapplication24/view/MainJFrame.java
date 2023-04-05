/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication24.view;

import java.awt.*;
import java.util.*;
import javax.swing.JComponent;

/**
 *
 * @author Admin
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    SanPhamView spv = new SanPhamView();
    BanHangView bhv = new BanHangView();
    public MainJFrame() {
        initComponents();
        setForm(bhv);
    }

    private void setForm(JComponent com) {
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(com);
        jpnView.validate();
        jpnView.repaint();
        jpnView.revalidate();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel14 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jpnRoot = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpnBanhang = new javax.swing.JPanel();
        jlbBanHang = new javax.swing.JLabel();
        jpnSanPham = new javax.swing.JPanel();
        jlbSanPham = new javax.swing.JLabel();
        jpnHoaDon = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jpnKhuyenMai = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jpnNhanVien = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jpnKhachHang = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jpnThongKe = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jpnDonGiao = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jpnView = new javax.swing.JPanel();

        jPanel14.setBackground(new java.awt.Color(255, 77, 77));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication24/image/outline_logout_black_24dp.png"))); // NOI18N
        jLabel12.setText("Đợt giảm giá");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel12)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnRoot.setAutoscrolls(true);

        jpnMenu.setBackground(new java.awt.Color(102, 102, 0));
        jpnMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel3.setBackground(new java.awt.Color(102, 255, 102));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication24/image/account_circle_FILL0_wght400_GRAD0_opsz48.png"))); // NOI18N
        jLabel1.setText("QUẢN LÝ THỊT TƯƠI");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jpnBanhang.setBackground(new java.awt.Color(255, 77, 77));
        jpnBanhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnBanhangMouseClicked(evt);
            }
        });

        jlbBanHang.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlbBanHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication24/image/outline_storefront_black_24dp.png"))); // NOI18N
        jlbBanHang.setText("Bán hàng");

        javax.swing.GroupLayout jpnBanhangLayout = new javax.swing.GroupLayout(jpnBanhang);
        jpnBanhang.setLayout(jpnBanhangLayout);
        jpnBanhangLayout.setHorizontalGroup(
            jpnBanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBanhangLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jlbBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnBanhangLayout.setVerticalGroup(
            jpnBanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBanhangLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbBanHang)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jpnSanPham.setBackground(new java.awt.Color(255, 77, 77));
        jpnSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnSanPhamMouseClicked(evt);
            }
        });

        jlbSanPham.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlbSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication24/image/outline_inventory_2_black_24dp.png"))); // NOI18N
        jlbSanPham.setText("Sản phẩm");

        javax.swing.GroupLayout jpnSanPhamLayout = new javax.swing.GroupLayout(jpnSanPham);
        jpnSanPham.setLayout(jpnSanPhamLayout);
        jpnSanPhamLayout.setHorizontalGroup(
            jpnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSanPhamLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jlbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnSanPhamLayout.setVerticalGroup(
            jpnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSanPhamLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbSanPham)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jpnHoaDon.setBackground(new java.awt.Color(255, 77, 77));
        jpnHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OpenForm(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication24/image/outline_receipt_long_black_24dp.png"))); // NOI18N
        jLabel11.setText("Hoá đơn");

        javax.swing.GroupLayout jpnHoaDonLayout = new javax.swing.GroupLayout(jpnHoaDon);
        jpnHoaDon.setLayout(jpnHoaDonLayout);
        jpnHoaDonLayout.setHorizontalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoaDonLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnHoaDonLayout.setVerticalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoaDonLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel11)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jpnKhuyenMai.setBackground(new java.awt.Color(255, 77, 77));
        jpnKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnKhuyenMaiMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication24/image/outline_sell_black_24dp.png"))); // NOI18N
        jLabel5.setText("Phiếu giảm giá");

        javax.swing.GroupLayout jpnKhuyenMaiLayout = new javax.swing.GroupLayout(jpnKhuyenMai);
        jpnKhuyenMai.setLayout(jpnKhuyenMaiLayout);
        jpnKhuyenMaiLayout.setHorizontalGroup(
            jpnKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhuyenMaiLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnKhuyenMaiLayout.setVerticalGroup(
            jpnKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhuyenMaiLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jpnNhanVien.setBackground(new java.awt.Color(255, 77, 77));
        jpnNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnNhanVienMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication24/image/outline_groups_black_24dp.png"))); // NOI18N
        jLabel6.setText("Nhân viên");

        javax.swing.GroupLayout jpnNhanVienLayout = new javax.swing.GroupLayout(jpnNhanVien);
        jpnNhanVien.setLayout(jpnNhanVienLayout);
        jpnNhanVienLayout.setHorizontalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNhanVienLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnNhanVienLayout.setVerticalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNhanVienLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel6)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jpnKhachHang.setBackground(new java.awt.Color(255, 77, 77));
        jpnKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnKhachHangMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication24/image/outline_person_search_black_24dp.png"))); // NOI18N
        jLabel7.setText("Khách hàng");

        javax.swing.GroupLayout jpnKhachHangLayout = new javax.swing.GroupLayout(jpnKhachHang);
        jpnKhachHang.setLayout(jpnKhachHangLayout);
        jpnKhachHangLayout.setHorizontalGroup(
            jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhachHangLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnKhachHangLayout.setVerticalGroup(
            jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhachHangLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jpnThongKe.setBackground(new java.awt.Color(255, 77, 77));
        jpnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnThongKeMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication24/image/outline_bar_chart_black_24dp.png"))); // NOI18N
        jLabel8.setText("Thống kê");

        javax.swing.GroupLayout jpnThongKeLayout = new javax.swing.GroupLayout(jpnThongKe);
        jpnThongKe.setLayout(jpnThongKeLayout);
        jpnThongKeLayout.setHorizontalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongKeLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnThongKeLayout.setVerticalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongKeLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel8)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jpnDonGiao.setBackground(new java.awt.Color(255, 77, 77));
        jpnDonGiao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnDonGiaoMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication24/image/outline_local_shipping_black_24dp.png"))); // NOI18N
        jLabel10.setText("Đơn giao");

        javax.swing.GroupLayout jpnDonGiaoLayout = new javax.swing.GroupLayout(jpnDonGiao);
        jpnDonGiao.setLayout(jpnDonGiaoLayout);
        jpnDonGiaoLayout.setHorizontalGroup(
            jpnDonGiaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDonGiaoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(195, Short.MAX_VALUE))
        );
        jpnDonGiaoLayout.setVerticalGroup(
            jpnDonGiaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDonGiaoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel10)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnBanhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnDonGiao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnBanhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnDonGiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenForm(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpenForm
        // TODO add your handling code here:
        resetColor();
        jpnHoaDon.setBackground(new Color(26, 117, 255));
        setForm(bhv);
    }//GEN-LAST:event_OpenForm

    private void jpnBanhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnBanhangMouseClicked
        // TODO add your handling code here:
        resetColor();
        jpnBanhang.setBackground(new Color(26, 117, 255));
        setForm(bhv);
    }//GEN-LAST:event_jpnBanhangMouseClicked

    private void jpnSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnSanPhamMouseClicked
        // TODO add your handling code here:
        resetColor();
        jpnSanPham.setBackground(new Color(26, 117, 255));
        setForm(spv);
    }//GEN-LAST:event_jpnSanPhamMouseClicked

    private void jpnKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnKhuyenMaiMouseClicked
        // TODO add your handling code here:
        VoucherView vv = new VoucherView();
        resetColor();
        jpnKhuyenMai.setBackground(new Color(26, 117, 255));
        setForm(vv);
    }//GEN-LAST:event_jpnKhuyenMaiMouseClicked

    private void jpnNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnNhanVienMouseClicked
        // TODO add your handling code here:
        resetColor();
        jpnNhanVien.setBackground(new Color(26, 117, 255));
        setForm(spv);
    }//GEN-LAST:event_jpnNhanVienMouseClicked

    private void jpnKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnKhachHangMouseClicked
        // TODO add your handling code here:
        resetColor();
        jpnKhachHang.setBackground(new Color(26, 117, 255));
        setForm(spv);
    }//GEN-LAST:event_jpnKhachHangMouseClicked

    private void jpnThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnThongKeMouseClicked
        // TODO add your handling code here:
        resetColor();
        jpnThongKe.setBackground(new Color(26, 117, 255));
        setForm(spv);
    }//GEN-LAST:event_jpnThongKeMouseClicked

    private void jpnDonGiaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnDonGiaoMouseClicked
        // TODO add your handling code here:
        resetColor();
        jpnDonGiao.setBackground(new Color(26, 117, 255));
        setForm(spv);
    }//GEN-LAST:event_jpnDonGiaoMouseClicked
    private void resetColor(){
        jpnBanhang.setBackground(new Color(255,77,77));
        jpnHoaDon.setBackground(new Color(255,77,77));
        jpnKhachHang.setBackground(new Color(255,77,77));
        jpnKhuyenMai.setBackground(new Color(255,77,77));
        jpnNhanVien.setBackground(new Color(255,77,77));
        jpnThongKe.setBackground(new Color(255,77,77));
        jpnDonGiao.setBackground(new Color(255,77,77));
        jpnSanPham.setBackground(new Color(255,77,77));
    }
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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jlbBanHang;
    private javax.swing.JLabel jlbSanPham;
    private javax.swing.JPanel jpnBanhang;
    private javax.swing.JPanel jpnDonGiao;
    private javax.swing.JPanel jpnHoaDon;
    private javax.swing.JPanel jpnKhachHang;
    private javax.swing.JPanel jpnKhuyenMai;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnNhanVien;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnSanPham;
    private javax.swing.JPanel jpnThongKe;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables
}
