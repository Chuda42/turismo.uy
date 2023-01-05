package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import logica.interfaces.ICtrlActividad;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import datatypes.DTActividad;
import datatypes.estadoActividad;

@SuppressWarnings("serial")
public class ConsultaDeActividadTuristica extends JInternalFrame {
  // Interfaces
  private ICtrlActividad controlAct;
  // Componentes graficos
  private JComboBox<String> comboBoxDepartamentos;
  private JComboBox<String> comboBoxActividades;
  private JComboBox<String> comboBoxSalidas;
  private JComboBox<String> comboBoxPaquetes;
  private JComboBox<String> comboBoxCategorias;
  private JLabel lblDepartamentos;
  private JLabel lblActividades;
  private JLabel lblSalidas;
  private JLabel lblNombre;
  private JLabel lblDescr;
  private JLabel lblDuracion;
  private JLabel lblCosto;
  private JLabel lblPaquetes;
  private JLabel lblCategorias;
  private JTextField textFieldNombre;
  private JTextArea textAreaDescr;
  private JScrollPane textAreaDescrScrollPane;
  private JTextField textFieldDuracion;
  private JTextField textFieldCosto;
  private JButton btnCerrar;
  private ConsultaPaquete consultaPaquete;
  private ConsultaSalida consultaSalida;

  private boolean borrandoFormularios = false;
  private JTextField textFieldEstado;

  public ConsultaDeActividadTuristica(ICtrlActividad ica) {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    setMaximizable(true);
    controlAct = ica;
    setResizable(true);
    setIconifiable(true);

    setClosable(true);
    setTitle("Consulta de Actividad Turistica");

    setBounds(100, 100, 517, 430);

    lblDepartamentos = new JLabel("Departamento:");
    lblDepartamentos.setHorizontalAlignment(SwingConstants.RIGHT);
    lblActividades = new JLabel("Actividad:");
    lblActividades.setHorizontalAlignment(SwingConstants.RIGHT);
    lblSalidas = new JLabel("Salidas:");
    lblSalidas.setHorizontalAlignment(SwingConstants.RIGHT);
    lblNombre = new JLabel("Nombre:");
    lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
    lblDescr = new JLabel("Descripcion:");
    lblDescr.setHorizontalAlignment(SwingConstants.RIGHT);
    lblDuracion = new JLabel("Duracion(hs):");
    lblDuracion.setHorizontalAlignment(SwingConstants.RIGHT);
    lblCosto = new JLabel("Costo:");
    lblCosto.setHorizontalAlignment(SwingConstants.RIGHT);
    lblPaquetes = new JLabel("Paquetes:");
    lblPaquetes.setHorizontalAlignment(SwingConstants.RIGHT);
    lblCategorias = new JLabel("Categorias:");

    comboBoxDepartamentos = new JComboBox<String>();
    comboBoxDepartamentos.setEnabled(true);
    comboBoxDepartamentos.setToolTipText("Seleccione un departamento");
    comboBoxActividades = new JComboBox<String>();
    comboBoxActividades.setEnabled(false);
    comboBoxActividades.setToolTipText("Seleccione una actividad");
    comboBoxSalidas = new JComboBox<String>();
    comboBoxSalidas.setEnabled(false);
    comboBoxSalidas.setToolTipText("Seleccione una salida");
    comboBoxPaquetes = new JComboBox<String>();
    comboBoxPaquetes.setEnabled(false);
    comboBoxPaquetes.setToolTipText("Seleccione un paquete");
    comboBoxCategorias = new JComboBox<String>();
    comboBoxCategorias.setEnabled(false);
    comboBoxCategorias.setToolTipText("Listado de categorias de la actividad");

    textFieldNombre = new JTextField();
    textFieldNombre.setEnabled(false);
    textFieldNombre.setBackground(Color.LIGHT_GRAY);
    textFieldNombre.setDisabledTextColor(Color.black);
    textAreaDescr = new JTextArea();
    textAreaDescr.setEnabled(false);
    textAreaDescr.setDisabledTextColor(Color.black);
    textAreaDescr.setBackground(Color.LIGHT_GRAY);
    textFieldDuracion = new JTextField();
    textFieldDuracion.setEnabled(false);
    textFieldDuracion.setDisabledTextColor(Color.black);
    textFieldDuracion.setBackground(Color.LIGHT_GRAY);
    textFieldCosto = new JTextField();
    textFieldCosto.setEnabled(false);
    textFieldCosto.setDisabledTextColor(Color.black);
    textFieldCosto.setBackground(Color.LIGHT_GRAY);

    textAreaDescrScrollPane = new JScrollPane(textAreaDescr);

    textAreaDescr.setWrapStyleWord(true);
    textAreaDescr.setLineWrap(true);

    btnCerrar = new JButton("Cerrar");
    btnCerrar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        limpiarFormulario();
        setVisible(false);
      }
    });

    comboBoxDepartamentos.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        if (!borrandoFormularios) {
          cargarActividades(comboBoxDepartamentos.getSelectedItem().toString());
          comboBoxActividades.setEnabled(true);
          borrandoFormularios = true;
          comboBoxSalidas.removeAllItems();
          comboBoxPaquetes.removeAllItems();
          comboBoxCategorias.removeAllItems();
          borrandoFormularios = false;
          comboBoxSalidas.setEnabled(false);
          comboBoxPaquetes.setEnabled(false);
          comboBoxCategorias.setEnabled(false);
          limpiarInformacion();
        }
      }
    });

    comboBoxActividades.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        if (!borrandoFormularios) {
          String act = comboBoxActividades.getSelectedItem().toString();
          cargarInformacionActividad(act);
          comboBoxSalidas.setEnabled(true);
          comboBoxPaquetes.setEnabled(true);
          comboBoxCategorias.setEnabled(true);
          String stringEstado = "";
          estadoActividad estadoAct = controlAct.getInfoActividad(act).getestado();
          if (estadoAct == estadoActividad.agregada) {
            stringEstado = "Agregada";
          } else if (estadoAct == estadoActividad.confirmada) {
            stringEstado = "Confirmada";
          } else if (estadoAct == estadoActividad.rechazada) {
            stringEstado = "Rechazada";
          } else {
            stringEstado = "Error";
          }
          textFieldEstado.setText(stringEstado);
        }
      }
    });
    
    comboBoxSalidas.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        if (!borrandoFormularios) {
          consultarSalida();          
        }
      }
    });
    
    comboBoxPaquetes.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        if (!borrandoFormularios) {
          consultarPaquete();          
        }
      }
    });
    
    JLabel lblEstado = new JLabel("Estado");
    
    textFieldEstado = new JTextField();
    textFieldEstado.setEditable(false);
    textFieldEstado.setBackground(Color.LIGHT_GRAY);
    textFieldEstado.setColumns(10);

    // Layout
    GroupLayout groupLayout = new GroupLayout(getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.TRAILING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addContainerGap()
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                .addGroup(groupLayout.createSequentialGroup()
                  .addGap(6)
                  .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                    .addComponent(lblDepartamentos)
                    .addComponent(lblActividades)
                    .addComponent(lblNombre)
                    .addComponent(lblCosto))
                  .addGap(18)
                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addGroup(groupLayout.createSequentialGroup()
                      .addComponent(textFieldCosto, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(ComponentPlacement.RELATED)
                      .addComponent(lblDuracion, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(ComponentPlacement.RELATED)
                      .addComponent(textFieldDuracion, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                    .addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxActividades, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxDepartamentos, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)))
                .addGroup(groupLayout.createSequentialGroup()
                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addGroup(groupLayout.createSequentialGroup()
                      .addGap(22)
                      .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addComponent(lblDescr)
                        .addComponent(lblSalidas)
                        .addComponent(lblPaquetes)
                        .addComponent(lblCategorias))
                      .addPreferredGap(ComponentPlacement.UNRELATED))
                    .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                      .addComponent(lblEstado)
                      .addGap(30)))
                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                      .addComponent(comboBoxSalidas, 0, 247, Short.MAX_VALUE)
                      .addComponent(textAreaDescrScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                      .addComponent(comboBoxPaquetes, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(comboBoxCategorias, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
            .addComponent(btnCerrar, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
          .addContainerGap())
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(21)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblDepartamentos)
            .addComponent(comboBoxDepartamentos, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(comboBoxActividades, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblActividades))
          .addGap(18)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNombre)
            .addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(17)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblCosto)
            .addComponent(textFieldCosto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblDuracion)
            .addComponent(textFieldDuracion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(lblDescr)
            .addComponent(textAreaDescrScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(comboBoxSalidas, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblSalidas))
          .addGap(16)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(comboBoxPaquetes, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblPaquetes))
          .addGap(18)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblCategorias)
            .addComponent(comboBoxCategorias, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
              .addComponent(btnCerrar)
              .addContainerGap())
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(18)
              .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                .addComponent(textFieldEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblEstado))
              .addContainerGap())))
    );
    getContentPane().setLayout(groupLayout);
  }

  public void cargarInformacionActividad(String actividad) {
    DTActividad datosActividad = controlAct.getInfoActividad(actividad);
    cargarSalidas(datosActividad.getSalidas());
    cargarPaquetes(datosActividad.getPaquetes());
    cargarCategorias(datosActividad.getCategorias());
    textFieldNombre.setText(datosActividad.getNombre());
    textAreaDescr.setText(datosActividad.getDescripcion());
    textFieldDuracion.setText(String.valueOf(datosActividad.getDuracionHs()));
    textFieldCosto.setText(String.valueOf(datosActividad.getCosto()));

  }

  // Carga de ComboBoxes
  public void cargarDepartamentos() {
    borrandoFormularios = true;
    comboBoxDepartamentos.removeAllItems();
    borrandoFormularios = false;
    DefaultComboBoxModel<String> model;
    // El ComboBox no soporta Sets, hay que decidir que hacer
    Set<String> setDeptos = controlAct.listarDepartamentos();
    String[] arrDeptos = new String[setDeptos.size()];
    setDeptos.toArray(arrDeptos);

    model = new DefaultComboBoxModel<String>(arrDeptos);
    comboBoxDepartamentos.setModel(model);
    comboBoxDepartamentos.setEnabled(true);
    comboBoxActividades.setEnabled(false);
    comboBoxSalidas.setEnabled(false);
    comboBoxPaquetes.setEnabled(false);
    comboBoxCategorias.setEnabled(false);
    borrandoFormularios = true;
    comboBoxDepartamentos.setSelectedItem(null);
    borrandoFormularios = false;
  }

  public void cargarActividades(String departamento) {
    borrandoFormularios = true;
    comboBoxActividades.removeAllItems();
    borrandoFormularios = false;
    DefaultComboBoxModel<String> model;
    // El ComboBox no soporta Sets, hay que decidir que hacer
    Set<String> setActs = controlAct.listarActividadesDepartamento(departamento);
    String[] arrActs = new String[setActs.size()];
    setActs.toArray(arrActs);

    model = new DefaultComboBoxModel<String>(arrActs);
    comboBoxActividades.setModel(model);
    comboBoxSalidas.setEnabled(false);
    borrandoFormularios = true;
    comboBoxActividades.setSelectedItem(null);
    borrandoFormularios = false;
  }

  public void cargarSalidas(Set<String> setSalidas) {
    borrandoFormularios = true;
    comboBoxSalidas.removeAllItems();
    borrandoFormularios = false;
    DefaultComboBoxModel<String> model;
    // El ComboBox no soporta Sets, hay que decidir que hacer
    String[] arrSalidas = new String[setSalidas.size()];
    setSalidas.toArray(arrSalidas);

    model = new DefaultComboBoxModel<String>(arrSalidas);
    comboBoxSalidas.setModel(model);
    borrandoFormularios = true;
    comboBoxSalidas.setSelectedItem(null);
    borrandoFormularios = false;
  }

  public void cargarPaquetes(Set<String> setPaquetes) {
    borrandoFormularios = false;
    comboBoxPaquetes.removeAllItems();
    borrandoFormularios = true;
    DefaultComboBoxModel<String> model;

    String[] arrPaquetes = new String[setPaquetes.size()];
    setPaquetes.toArray(arrPaquetes);

    model = new DefaultComboBoxModel<String>(arrPaquetes);
    comboBoxPaquetes.setModel(model);
    borrandoFormularios = true;
    comboBoxPaquetes.setSelectedItem(null);
    borrandoFormularios = false;
  }

  public void cargarCategorias(Set<String> setCategorias) {
    borrandoFormularios = true;
    comboBoxCategorias.removeAllItems();
    borrandoFormularios = false;
    DefaultComboBoxModel<String> model;
    
    String[] arrCategorias = new String[setCategorias.size()];
    setCategorias.toArray(arrCategorias);

    
    model = new DefaultComboBoxModel<String>(arrCategorias);
    comboBoxCategorias.setModel(model);
    borrandoFormularios = true;
    comboBoxCategorias.setSelectedItem(null);
    borrandoFormularios = false;
  }

  public void limpiarFormulario() {
    borrandoFormularios = true;
    limpiarInformacion();
    comboBoxDepartamentos.removeAllItems();
    comboBoxActividades.removeAllItems();
    comboBoxSalidas.removeAllItems();
    comboBoxPaquetes.removeAllItems();
    comboBoxCategorias.removeAllItems();
    borrandoFormularios = false;
  }

  private void limpiarInformacion() {
    textFieldNombre.setText("");
    textAreaDescr.setText("");
    textFieldDuracion.setText("");
    textFieldCosto.setText("");
    textFieldEstado.setText("");
  }

  private void consultarPaquete() {
    if (comboBoxPaquetes.getSelectedIndex() == -1) {
      JOptionPane.showMessageDialog(this, "No hay paquete para mostrar",
          "Consulta de Actividad Turistica", JOptionPane.ERROR_MESSAGE);
    } else
      consultaPaquete
          .datosQueVienenDesdeConsultaActividad(comboBoxPaquetes.getSelectedItem().toString());
  }

  private void consultarSalida() {
    if (comboBoxSalidas.getSelectedIndex() == -1) {
      JOptionPane.showMessageDialog(this, "No hay salida para mostrar",
          "Consulta de Actividad Turistica", JOptionPane.ERROR_MESSAGE);
    } else
      consultaSalida.datosQueVienenDesdeOtroCasoDeUso(
          comboBoxDepartamentos.getSelectedItem().toString(),
          comboBoxActividades.getSelectedItem().toString(),
          comboBoxSalidas.getSelectedItem().toString());
  }

  public void datosQueVienenDesdeConsultaDeUsuario(String nombreDepartamento,
      String nombreActividad) {
    borrandoFormularios = true;
    limpiarFormulario();
    borrandoFormularios = false;
    cargarDepartamentos();
    // cargarActividades(nombreDepartamento);
    comboBoxDepartamentos.setSelectedItem(nombreDepartamento);
    comboBoxActividades.setSelectedItem(nombreActividad);
    comboBoxDepartamentos.setEnabled(false);
    comboBoxActividades.setEnabled(false);
    setVisible(true);
  }

  public void cargarVentanasConsulta(ConsultaSalida ventanaConsultaSalida,
      ConsultaPaquete ventanaConsultaPaquete) {
    consultaSalida = ventanaConsultaSalida;
    consultaPaquete = ventanaConsultaPaquete;
  }

  public void datosQueVienenDesdeConsultaPaquete(String act) {
    borrandoFormularios = true;
    limpiarFormulario();
    borrandoFormularios = false;
    DTActividad actividad = controlAct.getInfoActividad(act);
    cargarDepartamentos();
    comboBoxDepartamentos.setSelectedItem(actividad.getDepartamento());
    comboBoxActividades.setSelectedItem(act);
    comboBoxDepartamentos.setEnabled(false);
    comboBoxActividades.setEnabled(false);
    setVisible(true);
  }
}