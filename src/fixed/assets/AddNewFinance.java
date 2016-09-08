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

public class AddNewFinance {

	JFrame frame;
	private JTextField txt_bank;
	private JTextField txt_bankref;
	private JTextField txt_loanamount;
	private DateButton btn_loan,btn_mdate;
	private JTextField txt_typeloan;
	private JTextField txt_fid;
	String datelastcalc,location,manager,book_value,id,descr,acc_depreciation,depreciation,purchaseno,serialno,catagory,cost,acquisition;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//AddNewFinance window = new AddNewFinance();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * @wbp.parser.entryPoint
	 */
	public AddNewFinance(String string) {
		//System.out.println(string);
		initialize();
		txt_fid.setText(string);
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel.setBounds(36, 46, 348, 286);
		frame.getContentPane().add(panel);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(320, 100, 439, 381);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdd = new JLabel("Add New Finance");
		lblAdd.setForeground(Color.RED);
		lblAdd.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdd.setBounds(143, 11, 180, 24);
		frame.getContentPane().add(lblAdd);
		
		JLabel lblDateOf = new JLabel("Bank Ref:");
		lblDateOf.setForeground(Color.BLUE);
		lblDateOf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateOf.setBounds(69, 152, 125, 27);
		frame.getContentPane().add(lblDateOf);
		
		JLabel lblDescription = new JLabel("Bank:");
		lblDescription.setForeground(Color.BLUE);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDescription.setBounds(69, 91, 125, 27);
		frame.getContentPane().add(lblDescription);
		
		JLabel lblPurchaseOrderNo = new JLabel("Origin Loan Amount:");
		lblPurchaseOrderNo.setForeground(Color.BLUE);
		lblPurchaseOrderNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPurchaseOrderNo.setBounds(69, 183, 125, 27);
		frame.getContentPane().add(lblPurchaseOrderNo);
		
		JLabel lblManufacture = new JLabel("Date Of Loan:");
		lblManufacture.setForeground(Color.BLUE);
		lblManufacture.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblManufacture.setBounds(69, 215, 144, 27);
		frame.getContentPane().add(lblManufacture);
		
		JLabel lblDepricationRate = new JLabel("Maturity Date");
		lblDepricationRate.setForeground(Color.BLUE);
		lblDepricationRate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDepricationRate.setBounds(69, 248, 144, 27);
		frame.getContentPane().add(lblDepricationRate);
		
		
		
		JButton btn_finance = new JButton("Add Finance");
		btn_finance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (txt_bankref.equals("")  ||txt_bank.equals("")  )
				{
					 JOptionPane.showMessageDialog(null, "Please Enter all required fields ! ", "Error", JOptionPane.ERROR_MESSAGE);
				}
	            else 
				{
	            	 ArrayList<String> finance_list=new ArrayList<String>();
	            	 finance_list.add(0, txt_fid.getText());
	            	 finance_list.add(1, txt_bank.getText());
	            	 finance_list.add(2, txt_typeloan.getText());
	            	 finance_list.add(3, txt_bankref.getText());
	            	 finance_list.add(4, txt_loanamount .getText());
	            	 finance_list.add(5, btn_loan.getText());
	            	 finance_list.add(6, btn_mdate.getText());
	            	
	            	 if (txt_fid.equals("")  ||txt_bank.equals("") ||txt_typeloan.equals("") ||txt_bankref.equals("") || txt_loanamount.equals(""))
		 				{
		 					 JOptionPane.showMessageDialog(null, "Please Enter all required fields ! ", "Error", JOptionPane.ERROR_MESSAGE);
		 				}
		 	                        else 
		 				{
		 					   
		 	                                                try
		 	                                                {          

		 			                                                	Class.forName("com.mysql.jdbc.Driver");	
		 			                                           			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fixed_assest_db","root","");                                    
		 			                                           		     
		 	                                                            Statement statement =con.createStatement();
		 	                                                            
		 	                                            				String temp1 = "INSERT INTO asset_finance_table VALUES ('"+ finance_list.get(0)+"','"+ finance_list.get(1)+"','"+ finance_list.get(2)+"','"+ finance_list.get(3)+"','"+ finance_list.get(4)+"','"+ finance_list.get(5)+"','"+ finance_list.get(6)+"')";
		 	                                            				 int result2 = statement.executeUpdate( temp1 );
		 	                                                            
		 	                                                            //JOptionPane.showMessageDialog(null, "Finance data has been Added ", "Done", JOptionPane.INFORMATION_MESSAGE);
		 	                                                             
		 	                                                }
		 	                                                catch (Exception e1)
		 	                                                { 
		 	                                                    JOptionPane.showMessageDialog(null, e1.getStackTrace(), "Error", JOptionPane.ERROR_MESSAGE);      
		 	                                                    e1.printStackTrace();
		 	                                                }
		 						}				

		            	 
		            	 JOptionPane.showMessageDialog(null, "Finance Data Saved");
		            	 
		                 AddNewFixedAsset l=new AddNewFixedAsset(finance_list,"finance");
		            	 //l.frame.setVisible(true);
		            	 frame.hide();
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
		cmd_cancel.setBounds(223, 295, 122, 23);
		frame.getContentPane().add(cmd_cancel);
		
		txt_bank = new JTextField();
		txt_bank.setColumns(10);
		txt_bank.setBounds(239, 93, 114, 20);
		frame.getContentPane().add(txt_bank);
		
		txt_bankref = new JTextField();
		txt_bankref.setColumns(10);
		txt_bankref.setBounds(239, 156, 114, 20);
		frame.getContentPane().add(txt_bankref);
		
		txt_loanamount = new JTextField();
		txt_loanamount.setColumns(10);
		txt_loanamount.setBounds(239, 187, 114, 20);
		frame.getContentPane().add(txt_loanamount);
		
		btn_loan = new DateButton();
		btn_loan.setBounds(239, 216, 114, 27);
		frame.getContentPane().add(btn_loan);
		
		btn_mdate = new DateButton();
		btn_mdate.setBounds(239, 251, 114, 27);
		frame.getContentPane().add(btn_mdate);
		
		txt_typeloan = new JTextField();
		txt_typeloan.setColumns(10);
		txt_typeloan.setBounds(239, 125, 114, 20);
		frame.getContentPane().add(txt_typeloan);
		
		JLabel lblSerialNumber = new JLabel("Type Of Finance:");
		lblSerialNumber.setForeground(Color.BLUE);
		lblSerialNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSerialNumber.setBounds(69, 120, 125, 27);
		frame.getContentPane().add(lblSerialNumber);
		btn_finance.setForeground(Color.BLUE);
		btn_finance.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_finance.setBounds(90, 296, 122, 23);
		frame.getContentPane().add(btn_finance);
		
		JLabel label = new JLabel("ID:");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(70, 58, 125, 27);
		frame.getContentPane().add(label);
		
		txt_fid = new JTextField();
		txt_fid.setEditable(false);
		txt_fid.setColumns(10);
		txt_fid.setBounds(239, 62, 114, 20);
		frame.getContentPane().add(txt_fid);
	}
}
