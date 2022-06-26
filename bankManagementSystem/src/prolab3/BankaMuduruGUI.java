package prolab3;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import helper.DBHelper;
import model.MusteriMT;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class BankaMuduruGUI extends JFrame {

	static MusteriMT musterimt2 = new MusteriMT();
	private JPanel contentPane;
	private JTable tblMusteriler;
	private DBHelper dbHelper=new DBHelper();
	
	private DefaultTableModel musteriModel2 =null;
	private Object[] musteriData2 =null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankaMuduruGUI frame = new BankaMuduruGUI();
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
	
	
	
	
	
	public BankaMuduruGUI() throws SQLException {
		
		try {
			Connection dbConnection2=dbHelper.getConnection();
			Statement statement2=dbConnection2.createStatement();

			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		
		musteriModel2 = new DefaultTableModel();
		Object[] colMusteriName2=new Object[7];
		
		colMusteriName2[0]="ID";
		colMusteriName2[1]="Ad Soyad";
		colMusteriName2[2]="TC NO";
		colMusteriName2[3]="E Mail";
		colMusteriName2[4]="Telefon";
		colMusteriName2[5]="Adres ";
		colMusteriName2[6]="Temsilci No";
	
		musteriModel2.setColumnIdentifiers(colMusteriName2);
		musteriData2 =new Object[7];
		//musteriSayisi=Integer.parseInt(null, musterimt.getMusteriList().size());
		 for(int i=0;i<8;i++) {        //SIZE KONTROLU OLMUYOR KAÇ MÜÞTERÝ VARSA ONA GÖRE SAYI VERÝLMELÝ
			 
			
				   musteriData2[0]=musterimt2.getMusteriList().get(i).getId();
					 musteriData2[1]=musterimt2.getMusteriList().get(i).getAdSoyad();
					 musteriData2[2]=musterimt2.getMusteriList().get(i).getTcNo();
					 musteriData2[3]=musterimt2.getMusteriList().get(i).geteMail();
					 musteriData2[4]=musterimt2.getMusteriList().get(i).getTelefon();
					 musteriData2[5]=musterimt2.getMusteriList().get(i).getAdres();
					 musteriData2[6]=musterimt2.getMusteriList().get(i).getTemsilciNo();
					   musteriModel2.addRow(musteriData2);
			  
	
		 }
	
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMTCikisYap = new JButton("\u00C7\u0131k\u0131\u015F Yap");
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
		btnMTCikisYap.setBounds(622, 10, 104, 28);
		contentPane.add(btnMTCikisYap);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(33, 132, 639, 321);
		contentPane.add(tabbedPane);
		
		JPanel pnlMusteriListesi = new JPanel();
		tabbedPane.addTab("Müþteriler", null, pnlMusteriListesi, null);
		pnlMusteriListesi.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 614, 274);
		pnlMusteriListesi.add(scrollPane);
		
		

		
		
		tblMusteriler = new JTable(musteriModel2);
		scrollPane.setColumnHeaderView(tblMusteriler);
	}

	
}
