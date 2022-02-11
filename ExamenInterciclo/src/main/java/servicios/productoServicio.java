package servicios;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import modelo.Productos;

public interface productoServicio {


	public Iterable<Productos> findAll();
	
	public Page<Productos> findAll(Pageable pageable);
	
	public Optional<Productos> findbyId(Long id);
	
	public Productos save(Productos productos);
	
	public void deletedBy(Long id);
}
