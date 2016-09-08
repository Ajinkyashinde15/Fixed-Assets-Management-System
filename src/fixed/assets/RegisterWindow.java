package fixed.assets;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class RegisterWindow {

	JFrame frame;
	private JTextField txt_name;
	private JPasswordField txt_password;
	private JPasswordField rtxt_password;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterWindow window = new RegisterWindow();
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
	public RegisterWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(330, 140, 383, 324);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Email Address:");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(68, 71, 90, 27);
		frame.getContentPane().add(label);
		
		JButton create = new JButton("Register");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				String n = txt_name.getText();
				String p = txt_password.getText();
	                        String rp=rtxt_password.getText();
				if (n.equals("") || p.equals(""))
				{
					 JOptionPane.showMessageDialog(null, "Please Check Your Id & Password !", "Error", JOptionPane.ERROR_MESSAGE);
				}
	                        else if(!p.equals(rp))
	                        {
	                             JOptionPane.showMessageDialog(null, "Check your Password fields!", "Error", JOptionPane.ERROR_MESSAGE);
	                        }
	                        else 
				{
					        try
							{          
	                        								Class.forName("com.mysql.jdbc.Driver");			
	                        		//now we can get connection from DriverManager
	            											Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fixed_assest_db","root","");
	            											Statement stmt = con.createStatement();
	            	    
	            	                           				String temp = "INSERT INTO Login VALUES ('"+  txt_name.getText()  + "', '" + txt_password.getText()+ "')";
	                                                           
                                                            int result = stmt.executeUpdate( temp );

                                                            
	            	                                        stmt.executeQuery("SELECT * FROM Login where username='"+txt_name.getText()+"' and password='"+txt_password.getText()+"'");
	            		                                                                              
	                                                        JOptionPane.showMessageDialog(null, "New Account Created", "Done", JOptionPane.INFORMATION_MESSAGE);
	                                                        txt_name.setText("");
	                                                        txt_password.setText("");
	                                                        rtxt_password.setText("");
								    
							}
	                                                catch (Exception e1)
							{ 
	                                                    JOptionPane.showMessageDialog(null, e1.getStackTrace(), "Error", JOptionPane.ERROR_MESSAGE);      
	                                                    System.out.println(e1.getStackTrace());
	                                                    e1.printStackTrace();
	                                                }
											
				}
				
				
				
			}
		});
		create.setBounds(62, 216, 101, 23);
		frame.getContentPane().add(create);
		
		JButton cmd_cancel = new JButton("Cancel");
		cmd_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginWindow hw=new LoginWindow();
				hw.frame.setVisible(true);
				frame.hide(); 
			}
		});
		cmd_cancel.setBounds(198, 216, 101, 23);
		frame.getContentPane().add(cmd_cancel);
		
		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBounds(195, 73, 115, 20);
		frame.getContentPane().add(txt_name);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(69, 111, 90, 27);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblReTypePassword = new JLabel("Re-type Password:");
		lblReTypePassword.setForeground(Color.BLUE);
		lblReTypePassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblReTypePassword.setBounds(69, 155, 116, 27);
		frame.getContentPane().add(lblReTypePassword);
		
		txt_password = new JPasswordField();
		txt_password.setBounds(195, 115, 115, 20);
		frame.getContentPane().add(txt_password);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel.setBounds(34, 49, 302, 215);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		rtxt_password = new JPasswordField();
		rtxt_password.setBounds(160, 107, 116, 20);
		panel.add(rtxt_password);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setForeground(Color.RED);
		lblRegister.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblRegister.setBounds(141, 10, 101, 24);
		frame.getContentPane().add(lblRegister);
		
	
		
	}

}
