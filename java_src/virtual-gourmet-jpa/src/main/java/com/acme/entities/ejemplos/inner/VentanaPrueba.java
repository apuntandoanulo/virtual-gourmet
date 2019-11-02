package com.acme.entities.ejemplos.inner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.acme.core.ingredientes.Carne;
import com.acme.core.ingredientes.Fruta;
import com.acme.entities.ejemplos.excepciones.LimiteSuperadoException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaPrueba extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldCantidad;

	private ArrayList<Fruta> listaFrutas;
	
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
		listaFrutas = new ArrayList<Fruta>();
		
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
					
					try {
						agregarIngrediente(nombre, cantidad);
					} catch (LimiteSuperadoException lex) {
						JOptionPane.showMessageDialog(null, "La cantidad que superaron es " + lex.getCantidadSuperada());
						
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
		btnAgregar.setBounds(153, 151, 97, 25);
		contentPane.add(btnAgregar);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(44, 93, 56, 16);
		contentPane.add(lblCantidad);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(153, 90, 116, 22);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
	}
	
	private void agregarIngrediente(String nombre, Integer cantidad) throws LimiteSuperadoException {
		Fruta fruta = new Fruta(nombre);
		fruta.setStock(cantidad);
		
		listaFrutas.add(fruta);
		
		if(listaFrutas.size() > 3) {
			throw new LimiteSuperadoException("Ya superamos el mensaje", 3);
		}
	}
}
