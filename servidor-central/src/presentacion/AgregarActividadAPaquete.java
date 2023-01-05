package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.HashSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import logica.clases.Compra;
import logica.clases.Turista;
import logica.handlers.HandlerUsuarios;
import logica.interfaces.ICtrlActividad;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import datatypes.DTActividad;
import datatypes.estadoActividad;

@SuppressWarnings("serial")
public class AgregarActividadAPaquete extends JInternalFrame{
	//Interfaces
	private ICtrlActividad controlAct;
	
	//Componentes graficos
	private JComboBox<String> comboBoxPaquetes;
	private JComboBox<String> comboBoxDepartamentos;
	private JComboBox<String> comboBoxActividades;
	private JLabel lblPaquetes;
	private JLabel lblDepartamentos;
	private JLabel lblActividades;
	private JButton btnCerrar;
	private JButton btnAceptar;
	
	private boolean borrandoFormularios = false;
	
	public AgregarActividadAPaquete(ICtrlActividad ica) {
		controlAct = ica;
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setBounds(30, 30, 435, 300);
		setResizable(true);
        setIconifiable(true);
        setClosable(true);
        setTitle("Agregar Actividad a Paquete");
        setBounds(100, 100, 400, 300);
        
        lblPaquetes = new JLabel("Paquetes:");
        lblPaquetes.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDepartamentos = new JLabel("Departamento:");
        lblDepartamentos.setHorizontalAlignment(SwingConstants.RIGHT);
        lblActividades = new JLabel("Actividad:");
        lblActividades.setHorizontalAlignment(SwingConstants.RIGHT);
        
        comboBoxPaquetes = new JComboBox<String>();
        comboBoxPaquetes.setEnabled(true);
        comboBoxPaquetes.setToolTipText("Seleccione un paquete");
        comboBoxDepartamentos = new JComboBox<String>();
        comboBoxDepartamentos.setEnabled(true);
        comboBoxDepartamentos.setToolTipText("Seleccione un departamento");
        comboBoxActividades = new JComboBox<String>();
        comboBoxActividades.setEnabled(false);
        comboBoxActividades.setToolTipText("Seleccione una actividad");
        
        btnCerrar = new JButton("Cancelar");
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	limpiarFormulario();
                setVisible(false);
            }
        });
        
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		cmdAgregarActividadPaqueteActionPerformed(arg0);
        	}
        });
        
        comboBoxPaquetes.addActionListener(new ActionListener( ) {
        	public void actionPerformed(ActionEvent arg0) {
        		if(!borrandoFormularios) {
        			cargarActividades();
        		}
        	}
        });
        
        comboBoxDepartamentos.addActionListener(new ActionListener( ) {
        	public void actionPerformed(ActionEvent arg0) {
        		if(!borrandoFormularios) {
        			cargarActividades();
        		}
        	}
        });
        
        //Layout
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(lblDepartamentos)
        						.addComponent(lblPaquetes)))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(32)
        					.addComponent(lblActividades)))
        			.addGap(7)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(comboBoxDepartamentos, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(comboBoxPaquetes, 0, 234, Short.MAX_VALUE)
        				.addComponent(comboBoxActividades, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addContainerGap(29, Short.MAX_VALUE))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap(165, Short.MAX_VALUE)
        			.addComponent(btnAceptar)
        			.addGap(28)
        			.addComponent(btnCerrar)
        			.addContainerGap())
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(32)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(comboBoxPaquetes, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblPaquetes))
        			.addGap(50)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(67)
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblActividades)
        						.addComponent(comboBoxActividades, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(lblDepartamentos)
        					.addComponent(comboBoxDepartamentos, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
        			.addGap(18)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnCerrar)
        				.addComponent(btnAceptar))
        			.addContainerGap())
        );
        getContentPane().setLayout(groupLayout);
        pack();
	}
	
	protected void cmdAgregarActividadPaqueteActionPerformed(ActionEvent arg0) {
		if(checkFormulario()) {
			controlAct.ingresarActividadAPaquete(comboBoxPaquetes.getSelectedItem().toString(), comboBoxActividades.getSelectedItem().toString());
			JOptionPane.showMessageDialog(this, "La actividad se ha agregado correctamente", "Agregar Actividad a Paquete", JOptionPane.INFORMATION_MESSAGE);
			limpiarFormulario();
			setVisible(false);
		}
	}
	
	public void cargarPaquetes() {
		borrandoFormularios = true;
		comboBoxPaquetes.removeAllItems();
		borrandoFormularios = false;
		DefaultComboBoxModel<String> model;
		
		//El ComboBox no soporta Sets, hay que decidir que hacer
		Set<String> setPaquetes = controlAct.listarPaquetes();
		HandlerUsuarios hu = HandlerUsuarios.getInstance();
		Set<Turista> turistas = hu.listarTuristas();
		for (Turista t : turistas){
			Set<Compra> compras =  new HashSet<Compra>(t.getCompras().values());
			for (Compra i : compras)
				setPaquetes.remove(i.getPaquete().getNombre());
		}
			 
		String[] arrPaquetes = new String[setPaquetes.size()];
		setPaquetes.toArray(arrPaquetes);
			 
		model = new DefaultComboBoxModel<String>(arrPaquetes);
		comboBoxPaquetes.setModel(model);
		comboBoxActividades.setEnabled(false);
		borrandoFormularios = true;
		comboBoxPaquetes.setSelectedItem(null);
		borrandoFormularios = false;
	}
	
	public void cargarDepartamentos() {
		borrandoFormularios = true;
		comboBoxDepartamentos.removeAllItems();
		borrandoFormularios = false;
		DefaultComboBoxModel<String> model;
		//El ComboBox no soporta Sets, hay que decidir que hacer
		Set<String> setDeptos = controlAct.listarDepartamentos();
		String[] arrDeptos = new String[setDeptos.size()];
		setDeptos.toArray(arrDeptos);
		
		model = new DefaultComboBoxModel<String>(arrDeptos);
		comboBoxDepartamentos.setModel(model);
		comboBoxActividades.setEnabled(false);
		borrandoFormularios = true;
		comboBoxDepartamentos.setSelectedItem(null);
		borrandoFormularios = false;
	}
	
	private void cargarActividades() {
		if(comboBoxDepartamentos.getSelectedIndex() != -1 && comboBoxPaquetes.getSelectedIndex() != -1) {
			borrandoFormularios = true;
			comboBoxActividades.removeAllItems();
			borrandoFormularios = false;
			DefaultComboBoxModel<String> model;
			//El ComboBox no soporta Sets, hay que decidir que hacer
			Set<String> setActs = controlAct.listarActividadesDepartamentoMenosPaquete(comboBoxDepartamentos.getSelectedItem().toString(), comboBoxPaquetes.getSelectedItem().toString());
			
			for(String act: setActs) {
				DTActividad actividad = controlAct.getInfoActividad(act);
				if( actividad.getestado() != estadoActividad.confirmada  ) {
					setActs.remove(actividad.getNombre());
				}
			}
			String[] arrActs = new String[setActs.size()];
			setActs.toArray(arrActs);
			
			model = new DefaultComboBoxModel<String>(arrActs);
			comboBoxActividades.setModel(model);
			borrandoFormularios = true;
			comboBoxActividades.setSelectedItem(null);
			borrandoFormularios = false;
			comboBoxActividades.setEnabled(true);
		}
	}
	
	private boolean checkFormulario() {
		if(comboBoxDepartamentos.getSelectedIndex() == -1 || comboBoxActividades.getSelectedIndex() == -1 || 
				   comboBoxPaquetes.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Agregar Actividad a Paquete", JOptionPane.ERROR_MESSAGE);
					return false;
		}
		
		return true;
	}
	
	public void limpiarFormulario() {
		borrandoFormularios = true;
		comboBoxPaquetes.removeAllItems();
		comboBoxDepartamentos.removeAllItems();
        comboBoxActividades.removeAllItems();
        borrandoFormularios = false;
	}
}