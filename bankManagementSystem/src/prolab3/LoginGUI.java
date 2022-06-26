package prolab3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import helper.DBHelper;
import model.MusteriMT;
import model.Musteri;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtMusteriTc;
	private JTextField txtMTTc;
	private JPasswordField txtMTSifre;
	private JPasswordField txtMusteriSifre;
	private DBHelper dbHelper=new DBHelper();
	private JTextField txtBMTc;
	private JPasswordField txtBMSifre;
	



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginGUI() throws SQLException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 566);
		contentPane = new JPanel();
		contentPane.setLocation(-43, -270);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(getClass().getResource("bank.png")));
		lblNewLabel.setBounds(290, 0, 166, 165);
		contentPane.add(lblNewLabel);
		
		JLabel lblHosgeldiniz = new JLabel("Banka Giri\u015F Sistemine Ho\u015F Geldiniz!");
		lblHosgeldiniz.setFont(new Font("Calibri", Font.BOLD, 21));
		lblHosgeldiniz.setBounds(41, 175, 376, 65);
		contentPane.add(lblHosgeldiniz);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(41, 250, 654, 269);
		contentPane.add(tabbedPane);
		
		JPanel panelMusteri = new JPanel();
		tabbedPane.addTab("Müþteri Giriþi", null, panelMusteri, null);
		panelMusteri.setLayout(null);
		
		JLabel lblMusteriTc = new JLabel("T.C. Numara:");
		lblMusteriTc.setFont(new Font("Calibri", Font.BOLD, 21));
		lblMusteriTc.setBounds(40, 10, 125, 65);
		panelMusteri.add(lblMusteriTc);
		
		JLabel lblMusteriSifre = new JLabel("Þifre:");
		lblMusteriSifre.setFont(new Font("Calibri", Font.BOLD, 21));
		lblMusteriSifre.setBounds(40, 85, 63, 65);
		panelMusteri.add(lblMusteriSifre);
		
		txtMusteriTc = new JTextField();
		txtMusteriTc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMusteriTc.setBounds(225, 20, 303, 43);
		panelMusteri.add(txtMusteriTc);
		txtMusteriTc.setColumns(10);
		
		
		
		
		//////////////////////MUSTERÝ GÝRÝS YAP///////////////////////////
		
		
		
		
		JButton btnMusteriGirisYap = new JButton("Giriþ Yap");		//Müþteri Giriþ yap buton fonksiyonu			
		btnMusteriGirisYap.addActionListener(new ActionListener() {	
			int yanlisSifre2=1;
			public void actionPerformed(ActionEvent e) {
				if (txtMusteriTc.getText().length()==0 || txtMusteriSifre.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Lütfen boþ alanlarý doldurunuz.");
				}else {
					try {
						Connection dbConnection=dbHelper.getConnection();
						Statement statement=dbConnection.createStatement();
						ResultSet	resultSet=statement.executeQuery("SELECT * FROM bilgiler");
						Musteri musteri =new Musteri();
						while (resultSet.next()) {
						 	if (txtMusteriTc.getText().equals(resultSet.getString("Tc_No")) && txtMusteriSifre.getText().equals(resultSet.getString("Sifre")) ) {
								
								musteri.setId(resultSet.getInt("idbilgiler"));
								musteri.setAdSoyad(resultSet.getString("Ad_Soyad"));
								musteri.seteMail(resultSet.getString("E_mail"));
								musteri.setAdres(resultSet.getString("Adres"));
								musteri.setSifre(resultSet.getString("Sifre"));
								musteri.setTcNo(resultSet.getString("Tc_No"));
								musteri.setBakiye(resultSet.getInt("Bakiye"));
								musteri.setIban(resultSet.getString("IBAN"));
								musteri.setTemsilciNo(resultSet.getString("TemsilciNo"));
								
								
								yanlisSifre2=0;
							}
		
						}
						if (yanlisSifre2==1) {
							JOptionPane.showMessageDialog(null, "Geçersiz TC No veya Þifre.");
					//		yanlisSifre2=0;
						}
						else {
							MusteriGUI musteriGUI=new MusteriGUI(musteri);
							musteriGUI.setVisible(true);
							dispose();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		
	
		btnMusteriGirisYap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMusteriGirisYap.setBounds(261, 178, 179, 43);
		panelMusteri.add(btnMusteriGirisYap);
		
		txtMusteriSifre = new JPasswordField();
		txtMusteriSifre.setBounds(225, 95, 303, 44);
		panelMusteri.add(txtMusteriSifre);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Müþteri Temsilcisi Giriþi", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblMusteriTc_1 = new JLabel("T.C. Numara:");
		lblMusteriTc_1.setFont(new Font("Calibri", Font.BOLD, 21));
		lblMusteriTc_1.setBounds(41, 10, 125, 65);
		panel.add(lblMusteriTc_1);
		
		txtMTTc = new JTextField();
		txtMTTc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMTTc.setColumns(10);
		txtMTTc.setBounds(226, 20, 303, 43);
		panel.add(txtMTTc);
		
		JLabel lblMusteriSifre_1 = new JLabel("Þifre:");
		lblMusteriSifre_1.setFont(new Font("Calibri", Font.BOLD, 21));
		lblMusteriSifre_1.setBounds(41, 85, 63, 65);
		panel.add(lblMusteriSifre_1);
		 
		/////////////MUSTERI TEMSÝLCÝ GÝRÝS YAP/////////////////////////////////
		
		
		JButton btnMTGirisYap = new JButton("Giriþ Yap");				//Müþteri Temsilcisi Giriþ yap buton fonksiyonu		
		btnMTGirisYap.addActionListener(new ActionListener() {
			int yanlisSifre=0;
			public void actionPerformed(ActionEvent e) {
				if (txtMTTc.getText().length()==0 || txtMTSifre.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Lütfen boþ alanlarý doldurunuz.");
				}else {
					try {
						Connection dbConnection=dbHelper.getConnection();
						Statement statement=dbConnection.createStatement();
						ResultSet	resultSet=statement.executeQuery("SELECT * FROM bilgilermt");
						
						while (resultSet.next()) {
						 	if (txtMTTc.getText().equals(resultSet.getString("Tc_No_MT")) && txtMTSifre.getText().equals(resultSet.getString("Sifre_MT")) ) {
								MusteriMT musterimt =new MusteriMT();
								musterimt.setId(resultSet.getInt("idMT"));
								musterimt.setAdSoyad(resultSet.getString("Ad_Soyad_MT"));
								musterimt.seteMail(resultSet.getString("E_mail_MT"));
								musterimt.setAdres(resultSet.getString("Adres_MT"));
								musterimt.setSifre(resultSet.getString("Sifre_MT"));
								musterimt.setTcNo(resultSet.getString("Tc_No_MT"));
								musterimt.setTemsilciNo(resultSet.getString("TemsilciNo_MT"));
								
								MusteriTemsilcisiGUI musteriTemsilcisiGUI= new MusteriTemsilcisiGUI(musterimt);  // MusteriTemsilcisiGUI 
								musteriTemsilcisiGUI.setVisible(true);
								dispose();
								
								yanlisSifre=0;
							}else {
								yanlisSifre=1;
							}
							
						}
						if (yanlisSifre==1) {
							JOptionPane.showMessageDialog(null, "Geçersiz TC No veya Þifre.");
							yanlisSifre=0;
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnMTGirisYap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMTGirisYap.setBounds(264, 175, 179, 43);
		panel.add(btnMTGirisYap);
		
		txtMTSifre = new JPasswordField();
		txtMTSifre.setBounds(226, 95, 303, 43);
		panel.add(txtMTSifre);
		
		JPanel bankaMuduruPnl = new JPanel();
		tabbedPane.addTab("Banka Müdürü Giriþi", null, bankaMuduruPnl, null);
		bankaMuduruPnl.setLayout(null);
		
		JLabel lblMusteriTc_1_1 = new JLabel("T.C. Numara:");
		lblMusteriTc_1_1.setFont(new Font("Calibri", Font.BOLD, 21));
		lblMusteriTc_1_1.setBounds(40, 10, 125, 65);
		bankaMuduruPnl.add(lblMusteriTc_1_1);
		
		txtBMTc = new JTextField();
		txtBMTc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtBMTc.setColumns(10);
		txtBMTc.setBounds(225, 20, 303, 43);
		bankaMuduruPnl.add(txtBMTc);
		
		txtBMSifre = new JPasswordField();
		txtBMSifre.setBounds(225, 95, 303, 43);
		bankaMuduruPnl.add(txtBMSifre);
		
		JLabel lblMusteriSifre_1_1 = new JLabel("\u015Eifre:");
		lblMusteriSifre_1_1.setFont(new Font("Calibri", Font.BOLD, 21));
		lblMusteriSifre_1_1.setBounds(40, 85, 63, 65);
		bankaMuduruPnl.add(lblMusteriSifre_1_1);
		
		///////////////////////BANKA MUDURU GÝRÝS YAP////////////////////////////////
		
		JButton btnBMGirisYap = new JButton("Giri\u015F Yap");
		btnBMGirisYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtBMTc.getText().equals("admin") && txtBMSifre.getText().equals("admin")) {
					BankaMuduruGUI bankaMuduruGUI;
					try {
						bankaMuduruGUI = new BankaMuduruGUI();
						bankaMuduruGUI.setVisible(true);
						dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  // MusteriTemsilcisiGUI 
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Geçersiz TC No veya Þifre.");
					
				}
				
				
			}
		});
		btnBMGirisYap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBMGirisYap.setBounds(263, 175, 179, 43);
		bankaMuduruPnl.add(btnBMGirisYap);
	}
}
