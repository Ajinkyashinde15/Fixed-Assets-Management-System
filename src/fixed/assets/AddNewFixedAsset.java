package fixed.assets;

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

public class AddNewFixedAsset {

	JFrame frame;
	private JTextField txt_description;
	private JTextField txt_catagory;
	private JTextField txt_purchaseno;
	private JTextField txt_depreciation;
	private JTextField txt_cost;
	private JTextField txt_acc_depreciation;
	private DateButton txt_acquisition,btn_gexp;
	private JTextField txt_serialno;
	private JTextField txt_book_value;
	private JTextField txt_location;
	private JTextField txt_manager;
	private JTextField txt_id;
	private JButton btn_capital,btn_insurance,btn_finance_new;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewFixedAsset window = new AddNewFixedAsset();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddNewFixedAsset() 
	{
		initialize();
        
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");	
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fixed_assest_db","root","");                                    
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs;
			rs= stmt.executeQuery("select * from fixed_asset_details");
	        //rs.last();
	        int las,las1;
	        String s;
	        
	        	int gr=0;
	        	int i=0;
	        	while(rs.next())
	        	{
	        		int no=Integer.parseInt(rs.getString(1));
	        		if(no>gr)
	        			gr=no;
	        		
	        	}
	        	
	            las=gr;
	            las1=las+1;
	            s=Integer.toString(las1);
	            txt_id.setText(s);
	         
	
		} catch (Exception e) {
        	txt_id.setText("1");
		}
		
	}

	public AddNewFixedAsset(ArrayList<String> list,String flag )
	{
	
		initialize();
        
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");	
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fixed_assest_db","root","");                                    
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs;
			rs= stmt.executeQuery("select * from fixed_asset_details");
	        //rs.last();
	        int las,las1;
	        String s;
	        
	        	int gr=0;
	        	int i=0;
	        	while(rs.next())
	        	{
	        		int no=Integer.parseInt(rs.getString(1));
	        		if(no>gr)
	        			gr=no;
	        		
	        	}
	        	
	            las=gr;
	            las1=las+1;
	            s=Integer.toString(las1);
	            txt_id.setText(s);
	         
	
		} catch (Exception e) {
        	txt_id.setText("1");
		}
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(350, 5, 439, 692);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdd = new JLabel("Add New Fixed Assest");
		lblAdd.setForeground(Color.RED);
		lblAdd.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdd.setBounds(130, 15, 180, 24);
		frame.getContentPane().add(lblAdd);
		
		JLabel lblDateOf = new JLabel("Assets Catagory:");
		lblDateOf.setForeground(Color.BLUE);
		lblDateOf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateOf.setBounds(68, 151, 125, 27);
		frame.getContentPane().add(lblDateOf);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setForeground(Color.BLUE);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDescription.setBounds(68, 90, 125, 27);
		frame.getContentPane().add(lblDescription);
		
		JLabel lblPurchaseOrderNo = new JLabel("Date Of Acquisition:");
		lblPurchaseOrderNo.setForeground(Color.BLUE);
		lblPurchaseOrderNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPurchaseOrderNo.setBounds(68, 182, 125, 27);
		frame.getContentPane().add(lblPurchaseOrderNo);
		
		JLabel lblManufacture = new JLabel("Purchase Order No:");
		lblManufacture.setForeground(Color.BLUE);
		lblManufacture.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblManufacture.setBounds(68, 214, 144, 27);
		frame.getContentPane().add(lblManufacture);
		
		JLabel lblCost = new JLabel("Cost:");
		lblCost.setForeground(Color.BLUE);
		lblCost.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCost.setBounds(68, 275, 144, 27);
		frame.getContentPane().add(lblCost);
		
		JLabel lblGuarantee = new JLabel("Accumalated Depreciation:");
		lblGuarantee.setForeground(Color.BLUE);
		lblGuarantee.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGuarantee.setBounds(67, 307, 161, 27);
		frame.getContentPane().add(lblGuarantee);
		
		JLabel lblDepricationMethod = new JLabel("Net Book Value:");
		lblDepricationMethod.setForeground(Color.BLUE);
		lblDepricationMethod.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDepricationMethod.setBounds(68, 341, 144, 27);
		frame.getContentPane().add(lblDepricationMethod);
		
		JLabel lblDepricationRate = new JLabel("Depreciation:");
		lblDepricationRate.setForeground(Color.BLUE);
		lblDepricationRate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDepricationRate.setBounds(68, 246, 144, 27);
		frame.getContentPane().add(lblDepricationRate);
		
		JLabel lblDesposalDate = new JLabel("Location:");
		lblDesposalDate.setForeground(Color.BLUE);
		lblDesposalDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDesposalDate.setBounds(68, 375, 144, 27);
		frame.getContentPane().add(lblDesposalDate);
		
		btn_finance_new = new JButton("Add Finance");
		btn_finance_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				btn_capital.setEnabled(true);
				AddNewFinance l=new AddNewFinance(txt_id.getText());
                l.frame.setVisible(true);
             
                if (txt_catagory.equals("")  ||txt_description.equals("") ||txt_depreciation.equals("") ||txt_acc_depreciation.equals("") || txt_cost.equals(""))
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

	                                                            String temp = "INSERT INTO fixed_asset_details VALUES ('"+  txt_id.getText()  + "','"+ txt_description.getText() +"', '" + txt_serialno.getText()+ "', '" +txt_catagory.getText()+ "', '" +txt_acquisition.getText() + "', '" +txt_purchaseno.getText() + "', '" +  txt_depreciation.getText() + "', '" + txt_cost.getText()+ "', '" +txt_acc_depreciation.getText()  + "', '" + txt_book_value.getText()+ "', '" + null + "', '" + txt_location.getText()+ "', '" + txt_manager.getText()   + "','"+btn_gexp.getText()+"','n' )";
	                                               			                                            																										                                                           
	                                                            int result = statement.executeUpdate( temp );
	                                                  
	                                                }
	                                                catch (Exception e1)
	                                                { 
	                                                    JOptionPane.showMessageDialog(null, e1.getStackTrace(), "Error", JOptionPane.ERROR_MESSAGE);      
	                                                    e1.printStackTrace();
	                                                }
						}				

                
			}
		});
		
	
		
		
		final JButton btn_finance = new JButton("Add Fixed Asset");
		btn_finance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			
				
					JOptionPane.showMessageDialog(null, "Fixed Assest has been Added ", "Done", JOptionPane.INFORMATION_MESSAGE);
		              
		            txt_acc_depreciation.setText("");
		            txt_id.setText("");
		            txt_description.setText("");
		            txt_serialno.setText("");
		            txt_catagory.setText("");
		            txt_acquisition.setText("");
		            txt_purchaseno.setText(""); 
		            txt_depreciation.getText();
		            txt_cost.setText("");
		            txt_acc_depreciation.setText("");
		            txt_book_value.setText("");
	//	            txt_datelastcalc.setText("");
		            txt_location.setText("");
		            txt_manager.setText("");  
		            txt_description.setText("");
		            txt_catagory.setText("");
		            txt_purchaseno.setText("");
		            txt_depreciation.setText("");
		            txt_acquisition.setText("");
		            txt_cost.setText("");
		            txt_acc_depreciation.setText("");
//		            txt_datelastcalc.setText("");
				}						
			
		});
		btn_finance_new.setForeground(new Color(0, 102, 255));
		btn_finance_new.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_finance_new.setBounds(234, 479, 121, 23);
		frame.getContentPane().add(btn_finance_new);

		btn_capital = new JButton("Add Capital");
		btn_capital.setEnabled(false);	//disable button capital
		btn_capital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				btn_finance_new.setEnabled(false);
				btn_insurance.setEnabled(true);
				AddNewCapital l=new AddNewCapital(txt_id.getText());
                l.frame.setVisible(true);
                
                //frame.hide(); 
			}
		});
		btn_capital.setForeground(new Color(0, 102, 255));
		btn_capital.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_capital.setBounds(233, 509, 121, 23);
		frame.getContentPane().add(btn_capital);
		
		 btn_insurance = new JButton("Add Insurance");
		btn_insurance.setEnabled(false);
		btn_insurance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				btn_capital.setEnabled(false);
				//btn_disposal.setEnabled(true);	//enable button disposal
				
				AddNewInsurance l=new AddNewInsurance(txt_id.getText());
                l.frame.setVisible(true);	//open new window 
                //frame.hide(); 
			}
		});
		btn_insurance.setForeground(new Color(0, 102, 255));
		btn_insurance.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_insurance.setBounds(233, 541, 121, 23);
		frame.getContentPane().add(btn_insurance);

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
		cmd_cancel.setBounds(220, 587, 122, 23);
		frame.getContentPane().add(cmd_cancel);
		
		txt_description = new JTextField();
		txt_description.setColumns(10);
		txt_description.setBounds(238, 92, 114, 20);
		frame.getContentPane().add(txt_description);
		
		txt_catagory = new JTextField();
		txt_catagory.setColumns(10);
		txt_catagory.setBounds(238, 155, 114, 20);
		frame.getContentPane().add(txt_catagory);
		
		txt_purchaseno = new JTextField();
		txt_purchaseno.setColumns(10);
		txt_purchaseno.setBounds(237, 215, 114, 20);
		frame.getContentPane().add(txt_purchaseno);
		
		txt_depreciation = new JTextField();
		txt_depreciation.setColumns(10);
		txt_depreciation.setBounds(238, 250, 114, 20);
		frame.getContentPane().add(txt_depreciation);
		
		txt_cost = new JTextField();
		txt_cost.setColumns(10);
		txt_cost.setBounds(238, 279, 114, 20);
		frame.getContentPane().add(txt_cost);
		
		txt_acc_depreciation = new JTextField();
		txt_acc_depreciation.setColumns(10);
		txt_acc_depreciation.setBounds(238, 311, 114, 20);
		frame.getContentPane().add(txt_acc_depreciation);
		
		btn_gexp = new DateButton();
		btn_gexp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_gexp.setBounds(234, 445, 114, 24);
		frame.getContentPane().add(btn_gexp);
		
		txt_acquisition = new DateButton();
		txt_acquisition.setBounds(238, 183, 114, 27);
		frame.getContentPane().add(txt_acquisition);
		
		txt_serialno = new JTextField();
		txt_serialno.setColumns(10);
		txt_serialno.setBounds(238, 124, 114, 20);
		frame.getContentPane().add(txt_serialno);
		
		JLabel lblSerialNumber = new JLabel("Serial Number:");
		lblSerialNumber.setForeground(Color.BLUE);
		lblSerialNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSerialNumber.setBounds(68, 119, 125, 27);
		frame.getContentPane().add(lblSerialNumber);
		
		JLabel label = new JLabel("%");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(357, 246, 12, 27);
		frame.getContentPane().add(label);
		
		JLabel lblManager = new JLabel("Manager:");
		lblManager.setForeground(Color.BLUE);
		lblManager.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblManager.setBounds(68, 407, 144, 27);
		frame.getContentPane().add(lblManager);
		
		JLabel lblGuaranteeExp = new JLabel("Guarantee Exp:");
		lblGuaranteeExp.setForeground(Color.BLUE);
		lblGuaranteeExp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGuaranteeExp.setBounds(68, 442, 144, 27);
		frame.getContentPane().add(lblGuaranteeExp);
		
		JLabel lblFinanceDetails = new JLabel("Finance Details:");
		lblFinanceDetails.setForeground(Color.BLUE);
		lblFinanceDetails.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFinanceDetails.setBounds(68, 476, 144, 27);
		frame.getContentPane().add(lblFinanceDetails);
		
		JLabel lblCapitalAllowancesDetails = new JLabel("Capital Allowances Details:");
		lblCapitalAllowancesDetails.setForeground(Color.BLUE);
		lblCapitalAllowancesDetails.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCapitalAllowancesDetails.setBounds(67, 507, 144, 27);
		frame.getContentPane().add(lblCapitalAllowancesDetails);
		
		JLabel lblInsuranceDetails = new JLabel("Insurance Details:");
		lblInsuranceDetails.setForeground(Color.BLUE);
		lblInsuranceDetails.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInsuranceDetails.setBounds(68, 538, 144, 27);
		frame.getContentPane().add(lblInsuranceDetails);
		
		txt_book_value = new JTextField();
		txt_book_value.setColumns(10);
		txt_book_value.setBounds(238, 345, 114, 20);
		frame.getContentPane().add(txt_book_value);
		
		txt_location = new JTextField();
		txt_location.setColumns(10);
		txt_location.setBounds(238, 379, 114, 20);
		frame.getContentPane().add(txt_location);
		
		txt_manager = new JTextField();
		txt_manager.setColumns(10);
		txt_manager.setBounds(238, 411, 114, 20);
		frame.getContentPane().add(txt_manager);
		
		
		btn_finance_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_finance.setForeground(Color.BLUE);
		btn_finance.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_finance.setBounds(79, 588, 122, 23);
		frame.getContentPane().add(btn_finance);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(Color.BLUE);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblId.setBounds(67, 60, 125, 27);
		frame.getContentPane().add(lblId);
		
		txt_id = new JTextField();
		txt_id.setEditable(false);
		txt_id.setColumns(10);
		txt_id.setBounds(239, 61, 114, 20);
		frame.getContentPane().add(txt_id);
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel.setBounds(36, 50, 348, 576);
		frame.getContentPane().add(panel);
	}
}
