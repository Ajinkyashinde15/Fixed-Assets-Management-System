/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fixed.assets;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PageFormat;
import java.sql.*;
import javax.swing.*;
import java.awt.print.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class PrintWindow extends JFrame implements ActionListener,Printable
{
    JFrame frame;
	JLabel		disposal,id,cost,error,login,order_no,date_acq,deprication_rate,description,serial_no,deprication,expiry_date;
	JTextField	txt_id,txt_name,txt_description,txt_deprication_rate,txt_order_no,txt_serial_no,txt_cost,txt_deprication;
	JPasswordField 	txt_password,rtxt_password;
	ImageIcon	[]image=new ImageIcon[5];
	JButton		cmd_cancel,create;
	Connection	con;
	String database = "";
        private DateButton adate,txt_disposal,txt_expiry_date;
        String sid,sdescription, sdate_acquisition,sorder_no, sserial_no,scost,sexpiry_date, sdepreciation_method, sdepreciation_rate, sdisposal_date;
        private int PAGE_EXISTS;
        private int NO_SUCH_PAGE;
        Component comp;
        
        public void Assign(String sid) throws Exception
        {
                  //txt_id.setText(String.valueOf(sid));
        		  txt_id.setText("1");
                  Class.forName("com.mysql.jdbc.Driver");	
      		      con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fixed_assest_db","root","");       Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );
        
                  ResultSet rs = stmt.executeQuery("select * from fixed_asset_details where id='"+txt_id.getText()+"'");
                     
                  if (rs.next()) {
                    adate.setText(rs.getString(2));
                    txt_order_no.setText(rs.getString(3));
                    txt_serial_no.setText(rs.getString(4));
                    txt_cost.setText(rs.getString(5));
                    txt_expiry_date.setText(rs.getString(6));
                    txt_deprication.setText(rs.getString(7));
                    txt_deprication_rate.setText(rs.getString(8));
                    txt_disposal.setText(rs.getString(9));
                    txt_description.setText(rs.getString(10));
                   }
                  
        }
        
        public PrintWindow(Component comp)
        {
            this.comp = comp;
        }
        
        public int print(Graphics g, PageFormat format, int page_index) 
            throws PrinterException {

            
            if (page_index > 0) {
                return NO_SUCH_PAGE;
            }

            Dimension dim = comp.getSize();
            double cHeight = dim.getHeight();
            double cWidth = dim.getWidth();

            // get the bounds of the printable area
            double pHeight = format.getImageableHeight();
            double pWidth = format.getImageableWidth();

            double pXStart = format.getImageableX();
            double pYStart = format.getImageableY();

            double xRatio = pWidth / cWidth;
            double yRatio = pHeight / cHeight;

            Graphics2D g2d = (Graphics2D)g;
            g2d.translate(pXStart, pYStart);
            g2d.scale(xRatio, yRatio);
            comp.paint(g2d);
            // java.awt.Frame.
//            frameToPrint.printAll(g);

            return PAGE_EXISTS;
        }   
        public void PrintUIWindow(JFrame f) 
        {
              frame = f;
        }
 
        PrintWindow() 
        {
		  super("Print Window");
                 
                getContentPane().setLayout(null);		
		setDefaultLookAndFeelDecorated(true);
		setTitle("    Edit Fixed Asset ");
		image[4] = new ImageIcon("INF//row_canoe.gif"); 
		login=new JLabel("Edit Fixed Asset");
		login.setBounds(140,25,250,50);
		getContentPane().add(login);
		login.setForeground(Color.red);
		login.setIcon(image[4]);
		login.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                
                id=new JLabel("ID:");
                id.setFont(new Font("Tahoma", Font.BOLD, 11));
		id.setBounds(80,95,120,20);
		getContentPane().add(id);
		id.setForeground(Color.blue);

		txt_id=new JTextField("");
		txt_id.setBounds(240,95,120,20);
		getContentPane().add(txt_id);
		txt_id.addActionListener(this);
                txt_id.setEditable(false);
                
		date_acq=new JLabel("Date of Acquisition:");
		date_acq.setFont(new Font("Tahoma", Font.BOLD, 11));
		date_acq.setBounds(80,120,150,50);
		getContentPane().add(date_acq);
		date_acq.setForeground(Color.blue);	
                //name.setPreferredSize(new Dimension(150,20));

		adate=new DateButton();
		adate.setBounds(240,135,120,20);
		getContentPane().add(adate);
		adate.addActionListener(this);
		//txt_name.addKeyListener(this);

		description=new JLabel("Description:");
		description.setFont(new Font("Tahoma", Font.BOLD, 11));
		description.setBounds(80,180,100,20);
		getContentPane().add(description);
		description.setForeground(Color.blue);

		txt_description=new JTextField("");
		txt_description.setBounds(240,180,120,20);
		getContentPane().add(txt_description);
		txt_description.addActionListener(this);

                order_no=new JLabel("Purchase Order No.:");
                order_no.setFont(new Font("Tahoma", Font.BOLD, 11));
		order_no.setBounds(80,230,120,20);
		getContentPane().add(order_no);
		order_no.setForeground(Color.blue);

		txt_order_no=new JTextField("");
		txt_order_no.setBounds(240,230,120,20);
		getContentPane().add(txt_order_no);
		txt_order_no.addActionListener(this);

                serial_no=new JLabel("Manufacturer Serial No.:");
                serial_no.setFont(new Font("Tahoma", Font.BOLD, 11));
		serial_no.setBounds(80,280,150,20);
		getContentPane().add(serial_no);
		serial_no.setForeground(Color.blue);

		txt_serial_no=new JTextField("");
		txt_serial_no.setBounds(240,280,120,20);
		getContentPane().add(txt_serial_no);
		txt_serial_no.addActionListener(this);

                cost=new JLabel("Cost: ");
                cost.setFont(new Font("Tahoma", Font.BOLD, 11));
		cost.setBounds(80,320,120,20);
		getContentPane().add(cost);
		cost.setForeground(Color.blue);

		txt_cost=new JTextField("");
		txt_cost.setBounds(240,320,120,20);
		getContentPane().add(txt_cost);
		txt_cost.addActionListener(this);

                expiry_date=new JLabel("Guarantee Expiry Date:");
                expiry_date.setFont(new Font("Tahoma", Font.BOLD, 11));
		expiry_date.setBounds(80,370,150,20);
		getContentPane().add(expiry_date);
		expiry_date.setForeground(Color.blue);

		txt_expiry_date=new DateButton();
		txt_expiry_date.setBounds(240,370,120,20);
		getContentPane().add(txt_expiry_date);
		txt_expiry_date.addActionListener(this);
                
                deprication=new JLabel("Depreciation Method:");
                deprication.setFont(new Font("Tahoma", Font.BOLD, 11));
		deprication.setBounds(80,420,120,20);
		getContentPane().add(deprication);
		deprication.setForeground(Color.blue);

		txt_deprication=new JTextField();
		txt_deprication.setBounds(240,420,120,20);
		getContentPane().add(txt_deprication);
		txt_deprication.addActionListener(this);

                deprication_rate=new JLabel("Depreciation Rate:");
                deprication_rate.setFont(new Font("Tahoma", Font.BOLD, 11));
		deprication_rate.setBounds(80,470,120,20);
		getContentPane().add(deprication_rate);
		deprication_rate.setForeground(Color.blue);

		txt_deprication_rate=new JTextField();
		txt_deprication_rate.setBounds(240,470,120,20);
		getContentPane().add(txt_deprication_rate);
		txt_deprication_rate.addActionListener(this);

                disposal=new JLabel("Disposal Date:");
                disposal.setFont(new Font("Tahoma", Font.BOLD, 11));
		disposal.setBounds(80,520,120,20);
		getContentPane().add(disposal);
		disposal.setForeground(Color.blue);

		txt_disposal=new DateButton();
		txt_disposal.setBounds(240,520,120,20);
		getContentPane().add(txt_disposal);
		txt_disposal.addActionListener(this);

                
		create=new JButton("Print");
		create.setFont(new Font("Tahoma", Font.PLAIN, 12));
		create.setBounds(120,580,100,30);
		getContentPane().add(create);
		create.addActionListener(this);

		cmd_cancel = new JButton("Cancel");
		cmd_cancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmd_cancel.setBounds(240, 580, 100, 30);
		getContentPane().add(cmd_cancel);
		cmd_cancel.addActionListener(this);


		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(50, 80, 350, 550);
		getContentPane().add(jsp);


		paintComponents(getGraphics());
		
		setBounds(350,30,450,690);		
	
		setResizable(false);			   
		setIconImage(new ImageIcon("INF/Icon.png").getImage());		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
                
               if (ae.getSource() == create)
               {
                    JFrame yourComponent = new JFrame();
                    PrinterJob pjob = PrinterJob.getPrinterJob();
                    PageFormat preformat = pjob.defaultPage();
                    preformat.setOrientation(PageFormat.LANDSCAPE);
                    PageFormat postformat = pjob.pageDialog(preformat);
                    //If user does not hit cancel then print.
                    if (preformat != postformat) {
                        //Set print component
                        pjob.setPrintable(new PrintWindow(yourComponent), postformat);
                        if (pjob.printDialog()) {
                            try {
                                pjob.print();
                            } catch (PrinterException ex) {
                                Logger.getLogger(PrintWindow.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }

		}
	
		if (ae.getSource() == cmd_cancel)
		{
			HomeWindow l=new HomeWindow();
                        //System.exit(0);
                        dispose();
		}
		
		if(ae.getSource()==txt_name)
		{
			txt_password.requestFocus();
		}
		if(ae.getSource()==txt_password)
		{
			create.requestFocus();
		}
		
	}



	
}