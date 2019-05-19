package vn.edu.vnuk.swing;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import vn.edu.vnuk.define.Define;
import vn.edu.vnuk.model.CasualWorker;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;

public class AddNewCasualWorker extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Id;
	private JTextField name;
	private JTextField yearOfBirth;
	private JTextField workDays;
	private JTextField earningPerDay;
	private JComboBox comboBox;
	private JTable table;
	private ArrayList<CasualWorker> casualWorkers = new ArrayList<CasualWorker>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewCasualWorker frame = new AddNewCasualWorker();
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
	public AddNewCasualWorker() {
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
				AddNewCasualWorker window = new AddNewCasualWorker();
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(174, 0, 275, 287);
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
		
		JLabel lblHomeTown = new JLabel("Work on Days :");
		lblHomeTown.setBounds(26, 121, 105, 14);
		panel_1.add(lblHomeTown);
		
		JLabel lblDepartment = new JLabel("Earning Per Day :");
		lblDepartment.setBounds(24, 146, 107, 14);
		panel_1.add(lblDepartment);
		
		Id = new JTextField();
		Id.setBounds(134, 12, 130, 24);
		panel_1.add(Id);
		Id.setColumns(10);
		
		name = new JTextField();
		name.setBounds(134, 65, 130, 20);
		panel_1.add(name);
		name.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Apply");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addcasualWorker();

			}
		});
		btnNewButton_1.setBounds(176, 257, 89, 23);
		panel_1.add(btnNewButton_1);
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					if(comboBox.getSelectedItem().toString().equals("Lectuer")) {
						AddNewLecturer menu13 = new AddNewLecturer();
						menu13.setVisible(true);
						
					}
					else if(comboBox.getSelectedItem().toString().equals("Staff")) {
						AddNewStaff menu12 = new AddNewStaff();
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
		
		workDays = new JTextField();
		workDays.setBounds(134, 115, 130, 20);
		panel_1.add(workDays);
		workDays.setColumns(10);
		
		earningPerDay = new JTextField();
		earningPerDay.setBounds(134, 140, 130, 20);
		panel_1.add(earningPerDay);
		earningPerDay.setColumns(10);
		JTable table = new JTable(data,column);
		table.setPreferredScrollableViewportSize(new Dimension(500,70));
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(461, 45, 424, 198);
		contentPane.add(pane);
	}
	public void addcasualWorker() {
		int id = Integer.parseInt(Id.getText().toString());		
		String fullName = name.getText().toString();
		int yearofBirth = Integer.parseInt(yearOfBirth.getText().toString());
		int WorkDay = Integer.parseInt(workDays.getText().toString());
		float EarningPerDay = Float.parseFloat(earningPerDay.getText().toString());
		
		CasualWorker casualWorker = new CasualWorker.CasualWorkerBuilder(Define.latestId, Define.TYPE_OF_CASUAL_WORKER).setFullName(fullName).setYearOfBirth(yearofBirth).setWorkDays(WorkDay).setEarningPerDay(EarningPerDay).build();
		
		Define.persons.add(casualWorker);
		casualWorkers.add(casualWorker);
		System.out.print(" "+ fullName + " " + yearofBirth + " " + WorkDay + " " + EarningPerDay);
	}
}
