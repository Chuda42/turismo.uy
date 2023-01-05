package presentacion;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import datatypes.DTSalida;

import logica.interfaces.ICtrlActividad;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class ConsultaSalida extends JInternalFrame {

	// Controlador
	private ICtrlActividad ctrlSalida;
	// Basicos
	private JLabel LabelSelcDepartamento;

	// Si el usuario es proveedor

	private JTextField textField_2;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	//private JRadioButton rdbtnDepto;
	private JComboBox<String> ComboBoxSelDepartamento, comboBox_1, comboBoxSal, comboBoxTuristas;
	private boolean settear;

	public ConsultaSalida(ICtrlActividad iCS) {
		getContentPane().setForeground(Color.PINK);
		// meto la interfaz
		this.ctrlSalida = iCS;
		// meto la interfaz
		this.ctrlSalida = iCS;

		// Cuestiones de configuracion del frame
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Consulta de Salida Turistica");

		setBounds(30, 30, 453, 431);

		///////////////// SELECCIONAR DEPARTAMENTO////////////////////////////////////
		LabelSelcDepartamento = new JLabel("Seleccionar departamento: ");
		LabelSelcDepartamento.setHorizontalAlignment(SwingConstants.RIGHT);

		ComboBoxSelDepartamento = new JComboBox<String>();
		Set<String> departamentos = iCS.listarDepartamentos();
		departamentos.forEach((d) -> {
			ComboBoxSelDepartamento.addItem(d);
		});

		///////////////// SELECCIONAR
		///////////////// ACTIVIDAD//////////////////////////////////////////////

		JLabel lblNewLabel = new JLabel("Seleccionar Actividad:");
		lblNewLabel.setEnabled(false);

		comboBox_1 = new JComboBox<String>();
		comboBox_1.setEnabled(false);

		JLabel lblNewLabel_1 = new JLabel("Seleccionar Salida Turistica:");
		lblNewLabel_1.setEnabled(false);

		comboBoxSal = new JComboBox<String>();
		comboBoxSal.setEnabled(false);

		JLabel lblNewLabel_2 = new JLabel("INFORMACION DE LA SALIDA:");

		JLabel lblNewLabel_3 = new JLabel("Nombre:");

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Lugar:");

		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Cantidad max. Turistas:");

		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Fecha Alta:");

		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Fecha Salida:");

		textField_10 = new JTextField();
		textField_10.setEditable(false);
		// textField_10.setEnabled(false);
		textField_10.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Turistas Inscriptos:");

		JButton btnNewButton_1 = new JButton("Cerrar");

		comboBoxTuristas = new JComboBox<String>();
		comboBoxTuristas.setEnabled(false);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(LabelSelcDepartamento)
					.addGap(5)
					.addComponent(ComboBoxSelDepartamento, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addGap(146))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(67)
					.addComponent(lblNewLabel)
					.addGap(5)
					.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addGap(137))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNewLabel_1)
					.addGap(5)
					.addComponent(comboBoxSal, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addGap(143))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(129)
					.addComponent(lblNewLabel_2))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(151)
					.addComponent(lblNewLabel_3)
					.addGap(5)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(166)
					.addComponent(lblNewLabel_4)
					.addGap(5)
					.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addComponent(lblNewLabel_5)
					.addGap(5)
					.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(136)
					.addComponent(lblNewLabel_6)
					.addGap(5)
					.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(124)
					.addComponent(lblNewLabel_7)
					.addGap(5)
					.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(83)
					.addComponent(lblNewLabel_8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(179)
							.addComponent(btnNewButton_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBoxTuristas, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(LabelSelcDepartamento, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(ComboBoxSelDepartamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel))
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel_1))
						.addComponent(comboBoxSal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2)
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel_3))
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel_4))
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel_5))
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel_6))
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel_7))
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_8)
						.addComponent(comboBoxTuristas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		pack();
		
		ComboBoxSelDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!settear) {
				limpiarForm();
				settear = true;
				comboBox_1.removeAllItems();
				comboBoxSal.removeAllItems();
				comboBox_1.setEnabled(true);
				lblNewLabel.setEnabled(true);
				lblNewLabel_1.setEnabled(true);
				//rdbtnNewRadioButton.setEnabled(true);

				
				// comboBox_1.removeAllItems();
				Set<String> actividades = iCS
						.listarActividadesDepartamento(ComboBoxSelDepartamento.getSelectedItem().toString());
				actividades.forEach((act) -> {
					comboBox_1.addItem(act);

				});
				settear = false;
				//if(depto.isSelected()) {
					/*depto.setSelected(false);
					limpiarForm();
					comboBox_1.removeAllItems();
					comboBox_1.setEnabled(false);
					comboBoxSal.removeAllItems();
					comboBoxSal.setEnabled(false);
					rdbtnNewRadioButton_1.setSelected(false);
					rdbtnNewRadioButton_1.setEnabled(false);
					rdbtnNewRadioButton.setEnabled(false);
					rdbtnNewRadioButton.setSelected(false);
					comboBoxTuristas.removeAllItems();*/
				}
				
			}
			
		});
		
		
		/// muestro salidas de esa actividad
		/*rdbtnNewRadioButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (!rdbtnNewRadioButton.isSelected()) {
					limpiarForm();
					settear = false;
					comboBoxTuristas.removeAllItems();

					comboBox_1.removeAllItems();
					comboBoxSal.removeAllItems();
					comboBoxSal.setEnabled(false);
					comboBox_1.setEnabled(false);
					depto.setSelected(false);
					settear = true;
					rdbtnNewRadioButton_1.setEnabled(false);
					rdbtnNewRadioButton.setEnabled(false);
					rdbtnNewRadioButton_1.setSelected(false);

				} else if (!settear || ComboBoxSelDepartamento.getSelectedIndex() == -1
						|| comboBox_1.getSelectedIndex() == -1)
					return;

				else {
					rdbtnNewRadioButton_1.setEnabled(true);
					settear = false;
					comboBoxSal.setEnabled(true);
					comboBoxSal.removeAllItems();

					Set<String> salidas = iCS.listarNombresSalidasDeActividad(comboBox_1.getSelectedItem().toString());
					if (salidas.isEmpty())
						return;
					salidas.forEach((sal) -> {

						comboBoxSal.addItem(sal);
					});
					settear = true;
				}
			} 
		});*/
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!settear) {
				//rdbtnNewRadioButton_1.setEnabled(true);
				settear = true;
				comboBoxSal.setEnabled(true);
				comboBoxSal.removeAllItems();

				Set<String> salidas = iCS.listarNombresSalidasDeActividad(comboBox_1.getSelectedItem().toString());
				
				salidas.forEach((sal) -> {

					comboBoxSal.addItem(sal);
				});
				comboBoxTuristas.removeAllItems();
				settear = false;

				/*if(rdbtnNewRadioButton.isSelected()) {
					rdbtnNewRadioButton.setSelected(false);
					rdbtnNewRadioButton_1.setSelected(false);
					settear = false;
					limpiarForm();
					comboBoxTuristas.removeAllItems();
					comboBoxSal.removeAllItems();
					comboBoxSal.setEnabled(false);
					settear = true;
				*/
				}
			}
			
		});
		comboBoxSal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!settear) {
				//if(rdbtnNewRadioButton_1.isSelected()) {
					//rdbtnNewRadioButton_1.setSelected(false);
					//limpiarForm();
					
				//}
					settear = true;
				DTSalida res = iCS.getInfoCompletaSalida(comboBoxSal.getSelectedItem().toString());
				textField_2.setText(res.getNombre());
				textField_8.setText(res.getlugarSalida());
				textField_7.setText(String.valueOf(res.getcantidadMaximaDeTuristas()));
				textField_9.setText(String.valueOf(fechaStringFormato(res.getfechaAlta(), false)));
				textField_10.setText(String.valueOf(fechaStringFormato(res.getfechaSalida(), true)));
				Set<String> aux = res.getTuristasInscriptos();
				DefaultComboBoxModel<String> model;
				String[] arrT = new String[aux.size()];
				aux.toArray(arrT);
				model = new DefaultComboBoxModel<String>(arrT);
				comboBoxTuristas.setModel(model);
				comboBoxTuristas.setEnabled(true);
				settear = false;
				}
			
			}
			
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				settear = true;
				ComboBoxSelDepartamento.removeAllItems();
				limpiarForm();
				setVisible(false);
				comboBox_1.removeAllItems();
				comboBox_1.setEnabled(false);
				comboBoxSal.removeAllItems();
				comboBoxSal.setEnabled(false);
				comboBoxTuristas.removeAllItems();
				comboBoxTuristas.setEnabled(false);
				settear = false;
			}

		});

	}

	public void cargarDatos() {
		ComboBoxSelDepartamento.setEnabled(true);
		//rdbtnDepto.setEnabled(true);
		comboBox_1.setEnabled(true);
		//rdbtnNewRadioButton.setEnabled(true);
		comboBoxSal.setEnabled(true);
		//rdbtnNewRadioButton_1.setEnabled(true);
		settear = true;
		ComboBoxSelDepartamento.removeAllItems();
		comboBox_1.removeAllItems();
		comboBoxSal.removeAllItems();
		comboBoxTuristas.removeAllItems();
		limpiarForm();
		Set<String> departamentos = ctrlSalida.listarDepartamentos();
		departamentos.forEach((d) -> {
			ComboBoxSelDepartamento.addItem(d);
		});
		settear = false;

	}

	@SuppressWarnings("static-access")
	public String fechaStringFormato(GregorianCalendar g, boolean conHora) {
		String dia = String.valueOf(g.get(g.DAY_OF_MONTH));
		String mes = String.valueOf(g.get(g.MONTH) + 1);
		String anio = String.valueOf(g.get(g.YEAR));
		String hora = String.valueOf(g.get(g.HOUR));
		String resultado = (conHora) ? dia + "/" + mes + "/" + anio + " " + hora + "hs" : dia + "/" + mes + "/" + anio;
		return resultado;
	}

	public void limpiarForm() {

		textField_10.setText("");
		textField_2.setText("");
		textField_8.setText("");
		textField_7.setText("");
		textField_9.setText("");

	}

	public void datosQueVienenDesdeOtroCasoDeUso(String departamento, String actividad, String salida) {
		limpiarForm();
		cargarDatos();
		ComboBoxSelDepartamento.setSelectedItem(departamento);
		comboBox_1.setSelectedItem(actividad);
		comboBoxSal.setSelectedItem(salida);
		ComboBoxSelDepartamento.setEnabled(false);
		comboBox_1.setEnabled(false);
		comboBoxSal.setEnabled(false);
		setVisible(true);
	}
}
