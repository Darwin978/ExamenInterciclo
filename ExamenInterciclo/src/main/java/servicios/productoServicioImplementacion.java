package servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import modelo.Productos;
import repositorio.repositorioPoducto;


@Service
public class productoServicioImplementacion implements productoServicio{

	@Autowired
	private repositorioPoducto repositorioProducto;
	
	
	@Override
	@Transactional(readOnly= true)
	public Iterable<Productos> findAll() {
		
		return repositorioProducto.findAll();
	}

	@Override
	@Transactional(readOnly= true)
	public Page<Productos> findAll(Pageable pageable) {
		
		return repositorioProducto.findAll(pageable);
	}

	@Override
	@Transactional(readOnly= true)
	public Optional<Productos> findbyId(Long id) {
		
		return repositorioProducto.findById(id);
	}

	@Override
	@Transactional
	public Productos save(Productos productos) {
		
		return repositorioProducto.save(productos);
	}

	@Override
	@Transactional
	public void deletedBy(Long id) {
		repositorioProducto.deleteById(id);
		
	}
}
