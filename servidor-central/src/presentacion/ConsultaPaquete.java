package presentacion;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import logica.interfaces.ICtrlActividad;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;

import datatypes.DTPaquete;

import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class ConsultaPaquete extends JInternalFrame {

	private ICtrlActividad ctrlAct;
	private boolean cargandoDatos;

	private JTextField textFieldPeriodoValidez;
	private JTextField textFieldCosto;
	private JTextField textFieldFechaAlta;

	private JComboBox<String> comboBoxPaquetes;
	private JComboBox<String> comboBoxActividades;
	private JLabel lblPaquetesRegistrados;
	private JLabel lblDatosDelPaquete;
	private JLabel lblDescripcion;
	private JLabel lblPeriodoDeValidez;
	private JLabel lblCosto;
	private JLabel lblFechaDeAlta;
	private JLabel lblActividadesTuristicasIncluidas;

	private JTextPane textPaneDescripcion;
	private JButton btnSalir;

	private ConsultaDeActividadTuristica consultaActividad;
	private JScrollPane scrollPane;
	private JLabel lblCategorias;
	private JComboBox<String> comboBoxCategorias;

	public ConsultaPaquete(ICtrlActividad ica) {
		ctrlAct = ica;

		setIconifiable(true);
		setMaximizable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setResizable(true);
		setTitle("Consulta de Paquete de Actividades Turisticas");

		lblPaquetesRegistrados = new JLabel("Paquetes Registrados");
		lblPaquetesRegistrados.setHorizontalAlignment(SwingConstants.CENTER);

		comboBoxPaquetes = new JComboBox<String>();
		comboBoxActividades = new JComboBox<String>();
		comboBoxActividades.setEnabled(false);

		lblDatosDelPaquete = new JLabel("Datos del Paquete");
		lblDescripcion = new JLabel("Descripcion");
		lblPeriodoDeValidez = new JLabel("Periodo de Validez");
		lblCosto = new JLabel("Descuento");
		lblFechaDeAlta = new JLabel("Fecha de Alta");
		lblActividadesTuristicasIncluidas = new JLabel("Actividades Turisticas incluidas en el Paquete");

		textFieldPeriodoValidez = new JTextField();
		textFieldPeriodoValidez.setEditable(false);
		textFieldPeriodoValidez.setColumns(10);

		textFieldCosto = new JTextField();
		textFieldCosto.setEditable(false);
		textFieldCosto.setColumns(10);

		textFieldFechaAlta = new JTextField();
		textFieldFechaAlta.setEditable(false);
		textFieldFechaAlta.setColumns(10);

		btnSalir = new JButton("Cerrar");

		scrollPane = new JScrollPane();

		lblCategorias = new JLabel("Categorias");
		comboBoxCategorias = new JComboBox<String>();
		comboBoxCategorias.setEnabled(false);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPaquetesRegistrados)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBoxPaquetes, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblDatosDelPaquete)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblDescripcion)
								.addComponent(lblActividadesTuristicasIncluidas)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblFechaDeAlta)
									.addGap(28)
									.addComponent(textFieldFechaAlta, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCosto)
										.addComponent(lblCategorias))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(comboBoxCategorias, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(11)
													.addComponent(textFieldCosto, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(lblPeriodoDeValidez)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(textFieldPeriodoValidez, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
											.addPreferredGap(ComponentPlacement.RELATED))))
								.addComponent(comboBoxActividades, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))))
					.addGap(52, 52, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPaquetesRegistrados)
						.addComponent(comboBoxPaquetes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addComponent(lblDatosDelPaquete)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(lblDescripcion))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaDeAlta)
						.addComponent(textFieldFechaAlta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblCosto)
							.addComponent(textFieldCosto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPeriodoDeValidez)
							.addComponent(textFieldPeriodoValidez, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCategorias)
						.addComponent(comboBoxCategorias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblActividadesTuristicasIncluidas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxActividades, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSalir))
					.addContainerGap(356, Short.MAX_VALUE))
		);

		textPaneDescripcion = new JTextPane();
		scrollPane.setViewportView(textPaneDescripcion);
		textPaneDescripcion.setEditable(false);
		getContentPane().setLayout(groupLayout);

		Listeners();

		setBounds(12, 6, 488, 548);
		// pack();
		setVisible(true);
	}

	public void cargarDatosIniciales() {
		cargandoDatos = true;
		limpiarFormulario();
		comboBoxPaquetes.setEnabled(true);
		comboBoxPaquetes.removeAllItems();
		comboBoxPaquetes.addItem("Elija un Paquete");
		String[] paquetes = ctrlAct.listarPaquetes().toArray(String[]::new);
		for (String p : paquetes) {
			comboBoxPaquetes.addItem(p);
		}
		comboBoxActividades.setEnabled(false);
		comboBoxActividades.removeAllItems();
		comboBoxCategorias.setEnabled(false);
		comboBoxCategorias.removeAllItems();
		cargandoDatos = false;
	}

	private void Listeners() {

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarFormulario();
				setVisible(false);
			}
		});

		comboBoxPaquetes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String p = (String) comboBoxPaquetes.getSelectedItem();
				boolean dummyItem = p == "Elija un Paquete";
				if (!cargandoDatos && !dummyItem) {
					DTPaquete dtp = ctrlAct.getInfoPaquete(p);
					textPaneDescripcion.setText(dtp.getDescripcion());
					textFieldPeriodoValidez.setText(String.valueOf(dtp.getPeriodoValidez()) + " dias");
					textFieldCosto.setText(String.valueOf(dtp.getDescuento()) + " %");
					textFieldFechaAlta.setText(fechaStringFormato(dtp.getFechaAlta(), true));
					
					comboBoxCategorias.removeAllItems();
					for (String c : dtp.getCategorias()) {
						comboBoxCategorias.addItem(c);
					}
					comboBoxCategorias.setEnabled(true);
					
					cargandoDatos = true;
					comboBoxActividades.removeAllItems();
					for(String a : dtp.getActividades()) {
						comboBoxActividades.addItem(a);
					}
					comboBoxActividades.setEnabled(true);
					cargandoDatos = false;
					
				}
			}
		});
		
		comboBoxActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!cargandoDatos) {
					consultaActividad.datosQueVienenDesdeConsultaPaquete(comboBoxActividades.getSelectedItem().toString());
				}
			}
		});

	}

	@SuppressWarnings("static-access")
	private String fechaStringFormato(GregorianCalendar g, boolean conHora) {
		String dia = String.valueOf(g.get(g.DAY_OF_MONTH));
		String mes = String.valueOf(g.get(g.MONTH) + 1);
		String anio = String.valueOf(g.get(g.YEAR));
		String hora = String.valueOf(g.get(g.HOUR));
		String resultado = (conHora) ? dia + "/" + mes + "/" + anio + " " + hora + "hs" : dia + "/" + mes + "/" + anio;
		return resultado;
	}

	public void cargarConsultaActividadFrame(ConsultaDeActividadTuristica frame) {
		consultaActividad = frame;
	}

	private void limpiarFormulario() {
		textPaneDescripcion.setText("");
		textFieldPeriodoValidez.setText("");
		textFieldCosto.setText("");
		textFieldFechaAlta.setText("");
	}

	public void datosQueVienenDesdeConsultaActividad(String paquete) {
		cargarDatosIniciales();
		comboBoxPaquetes.setSelectedItem(paquete);
		comboBoxPaquetes.setEnabled(false);
		setVisible(true);
	}
}
