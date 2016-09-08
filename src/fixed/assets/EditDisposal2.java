package fixed.assets;

import java.awt.EventQueue;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.PageAttributes.OriginType;
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

public class EditDisposal2 {

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
					EditDisposal2 window = new EditDisposal2(null);
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
	public EditDisposal2(String string) {
		initialize();
		txt_did.setText(string);
		
		JButton calcprloss = new JButton(">>");
		calcprloss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fixed_assest_db","root","");                                    
		 			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );
		 			ResultSet r1 = stmt.executeQuery("select netbookvalue from fixed_asset_details where id='"+ txt_did.getText()+"'");
		 			r1.last();
		 			double netbv=Double.parseDouble(r1.getString(1));
					int p=Integer.parseInt(txt_disposalproc.getText());
					double value=p-netbv;
					System.out.println(value);
					txt_profitloss.setText(String.valueOf(value));	
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
	 			
				
			}
		});
		calcprloss.setFont(new Font("Tahoma", Font.PLAIN, 9));
		calcprloss.setBounds(298, 131, 53, 23);
		frame.getContentPane().add(calcprloss);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel.setBounds(36, 47, 348, 211);
		frame.getContentPane().add(panel);
	}
	 public void Assign(String sid)
     {
		//txt_fid.setText(sid);
         
 		try 
 		{
 			Class.forName("com.mysql.jdbc.Driver");	
 			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fixed_assest_db","root","");                                    
 			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );
 			ResultSet r1 = stmt.executeQuery("select * from asset_disposal where assetid='"+ txt_did.getText()+"'");
 	        //rs.last();
 	        int las,las1;
 	        String s;
 	        

 	        while (r1.next())
 	        {
	 	        btn_disposal.setText(r1.getString(2));
	 	        txt_disposalproc.setText((r1.getString(3)));
				txt_profitloss.setText(r1.getString(4));
			
			}
 	        
 	
 		} catch (Exception e) {

 		}

     }


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(320, 100, 439, 319);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdd = new JLabel("Edit New Dispose");
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
		
		
		
		JButton btn_finance = new JButton("Edit Dispose");
		btn_finance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (txt_disposalproc.equals("")  || txt_profitloss.equals(""))
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
													Statement stmt2 = con.createStatement();
					
	                                                String lid= txt_did.getText();

	                                                String query="update asset_disposal set disposaldate='"+btn_disposal.getText()+"',disposalproceeds='"+txt_disposalproc.getText()+"',profitlossdisposal='"+txt_profitloss.getText()+"' where assetid='"+lid+"'";
	                                                stmt.executeUpdate(query);
	                                                stmt2.executeUpdate("update fixed_asset_details set disposed='y' where id='"+lid+"'");
	                                                
	                                                
	                                                JOptionPane.showMessageDialog(null, "Disposal has been Updated ", "Done", JOptionPane.INFORMATION_MESSAGE);
	                                                frame.hide(); 
					}
	                 catch (Exception e1)
					{ 
	                                            JOptionPane.showMessageDialog(null, e1.getStackTrace(), "Error", JOptionPane.ERROR_MESSAGE);      
	                                            e1.printStackTrace();
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
		txt_disposalproc.setColumns(10);
		txt_disposalproc.setBounds(237, 132, 59, 20);
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
