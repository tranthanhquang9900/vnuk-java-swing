package vn.edu.vnuk.swing;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vn.edu.vnuk.define.Define;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UpdateSalary extends JFrame {

	private JPanel contentPane;
	private JTextField UpdateSalary;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateSalary frame = new UpdateSalary();
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
	public UpdateSalary() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 156, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAddNewEmployee = new JButton("1.Add new Employee");
		btnAddNewEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNewLecturer menu1 = new AddNewLecturer();
				menu1.setVisible(true);
				dispose();
			}
		});
		btnAddNewEmployee.setBounds(2, 0, 153, 64);
		btnAddNewEmployee.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnAddNewEmployee);
		
		JButton btnNewButton = new JButton("2.Modify list of Employee");
		btnNewButton.setBounds(2, 66, 153, 64);
	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyListOfEmployee menu1 = new ModifyListOfEmployee();
				menu1.setVisible(true);
				dispose();
			}
		});
		panel.add(btnNewButton);
		
		JButton btnupdateBasicSalary = new JButton("3.Update basic salary");
		btnupdateBasicSalary.setBounds(2, 132, 153, 63);
		panel.add(btnupdateBasicSalary);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(2, 197, 153, 64);
		panel.add(btnExit);
		
		JLabel lblNewLabel = new JLabel("Current Basic Salary :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(168, 52, 129, 39);
		contentPane.add(lblNewLabel);
		
		UpdateSalary = new JTextField();
		UpdateSalary.setBounds(295, 61, 129, 20);
		contentPane.add(UpdateSalary);
		UpdateSalary.setColumns(10);
		
		btnNewButton_2 = new JButton("Edit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Define.newBasicSalary=Float.valueOf(UpdateSalary.getText());
				JOptionPane.showMessageDialog(frame, "UPDATE SUCCESSFULLY!");
			}
		});
		btnNewButton_2.setBounds(208, 114, 89, 23);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_1 = new JButton("Apply");
		btnNewButton_1.setBounds(320, 114, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
