package models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="categoria")
public class CategoriaModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_categoria;
	private String nombre;

	public Long getId_Categoria() {
		return id_categoria;
	}
	public void setId_Categoria(Long id_Categoria) {
		id_categoria = id_Categoria;
	}

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String Nombre)
    {
        this.nombre=Nombre;
    }
}
