//package newexp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;


	public class exptracker {
		Connection conn;
		public int parseValue(String value) {
			try {
				return Integer.parseInt(value);
			} catch(NumberFormatException e) {
				return 0;
			}
		}
		exptracker(){
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
				conn.setAutoCommit(false);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			JFrame f1= new JFrame();
			JLabel l1 = new JLabel("Daily Expense Tracker!!",JLabel.CENTER);
			l1.setBounds(90, 20, 200, 100);
			l1.setForeground(Color.RED);
			JLabel l5 = new JLabel (" date ");
			l5.setBounds(90, 95, 50, 50);
			//JDateChooser dateChooser = new JDateChooser();
	
			f1.setSize(400,500);
			f1.setVisible(true);
			f1.setLayout(null);
			f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
			/*JSeparator js1 = new JSeparator(SwingConstants.VERTICAL);
			js1.setBounds(30, 115,1, 600);
			JSeparator js3 = new JSeparator(SwingConstants.HORIZONTAL);
			js3.setBounds(30, 170, 300, 600 );
			JSeparator js2 = new  JSeparator(SwingConstants.HORIZONTAL);
			js2.setBounds(30, 110, 300, 600);
			JSeparator js4 = new JSeparator(SwingConstants.VERTICAL);
			js4.setBounds(350, 110,1, 650);*/
			JLabel l2 = new JLabel("Spent for..!");
			l2.setBounds(80, 110, 110, 100);
			//l2.setForeground(Color.white);
			JLabel l3 = new JLabel("Amount..!");
			l3.setBounds(237,110, 110, 100);
			//l3.setForeground(Color.white);
			JTextField t1 = new JTextField();
			t1.setBounds(50, 200, 130, 20);
			JTextField t2 = new JTextField();
			t2.setBounds(230, 200, 70, 20);
			JTextField t3 = new JTextField();
			t3.setBounds(50, 230, 130, 20);
			JTextField t4 = new JTextField();
			t4.setBounds(230, 230, 70, 20);
			JTextField t5 = new JTextField();
			t5.setBounds(50, 260, 130, 20);
			JTextField t6 = new JTextField();
			t6.setBounds(230, 260, 70, 20);
			JTextField t7 = new JTextField();
			t7.setBounds(50, 290, 130, 20);
			JTextField t8 = new JTextField();
			t8.setBounds(230, 290, 70, 20);
			JTextField t9 = new JTextField();
			t9.setBounds(150, 111, 70, 20);
			JLabel l4 = new JLabel("TOTAL : ");
			l4.setBounds(180, 320, 70, 20);
			//l4.setForeground(Color.white);
			JTextField tresult = new JTextField();
			tresult.setBounds(230, 323, 70, 20);
			//f1.getContentPane().setBackground(Color.BLACK);
			JButton b1 = new JButton("Save!");
			b1.setBounds(195, 360, 70, 30);
			JButton b2 = new JButton("View");
			b2.setBounds(90, 360, 70, 30);
			f1.add(b2);
			f1.add(b1);
			f1.add(t1);
			f1.add(t2);
			f1.add(t3);
			f1.add(t4);
			f1.add(t5);
			f1.add(t6);
			f1.add(t7);
			f1.add(t8);
			f1.add(t9);
			f1.add(tresult);
			f1.add(l4);
			f1.add(l1);
			f1.add(l2);
			f1.add(l3);
			f1.add(l5);
			
			tresult.setEditable(false);
			DocumentListener documentListener = new DocumentListener() {
				public void changeUpdate(DocumentEvent e) {
					updateTotal();
				}
				public void removeUpdate(DocumentEvent e) {
					updateTotal();
				}
				public void insertUpdate(DocumentEvent e) {
					updateTotal();
				}
				private void updateTotal() {
					int total = 0 ;
					total+=parseValue(t2.getText());
					total+=parseValue(t4.getText());
					total+=parseValue(t6.getText());
					total+=parseValue(t8.getText());
				    tresult.setText(String.valueOf(total));
					
				}
				private int parseValue(String value) {
					try {
						return Integer.parseInt(value);
					}
					catch(NumberFormatException e) {
						return 0;
					}
				}
				@Override
				public void changedUpdate(DocumentEvent e) {
		
					
				}
			};
			t2.getDocument().addDocumentListener(documentListener);
			t4.getDocument().addDocumentListener(documentListener);
			t6.getDocument().addDocumentListener(documentListener);
			t8.getDocument().addDocumentListener(documentListener);
		
			//f1.add(js1);
			//f1.add(js2);
			//f1.add(js3);
			//f1.add(js4);
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String query = "INSERT INTO expenses1(description1,amount1,description2,amount2,description3,amount3,description4,amount4,total) VALUES(?,?,?,?,?,?,?,?,?)";
					    PreparedStatement stmt = conn.prepareStatement(query);
					    stmt.setString(1, t1.getText());
					    stmt.setInt(2, parseValue(t2.getText()));
					    stmt.setString(3,t3.getText());
					    stmt.setInt(4, parseValue(t4.getText()));
					    stmt.setString(5, t5.getText());
					    stmt.setInt(6, parseValue(t6.getText()));
					    stmt.setString(7, t7.getText());
					    stmt.setInt(8, parseValue(t8.getText()));
					    stmt.setInt(9, Integer.parseInt(tresult.getText()));
					    stmt.executeUpdate();
					    conn.commit();
					    JOptionPane.showMessageDialog(f1, "Data stored succesfully!!","Success",JOptionPane.INFORMATION_MESSAGE);
					    t1.setText(" ");
					    t2.setText(" ");
					    t3.setText(" ");
					    t4.setText(" ");
					    t5.setText(" ");
					    t6.setText(" ");
					    t7.setText(" ");
					    t8.setText(" ");
					    tresult.setText(" ");
					    System.out.println("Data Stored Sucessfully");
					    
					} catch (SQLException ex) {
						ex.printStackTrace();
						try {
							conn.rollback();
						} catch(SQLException ex2) {
							ex2.printStackTrace();
						}
					}
				}
			});
			//view 
			b2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					displayData();
				}
			});
		}
		private void displayData() {
			JFrame viewFrame = new JFrame("Expense data");
			viewFrame.setSize(600,400);
			String[] columnNames = {"Description1","Amount1",
					"Description2","Amount2",
					"Description3","Amount3",
					"Description4","Amount4","Total"};
			DefaultTableModel model = new DefaultTableModel(columnNames,0);
			try {
				String query = "SELECT * FROM expenses1";
				PreparedStatement stmt = conn.prepareStatement(query);
			    ResultSet rs = stmt.executeQuery();
			    while(rs.next()) {
			    	Object[] row = {
			    			rs.getString("description1"),
			    			rs.getInt("amount1"),
			    			
			    			rs.getString("description2"),
			    			rs.getInt("amount2"),
			    			
			    			rs.getString("description3"),
			    			rs.getInt("amount3"),
			    			
			    			rs.getString("description4"),
			    			rs.getInt("amount4"),
			    		
			    			rs.getInt("total")
			    	};
			    	model.addRow(row);
			    }
			    rs.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
			JTable table = new JTable(model);
			JScrollPane scrollPane = new JScrollPane(table);
			viewFrame.add(scrollPane);
			viewFrame.setVisible(true);;
		}
		public static void main(String[] args) {
			new exptracker();	
		}

	}






