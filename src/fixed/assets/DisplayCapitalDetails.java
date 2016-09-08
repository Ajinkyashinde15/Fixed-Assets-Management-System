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


public class DisplayCapitalDetails {

	JFrame frame;
	private JTable tbpat;
	String head2[] ={ "AssetId ","CA Details","Start Date","End Date","Manager"};
	DefaultTableModel dtm;
	JScrollPane jsp;
	ResultSet rs1, rs2;
	Connection con;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
   		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayCapitalDetails window = new DisplayCapitalDetails();
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
			ResultSet r1;
			r1 = st.executeQuery("select * from capitalallowances");
			String[] t = new String[20];
			//System.out.println("hi- "+r1.getString("id"));
			//System.out.println("hi1- "+r1.getString(0));
			
		
				while (r1.next())
				{
					t[0] = r1.getString(1);
	                t[1]=  r1.getString(2);
					t[2] = r1.getString(3);
					t[3] = r1.getString(4);
					t[4] = r1.getString(5);			
				
					dtm.addRow(t);
				}
			}
		catch (Exception e)
		{
			System.out.println("Error :" + e); 
			e.printStackTrace();
		}
	}

	public DisplayCapitalDetails() {
		initialize();
		createCon();
		dtm = new DefaultTableModel();
		dtm.setColumnIdentifiers(head2);
		tbpat = new JTable(dtm);
		jsp = new JScrollPane(tbpat);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(21, 26, 666, 334);
		frame.getContentPane().add(jsp);
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
		showRecords();

		
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
