package com.acme.entities.ejemplos.inner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AccionBotonAgregar implements ActionListener {

	private JTextField textField;
	
	public AccionBotonAgregar(JTextField textField) {
		this.textField = textField;
	}
	
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Han agregado el ingrediente: " + textField.getText());
		
		textField.setText("");
		
		JOptionPane.showMessageDialog(null, "OK, ingrediente agregado");
	}
}
