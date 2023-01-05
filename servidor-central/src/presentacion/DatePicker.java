package presentacion;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DatePicker {
	int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
	int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
	int num_day = java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_MONTH);
	JLabel datelbl = new JLabel("", JLabel.CENTER);
	
	JPanel inputPanel = new JPanel();
	JPanel monthPanel = new JPanel(new GridLayout(1, 3));
	JPanel yearPanel = new JPanel(new GridLayout(1, 3));
	
	JTextField inputMonth = new JTextField();
	JTextField inputYear = new JTextField();
	JLabel monthlbl = new JLabel("Month ");
	JLabel yearlbl = new JLabel("Year ");
	
	String day = Integer.toString(num_day);
	JDialog d;
	JButton[] button = new JButton[49];

	public DatePicker(JInternalFrame parent) {
		d = new JDialog();
		d.setModal(true);
		String[] header = { "Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat" };
		JPanel p1 = new JPanel(new GridLayout(7, 7));
		p1.setPreferredSize(new Dimension(430, 120));

		for (int x = 0; x < button.length; x++) {
			final int selection = x;
			button[x] = new JButton();
			button[x].setFocusPainted(false);
			button[x].setBackground(Color.white);
			if (x > 6)
				button[x].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						day = button[selection].getActionCommand();
						d.dispose();
					}
				});
			if (x < 7) {
				button[x].setText(header[x]);
				button[x].setForeground(Color.red);
			}
			p1.add(button[x]);
		}
		
		JButton previousMonth = new JButton("<< Previous Month");
		previousMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (month-1<0) {
					month = 11;
				} else {
					month--;
				}
				displayDate();
			}
		});
		JButton previousYear = new JButton("<< Previous Year");
		previousYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (year-1==0) return;
				year--;
				displayDate();
			}
		});
		monthPanel.add(previousMonth);
		yearPanel.add(previousYear);
		
		yearPanel.add(datelbl);
		inputPanel.setLayout(new GridLayout(0, 4, 0, 0));
		inputMonth.setHorizontalAlignment(SwingConstants.CENTER);
		inputYear.setHorizontalAlignment(SwingConstants.CENTER);
		inputMonth.setToolTipText("Press enter when done");
		inputYear.setToolTipText("Press enter when done");
		
		inputMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String content = inputMonth.getText();
				int num;
				try {
					num= Integer.parseInt(content);
				} catch (NumberFormatException e) {
					inputMonth.setText(Integer.toString(month+1));
					return;
				}
				if (content.isBlank() || num < 1 || num > 12) {
					inputMonth.setText(Integer.toString(month+1));
				} else {
					month = num-1;
					displayDate();
				}
			}
		});
		inputYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String content = inputYear.getText();
				int num;
				try {
					num = Integer.parseInt(content);
				} catch (NumberFormatException e) {
					inputYear.setText(Integer.toString(year));
					return;
				}
				if (content.isBlank() || num < 1 ) {
					inputYear.setText(Integer.toString(year));
				} else {
					year = num;
					displayDate();
				}
			}
		});
		monthlbl.setHorizontalAlignment(SwingConstants.RIGHT);

		inputPanel.add(monthlbl);
		inputPanel.add(inputMonth);
		yearlbl.setHorizontalAlignment(SwingConstants.RIGHT);
		inputPanel.add(yearlbl);
		inputPanel.add(inputYear);

		monthPanel.add(inputPanel);
		
		JButton nextMonth = new JButton("Next Month >>");
		nextMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				month = (month+1)%12;
				displayDate();
			}
		});
		JButton nextYear = new JButton("Next Year >>");
		nextYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				year++;
				displayDate();
			}
		});
		monthPanel.add(nextMonth);
		yearPanel.add(nextYear);
		

		d.getContentPane().add(p1, BorderLayout.CENTER);
		d.getContentPane().add(monthPanel, BorderLayout.SOUTH);
		d.getContentPane().add(yearPanel, BorderLayout.NORTH);
		d.pack();
		d.setLocationRelativeTo(parent);
		displayDate();
		d.setVisible(true);
	}

	public void displayDate() {
		for (int x = 7; x < button.length; x++)
			button[x].setText("");
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"MMMM yyyy");
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, 1);
		int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
		int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
		for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++)
			button[x].setText("" + day);
		datelbl.setText(sdf.format(cal.getTime()));
		
		inputMonth.setText(Integer.toString(month+1));
		inputYear.setText(Integer.toString(year));
		
		d.setTitle("Date Picker");
	}

	public String setPickedDate() {
		if (day.equals(""))
			return day;
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, Integer.parseInt(day));
		return sdf.format(cal.getTime());
	}
}