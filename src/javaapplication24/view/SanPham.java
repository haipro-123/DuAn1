/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import DomainModel.HopThit;
import DomainModel.LoaiThit;
import DomainModel.Thit;
import Service.AllSer;
import Service.InHopThitSer;
import Service.InLoaiThitSer;
import Service.InThitSer;
import Utilities.Chk;
import ViewModels.HopThitViewModel;
import ViewModels.LoaiThitViewModel;
import ViewModels.ThitViewModel;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author baphuoc
 */
public class SanPham extends javax.swing.JFrame {
    
    InHopThitSer HT_Service = AllSer.getHopThitSer();
    InLoaiThitSer LoaiThit_SV = AllSer.getLoaiThitSer();
    InThitSer Thit_SV = AllSer.getThitSer();
    ArrayList<HopThitViewModel> listHT = new ArrayList<>();
    ArrayList<LoaiThitViewModel> listLT = new ArrayList<>();
    ArrayList<ThitViewModel> listThit = new ArrayList<>();
    DefaultTableModel mol;
    

    /**
     * Creates new form SanPham
     */
    public SanPham() {
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
                    lt.getThit()
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
            mol.setRowCount(0);
            for (HopThitViewModel ht : listHT) {
                Object[] row = new Object[]{
                    ht.getStt(),
                    ht.getMa(),
                    ht.getLoaiThit(),
                    ht.getTrongLuong() + "kg",
                    ht.getSoLuong(),
                    ht.getNgaySanXuat(),
                    ht.getTongGia() + " VND"
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
            cboLoaiThit.setSelectedItem(lt.getTen());
        } else if (Tab.getSelectedIndex() == 1) {
            LoaiThit lt = LoaiThit_SV.getLTByMa(listLT.get(index).getMa());
            Thit t = Thit_SV.getThitByMa(listThit.get(index).getMa());
            txtMaLoaiThit.setText(lt.getId());
            txtTenLoaiThit.setText(lt.getTen());
            txtGiaTheoKG.setText(lt.getDonGia() + "");
            txtHSD.setText(lt.getHSD() + ""); 
            cboThit.setSelectedItem(t.getTen());
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
        } else if (Tab.getSelectedIndex() == 1) {
            txtMaLoaiThit.setText("");
            txtTenLoaiThit.setText("");
            txtGiaTheoKG.setText("");
            txtHSD.setText("");
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
         return new LoaiThit(id, txtTenLoaiThit.getText(), Integer.parseInt(txtGiaTheoKG.getText()), Integer.parseInt(txtHSD.getText()));
    }
    
    public HopThit getHopThit(){
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        String maLoaiThit = cboLoaiThit.getSelectedItem().toString().split(" ")[0];
        LoaiThit lt = LoaiThit_SV.getLTByMa(maLoaiThit);
        String id = listLT.get(cboLoaiThit.getSelectedIndex()).getMa();
        try {
            return new HopThit(id, Integer.parseInt(txtTrongLuong.getText()), Integer.parseInt(txtSoLuong.getText()), fm.parse(txtNgaySanXuat.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
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

        Tab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHopThit = new javax.swing.JTable();
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
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLoaiThit = new javax.swing.JTable();
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
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblThit = new javax.swing.JTable();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(186, 79, 84));

        Tab.setBackground(new java.awt.Color(186, 79, 84));
        Tab.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), null));
        Tab.setForeground(new java.awt.Color(187, 187, 187));
        Tab.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Tab.setMaximumSize(new java.awt.Dimension(50000, 50000));
        Tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(186, 79, 84));

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaHopThit, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(txtGia, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(txtTrongLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(txtNgaySanXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(cboLoaiThit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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

        jPanel8.setBackground(new java.awt.Color(186, 79, 84));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jPanel8.setPreferredSize(new java.awt.Dimension(324, 90));

        btnThemHopThit.setBackground(new java.awt.Color(186, 79, 84));
        btnThemHopThit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThemHopThit.setForeground(new java.awt.Color(187, 187, 187));
        btnThemHopThit.setText("Thêm");
        btnThemHopThit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHopThitActionPerformed(evt);
            }
        });

        btnSuaHopThit.setBackground(new java.awt.Color(186, 79, 84));
        btnSuaHopThit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSuaHopThit.setForeground(new java.awt.Color(187, 187, 187));
        btnSuaHopThit.setText("Sửa");
        btnSuaHopThit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaHopThitActionPerformed(evt);
            }
        });

        btnClearHopThit.setBackground(new java.awt.Color(186, 79, 84));
        btnClearHopThit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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
                .addContainerGap()
                .addComponent(btnThemHopThit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSuaHopThit)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClearHopThit)
                .addGap(83, 83, 83))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnClearHopThit, btnSuaHopThit, btnThemHopThit});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemHopThit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaHopThit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClearHopThit)
                .addContainerGap())
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnClearHopThit, btnSuaHopThit, btnThemHopThit});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 38, Short.MAX_VALUE))
        );

        Tab.addTab("Hộp Thịt", jPanel1);

        jPanel3.setBackground(new java.awt.Color(186, 79, 84));

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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

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
                .addGap(29, 29, 29)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MaMau)
                    .addComponent(tenMau, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenMau3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenMau1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenMau4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaLoaiThit)
                    .addComponent(txtTenLoaiThit)
                    .addComponent(txtGiaTheoKG)
                    .addComponent(txtHSD)
                    .addComponent(cboThit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MaMau)
                    .addComponent(txtMaLoaiThit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tenMau4)
                    .addComponent(cboThit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(186, 79, 84));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jPanel10.setPreferredSize(new java.awt.Dimension(324, 90));

        btnThemLoaiThit.setBackground(new java.awt.Color(186, 79, 84));
        btnThemLoaiThit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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
        btnSuaLoaiThit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSuaLoaiThit.setForeground(new java.awt.Color(187, 187, 187));
        btnSuaLoaiThit.setText("Sửa");
        btnSuaLoaiThit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaLoaiThitActionPerformed(evt);
            }
        });

        btnClearLoaiThit.setBackground(new java.awt.Color(186, 79, 84));
        btnClearLoaiThit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemLoaiThit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSuaLoaiThit)
                .addContainerGap())
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(btnClearLoaiThit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnClearLoaiThit, btnSuaLoaiThit, btnThemLoaiThit});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemLoaiThit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaLoaiThit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClearLoaiThit)
                .addContainerGap())
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnClearLoaiThit, btnSuaLoaiThit, btnThemLoaiThit});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 38, Short.MAX_VALUE))
        );

        Tab.addTab("Loại Thịt", jPanel3);

        jPanel14.setBackground(new java.awt.Color(186, 79, 84));

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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(MaMau3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MaMau2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tenMau2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtMaThit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMoTaThit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTenThit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MaMau2)
                    .addComponent(txtMaThit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenThit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MaMau3))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tenMau2)
                    .addComponent(txtMoTaThit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(186, 79, 84));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jPanel17.setPreferredSize(new java.awt.Dimension(324, 90));

        btnThemThit.setBackground(new java.awt.Color(186, 79, 84));
        btnThemThit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThemThit.setForeground(new java.awt.Color(187, 187, 187));
        btnThemThit.setText("Thêm");
        btnThemThit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemThitActionPerformed(evt);
            }
        });

        btnSuaThit.setBackground(new java.awt.Color(186, 79, 84));
        btnSuaThit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSuaThit.setForeground(new java.awt.Color(187, 187, 187));
        btnSuaThit.setText("Sửa");
        btnSuaThit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaThitActionPerformed(evt);
            }
        });

        btnClearThit.setBackground(new java.awt.Color(186, 79, 84));
        btnClearThit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addComponent(btnThemThit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuaThit)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addComponent(btnClearThit)
                        .addGap(82, 82, 82))))
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnClearThit, btnSuaThit, btnThemThit});

        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThemThit, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnSuaThit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClearThit)
                .addContainerGap())
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnClearThit, btnSuaThit, btnThemThit});

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 38, Short.MAX_VALUE))
        );

        Tab.addTab("Thịt", jPanel14);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Tab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Tab, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemHopThitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHopThitActionPerformed
        if(chk()){
            if(HT_Service.getHTByMa(txtMaHopThit.getText()) != null){
                JOptionPane.showMessageDialog(this, "Đã Có Mã Hộp Thịt Này Trong DATABASE", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                HT_Service.add(getHopThit());
                loadTableHopThit();
                clear();
                JOptionPane.showMessageDialog(this, "Thêm thành công");
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
            } else {
                JOptionPane.showMessageDialog(this, "Không Tồn Tại Loại Thịt Này Trong DATABASE", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSuaHopThitActionPerformed

    private void btnClearHopThitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearHopThitActionPerformed
        clear();
    }//GEN-LAST:event_btnClearHopThitActionPerformed

    private void tblHopThitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHopThitMouseClicked
        int index = tblHopThit.getSelectedRow();
        show(index);
    }//GEN-LAST:event_tblHopThitMouseClicked

    private void tblLoaiThitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiThitMouseClicked
        int index = tblLoaiThit.getSelectedRow();
        show(index);
    }//GEN-LAST:event_tblLoaiThitMouseClicked

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
                clear();
                JOptionPane.showMessageDialog(this, "Thêm thành công");
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
            } else {
                JOptionPane.showMessageDialog(this, "Không Tồn Tại Loại Thịt Này Trong DATABASE", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSuaLoaiThitActionPerformed

    private void btnClearLoaiThitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearLoaiThitActionPerformed
        clear();
    }//GEN-LAST:event_btnClearLoaiThitActionPerformed

    private void TabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabMouseClicked
        
    }//GEN-LAST:event_TabMouseClicked

    private void txtMaHopThitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHopThitActionPerformed
        
    }//GEN-LAST:event_txtMaHopThitActionPerformed

    private void btnClearThitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearThitActionPerformed
        clear();
    }//GEN-LAST:event_btnClearThitActionPerformed

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
                clear();
                JOptionPane.showMessageDialog(this, "Thêm thành công");
            }
        }
    }//GEN-LAST:event_btnThemThitActionPerformed

    private void tblThitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThitMouseClicked
        int index = tblThit.getSelectedRow();
        show(index);
    }//GEN-LAST:event_tblThitMouseClicked

    private void btnThemLoaiThitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemLoaiThitMouseClicked
        
    }//GEN-LAST:event_btnThemLoaiThitMouseClicked

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
            java.util.logging.Logger.getLogger(SanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SanPham().setVisible(true);
            }
        });
    }

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
