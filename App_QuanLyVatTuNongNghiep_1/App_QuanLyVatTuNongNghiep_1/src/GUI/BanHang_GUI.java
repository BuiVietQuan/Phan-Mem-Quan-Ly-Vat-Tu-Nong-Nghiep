/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import Model.ArrayLists;
import Model.ChiTietHoaDon;
import Model.ChiTietLoaiHang;
import Model.ColorCustom;
import Model.DBQuanLyVatTuNongNghiep;
import Model.GiaMatHang;
import Model.HangHoa;
import Model.HoaDon;
import Model.LoaiHang;
import Model.NhanVien;
import com.sun.javafx.geom.Vec2d;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Optional;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import table.TableCustom;

/**
 *
 * @author Admin
 */
public class BanHang_GUI extends javax.swing.JPanel {

    /**
     * Creates new form BanHang
     */
    DefaultTableModel dtm =null;
    DBQuanLyVatTuNongNghiep db;
    NhanVien user;
    DefaultTableModel dtm_bangGia = null;
    Vector header_bangGia = null;
    int idxSua = -1;
    int ThanhTien = 0;
    public BanHang_GUI(DBQuanLyVatTuNongNghiep db, NhanVien user) {
        this.db = db;
        this.user = user;
        initComponents();              
        db.getLoaiHangs().forEach(t->cbo_loaiHang.addItem(t.getTenLoaiHang()));  
        dtm = new DefaultTableModel();
        tbl_chiTietHoaDon.setModel(dtm);        
        Vector header = new Vector();
        header.add("Mã");
        header.add("Tên sản phẩm");
        header.add("Loại");
        header.add("Đơn giá");
        header.add("Số lượng");
        header.add("Tổng tiền");
        dtm.setColumnIdentifiers(header);   
        btn_huy.setEnabled(false);
        btn_xoa.setEnabled(false);
        //tbl_chiTietHoaDon.setEditingRow(0);
        
        header_bangGia = new Vector();
        header_bangGia.add("Giá bán");
        header_bangGia.add("Số lượng tối thiểu");
        dtm_bangGia = new DefaultTableModel();
        dtm_bangGia.setColumnIdentifiers(header_bangGia);
        tbl_bangGia.setModel(dtm_bangGia);
        tbl_bangGia.setEnabled(false);
        
        
        txt_soHoaDon.setEditable(false);
        txt_soHoaDon.setText(taoSoHoaDonMoi());
        label_thanhTien.setText("0đ");
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        TableCustom.apply(jScrollPane2, TableCustom.TableType.MULTI_LINE);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboSuggestionUI1 = new combo_suggestion.ComboSuggestionUI();
        comboSuggestionUI2 = new combo_suggestion.ComboSuggestionUI();
        jLabel1 = new javax.swing.JLabel();
        label_soluongtonkho = new javax.swing.JLabel();
        btn_taoHoaDon = new javax.swing.JButton();
        txt_soLuong = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_cong = new javax.swing.JButton();
        btn_tru = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        label_thanhTien = new javax.swing.JLabel();
        cbo_loaiHang = new combo_suggestion.ComboBoxSuggestion();
        cbo_sanPham = new combo_suggestion.ComboBoxSuggestion();
        cbo_loaiSanPham = new combo_suggestion.ComboBoxSuggestion();
        btn_capnhat = new button.Button();
        btn_xoa = new button.Button();
        btn_huy = new button.Button();
        txt_soHoaDon = new textfield_2.TextField();
        btn_lammoi = new button.Button();
        tableScrollButton1 = new table.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_chiTietHoaDon = new javax.swing.JTable();
        tableScrollButton2 = new table.TableScrollButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bangGia = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1500, 1000));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jLabel1.setText("Số lượng tồn:");

        label_soluongtonkho.setText("1");

        btn_taoHoaDon.setBackground(new java.awt.Color(45, 153, 174));
        btn_taoHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_taoHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btn_taoHoaDon.setText("Tạo hóa đơn");
        btn_taoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoHoaDonActionPerformed(evt);
            }
        });

        txt_soLuong.setText("1");
        txt_soLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soLuongActionPerformed(evt);
            }
        });
        txt_soLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_soLuongKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_soLuongKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_soLuongKeyTyped(evt);
            }
        });

        jLabel2.setText("Nhập số lượng:");

        btn_cong.setText("+");
        btn_cong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_congActionPerformed(evt);
            }
        });

        btn_tru.setText("-");
        btn_tru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_truActionPerformed(evt);
            }
        });

        jLabel3.setText("Bảng giá tương ứng");

        jLabel4.setText("Số hóa đơn:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setText("Thành tiền: ");

        label_thanhTien.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        label_thanhTien.setForeground(new java.awt.Color(255, 51, 51));
        label_thanhTien.setText("99999");

        cbo_loaiHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_loaiHangActionPerformed(evt);
            }
        });

        cbo_sanPham.setPreferredSize(new java.awt.Dimension(200, 32));
        cbo_sanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_sanPhamActionPerformed(evt);
            }
        });

        cbo_loaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_loaiSanPhamActionPerformed(evt);
            }
        });

        btn_capnhat.setBackground(new java.awt.Color(12, 87, 118));
        btn_capnhat.setForeground(new java.awt.Color(255, 255, 255));
        btn_capnhat.setText("Thêm");
        btn_capnhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhatActionPerformed(evt);
            }
        });

        btn_xoa.setBackground(new java.awt.Color(0, 28, 68));
        btn_xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_xoa.setText("Xóa");
        btn_xoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_huy.setText("Hủy");
        btn_huy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyActionPerformed(evt);
            }
        });

        btn_lammoi.setBackground(new java.awt.Color(248, 218, 208));
        btn_lammoi.setText("Làm mới");
        btn_lammoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_lammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lammoiActionPerformed(evt);
            }
        });

        tbl_chiTietHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbl_chiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_chiTietHoaDon.setRowHeight(40);
        tbl_chiTietHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_chiTietHoaDonMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_chiTietHoaDonMouseReleased(evt);
            }
        });
        tbl_chiTietHoaDon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_chiTietHoaDonKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_chiTietHoaDon);

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        tbl_bangGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbl_bangGia);

        tableScrollButton2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_thanhTien)
                        .addGap(1109, 1109, 1109)
                        .addComponent(btn_taoHoaDon)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_soHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbo_loaiHang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(31, 31, 31)
                                        .addComponent(label_soluongtonkho, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel2)
                                        .addGap(28, 28, 28)
                                        .addComponent(btn_tru)
                                        .addGap(0, 0, 0)
                                        .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(btn_cong))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbo_sanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbo_loaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_lammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE))
                                    .addComponent(tableScrollButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)))
                            .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(96, 96, 96))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_capnhat, btn_huy});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbo_loaiHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_sanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_loaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_soHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(label_soluongtonkho, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(btn_cong)
                            .addComponent(btn_tru)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_lammoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tableScrollButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(label_thanhTien)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(638, 638, 638)
                        .addComponent(btn_taoHoaDon)))
                .addContainerGap(159, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    ChiTietLoaiHang getChiTietLoaiHang(String tenHang,String tenLoaiSP)
    {
        return db.getChiTietLoaiHangs().get(t->t.getHangHoa().getTenHang()
                .equalsIgnoreCase(tenHang)&&t.getTenLoai().equalsIgnoreCase(tenLoaiSP));                
    }
    ChiTietLoaiHang getChiTietLoaiHang(String maCTLH)
    {
        return db.getChiTietLoaiHangs().get(t->t.getMaCTLH().equalsIgnoreCase(maCTLH));                
    }
    private void seteTxtSoLuong(boolean b)
    {
        txt_soLuong.setEnabled(b);
        btn_cong.setEnabled(b);
        btn_tru.setEnabled(b);
    }
    private void tbl_chiTietHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_chiTietHoaDonMouseClicked
        // TODO add your handling code here:        
        idxSua = tbl_chiTietHoaDon.getSelectedRow();
        btn_capnhat.setText("Cập nhật");
        btn_huy.setEnabled(true);        
        btn_xoa.setEnabled(true);
        btn_huy.setBackground(ColorCustom.TRANG);
        btn_xoa.setBackground(ColorCustom.XANH_CUC_DAM);
        Vector v = (Vector)dtm.getDataVector().get(idxSua);
        ChiTietLoaiHang ctlh = db.getChiTietLoaiHangs().get(t->t.getMaCTLH().equalsIgnoreCase(v.get(0).toString()));        
        for(int i = 0 ; i< cbo_loaiHang.getItemCount();i++)        
            if(cbo_loaiHang.getItemAt(i)==ctlh.getHangHoa().getLoaiHang().getTenLoaiHang())
            {
                cbo_loaiHang.setSelectedIndex(i);                
                break;
            }
        for(int i = 0;i<cbo_sanPham.getItemCount();i++)
            if(cbo_sanPham.getItemAt(i)==ctlh.getHangHoa().getTenHang())
            {
                cbo_sanPham.setSelectedIndex(i);
                break;
            }
        for(int i = 0;i<cbo_loaiSanPham.getItemCount();i++)
            if(cbo_loaiSanPham.getItemAt(i)==ctlh.getTenLoai())
            {
                cbo_loaiSanPham.setSelectedIndex(i);
                break;
            }       
    }//GEN-LAST:event_tbl_chiTietHoaDonMouseClicked

    private void tbl_chiTietHoaDonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_chiTietHoaDonKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_UP||evt.getKeyCode() == KeyEvent.VK_DOWN)        
            tbl_chiTietHoaDonMouseClicked(null);        
    }//GEN-LAST:event_tbl_chiTietHoaDonKeyReleased

    private String taoSoHoaDonMoi()
    {        
        int sl = db.getHoaDons().size()+1;
        do
        {
            int slHD = db.getHoaDons().size();
            String sohd = "HD00"+String.valueOf(slHD+sl++);    
            if(db.getHoaDons().get(t->t.getSoHoaDon().equalsIgnoreCase(sohd)) == null)                
                return sohd;                
        } while(true);             
    }
    
    private void btn_taoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoHoaDonActionPerformed
        // TODO add your handling code here:        
//        Calendar cal = Calendar.getInstance();
//        Date today = cal.getTime();
        //Timestamp tmp = new Timestamp
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");        
        if(dtm.getRowCount()==0)
        {
            JOptionPane.showMessageDialog(this, "Cần phải có ít nhất 1 chi tiết hóa đơn!!!"); 
            return ;
            
        }
        if(JOptionPane.showConfirmDialog(this, "Xác nhận tạo hóa đơn","Thông báo",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
        {
            String soHoaDon = txt_soHoaDon.getText();
            HoaDon hdMoi = new HoaDon(soHoaDon,user.getMaNV(),"KH01");
            ArrayList<ChiTietHoaDon> cthds = new ArrayList<ChiTietHoaDon>();
            for (Object item : dtm.getDataVector()) {
                Vector v = (Vector) item;
                ChiTietHoaDon cthd = new ChiTietHoaDon(soHoaDon, (String) v.get(0), (int) v.get(4), (int) v.get(3));
                cthds.add(cthd);
            }
            hdMoi.setThanhTien(this.ThanhTien);
            if(db.getHoaDons().insert(hdMoi))
            {
                int thanhcong = db.getChiTietHoaDons().insert(cthds);
                if(thanhcong == cthds.size())                
                    JOptionPane.showMessageDialog(this, "Thao tác thành công");                                     
                else                
                    JOptionPane.showMessageDialog(this, thanhcong + " chi tiết hóa đơn đầu tiên được tạo!!!");                                    
                btn_lammoiActionPerformed(null);
                txt_soHoaDon.setText(taoSoHoaDonMoi());
                return;
            }
            JOptionPane.showMessageDialog(this, "Thao tác thất bại");
        }
    }//GEN-LAST:event_btn_taoHoaDonActionPerformed

    private void txt_soLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_soLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_soLuongActionPerformed

    private void txt_soLuongKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_soLuongKeyTyped
        // TODO add your handling code here:
        String strsl = txt_soLuong.getText();
        if(strsl.isEmpty() && evt.getKeyChar()=='0')        
            evt.consume();        
        else if(evt.getKeyChar()<'0' || evt.getKeyChar() > '9')
            evt.consume();
        else
        {            
                int slTon =Integer.parseInt(label_soluongtonkho.getText());
                int slInt = Integer.parseInt(strsl+String.valueOf(evt.getKeyChar()));
                if(slInt>slTon)            
                    evt.consume();                      
        }
    }//GEN-LAST:event_txt_soLuongKeyTyped

    private void btn_congActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_congActionPerformed
        // TODO add your handling code here:
        String strsl = txt_soLuong.getText();
        if(strsl.isEmpty())
            txt_soLuong.setText("1");
        else
        {
            int slTon =Integer.parseInt(label_soluongtonkho.getText());
            int sl = Integer.parseInt(strsl);
            if(sl<slTon)
                txt_soLuong.setText(String.valueOf(++sl));
        }
    }//GEN-LAST:event_btn_congActionPerformed

    private void btn_truActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_truActionPerformed
        // TODO add your handling code here:
        String strsl = txt_soLuong.getText();
        if(strsl.equals("1"))
            return;
        int sl = Integer.parseInt(strsl);
        txt_soLuong.setText(String.valueOf(--sl));
    }//GEN-LAST:event_btn_truActionPerformed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:        
    }//GEN-LAST:event_formKeyReleased

    private void txt_soLuongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_soLuongKeyReleased
        // TODO add your handling code here:        
    }//GEN-LAST:event_txt_soLuongKeyReleased

    private void txt_soLuongKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_soLuongKeyPressed
        // TODO add your handling code here:        
    }//GEN-LAST:event_txt_soLuongKeyPressed

    private void tbl_chiTietHoaDonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_chiTietHoaDonMouseReleased
        // TODO add your handling code here:
        if(tbl_chiTietHoaDon.isEditing())
        {
            int column = tbl_chiTietHoaDon.getSelectedColumn();
            tbl_chiTietHoaDon.getCellEditor(idxSua,column).cancelCellEditing();
        }
    }//GEN-LAST:event_tbl_chiTietHoaDonMouseReleased

    private void cbo_loaiHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_loaiHangActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        cbo_loaiSanPham.setSelectedIndex(-1);
        if(cbo_loaiHang.getSelectedIndex()<0)
        return;
        cbo_sanPham.removeAllItems();
        try
        {
            String tenLoai = cbo_loaiHang.getSelectedItem().toString();
            db.getLoaiHangs().get(t->t.getTenLoaiHang().equalsIgnoreCase(tenLoai)).getHangHoas().forEach(h->cbo_sanPham.addItem(h.getTenHang()));
            if(cbo_sanPham.getItemCount() == 0)
            JOptionPane.showMessageDialog(this, "Khôg tìm thấy những sản phẩm thuộc loại '"+tenLoai+"'!!!");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Đã xảy ra lỗi, vui lòng thử lại!!!");
        }
    }//GEN-LAST:event_cbo_loaiHangActionPerformed

    private void cbo_sanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_sanPhamActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here: 
        label_soluongtonkho.setText("0");
        seteTxtSoLuong(false);
        cbo_loaiSanPham.setSelectedIndex(-1);
        cbo_loaiSanPham.removeAllItems();                
        if(cbo_sanPham.getSelectedIndex()<0)
            return;        
        try{
            String tenSanPham;
            tenSanPham = cbo_sanPham.getSelectedItem().toString(); 
            db.getHangHoas().get(t->t.getTenHang().equalsIgnoreCase(tenSanPham)).getChiTietLoaiHangs().forEach(l->cbo_loaiSanPham.addItem(l.getTenLoai()));
            if(cbo_loaiSanPham.getItemCount()==0 && idxSua==-1)  
            {
                JOptionPane.showMessageDialog(this, "Khôg tìm thấy những phân loại của "+cbo_sanPham.getSelectedItem().toString());
            }
            cbo_loaiSanPhamActionPerformed(null);
        }catch(Exception e)
        {          
            JOptionPane.showMessageDialog(this,"Đã xảy ra lỗi, vui lòng thử lại!!!");            
        }        
    }//GEN-LAST:event_cbo_sanPhamActionPerformed

    private void cbo_loaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_loaiSanPhamActionPerformed
        // TODO add your handling code here:
         try
        {
            dtm_bangGia.setRowCount(0);
        }catch(Exception e){}
        try
        {
            ChiTietLoaiHang ctlh = getChiTietLoaiHang(cbo_sanPham.getSelectedItem().toString(),cbo_loaiSanPham.getSelectedItem().toString());            
            label_soluongtonkho.setText(String.valueOf(ctlh.getSoLuongTon()));
            dtm_bangGia.setDataVector(ctlh.getGiaMatHangs().getData("MaCTLH"), header_bangGia);
            Vector row = new Vector();
            row.add(ctlh.getGiaMacDinh());
            row.add(1);
            dtm_bangGia.insertRow(0, row);
        if(ctlh.getSoLuongTon()==0)
        {
            seteTxtSoLuong(false);
            btn_capnhat.setEnabled(false);
        }
        else
        {
            seteTxtSoLuong(true);
            btn_capnhat.setEnabled(true);            
        }            
        } catch(Exception e){}  
    }//GEN-LAST:event_cbo_loaiSanPhamActionPerformed

    private void btn_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhatActionPerformed
        // TODO add your handling code here:
          String strSL = txt_soLuong.getText();
        if(strSL.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Số lượng mua không được để trống!!!");            
            return;
        }
        int slTon =Integer.parseInt(label_soluongtonkho.getText());
        int sl = Integer.parseInt(strSL);  
        if(sl > slTon)
        {
            JOptionPane.showMessageDialog(this,"Số lượng mua vượt quá số lượng tồn!!!");                
            return;
        } 
        ChiTietLoaiHang ctlh = getChiTietLoaiHang(cbo_sanPham.getSelectedItem().toString(),cbo_loaiSanPham.getSelectedItem().toString());  
        int i = 0;
        for(Object item : dtm.getDataVector())
        {
            Vector v = (Vector)item;
            if(v.get(0)==ctlh.getMaCTLH())
            {              
                sl = idxSua == -1 ? (int) v.get(4)+sl:sl;
                if(sl > slTon)
                {
                    JOptionPane.showMessageDialog(this,"Số lượng mua vượt quá số lượng tồn!!!");                
                    return;
                } 
                v.set(4,sl);
                int gia = getGiaMatHang(ctlh,sl);
                ThanhTien += (gia*sl)-(int) v.get(5);
                v.set(3, gia); 
                v.set(5,gia*sl);                
                //trường hợp sửa
                if(idxSua != -1 && idxSua != i)
                {
                    ThanhTien -= (int) ((Vector)dtm.getDataVector().get(idxSua)).get(5);
                    dtm.removeRow(idxSua);                      
                }
                tbl_chiTietHoaDon.updateUI();
                btn_huyActionPerformed(null);
                label_thanhTien.setText(String.valueOf(ThanhTien)+"đ");
                return;
            }
            i ++;
        }
            int gia = getGiaMatHang(ctlh,sl);        
            Vector cthd = new Vector();
            cthd.add(ctlh.getMaCTLH());
            cthd.add(ctlh.getHangHoa().getTenHang());
            cthd.add(ctlh.getTenLoai());
            cthd.add(gia);
            cthd.add(sl);
            cthd.add(gia*sl); 
            ThanhTien+=(gia*sl);
            if(idxSua==-1)
                dtm.addRow(cthd);                
            else
            {                
                ThanhTien-= Integer.parseInt(dtm.getValueAt(idxSua, 5).toString());
                dtm.removeRow(idxSua);
                dtm.insertRow(idxSua, cthd);
                tbl_chiTietHoaDon.updateUI();
                btn_huyActionPerformed(null);
            }
            label_thanhTien.setText(String.valueOf(ThanhTien)+"đ");
    }//GEN-LAST:event_btn_capnhatActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        ThanhTien-= Integer.parseInt(dtm.getValueAt(idxSua, 5).toString());
        label_thanhTien.setText(String.valueOf(ThanhTien)+"đ");
        dtm.removeRow(idxSua);
        btn_huyActionPerformed(null);
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyActionPerformed
        // TODO add your handling code here:
        btn_capnhat.setText("Thêm");
        btn_xoa.setEnabled(false);
        btn_huy.setEnabled(false);
        idxSua = -1;
    }//GEN-LAST:event_btn_huyActionPerformed

    private void btn_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lammoiActionPerformed
        // TODO add your handling code here:
         dtm.setRowCount(0);
       label_thanhTien.setText("0đ");
        btn_huyActionPerformed(null);
        this.ThanhTien = 0;
    }//GEN-LAST:event_btn_lammoiActionPerformed
    int getGiaMatHang(ChiTietLoaiHang ctlh , int sl)
    {
        try
        {
            return ctlh.getGiaMatHangs().parallelStream().filter(t->t.getDieuKien()<=sl)
                    .sorted(Comparator.comparingInt(GiaMatHang::getDieuKien))
                    .max(Comparator.comparingInt(GiaMatHang::getDieuKien)).get().getGiaBan();
        }catch(Exception e)
        {
            return ctlh.getGiaMacDinh();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.Button btn_capnhat;
    private javax.swing.JButton btn_cong;
    private button.Button btn_huy;
    private button.Button btn_lammoi;
    private javax.swing.JButton btn_taoHoaDon;
    private javax.swing.JButton btn_tru;
    private button.Button btn_xoa;
    private combo_suggestion.ComboBoxSuggestion cbo_loaiHang;
    private combo_suggestion.ComboBoxSuggestion cbo_loaiSanPham;
    private combo_suggestion.ComboBoxSuggestion cbo_sanPham;
    private combo_suggestion.ComboSuggestionUI comboSuggestionUI1;
    private combo_suggestion.ComboSuggestionUI comboSuggestionUI2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_soluongtonkho;
    private javax.swing.JLabel label_thanhTien;
    private table.TableScrollButton tableScrollButton1;
    private table.TableScrollButton tableScrollButton2;
    private javax.swing.JTable tbl_bangGia;
    private javax.swing.JTable tbl_chiTietHoaDon;
    private textfield_2.TextField txt_soHoaDon;
    private javax.swing.JTextField txt_soLuong;
    // End of variables declaration//GEN-END:variables
}

