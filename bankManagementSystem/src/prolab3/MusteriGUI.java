package prolab3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Musteri;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class MusteriGUI extends JFrame {
	SimpleDateFormat sekil = new SimpleDateFormat(); 			//GÜNCEL TARÝH SAATÝ ALIR
    Date tarih = new Date();

	static Musteri musteri=new Musteri();
	private JPanel contentPane;
	private JTextField txtyatirma;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusteriGUI frame = new MusteriGUI(musteri);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MusteriGUI(Musteri musteri) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hoþ Geldiniz, Sayýn "+musteri.getAdSoyad());
		lblNewLabel.setBounds(10, 10, 270, 28);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(31, 69, 648, 358);
		contentPane.add(tabbedPane);
		
		JPanel pnlHesapOzeti = new JPanel();
		tabbedPane.addTab("Hesap Özeti", null, pnlHesapOzeti, null);
		pnlHesapOzeti.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ad Soyad:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(33, 39, 155, 22);
		pnlHesapOzeti.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tc No:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(33, 83, 100, 20);
		pnlHesapOzeti.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("E-Mail:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(33, 128, 100, 20);
		pnlHesapOzeti.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Bakiye:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(318, 290, 100, 20);
		pnlHesapOzeti.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Adres:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_4.setBounds(33, 175, 100, 20);
		pnlHesapOzeti.add(lblNewLabel_1_4);
		
		JLabel lblAdSoyad = new JLabel(musteri.getAdSoyad());
		lblAdSoyad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAdSoyad.setBounds(224, 34, 225, 32);
		pnlHesapOzeti.add(lblAdSoyad);
		
		JLabel lblTcNo = new JLabel(musteri.getTcNo());
		lblTcNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTcNo.setBounds(224, 77, 225, 32);
		pnlHesapOzeti.add(lblTcNo);
		
		JLabel lblEMail = new JLabel(musteri.geteMail());
		lblEMail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEMail.setBounds(224, 122, 225, 32);
		pnlHesapOzeti.add(lblEMail);
		
		JLabel lblAdres = new JLabel(musteri.getAdres());
		lblAdres.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAdres.setBounds(224, 163, 225, 32);
		pnlHesapOzeti.add(lblAdres);
		
		JLabel lblBakiye = new JLabel(""+musteri.getBakiye());
		lblBakiye.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBakiye.setBounds(515, 284, 225, 32);
		pnlHesapOzeti.add(lblBakiye);
		
		JLabel lblNewLabel_2 = new JLabel("IBAN:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(33, 255, 106, 22);
		pnlHesapOzeti.add(lblNewLabel_2);
		
		JLabel lbliban = new JLabel(""+musteri.getIban());
		lbliban.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbliban.setBounds(224, 255, 118, 22);
		pnlHesapOzeti.add(lbliban);
		
		JLabel lblNewLabel_2_1 = new JLabel("Temsilci No:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(33, 213, 106, 22);
		pnlHesapOzeti.add(lblNewLabel_2_1);
		
		JLabel lblTemsilciNo = new JLabel(""+musteri.getTemsilciNo());
		lblTemsilciNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTemsilciNo.setBounds(224, 211, 106, 22);
		pnlHesapOzeti.add(lblTemsilciNo);
		
		JPanel pnlParaYatCek = new JPanel();
		tabbedPane.addTab("Para Yatýrma-Çekme", null, pnlParaYatCek, null);
		pnlParaYatCek.setLayout(null);
		
		txtyatirma = new JTextField();
		txtyatirma.setBounds(286, 51, 96, 19);
		pnlParaYatCek.add(txtyatirma);
		txtyatirma.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Yatýrýlacak Tutar:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(39, 45, 123, 31);
		pnlParaYatCek.add(lblNewLabel_3);
		
		JButton btnYatir = new JButton("Yatýr");
		btnYatir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnYatir.setBounds(192, 112, 85, 21);
		pnlParaYatCek.add(btnYatir);
		
							
	    
        
		
		JPanel pnlHesapEkleSil = new JPanel();
		tabbedPane.addTab("Hesap Sil", null, pnlHesapEkleSil, null);
		
		JPanel pnlBilgiGuncelle = new JPanel();
		tabbedPane.addTab("Bilgilerini Güncelle", null, pnlBilgiGuncelle, null);
		
		        
		JLabel lblTarih = new JLabel(""+sekil.format(tarih));
		lblTarih.setBounds(591, 54, 121, 24);
		contentPane.add(lblTarih);
		lblTarih.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnCikisYap = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btnCikisYap.addActionListener(new ActionListener() {
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
		btnCikisYap.setBounds(613, 15, 113, 24);
		contentPane.add(btnCikisYap);
	
		
	
	
	}
}
