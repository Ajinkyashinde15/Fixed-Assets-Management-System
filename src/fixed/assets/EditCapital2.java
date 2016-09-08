package fixed.assets;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class EditCapital2 extends JFrame {

	private JPanel contentPane;
	JFrame frame;
	private JTextField txt_cadetails;
	private JTextField txt_manager;
	private DateButton start_date,end_date;
	private JTextField txt_cid;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try {
					EditCapital2 frame = new EditCapital2(null);
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
	public EditCapital2(String string) {
		initialize();
		txt_cid.setText(string.toString());
	}

	public void Assign(String sid)
     {
         txt_cid.setText(String.valueOf(sid));
         
 		try 
 		{
 			Class.forName("com.mysql.jdbc.Driver");	
 			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fixed_assest_db","root","");                                    
 			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );
 			ResultSet r1 = stmt.executeQuery("select * from capitalallowances where assetid='"+txt_cid.getText()+"'");
 	        //rs.last();
 	        int las,las1;
 	        String s;
 	        
 	        while (r1.next())
 	        {
	 	        txt_cadetails .setText(r1.getString(2)); //load CA details data into textbox 
	 	        start_date.setText((r1.getString(3))); //load Start Date data into start_date  textbox
				end_date.setText(r1.getString(4));
				txt_manager.setText( r1.getString(5));			
			}
 	
 		} catch (Exception e) {
 		}

     }


	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(320, 100, 402, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdd = new JLabel("Edit Capital Allowances");
		lblAdd.setForeground(Color.RED);
		lblAdd.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdd.setBounds(104, 11, 204, 24);
		frame.getContentPane().add(lblAdd);
		
		JLabel lblDateOf = new JLabel("Start Date:");
		lblDateOf.setForeground(Color.BLUE);
		lblDateOf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateOf.setBounds(69, 127, 125, 27);
		frame.getContentPane().add(lblDateOf);
		
		JLabel lblDescription = new JLabel("CA Details:");
		lblDescription.setForeground(Color.BLUE);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDescription.setBounds(70, 89, 125, 27);
		frame.getContentPane().add(lblDescription);
		
		JLabel lblManufacture = new JLabel("End Date:");
		lblManufacture.setForeground(Color.BLUE);
		lblManufacture.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblManufacture.setBounds(69, 170, 144, 27);
		frame.getContentPane().add(lblManufacture);
		
		JLabel lblDepricationRate = new JLabel("Manager");
		lblDepricationRate.setForeground(Color.BLUE);
		lblDepricationRate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDepricationRate.setBounds(69, 207, 144, 27);
		frame.getContentPane().add(lblDepricationRate);
		
		JButton btn_finance = new JButton("Edit Capital");
		btn_finance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (txt_cadetails.equals("")  ||txt_manager.equals("") )
				{
					 JOptionPane.showMessageDialog(null, "Please Enter all required fields ! ", "Error", JOptionPane.ERROR_MESSAGE);
				}
	            else 
				{
	            
	  	          				try
	  	      				{   							
	  	                      	 							Class.forName("com.mysql.jdbc.Driver");			
	  	      												Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fixed_assest_db","root","");
	  	      												Statement stmt = con.createStatement();

	  	                                                      String query="update capitalallowances set assetid='"+txt_cid.getText()+"',cadetails='"+txt_cadetails.getText()+"',startdate='"+start_date.getText()+"',enddate='"+end_date.getText()+"',manager='"+txt_manager.getText()+"' where assetid='"+txt_cid.getText()+"'"; //update capitalallowances table and set new value
	  	                                                      stmt.executeUpdate(query);  //execute above query
	  	                                                              
	  	                                                      JOptionPane.showMessageDialog(null, "Capital has been Updated ", "Done", JOptionPane.INFORMATION_MESSAGE);
	  	                                                      frame.hide(); 
	  	      				}
	  	                       catch (Exception e1)
	  	      				{ 
	  	                                                  JOptionPane.showMessageDialog(null, e1.getStackTrace(), "Error", JOptionPane.ERROR_MESSAGE);      
	  	                                                  e1.printStackTrace();
	  	                      }

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
		cmd_cancel.setBounds(210, 256, 97, 23);
		frame.getContentPane().add(cmd_cancel);
		
		txt_cadetails = new JTextField();
		txt_cadetails.setColumns(10);
		txt_cadetails.setBounds(206, 90, 114, 20);
		frame.getContentPane().add(txt_cadetails);
		
		txt_manager = new JTextField();
		txt_manager.setColumns(10);
		txt_manager.setBounds(206, 211, 114, 20);
		frame.getContentPane().add(txt_manager);
		
		start_date = new DateButton();
		start_date.setBounds(204, 128, 114, 27);
		frame.getContentPane().add(start_date);
		btn_finance.setForeground(Color.BLUE);
		btn_finance.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_finance.setBounds(86, 256, 108, 23);
		frame.getContentPane().add(btn_finance);
		
		end_date = new DateButton();
		DateButton end_date = new DateButton();
		end_date.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		end_date.setBounds(206, 169, 114, 27);
		frame.getContentPane().add(end_date);
		
		JLabel lblAssetId = new JLabel("Asset ID:");
		lblAssetId.setForeground(Color.BLUE);
		lblAssetId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAssetId.setBounds(69, 54, 125, 27);
		frame.getContentPane().add(lblAssetId);
		
		txt_cid = new JTextField();
		txt_cid.setEditable(false);
		txt_cid.setColumns(10);
		txt_cid.setBounds(206, 59, 114, 20);
		frame.getContentPane().add(txt_cid);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), Color.BLACK, Color.BLACK));
		panel.setBounds(38, 44, 316, 264);
		frame.getContentPane().add(panel);
	
	}

}
