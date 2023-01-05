package presentacion;

import logica.clases.ActividadTuristica;
import logica.clases.Proveedor;
import logica.clases.dao.ActividadDao;
import logica.clases.dao.ProveedorDao;
import logica.clases.dao.SalidaDao;
import logica.clases.dao.InscripcionDao;
import logica.handlers.HandlerActividades;
import logica.handlers.HandlerUsuarios;
import logica.interfaces.Fabrica;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import datatypes.estadoActividad;
import datosdeprueba.CargarDatosDePrueba;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import webservices.WebServices;

//import logica.*;
//import presentacion.*;
import javax.swing.JMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

//import logica.controladores.*;
import logica.interfaces.ICtrlActividad;
import logica.interfaces.ICtrlUsuario;
//import javax.swing.JLabel;
//import java.awt.GridBagConstraints;
//import java.awt.Insets;
//import javax.swing.JTextField;

public class Principal {
	
	// Frame principal
	private JFrame frmGestionDeTurismoUy;
	// interfaces
	private ICtrlUsuario ICU;
	private ICtrlActividad ICA;
	// frame altas
	private altaUsuario altaUsuario;
	private altaCategoria altaCategoria;
	private altaSalida altaSalida;
	private altaActividadTuristica crearActividadTuristica;
	private InscripcionSalidaTuristica creInscrInternalFrame;
	// modificar usuario
	private ActualizarUsuario actualizarUsuario;
	// frame consultas
	private ConsultaDeUsuario consultaDeUsuario;
	private ConsultaDeActividadTuristica consultaActividadInternalFrame;
	private ConsultaSalida consultaDeSalida;
	private CrearPaquete crearPaquete;
	private AgregarActividadAPaquete agregarActividadPaquete;
	private ConsultaPaquete consultarPaquete;
	private aceptarRechazarActividad aceptarRechazarActividad;
	private ListarTop10 listarTop10;
	
	private WebServices webService = new WebServices();

	private boolean yaSeCargaronLosDatosDePrueba;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Principal window = new Principal();
				window.frmGestionDeTurismoUy.setVisible(true);

			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();

		Fabrica fabrica = Fabrica.getInstance();
		ICU = fabrica.getICtrlUsuario();
		ICA = fabrica.getICtrlActividad();

		yaSeCargaronLosDatosDePrueba = false;

		frmGestionDeTurismoUy.getContentPane().setLayout(null);

		aceptarRechazarActividad = new aceptarRechazarActividad(ICA);
		aceptarRechazarActividad.setBounds(30, 30, 597, 452);
		aceptarRechazarActividad.setVisible(false);
		frmGestionDeTurismoUy.getContentPane().setLayout(null);
		frmGestionDeTurismoUy.getContentPane().add(aceptarRechazarActividad);

		altaUsuario = new altaUsuario(ICU);
		altaUsuario.setBounds(30, 30, 597, 452);
		altaUsuario.setVisible(false);
		frmGestionDeTurismoUy.getContentPane().setLayout(null);
		frmGestionDeTurismoUy.getContentPane().add(altaUsuario);

		altaSalida = new altaSalida(ICA);
		altaSalida.setBounds(30, 30, 515, 431);
		altaSalida.setVisible(false);
		frmGestionDeTurismoUy.getContentPane().add(altaSalida);

		altaCategoria = new altaCategoria(ICA);
		altaCategoria.setBounds(30, 30, 425, 174);
		altaCategoria.setVisible(false);
		frmGestionDeTurismoUy.getContentPane().add(altaCategoria);

		consultaDeSalida = new ConsultaSalida(ICA);
		consultaDeSalida.setVisible(false);
		frmGestionDeTurismoUy.getContentPane().add(consultaDeSalida);

		consultaDeUsuario = new ConsultaDeUsuario(ICU);
		consultaDeUsuario.setBounds(30, 30, 654, 528);
		consultaDeUsuario.setVisible(false);
		frmGestionDeTurismoUy.getContentPane().add(consultaDeUsuario);

		creInscrInternalFrame = new InscripcionSalidaTuristica(ICA, ICU);
		creInscrInternalFrame.setBounds(30, 30, 345, 364);
		creInscrInternalFrame.setVisible(false);
		frmGestionDeTurismoUy.getContentPane().add(creInscrInternalFrame);

		crearActividadTuristica = new altaActividadTuristica(ICA, ICU);
		crearActividadTuristica.setBounds(45, 71, 480, 445);
		crearActividadTuristica.setVisible(false);
		frmGestionDeTurismoUy.getContentPane().add(crearActividadTuristica);

		consultaActividadInternalFrame = new ConsultaDeActividadTuristica(ICA);
		consultaActividadInternalFrame.setSize(510, 462);
		consultaActividadInternalFrame.setLocation(87, 30);
		consultaActividadInternalFrame.setVisible(false);
		frmGestionDeTurismoUy.getContentPane().add(consultaActividadInternalFrame);

		crearPaquete = new CrearPaquete(ICA);
		crearPaquete.setBounds(30, 30, 475, 381);
		crearPaquete.setVisible(false);
		frmGestionDeTurismoUy.getContentPane().add(crearPaquete);

		agregarActividadPaquete = new AgregarActividadAPaquete(ICA);
		agregarActividadPaquete.setBounds(100, 100, 401, 300);
		agregarActividadPaquete.setVisible(false);
		frmGestionDeTurismoUy.getContentPane().add(agregarActividadPaquete);

		consultarPaquete = new ConsultaPaquete(ICA);
		consultarPaquete.setBounds(22, 29, 503, 365);
		consultarPaquete.setVisible(false);
		frmGestionDeTurismoUy.getContentPane().add(consultarPaquete);

		actualizarUsuario = new ActualizarUsuario(ICU);
		actualizarUsuario.setVisible(false);
		frmGestionDeTurismoUy.getContentPane().add(actualizarUsuario);
		
		listarTop10 = new ListarTop10(ICA);
		listarTop10.setBounds(68, 11, 490, 251);
		listarTop10.setVisible(false);
		frmGestionDeTurismoUy.getContentPane().add(listarTop10);

		// Esto tiene que ir al final de todo
		consultaActividadInternalFrame.cargarVentanasConsulta(consultaDeSalida, consultarPaquete);
		consultarPaquete.cargarConsultaActividadFrame(consultaActividadInternalFrame);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// Se crea el Frame con las dimensiones indicadas.
		frmGestionDeTurismoUy = new JFrame();
		frmGestionDeTurismoUy.setTitle("Turismo.uy");
		frmGestionDeTurismoUy.setResizable(true);
		frmGestionDeTurismoUy.setBounds(100, 100, 697, 700);
		frmGestionDeTurismoUy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Se crea una barra de menú (JMenuBar) con dos menú (JMenu) desplegables.
		// Cada menú contiene diferentes opciones (JMenuItem), los cuales tienen un
		// evento asociado que permite realizar una acción una vez se seleccionan.
		JMenuBar menuBar = new JMenuBar();
		frmGestionDeTurismoUy.setJMenuBar(menuBar);

		// -----------MENU SISTEMA-----------

		JMenu menuSistema = new JMenu("Sistema");
		menuBar.add(menuSistema);

		JMenuItem menuSalir = new JMenuItem("Salir");
		menuSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Salgo de la aplicación
				frmGestionDeTurismoUy.setVisible(false);
				frmGestionDeTurismoUy.dispose();
			}
		});
		menuSistema.add(menuSalir);

		JMenuItem menuCargarDatos = new JMenuItem("Cargar Datos");
		menuCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!yaSeCargaronLosDatosDePrueba) {
					CargarDatosDePrueba cdp = new CargarDatosDePrueba();
					cdp.cargarDatos(ICU, ICA);
					yaSeCargaronLosDatosDePrueba = true;
				}
			}
		});
		menuSistema.add(menuCargarDatos);
		
    JMenuItem publicar = new JMenuItem("Publicar WS");
    publicar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        webService.publicar();
      }
    });
    menuSistema.add(publicar);
    
    JMenuItem despublicar = new JMenuItem("Despublicar WS");
    despublicar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        webService.despublicar();
      }
    });
    menuSistema.add(despublicar);


		// -----------MENU USUARIO-----------

		JMenu menuUsuarios = new JMenu("Usuarios");
		menuBar.add(menuUsuarios);

		JMenuItem menuItemRegistrar = new JMenuItem("Alta de Usuario");
		menuItemRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuario.setVisible(true);
			}
		});
		menuUsuarios.add(menuItemRegistrar);

		JMenuItem menuItemConsultaUsuario = new JMenuItem("Consulta de Usuario");
		menuItemConsultaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaDeUsuario.iniciarVentana(consultaActividadInternalFrame, consultaDeSalida);
			};
		});
		menuUsuarios.add(menuItemConsultaUsuario);

		JMenuItem menuItemActualizarUsuario = new JMenuItem("Modificar datos de Usuario");
		menuItemActualizarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarUsuario.iniciarVentana();

			};
		});
		menuUsuarios.add(menuItemActualizarUsuario);

		// -----------MENU ACTIVIDADES-----------

		JMenu menuActividades = new JMenu("Actividades");
		menuBar.add(menuActividades);

		JMenuItem menuItemAltaCategoria = new JMenuItem("Alta de Categoria");
		menuItemAltaCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaCategoria.setVisible(true);
			};
		});
		menuActividades.add(menuItemAltaCategoria);

		JMenuItem menuItemAltaActividadTuristica = new JMenuItem("Alta de Actividad Turistica");
		menuItemAltaActividadTuristica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearActividadTuristica.cargarDatos();
				crearActividadTuristica.setVisible(true);
			};
		});
		menuActividades.add(menuItemAltaActividadTuristica);
		
		JMenuItem menuItemAceptarRechazarActividad = new JMenuItem("Aceptar o Rechazar Actividad Turistica");
		menuItemAceptarRechazarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptarRechazarActividad.cargarDatos();
				aceptarRechazarActividad.setVisible(true);
			};
		});
		menuActividades.add(menuItemAceptarRechazarActividad);
		
		JMenuItem menuItemConsultaActividadTuristica = new JMenuItem("Consulta de Actividad Turistica");
		menuItemConsultaActividadTuristica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Muestro el InternalFrame para consulta una actividad
				consultaActividadInternalFrame.limpiarFormulario();
				consultaActividadInternalFrame.cargarDepartamentos();
				consultaActividadInternalFrame.setVisible(true);

			}
		});
		menuActividades.add(menuItemConsultaActividadTuristica);

		JMenuItem menuItemListarTop10 = new JMenuItem("Listar Top 10 visitadas");
		menuItemListarTop10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarTop10.cargarInformacion();
				listarTop10.setVisible(true);
			}
		});
		menuActividades.add(menuItemListarTop10);
		
		// -----------MENU SALIDAS-----------
		JMenu menuSalidas = new JMenu("Salidas");
		menuBar.add(menuSalidas);
		
		JMenuItem menuItemRegistrarSalida = new JMenuItem("Alta de Salida Turistica");
		menuItemRegistrarSalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaSalida.cargarDatos();
				altaSalida.setVisible(true);
			}
		});
		menuSalidas.add(menuItemRegistrarSalida);
		
		JMenuItem menuItemConsultaSalida = new JMenuItem("Consulta de Salida Turistica");
		menuItemConsultaSalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaDeSalida.cargarDatos();
				consultaDeSalida.setVisible(true);
			};
		});
		menuSalidas.add(menuItemConsultaSalida);
		
		JMenuItem menuItemIngresarInscripcion = new JMenuItem("Alta de Inscripcion a Salida Turistica");
		menuItemIngresarInscripcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Muestro el InternalFrame para ingresar inscripcion
				creInscrInternalFrame.limpiarFormulario();
				creInscrInternalFrame.cargarDepartamentos();
				creInscrInternalFrame.cargarTuristas();
				creInscrInternalFrame.setVisible(true);
			}
		});
		menuSalidas.add(menuItemIngresarInscripcion);
		
		// -----------MENU PAQUETES-----------
		
		JMenu menuPaquetes = new JMenu("Paquetes");
		menuBar.add(menuPaquetes);
		
		JMenuItem menuItemCrearPaquete = new JMenuItem("Alta de Paquete de Actividades Turisticas");
		menuItemCrearPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Muestro el InternalFrame para crear paquete
				crearPaquete.limpiarFormulario();
				crearPaquete.setVisible(true);
			}
		});
		menuPaquetes.add(menuItemCrearPaquete);
		
		JMenuItem menuItemConsultarPaquete = new JMenuItem("Consulta de Paquete de Actividades Turisticas");
		menuItemConsultarPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarPaquete.cargarDatosIniciales();
				consultarPaquete.setVisible(true);
			}
		});
		menuPaquetes.add(menuItemConsultarPaquete);

		JMenuItem menuItemAgregarActividadAPaquete = new JMenuItem("Agregar Actividad a Paquete");
		menuItemAgregarActividadAPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Muestro el InternalFrame para agregar actividad a paquete
				agregarActividadPaquete.limpiarFormulario();
				agregarActividadPaquete.cargarPaquetes();
				agregarActividadPaquete.cargarDepartamentos();
				agregarActividadPaquete.setVisible(true);
			}
		});
		menuPaquetes.add(menuItemAgregarActividadAPaquete);
	}
}
