/**
 * 
 */
package com.acme.core.taller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang3.StringUtils;

import com.acme.core.EnumIngrediente;
import com.acme.core.Ingrediente;
import com.acme.core.ingredientes.Carne;
import com.acme.core.ingredientes.Condimento;
import com.acme.core.ingredientes.Fruta;
import com.acme.core.ingredientes.Grano;
import com.acme.core.ingredientes.Vegetal;

/**
 * @author Jairo Henao
 *
 */
public class DetallesIngrediente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox cmbTipo;
	private JTextField txtNombre;
	private JTextField txtCantidad;
	private JTextField txtPrecio;

	private CRUDIngrediente crudIngrediente;
	private Ingrediente ingrediente;
	
	/**
	 * Create the dialog.
	 */
	public DetallesIngrediente(CRUDIngrediente crudIngrediente, Ingrediente ingrediente) {
		super(crudIngrediente.getFrmAdministracionIngredientes());
		this.crudIngrediente = crudIngrediente;
		this.ingrediente = ingrediente;
		
		setModal(true);
		setTitle("Detalle ingrediente");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(crudIngrediente.getFrmAdministracionIngredientes());
		BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		contentPanel.setBorder(new EmptyBorder(20, 15, 20, 15));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(4, 2, 10, 20));
		{
			JLabel lblTipo = new JLabel("Tipo");
			contentPanel.add(lblTipo);
		}
		{
			cmbTipo = new JComboBox();
			cmbTipo.setModel(new DefaultComboBoxModel(EnumIngrediente.values()));
			contentPanel.add(cmbTipo);
		}
		{
			JLabel lblNombre = new JLabel("Nombre");
			contentPanel.add(lblNombre);
		}
		{
			txtNombre = new JTextField();
			contentPanel.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			JLabel lblCantidad = new JLabel("Cantidad");
			contentPanel.add(lblCantidad);
		}
		{
			txtCantidad = new JTextField();
			contentPanel.add(txtCantidad);
			txtCantidad.setColumns(10);
		}
		{
			JLabel lblPrecio = new JLabel("Precio");
			contentPanel.add(lblPrecio);
		}
		{
			txtPrecio = new JTextField();
			contentPanel.add(txtPrecio);
			txtPrecio.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						confirmarCambios();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		cargarValoresIngrediente();
	}

	public void cargarValoresIngrediente() {
		cmbTipo.setSelectedItem(ingrediente.getTipo());
		txtNombre.setText(ingrediente.getNombre());
		txtCantidad.setText(ingrediente.getStock() != null ? ingrediente.getStock().toString() : "");
		txtPrecio.setText(ingrediente.getCosto() != null ? String.format("%.0f", ingrediente.getCosto()) : "");
	}
	
	private void confirmarCambios() {
		//Se realizan las validaciones
		if(cmbTipo.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(this, "El tipo es requerido", "Valor requerido", JOptionPane.ERROR_MESSAGE);
		} else if(StringUtils.isBlank(txtNombre.getText())) {
			JOptionPane.showMessageDialog(this, "El nombre es requerido", "Valor requerido", JOptionPane.ERROR_MESSAGE);
		} else if(StringUtils.isBlank(txtCantidad.getText()) || !StringUtils.isNumeric(txtCantidad.getText())) {
			JOptionPane.showMessageDialog(this, "La cantidad es requerida", "Valor requerido", JOptionPane.ERROR_MESSAGE);
		} else if(StringUtils.isBlank(txtPrecio.getText()) || !StringUtils.isNumeric(txtPrecio.getText())) {
			JOptionPane.showMessageDialog(this, "El precio es requerido", "Valor requerido", JOptionPane.ERROR_MESSAGE);
		} else {
			EnumIngrediente tipo = (EnumIngrediente) cmbTipo.getSelectedItem();
			String nombre = txtNombre.getText();
			
			if(ingrediente.getId() == null) {
				//Se crea la instancia dependiendo el tipo
				switch (tipo) {
					case FRUTA :
						ingrediente = new Fruta(nombre);
						
						break;
						
					case GRANO :
						ingrediente = new Grano(nombre);
						
						break;
					
					case PROTEINA :
						ingrediente = new Carne(nombre);
						
						break;
					
					case CONDIMENTO :
						ingrediente = new Condimento(nombre);
						
						break;
						
					case VEGETAL :
						ingrediente = new Vegetal(nombre);
						
						break;
						
					case DESCONOCIDO :
						//Nada por hacer
						
						break;
				}
			}
			
			if(ingrediente != null) {
				ingrediente.setStock(Integer.parseInt(txtCantidad.getText()));
				ingrediente.setCosto(Double.parseDouble(txtPrecio.getText()));
				ingrediente.setTipo(tipo);
				
				setVisible(false);
				
				//Si el registro no tiene ID, es un nuevo registro
				if(ingrediente.getId() == null) {
					crudIngrediente.agregarIngrediente(ingrediente);
				} else {
					crudIngrediente.editarIngrediente(ingrediente);
				}
				
				//Se cierra el dialogo actual
				dispose();
			}
		}
	}
}
