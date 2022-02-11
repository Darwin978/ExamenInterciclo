package repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import modelo.Productos;

@Repository
public interface repositorioPoducto extends JpaRepository<Productos, Long> {

}
