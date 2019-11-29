package com.acme.core.taller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.acme.core.Ingrediente;

public class ModeloTablaIngrediente extends AbstractTableModel {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1L;

	private static final List<String> listaEncabezados = Arrays.asList("Tipo", "Nombre", "Cantidad", "Precio");
	
	private List<Ingrediente> listaDatos;
	
	public ModeloTablaIngrediente() {
		listaDatos = new ArrayList<Ingrediente>();
	}
	
	public ModeloTablaIngrediente(List<Ingrediente> listaDatos) {
		this.listaDatos = listaDatos;
	}
	
	@Override
	public int getRowCount() {
		return listaDatos.size();
	}

	@Override
	public int getColumnCount() {
		return listaEncabezados.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		//Se obtiene la fila del ingrediente
		Ingrediente ing = listaDatos.get(rowIndex);
		
		//Dependiendo de la columna, se muestra el campo
		switch (columnIndex) {
			case 0 :
				return ing.getTipo().getNombre();				
			
			case 1 :
				return ing.getNombre();
				
			case 2 :
				return ing.getStock();
				
			case 3 :
				return String.format("%.2f", ing.getCosto());
				
			default :
				return "???";
		}
	}
	
	@Override
	public String getColumnName(int column) {
		return listaEncabezados.get(column);
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public void actualizarListaDatos(List<Ingrediente> listaDatos) {
		this.listaDatos = listaDatos;
		
		//Forzar la actualizacion completa del modelo
		fireTableDataChanged();
	}
	
	/**
	 * @return the listaDatos
	 */
	public List<Ingrediente> getListaDatos() {
		return listaDatos;
	}
}
