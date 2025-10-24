package biblioteca.demo.Service;

import biblioteca.demo.domain.Libro;
import java.util.List;

public interface LibroService {
    List<Libro> listar();
    Libro guardar(Libro libro);
    void eliminar(Long id);
    Libro buscar(Long id);
}
