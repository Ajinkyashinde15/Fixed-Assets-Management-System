package fixed.assets;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

public class LoginWindow {

	JFrame frame;
	private JTextField txt_name;
	private JPasswordField txt_password;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
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
	public LoginWindow() {
		initialize();
			}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(350, 200, 348, 326);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.RED);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblLogin.setBounds(130, 11, 101, 24);
		frame.getContentPane().add(lblLogin);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel.setBounds(25, 46, 283, 189);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email Address:");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(22, 26, 90, 27);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(22, 83, 90, 27);
		panel.add(lblPassword);
		
		txt_name = new JTextField();
		txt_name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				txt_name.requestFocus();
			}
		});
		txt_name.setBounds(144, 30, 116, 20);
		panel.add(txt_name);
		txt_name.setColumns(10);
		
		JButton cmd_login = new JButton("Login");
		cmd_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				if( txt_name.getText()=="")
				{
						JOptionPane.showMessageDialog(null, "Please enter value");
				}
				try
				{	
														Class.forName("com.mysql.jdbc.Driver");			
				//now we can get connection from DriverManager
														Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fixed_assest_db","root","");
														Statement stmt = con.createStatement();
	    
	                                                    ResultSet rs = stmt.executeQuery("SELECT * FROM login where username='"+txt_name.getText()+"' and password='"+txt_password.getText()+"'");
	
	                                                    if (rs.next()) 
	                                                    {
	                                                        JOptionPane.showMessageDialog(null, "Login Successful", "Sorry", JOptionPane.INFORMATION_MESSAGE);
	                                                        
	                                                        HomeWindow hw=new HomeWindow();
	                                                        hw.frame.setVisible(true);
	                                                        frame.hide(); 
	                                                        
	                                                    }else
	                                                    {
	                                                        JOptionPane.showMessageDialog(null, "Please check your email or password", "Sorry", JOptionPane.ERROR_MESSAGE);
	                                                    }          
	                                        
					}
					catch (Exception e1)
					{
						System.out.println("Error in creating DSN [Login]:" + e);
						e1.printStackTrace();
					}
				}
		});
		cmd_login.setBounds(22, 137, 101, 23);
		panel.add(cmd_login);
		
		txt_password = new JPasswordField();
		txt_password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_password.requestFocus();
			}
		});
		txt_password.setBounds(144, 87, 116, 20);
		panel.add(txt_password);
		
		JButton cmd_cancel = new JButton("Cancel");
		cmd_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		cmd_cancel.setBounds(159, 137, 101, 23);
		panel.add(cmd_cancel);
		
		JButton create = new JButton("Create New Account");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
               
				RegisterWindow r=new RegisterWindow();
				r.frame.setVisible(true);
             }
		});
		create.setBounds(25, 250, 157, 23);
		frame.getContentPane().add(create);
	}
}
