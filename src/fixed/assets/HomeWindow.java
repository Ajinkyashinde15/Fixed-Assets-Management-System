package fixed.assets;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class HomeWindow {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeWindow window = new HomeWindow();
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
	public HomeWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(340, 150, 409, 535);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Add New Fixed Assest");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AddNewFixedAsset hw=new AddNewFixedAsset(null,null);
				hw.frame.setVisible(true);
				frame.hide(); 
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(91, 57, 214, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnEditFixedAssest = new JButton("Edit Fixed Assest Details");
		btnEditFixedAssest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{

				EditFixedAssets1 hw1=new EditFixedAssets1();
				hw1.frame.setVisible(true);
				frame.hide(); 
			}
		});
		btnEditFixedAssest.setForeground(Color.BLUE);
		btnEditFixedAssest.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditFixedAssest.setBounds(91, 90, 214, 23);
		frame.getContentPane().add(btnEditFixedAssest);
		
		JButton btnUpdateData = new JButton("Display Intangible Assets");
		btnUpdateData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayIntangibleAssets d=new DisplayIntangibleAssets();
				d.frame.setVisible(true);
				frame.hide(); 
			}
		});
		btnUpdateData.setForeground(Color.BLUE);
		btnUpdateData.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdateData.setBounds(91, 399, 214, 23);
		frame.getContentPane().add(btnUpdateData);
		
		JButton btnIntangibleAssets = new JButton("Display Disposals");
		btnIntangibleAssets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Displayassetdisposal d=new Displayassetdisposal();
				d.frame.setVisible(true);
				frame.hide(); 
			}
		});
		btnIntangibleAssets.setForeground(Color.BLUE);
		btnIntangibleAssets.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIntangibleAssets.setBounds(91, 261, 214, 23);
		frame.getContentPane().add(btnIntangibleAssets);
		
		JButton btnDleleteAssetsEntry = new JButton("Display Insurance Details ");
		btnDleleteAssetsEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{

				DisplayInsurance d=new DisplayInsurance();
				d.frame.setVisible(true);
				frame.hide(); 
			}
		});
		btnDleleteAssetsEntry.setForeground(Color.BLUE);
		btnDleleteAssetsEntry.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDleleteAssetsEntry.setBounds(91, 227, 214, 23);
		frame.getContentPane().add(btnDleleteAssetsEntry);
		
		JLabel lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setForeground(Color.RED);
		lblMainMenu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMainMenu.setBounds(155, 11, 101, 24);
		frame.getContentPane().add(lblMainMenu);
		
		JButton btnDisplayAssetsEntry = new JButton("Display Fixed Assets Details");
		btnDisplayAssetsEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{

				DisplayFixedAsset hw5=new DisplayFixedAsset();
				hw5.frame.setVisible(true);
				frame.hide(); 
			}
		});
		btnDisplayAssetsEntry.setForeground(Color.BLUE);
		btnDisplayAssetsEntry.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDisplayAssetsEntry.setBounds(91, 124, 214, 23);
		frame.getContentPane().add(btnDisplayAssetsEntry);
		
		JButton btnPrintFixedAssets = new JButton("Add Intangible Assets");
		btnPrintFixedAssets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				AddIntangibleAssets hw5=new AddIntangibleAssets();
				hw5.frame.setVisible(true);
				frame.hide(); 
             }
		});
		btnPrintFixedAssets.setForeground(Color.BLUE);
		btnPrintFixedAssets.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPrintFixedAssets.setBounds(91, 329, 214, 23);
		frame.getContentPane().add(btnPrintFixedAssets);
		
		JButton btnEditIntangibleAssets = new JButton("Edit Intangible Assets");
		btnEditIntangibleAssets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				EditIntangibleAssets1 hw5=new EditIntangibleAssets1();
				hw5.frame.setVisible(true);
				frame.hide(); 
			}
		});
		btnEditIntangibleAssets.setForeground(Color.BLUE);
		btnEditIntangibleAssets.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditIntangibleAssets.setBounds(91, 365, 214, 23);
		frame.getContentPane().add(btnEditIntangibleAssets);
		
		JButton btnDisplayCapitalAllowancedetails = new JButton("Display Capital Allowance Details");
		btnDisplayCapitalAllowancedetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayCapitalDetails d=new DisplayCapitalDetails();
				d.frame.setVisible(true);
				frame.hide(); 
			}
		});
		btnDisplayCapitalAllowancedetails.setForeground(Color.BLUE);
		btnDisplayCapitalAllowancedetails.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDisplayCapitalAllowancedetails.setBounds(91, 191, 214, 23);
		frame.getContentPane().add(btnDisplayCapitalAllowancedetails);
		
		JButton btnUpdateNetBook = new JButton("Update Net Book Value");
		btnUpdateNetBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");	
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fixed_assest_db","root","");                                    
					Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );
					ResultSet rs = stmt.executeQuery("select * from fixed_asset_details where disposed='n'");
	
					Statement stmt1 = con.createStatement();
					Statement stmt2 = con.createStatement();

					
					
					while(rs.next())
					{
						double  cost=Double.parseDouble(rs.getString("cost"));
						double dprate=Double.parseDouble(rs.getString("depreciation"));
						double accdprate=Double.parseDouble(rs.getString("accumulateddepreciation"));
						//JOptionPane.showMessageDialog(null, "cot= "+cost+" depreciation= "+dprate+"accumulateddepreciation="+accdprate, "Done", JOptionPane.INFORMATION_MESSAGE);

						double updateaccdprate=(cost*(dprate/100))+accdprate;
						String query1="update fixed_asset_details set accumulateddepreciation='"+updateaccdprate+"' where id='"+rs.getString("id")+"'";
	                    stmt2.executeUpdate(query1);
	                      
						double updnetbookvalue=cost-updateaccdprate;	//Calculate net Book Value
						String query="update fixed_asset_details set netbookvalue='"+updnetbookvalue+"' where id='"+rs.getString("id")+"'"; //update and set new netbookvalu0e
                        stmt1.executeUpdate(query);
                        
                        //stmt2.executeUpdate("update fixed_asset_details set disposed='y' where id='"+rs.getString("id")+"'");
                                
                        
					}
					JOptionPane.showMessageDialog(null, "Net Value has been Updated ", "Done", JOptionPane.INFORMATION_MESSAGE);

				} catch (Exception e1)
				{
						e1.printStackTrace();
				}
			}
		});
		btnUpdateNetBook.setForeground(Color.BLUE);
		btnUpdateNetBook.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdateNetBook.setBounds(91, 295, 214, 23);
		frame.getContentPane().add(btnUpdateNetBook);
		
		JButton btnPrintAssetsReports = new JButton("Print Assets Reports");
		btnPrintAssetsReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				PrintDisplayFixedAsset p=new PrintDisplayFixedAsset();
				p.frame.setVisible(true);
				frame.hide();
				
			}
		});
		btnPrintAssetsReports.setForeground(Color.BLUE);
		btnPrintAssetsReports.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPrintAssetsReports.setBounds(91, 433, 214, 23);
		frame.getContentPane().add(btnPrintAssetsReports);
		
		JButton display_finance = new JButton("Display Assets Finance Details");
		display_finance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayFinanceDetails d=new DisplayFinanceDetails();
				d.frame.setVisible(true);
				frame.hide(); 
			}
		});
		display_finance.setForeground(Color.BLUE);
		display_finance.setFont(new Font("Tahoma", Font.BOLD, 11));
		display_finance.setBounds(91, 158, 214, 23);
		frame.getContentPane().add(display_finance);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel.setBounds(45, 46, 305, 423);
		frame.getContentPane().add(panel);
	}
}
