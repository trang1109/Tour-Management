package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import dao.KhachHang_DAO;
import entity.HoaDon;

public class Frm_ThongTinHoaDonDatTour extends JFrame implements ActionListener {
	private JLabel lblTieuDe;
	private JLabel lblTieuDe1;
	private JLabel lblMaDon;
	private JLabel lblMaTour;
	private JLabel lblTenKH;
	private JLabel lblSLNguoiLon;
	private JLabel lblNgayDat;
	private JLabel lblSLTreCon;
	private JLabel lblTrangThai;
	private JLabel lblTongTien;
	private JTextField txtMaDon;
	private JTextField txtMaTour;
	private JTextField txtTenKH;
	private JTextField txtSLNguoiLon;
	private JTextField txtNgayDat;
	private JTextField txtSLTreCon;
	private JComboBox cbbTrangThai;
	private JTextField txtTongTien;
	private JButton btnDong;
	private JLabel lblNhanVien;
	private JLabel lblPhuongThucThanhToan;
	private JTextField txtNhanVien;
	private JTextField txtPhuongThuc;
	private KhachHang_DAO khachHang_DAO;
	private DecimalFormat df;
	private JTextField txtTrangThai;

	public Frm_ThongTinHoaDonDatTour() throws IOException{
		setTitle("Thông Tin Đơn Đặt");
		setSize(780, 300);
		setLocationRelativeTo(null);
		khachHang_DAO = new KhachHang_DAO();
		df = new DecimalFormat("#,##0.00");
		buildUI();
	}
	
	private void buildUI() {
		JPanel pnlNorth;
		add(pnlNorth = new JPanel(), BorderLayout.NORTH);
		pnlNorth.setLayout(new BoxLayout(pnlNorth, BoxLayout.Y_AXIS));
		Box b= Box.createVerticalBox();
		Box b1,b2;
		lblTieuDe = new JLabel("Hình Ảnh");
		
		lblTieuDe1 = new JLabel("Thông Tin Đơn Đặt");
		lblTieuDe1.setFont(new Font("Time New Roman", Font.BOLD, 30));
		b.add(b1 =Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(250));
		b1.add(lblTieuDe);
		b.add(b2 =Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(250));
		b2.add(lblTieuDe1);
		pnlNorth.add(b1);
		pnlNorth.add(b2);

		
		JPanel pnlCenter;
		add(pnlCenter = new JPanel(), BorderLayout.CENTER);
		
		pnlCenter.setPreferredSize(new Dimension(0,200));
		pnlCenter.setBorder(BorderFactory.createTitledBorder("Thông Tin"));
		pnlCenter.setLayout(null);

		pnlCenter.add(lblMaDon = new JLabel("Mã Đơn: "));
		pnlCenter.add(lblMaTour = new JLabel("Mã Tour: "));
		pnlCenter.add(lblTenKH = new JLabel("Tên Khách Hàng: "));
		pnlCenter.add(lblSLNguoiLon = new JLabel("Số Lượng Người Lớn: "));
		pnlCenter.add(lblNgayDat = new JLabel("Ngày Đặt: "));
		pnlCenter.add(lblSLTreCon = new JLabel("Số Lượng Trẻ Con: "));
		pnlCenter.add(lblTrangThai = new JLabel("Trạng Thái: "));
		pnlCenter.add(lblTongTien = new JLabel("Tổng Tiền: "));
		pnlCenter.add(lblNhanVien = new JLabel("Mã nhân Viên"));
		pnlCenter.add(lblPhuongThucThanhToan = new JLabel("Phương Thức"));
		pnlCenter.add(txtMaDon = new JTextField());
		pnlCenter.add(txtMaTour = new JTextField());
		pnlCenter.add(txtTenKH = new JTextField());
		pnlCenter.add(txtSLNguoiLon = new JTextField());
		pnlCenter.add(txtNgayDat = new JTextField());
		pnlCenter.add(txtSLTreCon = new JTextField());
		pnlCenter.add(txtNhanVien = new JTextField());
		pnlCenter.add(txtPhuongThuc = new JTextField());
		
		txtMaDon.setEditable(false);
		txtMaTour.setEditable(false);
		txtNgayDat.setEditable(false);
		txtNhanVien.setEditable(false);
		txtPhuongThuc.setEditable(false);
		txtSLNguoiLon.setEditable(false);
		txtSLTreCon.setEditable(false);
		txtTenKH.setEditable(false);
		
		pnlCenter.add(txtTrangThai = new JTextField());
		pnlCenter.add(txtTongTien = new JTextField());
		txtTongTien.setEditable(false);
		txtTrangThai.setEditable(false);
 
		int w1 = 150, w2 = 200, h = 20;
		lblMaDon.setBounds(20, 27, w1, h);
		txtMaDon.setBounds(130, 27, w2, h);
		lblMaTour.setBounds(400, 27, w1, h);
		txtMaTour.setBounds(540, 27, w2, h);

		lblTenKH.setBounds(20, 52, w1, h);
		txtTenKH.setBounds(130, 52, w2, h);
		lblNhanVien.setBounds(400, 52, w1, h);
		txtNhanVien.setBounds(540, 52, w2, h);

		lblNgayDat.setBounds(20, 77, w1, h);
		txtNgayDat.setBounds(130, 77, w2, h);
		lblSLTreCon.setBounds(400, 77, w1, h);
		txtSLTreCon.setBounds(540, 77, w2, h);

		lblTrangThai.setBounds(20, 102, w1, h);
		txtTrangThai.setBounds(130, 102, w2, h);
		lblSLNguoiLon.setBounds(400, 102, w1, h);
		txtSLNguoiLon.setBounds(540, 102, w2, h);
		
		
		lblPhuongThucThanhToan.setBounds(20, 127, w1, h);
		txtPhuongThuc.setBounds(130, 127, w2, h);
		lblTongTien.setBounds(400, 127, w1, h);
		txtTongTien.setBounds(540, 127, w2, h);
		
		
		
		JPanel pnlSouth;
		add(pnlSouth = new JPanel(), BorderLayout.SOUTH);
		btnDong = new JButton("Đóng", new ImageIcon("img\\close.png"));
		btnDong.setForeground(Color.WHITE);
		btnDong.setBackground(new Color(224, 37, 37));
		btnDong.setToolTipText("Đóng");
		pnlSouth.add(btnDong);
		
		btnDong.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnDong)) {
			this.dispose();
		}
	}
	public void setEditData(HoaDon hoaDon) {
		// TODO Auto-generated method stub
		txtMaDon.setText(hoaDon.getMaHoaDon());
		txtMaTour.setText(hoaDon.getTour().getMaTour());
		txtTenKH.setText(khachHang_DAO.searchKhachHangTheoMa(hoaDon.getKhachHang().getMaKhachHang()).getTenKhachHang());
		txtNhanVien.setText(hoaDon.getNhanVien().getMaNhanvien());
		txtNgayDat.setText(String.valueOf(hoaDon.getNgayDat()));
		txtSLNguoiLon.setText(String.valueOf(hoaDon.getSoLuongNguoiLon()));
		txtSLTreCon.setText(String.valueOf(hoaDon.getSoLuongTreEm()));
		txtPhuongThuc.setText(hoaDon.getPhuongThucThanhToan());
		boolean tt = hoaDon.isTrangThai();
		if (tt == true) {
			txtTrangThai.setText("Đã thanh toán");
		} else if(tt==false)
			txtTrangThai.setText("Chưa thanh toán");
		txtTongTien.setText(df.format(hoaDon.getTongTien()));
	}
}