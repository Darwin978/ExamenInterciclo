package modelo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Producto")
public class Productos {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length=100, nullable= false)
	private String descripcion;
	
	@Column(precision=2, nullable= false)
	private Double precio;
	
	@Column(nullable= false)
	private Long cantidad;
	
	@Column( nullable= false)
	private Double preciodearticulo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPreciodearticulo() {
		return preciodearticulo;
	}

	public void setPreciodearticulo(Double preciodearticulo) {
		this.preciodearticulo = preciodearticulo;
	}

	
	
}
