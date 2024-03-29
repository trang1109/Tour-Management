package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.spi.DateFormatProvider;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.DateFormatter;

import dao.PhuongTien_DAO;
import dao.Tour_DAO;
import entity.PhuongTien;
import entity.Tour;

public class Frm_ThemTour extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaTour;
	private JTextField txtTenTour;
	private JTextField txtDiaChiDen;
	private JTextField txtThoiGianXuatPhat;
	private JTextField txtThoiGian;
	private JTextField txtSoLuongKhach;
	private JComboBox<String> cbxPhuongTienDiChuyen;
	private JTextField txtGiaTour;
	private JTextArea txtChiTietTour;
	private DefaultComboBoxModel<String> cbxMode;

	private JLabel lblMaTour;
	private JLabel lblTenTour;
	private JLabel lblDiaChiDen;
	private JLabel lblThoiGianXuatPhat;
	private JLabel lblPhuongTienDiChuyen;
	private JLabel lblThoiGian;
	private JLabel lblSoLuongKhach;
	private JLabel lblGiaTour;
	private JLabel lblChiTietTour;

	private JButton btnLuu;
	private JButton btnDong;
	private JLabel lbltitle;
	private JLabel lblDiemXuatPhat;
	private JLabel lblTrangThai;
	private JTextField txtTrangThai;
	private JTextField txtDiemXuatPhat;
	private ArrayList<PhuongTien> listPhuongTien;
	private PhuongTien_DAO phuongTien_DAO;
	private Frm_Tour frm_Tour;
	private JComboBox<String> cbxTrangThai;
	private DefaultComboBoxModel<String> cbxTTModel;
	private Tour_DAO tour_DAO;

	public Frm_ThemTour(JPanel panel, boolean modal) {
		frm_Tour = new Frm_Tour();
		frm_Tour = (Frm_Tour) panel;
		phuongTien_DAO = new PhuongTien_DAO();
		tour_DAO = new Tour_DAO();
		listPhuongTien = new ArrayList<PhuongTien>();
		listPhuongTien = phuongTien_DAO.getAllPhuongTien();
		
		this.setTitle("Thêm Tour");
		this.setSize(950, 850);
		this.setLocationRelativeTo(null);
		this.setResizable(false);	
		
		add(lbltitle = new JLabel("Thêm tour", SwingConstants.CENTER), BorderLayout.NORTH);
		lbltitle.setFont(new Font("Time New Roman", Font.BOLD, 35));
		lbltitle.setForeground(Color.red);
		
		lblMaTour = new JLabel("Mã Tour: ");
		lblMaTour.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		lblTenTour = new JLabel("Tên tour: ");
		lblTenTour.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		lblDiaChiDen = new JLabel("Địa chỉ đến: ");
		lblDiaChiDen.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		lblThoiGianXuatPhat = new JLabel("Thời gian xuất phát: ");
		lblThoiGianXuatPhat.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		lblPhuongTienDiChuyen = new JLabel("Phương tiện di chuyển: ");
		lblPhuongTienDiChuyen.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		lblThoiGian = new JLabel("Thời gian: ");
		lblThoiGian.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		lblSoLuongKhach = new JLabel("Số lượng khách: ");
		lblSoLuongKhach.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		lblGiaTour = new JLabel("Giá tour: ");
		lblGiaTour.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		lblChiTietTour = new JLabel("Chi tiết tour: ");
		lblChiTietTour.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		lblDiemXuatPhat = new JLabel("Điểm xuất phát: ");
		lblDiemXuatPhat.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		lblTrangThai = new JLabel("Trạng thái: ");
		lblTrangThai.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		

		txtMaTour = new JTextField(5);
		txtMaTour.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		txtTenTour = new JTextField(5);
		txtTenTour.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		txtDiaChiDen = new JTextField(5);
		txtDiaChiDen.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		txtThoiGianXuatPhat = new JTextField(5);
		txtThoiGianXuatPhat.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		txtThoiGian = new JTextField(5);
		txtThoiGian.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		txtSoLuongKhach = new JTextField(5);
		txtSoLuongKhach.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		txtGiaTour = new JTextField(5);
		txtGiaTour.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		txtDiemXuatPhat = new JTextField(5);
		txtDiemXuatPhat.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		txtTrangThai = new JTextField(5);
		txtTrangThai.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		
		txtChiTietTour = new JTextArea(20, 20);
		txtChiTietTour.setLineWrap(true);
		txtChiTietTour.setFont(new Font("Time New Roman", Font.PLAIN, 20));

		cbxPhuongTienDiChuyen = new JComboBox<String>();
		cbxMode = new DefaultComboBoxModel<String>();
		cbxPhuongTienDiChuyen = new JComboBox<String>(cbxMode);
		for (PhuongTien pt : listPhuongTien) {
			cbxMode.addElement(pt.getMaPhuongTien());
		}
		cbxPhuongTienDiChuyen.setPreferredSize(new Dimension(200, 5));
		
		cbxTrangThai = new JComboBox<String>();
		cbxTTModel = new DefaultComboBoxModel<String>();
		cbxTrangThai = new JComboBox<String>(cbxTTModel);
		cbxTTModel.addElement("Còn chỗ");
		cbxTTModel.addElement("Hết chỗ");
		cbxTrangThai.setPreferredSize(new Dimension(200, 5));
		

		btnLuu = new JButton("Lưu", new ImageIcon("img\\save.png"));
		btnLuu.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		//btnLuu.setPreferredSize(new Dimension(100, 30));
		btnLuu.setToolTipText("Lưu thông tin tour");
		
		btnDong = new JButton("Đóng" , new ImageIcon("img\\close.png"));
		btnDong.setFont(new Font("Time New Roman", Font.PLAIN, 20));
		//btnDong.setPreferredSize(new Dimension(100, 30));
		btnDong.setToolTipText("Đóng");
		btnLuu.setPreferredSize(btnDong.getPreferredSize());

//		JPanel p = new JPanel();
//		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		Box p = Box.createVerticalBox();

		Box b1 = Box.createHorizontalBox();
		b1.add(lblMaTour);
		b1.add(Box.createRigidArea(new Dimension(35, 5)));
		b1.add(txtMaTour);
		b1.add(Box.createRigidArea(new Dimension(35, 5)));
		b1.add(lblDiaChiDen);
		b1.add(Box.createRigidArea(new Dimension(35, 5)));
		b1.add(txtDiaChiDen);

		p.add(Box.createRigidArea(new Dimension(20, 20)));
		p.add(b1);
		p.add(Box.createRigidArea(new Dimension(10, 10)));

		Box b2 = Box.createHorizontalBox();
		b2.add(lblTenTour);
		b2.add(Box.createRigidArea(new Dimension(35, 5)));
		b2.add(txtTenTour);
		b2.add(Box.createRigidArea(new Dimension(35, 5)));
		b2.add(lblDiemXuatPhat);
		b2.add(Box.createRigidArea(new Dimension(35, 5)));
		b2.add(txtDiemXuatPhat);

		p.add(b2);
		p.add(Box.createRigidArea(new Dimension(10, 10)));

		Box b3 = Box.createHorizontalBox();
		b3.add(lblThoiGianXuatPhat);
		b3.add(Box.createRigidArea(new Dimension(35, 5)));
		b3.add(txtThoiGianXuatPhat);
		b3.add(Box.createRigidArea(new Dimension(35, 5)));
		b3.add(lblSoLuongKhach);
		b3.add(Box.createRigidArea(new Dimension(35, 5)));
		b3.add(txtSoLuongKhach);

		p.add(b3);
		p.add(Box.createRigidArea(new Dimension(10, 10)));

		Box b4 = Box.createHorizontalBox();
		b4.add(lblThoiGian);
		b4.add(Box.createRigidArea(new Dimension(35, 5)));
		b4.add(txtThoiGian);
		b4.add(Box.createRigidArea(new Dimension(35, 5)));
		b4.add(lblPhuongTienDiChuyen);
		b4.add(Box.createRigidArea(new Dimension(35, 5)));
		b4.add(cbxPhuongTienDiChuyen);
		
		p.add(b4);
		p.add(Box.createRigidArea(new Dimension(10, 10)));
		
		Box b7 = Box.createHorizontalBox();
		b7.add(lblGiaTour);
		b7.add(Box.createRigidArea(new Dimension(35, 5)));
		b7.add(txtGiaTour);
		b7.add(Box.createRigidArea(new Dimension(35, 5)));
		b7.add(lblTrangThai);
		b7.add(Box.createRigidArea(new Dimension(35, 5)));
		b7.add(cbxTrangThai);
		
		p.add(b7);
		p.add(Box.createRigidArea(new Dimension(10, 10)));

		Box b5 = Box.createHorizontalBox();
		b5.add(lblChiTietTour);
		b5.add(Box.createRigidArea(new Dimension(750, 0)));
		Box b6 = Box.createHorizontalBox();
		b6.add(new JScrollPane(txtChiTietTour));
		b6.add(Box.createRigidArea(new Dimension(0, 150)));

		//p.add(Box.createRigidArea(new Dimension(40, 40)));
		p.add(b5);
		p.add(Box.createRigidArea(new Dimension(10, 10)));
		p.add(b6);
		p.add(Box.createRigidArea(new Dimension(20, 20)));

		lblMaTour.setPreferredSize(lblPhuongTienDiChuyen.getPreferredSize());
		lblTenTour.setPreferredSize(lblPhuongTienDiChuyen.getPreferredSize());
		lblThoiGianXuatPhat.setPreferredSize(lblPhuongTienDiChuyen.getPreferredSize());
		lblThoiGian.setPreferredSize(lblPhuongTienDiChuyen.getPreferredSize());
		lblDiaChiDen.setPreferredSize(lblPhuongTienDiChuyen.getPreferredSize());
		lblSoLuongKhach.setPreferredSize(lblPhuongTienDiChuyen.getPreferredSize());
		//lblPhuongTienDiChuyen.setPreferredSize(lblPhuongTienDiChuyen.getPreferredSize());
		lblGiaTour.setPreferredSize(lblPhuongTienDiChuyen.getPreferredSize());
		lblChiTietTour.setPreferredSize(lblPhuongTienDiChuyen.getPreferredSize());
		lblDiemXuatPhat.setPreferredSize(lblPhuongTienDiChuyen.getPreferredSize());
		lblTrangThai.setPreferredSize(lblPhuongTienDiChuyen.getPreferredSize());
		
		
		JPanel pBottom = new JPanel();
		pBottom.add(btnLuu);
		pBottom.add(btnDong);
		btnLuu.setBackground(new Color(42, 175, 45));
		btnLuu.setForeground(Color.WHITE);
		btnDong.setBackground(new Color(224, 37, 37));
		btnDong.setForeground(Color.WHITE);

		Box bTop = Box.createVerticalBox();
		bTop.setBorder(BorderFactory.createTitledBorder("Thông tin tour"));
		bTop.add(p);

		Box bN = Box.createVerticalBox();
		bN.add(bTop);
		bN.add(pBottom);

		add(bN, BorderLayout.CENTER);
		bN.setPreferredSize(new Dimension(0, 500));

		btnLuu.addActionListener(this);
		btnDong.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnDong)) {
			this.dispose();
		}
		else if(obj.equals(btnLuu)) {
			ArrayList<Tour> lstTour = tour_DAO.getAllTour();
			if(checkDieuKien()) {
				Tour t = gianGiaTri();
				if(!lstTour.contains(t)) {
					frm_Tour.addTour(t);
					this.dispose();
				}
				else 
					JOptionPane.showConfirmDialog(null, "Trùng mã tour", "Thông báo", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
	private Tour gianGiaTri() {
		String ma = txtMaTour.getText();
		String ten = txtTenTour.getText();
		String diemDi = txtDiemXuatPhat.getText();
		String diemDen = txtDiaChiDen.getText();
		Date ngayDi = Date.valueOf(txtThoiGianXuatPhat.getText());
		String thoiGian = txtThoiGian.getText();
		int sl = Integer.parseInt(txtSoLuongKhach.getText());
		Double gia = Double.parseDouble(txtGiaTour.getText());
		String moTa = txtChiTietTour.getText();
		String trangThai =(String) cbxTrangThai.getSelectedItem();
		boolean bl;
		if(trangThai.equals("Còn chỗ")) {
			bl = false;
		}
		else bl = true;
		PhuongTien maPt = new PhuongTien((String)cbxMode.getSelectedItem());
		return new Tour(ma, ten, diemDi, diemDen, ngayDi, thoiGian, sl, gia, bl, moTa, maPt);
	}
	private boolean checkDieuKien() {
		String ma = txtMaTour.getText().trim();
		String ten = txtTenTour.getText().trim();
		String diemDi = txtDiemXuatPhat.getText().trim();
		String diemDen = txtDiaChiDen.getText().trim();
		String ngayDi = txtThoiGianXuatPhat.getText().trim();
		String thoiGian = txtThoiGian.getText().trim();
		String sl = txtSoLuongKhach.getText().trim();
		String gia = txtGiaTour.getText().trim();
		String moTa = txtChiTietTour.getText().trim();
		if(!(ma.length() > 0 && ma.matches("^(T_)\\d+"))) {
			showError(txtMaTour, "Mã Tour phải bắt đầu bằng T_ theo sau ít nhất 1 chứ số");
			return false;
		}
		if(ten.length() <= 0) {
			showError(txtTenTour, "Tên khách hàng không được để trống");
			return false;
		}
		if(diemDen.length() <= 0) {
			showError(txtDiaChiDen, "Điểm đến không được để trống");
			return false;
		}
		if(diemDi.length() <= 0) {
			showError(txtDiemXuatPhat, "Điểm xuất phát không được để trống");
			return false;
		}
		if(ngayDi.length() > 0) {
			try {
				Date khoihanh = Date.valueOf(ngayDi);
				if(khoihanh.before(Date.valueOf(LocalDate.now()))) {
					showError(txtThoiGianXuatPhat, "Thời gian khỏi hành phải sau thời điểm hiện tại");
					return false;
				}
				
			} catch (IllegalArgumentException e) {
				showError(txtThoiGianXuatPhat, "Phải đúng cú pháp yyyy-MM-dd");
				return false;
			}
		}
		else {
			showError(txtThoiGianXuatPhat, "Ngày đi không được để trống");
			return false;
		}
		if(thoiGian.length() <= 0) {
			showError(txtThoiGian, "Thời gian đi không được để trống");
			return false;
		}
		if(sl.length() > 0) {
			try {
				int SL = Integer.parseInt(sl);
				if(SL < 0 || SL > 50) {
					showError(txtSoLuongKhach, "Số lượng khách phải lớn hơn 0 và nhỏ hơn 50");
					return false;
				}
				
			} catch (NumberFormatException e) {
				showError(txtSoLuongKhach, "Số lượng khách quy định phải là số nguyên");
				return false;
			}
		}
		if(gia.length() > 0) {
			try {
				double Gia = Double.parseDouble(gia);
				if(Gia < 0 ) {
					showError(txtGiaTour, "Giá của một Tour phải lớn hơn 0");
					return false;
				}
				
			} catch (NumberFormatException e) {
				showError(txtGiaTour, "Giá tour phải là số thực");
				return false;
			}
		}
		if(moTa.length() <= 0) {
			txtChiTietTour.requestFocus();
			JOptionPane.showConfirmDialog(null, "Chương trình Tour không được để trống", "Báo lỗi", JOptionPane.ERROR_MESSAGE);
		}
		return true;
	}
	private void showError(JTextField txt, String mess) {
		txt.requestFocus();
		JOptionPane.showConfirmDialog(null, mess, "Báo lỗi", JOptionPane.ERROR_MESSAGE);
	}
}
