package fixed.assets;

import java.awt.EventQueue;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddNewDisposal {

	JFrame frame;
	private JTextField txt_profitloss;
	private JTextField txt_disposalproc;
	private DateButton btn_disposal;
	private JTextField txt_did;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewDisposal window = new AddNewDisposal(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param string 
	 */
	public AddNewDisposal(String string) {
		initialize();
		txt_did.setText(string);
		
		JButton btnNewButton = new JButton(">");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");	
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fixed_assest_db","root","");                                    
					Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );
					ResultSet rs = stmt.executeQuery("select * from fixed_asset_details where id='"+txt_did.getText()+"'");
					//ResultSet rs = stmt.executeQuery("select * from fixed_asset_details where id='1'");
					
					Statement stmt1 = con.createStatement();

					while(rs.next())
					{
						int cost=Integer.parseInt(rs.getString("netbookvalue"));
						int disposal=Integer.parseInt(txt_disposalproc.getText());
						int result1=disposal-cost+1;
						
						txt_profitloss.setText(String.valueOf(result1));
					}
				} catch (Exception e1)
				{

				}


				
			}
		});
		btnNewButton.setBounds(310, 134, 41, 23);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel.setBounds(36, 47, 346, 210);
		frame.getContentPane().add(panel);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(320, 100, 439, 319);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdd = new JLabel("Add New Dispose");
		lblAdd.setForeground(Color.RED);
		lblAdd.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdd.setBounds(143, 11, 180, 24);
		frame.getContentPane().add(lblAdd);
		
		JLabel lblDateOf = new JLabel("Disposal Proceeds:");
		lblDateOf.setForeground(Color.BLUE);
		lblDateOf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateOf.setBounds(65, 131, 125, 27);
		frame.getContentPane().add(lblDateOf);
		
		JLabel lblDescription = new JLabel("ID:");
		lblDescription.setForeground(Color.BLUE);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDescription.setBounds(65, 63, 125, 27);
		frame.getContentPane().add(lblDescription);
		
		JLabel lblPurchaseOrderNo = new JLabel("Profit/Loss Disposal:");
		lblPurchaseOrderNo.setForeground(Color.BLUE);
		lblPurchaseOrderNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPurchaseOrderNo.setBounds(65, 167, 125, 27);
		frame.getContentPane().add(lblPurchaseOrderNo);
		
		
		
		JButton btn_finance = new JButton("Add Dispose");
		btn_finance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (txt_disposalproc.equals("")  || txt_profitloss.equals(""))
				{
					 JOptionPane.showMessageDialog(null, "Please Enter all required fields ! ", "Error", JOptionPane.ERROR_MESSAGE);
				}
	            else 
				{
	            	 ArrayList<String> disposal_list=new ArrayList<String>();
	            	 disposal_list.add(0, txt_did.getText());
	            	 disposal_list.add(1, btn_disposal.getText());
	            	 disposal_list.add(2, txt_disposalproc.getText());
	            	 disposal_list.add(3, txt_profitloss.getText());
                     try
                     {          

                             	Class.forName("com.mysql.jdbc.Driver");	
                        			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fixed_assest_db","root","");                                    
                        		     
                                 Statement statement =con.createStatement();
                                 Statement statement1 =con.createStatement(); 
                                 String temp4 = "INSERT INTO asset_disposal VALUES ('"+ disposal_list.get(0)+"','"+ disposal_list.get(1)+"','"+ disposal_list.get(2)+"','"+ disposal_list.get(3)+"')";
                                 
                                 int result4 = statement.executeUpdate( temp4 );
                                 statement1.executeUpdate("update fixed_asset_details set disposed='y' where id='"+disposal_list.get(0)+"'");
                                 
                                 JOptionPane.showMessageDialog(null, "Disposal Data Saved");
                                 btn_disposal.setEnabled(false);
                                 frame.hide();
		            	 }
                     catch(Exception e1)
                     {
                    	 
                     }
	            }				
				
			}	
		});
		
		JButton cmd_cancel = new JButton("Cancel");
		cmd_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				HomeWindow l=new HomeWindow();
				l.frame.setVisible(true);
				frame.hide(); 
            }
		});
		cmd_cancel.setForeground(Color.BLUE);
		cmd_cancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmd_cancel.setBounds(216, 213, 122, 23);
		frame.getContentPane().add(cmd_cancel);
		
		txt_profitloss = new JTextField();
		txt_profitloss.setEditable(false);
		txt_profitloss.setColumns(10);
		txt_profitloss.setBounds(237, 171, 114, 20);
		frame.getContentPane().add(txt_profitloss);
		
		txt_disposalproc = new JTextField();
		txt_disposalproc.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) 
			{
					}
		});
		txt_disposalproc.setColumns(10);
		txt_disposalproc.setBounds(237, 135, 58, 20);
		frame.getContentPane().add(txt_disposalproc);
		
		btn_disposal = new DateButton();
		btn_disposal.setBounds(236, 96, 114, 27);
		frame.getContentPane().add(btn_disposal);
		
		txt_did = new JTextField();
		txt_did.setEditable(false);
		txt_did.setColumns(10);
		txt_did.setBounds(236, 67, 114, 20);
		frame.getContentPane().add(txt_did);
		
		JLabel lblSerialNumber = new JLabel("Disposal Date:");
		lblSerialNumber.setForeground(Color.BLUE);
		lblSerialNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSerialNumber.setBounds(65, 96, 125, 27);
		frame.getContentPane().add(lblSerialNumber);
		btn_finance.setForeground(Color.BLUE);
		btn_finance.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_finance.setBounds(79, 214, 122, 23);
		frame.getContentPane().add(btn_finance);
	}
}
