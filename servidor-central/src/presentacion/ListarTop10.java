package presentacion;

import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;

import logica.interfaces.ICtrlActividad;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class ListarTop10 extends JInternalFrame {
	
	private ICtrlActividad ctrlAct;
	
	private JLabel lblNombre;
	private JLabel lblTipo;
	private JLabel lblVisitas;
	
	String[] columns = {"Nombre", "Tipo", "Visitas"};
	DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
	JTable table = new JTable(tableModel);
	
	public ListarTop10(ICtrlActividad ica) {
		ctrlAct = ica;
		
		setIconifiable(true);
		setMaximizable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setResizable(true);
		setTitle("Top 10 Visitadas");
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblVisitas = new JLabel("Visitas");
		lblVisitas.setHorizontalAlignment(SwingConstants.CENTER);
				
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(58)
							.addComponent(lblNombre)
							.addGap(112)
							.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(117)
							.addComponent(lblVisitas, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(lblVisitas)
						.addComponent(lblTipo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		
		getContentPane().setLayout(groupLayout);
	}
	
	public void cargarInformacion() {
		limpiarTabla();
		Map<String, Integer> info = ctrlAct.listarTop10Visitados();
		info.forEach((k,v)->{
			if(v > 0) {
				String[] fila= {k, "Actividad", v.toString()};
				tableModel.addRow(fila);
			}else {
				Integer value = -1*v;
				String[] fila= {k, "Salida", value.toString()};
				tableModel.addRow(fila);
			}
		});
		
		
	}
	
	private void limpiarTabla() {
		tableModel.setRowCount(0);
	}
	
}
