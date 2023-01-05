package presentacion;



import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.util.GregorianCalendar;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



import excepciones.YaExisteException;
import logica.interfaces.ICtrlActividad;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSpinner;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import datatypes.DTActividad;

import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class altaSalida extends JInternalFrame {

	//Controlador
	private ICtrlActividad ctrlSalida;
	//Basicos
	private GregorianCalendar fechaNac;

	private JButton calendarBtn;
	private JTextField date;
	private JInternalFrame f;
	private  JComboBox<String> comboBox,comboBox_1 ;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JSpinner spinner, spinner_1, spinner_2;
	private boolean settear;


	public altaSalida(ICtrlActividad iCS) {
		this.ctrlSalida = iCS;
		
	  
	
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta de Salida Turistica");
        setBounds(10, 40, 452, 341);
	
	
   
       
       JLabel lblNewLabel = new JLabel("Seleccionar departamento:");
       
       comboBox = new JComboBox<String>();
       
       JLabel lblNewLabel_1 = new JLabel("Seleccionar Actividad");
       lblNewLabel_1.setEnabled(false);
       
      comboBox_1 = new JComboBox<String>();
       comboBox_1.setEnabled(false);
       
       JLabel lblNewLabel_2 = new JLabel("INFORMACION DE LA SALIDA:");
       lblNewLabel_2.setEnabled(false);
       
       JLabel lblNewLabel_3 = new JLabel("Nombre:");
       lblNewLabel_3.setEnabled(false);
       
       JLabel lblNewLabel_4 = new JLabel("Fecha:");
       lblNewLabel_4.setEnabled(false);
       
       JLabel lblNewLabel_5 = new JLabel("Hora:");
       lblNewLabel_5.setEnabled(false);
       
       JButton btnNewButton = new JButton("Confirmar");
       btnNewButton.setEnabled(false);
       
       JButton btnNewButton_1 = new JButton("Cancelar");
       
       JLabel lblNewLabel_6 = new JLabel("Lugar:");
       lblNewLabel_6.setEnabled(false);
       
       JLabel lblNewLabel_7 = new JLabel("Cantidad Max. Turistas");
       lblNewLabel_7.setEnabled(false);
       
       textField_1 = new JTextField();
       textField_1.setEnabled(false);
       textField_1.setColumns(10);

       SpinnerModel sm = new SpinnerNumberModel(0, 0, 23, 1); //default value,lower bound,upper bound,increment by
       spinner = new JSpinner(sm);
       spinner.setEnabled(false);
       
      
       
   	calendarBtn = new JButton("...");
	String icon_path = "src/icons/calendario.png";
	ImageIcon icon = new ImageIcon(icon_path,"calendario");
	Image img = icon.getImage();
	Image scaled_img = img.getScaledInstance( 15, 15,  java.awt.Image.SCALE_SMOOTH ) ;  
	calendarBtn.setIcon(new ImageIcon(scaled_img));
	calendarBtn.setEnabled(false);
	
       textField_2 = new JTextField();
       textField_2.setEnabled(false);
       textField_2.setColumns(10);
       
       SpinnerModel sm2 = new SpinnerNumberModel(0,0,59,1);
       spinner_1 = new JSpinner(sm2);
       spinner_1.setEnabled(false);
       
       textField_3 = new JTextField();
       textField_3.setEnabled(false);
       textField_3.setColumns(10);
       
       JLabel lblNewLabel_8 = new JLabel(":");
       SpinnerModel sm3 = new SpinnerNumberModel(1, -500, 500, 1); //default value,lower bound,upper bound,increment by
       spinner_2 = new JSpinner(sm3);
       
       GroupLayout groupLayout = new GroupLayout(getContentPane());
       groupLayout.setHorizontalGroup(
       	groupLayout.createParallelGroup(Alignment.LEADING)
       		.addGroup(groupLayout.createSequentialGroup()
       			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
       				.addGroup(groupLayout.createSequentialGroup()
       					.addGap(15)
       					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
       						.addGroup(groupLayout.createSequentialGroup()
       							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
       								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
       								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
       							.addGap(18)
       							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
       								.addComponent(comboBox_1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
       								.addComponent(comboBox, 0, 150, Short.MAX_VALUE)
       								.addComponent(btnNewButton_1)))
       						.addGroup(groupLayout.createSequentialGroup()
       							.addComponent(lblNewLabel_3)
       							.addPreferredGap(ComponentPlacement.RELATED)
       							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
       						.addGroup(groupLayout.createSequentialGroup()
       							.addComponent(lblNewLabel_4)
       							.addPreferredGap(ComponentPlacement.RELATED)
       							.addComponent(calendarBtn, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
       							.addPreferredGap(ComponentPlacement.RELATED)
       							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
       							.addGap(18)
       							.addComponent(lblNewLabel_5)
       							.addPreferredGap(ComponentPlacement.RELATED)
       							.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
       							.addPreferredGap(ComponentPlacement.RELATED)
       							.addComponent(lblNewLabel_8)
       							.addPreferredGap(ComponentPlacement.RELATED)
       							.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
       						.addComponent(lblNewLabel_2)
       						.addGroup(groupLayout.createSequentialGroup()
       							.addComponent(lblNewLabel_6)
       							.addGap(18)
       							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
       						.addGroup(groupLayout.createSequentialGroup()
       							.addComponent(lblNewLabel_7)
       							.addPreferredGap(ComponentPlacement.RELATED)
       							.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
       				.addGroup(groupLayout.createSequentialGroup()
       					.addGap(65)
       					.addComponent(btnNewButton)))
       			.addContainerGap(111, Short.MAX_VALUE))
       );
       groupLayout.setVerticalGroup(
       	groupLayout.createParallelGroup(Alignment.LEADING)
       		.addGroup(groupLayout.createSequentialGroup()
       			.addGap(23)
       			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
       				.addComponent(lblNewLabel)
       				.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
       			.addPreferredGap(ComponentPlacement.RELATED)
       			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
       				.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
       				.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
       			.addGap(18)
       			.addComponent(lblNewLabel_2)
       			.addPreferredGap(ComponentPlacement.UNRELATED)
       			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
       				.addComponent(lblNewLabel_3)
       				.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
       			.addPreferredGap(ComponentPlacement.UNRELATED)
       			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
       				.addComponent(lblNewLabel_4)
       				.addComponent(calendarBtn)
       				.addComponent(lblNewLabel_5)
       				.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
       				.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
       				.addComponent(lblNewLabel_8)
       				.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
       			.addPreferredGap(ComponentPlacement.UNRELATED)
       			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
       				.addComponent(lblNewLabel_6)
       				.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
       			.addPreferredGap(ComponentPlacement.UNRELATED)
       			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
       				.addComponent(lblNewLabel_7)
       				.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
       			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
       			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
       				.addComponent(btnNewButton)
       				.addComponent(btnNewButton_1)))
       );
       getContentPane().setLayout(groupLayout);
       pack();
       /////////////////////////////////////////////////////ACTION LISTENERSS/////////////////////////////////////
     
     /* rdbtnNewRadioButton.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent e) {
    	    if(comboBox.getSelectedIndex() == -1) return;
    	    else  if (!rdbtnNewRadioButton.isSelected()) {
    	    	settear = false;
				limpiarForm();
				
			
				settear = true;
				
				rdbtnNewRadioButton_1.setEnabled(false);
				comboBox_1.removeAllItems();
				comboBox_1.setEnabled(false);
				rdbtnNewRadioButton_1.setSelected(false);
	    		   lblNewLabel_2.setEnabled(false);
	    		   lblNewLabel_3.setEnabled(false);
	    		   lblNewLabel_4.setEnabled(false);
	    		   lblNewLabel_5.setEnabled(false);
	    		   lblNewLabel_6.setEnabled(false);
	    		   lblNewLabel_7.setEnabled(false);
	    		   
	    		   calendarBtn.setEnabled(false);
	    		   spinner.setEnabled(false);
	    		   spinner_1.setEnabled(false);
	    		   textField_1.setEnabled(false);
	    		   textField_2.setEnabled(false);
	    		  // textField_3.setEnabled(true);
	    		  spinner_2.setEnabled(false);
	    		   btnNewButton.setEnabled(false);

			}
    	    else {
    	    comboBox_1.setEnabled(true);
    	    rdbtnNewRadioButton_1.setEnabled(true);
    	    lblNewLabel_1.setEnabled(true);
    	    settear = false;
    	    comboBox_1.removeAllItems();
    	    Set<String> actividades = iCS.listarActividadesDepartamento(comboBox.getSelectedItem().toString() );
    	        actividades.forEach((act)->{
    	        	
    	           comboBox_1.addItem(act);
    	           
    	        });
    	        settear =true;
    	    }
    	    }
    });*/
       comboBox.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent e) {
    		   /*if (rdbtnNewRadioButton.isSelected()) {
    			   rdbtnNewRadioButton.setSelected(false);
    			   rdbtnNewRadioButton_1.setSelected(false);
    			   rdbtnNewRadioButton_1.setEnabled(false);
    			   settear = false;*/
    		   if(!settear) {
    		   		settear = true;
    			   comboBox_1.removeAllItems();
    			   comboBox_1.setEnabled(false);
    			   
    			   lblNewLabel_1.setEnabled(true);
    			   lblNewLabel_2.setEnabled(false);
	    		   lblNewLabel_3.setEnabled(false);
	    		   lblNewLabel_4.setEnabled(false);
	    		   lblNewLabel_5.setEnabled(false);
	    		   lblNewLabel_6.setEnabled(false);
	    		   lblNewLabel_7.setEnabled(false);
	    		   textField_1.setText("");
	    			textField_2.setText("");
	    			textField_3.setText("");
	    		   calendarBtn.setEnabled(false);
	    		   spinner.setEnabled(false);
	    		   spinner_1.setEnabled(false);
	    		   textField_1.setEnabled(false);
	    		   textField_2.setEnabled(false);
	    		  // textField_3.setEnabled(true);
	    		  spinner_2.setEnabled(false);
	    		   btnNewButton.setEnabled(false);
	    		   comboBox_1.setEnabled(true);
	       	    comboBox_1.removeAllItems();
	       	    
	       	    Set<String> actividades = iCS.listarActividadesDepartamento(comboBox.getSelectedItem().toString() );
	       	        actividades.forEach((act)->{
	       	        	
	       	           comboBox_1.addItem(act);
	       	           
	       	        });
	       	        settear =false;
    		   }
    	   }
       });
       comboBox_1.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent e) {
    		  if(!settear) {
    			   
    		
	    		  // textField_3.setEnabled(true);
	    		  spinner_2.setEnabled(false);
	    		   btnNewButton.setEnabled(false);
	    		   lblNewLabel_2.setEnabled(true);
	    		   lblNewLabel_3.setEnabled(true);
	    		   lblNewLabel_4.setEnabled(true);
	    		   lblNewLabel_5.setEnabled(true);
	    		   lblNewLabel_6.setEnabled(true);
	    		   lblNewLabel_7.setEnabled(true);
	    		   
	    		   calendarBtn.setEnabled(true);
	    		   spinner.setEnabled(true);
	    		   spinner_1.setEnabled(true);
	    		   textField_1.setEnabled(true);
	    		   textField_2.setEnabled(true);
	    		  // textField_3.setEnabled(true);
	    		  spinner_2.setEnabled(true);
	    		   btnNewButton.setEnabled(true);
    		  }
    			   
    		   }
    	   
       });
       
      /* rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
    	  
    	   public void actionPerformed(ActionEvent e) {
    		   if(!rdbtnNewRadioButton_1.isSelected()) {
	    		   lblNewLabel_2.setEnabled(false);
	    		   lblNewLabel_3.setEnabled(false);
	    		   lblNewLabel_4.setEnabled(false);
	    		   lblNewLabel_5.setEnabled(false);
	    		   lblNewLabel_6.setEnabled(false);
	    		   lblNewLabel_7.setEnabled(false);
	    		   
	    		   calendarBtn.setEnabled(false);
	    		   spinner.setEnabled(false);
	    		   spinner_1.setEnabled(false);
	    		   textField_1.setEnabled(false);
	    		   textField_2.setEnabled(false);
	    		  // textField_3.setEnabled(true);
	    		  spinner_2.setEnabled(false);
	    		   btnNewButton.setEnabled(false);
    		   }
    		   if(comboBox.getSelectedIndex() == -1 || comboBox_1.getSelectedIndex() == -1|| !settear) return;
    		   
    		   else {lblNewLabel_2.setEnabled(true);
    		   lblNewLabel_3.setEnabled(true);
    		   lblNewLabel_4.setEnabled(true);
    		   lblNewLabel_5.setEnabled(true);
    		   lblNewLabel_6.setEnabled(true);
    		   lblNewLabel_7.setEnabled(true);
    		   
    		   calendarBtn.setEnabled(true);
    		   spinner.setEnabled(true);
    		   spinner_1.setEnabled(true);
    		   textField_1.setEnabled(true);
    		   textField_2.setEnabled(true);
    		  // textField_3.setEnabled(true);
    		  spinner_2.setEnabled(true);
    		   btnNewButton.setEnabled(true);
    		   }
    	   }
       });*/
       
         
       calendarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.setVisible(true);
				date.setText(new DatePicker(f).setPickedDate());
				// string en formato dd-mm-yyyy
				if (!date.getText().isEmpty()) {
					textField_3.setText(date.getText());
					int dia = Integer.parseInt(date.getText().substring(0,2));
					int mes = Integer.parseInt(date.getText().substring(3,5));
					int anio = Integer.parseInt(date.getText().substring(6,10));
					fechaNac = new GregorianCalendar(anio, mes-1, dia);
				}
			}
		});
		
		date = new JTextField(20);
		f = new JInternalFrame();
		f.setVisible(false);
		
		
		 btnNewButton.addActionListener(new ActionListener() {

				
				
			 public void actionPerformed(ActionEvent ae) { 
				 
				 if(!checkForm()) {
					 JOptionPane.showMessageDialog(getContentPane(), "Complete los campos", " Registro invalido", JOptionPane.INFORMATION_MESSAGE);
				return;
				 }
				DTActividad act = iCS.getInfoActividad(comboBox_1.getSelectedItem().toString());
				int dia = fechaNac.get(fechaNac.DAY_OF_MONTH);
				int  mes = fechaNac.get(fechaNac.MONTH) + 1;
				int anio = fechaNac.get(fechaNac.YEAR);
				int diafa = act.getFechaAlta().get(fechaNac.DAY_OF_MONTH);
				int mesfa = (act.getFechaAlta().get(fechaNac.MONTH) + 1);
				int aniofa = (act.getFechaAlta().get(fechaNac.YEAR));
				String img ="salDefault.png";
				
				if(aniofa > anio || (aniofa == anio && mesfa > mes) || (aniofa == anio && mesfa == mes && diafa>dia)) {
					 JOptionPane.showMessageDialog(getContentPane(), "La fecha debe ser posterior al alta de la actividad ", " Registro invalido", JOptionPane.INFORMATION_MESSAGE);
					 
					 	return;
					
				}
				
				 if((int)spinner_2.getValue() < 0  ) {
					 JOptionPane.showMessageDialog(getContentPane(), "Cantidad de turistas debe ser positiva", " Registro invalido", JOptionPane.INFORMATION_MESSAGE);
				 return;
				 }
				 
				 int hora =(Integer) spinner.getValue();
				 int minutos = (Integer) spinner_1.getValue();
				 fechaNac.set(anio, mes-1, dia, hora, minutos);
		
				 try {
					 
					iCS.altaSalidaTuristica(textField_1.getText(), fechaNac, textField_2.getText(), (int)spinner_2.getValue(), new GregorianCalendar(),comboBox_1.getSelectedItem().toString(), img);
					 JOptionPane.showMessageDialog(getContentPane(), "La salida se ha creado con exito", "Registrar Salida", JOptionPane.INFORMATION_MESSAGE);
					 settear = true;
					 limpiarForm();
					 //cargarDatos();
					 settear = false;
					 setVisible(false);
				 } catch (YaExisteException e) {
					 JOptionPane.showMessageDialog(getContentPane(), "La salida ya existe", "Salida no Registrada", JOptionPane.INFORMATION_MESSAGE);
				}
				
		 }
			 
		 });
		 btnNewButton_1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent ae) {
			
				 limpiarForm();
				 setVisible(false);
			 }
			
			 
		 });
    	  

    	
}
	   
public void cargarDatos() {
	
	  Set<String> departamentos = ctrlSalida.listarDepartamentos();
      departamentos.forEach((d)->{
          comboBox.addItem(d);
      });
     
}
public boolean checkForm() {

	if(textField_1.getText().isBlank() || textField_2.getText().isBlank() || textField_3.getText().isBlank()  ) return false;
	return true;
}
		
public void limpiarForm() {
	
	textField_1.setText("");
	textField_2.setText("");
	textField_3.setText("");
	spinner.setValue(0);
	spinner_1.setValue(0);
	spinner_2.setValue(1);
	settear=true;
	 comboBox.removeAllItems();
	 comboBox_1.removeAllItems();
	 settear=false;
	// rdbtnNewRadioButton.setSelected(false);
	// rdbtnNewRadioButton_1.setSelected(false);	 
	// rdbtnNewRadioButton_1.setEnabled(false);

	
}
}


	
	
