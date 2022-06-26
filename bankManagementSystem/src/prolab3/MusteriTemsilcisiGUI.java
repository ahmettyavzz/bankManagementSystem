package prolab3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.MusteriMT;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;


import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MusteriTemsilcisiGUI extends JFrame {

	static MusteriMT musterimt = new MusteriMT();
	private JPanel contentPane;
	private JTable tableMusteriListesi;
	private DefaultTableModel musteriModel =null;
	private Object[] musteriData =null;
	private JTextField txtTCNO;
	private JTextField txtTelefon;
	private JTextField txtEMail;
	private JTextField txtAdres;
	private JTextField txtSifre;
	private JTextField txtBakiye;
	private JTextField txtIBAN;
	private JTextField txtAdSoyad;
	//int musteriSayisi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusteriTemsilcisiGUI frame = new MusteriTemsilcisiGUI(musterimt);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException
	 */
	
	
	///////////////////////////////////
	
	
	public MusteriTemsilcisiGUI(MusteriMT musterimt)throws SQLException {
		musteriModel = new DefaultTableModel();
		Object[] colMusteriName=new Object[7];
		
		colMusteriName[0]="ID";
		colMusteriName[1]="Ad Soyad";
		colMusteriName[2]="TC NO";
		colMusteriName[3]="E Mail";
		colMusteriName[4]="Telefon";
		colMusteriName[5]="Adres ";
		colMusteriName[6]="Temsilci No";
	
		musteriModel.setColumnIdentifiers(colMusteriName);
		musteriData =new Object[7];
		//musteriSayisi=Integer.parseInt(null, musterimt.getMusteriList().size());
		 for(int i=0;i<8;i++) {        //SIZE KONTROLU OLMUYOR KAÇ MÜÞTERÝ VARSA ONA GÖRE SAYI VERÝLMELÝ
			 
			 if(musterimt.getTemsilciNo().equals(musterimt.getMusteriList().get(i).getTemsilciNo()) ) {
				   musteriData[0]=musterimt.getMusteriList().get(i).getId();
					 musteriData[1]=musterimt.getMusteriList().get(i).getAdSoyad();
					 musteriData[2]=musterimt.getMusteriList().get(i).getTcNo();
					 musteriData[3]=musterimt.getMusteriList().get(i).geteMail();
					 musteriData[4]=musterimt.getMusteriList().get(i).getTelefon();
					 musteriData[5]=musterimt.getMusteriList().get(i).getAdres();
					 musteriData[6]=musterimt.getMusteriList().get(i).getTemsilciNo();
					   musteriModel.addRow(musteriData);
			  }
	
		 }
	
		
		setTitle("Müþteri Temsilcisi Sistemi");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMTHg = new JLabel("Hoþ Geldiniz, Sayýn "+musterimt.getAdSoyad()+"("+musterimt.getTemsilciNo()+")");
		lblMTHg.setBounds(10, 10, 313, 30);
		lblMTHg.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(lblMTHg);
		
		JButton btnMTCikisYap = new JButton("Çýkýþ Yap");
		btnMTCikisYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LoginGUI loginGUI =new LoginGUI();
					loginGUI.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				
			}
		});
		btnMTCikisYap.setBounds(630, 17, 96, 23);
		contentPane.add(btnMTCikisYap);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(26, 116, 551, 337);
		contentPane.add(tabbedPane);
		
		JPanel pnlMusteriListesi = new JPanel();
		tabbedPane.addTab("Müþteriler", null, pnlMusteriListesi, null);
		pnlMusteriListesi.setLayout(null);
		
		JScrollPane scrollMT = new JScrollPane();
		scrollMT.setBounds(10, 10, 526, 289);
		pnlMusteriListesi.add(scrollMT);
		
		tableMusteriListesi = new JTable(musteriModel);
		scrollMT.setViewportView(tableMusteriListesi);
		
		JPanel pnlMusteriEkle = new JPanel();
		tabbedPane.addTab("Müþteri Ekle", null, pnlMusteriEkle, null);
		pnlMusteriEkle.setLayout(null);
		
		txtTCNO = new JTextField();
		txtTCNO.setBackground(Color.WHITE);
		txtTCNO.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTCNO.setBounds(235, 46, 96, 19);
		pnlMusteriEkle.add(txtTCNO);
		txtTCNO.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("TC NO:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(30, 49, 96, 13);
		pnlMusteriEkle.add(lblNewLabel);
		
		JLabel lblTelefonNo = new JLabel("Telefon No:");
		lblTelefonNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefonNo.setBounds(30, 90, 96, 13);
		pnlMusteriEkle.add(lblTelefonNo);
		
		txtTelefon = new JTextField();
		txtTelefon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTelefon.setColumns(10);
		txtTelefon.setBackground(Color.WHITE);
		txtTelefon.setBounds(235, 87, 96, 19);
		pnlMusteriEkle.add(txtTelefon);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(30, 124, 96, 13);
		pnlMusteriEkle.add(lblEmail);
		
		txtEMail = new JTextField();
		txtEMail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEMail.setColumns(10);
		txtEMail.setBackground(Color.WHITE);
		txtEMail.setBounds(235, 121, 96, 19);
		pnlMusteriEkle.add(txtEMail);
		
		JLabel lblAderes = new JLabel("Adres:");
		lblAderes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAderes.setBounds(30, 161, 96, 13);
		pnlMusteriEkle.add(lblAderes);
		
		txtAdres = new JTextField();
		txtAdres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAdres.setColumns(10);
		txtAdres.setBackground(Color.WHITE);
		txtAdres.setBounds(235, 158, 96, 19);
		pnlMusteriEkle.add(txtAdres);
		
		JLabel lblifre = new JLabel("\u015Eifre:");
		lblifre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblifre.setBounds(30, 200, 96, 13);
		pnlMusteriEkle.add(lblifre);
		
		txtSifre = new JTextField();
		txtSifre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSifre.setColumns(10);
		txtSifre.setBackground(Color.WHITE);
		txtSifre.setBounds(235, 197, 96, 19);
		pnlMusteriEkle.add(txtSifre);
		
		JLabel lblBakiye = new JLabel("Bakiye:");
		lblBakiye.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBakiye.setBounds(30, 238, 96, 13);
		pnlMusteriEkle.add(lblBakiye);
		
		txtBakiye = new JTextField();
		txtBakiye.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBakiye.setColumns(10);
		txtBakiye.setBackground(Color.WHITE);
		txtBakiye.setBounds(235, 235, 96, 19);
		pnlMusteriEkle.add(txtBakiye);
		
		JLabel lblIban = new JLabel("IBAN:");
		lblIban.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIban.setBounds(30, 274, 96, 13);
		pnlMusteriEkle.add(lblIban);
		
		txtIBAN = new JTextField();
		txtIBAN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIBAN.setColumns(10);
		txtIBAN.setBackground(Color.WHITE);
		txtIBAN.setBounds(235, 271, 96, 19);
		pnlMusteriEkle.add(txtIBAN);
		
		JLabel lblNewLabel_8 = new JLabel("Ad Soyad:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(30, 13, 96, 13);
		pnlMusteriEkle.add(lblNewLabel_8);
		
		txtAdSoyad = new JTextField();
		txtAdSoyad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAdSoyad.setColumns(10);
		txtAdSoyad.setBackground(Color.WHITE);
		txtAdSoyad.setBounds(235, 10, 96, 19);
		pnlMusteriEkle.add(txtAdSoyad);
		
		JButton btnMusteriEkle = new JButton("Müþteri Ekle");
		btnMusteriEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				if (txtAdSoyad.getText().isEmpty() || txtAdres.getText().isEmpty() 
					|| txtBakiye.getText().isEmpty() || txtEMail.getText().isEmpty() 
					|| txtIBAN.getText().isEmpty() || txtSifre.getText().isEmpty()
					|| txtTCNO.getText().isEmpty() || txtTelefon.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Lütfen boþ alanlarý doldurunuz.");
				}else {
					
					try {
						boolean kontrol = musterimt.addMusteri(txtAdSoyad.getText(), txtEMail.getText()
								, txtTelefon.getText(), txtTCNO.getText(),txtSifre.getText(), txtAdres.getText(),txtBakiye.getText(),musterimt.getTemsilciNo()
								,txtIBAN.getText());
						if (kontrol) {
							JOptionPane.showMessageDialog(null, "Müþteri Eklendi.");
							txtAdres.setText(null);txtAdSoyad.setText(null);txtBakiye.setText(null);
							txtEMail.setText(null);txtIBAN.setText(null);txtAdSoyad.setText(null);
							txtSifre.setText(null);txtTCNO.setText(null);txtTelefon.setText(null);
							
						
							
						}else {
							JOptionPane.showMessageDialog(null, "Müþteri Ekleme Baþarýsýz.");
						}
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				
				
			}
		});
		
		btnMusteriEkle.setBackground(Color.WHITE);
		btnMusteriEkle.setFont(new Font("Arial", Font.PLAIN, 12));
		btnMusteriEkle.setBounds(440, 268, 96, 32);
		pnlMusteriEkle.add(btnMusteriEkle);
		
	}

}
