package controlador;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import modelo.Productos;
import servicios.productoServicio;



@RestController
@RequestMapping("/api/productos")
public class productoController {
	@Autowired
	private productoServicio productoServicio;
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Productos producto){
		producto.setPreciodearticulo(producto.getCantidad()*producto.getPrecio());
		return ResponseEntity.status(HttpStatus.CREATED).body(productoServicio.save(producto));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value ="id") Long userId){
		Optional<Productos> oUser=productoServicio.findbyId(userId);
		
		if(!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oUser);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?>update(@RequestBody Productos productoDetails, @PathVariable(value="id") Long productId){
		Optional <Productos> producto= productoServicio.findbyId(productId);
		if(!producto.isPresent()) {
			return  ResponseEntity.notFound().build();
		}
		
		producto.get().setCodigo(productoDetails.getCodigo());
		producto.get().setDescripcion(productoDetails.getDescripcion());
		producto.get().setCantidad(productoDetails.getCantidad());
		producto.get().setPrecio(productoDetails.getPrecio());
		producto.get().setPreciodearticulo(productoDetails.getPreciodearticulo());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productoServicio.save(producto.get()));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value="id") Long productId){
		
		if(!productoServicio.findbyId(productId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		productoServicio.deletedBy(productId);
		return ResponseEntity.ok().build();
	}
	
	
	@GetMapping
	public List<Productos> readAll(){
		List<Productos> productos= StreamSupport.stream(productoServicio.findAll().spliterator(), false).collect(Collectors.toList());
		
		return productos;
	}

}
