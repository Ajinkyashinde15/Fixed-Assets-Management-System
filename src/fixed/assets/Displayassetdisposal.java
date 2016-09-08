package fixed.assets;

import java.awt.EventQueue;
import java.awt.EventQueue;
import java.awt.EventQueue;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;


public class Displayassetdisposal {

	JFrame frame;
	private JTable tbpat;
	String head2[] ={ "AssetId ","Disposal Date","Disposal Proceeds","Profit/Loss Disposal"};	//define table's header  
	DefaultTableModel dtm;	//initialize table controller variable 
	JScrollPane jsp;	//initialize scroll bar controller variable
	ResultSet rs1, rs2;
	Connection con;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
   		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Displayassetdisposal window = new Displayassetdisposal();
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
	public void createCon()
	{
		try
		{
		    Class.forName("com.mysql.jdbc.Driver");	
		    con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fixed_assest_db","root","");       
    	}
		catch (Exception e)
		{ System.out.println("Error in Con :" + e); }
	}

	public void showRecords()
	{
		dtm.setRowCount(0);
		System.gc();
		try
		{
			createCon();
                 
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
			ResultSet.CONCUR_UPDATABLE);
			ResultSet r1;// store temporary table data
			r1 = st.executeQuery("select * from asset_disposal");
			String[] t = new String[20];
			//System.out.println("hi- "+r1.getString("id"));
			//System.out.println("hi1- "+r1.getString(0));
			
		
				while (r1.next())	//iterate until last row 
				{
					t[0] = r1.getString(1);	//get first column value and store in first column of table 
	                t[1]=  r1.getString(2); //get second column value and store in first column of table 
					t[2] = r1.getString(3);
					t[3] = r1.getString(4);
				
					dtm.addRow(t);	//add row into table
				}
			}
		catch (Exception e)
		{
			System.out.println("Error :" + e); 
			e.printStackTrace();
		}
	}

	public Displayassetdisposal() {
		initialize();
		createCon();
		dtm = new DefaultTableModel();
		dtm.setColumnIdentifiers(head2);	//set column header
		tbpat = new JTable(dtm);
		jsp = new JScrollPane(tbpat);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(21, 26, 666, 334);
		frame.getContentPane().add(jsp);	//add scrollbar 
		tbpat.setRowHeight(20);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{	
                HomeWindow h=new HomeWindow();
				h.frame.setVisible(true);
                frame.hide(); 

			}
		});
		btnNewButton.setBounds(323, 381, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		tbpat = new JTable();
		tbpat.setBounds(21, 26, 473, 323);
		tbpat.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		tbpat.setBackground(new Color(192, 192, 192));
		frame.getContentPane().add(tbpat);
		showRecords();	//call showRecords() method 
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(150, 130, 724, 453);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
}
