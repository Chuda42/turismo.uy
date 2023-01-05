package presentacion;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import excepciones.YaExisteException;

import javax.swing.JTextArea;

import logica.interfaces.ICtrlActividad;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class CrearPaquete extends JInternalFrame{
	//Interfaces
	private ICtrlActividad controlAct;
	
	//Componentes graficos
	private JLabel lblNombre;
	private JLabel lblDescripcion;
	private JLabel lblPeriodoValidez;
	private JLabel lblDescuento;
	private JTextField textFieldNombre;
	private JTextArea textAreaDescripcion;
	private JTextField textFieldPeriodoValidez;
	private JTextField textFieldDescuento;
	private JButton btnAceptar;
	private JButton btnCerrar;
	private JTextField selectedDate;
	private JInternalFrame f;
	private JButton btnFecha;
	private GregorianCalendar fechaPaquete;
	
	public CrearPaquete(ICtrlActividad ica) {
		setMaximizable(true);
		controlAct = ica;
		
		setResizable(true);
        setIconifiable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta de Paquete de Actividades Turisticas");
        setBounds(30, 30, 481, 376);
        
        lblNombre = new JLabel("Nombre:");
        lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDescripcion = new JLabel("Descripcion:");
        lblDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPeriodoValidez = new JLabel("Periodo de Validez:");
        lblPeriodoValidez.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDescuento = new JLabel("Descuento:");
        lblDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        
        textFieldNombre = new JTextField();
        textFieldNombre.setToolTipText("Ingrese el nombre del paquete");
        textAreaDescripcion = new JTextArea();
        textAreaDescripcion.setToolTipText("Ingrese la descripcion del paquete");
        textFieldPeriodoValidez = new JTextField();
        textFieldPeriodoValidez.setToolTipText("Ingrese el periodo de validez del paquete en dias");
        textFieldDescuento = new JTextField();
        textFieldDescuento.setToolTipText("Ingrese el descuento del paquete");
        
        textAreaDescripcion.setWrapStyleWord(true);
        textAreaDescripcion.setLineWrap(true);
        
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
        		cmdCrearPaqueteActionPerformed(arg0);
        	}
        });
        
        JLabel lblFecha = new JLabel("Fecha:");
        
        selectedDate = new JTextField();
        selectedDate.setEditable(false);
        selectedDate.setColumns(10);
        
        btnFecha = new JButton("");
        String icon_path = "src/icons/calendario.png";
        ImageIcon icon = new ImageIcon(icon_path,"calendario");
        Image img = icon.getImage();
        Image scaled_img = img.getScaledInstance( 15, 15,  java.awt.Image.SCALE_SMOOTH ) ;  
        btnFecha.setIcon(new ImageIcon(scaled_img));
        btnFecha.setEnabled(true);
        
        btnFecha.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent ae) {
            setVisible(true);
            selectedDate.setText(new DatePicker(f).setPickedDate());
            // string en formato dd-mm-yyyy
            if(!selectedDate.getText().isEmpty()) {
              int dia = Integer.parseInt(selectedDate.getText().substring(0,2));
              int mes = Integer.parseInt(selectedDate.getText().substring(3,5));
              int anio = Integer.parseInt(selectedDate.getText().substring(6,10));
              fechaPaquete = new GregorianCalendar(anio, mes-1, dia);
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
                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addGroup(groupLayout.createSequentialGroup()
                      .addGap(24)
                      .addComponent(lblNombre))
                    .addGroup(groupLayout.createSequentialGroup()
                      .addContainerGap()
                      .addComponent(lblDescripcion)))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                    .addComponent(textFieldNombre)
                    .addComponent(textAreaDescripcion, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)))
                .addGroup(groupLayout.createSequentialGroup()
                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addGroup(groupLayout.createSequentialGroup()
                      .addGap(24)
                      .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblPeriodoValidez)
                        .addComponent(lblDescuento)
                        .addGroup(groupLayout.createSequentialGroup()
                          .addComponent(lblFecha)
                          .addPreferredGap(ComponentPlacement.UNRELATED)
                          .addComponent(selectedDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                      .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                          .addPreferredGap(ComponentPlacement.RELATED)
                          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                            .addComponent(textFieldDescuento, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldPeriodoValidez, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)))
                        .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                          .addGap(24)
                          .addComponent(btnFecha, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                          .addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)))
                      .addPreferredGap(ComponentPlacement.RELATED))
                    .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                      .addContainerGap()
                      .addComponent(btnAceptar)
                      .addGap(104)))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(btnCerrar)
                  .addGap(72)))
              .addContainerGap())
        );
        groupLayout.setVerticalGroup(
          groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(17)
              .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                .addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblNombre))
              .addGap(27)
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(lblDescripcion)
                .addComponent(textAreaDescripcion, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                  .addGap(18)
                  .addComponent(lblPeriodoValidez))
                .addGroup(groupLayout.createSequentialGroup()
                  .addGap(12)
                  .addComponent(textFieldPeriodoValidez, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                  .addGap(14)
                  .addComponent(lblDescuento))
                .addGroup(groupLayout.createSequentialGroup()
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(textFieldDescuento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
              .addGap(18)
              .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                .addComponent(btnFecha, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                  .addComponent(lblFecha)
                  .addComponent(selectedDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
              .addGap(18)
              .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                .addComponent(btnAceptar)
                .addComponent(btnCerrar))
              .addGap(17))
        );
        getContentPane().setLayout(groupLayout);
        
	}
	
	protected void cmdCrearPaqueteActionPerformed(ActionEvent arg0) {
		if(checkFormulario()) {
			String nombre = textFieldNombre.getText();
			String descripcion = textAreaDescripcion.getText();
			int periodoValidez = Integer.valueOf(textFieldPeriodoValidez.getText());
			float descuento = Float.valueOf(textFieldDescuento.getText());
			
			String imagen = "paqDefault.jpg"; 
			
			try {
				controlAct.crearPaquete(nombre, descripcion, periodoValidez, descuento, fechaPaquete, imagen);
				
				JOptionPane.showMessageDialog(this, "El paquete ha sido creado con exito", "Crear Paquete de Actividades Turisticas", JOptionPane.INFORMATION_MESSAGE);
				limpiarFormulario();
				setVisible(false);
			} catch (YaExisteException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Inscripcion a Salida Turistica", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void limpiarFormulario() {
		textFieldNombre.setText("");
		textAreaDescripcion.setText("");
		textFieldPeriodoValidez.setText("");
		textFieldDescuento.setText("");
	}
	
	private boolean checkFormulario() {
		if(textFieldNombre.getText().isEmpty() || textAreaDescripcion.getText().isEmpty() || 
				textFieldDescuento.getText().isEmpty() || textFieldPeriodoValidez.getText().isEmpty() || selectedDate.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Crear Paquete de Actividades Turisticas", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else {
			try {
				Integer number = Integer.valueOf(textFieldPeriodoValidez.getText());
				if(number <=0)
					throw new NumberFormatException();
				
				try {
					Float aux = Float.valueOf(textFieldDescuento.getText());
					if(aux<=0)
						throw new NumberFormatException();
					
				} catch(NumberFormatException ex){
					ex.printStackTrace();
					JOptionPane.showMessageDialog(this, "El descuento debe ser un numero positivo", "Crear Paquete de Actividades Turisticas", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			} catch(NumberFormatException ex){
				ex.printStackTrace();
				JOptionPane.showMessageDialog(this, "El periodo de validez debe ser un numero entero positivo", "Crear Paquete de Actividades Turisticas", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		
		return true;
	}
}