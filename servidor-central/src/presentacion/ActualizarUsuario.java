package presentacion;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import datatypes.DTProveedor;
import datatypes.DTTurista;
import datatypes.DTUsuario;
import logica.interfaces.ICtrlUsuario;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.Set;

@SuppressWarnings("serial")
public class ActualizarUsuario extends JInternalFrame {
	
	//Controlador
	private ICtrlUsuario ctrlUsuario;
	//Basicos
	private JLabel LabelSelcUsuario;
	private JComboBox<String> ComboBoxSelUsuario;
	//NO MODIFICABLES
	private JLabel LabelInfoUsuario;
	private JLabel LabelTipoUsuario;
	private JTextField TextTipoUsuario;
	private JLabel LabelNickname;
	private JTextField TextNickname;
	//DATOS MODIFICABLES
	private JLabel LabelDatosModificables;
	private JLabel LabelNombre;
	private JTextField TextNombre;
	private JLabel LabelApellido;
	private JTextField TextApellido;
	private JLabel LabelFechaNac;
	private JButton btnCalendario;
	//fecha ancimiento
	private JTextField textFieldCalendario;
	private JInternalFrame f; //se muestra el calendario
	private JTextField date;
	//Turista
	private JLabel LabelNacionalidad;
	private JTextField TextNacionalidad;
	//Proveedor
	private JLabel LabelDescripcionProveedor;
	private JScrollPane ScrollPaneDescripcionProveedor;
	private JTextArea TextAreaDescripcion;
	private JLabel LabelSitioWeb;
	private JTextField TextSitioWeb;
	//Datos que interesa conservar temporalmente
	private String newNombre;
	private String newApellido;
	private GregorianCalendar fechaNac; //guardo la fecha que luego uso
	private String newNacionalidad;
	private String newSitioWeb;
	private String newDescripcion;
	private DTUsuario dtU;
	//Botones
	private JButton btnModificarDatos;
	private JButton btnCancelar;
	//Modificacion de datos de combo box
	
	private Boolean limpiandoCombo;

	

	
	public ActualizarUsuario(ICtrlUsuario iCU) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		//meto la interfaz y la ventana de actividada
		this.ctrlUsuario = iCU;
		
		//Cuestiones de configuracion del frame
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Modificar datos de Usuario");
				
		setBounds(30, 30, 567, 454);
				
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = new int[] { 41, 147, 110, 54, 14, 93, 104, 43 };
		gbl.rowHeights = new int[] { 0, 0, 30, 30, 30, 30, 30, 30, 30, 35, 35, 30, -27, 36, 0, 0 };
		gbl.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
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
        gbc_cBSelcUsuario.gridwidth = 4;
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
        gbc_LabelInfoUsuario.gridx = 0;
        gbc_LabelInfoUsuario.gridy = 2;
        gbc_LabelInfoUsuario.gridwidth = 8;
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
        gbc_TextTipoUsuario.gridwidth = 5;
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
        gbc_TextNickname.gridwidth = 5;
        gbc_TextNickname.fill = GridBagConstraints.BOTH;
        gbc_TextNickname.insets = new Insets(0, 0, 5, 5);
        gbc_TextNickname.gridx = 2;
        gbc_TextNickname.gridy = 4;
        getContentPane().add(TextNickname, gbc_TextNickname);
        
        LabelDatosModificables = new JLabel("Datos modificables");
        GridBagConstraints gbc_LabelDatosModificables = new GridBagConstraints();
        gbc_LabelDatosModificables.gridwidth = 8;
        gbc_LabelDatosModificables.insets = new Insets(0, 0, 5, 0);
        gbc_LabelDatosModificables.gridx = 0;
        gbc_LabelDatosModificables.gridy = 5;
        getContentPane().add(LabelDatosModificables, gbc_LabelDatosModificables);
		        
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
        TextNombre.setEditable(true);
        GridBagConstraints gbc_TextNombre = new GridBagConstraints();
        gbc_TextNombre.gridwidth = 5;
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
        TextApellido.setEditable(true);
        GridBagConstraints gbc_TextApellido = new GridBagConstraints();
        gbc_TextApellido.gridwidth = 5;
        gbc_TextApellido.fill = GridBagConstraints.BOTH;
        gbc_TextApellido.insets = new Insets(0, 0, 5, 5);
        gbc_TextApellido.gridx = 2;
        gbc_TextApellido.gridy = 7;
        getContentPane().add(TextApellido, gbc_TextApellido);
		        
        //Label FechaNac
        LabelFechaNac = new JLabel("Fecha de nacimiento: ");
        LabelFechaNac.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelFechaNac = new GridBagConstraints();
        gbc_LabelFechaNac.anchor = GridBagConstraints.EAST;
        gbc_LabelFechaNac.fill = GridBagConstraints.VERTICAL;
        gbc_LabelFechaNac.insets = new Insets(0, 0, 5, 5);
        gbc_LabelFechaNac.gridx = 1;
        gbc_LabelFechaNac.gridy = 8;
        getContentPane().add(LabelFechaNac, gbc_LabelFechaNac);
        
        btnCalendario = new JButton("...");
        String icon_path = "src/icons/calendario.png";
        ImageIcon icon = new ImageIcon(icon_path,"calendario");
        Image img = icon.getImage();
    	Image scaled_img = img.getScaledInstance( 15, 15,  java.awt.Image.SCALE_SMOOTH ) ;  
    	btnCalendario.setIcon(new ImageIcon(scaled_img));
    	btnCalendario.setEnabled(true);
        GridBagConstraints gbc_btnCalendario = new GridBagConstraints();
        gbc_btnCalendario.insets = new Insets(0, 0, 5, 5);
        gbc_btnCalendario.gridx = 2;
        gbc_btnCalendario.gridy = 8;
        getContentPane().add(btnCalendario, gbc_btnCalendario);
        
        textFieldCalendario = new JTextField();
        GridBagConstraints gbc_textFieldCalendario = new GridBagConstraints();
        textFieldCalendario.setEditable(false);
        gbc_textFieldCalendario.gridwidth = 6;
        gbc_textFieldCalendario.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldCalendario.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldCalendario.gridx = 4;
        gbc_textFieldCalendario.gridy = 8;
        getContentPane().add(textFieldCalendario, gbc_textFieldCalendario);
        textFieldCalendario.setColumns(10);
        
        LabelNacionalidad = new JLabel("Nacionalidad: ");
        LabelNacionalidad.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelNacionalidad = new GridBagConstraints();
        gbc_LabelNacionalidad.fill = GridBagConstraints.BOTH;
        gbc_LabelNacionalidad.insets = new Insets(0, 0, 5, 5);
        gbc_LabelNacionalidad.gridx = 1;
        gbc_LabelNacionalidad.gridy = 9; 
        getContentPane().add(LabelNacionalidad, gbc_LabelNacionalidad);
        //text box nacionalidad
        TextNacionalidad = new JTextField();
        TextNacionalidad.setEditable(true);
        GridBagConstraints gbc_TextNacionalidad = new GridBagConstraints();
        gbc_TextNacionalidad.fill = GridBagConstraints.BOTH;
        gbc_TextNacionalidad.insets = new Insets(0, 0, 5, 5);
        gbc_TextNacionalidad.gridx = 2;
        gbc_TextNacionalidad.gridy = 9;
        gbc_TextNacionalidad.gridwidth = 5;
        getContentPane().add(TextNacionalidad, gbc_TextNacionalidad);
        
        //Label sitio web
        LabelSitioWeb = new JLabel("Link del sitio Web: ");
        LabelSitioWeb.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelSitioWeb = new GridBagConstraints();
        gbc_LabelSitioWeb.fill = GridBagConstraints.BOTH;
        gbc_LabelSitioWeb.insets = new Insets(0, 0, 5, 5);
        gbc_LabelSitioWeb.gridx = 1;
        gbc_LabelSitioWeb.gridy = 9; 
        getContentPane().add(LabelSitioWeb, gbc_LabelSitioWeb);

        //text box sitio web
        TextSitioWeb = new JTextField();
        TextSitioWeb.setEditable(true);
        GridBagConstraints gbc_TextSitioWeb = new GridBagConstraints();
        gbc_TextSitioWeb.gridwidth = 5;
        gbc_TextSitioWeb.fill = GridBagConstraints.BOTH;
        gbc_TextSitioWeb.insets = new Insets(0, 0, 5, 5);
        gbc_TextSitioWeb.gridx = 2;
        gbc_TextSitioWeb.gridy = 9;
        getContentPane().add(TextSitioWeb, gbc_TextSitioWeb);
        
        LabelDescripcionProveedor = new JLabel("Descripción: ");
        GridBagConstraints gbc_LabelDescripcionProveedor = new GridBagConstraints();
        gbc_LabelDescripcionProveedor.anchor = GridBagConstraints.EAST;
        gbc_LabelDescripcionProveedor.insets = new Insets(0, 0, 5, 5);
        gbc_LabelDescripcionProveedor.gridx = 1;
        gbc_LabelDescripcionProveedor.gridy = 10;
        getContentPane().add(LabelDescripcionProveedor, gbc_LabelDescripcionProveedor);
        
        TextAreaDescripcion = new JTextArea();
        ScrollPaneDescripcionProveedor = new JScrollPane(TextAreaDescripcion);
        TextAreaDescripcion.setWrapStyleWord(true);
        TextAreaDescripcion.setLineWrap(true); 
        TextAreaDescripcion.setEditable(true);
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.gridwidth = 5;
        gbc_scrollPane.gridheight = 2;
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane.gridx = 2;
        gbc_scrollPane.gridy = 10;
        getContentPane().add(ScrollPaneDescripcionProveedor, gbc_scrollPane);
        
        btnModificarDatos = new JButton("Modificar");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.gridwidth = 2;
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton.gridx = 2;
        gbc_btnNewButton.gridy = 13;
        getContentPane().add(btnModificarDatos, gbc_btnNewButton);
        
        btnCancelar = new JButton("Cancelar");
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.gridwidth = 2;
        gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton_1.gridx = 5;
        gbc_btnNewButton_1.gridy = 13;
        getContentPane().add(btnCancelar, gbc_btnNewButton_1);
        
        //maneja el calendario con iconito
		date = new JTextField(20);
		f = new JInternalFrame();
		f.setVisible(false);
        
		    limpiandoCombo = false;
        cargarEventos();
	}
	
	private void cargarEventos() {
		
        ComboBoxSelUsuario.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		limpiarCamposTexto();
        		btnModificarDatos.setEnabled(false);
        		if (!limpiandoCombo && ComboBoxSelUsuario.getSelectedIndex() != 0) {
        		  seleccionarUsuario();         		  
        		}
        	}
        });
		
		btnModificarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarDatosUsuario();
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		
		btnCalendario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					setVisible(true);
					date.setText(new DatePicker(f).setPickedDate());
					// string en formato dd-mm-yyyy
					if(!date.getText().isEmpty()) {
						textFieldCalendario.setText(date.getText());
						int dia = Integer.parseInt(date.getText().substring(0,2));
						int mes = Integer.parseInt(date.getText().substring(3,5));
						int anio = Integer.parseInt(date.getText().substring(6,10));
						fechaNac = new GregorianCalendar(anio, mes-1, dia);
					}
				}
			});
			
	};
	
	public void iniciarVentana() {
	  limpiandoCombo = true;
		limpiarComboBoxeUsuario();
		limpiandoCombo = false;
		limpiarCamposTexto();
		btnModificarDatos.setEnabled(false);
		Set<String> usuarios = ctrlUsuario.listarUsuarios();
		if(usuarios.isEmpty()) {
        	ComboBoxSelUsuario.addItem("No hay usuarios registrados");
		}else {
		      ComboBoxSelUsuario.addItem("Seleccione un Usuario");
	        usuarios.forEach((u)->{
	        	ComboBoxSelUsuario.addItem(u);
	        });
		}
		visibleCamposTurista(false);
		visibleCamposProveedor(false);
		setVisible(true);
	}
	
	public void seleccionarUsuario() {
		btnModificarDatos.setEnabled(true);
		dtU = ctrlUsuario.getInfoBasicaUsuario(ComboBoxSelUsuario.getSelectedItem().toString());
		newNombre = dtU.getNombre();
		newApellido = dtU.getApellido();
		fechaNac = dtU.getFechaNac();
		
		TextNickname.setText(dtU.getNickname());
		TextNombre.setText(dtU.getNombre());
		TextApellido.setText(dtU.getApellido());
		textFieldCalendario.setText(fechaStringFormato(dtU.getFechaNac(), false));
		
		
		if(dtU instanceof DTTurista) {
			TextTipoUsuario.setText("Turista");
			visibleCamposTurista(true);
			visibleCamposProveedor(false);
			DTTurista dtT = (DTTurista)dtU;
			TextNacionalidad.setText(dtT.getNacionalidad());
			newNacionalidad = dtT.getNacionalidad();

		}else {
			TextTipoUsuario.setText("Proveedor");
			visibleCamposTurista(false);
			visibleCamposProveedor(true);
			DTProveedor dtP = (DTProveedor)dtU;
			TextSitioWeb.setText(dtP.getLinkSitioWeb());
			TextAreaDescripcion.setText(dtP.getDescripcion());
			newSitioWeb = dtP.getLinkSitioWeb();
			newDescripcion = dtP.getDescripcion();
		
		}
	}
	
	public void modificarDatosUsuario(){
		if(ComboBoxSelUsuario.getSelectedItem() == "No hay usuarios registrados") {
			JOptionPane.showMessageDialog(this,
					"No hay usuarios registrados", "No hay usuarios", JOptionPane.ERROR_MESSAGE);
			return;
		};
		newNombre = TextNombre.getText();
		newApellido = TextApellido.getText();
		if(newNombre.isEmpty() || newApellido.isEmpty() || fechaNac == null) {
			JOptionPane.showMessageDialog(this,
					"Los campos nombre, apellido y fecha de nacimiento no puede estar vacio", "Hay campos vacios", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(TextTipoUsuario.getText().equals("Turista")) {
			newNacionalidad = TextNacionalidad.getText();
			if(newNacionalidad.isEmpty()) {
				JOptionPane.showMessageDialog(this,
						"El campo nacionalidad no puede ser vacio", "Hay campos vacios", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		}else {
			newDescripcion = TextAreaDescripcion.getText();
			newSitioWeb = TextSitioWeb.getText();
			if(newDescripcion.isEmpty()) {
				JOptionPane.showMessageDialog(this,
						"El campo descripcion no puede ser vacio", "Hay campos vacios", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		ctrlUsuario.actualizarUsuario(dtU.getNickname(), newNombre, newApellido, fechaNac, "",newNacionalidad, newDescripcion, newSitioWeb);
		JOptionPane.showMessageDialog(this,
				"Usuario actualizado con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
		cancelar();
	}
	
	public void cancelar() {
	  limpiandoCombo = true;
		limpiarComboBoxeUsuario();
    limpiandoCombo = false;
		limpiarCamposTexto();
		setVisible(false);
	}
	
	public void limpiarComboBoxeUsuario(){
	  if (limpiandoCombo) {
	    ComboBoxSelUsuario.removeAllItems();	    
	  }
	}
	
	public void limpiarCamposTexto() {
    	TextTipoUsuario.setText("");
    	TextNickname.setText("");
    	TextNombre.setText("");
    	TextApellido.setText("");
    	textFieldCalendario.setText("");
    	TextNacionalidad.setText("");
    	TextAreaDescripcion.setText("");
    	TextSitioWeb.setText("");
    	
    	newNombre = null;
    	newApellido = null;
    	fechaNac = null;
    	newNacionalidad = null;
    	newDescripcion = null;
    	newSitioWeb = null;
	}
	
	@SuppressWarnings("static-access")
	private String fechaStringFormato(GregorianCalendar g, boolean conHora) {
		String dia = String.valueOf(g.get(g.DAY_OF_MONTH));
		String mes = String.valueOf(g.get(g.MONTH) + 1);
		String anio = String.valueOf(g.get(g.YEAR));
		String hora = String.valueOf(g.get(g.HOUR));
		String resultado = (conHora)?
				 dia + "-" + mes + "-" + anio + " " + hora + "hs": dia + "-" + mes + "-" + anio;
		return resultado;
	}
	
	private void visibleCamposTurista(boolean b){
		LabelNacionalidad.setVisible(b);
		TextNacionalidad.setVisible(b);
	}
	
	private void visibleCamposProveedor(boolean b) {
		LabelDescripcionProveedor.setVisible(b);
		TextAreaDescripcion.setVisible(b);
		LabelSitioWeb.setVisible(b);
		TextSitioWeb.setVisible(b);
		ScrollPaneDescripcionProveedor.setVisible(b);
	}
	

}
