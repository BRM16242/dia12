package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class ProductoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id_Producto;
	private String Codigo;
	private String Nombre;
	private Long Id_Categoria;
	
	
	public Long getIdProducto() {
		return Id_Producto;
	}
	public void setIdProducto(Long IdProducto) {
		this.Id_Producto=IdProducto;
	}
	
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public Long getId_Categoria() {
		return Id_Categoria;
	}
	public void setId_Categoria(Long id_Categoria) {
		Id_Categoria = id_Categoria;
	}
}

