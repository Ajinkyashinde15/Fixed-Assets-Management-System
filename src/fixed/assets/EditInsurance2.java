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
import java.awt.image.renderable.RenderableImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
public class EditInsurance2 extends JFrame {

	private JPanel contentPane;
	JFrame frame;
	private JTextField txt_insurer;
	private JTextField txt_policyno;
	private JTextField txt_manager;
	private DateButton btn_renewaldate;
	private JTextField txt_iid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditInsurance2 frame = new EditInsurance2(null);
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
	 public void Assign(String sid)
     {
		//txt_fid.setText(sid);
         
 		try 
 		{
 			Class.forName("com.mysql.jdbc.Driver");	
 			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fixed_assest_db","root","");                                    
 			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );
 			ResultSet r1 = stmt.executeQuery("select * from insurence where assetid='"+txt_iid.getText()+"'");
 	        //rs.last();
 	        int las,las1;
 	        String s;
 	        

 	        while (r1.next())
 	        {
	 	        txt_insurer.setText(r1.getString(2));
	 	        btn_renewaldate.setText((r1.getString(3)));
				txt_policyno.setText(r1.getString(4));
				txt_manager.setText( r1.getString(5));			
			}
 	        
 	
 		} catch (Exception e) {

 		}

     }


	public EditInsurance2(String string) {
		initialize();
		txt_iid.setText(string.toString());
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(320, 100, 439, 349);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdd = new JLabel("Edit Insurance");
		lblAdd.setForeground(Color.RED);
		lblAdd.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdd.setBounds(149, 11, 180, 24);
		frame.getContentPane().add(lblAdd);
		
		JLabel lblDateOf = new JLabel("Policy No:");
		lblDateOf.setForeground(Color.BLUE);
		lblDateOf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateOf.setBounds(69, 152, 125, 27);
		frame.getContentPane().add(lblDateOf);
		
		JLabel lblDescription = new JLabel("Renewal Date:");
		lblDescription.setForeground(Color.BLUE);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDescription.setBounds(69, 121, 125, 27);
		frame.getContentPane().add(lblDescription);
		
		JLabel lblPurchaseOrderNo = new JLabel("Manager:");
		lblPurchaseOrderNo.setForeground(Color.BLUE);
		lblPurchaseOrderNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPurchaseOrderNo.setBounds(69, 183, 125, 27);
		frame.getContentPane().add(lblPurchaseOrderNo);
		
		
		
		JButton btn_finance = new JButton("Edit Insurance");
		btn_finance.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				if (txt_manager.equals("")  || txt_insurer.equals("") ||txt_policyno.equals(""))
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

					
	                                                String lid= txt_iid.getText();
	                                                
	                                                String query="update insurence set insure='"+txt_insurer.getText()+"',renewaldate='"+ btn_renewaldate .getText()+"',policyno='"+txt_policyno.getText()+"',manager='"+txt_manager.getText()+"' where assetid='"+lid+"'";
	                                                stmt.executeUpdate(query);
	                                                        
	                                                JOptionPane.showMessageDialog(null, "Insurance has been Updated ", "Done", JOptionPane.INFORMATION_MESSAGE);
	                                               frame.hide(); 
					}
	                 catch (Exception e1)
					{ 
	                                            JOptionPane.showMessageDialog(null, e1.getStackTrace(), "Error", JOptionPane.ERROR_MESSAGE);      
	                                            e1.printStackTrace();
	                }
					
	                 //AddNewFixedAsset l=new AddNewFixedAsset(insurance_list,"insurance");
	            	 //l.frame.setVisible(true);
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
		cmd_cancel.setBounds(220, 238, 122, 23);
		frame.getContentPane().add(cmd_cancel);
		
		txt_insurer = new JTextField();
		txt_insurer.setColumns(10);
		txt_insurer.setBounds(239, 93, 114, 20);
		frame.getContentPane().add(txt_insurer);
		
		txt_policyno = new JTextField();
		txt_policyno.setColumns(10);
		txt_policyno.setBounds(239, 156, 114, 20);
		frame.getContentPane().add(txt_policyno);
		
		txt_manager = new JTextField();
		txt_manager.setColumns(10);
		txt_manager.setBounds(239, 187, 114, 20);
		frame.getContentPane().add(txt_manager);
		
		btn_renewaldate = new DateButton();
		btn_renewaldate.setBounds(239, 122, 114, 27);
		frame.getContentPane().add(btn_renewaldate);
		
		JLabel lblSerialNumber = new JLabel("Insurer:");
		lblSerialNumber.setForeground(Color.BLUE);
		lblSerialNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSerialNumber.setBounds(69, 89, 125, 27);
		frame.getContentPane().add(lblSerialNumber);
		btn_finance.setForeground(Color.BLUE);
		btn_finance.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_finance.setBounds(88, 238, 122, 23);
		frame.getContentPane().add(btn_finance);
		
		JLabel label = new JLabel("ID:");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(69, 59, 125, 27);
		frame.getContentPane().add(label);
		
		txt_iid = new JTextField();
		txt_iid.setEditable(false);
		txt_iid.setColumns(10);
		txt_iid.setBounds(239, 62, 114, 20);
		frame.getContentPane().add(txt_iid);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel.setBounds(36, 46, 348, 238);
		frame.getContentPane().add(panel);
	}

}
