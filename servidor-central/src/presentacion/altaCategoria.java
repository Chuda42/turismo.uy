package presentacion;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import excepciones.YaExisteException;
import logica.interfaces.ICtrlActividad;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class altaCategoria extends JInternalFrame {
	private ICtrlActividad IActividad;
	
	private JTextField textField;
	public altaCategoria(ICtrlActividad ica) {
		setTitle("Alta de Categoria");
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		IActividad = ica;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{44, 223, 119, 0};
		gridBagLayout.rowHeights = new int[]{30, 20, 42, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Nombre: ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridwidth = 2;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		getContentPane().add(textField, gbc_textField);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				limpiarFormulario();
			}
		});
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmdAltaActividadTuristicaActionPerformed(e);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 3;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 3;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
	}

	protected void cmdAltaActividadTuristicaActionPerformed(ActionEvent arg0) {
		String nombreCategoria = this.textField.getText();
		
		if(checkFormulario()) {
			try {
				
				IActividad.altaCategoria(nombreCategoria);
				limpiarFormulario();
				JOptionPane.showMessageDialog(this,
						"Categoria creada con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
			
			} catch(YaExisteException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Alta de Categoria ", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
	
	private boolean checkFormulario() {
		String nombreCategoria = this.textField.getText();
		
		if (nombreCategoria.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Alta de Categoria",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
		
		return true;
	}
	
	private void limpiarFormulario() {
		textField.setText("");
	}
}
