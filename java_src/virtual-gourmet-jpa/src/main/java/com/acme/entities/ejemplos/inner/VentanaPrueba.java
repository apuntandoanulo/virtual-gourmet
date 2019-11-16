package com.acme.entities.ejemplos.inner;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.acme.core.EnumIngrediente;
import com.acme.core.InventarioIngredientes;
import com.acme.core.ingredientes.Carne;
import com.acme.core.ingredientes.Fruta;
import com.acme.core.ingredientes.Vegetal;
import com.acme.entities.ejemplos.excepciones.LimiteSuperadoException;
import com.acme.entities.ejemplos.flujos.UtilitarioJSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class VentanaPrueba extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldCantidad;
	private JComboBox comboBoxTipoIngrediente;
	
	private InventarioIngredientes inventario;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrueba frame = new VentanaPrueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrueba() {
		inventario = new InventarioIngredientes();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(44, 36, 56, 16);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(153, 33, 223, 22);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textFieldNombre.getText();
				
				try {
					Integer cantidad = Integer.parseInt(textFieldCantidad.getText());
					EnumIngrediente tipo = (EnumIngrediente) comboBoxTipoIngrediente.getSelectedItem();
					
					try {
						agregarIngrediente(nombre, cantidad, tipo);
					} catch (LimiteSuperadoException lex) {
						JOptionPane.showMessageDialog(null, "La cantidad que superaron es " + lex.getCantidadSuperada());
						
						// Asi se propaga la excepcion
						throw lex;
					}
				
					textFieldNombre.setText("");
					textFieldCantidad.setText("");
					
					JOptionPane.showMessageDialog(null, "OK, ingrediente agregado");
				} catch (NumberFormatException nfex) {
					JOptionPane.showMessageDialog(null, "La cantidad es incorrecta");
				} catch (LimiteSuperadoException lex) {
					
				}
			}
		});
		btnAgregar.setBounds(153, 215, 97, 25);
		contentPane.add(btnAgregar);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(44, 93, 56, 16);
		contentPane.add(lblCantidad);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(153, 90, 116, 22);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		comboBoxTipoIngrediente = new JComboBox();
		comboBoxTipoIngrediente.setModel(new DefaultComboBoxModel(EnumIngrediente.values()));
		comboBoxTipoIngrediente.setBounds(153, 151, 116, 21);
		contentPane.add(comboBoxTipoIngrediente);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(44, 155, 46, 13);
		contentPane.add(lblTipo);
	}
	
	private void agregarIngrediente(String nombre, Integer cantidad, EnumIngrediente tipo) throws LimiteSuperadoException {
		
		switch (tipo) {
			case FRUTA :
				Fruta fruta = new Fruta(nombre);
				fruta.setStock(cantidad);
				fruta.setTipo(tipo);
				
				inventario.getListaFrutas().add(fruta);
				
				break;
				
			case VEGETAL :
				Vegetal veg = new Vegetal(nombre);
				veg.setStock(cantidad);
				
				inventario.getListaVegetales().add(veg);
				
				break;
				
			case PROTEINA :
				Carne cr = new Carne();
				cr.setNombre(nombre);
				cr.setStock(cantidad);
				
				inventario.agregarIngrediente(cr);
				
				break;
				
			default :
				System.out.println("Ignorando el tipo de ingrediente...");
				
				break;
		}
		
		/*
		// Ejemplo de como se lanza una excepcion
		if(listaFrutas.size() > 3) {
			throw new LimiteSuperadoException("Ya superamos el mensaje", 3);
		}
		*/
		
		if(inventario.obtenerCantidadElementos() == 6) {
			System.out.println("Guardando la lista en el archivo...");
			
			try {
				UtilitarioJSON.guardarArchivo("D:\\DELETE_ME\\virtual_gourmet_inventario.json", inventario);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
