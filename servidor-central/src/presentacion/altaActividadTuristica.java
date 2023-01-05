package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

//import excepciones.UsuarioNoExisteException;
import datatypes.estadoActividad;
import excepciones.YaExisteException;
//import logica.DataUsuario;
import logica.interfaces.ICtrlActividad;
import logica.interfaces.ICtrlUsuario;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;

@SuppressWarnings("serial")
public class altaActividadTuristica extends JInternalFrame {
	private ICtrlActividad IActividad;
	private ICtrlUsuario IUsuario;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	private JInternalFrame f; //se muestra el calendario
	private JTextField date;
	DefaultListModel<String> listModel;
	JList<String> listCat;
	private JTextField textFieldCalendario;

	/**
	 * Launch the application.
	 */
/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					altaActividadTuristica frame = new altaActividadTuristica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public altaActividadTuristica(ICtrlActividad ica, ICtrlUsuario icu) {
		IActividad = ica;
		IUsuario = icu;
		
		setClosable(true);
		setTitle("Alta de Actividad Turística");
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 470, 435);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{121, 33, 66, 108, 101, 0};
		gridBagLayout.rowHeights = new int[]{22, 22, 20, 20, 20, 20, 20, 20, 14, 119, 23, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Proveedor:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		comboBox = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.NORTH;
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridwidth = 4;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		getContentPane().add(comboBox, gbc_comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Departamento:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		comboBox_1 = new JComboBox<String>();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.anchor = GridBagConstraints.NORTH;
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.gridwidth = 4;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 1;
		getContentPane().add(comboBox_1, gbc_comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre de Actvidad:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridwidth = 4;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		getContentPane().add(textField, gbc_textField);
		
		JLabel lblNewLabel_3 = new JLabel("Descripción:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.NORTH;
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridwidth = 4;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 3;
		getContentPane().add(textField_1, gbc_textField_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Duración en horas:");
		GridBagConstraints gbc_lblNewLabel_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1.gridx = 0;
		gbc_lblNewLabel_3_1.gridy = 4;
		getContentPane().add(lblNewLabel_3_1, gbc_lblNewLabel_3_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.NORTH;
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridwidth = 4;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 4;
		getContentPane().add(textField_2, gbc_textField_2);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Costo por persona:");
		GridBagConstraints gbc_lblNewLabel_3_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1_1.gridx = 0;
		gbc_lblNewLabel_3_1_1.gridy = 5;
		getContentPane().add(lblNewLabel_3_1_1, gbc_lblNewLabel_3_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.NORTH;
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridwidth = 4;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 5;
		getContentPane().add(textField_3, gbc_textField_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ciudad:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 6;
		getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.anchor = GridBagConstraints.NORTH;
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.gridwidth = 4;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 6;
		getContentPane().add(textField_4, gbc_textField_4);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 7;
		getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JButton btnCalendario = new JButton("");
		btnCalendario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCalendario.setEnabled(true);
		GridBagConstraints gbc_btnCalendario = new GridBagConstraints();
		gbc_btnCalendario.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCalendario.insets = new Insets(0, 0, 5, 5);
		gbc_btnCalendario.gridx = 1;
		gbc_btnCalendario.gridy = 7;
		getContentPane().add(btnCalendario, gbc_btnCalendario);
		
		btnCalendario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				setVisible(true);
				date.setText(new DatePicker(f).setPickedDate());
				if(!date.getText().isEmpty()) {
					textFieldCalendario.setText(date.getText());				
				}
			}
		});
		
		textFieldCalendario = new JTextField();
		GridBagConstraints gbc_textFieldCalendario = new GridBagConstraints();
		gbc_textFieldCalendario.gridwidth = 2;
		gbc_textFieldCalendario.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCalendario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCalendario.gridx = 2;
		gbc_textFieldCalendario.gridy = 7;
		getContentPane().add(textFieldCalendario, gbc_textFieldCalendario);
		textFieldCalendario.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Seleccionar Categorias:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 8;
		getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.gridwidth = 4;
		gbc_list.gridx = 0;
		gbc_list.gridy = 9;

		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmdAltaActividadTuristicaActionPerformed(e);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 11;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				limpiarFormulario();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 11;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
        String icon_path = "src/icons/calendario.png";
        ImageIcon icon = new ImageIcon(icon_path,"calendario");
        Image img = icon.getImage();
    	Image scaled_img = img.getScaledInstance( 15, 15,  java.awt.Image.SCALE_SMOOTH ) ;  
		btnCalendario.setIcon(new ImageIcon(scaled_img));
		
		listModel = new DefaultListModel<String>();
		listCat = new JList<String>(listModel);
		getContentPane().add(listCat, gbc_list);
		
        //maneja el calendario con iconito
		date = new JTextField(20);
		f = new JInternalFrame();
		f.setVisible(false);
	}
	
	protected void cmdAltaActividadTuristicaActionPerformed(ActionEvent arg0) {
		String nomActividad = this.textField.getText();
		String desc = this.textField_1.getText();
		String duraHs = this.textField_2.getText();
		String costo =  this.textField_3.getText();
		String nombCiudad = this.textField_4.getText();
		List<String> cat = this.listCat.getSelectedValuesList();
		String img = "actDefault.jpg";

		if(checkFormulario()) {
			int dia = Integer.parseInt(date.getText().substring(0,2));
			int mes = Integer.parseInt(date.getText().substring(3,5));
			int anio = Integer.parseInt(date.getText().substring(6,10));
			GregorianCalendar fecha = new GregorianCalendar(anio, mes-1, dia);
			
			Set<String> setCat = new HashSet<String>();
			cat.forEach(catNom ->{
				setCat.add(catNom);
			});
			
			try {
				IActividad.altaActividadTuristica(comboBox_1.getSelectedItem().toString(), nomActividad, desc, Integer.parseInt(duraHs), Float.parseFloat(costo), 
						nombCiudad, comboBox.getSelectedItem().toString(), fecha, img, setCat,"", estadoActividad.confirmada);
				limpiarFormulario();
				JOptionPane.showMessageDialog(this,
						"Actividad Turística creada con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
			} catch(YaExisteException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Alta de Actividad Turistica", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
	
	private boolean checkFormulario() {
		String nomActividad = this.textField.getText();
		String desc = this.textField_1.getText();
		String duraHs = this.textField_2.getText();
		String costo =  this.textField_3.getText();
		String nombCiudad = this.textField_4.getText();
		String fecha = this.date.getText();
		List<String> cat = this.listCat.getSelectedValuesList();
		
		if (nomActividad.isEmpty() || desc.isEmpty() || duraHs.isEmpty() || costo.isEmpty() || nombCiudad.isEmpty() || comboBox.getSelectedIndex() == -1 ||
				comboBox_1.getSelectedIndex() == -1 || fecha.isEmpty() || cat.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta de Actividad Turistica",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            Integer.parseInt(duraHs);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La duraci�n en horas debe ser un n�mero entero positivo", "Alta de Actividad Turistica",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Float.parseFloat(costo);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El costo debe ser un número positivo", "Alta de Actividad Turistica",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(Integer.parseInt(duraHs) < 0) {
        	JOptionPane.showMessageDialog(this, "La duraci�n en horas debe ser un número entero positivo", "Alta de Actividad Turistica",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(Float.parseFloat(costo) < 0) {
        	JOptionPane.showMessageDialog(this, "El costo debe ser un número positivo", "Alta de Actividad Turistica",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
	}
	
	private void limpiarFormulario() {
		comboBox.removeAllItems();
		comboBox_1.removeAllItems();
		
		listModel.removeAllElements();
		
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
    	textFieldCalendario.setText("");

	}
	
	public void cargarDatos() {
		cargarProveedores();
		cargarDepartamentos();
		cargarCategorias();
	}
	
	private void cargarProveedores() {
       	Set<String> proveedores = IUsuario.listarProveedores();
       	String[] arrProveedores = new String[proveedores.size()];
    	proveedores.toArray(arrProveedores);
       	
    	DefaultComboBoxModel<String> model;
        model = new DefaultComboBoxModel<String>(arrProveedores);
        comboBox.setModel(model);
	}
	
	private void cargarDepartamentos() {
       	Set<String> departamentos = IActividad.listarDepartamentos();
       	String[] arrDepartamentos = new String[departamentos.size()];
    	departamentos.toArray(arrDepartamentos);
       	
    	DefaultComboBoxModel<String> model;
        model = new DefaultComboBoxModel<String>(arrDepartamentos);
        comboBox_1.setModel(model);
	}
	
	private void cargarCategorias() {
		if(!listModel.isEmpty())
			listModel.clear();
		Set<String> categorias = IActividad.listarCategorias();
		categorias.forEach(cate -> {
			listModel.addElement(cate);
		});
	}
}
