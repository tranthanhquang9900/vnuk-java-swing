package vn.edu.vnuk.swing;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import vn.edu.vnuk.define.Define;
import vn.edu.vnuk.model.CasualWorker;
import vn.edu.vnuk.model.Staff;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;

public class AddNewStaff extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField name;
	private JTextField yearOfBirth;
	private JTextField homeTown;
	private JTextField department;
	private JTextField salaryRatio;
	private JTextField yearsOfWork;
	private JTextField position;
	private JComboBox comboBox;
	private JTextField allwance;
	private ArrayList<Staff> staffs = new ArrayList<Staff>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewStaff frame = new AddNewStaff();
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
	public AddNewStaff() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(1, 0, 163, 286);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAddNewEmployee = new JButton("1.Add new Employee");
		btnAddNewEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNewStaff window = new AddNewStaff();
				window.setVisible(true);
				
			}
		});
		btnAddNewEmployee.setBounds(2, 0, 160, 64);
		btnAddNewEmployee.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnAddNewEmployee);
		
		JButton btnNewButton = new JButton("2.Modify list of Employee");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyListOfEmployee menu2 = new ModifyListOfEmployee();
				menu2.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setBounds(1, 71, 160, 64);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnNewButton);
		
		JButton btnupdateBasicSalary = new JButton("3.Update basic salary");
		btnupdateBasicSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateSalary menu2 = new UpdateSalary();
				menu2.setVisible(true);
				dispose();
			}
		});
		btnupdateBasicSalary.setBounds(1, 145, 160, 63);
		panel.add(btnupdateBasicSalary);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(1, 218, 160, 64);
		panel.add(btnExit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(200, 0, 275, 287);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setBounds(26, 14, 70, 25);
		panel_1.add(lblId);
		
		JLabel lblType = new JLabel("TYPE :");
		lblType.setHorizontalAlignment(SwingConstants.LEFT);
		lblType.setBounds(26, 46, 76, 14);
		panel_1.add(lblType);
		
		JLabel lblFullName = new JLabel("Full Name :");
		lblFullName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFullName.setBounds(26, 71, 94, 14);
		panel_1.add(lblFullName);
		
		JLabel lblYearOfBirth = new JLabel("Year Of Birth :");
		lblYearOfBirth.setBounds(26, 96, 105, 14);
		panel_1.add(lblYearOfBirth);
		
		JLabel lblHomeTown = new JLabel("Home Town :");
		lblHomeTown.setBounds(26, 121, 105, 14);
		panel_1.add(lblHomeTown);
		
		JLabel lblDepartment = new JLabel("Department :");
		lblDepartment.setBounds(24, 146, 107, 14);
		panel_1.add(lblDepartment);
		
		JLabel lblSalaryRatio = new JLabel("Salary Ratio :");
		lblSalaryRatio.setBounds(26, 171, 101, 14);
		panel_1.add(lblSalaryRatio);
		
		JLabel lblYearOfWork = new JLabel("Year Of Work :");
		lblYearOfWork.setBounds(26, 196, 106, 14);
		panel_1.add(lblYearOfWork);
		
		JLabel lblPosition = new JLabel("Position :");
		lblPosition.setBounds(26, 221, 108, 14);
		panel_1.add(lblPosition);
		
		textField = new JTextField();
		textField.setBounds(134, 12, 130, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		name = new JTextField();
		name.setBounds(134, 65, 130, 20);
		panel_1.add(name);
		name.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Apply");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStaff();
			}
		});
		btnNewButton_1.setBounds(176, 257, 89, 23);
		panel_1.add(btnNewButton_1);
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					if(comboBox.getSelectedItem().toString().equals("CasualWorker")) {
						AddNewCasualWorker menu13 = new AddNewCasualWorker();
						menu13.setVisible(true);
						
					}
					else if(comboBox.getSelectedItem().toString().equals("Lectuer")) {
						AddNewLecturer menu12 = new AddNewLecturer();
						menu12.setVisible(true);
						
					}
				}
			}
		});
		comboBox.addItem("Lectuer");
		comboBox.addItem("Staff");
		comboBox.addItem("CasualWorker");
		comboBox.setBounds(134, 40, 130, 20);
		panel_1.add(comboBox);
		
		yearOfBirth = new JTextField();
		yearOfBirth.setBounds(134, 90, 130, 20);
		panel_1.add(yearOfBirth);
		yearOfBirth.setColumns(10);
		
		homeTown = new JTextField();
		homeTown.setBounds(134, 115, 130, 20);
		panel_1.add(homeTown);
		homeTown.setColumns(10);
		
		department = new JTextField();
		department.setBounds(134, 140, 130, 20);
		panel_1.add(department);
		department.setColumns(10);
		
		salaryRatio = new JTextField();
		salaryRatio.setBounds(134, 165, 130, 20);
		panel_1.add(salaryRatio);
		salaryRatio.setColumns(10);
		
		yearsOfWork = new JTextField();
		yearsOfWork.setBounds(134, 190, 130, 20);
		panel_1.add(yearsOfWork);
		yearsOfWork.setColumns(10);
		
		position = new JTextField();
		position.setBounds(134, 215, 130, 20);
		panel_1.add(position);
		position.setColumns(10);
		
		
		JLabel lblAllowance = new JLabel("Allowance :");
		lblAllowance.setBounds(26, 239, 70, 14);
		panel_1.add(lblAllowance);
		
		allwance = new JTextField();
		allwance.setBounds(134, 236, 130, 20);
		panel_1.add(allwance);
		allwance.setColumns(10);
		
		
		Object[][] data = 
			{
					{"Kathy", "Smith", new Integer(5), new Boolean(false),},
			};
			
			String[] column= {"Full Name",
	                "Year of birth",
	                "Work on Day",
	                "Earning Per Day"
			};
			contentPane.setLayout(null);
		
		JTable table = new JTable(data,column);
		table.setPreferredScrollableViewportSize(new Dimension(500,70));
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(461, 45, 424, 198);
		contentPane.add(pane);
	}
	public void addStaff() {
		String fullName = name.getText().toString();
		int yearofBirth = Integer.parseInt(yearOfBirth.getText().toString());
		String HomeTown = homeTown.getText().toString();
		String Department = department.getText().toString();
		int SalaryRatio = Integer.parseInt(salaryRatio.getText().toString());
		int YearsOfWork = Integer.parseInt(yearsOfWork.getText().toString());
		String Position = position.getText().toString();
		int Allwance = Integer.parseInt(allwance.getText().toString());
		
		Staff staff= new Staff.StaffBuilder(Define.latestId, Define.TYPE_OF_CASUAL_WORKER).setFullName(fullName).setYearOfBirth(yearofBirth).setHomeTown(HomeTown).setDepartment(Department).setSalaryRatio(SalaryRatio).setWorkYears(YearsOfWork).setPosition(Position).setAllowance(Allwance).build();
		
		Define.persons.add(staff);
		staffs.add(staff);
		System.out.print(" "+ fullName + " " + yearofBirth + " " + HomeTown + " " + Department + " " + SalaryRatio + " " + YearsOfWork + " " + " " + Position + " " + Allwance);
	}
}
