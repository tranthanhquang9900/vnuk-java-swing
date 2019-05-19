package vn.edu.vnuk.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CasualWorkerList extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CasualWorkerList frame = new CasualWorkerList();
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
	public CasualWorkerList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

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
		pane.setBounds(5, 5, 424, 198);
		getContentPane().add(pane);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNewCasualWorker add = new AddNewCasualWorker();
				add.setVisible(true);
			}
		});
		btnAdd.setBounds(340, 216, 89, 23);
		contentPane.add(btnAdd);
	}

}
