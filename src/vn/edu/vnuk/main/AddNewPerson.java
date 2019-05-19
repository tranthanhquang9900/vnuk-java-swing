package vn.edu.vnuk.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddNewPerson extends JFrame {
    
	private static ArrayList<JPanel> panels = new ArrayList<>();
    
    public AddNewPerson(int typeOfEmployee) {
        panels.clear();
        
        setSize(400, 400);
        setTitle("Dialog");
        setLayout(null);
        
        PanelTop panelTop = new PanelTop();
        panelTop.setSize(400, 80);
        panelTop.setLocation(0, 0);

        PanelMiddle panelMiddle = new PanelMiddle();
        panelMiddle.setSize(400, 60);
        panelMiddle.setLocation(0, 80);
        
        PanelEmpty panelEmpty = new PanelEmpty();
        panelEmpty.setSize(0,0);
        panelEmpty.setLocation(0, 0);

        PanelBottomLecturer panelBottomLecturer = new PanelBottomLecturer();
        panelBottomLecturer.setSize(400, 300);
        panelBottomLecturer.setLocation(0, 140);
        panelBottomLecturer.setVisible(false);
        
        PanelBottomStaff panelBottomStaff = new PanelBottomStaff();
        panelBottomStaff.setSize(400, 300);
        panelBottomStaff.setLocation(0, 140);
        panelBottomStaff.setVisible(false);
        
        PanelBottomCasualWorker panelBottomCasualWoker = new PanelBottomCasualWorker();
        panelBottomCasualWoker.setSize(400, 300);
        panelBottomCasualWoker.setLocation(0, 140);
        panelBottomCasualWoker.setVisible(false);
        
        PanelButtonAction panelButtonAction = new PanelButtonAction();
        panelButtonAction.setSize(150, 500);
        panelButtonAction.setVisible(true);
        

        this.add(panelTop);
        this.add(panelMiddle);
        this.add(panelBottomStaff);
        this.add(panelBottomLecturer);
        this.add(panelBottomCasualWoker);
        this.add(panelButtonAction);
        
        panels.add(panelTop);
        panels.add(panelMiddle);
        panels.add(panelEmpty);
        panels.add(panelBottomStaff);
        panels.add(panelBottomLecturer);
        panels.add(panelBottomCasualWoker);
        panels.add(panelButtonAction);
        
    }

    public static void showPanelMiddleAndPanelBottom(int typeOfEmployee) {
    	switch(typeOfEmployee) {
    		case 0: { // staff
    		
	    		panels.get(1).setVisible(true);
	    		panels.get(2).setVisible(true);
	    		panels.get(3).setVisible(false);
	    		panels.get(4).setVisible(false);
	    		panels.get(5).setVisible(false);
	    		panels.get(6).setLocation(panels.get(2).getLocation().x, (int) (panels.get(2).getLocation().y + panels.get(2).getSize().getHeight() + 20));
	    		break;
    		}
    		
			case 1: { // staff
			    		
			    panels.get(1).setVisible(true);
			    panels.get(2).setVisible(false);
			    panels.get(3).setVisible(true);
			    panels.get(4).setVisible(false);
			    panels.get(5).setVisible(false);
			    panels.get(6).setLocation(panels.get(2).getLocation().x, (int) (panels.get(2).getLocation().y + panels.get(2).getSize().getHeight() + 20));
	    		break;
			   }
			case 2: { // staff
				
				panels.get(1).setVisible(true);
				panels.get(2).setVisible(false);
				panels.get(3).setVisible(false);
				panels.get(4).setVisible(true);
				panels.get(5).setVisible(false);
				panels.get(6).setLocation(panels.get(2).getLocation().x, (int) (panels.get(2).getLocation().y + panels.get(2).getSize().getHeight() + 20));
	    		break;
			}
			
			case 3: { // staff
	    		
	    		panels.get(1).setVisible(true);
	    		panels.get(2).setVisible(false);
	    		panels.get(3).setVisible(false);
	    		panels.get(4).setVisible(false);
	    		panels.get(5).setVisible(true);
	    		panels.get(6).setLocation(panels.get(2).getLocation().x, (int) (panels.get(2).getLocation().y + panels.get(2).getSize().getHeight() + 20));
	    		break; 
	    	}
    	}
    }
    
    class PanelTop extends JPanel {
        String typesOfEmployee[] = {"Select Type Employee","Staff", "Lecturer", "Casual Worker"};

        public PanelTop() {
            this.setLayout(null);

            //ID 
            JLabel labelId = new JLabel("ID");
            labelId.setLocation(20, 20);
            labelId.setSize(labelId.getPreferredSize());
            this.add(labelId);
            
            JTextField textFieldId = new JTextField();
            textFieldId.setLocation(150, 20);
            textFieldId.setSize(150, 25);
            this.add(textFieldId);
            textFieldId.setText("1");
            textFieldId.setEditable(false);
            
            //Type
            JLabel labelType = new JLabel("Type");
            labelType.setLocation(20, 50);
            labelType.setSize(labelType.getPreferredSize());
            this.add(labelType);
            
            JComboBox<?> comboBoxType = new JComboBox<Object>(typesOfEmployee);
            comboBoxType.setBounds(150, 50, 150, 20);
            comboBoxType.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					AddNewPerson.showPanelMiddleAndPanelBottom(comboBoxType.getSelectedIndex());
				}
			});
            this.add(comboBoxType);
        }
    }

    class PanelMiddle extends JPanel {
        
        public PanelMiddle() {

            this.setLayout(null);

            //FullName
            JLabel labelFullName = new JLabel("FullName");
            labelFullName.setLocation(20, 0);
            labelFullName.setSize(labelFullName.getPreferredSize());
            this.add(labelFullName);
            
            JTextField textFieldName = new JTextField();
            textFieldName.setLocation(150, 0);
            textFieldName.setSize(150, 25);
            this.add(textFieldName);
            
            //yearOfBirth
            JLabel labelYearOfBirth = new JLabel("Year of birth");
            labelYearOfBirth.setLocation(20, 30);
            labelYearOfBirth.setSize(labelYearOfBirth.getPreferredSize());
            this.add(labelYearOfBirth);
            
            JTextField textFieldYearOfBirth = new JTextField();
            textFieldYearOfBirth.setLocation(150, 30);
            textFieldYearOfBirth.setSize(150, 25);
            this.add(textFieldYearOfBirth);
        }
    }
    
    class PanelEmpty extends JPanel {
    	public PanelEmpty() {
            this.setLayout(null);
    }
    }

    class PanelBottomLecturer extends JPanel {
        String certificate[] = {"Bachelor", "Master", "Doctor"};

    	public PanelBottomLecturer() {
            this.setLayout(null);
            
            //Home Town
            JLabel labelHomeTown = new JLabel("Home Town");
            labelHomeTown.setLocation(20, 0);
            labelHomeTown.setSize(labelHomeTown.getPreferredSize());
            this.add(labelHomeTown);
            
            JTextField textFieldHomeTown = new JTextField();
            textFieldHomeTown.setLocation(150, 0);
            textFieldHomeTown.setSize(150, 25);
            this.add(textFieldHomeTown);
            
            //Department
            JLabel labelDepartment = new JLabel("Department");
            labelDepartment.setLocation(20, 30);
            labelDepartment.setSize(labelDepartment.getPreferredSize());
            this.add(labelDepartment);
            
            JTextField textFieldDepartment = new JTextField();
            textFieldDepartment.setLocation(150, 30);
            textFieldDepartment.setSize(150, 25);
            this.add(textFieldDepartment);
            
            //PeriodsInMonth
            JLabel labelPeriodsInMonth = new JLabel("Period in Months");
            labelPeriodsInMonth.setLocation(20, 60);
            labelPeriodsInMonth.setSize(labelPeriodsInMonth.getPreferredSize());
            this.add(labelPeriodsInMonth);
            
            JTextField textFieldPeriodsInMonth = new JTextField();
            textFieldPeriodsInMonth.setLocation(150, 60);
            textFieldPeriodsInMonth.setSize(150, 25);
            this.add(textFieldPeriodsInMonth);
            
            //SalaryRatio
            JLabel labelSalaryRatio = new JLabel("Salary ratio");
            labelSalaryRatio.setLocation(20, 90);
            labelSalaryRatio.setSize(labelSalaryRatio.getPreferredSize());
            this.add(labelSalaryRatio);
            
            JTextField textFieldSalaryRatio = new JTextField();
            textFieldSalaryRatio.setLocation(150, 90);
            textFieldSalaryRatio.setSize(150, 25);
            this.add(textFieldSalaryRatio);
        
            //YearOfWork
            JLabel labelWorkYears = new JLabel("Year of work");
            labelWorkYears.setLocation(20, 120);
            labelWorkYears.setSize(labelWorkYears.getPreferredSize());
            this.add(labelWorkYears);
            
            JTextField textFieldWorkYears = new JTextField();
            textFieldWorkYears.setLocation(150, 120);
            textFieldWorkYears.setSize(150, 25);
            this.add(textFieldWorkYears);
            
            //Certificate
            
            JLabel labelCertificate = new JLabel("Qualification");
            labelCertificate.setLocation(20, 150);
            labelCertificate.setSize(labelCertificate.getPreferredSize());
            this.add(labelCertificate);
            
            JComboBox<?> comboBoxCertificate = new JComboBox<Object>(certificate);
            comboBoxCertificate.setBounds(150, 150, 150, 20);
            this.add(comboBoxCertificate);
    	}
    }

    class PanelBottomStaff extends JPanel {
    	public PanelBottomStaff() {
    		String position[] = {"Chief", "Deputy", "Employee"};
    		
    		setLayout(null);
    		
    		//hometown
            JLabel labelHomeTown = new JLabel("Home Town");
            labelHomeTown.setLocation(20, 0);
            labelHomeTown.setSize(labelHomeTown.getPreferredSize());
            this.add(labelHomeTown);
            
            JTextField textFieldHomeTown = new JTextField();
            textFieldHomeTown.setLocation(150, 0);
            textFieldHomeTown.setSize(150, 25);
            this.add(textFieldHomeTown);
            
            //department
            JLabel labelDepartment = new JLabel("Department");
            labelDepartment.setLocation(20, 30);
            labelDepartment.setSize(labelDepartment.getPreferredSize());
            this.add(labelDepartment);
            
            JTextField textFieldDepartment = new JTextField();
            textFieldDepartment.setLocation(150, 30);
            textFieldDepartment.setSize(150, 25);
            this.add(textFieldDepartment);
            
            //salaryRatio
            JLabel labelSalaryRatio = new JLabel("Salary ratio");
            labelSalaryRatio.setLocation(20, 60);
            labelSalaryRatio.setSize(labelSalaryRatio.getPreferredSize());
            this.add(labelSalaryRatio);
            
            JTextField textFieldSalaryRatio = new JTextField();
            textFieldSalaryRatio.setLocation(150, 60);
            textFieldSalaryRatio.setSize(150, 25);
            this.add(textFieldSalaryRatio);
            
            //yearOfWork
            JLabel labelYearOfWork = new JLabel("Year of work");
            labelYearOfWork.setLocation(20, 90);
            labelYearOfWork.setSize(labelYearOfWork.getPreferredSize());
            this.add(labelYearOfWork);
            
            JTextField textFieldYearOfWork = new JTextField();
            textFieldYearOfWork.setLocation(150, 90);
            textFieldYearOfWork.setSize(150, 25);
            this.add(textFieldYearOfWork);
            
            //workDay
            JLabel labelWorkDays = new JLabel("Day of work");
            labelWorkDays.setLocation(20, 120);
            labelWorkDays.setSize(labelWorkDays.getPreferredSize());
            this.add(labelWorkDays);
            
            JTextField textFieldWorkDays = new JTextField();
            textFieldWorkDays.setLocation(150, 120);
            textFieldWorkDays.setSize(150, 25);
            this.add(textFieldWorkDays);
            
            //position
            JLabel labelPosition = new JLabel("Position");
            labelPosition.setLocation(20, 150);
            labelPosition.setSize(labelPosition.getPreferredSize());
            this.add(labelPosition);
            
            JComboBox<?> comboBoxPosition = new JComboBox<Object>(position);
            comboBoxPosition.setBounds(150, 150, 150, 20);
            this.add(comboBoxPosition);
    	}
    }

    class PanelBottomCasualWorker extends JPanel {
    	public PanelBottomCasualWorker() {
    		
    		setLayout(null);
    		
    		// WorkDays
            JLabel labelWorkDays = new JLabel("Work Days");
            labelWorkDays.setLocation(20, 0);
            labelWorkDays.setSize(labelWorkDays.getPreferredSize());
            this.add(labelWorkDays);
            
            JTextField textFieldWorkDays = new JTextField();
            textFieldWorkDays.setLocation(150, 0);
            textFieldWorkDays.setSize(150, 25);
            this.add(textFieldWorkDays);
            
            // EarningPerDays
            JLabel labelEarningPerDays = new JLabel("EarningPerDays");
            labelEarningPerDays.setLocation(20, 30);
            labelEarningPerDays.setSize(labelEarningPerDays.getPreferredSize());
            this.add(labelEarningPerDays);
            
            JTextField textFieldEarningPerDays = new JTextField();
            textFieldEarningPerDays.setLocation(150, 30);
            textFieldEarningPerDays.setSize(150, 25);
            this.add(textFieldEarningPerDays);
    	}
    }
    
class PanelButtonAction extends JPanel {
    	
    	public PanelButtonAction() {
    		setLayout(null);
    		
    		JButton actionButton = new JButton();
    		//actionButton.setText((isEdited) ? "Update" : "Add");
    		actionButton.setText("Update");
    		actionButton.setLocation(100, 400);
    		actionButton.setSize(100, 30);
    		
    		this.add(actionButton);
    	}
    }
}
