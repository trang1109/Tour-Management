package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.Tour_DAO;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Tour;

public class Frm_SuaHoaDonDatTour extends JDialog implements ActionListener {
	private JLabel lblMaDon;
	private JLabel lblMaTour;
	private JLabel lblTenKH;
	private JLabel lblSLNguoiLon;
	private JLabel lblNgayDat;
	private JLabel lblSLTreCon;
	private JLabel lblTrangThai;
	private JLabel lblTongTien;
	private JTextField txtMaDon;
	private JTextField txtTenKH;
	private JTextField txtMaTour;
	private JTextField txtSLNguoiLon;
	private JTextField txtNgayDat;
	private JTextField txtSLTreCon;
	private JTextField txtTongTien;
	private JButton btnLuu;
	private JButton btnDong;
	private JComboBox cbbTrangThai;
	private Container pnlNorth;
	private JLabel lblTieuDe;
	private Frm_HoaDonDatTour home_HD;
	private HoaDon_DAO dsHoaDon;
	private Frm_HoaDonDatTour frm_HD;
	private JLabel lblPhuongThuc;
	private JLabel lblNhanVien;
	private JTextField txtPhuongThuc;
	private JTextField txtNhanVien;
	private KhachHang_DAO khachHang_DAO;
	private DecimalFormat df;
	private Tour_DAO tour_DAO;
	private double tongTien;

	public Frm_SuaHoaDonDatTour(JPanel panel, boolean modal) {
		setTitle("Sửa Thông TIn Đặt Tour");
		setSize(780, 300);
		setLocationRelativeTo(null);
		df = new DecimalFormat("#,##0.00");
		
		khachHang_DAO = new KhachHang_DAO();
		tour_DAO = new Tour_DAO();
		
		frm_HD = new Frm_HoaDonDatTour();
		frm_HD =(Frm_HoaDonDatTour) panel;
		buildUI();
	}
	
	private void buildUI() {
		JPanel pnlNorth;
		add(pnlNorth = new JPanel(), BorderLayout.NORTH);
		lblTieuDe = new JLabel("Sửa thông tin đặt tour");
		lblTieuDe.setForeground(new Color(224, 37, 37));
		lblTieuDe.setFont(new Font("Time New Roman", Font.BOLD, 30));
		pnlNorth.add(lblTieuDe);
		
		JPanel pnlCenter;
		add(pnlCenter = new JPanel(), BorderLayout.CENTER);
		
		pnlCenter.setPreferredSize(new Dimension(0,200));
		pnlCenter.setBorder(BorderFactory.createTitledBorder("Thông Tin"));
		pnlCenter.setLayout(null);

		pnlCenter.add(lblMaDon = new JLabel("Mã Đơn: "));
		pnlCenter.add(lblMaTour = new JLabel("Mã Tour: "));
		pnlCenter.add(lblTenKH = new JLabel("Mã Khách Hàng: "));
		pnlCenter.add(lblSLNguoiLon = new JLabel("Số Lượng Người Lớn: "));
		pnlCenter.add(lblNgayDat = new JLabel("Ngày Đặt: "));
		pnlCenter.add(lblSLTreCon = new JLabel("Số Lượng Trẻ Con: "));
		pnlCenter.add(lblTrangThai = new JLabel("Trạng Thái: "));
		pnlCenter.add(lblTongTien = new JLabel("Tổng Tiền: "));
		pnlCenter.add(lblPhuongThuc = new JLabel("Phương Thức:"));
		pnlCenter.add(lblNhanVien = new JLabel("Mã nhân Viên:"));
		

		pnlCenter.add(txtMaDon = new JTextField());
		txtMaDon.setEditable(false);
		pnlCenter.add(txtMaTour = new JTextField());
		pnlCenter.add(txtTenKH = new JTextField());
		pnlCenter.add(txtSLNguoiLon = new JTextField());
		pnlCenter.add(txtNgayDat = new JTextField());
		pnlCenter.add(txtSLTreCon = new JTextField());
		pnlCenter.add(txtPhuongThuc = new JTextField());
		pnlCenter.add(txtNhanVien = new JTextField());
		cbbTrangThai= new JComboBox();
		cbbTrangThai.addItem("Chưa thanh toán");
		cbbTrangThai.addItem("Đã thanh toán");
		txtMaTour.setEditable(false);
		txtTenKH.setEditable(false);
		txtNhanVien.setEditable(false);
		pnlCenter.add(cbbTrangThai);
		pnlCenter.add(txtTongTien = new JTextField());
		txtTongTien.setEditable(false);

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
		cbbTrangThai.setBounds(130, 102, w2, h);
		lblSLNguoiLon.setBounds(400, 102, w1, h);
		txtSLNguoiLon.setBounds(540, 102, w2, h);
		
		
		lblPhuongThuc.setBounds(20, 127, w1, h);
		txtPhuongThuc.setBounds(130, 127, w2, h);
		lblTongTien.setBounds(400, 127, w1, h);
		txtTongTien.setBounds(540, 127, w2, h);
		
		JPanel pnlSouth;
		add(pnlSouth = new JPanel(), BorderLayout.SOUTH);
		btnLuu = new JButton("Lưu", new ImageIcon("img\\save.png"));
		btnLuu.setForeground(Color.WHITE);
		btnLuu.setBackground(new Color(42, 175, 45));
		btnLuu.setToolTipText("Lưu thông tin đặt tour");
		btnLuu.setFont(new Font("Time new roman", Font.BOLD, 20));
		
		pnlSouth.add(btnLuu);
		btnDong = new JButton("Đóng", new ImageIcon("img\\close.png"));
		btnDong.setForeground(Color.WHITE);
		btnDong.setBackground(new Color(224, 37, 37));
		btnDong.setToolTipText("Đóng");
		btnDong.setFont(new Font("time new roman", Font.BOLD, 20));
		btnLuu.setPreferredSize(btnDong.getPreferredSize());
		pnlSouth.add(btnDong);
		
		
		btnLuu.addActionListener(this);
		btnDong.addActionListener(this);
		txtSLNguoiLon.addActionListener(this);
		txtSLTreCon.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnDong)) {
			this.dispose();
		}
		if(txtSLNguoiLon.getText().length() > 0 && txtSLTreCon.getText().length() > 0) {
			tongTien = tinhTien(Integer.parseInt(txtSLNguoiLon.getText()), Integer.parseInt(txtSLTreCon.getText()));
			txtTongTien.setText(df.format(tongTien));
		}
		if (e.getSource().equals(btnLuu)) {
			String maHoaDon = txtMaDon.getText().trim();
			Tour tour = new Tour(lblMaTour.getText());
			KhachHang kh = new KhachHang(txtTenKH.getText());
			NhanVien nv = new NhanVien(txtNhanVien.getText());
			Date ngayDat = Date.valueOf(txtNgayDat.getText());
			int sLNguoiLon = Integer.parseInt(txtSLNguoiLon.getText());
			int sLTreCon = Integer.parseInt(txtSLTreCon.getText());
			String phuongThuc = txtPhuongThuc.getText().trim();
			double tien = tongTien;
			boolean tt = true;
			if (cbbTrangThai.equals("Đã thanh toán")) {
				tt = true;
			} else if(cbbTrangThai.equals("Chưa thanh toán"))
				tt = false;
			HoaDon hoaDonNew = new HoaDon(maHoaDon, tour, kh, nv, ngayDat, sLNguoiLon, sLNguoiLon, phuongThuc, tt, tien);
			frm_HD.suaThongTinHoaDon(hoaDonNew);
			JOptionPane.showMessageDialog(this, "Lưu thành công !");
			this.dispose();
		}
		
	}
	public void setEditData(HoaDon hoaDon) {
		// TODO Auto-generated method stub
		txtMaDon.setText(hoaDon.getMaHoaDon());
		txtMaTour.setText(hoaDon.getTour().getMaTour());
		txtTenKH.setText(hoaDon.getKhachHang().getMaKhachHang());
		txtNhanVien.setText(hoaDon.getNhanVien().getMaNhanvien());
		txtNgayDat.setText(String.valueOf(hoaDon.getNgayDat()));
		txtSLNguoiLon.setText(String.valueOf(hoaDon.getSoLuongNguoiLon()));
		txtSLTreCon.setText(String.valueOf(hoaDon.getSoLuongTreEm()));
		txtPhuongThuc.setText(hoaDon.getPhuongThucThanhToan());
		boolean tt = hoaDon.isTrangThai();
		if (tt == true) {
			cbbTrangThai.setSelectedItem("Đã thanh toán");
		} else
			cbbTrangThai.setSelectedItem("Chưa thanh toán");
		txtTongTien.setText(df.format(hoaDon.getTongTien()).toString());
	}
	private double tinhTien(int veLon, int veNho) {
		Tour t = tour_DAO.getTourTheoMa(txtMaTour.getText());
		double gia = t.getGia();
		return (veLon * gia) + (veNho * (gia * 0.5));
	}
}
