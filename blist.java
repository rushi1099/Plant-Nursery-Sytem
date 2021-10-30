import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class blist extends JFrame implements ActionListener
{
	Container con=this.getContentPane();
	DefaultTableModel dm;
	JTable jt;
	Vector rows,header,row1;
      
	
	Connection cn;
	String str;
	Statement stmt;
	
	JButton close=new JButton("CLOSE");

	public blist()
	{
		setLayout(null);
		
		/*try
		{
    Class.forName("com.mysql.jdbc.Driver");

			String stra="nursery";
			String strb="jdbc:mysql://localhost:3306/";
			String strc="root";
			String strd="root";
			
			
			Connection cn=DriverManager.getConnection(strb+stra,strc,strd);
		stmt=cn.createStatement();
		}
		catch(SQLException ae)
		{
			System.out.print("Driver not found");
			ae.printStackTrace();	
		}
		catch(ClassNotFoundException ae)
		{
			System.out.print("Class not found");
				ae.printStackTrace();
		}
		try
		{
			ResultSet rs=stmt.executeQuery("select * from plant");
			while(rs.next())
			{
			   row1=new Vector();
				row1.addElement(rs.getString(1));
				row1.addElement(rs.getString(2));
				row1.addElement(rs.getString(3));
				row1.addElement(rs.getString(4));
				row1.addElement(rs.getString(5));
				row1.addElement(rs.getString(6));
				rows.addElement(row1);
			}
		}
		catch(NullPointerException e)
		{
			System.out.print("Exception is there" +e);
				e.printStackTrace();
		}
		catch(SQLException aw)
		{
			System.out.print("Exception for sql" +aw);
				aw.printStackTrace();
		}
		
		*/

			 Vector d=new Vector();Vector colname=new Vector();
		try
		{        
                       Class.forName("org.postgresql.Driver");
                       Connection cn=DriverManager.getConnection("jdbc:postgresql://192.168.100.190/tydb21","ty21", "rushi1099");
                        Statement  stmt=cn.createStatement();
                        ResultSet rs=stmt.executeQuery("select * from plant");
                       
			while(rs.next())
			{
			       Vector row1=new Vector();
				row1.add(rs.getInt(1));
				row1.add(rs.getString(2));
               			row1.add(rs.getString(3));
				row1.add(rs.getString(4));
				row1.add(rs.getInt(5));
				row1.add(rs.getInt(6));
								
                                d.add(row1);
                        }
                        
			colname.add("plant_id");
			colname.add("plant_name");
			colname.add("description");
			colname.add("fertilizer");
			colname.add("quantity");
			colname.add("rate");
                    
                      
		}
                 catch(Exception e)
                 {
                    System.out.println(e);
                  }


                
		jt=new JTable(d,colname);		
		JScrollPane p=new JScrollPane(jt);
		p.setBounds(30,30,700,450);
		add(p);
		jt.setRowSelectionAllowed(false);
		jt.setEnabled(false);

		close.setBounds(320,495,100,30);
		add(close);
	    close.addActionListener(this);
		close.setToolTipText("Close");
		
		setTitle("**  PLANT STOCK  **");
		setResizable(false);
		
		setSize(770,570);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String args[])
	{
     	new blist();
		
	}


	public void actionPerformed(ActionEvent e)
	{
		String title=e.getActionCommand();
		if(title=="CLOSE")
		{
			dispose();
		}
		
	
	}
}
