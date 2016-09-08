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

public class AddIntangibleAssets {

	JFrame frame;
	private JTextField txt_description;	//declare JTextField 
	private JTextField txt_expenditure;
	private JTextField txt_validation;
	private JTextField txt_status;
	private DateButton btn_validation;	//declare DateButton [User define] 
	private JTextField txt_catagory;
	private JTextField txt_manager;
	private JTextField txt_id;

 		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddIntangibleAssets window = new AddIntangibleAssets();
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
	public AddIntangibleAssets() 
	{
		initialize();
        
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");		//load Jdbc Driver
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fixed_assest_db","root","");     //connect to database                               
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );	//create statement 
			ResultSet rs = stmt.executeQuery("select * from intagible_assets");	//select all table details
	        rs.last();	//get last id 
	        int las,las1;
	        String s;
	        if(rs.getString(1)==null || rs.getString(1)=="0")	//if nothing then set id=1
	        {
	        	txt_id.setText("1");
	        }else
	        {
	            las=Integer.parseInt(rs.getString(1));
	            las1=las+1;	//Increment id by one  
	            s=Integer.toString(las1);
	            txt_id.setText(s);	//set new id [old+1] 
	         }
	
		} catch (Exception e) {
        	txt_id.setText("1");
		}
		
	}
/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(350, 5, 439, 436);	//set window size x=350 y=5 width=439 height=436
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdd = new JLabel("Add New Intangible Assets");	//initialize label control	
		lblAdd.setForeground(Color.RED);	//set Foreground color as red to label
		lblAdd.setFont(new Font("Times New Roman", Font.BOLD, 18)); //set Font  as Times New Roman to label
		lblAdd.setBounds(98, 17, 236, 24);
		frame.getContentPane().add(lblAdd);//add label to content pane
		
		JLabel lblDateOf = new JLabel("Expenditure");
		lblDateOf.setForeground(Color.BLUE);
		lblDateOf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateOf.setBounds(68, 151, 125, 27);
		frame.getContentPane().add(lblDateOf);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setForeground(Color.BLUE);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDescription.setBounds(68, 90, 125, 27);
		frame.getContentPane().add(lblDescription);
		
		JLabel txt_validation1 = new JLabel("Valuation");
		txt_validation1.setForeground(Color.BLUE);
		txt_validation1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_validation1.setBounds(68, 182, 125, 27);
		frame.getContentPane().add(txt_validation1);
		
		JLabel lblManufacture = new JLabel("Valuation Date");
		lblManufacture.setForeground(Color.BLUE);
		lblManufacture.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblManufacture.setBounds(68, 214, 144, 27);
		frame.getContentPane().add(lblManufacture);
		
		JLabel lblDepricationRate = new JLabel("Application Status");
		lblDepricationRate.setForeground(Color.BLUE);
		lblDepricationRate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDepricationRate.setBounds(68, 248, 144, 27);
		frame.getContentPane().add(lblDepricationRate);
		
	
		
		
		JButton btn_finance = new JButton("Add Intangible ");
		btn_finance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			
				 if (txt_id.equals("")  ||txt_catagory.equals("") ||txt_description.equals("") ||txt_expenditure.equals("") || txt_manager.equals("")|| txt_status.equals("")|| txt_validation.equals(""))
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
	 	                                                            
	 	                                            				String temp1 = "INSERT INTO intagible_assets VALUES ('"+ txt_id.getText() +"','"+ txt_description.getText()+"','"+ txt_catagory.getText()+"','"+ txt_expenditure.getText()+"','"+ txt_validation.getText()+"','"+ btn_validation.getText()+"','"+ txt_status.getText()+"','"+txt_manager.getText()+"')";  //insert values into intagible_assets table
	 	                                            				int result2 = statement.executeUpdate( temp1 ); //execute above command 
	 	                                                            
	 	                                                            //JOptionPane.showMessageDialog(null, "Finance data has been Added ", "Done", JOptionPane.INFORMATION_MESSAGE);
	 	                                                             
	 	                                                }
	 	                                                catch (Exception e1)
	 	                                                { 
	 	                                                    JOptionPane.showMessageDialog(null, e1.getStackTrace(), "Error", JOptionPane.ERROR_MESSAGE);      
	 	                                                    e1.printStackTrace();
	 	                                                }
	 						}				

	            	 

				JOptionPane.showMessageDialog(null, "Intangible Assest has been Added ", "Done", JOptionPane.INFORMATION_MESSAGE); //show message
                  
                txt_id.setText("");
                txt_description.setText("");
                txt_catagory.setText("");
                txt_expenditure.setText("");
                btn_validation.setText("");
                txt_validation.setText(""); 
                txt_status.getText();
                txt_manager.setText("");  
                txt_description.setText("");
                txt_expenditure.setText("");
                txt_validation.setText("");
                txt_status.setText("");
                btn_validation.setText("");
              	
			}
		});

		JButton cmd_cancel = new JButton("Cancel");
		cmd_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				HomeWindow l=new HomeWindow();
				l.frame.setVisible(true);	//open new window
				frame.hide(); //hide current frame
            }
		});
		cmd_cancel.setForeground(Color.BLUE);
		cmd_cancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmd_cancel.setBounds(213, 337, 122, 23);
		frame.getContentPane().add(cmd_cancel);
		
		txt_description = new JTextField();
		txt_description.setColumns(10);
		txt_description.setBounds(238, 92, 114, 20);
		frame.getContentPane().add(txt_description);
		
		txt_expenditure = new JTextField();
		txt_expenditure.setColumns(10);
		txt_expenditure.setBounds(238, 155, 114, 20);
		frame.getContentPane().add(txt_expenditure);
		
		txt_validation = new JTextField();
		txt_validation.setColumns(10);
		txt_validation.setBounds(238, 186, 114, 20);
		frame.getContentPane().add(txt_validation);
		
		txt_status = new JTextField();
		txt_status.setColumns(10);
		txt_status.setBounds(238, 251, 114, 20);
		frame.getContentPane().add(txt_status);
		
		btn_validation = new DateButton();
		btn_validation.setBounds(238, 215, 114, 27);
		frame.getContentPane().add(btn_validation);
		
		txt_catagory = new JTextField();
		txt_catagory.setColumns(10);
		txt_catagory.setBounds(238, 124, 114, 20);
		frame.getContentPane().add(txt_catagory);
		
		JLabel lblSerialNumber = new JLabel("Catagory");
		lblSerialNumber.setForeground(Color.BLUE);
		lblSerialNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSerialNumber.setBounds(68, 119, 125, 27);
		frame.getContentPane().add(lblSerialNumber);
		
		JLabel lblManager = new JLabel("Manager:");
		lblManager.setForeground(Color.BLUE);
		lblManager.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblManager.setBounds(67, 286, 144, 27);
		frame.getContentPane().add(lblManager);
		
		txt_manager = new JTextField();
		txt_manager.setColumns(10);
		txt_manager.setBounds(239, 288, 114, 20);
		frame.getContentPane().add(txt_manager);
		btn_finance.setForeground(Color.BLUE);
		btn_finance.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_finance.setBounds(81, 337, 122, 23);
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
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), Color.BLACK, Color.BLACK));
		panel.setBounds(36, 48, 350, 327);
		frame.getContentPane().add(panel);
	}
}
