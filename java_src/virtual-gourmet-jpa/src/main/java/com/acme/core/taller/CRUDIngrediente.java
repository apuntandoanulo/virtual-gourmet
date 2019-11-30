package com.acme.core.taller;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.acme.core.EnumIngrediente;
import com.acme.core.Ingrediente;
import com.acme.core.ingredientes.Vegetal;
import com.acme.entities.ejemplos.jdbc.IngredienteJDBCUtil;

public class CRUDIngrediente {

	private JFrame frmAdministracionIngredientes;
	private JTable tablaDatos;

	private IngredienteJDBCUtil jdbcUtil;
	private ModeloTablaIngrediente modeloTablaIngredientes;
	private Optional<Ingrediente> elementoSeleccionado;
	
	private final String urlBD = "jdbc:postgresql://127.0.0.1:5432/curso_java_bd?currentSchema=public";
	private final String usuario = "curso_java";
	private final String password = "curso_java";
	
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private JButton btnSimularIva;
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUDIngrediente window = new CRUDIngrediente();
					window.frmAdministracionIngredientes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CRUDIngrediente() {
		jdbcUtil = new IngredienteJDBCUtil(urlBD, usuario, password);
		modeloTablaIngredientes = new ModeloTablaIngrediente();
		elementoSeleccionado = Optional.empty();
		
		initialize();
		
		try {
			jdbcUtil.conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		cargarDatosIngredientes();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdministracionIngredientes = new JFrame();
		frmAdministracionIngredientes.setTitle("Administracion ingredientes");
		frmAdministracionIngredientes.setBounds(100, 100, 770, 456);
		frmAdministracionIngredientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdministracionIngredientes.getContentPane().setLayout(new BorderLayout(0, 0));
		frmAdministracionIngredientes.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					jdbcUtil.desconectar();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JPanel panelBotones = new JPanel();
		frmAdministracionIngredientes.getContentPane().add(panelBotones, BorderLayout.NORTH);
		panelBotones.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DetallesIngrediente di = new DetallesIngrediente(CRUDIngrediente.this, new Vegetal());
				di.setVisible(true);
			}
		});
		panelBotones.add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DetallesIngrediente di = new DetallesIngrediente(CRUDIngrediente.this, elementoSeleccionado.get());
				di.setVisible(true);
			}
		});
		panelBotones.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener((actEvt) -> {
			//Solo se realiza la accion si el usuario confirma el mensaje...
			if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(frmAdministracionIngredientes, "¿Realmente desea eliminar el ingrediente seleccionado?",
					"Eliminar registro", JOptionPane.YES_NO_OPTION)) {
				eliminarElemento(elementoSeleccionado);
				cargarDatosIngredientes();
			}
		});
		panelBotones.add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDatosIngredientes();
				
				JOptionPane.showMessageDialog(frmAdministracionIngredientes, "Los datos han sido actualizados correctamente",
						"Ingredientes actualizados", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		panelBotones.add(btnActualizar);
		
		btnSimularIva = new JButton("Simular IVA");
		btnSimularIva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Se obtienen los ingredientes actuales
				List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
				
				try {
					ingredientes = jdbcUtil.obtenerListaIngredientes("nombre");
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				
				//Aplicar el iva del 16%
				List<Ingrediente> ingsIva = ingredientes.stream()
						.filter((ing) -> EnumIngrediente.FRUTA.equals(ing.getTipo()) || EnumIngrediente.VEGETAL.equals(ing.getTipo())) 
						.map((ing) -> {
							ing.setCosto(ing.getCosto() + ing.getCosto() * 0.16); 
							return ing;
						})
						.filter((ing) -> ing.getCosto() > 1000)
						.collect(Collectors.toList());
				
				//Se actualiza la tabla de ingredientes
				modeloTablaIngredientes.actualizarListaDatos(ingsIva);
			}
		});
		panelBotones.add(btnSimularIva);
				
		JScrollPane scrlPanelTabla = new JScrollPane();
		frmAdministracionIngredientes.getContentPane().add(scrlPanelTabla, BorderLayout.CENTER);
		
		tablaDatos = new JTable();
		tablaDatos.setModel(modeloTablaIngredientes);
		tablaDatos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tablaDatos.setRowSelectionAllowed(true);
		
		tablaDatos.getSelectionModel().addListSelectionListener((lse) -> {
			if(!lse.getValueIsAdjusting()) {
				int[] selectedRows = tablaDatos.getSelectedRows();
				
				elementoSeleccionado = Optional.empty();
				
				//Verificando si hay filas seleccionadas para identificar el ingrediente seleccionado
				if(selectedRows != null && selectedRows.length > 0) {
					elementoSeleccionado = Optional.of(((ModeloTablaIngrediente) tablaDatos.getModel()).getListaDatos().get(selectedRows[0]));
				}
				
				refrescarEstadoBotones();
			}
		});
		
		scrlPanelTabla.setViewportView(tablaDatos);
	}
	
	private void cargarDatosIngredientes() {
		List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		
		try {
			ingredientes = jdbcUtil.obtenerListaIngredientes("nombre");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		modeloTablaIngredientes.actualizarListaDatos(ingredientes);
		elementoSeleccionado = Optional.empty();
		
		refrescarEstadoBotones();
	}
	
	private void refrescarEstadoBotones() {
		//Si hay un elemento seleccionado
		if(elementoSeleccionado.isEmpty()) {
			btnEditar.setEnabled(false);
			btnEliminar.setEnabled(false);
		} else {
			btnEditar.setEnabled(true);
			btnEliminar.setEnabled(true);
		}
	}
	
	public void agregarIngrediente(Ingrediente ing) {
		try {
			jdbcUtil.insertar(ing);
			
			JOptionPane.showMessageDialog(frmAdministracionIngredientes, "El nuevo registro ha sido guardado exitosamente",
					"Ingredientes agregado", JOptionPane.INFORMATION_MESSAGE);
			
			cargarDatosIngredientes();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editarIngrediente(Ingrediente ing) {
		System.out.println("PENDIENTE...");
	}
	
	/**
	 * @param ingredienteSeleccionado
	 */
	private void eliminarElemento(Optional<Ingrediente> ingredienteSeleccionado) {
		if(ingredienteSeleccionado.isPresent()) {
			try {
				jdbcUtil.eliminarIngrediente(ingredienteSeleccionado.get().getNombre());
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	
	/**
	 * @return the frmAdministracionIngredientes
	 */
	public JFrame getFrmAdministracionIngredientes() {
		return frmAdministracionIngredientes;
	}
}
