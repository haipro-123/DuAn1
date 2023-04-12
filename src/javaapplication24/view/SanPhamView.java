/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package javaapplication24.view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import javaapplication24.model.HopThit;
import javaapplication24.model.LoaiThit;
import javaapplication24.model.Thit;
import javaapplication24.service.AllSer;
import javaapplication24.service.InHopThitSer;
import javaapplication24.service.InLoaiThitSer;
import javaapplication24.service.InThitSer;
import javaapplication24.Utilities.Chk;
import javaapplication24.viewmodel.HopThitViewModel;
import javaapplication24.viewmodel.LoaiThitViewModel;
import javaapplication24.viewmodel.ThitViewModel;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class SanPhamView extends javax.swing.JPanel {
    
    InHopThitSer HT_Service = AllSer.getHopThitSer();
    InLoaiThitSer LoaiThit_SV = AllSer.getLoaiThitSer();
    InThitSer Thit_SV = AllSer.getThitSer();
    ArrayList<HopThitViewModel> listHT = new ArrayList<>();
    ArrayList<LoaiThitViewModel> listLT = new ArrayList<>();
    ArrayList<ThitViewModel> listThit = new ArrayList<>();
    DefaultTableModel mol;

    /**
     * Creates new form SanPhamView
     */
    public SanPhamView() {
        initComponents();
        txtMaThit.setEnabled(false);
        txtMaLoaiThit.setEnabled(false);
        txtMaHopThit.setEnabled(false);
        txtGia.setEnabled(false);
        loadTableHopThit();
        loadTableLoaiThit();
        loadTableThit();
    }
    
    
    public void fillThongTinThit(){
        listThit = (ArrayList<ThitViewModel>) Thit_SV.layDanhSachThit();
        cboThit.removeAllItems();
        for(ThitViewModel t : listThit){
            cboThit.addItem(t.getTen());
        }
    }
    
    public void fillThongTinLoaiThit(){
        listLT = (ArrayList<LoaiThitViewModel>) LoaiThit_SV.layDanhSachLoaiThit();
        cboLoaiThit.removeAllItems();
        for(LoaiThitViewModel lt : listLT){
            cboLoaiThit.addItem(lt.getTen());
        }
    }
    
    
    
    public void loadTableThit(){
        listThit = (ArrayList<ThitViewModel>) Thit_SV.layDanhSachThit();
            mol = (DefaultTableModel) tblThit.getModel();
            mol.setColumnCount(0);
            mol.addColumn("STT");
            mol.addColumn("Mã");
            mol.addColumn("Tên");
            mol.addColumn("Mô tả");
            mol.setRowCount(0);
            for (ThitViewModel t : listThit) {
                Object[] row = new Object[]{
                    t.getStt(),
                    t.getMa(),
                    t.getTen(),
                    t.getMota()
                };
                mol.addRow(row);
            }
    }
    
    public void loadTableLoaiThit(){
        fillThongTinThit();
            listLT = (ArrayList<LoaiThitViewModel>) LoaiThit_SV.layDanhSachLoaiThit();
            listThit = (ArrayList<ThitViewModel>) Thit_SV.layDanhSachThit();
            mol = (DefaultTableModel) tblLoaiThit.getModel();
            mol.setColumnCount(0);
            mol.addColumn("STT");
            mol.addColumn("Mã");
            mol.addColumn("Tên");
            mol.addColumn("Đơn Giá");
            mol.addColumn("HSD");
            mol.addColumn("Thông Tin Thịt");
            mol.setRowCount(0);
            for (LoaiThitViewModel lt : listLT) {
                Object[] row = new Object[]{
                    lt.getStt(),
                    lt.getMa(),
                    lt.getTen(),
                    lt.getDonGia() + " VND",
                    lt.getHSD() + " Ngày",
                    lt.getTenThit()
                };
                mol.addRow(row);
            }
    }
    
    public void loadTableHopThit(){
        fillThongTinLoaiThit();
            listHT = (ArrayList<HopThitViewModel>) HT_Service.layDanhSachHopThit();
            mol = (DefaultTableModel) tblHopThit.getModel();
            mol.setColumnCount(0);
            mol.addColumn("STT");
            mol.addColumn("Mã");
            mol.addColumn("Tên");
            mol.addColumn("Trọng Lượng");
            mol.addColumn("Số Lượng");
            mol.addColumn("NSX");
            mol.addColumn("Giá hộp thịt");
            mol.addColumn("Trạng thái");
            mol.setRowCount(0);
            for (HopThitViewModel ht : listHT) {
                Object[] row = new Object[]{
                    ht.getStt(),
                    ht.getMa(),
                    ht.getTenLoaiThit(),
                    ht.getTrongLuong() + "kg",
                    ht.getSoLuong(),
                    ht.getNgaySanXuat(),
                    ht.getTongGia() + " VND",
                    ht.getTrangThai() == 1 ? "Chưa bán" : "Đã bán",
                };
                mol.addRow(row);
            }
    }
    
    public void show(int index){
        if (Tab.getSelectedIndex() == 0) {
            //Show SP
            HopThit ht = HT_Service.getHTByMa(listHT.get(index).getMa());
            LoaiThit lt = LoaiThit_SV.getLTByMa(listLT.get(index).getMa());
            txtMaHopThit.setText(ht.getId());
            txtGia.setText(lt.getDonGia() + "");
            txtTrongLuong.setText(ht.getTrongLuong() + "");
            txtSoLuong.setText(ht.getSoLuong() + "");
            txtNgaySanXuat.setText(ht.getNgaySanXuat() + "");
            cboLoaiThit.setSelectedItem(ht.getTenLoaiThit());
        } else if (Tab.getSelectedIndex() == 1) {
            LoaiThit lt = LoaiThit_SV.getLTByMa(listLT.get(index).getMa());
            
            txtMaLoaiThit.setText(lt.getId());
            txtTenLoaiThit.setText(lt.getTen());
            txtGiaTheoKG.setText(lt.getDonGia() + "");
            txtHSD.setText(lt.getHSD() + ""); 
            cboThit.setSelectedItem(lt.getTenThit());
        } else if (Tab.getSelectedIndex() == 2) {
            Thit t = Thit_SV.getThitByMa(listThit.get(index).getMa());
            txtMaThit.setText(t.getId());
            txtTenThit.setText(t.getTen());
            txtMoTaThit.setText(t.getMota());
        }
    }
    
    
    public boolean chk(){
        if (Tab.getSelectedIndex() == 0) {
            if (Chk.chknull("Không Để Trống Trọng Lượng", txtTrongLuong)) {
                return false;
            }
            try {
            double trongLuong = Double.parseDouble(txtTrongLuong.getText());
            if (trongLuong <= 0) {
                JOptionPane.showMessageDialog(this, "Trọng Lượng Phải > 0","Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
                } 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Trọng Lượng Phải Là Số","Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (Chk.chknull("Không Để Trống Số Lượng", txtSoLuong)) {
                return false;
            } 
            try {
            double soLuong = Double.parseDouble(txtSoLuong.getText());
            if (soLuong <= 0) {
                JOptionPane.showMessageDialog(this, "Số Lượng Phải > 0","Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
                } 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Số Lượng Phải Là Số","Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (Chk.chknull("Không Để Trống Ngày Sản Xuất", txtNgaySanXuat)) {
                return false;
            } else if(Chk.chkDate("Ngày Ko Đúng Định Dạng", txtNgaySanXuat)) {
                return false;
            } else {
                return true;
            }
        } else if (Tab.getSelectedIndex() == 1) {
            if (Chk.chknull("Không Để Trống Tên", txtTenLoaiThit)) {
                return false;
            }
            if (Chk.chknull("Không Để Trống Giá", txtGiaTheoKG)) {
                return false;
            }
            try {
            double giaTheoKg = Double.parseDouble(txtGiaTheoKG.getText());
            if (giaTheoKg <= 0) {
                JOptionPane.showMessageDialog(this, "Giá Phải > 0","Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
                } 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Giá Phải Là Số","Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (Chk.chknull("Không Để Trống HSD", txtHSD)) {
                return false;
            }
            try {
            double hsd = Double.parseDouble(txtHSD.getText());
            if (hsd <= 0) {
                JOptionPane.showMessageDialog(this, "HSD Phải > 0","Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
                } 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "HSD Phải Là Số","Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            {
                return true;
            }
        } else if (Tab.getSelectedIndex() == 2) {
            if (Chk.chknull("Không Để Trống Tên", txtTenThit)) {
                return false;
            } else if (Chk.chknull("Không Để Trống Mô Tả", txtMoTaThit)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
    
    public void clear(){
        if (Tab.getSelectedIndex() == 0) {
            txtMaHopThit.setText("");
            txtGia.setText("");
            txtTrongLuong.setText("");
            txtSoLuong.setText("");
            txtNgaySanXuat.setText("");
            cboLoaiThit.setSelectedIndex(0);
        } else if (Tab.getSelectedIndex() == 1) {
            txtMaLoaiThit.setText("");
            txtTenLoaiThit.setText("");
            txtGiaTheoKG.setText("");
            txtHSD.setText("");
            cboThit.setSelectedIndex(0);
        } else if (Tab.getSelectedIndex() == 2) {
            txtMaThit.setText("");
            txtTenThit.setText("");
            txtMoTaThit.setText("");
        }
    }
    
    public Thit getThit(){
        return new Thit(txtTenThit.getText(), txtMoTaThit.getText());
    }
    
    
    public LoaiThit getLoaiThit(){
         String maThit = cboThit.getSelectedItem().toString().split(" ")[0];
         Thit t = Thit_SV.getThitByMa(maThit);
         String id = listThit.get(cboThit.getSelectedIndex()).getMa();
         String ten = listThit.get(cboThit.getSelectedIndex()).getTen();
         return new LoaiThit(id, ten, txtTenLoaiThit.getText(), Integer.parseInt(txtGiaTheoKG.getText()), Integer.parseInt(txtHSD.getText()));
    }
    
    public HopThit getHopThit(){
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        String maLoaiThit = cboLoaiThit.getSelectedItem().toString().split(" ")[0];
        LoaiThit lt = LoaiThit_SV.getLTByMa(maLoaiThit);
        String id = listLT.get(cboLoaiThit.getSelectedIndex()).getMa();
        String ten = listLT.get(cboLoaiThit.getSelectedIndex()).getTen();
        try {
            return new HopThit(id, ten, Integer.parseInt(txtTrongLuong.getText()), Integer.parseInt(txtSoLuong.getText()), fm.parse(txtNgaySanXuat.getText()), 1);
        } catch (ParseException ex) {
            Logger.getLogger(SanPhamView.class.getName()).log(Level.SEVERE, null, ex);
            return null;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        Tab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaHopThit = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTrongLuong = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNgaySanXuat = new javax.swing.JTextField();
        cboLoaiThit = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnThemHopThit = new javax.swing.JButton();
        btnSuaHopThit = new javax.swing.JButton();
        btnClearHopThit = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHopThit = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        MaMau = new javax.swing.JLabel();
        tenMau = new javax.swing.JLabel();
        txtMaLoaiThit = new javax.swing.JTextField();
        txtTenLoaiThit = new javax.swing.JTextField();
        tenMau1 = new javax.swing.JLabel();
        txtGiaTheoKG = new javax.swing.JTextField();
        tenMau3 = new javax.swing.JLabel();
        txtHSD = new javax.swing.JTextField();
        tenMau4 = new javax.swing.JLabel();
        cboThit = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        btnThemLoaiThit = new javax.swing.JButton();
        btnSuaLoaiThit = new javax.swing.JButton();
        btnClearLoaiThit = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLoaiThit = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        MaMau2 = new javax.swing.JLabel();
        tenMau2 = new javax.swing.JLabel();
        txtMaThit = new javax.swing.JTextField();
        txtMoTaThit = new javax.swing.JTextField();
        txtTenThit = new javax.swing.JTextField();
        MaMau3 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        btnThemThit = new javax.swing.JButton();
        btnSuaThit = new javax.swing.JButton();
        btnClearThit = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblThit = new javax.swing.JTable();

        Tab.setBackground(new java.awt.Color(186, 79, 84));
        Tab.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), null));
        Tab.setForeground(new java.awt.Color(187, 187, 187));
        Tab.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Tab.setMaximumSize(new java.awt.Dimension(50000, 50000));
        Tab.setPreferredSize(new java.awt.Dimension(780, 731));
        Tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(186, 79, 84));

        jPanel6.setBackground(new java.awt.Color(186, 79, 84));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thông Tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(187, 187, 187))); // NOI18N
        jPanel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel1.setForeground(new java.awt.Color(187, 187, 187));
        jLabel1.setText("Mã");

        jLabel2.setForeground(new java.awt.Color(187, 187, 187));
        jLabel2.setText("Giá");

        txtMaHopThit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHopThitActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(187, 187, 187));
        jLabel3.setText("Trọng lượng");

        jLabel4.setForeground(new java.awt.Color(187, 187, 187));
        jLabel4.setText("Số lượng");

        jLabel5.setForeground(new java.awt.Color(187, 187, 187));
        jLabel5.setText("Ngày sản xuất");

        cboLoaiThit.setBackground(new java.awt.Color(186, 79, 84));
        cboLoaiThit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setForeground(new java.awt.Color(187, 187, 187));
        jLabel6.setText("Thông tin loại thịt");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboLoaiThit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNgaySanXuat)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTrongLuong))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaHopThit, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboLoaiThit, txtGia, txtMaHopThit, txtNgaySanXuat, txtSoLuong, txtTrongLuong});

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaHopThit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTrongLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNgaySanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboLoaiThit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboLoaiThit, txtGia, txtMaHopThit, txtNgaySanXuat, txtSoLuong, txtTrongLuong});

        jPanel8.setBackground(new java.awt.Color(186, 79, 84));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jPanel8.setPreferredSize(new java.awt.Dimension(324, 90));

        btnThemHopThit.setBackground(new java.awt.Color(186, 79, 84));
        btnThemHopThit.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        btnThemHopThit.setForeground(new java.awt.Color(187, 187, 187));
        btnThemHopThit.setText("Thêm");
        btnThemHopThit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHopThitActionPerformed(evt);
            }
        });

        btnSuaHopThit.setBackground(new java.awt.Color(186, 79, 84));
        btnSuaHopThit.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        btnSuaHopThit.setForeground(new java.awt.Color(187, 187, 187));
        btnSuaHopThit.setText("Sửa");
        btnSuaHopThit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaHopThitActionPerformed(evt);
            }
        });

        btnClearHopThit.setBackground(new java.awt.Color(186, 79, 84));
        btnClearHopThit.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        btnClearHopThit.setForeground(new java.awt.Color(187, 187, 187));
        btnClearHopThit.setText("Thêm Mới");
        btnClearHopThit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearHopThitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemHopThit, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaHopThit, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearHopThit, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnClearHopThit, btnSuaHopThit, btnThemHopThit});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnThemHopThit, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSuaHopThit, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClearHopThit, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnClearHopThit, btnSuaHopThit, btnThemHopThit});

        jPanel5.setBackground(new java.awt.Color(186, 79, 84));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Danh Sách Hộp Thịt", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(187, 187, 187))); // NOI18N

        tblHopThit.setBackground(new java.awt.Color(187, 187, 187));
        tblHopThit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Mã ", "Tên"
            }
        ));
        tblHopThit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHopThitMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHopThit);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Tab.addTab("Hộp Thịt", jPanel1);

        jPanel3.setBackground(new java.awt.Color(186, 79, 84));

        jPanel9.setBackground(new java.awt.Color(186, 79, 84));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thông Tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(187, 187, 187))); // NOI18N
        jPanel9.setForeground(new java.awt.Color(187, 187, 187));

        MaMau.setForeground(new java.awt.Color(187, 187, 187));
        MaMau.setText("Mã");

        tenMau.setForeground(new java.awt.Color(187, 187, 187));
        tenMau.setText("Tên");

        tenMau1.setForeground(new java.awt.Color(187, 187, 187));
        tenMau1.setText("Giá theo kg");

        tenMau3.setForeground(new java.awt.Color(187, 187, 187));
        tenMau3.setText("HSD");

        tenMau4.setForeground(new java.awt.Color(187, 187, 187));
        tenMau4.setText("Thông tin thịt");

        cboThit.setBackground(new java.awt.Color(186, 79, 84));
        cboThit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(MaMau)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaLoaiThit, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(tenMau, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenLoaiThit))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(tenMau1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaTheoKG))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(tenMau3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHSD))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(tenMau4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboThit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {MaMau, tenMau, tenMau1, tenMau3, tenMau4});

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboThit, txtGiaTheoKG, txtHSD, txtMaLoaiThit, txtTenLoaiThit});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaLoaiThit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MaMau))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tenMau)
                    .addComponent(txtTenLoaiThit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tenMau1)
                    .addComponent(txtGiaTheoKG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tenMau3)
                    .addComponent(txtHSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboThit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenMau4))
                .addGap(33, 33, 33))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboThit, txtGiaTheoKG, txtHSD, txtMaLoaiThit, txtTenLoaiThit});

        jPanel10.setBackground(new java.awt.Color(186, 79, 84));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jPanel10.setPreferredSize(new java.awt.Dimension(324, 90));

        btnThemLoaiThit.setBackground(new java.awt.Color(186, 79, 84));
        btnThemLoaiThit.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        btnThemLoaiThit.setForeground(new java.awt.Color(187, 187, 187));
        btnThemLoaiThit.setText("Thêm");
        btnThemLoaiThit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemLoaiThitMouseClicked(evt);
            }
        });
        btnThemLoaiThit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLoaiThitActionPerformed(evt);
            }
        });

        btnSuaLoaiThit.setBackground(new java.awt.Color(186, 79, 84));
        btnSuaLoaiThit.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        btnSuaLoaiThit.setForeground(new java.awt.Color(187, 187, 187));
        btnSuaLoaiThit.setText("Sửa");
        btnSuaLoaiThit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaLoaiThitActionPerformed(evt);
            }
        });

        btnClearLoaiThit.setBackground(new java.awt.Color(186, 79, 84));
        btnClearLoaiThit.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        btnClearLoaiThit.setForeground(new java.awt.Color(187, 187, 187));
        btnClearLoaiThit.setText("Thêm Mới");
        btnClearLoaiThit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearLoaiThitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemLoaiThit, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaLoaiThit, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearLoaiThit, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnClearLoaiThit, btnSuaLoaiThit, btnThemLoaiThit});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemLoaiThit, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSuaLoaiThit, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClearLoaiThit, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnClearLoaiThit, btnSuaLoaiThit, btnThemLoaiThit});

        jPanel7.setBackground(new java.awt.Color(186, 79, 84));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Danh Sách Loại Thịt", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(187, 187, 187))); // NOI18N

        tblLoaiThit.setBackground(new java.awt.Color(187, 187, 187));
        tblLoaiThit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Mã ", "Tên"
            }
        ));
        tblLoaiThit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiThitMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblLoaiThit);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        Tab.addTab("Loại Thịt", jPanel3);

        jPanel14.setBackground(new java.awt.Color(186, 79, 84));

        jPanel16.setBackground(new java.awt.Color(186, 79, 84));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thông Tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(187, 187, 187))); // NOI18N

        MaMau2.setForeground(new java.awt.Color(187, 187, 187));
        MaMau2.setText("Mã");

        tenMau2.setForeground(new java.awt.Color(187, 187, 187));
        tenMau2.setText("Mô tả");

        MaMau3.setForeground(new java.awt.Color(187, 187, 187));
        MaMau3.setText("Tên");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(MaMau2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaThit, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(MaMau3, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenThit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(tenMau2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMoTaThit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel16Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtMaThit, txtMoTaThit, txtTenThit});

        jPanel16Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {MaMau2, MaMau3, tenMau2});

        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaThit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MaMau2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenThit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MaMau3))
                .addGap(46, 46, 46)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tenMau2)
                    .addComponent(txtMoTaThit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        jPanel16Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtMaThit, txtMoTaThit, txtTenThit});

        jPanel17.setBackground(new java.awt.Color(186, 79, 84));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jPanel17.setPreferredSize(new java.awt.Dimension(324, 90));

        btnThemThit.setBackground(new java.awt.Color(186, 79, 84));
        btnThemThit.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        btnThemThit.setForeground(new java.awt.Color(187, 187, 187));
        btnThemThit.setText("Thêm");
        btnThemThit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemThitActionPerformed(evt);
            }
        });

        btnSuaThit.setBackground(new java.awt.Color(186, 79, 84));
        btnSuaThit.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnSuaThit.setForeground(new java.awt.Color(187, 187, 187));
        btnSuaThit.setText("Sửa");
        btnSuaThit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaThitActionPerformed(evt);
            }
        });

        btnClearThit.setBackground(new java.awt.Color(186, 79, 84));
        btnClearThit.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnClearThit.setForeground(new java.awt.Color(187, 187, 187));
        btnClearThit.setText("Thêm Mới");
        btnClearThit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearThitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnClearThit, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaThit, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemThit, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnThemThit, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuaThit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClearThit, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnClearThit, btnSuaThit, btnThemThit});

        jPanel15.setBackground(new java.awt.Color(186, 79, 84));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Danh Sách Thịt", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(187, 187, 187))); // NOI18N

        tblThit.setBackground(new java.awt.Color(187, 187, 187));
        tblThit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Mã ", "Tên"
            }
        ));
        tblThit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThitMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblThit);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(396, 396, 396))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                    .addContainerGap(332, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        Tab.addTab("Thịt", jPanel14);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Tab, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblHopThitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHopThitMouseClicked
        int index = tblHopThit.getSelectedRow();
        show(index);
    }//GEN-LAST:event_tblHopThitMouseClicked

    private void txtMaHopThitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHopThitActionPerformed

    }//GEN-LAST:event_txtMaHopThitActionPerformed

    private void btnThemHopThitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHopThitActionPerformed
        if(chk()){
            if(HT_Service.getHTByMa(txtMaHopThit.getText()) != null){
                JOptionPane.showMessageDialog(this, "Đã Có Mã Hộp Thịt Này Trong DATABASE", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                HT_Service.add(getHopThit());
                loadTableHopThit();
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                clear();
            }
        }
    }//GEN-LAST:event_btnThemHopThitActionPerformed

    private void btnSuaHopThitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaHopThitActionPerformed
        if(chk()){
            if(HT_Service.getHTByMa(txtMaHopThit.getText()) != null){
                HopThit ht = getHopThit();
                ht.setId(txtMaHopThit.getText());
                HT_Service.update(ht);
                loadTableHopThit();
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                clear();
            } else {
                JOptionPane.showMessageDialog(this, "Không Tồn Tại Loại Thịt Này Trong DATABASE", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSuaHopThitActionPerformed

    private void btnClearHopThitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearHopThitActionPerformed
        clear();
    }//GEN-LAST:event_btnClearHopThitActionPerformed

    private void tblLoaiThitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiThitMouseClicked
        int index = tblLoaiThit.getSelectedRow();
        show(index);
    }//GEN-LAST:event_tblLoaiThitMouseClicked

    private void btnThemLoaiThitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemLoaiThitMouseClicked

    }//GEN-LAST:event_btnThemLoaiThitMouseClicked

    private void btnThemLoaiThitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLoaiThitActionPerformed
        if(chk()){
            if(LoaiThit_SV.getLTByMa(txtMaLoaiThit.getText()) != null){
                JOptionPane.showMessageDialog(this, "Đã Có Mã Loại Thịt Này Trong DATABASE", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else if(LoaiThit_SV.getLTByTen(txtTenLoaiThit.getText()) != null){
                JOptionPane.showMessageDialog(this, "Đã Có Tên Loại Thịt Này Trong DATABASE", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else if(LoaiThit_SV.getLTByGia(txtGiaTheoKG.getText()) != null){
                JOptionPane.showMessageDialog(this, "Đã Có Giá Loại Thịt Này Trong DATABASE", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                LoaiThit_SV.add(getLoaiThit());
                fillThongTinLoaiThit();
                loadTableLoaiThit();
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                clear();
            }
        }
    }//GEN-LAST:event_btnThemLoaiThitActionPerformed

    private void btnSuaLoaiThitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaLoaiThitActionPerformed
        if(chk()){
            if(LoaiThit_SV.getLTByMa(txtMaLoaiThit.getText()) != null){
                LoaiThit lt = getLoaiThit();
                lt.setId(txtMaLoaiThit.getText());
                LoaiThit_SV.update(lt);
                loadTableLoaiThit();
                fillThongTinLoaiThit();
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                clear();
            } else {
                JOptionPane.showMessageDialog(this, "Không Tồn Tại Loại Thịt Này Trong DATABASE", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSuaLoaiThitActionPerformed

    private void btnClearLoaiThitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearLoaiThitActionPerformed
        clear();
    }//GEN-LAST:event_btnClearLoaiThitActionPerformed

    private void tblThitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThitMouseClicked
        int index = tblThit.getSelectedRow();
        show(index);
    }//GEN-LAST:event_tblThitMouseClicked

    private void btnThemThitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemThitActionPerformed
        if(chk()){
            if(Thit_SV.getThitByMa(txtMaThit.getText()) != null){
                JOptionPane.showMessageDialog(this, "Đã Có Mã Thịt Này Trong DATABASE", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else if(Thit_SV.getThitByTen(txtTenThit.getText()) != null){
                JOptionPane.showMessageDialog(this, "Đã Có Tên Thịt Này Trong DATABASE", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                Thit_SV.add(getThit());
                loadTableThit();
                fillThongTinThit();
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                clear();
            }
        }
    }//GEN-LAST:event_btnThemThitActionPerformed

    private void btnSuaThitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaThitActionPerformed
        if(chk()){
            if(Thit_SV.getThitByMa(txtMaThit.getText()) != null){
                Thit t = getThit();
                t.setId(txtMaThit.getText());
                Thit_SV.update(t);
                loadTableThit();
                fillThongTinThit();
                clear();
                JOptionPane.showMessageDialog(this, "Sửa thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Không Tồn Tại Thịt Này Trong DATABASE", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSuaThitActionPerformed

    private void btnClearThitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearThitActionPerformed
        clear();
    }//GEN-LAST:event_btnClearThitActionPerformed

    private void TabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabMouseClicked

    }//GEN-LAST:event_TabMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MaMau;
    private javax.swing.JLabel MaMau2;
    private javax.swing.JLabel MaMau3;
    private javax.swing.JTabbedPane Tab;
    private javax.swing.JButton btnClearHopThit;
    private javax.swing.JButton btnClearLoaiThit;
    private javax.swing.JButton btnClearThit;
    private javax.swing.JButton btnSuaHopThit;
    private javax.swing.JButton btnSuaLoaiThit;
    private javax.swing.JButton btnSuaThit;
    private javax.swing.JButton btnThemHopThit;
    private javax.swing.JButton btnThemLoaiThit;
    private javax.swing.JButton btnThemThit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboLoaiThit;
    private javax.swing.JComboBox<String> cboThit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblHopThit;
    private javax.swing.JTable tblLoaiThit;
    private javax.swing.JTable tblThit;
    private javax.swing.JLabel tenMau;
    private javax.swing.JLabel tenMau1;
    private javax.swing.JLabel tenMau2;
    private javax.swing.JLabel tenMau3;
    private javax.swing.JLabel tenMau4;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtGiaTheoKG;
    private javax.swing.JTextField txtHSD;
    private javax.swing.JTextField txtMaHopThit;
    private javax.swing.JTextField txtMaLoaiThit;
    private javax.swing.JTextField txtMaThit;
    private javax.swing.JTextField txtMoTaThit;
    private javax.swing.JTextField txtNgaySanXuat;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenLoaiThit;
    private javax.swing.JTextField txtTenThit;
    private javax.swing.JTextField txtTrongLuong;
    // End of variables declaration//GEN-END:variables
}
