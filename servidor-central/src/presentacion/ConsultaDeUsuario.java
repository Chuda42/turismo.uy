package presentacion;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import datatypes.DTActividad;
import datatypes.DTProveedor;
import datatypes.DTSalida;
import datatypes.DTTurista;
import datatypes.DTUsuario;
import datatypes.estadoActividad;
import logica.interfaces.ICtrlUsuario;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class ConsultaDeUsuario extends JInternalFrame {

	//Controlador
	private ICtrlUsuario ctrlUsuario;
	//Basicos
	private JLabel LabelSelcUsuario;
	private JComboBox<String> ComboBoxSelUsuario;
	private JLabel LabelInfoUsuario;
	private JLabel LabelTipoUsuario;
	private JTextField TextTipoUsuario;
	//Datos del usuario
	private JLabel LabelNickname;
	private JTextField TextNickname;
	private JLabel LabelEmail;
	private JTextField TextEmail;
	private JLabel LabelNombre;
	private JTextField TextNombre;
	private JLabel LabelApellido;
	private JTextField TextApellido;
	private JLabel LabelFechaNac;
	private JTextField TextFechaNac;
	//Si usuario es turista
	private JLabel LabelNacionalidad;
	private JTextField TextNacionalidad;
	private JLabel LabelSalidasInscripto;
	private JComboBox<DTSalida> ComboBoxSalidasInscripto;
	//Si el usuario es proveedor
	private JLabel LabelDescripcion;
	private JTextArea TextDescripcion;
	private JLabel LabelSitioWeb;
	private JTextField TextSitioWeb;
	private JLabel LabelActividadesProveedor;
	private JComboBox<DTActividad> ComboBoxActividadesProveedor;
	private JLabel LabelSalidasDeActividadesDelProveedor;
	private JLabel DescripcionActividadProveedorLabel;
	private JTextArea DescripcionActividadProveedorTextArea;
	private JScrollPane DescripcionActividadProveedorScrollPane;
	private JComboBox<String> ComboBoxSalidasDeActividadesDelProveedor;
	//borrando
	private boolean seteandoDatosIniciales = false;
	//Datos que interesa conservar temporalmente
	private DTUsuario dtU = null;
	//Ventanas que abre
	private ConsultaDeActividadTuristica ventanaConsultaActividad;
	private ConsultaSalida ventanaConsultaSalida;
	private JButton btnCerrar;
	

	
	public ConsultaDeUsuario(ICtrlUsuario iCU) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		//meto la interfaz y la ventana de actividada
		this.ctrlUsuario = iCU;
		
		//Cuestiones de configuracion del frame
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Consulta de Usuario");
				
		setBounds(30, 30, 654, 555);
				
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = new int[] { 41, 219, 134, 104, 43 };
		gbl.rowHeights = new int[] { 0, 0, 30, 30, 30, 30, 30, 30, 30, 47, 30, 30, 44, 36, 0, 0 };
		gbl.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gbl);
        
		//label seleccionar usuario
		LabelSelcUsuario = new JLabel("Seleccionar Usuario: ");
		LabelSelcUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_labelSelcUsuario = new GridBagConstraints();
		gbc_labelSelcUsuario.fill = GridBagConstraints.BOTH;
		gbc_labelSelcUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_labelSelcUsuario.gridx = 1;
		gbc_labelSelcUsuario.gridy = 1;
		getContentPane().add(LabelSelcUsuario, gbc_labelSelcUsuario);
        //Combo box seleccionar usuario
        ComboBoxSelUsuario = new JComboBox<String>();
        
        GridBagConstraints gbc_cBSelcUsuario = new GridBagConstraints();
        gbc_cBSelcUsuario.fill = GridBagConstraints.BOTH;
        gbc_cBSelcUsuario.insets = new Insets(0, 0, 5, 5);
        gbc_cBSelcUsuario.gridx = 2;
        gbc_cBSelcUsuario.gridy = 1;
        getContentPane().add(ComboBoxSelUsuario, gbc_cBSelcUsuario);
        	        
        //label Informacion usuario
        LabelInfoUsuario = new JLabel("Informacion del usuario");
        LabelInfoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc_LabelInfoUsuario = new GridBagConstraints();
        gbc_LabelInfoUsuario.fill = GridBagConstraints.BOTH;
        gbc_LabelInfoUsuario.insets = new Insets(0, 0, 5, 0);
        gbc_LabelInfoUsuario.gridx = 1;
        gbc_LabelInfoUsuario.gridy = 2;
        gbc_LabelInfoUsuario.gridwidth = 4;
        getContentPane().add(LabelInfoUsuario, gbc_LabelInfoUsuario);
			
		        
        //Label tipo usuario
        LabelTipoUsuario = new JLabel("Tipo de usuario: ");
        LabelTipoUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelTipoUsuario = new GridBagConstraints();
        gbc_LabelTipoUsuario.fill = GridBagConstraints.BOTH;
        gbc_LabelTipoUsuario.insets = new Insets(0, 0, 5, 5);
        gbc_LabelTipoUsuario.gridx = 1;
        gbc_LabelTipoUsuario.gridy = 3;
        getContentPane().add(LabelTipoUsuario, gbc_LabelTipoUsuario);
        //text box tipo usuario
        TextTipoUsuario = new JTextField();
        TextTipoUsuario.setEditable(false);
        GridBagConstraints gbc_TextTipoUsuario = new GridBagConstraints();
        gbc_TextTipoUsuario.gridwidth = 2;
        gbc_TextTipoUsuario.fill = GridBagConstraints.BOTH;
        gbc_TextTipoUsuario.insets = new Insets(0, 0, 5, 5);
        gbc_TextTipoUsuario.gridx = 2;
        gbc_TextTipoUsuario.gridy = 3;
        getContentPane().add(TextTipoUsuario, gbc_TextTipoUsuario);

        //Label nickname 
        LabelNickname = new JLabel("Nickname: ");
        LabelNickname.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelNickname = new GridBagConstraints();
        gbc_LabelNickname.fill = GridBagConstraints.BOTH;
        gbc_LabelNickname.insets = new Insets(0, 0, 5, 5);
        gbc_LabelNickname.gridx = 1;
        gbc_LabelNickname.gridy = 4;
        getContentPane().add(LabelNickname, gbc_LabelNickname);
        //text box nickname 
        TextNickname = new JTextField();
        TextNickname.setEditable(false);
        GridBagConstraints gbc_TextNickname = new GridBagConstraints();
        gbc_TextNickname.gridwidth = 2;
        gbc_TextNickname.fill = GridBagConstraints.BOTH;
        gbc_TextNickname.insets = new Insets(0, 0, 5, 5);
        gbc_TextNickname.gridx = 2;
        gbc_TextNickname.gridy = 4;
        getContentPane().add(TextNickname, gbc_TextNickname);
		        
        //Label email
        LabelEmail = new JLabel("E-mail: ");
        LabelEmail.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelEmail = new GridBagConstraints();
        gbc_LabelEmail.fill = GridBagConstraints.BOTH;
        gbc_LabelEmail.insets = new Insets(0, 0, 5, 5);
        gbc_LabelEmail.gridx = 1;
        gbc_LabelEmail.gridy = 5;
        getContentPane().add(LabelEmail, gbc_LabelEmail);
        //text box email
        TextEmail = new JTextField();
        TextEmail.setEditable(false);
        GridBagConstraints gbc_TextEmail = new GridBagConstraints();
        gbc_TextEmail.gridwidth = 2;
        gbc_TextEmail.fill = GridBagConstraints.BOTH;
        gbc_TextEmail.insets = new Insets(0, 0, 5, 5);
        gbc_TextEmail.gridx = 2;
        gbc_TextEmail.gridy = 5;
	    getContentPane().add(TextEmail, gbc_TextEmail);
		        
        //Label nombre
        LabelNombre = new JLabel("Nombre: ");
        LabelNombre.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelNombre = new GridBagConstraints();
        gbc_LabelNombre.fill = GridBagConstraints.BOTH;
        gbc_LabelNombre.insets = new Insets(0, 0, 5, 5);
        gbc_LabelNombre.gridx = 1;
        gbc_LabelNombre.gridy = 6;
        getContentPane().add(LabelNombre, gbc_LabelNombre);
        //text box nombre
        TextNombre = new JTextField();
        TextNombre.setEditable(false);
        GridBagConstraints gbc_TextNombre = new GridBagConstraints();
        gbc_TextNombre.gridwidth = 2;
        gbc_TextNombre.fill = GridBagConstraints.BOTH;
        gbc_TextNombre.insets = new Insets(0, 0, 5, 5);
        gbc_TextNombre.gridx = 2;
        gbc_TextNombre.gridy = 6;
        getContentPane().add(TextNombre, gbc_TextNombre);
		        
        //Label apellido
        LabelApellido = new JLabel("Apellido: ");
        LabelApellido.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelApellido = new GridBagConstraints();
        gbc_LabelApellido.fill = GridBagConstraints.BOTH;
        gbc_LabelApellido.insets = new Insets(0, 0, 5, 5);
        gbc_LabelApellido.gridx = 1;
        gbc_LabelApellido.gridy = 7;
        getContentPane().add(LabelApellido, gbc_LabelApellido);
        //text box apellido
        TextApellido = new JTextField();
        TextApellido.setEditable(false);
        GridBagConstraints gbc_TextApellido = new GridBagConstraints();
        gbc_TextApellido.gridwidth = 2;
        gbc_TextApellido.fill = GridBagConstraints.BOTH;
        gbc_TextApellido.insets = new Insets(0, 0, 5, 5);
        gbc_TextApellido.gridx = 2;
        gbc_TextApellido.gridy = 7;
        getContentPane().add(TextApellido, gbc_TextApellido);
		        
        //Label FechaNac
        LabelFechaNac = new JLabel("Fecha de nacimiento: ");
        LabelFechaNac.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelFechaNac = new GridBagConstraints();
        gbc_LabelFechaNac.fill = GridBagConstraints.BOTH;
        gbc_LabelFechaNac.insets = new Insets(0, 0, 5, 5);
        gbc_LabelFechaNac.gridx = 1;
        gbc_LabelFechaNac.gridy = 8;
        getContentPane().add(LabelFechaNac, gbc_LabelFechaNac);
        //text box FechaNac
        TextFechaNac = new JTextField();
        TextFechaNac.setEditable(false);
        GridBagConstraints gbc_TextFechaNac = new GridBagConstraints();
        gbc_TextFechaNac.gridwidth = 2;
        gbc_TextFechaNac.fill = GridBagConstraints.BOTH;
        gbc_TextFechaNac.insets = new Insets(0, 0, 5, 5);
        gbc_TextFechaNac.gridx = 2;
        gbc_TextFechaNac.gridy = 8;
        getContentPane().add(TextFechaNac, gbc_TextFechaNac);

        //Label Nacionalidad
        LabelNacionalidad = new JLabel("Nacionalidad: ");
        LabelNacionalidad.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelNacionalidad = new GridBagConstraints();
        gbc_LabelNacionalidad.fill = GridBagConstraints.BOTH;
        gbc_LabelNacionalidad.insets = new Insets(0, 0, 5, 5);
        gbc_LabelNacionalidad.gridx = 1;
        gbc_LabelNacionalidad.gridy = 9;
        getContentPane().add(LabelNacionalidad, gbc_LabelNacionalidad);
        LabelNacionalidad.setVisible(false);
        //text box nacionalidad
        TextNacionalidad = new JTextField();
        TextNacionalidad.setEditable(false);
        GridBagConstraints gbc_TextNacionalidad = new GridBagConstraints();
        gbc_TextNacionalidad.fill = GridBagConstraints.BOTH;
        gbc_TextNacionalidad.insets = new Insets(0, 0, 5, 5);
        gbc_TextNacionalidad.gridx = 2;
        gbc_TextNacionalidad.gridy = 9;
        getContentPane().add(TextNacionalidad, gbc_TextNacionalidad);
        TextNacionalidad.setVisible(false);
		        
        //Label salidas
        LabelSalidasInscripto = new JLabel("Salidas en las que esta inscripto: ");
	    LabelSalidasInscripto.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelSalidasInscripto = new GridBagConstraints();
        gbc_LabelSalidasInscripto.fill = GridBagConstraints.BOTH;
        gbc_LabelSalidasInscripto.insets = new Insets(0, 0, 5, 5);
        gbc_LabelSalidasInscripto.gridx = 1;
        gbc_LabelSalidasInscripto.gridy = 10;
        getContentPane().add(LabelSalidasInscripto, gbc_LabelSalidasInscripto);
        LabelSalidasInscripto.setVisible(false);
        //combo box salidas
        ComboBoxSalidasInscripto = new JComboBox<DTSalida>();
        GridBagConstraints gbc_ComboBoxSalidasInscripto = new GridBagConstraints();
        gbc_ComboBoxSalidasInscripto.gridwidth = 2;
        gbc_ComboBoxSalidasInscripto.fill = GridBagConstraints.BOTH;
        gbc_ComboBoxSalidasInscripto.insets = new Insets(0, 0, 5, 5);
        gbc_ComboBoxSalidasInscripto.gridx = 2;
        gbc_ComboBoxSalidasInscripto.gridy = 10;
        getContentPane().add(ComboBoxSalidasInscripto, gbc_ComboBoxSalidasInscripto);
        ComboBoxSalidasInscripto.setVisible(false);
		        
        //Label Descripcion
        LabelDescripcion = new JLabel("Descripcion: ");
        LabelDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelDescripcion = new GridBagConstraints();
        gbc_LabelDescripcion.fill = GridBagConstraints.BOTH;
        gbc_LabelDescripcion.insets = new Insets(0, 0, 5, 5);
        gbc_LabelDescripcion.gridx = 1;
        gbc_LabelDescripcion.gridy = 9; 
        getContentPane().add(LabelDescripcion, gbc_LabelDescripcion);
        LabelDescripcion.setVisible(false);
        //text box Descripcion
        TextDescripcion = new JTextArea();
        TextDescripcion.setWrapStyleWord(true);
        TextDescripcion.setLineWrap(true); 
        TextDescripcion.setEditable(false);
        GridBagConstraints gbc_TextDescripcion = new GridBagConstraints();
        gbc_TextDescripcion.gridwidth = 2;
        gbc_TextDescripcion.fill = GridBagConstraints.BOTH;
        gbc_TextDescripcion.insets = new Insets(0, 0, 5, 5);
        gbc_TextDescripcion.gridx = 2;
        gbc_TextDescripcion.gridy = 9;
        getContentPane().add(TextDescripcion, gbc_TextDescripcion);
        TextDescripcion.setVisible(false);
        
        //Label sitio web
        LabelSitioWeb = new JLabel("Link del sitio Web: ");
        LabelSitioWeb.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelSitioWeb = new GridBagConstraints();
        gbc_LabelSitioWeb.fill = GridBagConstraints.BOTH;
        gbc_LabelSitioWeb.insets = new Insets(0, 0, 5, 5);
        gbc_LabelSitioWeb.gridx = 1;
        gbc_LabelSitioWeb.gridy = 10; 
        getContentPane().add(LabelSitioWeb, gbc_LabelSitioWeb);
        LabelSitioWeb.setVisible(false);
        //text box sitio web
        TextSitioWeb = new JTextField();
        TextSitioWeb.setEditable(false);
        GridBagConstraints gbc_TextSitioWeb = new GridBagConstraints();
        gbc_TextSitioWeb.fill = GridBagConstraints.BOTH;
        gbc_TextSitioWeb.insets = new Insets(0, 0, 5, 5);
        gbc_TextSitioWeb.gridx = 2;
        gbc_TextSitioWeb.gridy = 10;
        gbc_TextSitioWeb.gridwidth = 2;
        getContentPane().add(TextSitioWeb, gbc_TextSitioWeb);
        TextSitioWeb.setVisible(false);
	       
        //Label actividades
        LabelActividadesProveedor = new JLabel("Actividades que provee: ");
        LabelActividadesProveedor.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelActividadesProveedor = new GridBagConstraints();
        gbc_LabelActividadesProveedor.fill = GridBagConstraints.BOTH;
        gbc_LabelActividadesProveedor.insets = new Insets(0, 0, 5, 5);
        gbc_LabelActividadesProveedor.gridx = 1;
        gbc_LabelActividadesProveedor.gridy = 11;
        getContentPane().add(LabelActividadesProveedor, gbc_LabelActividadesProveedor);
        LabelActividadesProveedor.setVisible(false);
        //combo box actividades
        ComboBoxActividadesProveedor = new JComboBox<DTActividad>();
        GridBagConstraints gbc_ComboBoxActividadesProveedor = new GridBagConstraints();
        gbc_ComboBoxActividadesProveedor.gridwidth = 2;
        gbc_ComboBoxActividadesProveedor.fill = GridBagConstraints.BOTH;
        gbc_ComboBoxActividadesProveedor.insets = new Insets(0, 0, 5, 5);
        gbc_ComboBoxActividadesProveedor.gridx = 2;
        gbc_ComboBoxActividadesProveedor.gridy = 11;
        getContentPane().add(ComboBoxActividadesProveedor, gbc_ComboBoxActividadesProveedor);
        ComboBoxActividadesProveedor.setVisible(false);
        
        DescripcionActividadProveedorLabel = new JLabel("Descripcion de la actividad: ");
        DescripcionActividadProveedorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 12;
        getContentPane().add(DescripcionActividadProveedorLabel, gbc_lblNewLabel);
        
        DescripcionActividadProveedorTextArea = new JTextArea();
        DescripcionActividadProveedorScrollPane = new JScrollPane(DescripcionActividadProveedorTextArea);
        DescripcionActividadProveedorTextArea.setWrapStyleWord(true);
        DescripcionActividadProveedorTextArea.setLineWrap(true); 
        DescripcionActividadProveedorTextArea.setEditable(false);
        GridBagConstraints gbc_textArea = new GridBagConstraints();
        gbc_textArea.gridwidth = 2;
        gbc_textArea.insets = new Insets(0, 0, 5, 5);
        gbc_textArea.fill = GridBagConstraints.BOTH;
        gbc_textArea.gridx = 2;
        gbc_textArea.gridy = 12;
        getContentPane().add(DescripcionActividadProveedorScrollPane, gbc_textArea);
        
        //Salidas de actividades del proveedor
        LabelSalidasDeActividadesDelProveedor = new JLabel("Salidas de la actividad: ");
        LabelSalidasDeActividadesDelProveedor.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelSalidasDeActividadesDelProveedor = new GridBagConstraints();
        gbc_LabelSalidasDeActividadesDelProveedor.fill = GridBagConstraints.BOTH;
        gbc_LabelSalidasDeActividadesDelProveedor.insets = new Insets(0, 0, 5, 5);
        gbc_LabelSalidasDeActividadesDelProveedor.gridx = 1;
        gbc_LabelSalidasDeActividadesDelProveedor.gridy = 13;
        getContentPane().add(LabelSalidasDeActividadesDelProveedor, gbc_LabelSalidasDeActividadesDelProveedor);
        //combo box de salidas de actividades del proveedor
        ComboBoxSalidasDeActividadesDelProveedor = new JComboBox<String>();
        GridBagConstraints gbc_ComboBoxSalidasDeActividadesDelProveedor = new GridBagConstraints();
        gbc_ComboBoxSalidasDeActividadesDelProveedor.gridwidth = 2;
        gbc_ComboBoxSalidasDeActividadesDelProveedor.fill = GridBagConstraints.BOTH;
        gbc_ComboBoxSalidasDeActividadesDelProveedor.insets = new Insets(0, 0, 5, 5);
        gbc_ComboBoxSalidasDeActividadesDelProveedor.gridx = 2;
        gbc_ComboBoxSalidasDeActividadesDelProveedor.gridy = 13;
        getContentPane().add(ComboBoxSalidasDeActividadesDelProveedor, gbc_ComboBoxSalidasDeActividadesDelProveedor);
        
        btnCerrar = new JButton("Cerrar");
        GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
        gbc_btnCerrar.insets = new Insets(0, 0, 5, 5);
        gbc_btnCerrar.gridx = 3;
        gbc_btnCerrar.gridy = 14;
        getContentPane().add(btnCerrar, gbc_btnCerrar);
        ComboBoxSalidasDeActividadesDelProveedor.setVisible(false);
        LabelSalidasDeActividadesDelProveedor.setVisible(false);
        
        //Eventos
        cargarEventos();
	}
	
	private void cargarEventos() {
        /*btnSelecUsuario.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		seleccionarUsuario();	
        	}
        });*/
        
        ComboBoxSelUsuario.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(seteandoDatosIniciales == true)
        			return;
        		limpiarCamposParaNuevoUsuario();
        		seleccionarUsuario();
        		
        	}
        });
        
        ComboBoxActividadesProveedor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(seteandoDatosIniciales) {
        			return;
        		}
        		limpiarComboBox(ComboBoxSalidasDeActividadesDelProveedor);
        		
        		DTActividad dtA = ComboBoxActividadesProveedor.getItemAt(ComboBoxActividadesProveedor.getSelectedIndex());
        		if (dtA.getNombre() != "No tiene actividades") {
            		Set<String> dtAS = dtA.getSalidas();
            		if(!dtAS.isEmpty()) {
                		dtAS.forEach((s)->{
        					seteandoDatosIniciales = true;
        					ComboBoxSalidasDeActividadesDelProveedor.addItem("Nombre: "+ s);
        					pasarDatosConsultaActividad();
        					seteandoDatosIniciales = false;
        				});
            		}else {
            			seteandoDatosIniciales = true;
    					ComboBoxSalidasDeActividadesDelProveedor.addItem("No tiene salidas");
    					seteandoDatosIniciales = false;
            		}

            		DescripcionActividadProveedorTextArea.setText(dtA.getDescripcion());
        		}else {
					seteandoDatosIniciales = true;
					ComboBoxSalidasDeActividadesDelProveedor.addItem("No tiene salidas");
					seteandoDatosIniciales = false;
        		}

        	}
        });
        
        ComboBoxSalidasInscripto.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(seteandoDatosIniciales) {
        			return;
        		}
        		pasarDatosConsultaSalidaTurista(e);

        	}
        });
        
        ComboBoxSalidasDeActividadesDelProveedor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(seteandoDatosIniciales) {
        			return;
        		}
        		pasarDatosConsultaSalidaProveedor(e);

        	}
        });
        
        btnCerrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		limpiarTodosCampos();
        		setVisible(false);
        	}
        });
	}
	
	public void iniciarVentana(ConsultaDeActividadTuristica consultaActividad, ConsultaSalida consultaSalida) {
		ventanaConsultaActividad = consultaActividad;
		ventanaConsultaSalida = consultaSalida;
		
		limpiarTodosCampos();
		Set<String> usuarios = ctrlUsuario.listarUsuarios();
		if(usuarios.isEmpty()) {
			seteandoDatosIniciales = true;
        	ComboBoxSelUsuario.addItem("No hay usuarios registrados");
        	seteandoDatosIniciales = false;
		}else {
	        usuarios.forEach((u)->{
	        	seteandoDatosIniciales = true;
	        	ComboBoxSelUsuario.addItem(u);
	        	seteandoDatosIniciales = false;
	        });
		}
        //Setea inicialmente las cosas de un usuario especifico en invisible
        visibleCamposTurista(false);
        visibleCamposProveedor(false);
        setVisible(true);
        
	}
	
	public void seleccionarUsuario() {
		dtU = ctrlUsuario.getInfoBasicaUsuario(ComboBoxSelUsuario.getSelectedItem().toString());
		TextNickname.setText(dtU.getNickname());
		TextEmail.setText(dtU.getEmail());
		TextNombre.setText(dtU.getNombre());
		TextApellido.setText(dtU.getApellido());
		TextFechaNac.setText(fechaStringFormato(dtU.getFechaNac(), false));
		if(dtU instanceof DTTurista) {
			TextTipoUsuario.setText("Turista");
			visibleCamposTurista(true);
			visibleCamposProveedor(false);
			
			DTTurista dtT = (DTTurista)dtU;
			TextNacionalidad.setText(dtT.getNacionalidad());
			Set<DTSalida> dtS = ctrlUsuario.listarInfoSalidasTurista(dtT.getNickname());
			if (!dtS.isEmpty()) {
				dtS.forEach((dt)->{
					seteandoDatosIniciales = true;
					ComboBoxSalidasInscripto.addItem(dt);
					seteandoDatosIniciales = false;
				});
				
			}else {
				seteandoDatosIniciales = true;
				DTSalida dt = new  DTSalida("No tiene salidas", null, null, 0, null, null, "");
				ComboBoxSalidasInscripto.addItem(dt);
				seteandoDatosIniciales = false;
				
			}

		}else {
			TextTipoUsuario.setText("Proveedor");
			visibleCamposTurista(false);
			visibleCamposProveedor(true);
			
			DTProveedor dtP = (DTProveedor)dtU;
			TextDescripcion.setText(dtP.getDescripcion());
			TextSitioWeb.setText(dtP.getLinkSitioWeb());
			Set<DTActividad> dtA = ctrlUsuario.listarInfoCompletaActividadesProveedor(dtP.getNickname());
			if(!dtA.isEmpty()) {
				dtA.forEach((dt)->{
					seteandoDatosIniciales = true;
					ComboBoxActividadesProveedor.addItem(dt);
					seteandoDatosIniciales = false;
				});
			}else {
				seteandoDatosIniciales = true;
				DTActividad noTiene = new DTActividad("No tiene actividades", "", "" , "", null, 0, 0, null, null, "", estadoActividad.agregada, null, "");
				ComboBoxActividadesProveedor.addItem(noTiene);
				seteandoDatosIniciales = false;
				seteandoDatosIniciales = true;
				ComboBoxSalidasDeActividadesDelProveedor.addItem("No tiene salidas");
				seteandoDatosIniciales = false;
			}

			
		}
	}
	
	@SuppressWarnings("static-access")
	private String fechaStringFormato(GregorianCalendar g, boolean conHora) {
		String dia = String.valueOf(g.get(g.DAY_OF_MONTH));
		String mes = String.valueOf(g.get(g.MONTH) + 1);
		String anio = String.valueOf(g.get(g.YEAR));
		String hora = String.valueOf(g.get(g.HOUR));
		String resultado = (conHora)?
				 dia + "/" + mes + "/" + anio + " " + hora + "hs": dia + "/" + mes + "/" + anio;
		return resultado;
	}
	
	private void limpiarComboBox(@SuppressWarnings("rawtypes") JComboBox b) {
		seteandoDatosIniciales = true;
		b.removeAllItems();
		seteandoDatosIniciales = false;
	};
	
	private void visibleCamposTurista(boolean b) {
		LabelNacionalidad.setVisible(b);
		TextNacionalidad.setVisible(b);
		LabelSalidasInscripto.setVisible(b);
		ComboBoxSalidasInscripto.setVisible(b);
		
		
	}
	
	private void visibleCamposProveedor(boolean b) {
		LabelDescripcion.setVisible(b);
		TextDescripcion.setVisible(b);
		LabelSitioWeb.setVisible(b);
		TextSitioWeb.setVisible(b);
		LabelActividadesProveedor.setVisible(b);
		ComboBoxActividadesProveedor.setVisible(b);
		LabelSalidasDeActividadesDelProveedor.setVisible(b);
		ComboBoxSalidasDeActividadesDelProveedor.setVisible(b);
		DescripcionActividadProveedorLabel.setVisible(b);
		DescripcionActividadProveedorTextArea.setVisible(b);
		DescripcionActividadProveedorScrollPane.setVisible(b);
	}
	
	private void limpiarCamposText() {
		seteandoDatosIniciales = true;
    	TextTipoUsuario.setText("");
    	TextNickname.setText("");
    	TextEmail.setText("");
    	TextNombre.setText("");
    	TextApellido.setText("");
    	TextFechaNac.setText("");
    	TextNacionalidad.setText("");
    	TextDescripcion.setText("");
    	TextSitioWeb.setText("");
    	DescripcionActividadProveedorTextArea.setText("");
    	seteandoDatosIniciales = false;
    }
	
	private void limpiarCamposCombobox() {
		seteandoDatosIniciales = true;
    	ComboBoxSelUsuario.removeAllItems();
    	ComboBoxSalidasInscripto.removeAllItems();
    	ComboBoxActividadesProveedor.removeAllItems();
    	ComboBoxSalidasDeActividadesDelProveedor.removeAllItems();
    	seteandoDatosIniciales = false;
	}
	
	private void limpiarTodosCampos() {
		limpiarCamposText();
		limpiarCamposCombobox();
		dtU = null;
	}
	
	private void limpiarCamposParaNuevoUsuario() {
		limpiarCamposText();
		//limpio combobox menos el de usuario
		seteandoDatosIniciales = true;
    	ComboBoxSalidasInscripto.removeAllItems();
    	ComboBoxActividadesProveedor.removeAllItems();
    	ComboBoxSalidasDeActividadesDelProveedor.removeAllItems();
    	seteandoDatosIniciales = false;
	}
	
	public void pasarDatosConsultaSalidaTurista(ActionEvent e){
		String nombreActividad = ComboBoxSalidasInscripto.getItemAt(ComboBoxSalidasInscripto.getSelectedIndex()).getNombreActividad();
		String nombreDepartamento = ComboBoxSalidasInscripto.getItemAt(ComboBoxSalidasInscripto.getSelectedIndex()).getNombreDepartamentoActividad();
		String nombreSalida = ComboBoxSalidasInscripto.getItemAt(ComboBoxSalidasInscripto.getSelectedIndex()).getNombre();
			
		ventanaConsultaSalida.datosQueVienenDesdeOtroCasoDeUso(nombreDepartamento, nombreActividad, nombreSalida);
		
	}
	
	public void pasarDatosConsultaSalidaProveedor(ActionEvent e) {
		String nombreActividad = ComboBoxActividadesProveedor.getItemAt(ComboBoxActividadesProveedor.getSelectedIndex()).getNombre();
		String nombreDepartamento = ComboBoxActividadesProveedor.getItemAt(ComboBoxActividadesProveedor.getSelectedIndex()).getDepartamento();
		String nombreSalida = (String) ComboBoxSalidasDeActividadesDelProveedor.getSelectedItem();
		nombreSalida = nombreSalida.substring(8);
		ventanaConsultaSalida.datosQueVienenDesdeOtroCasoDeUso(nombreDepartamento, nombreActividad, nombreSalida);

	}
	
	public void pasarDatosConsultaActividad() {
		if(ComboBoxActividadesProveedor.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(this,
					"No hay actividad para mostrar", "No hay actividad", JOptionPane.ERROR_MESSAGE);
		}else {
			String nombreDepartamento = ComboBoxActividadesProveedor.getItemAt(ComboBoxActividadesProveedor.getSelectedIndex()).getDepartamento();
			String nombreActividad =ComboBoxActividadesProveedor.getItemAt(ComboBoxActividadesProveedor.getSelectedIndex()).getNombre(); 
			ventanaConsultaActividad.datosQueVienenDesdeConsultaDeUsuario(nombreDepartamento ,nombreActividad);
		}
	}
	
}
