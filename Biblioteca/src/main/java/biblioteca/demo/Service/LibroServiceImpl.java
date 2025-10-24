package biblioteca.demo.Service;

import biblioteca.demo.domain.Libro;
import biblioteca.demo.repository.LibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LibroServiceImpl implements LibroService {
    private final LibroRepository repo;

    @Override public List<Libro> listar()           { return repo.findAll(); }
    @Override public Libro guardar(Libro libro)     { return repo.save(libro); }
    @Override public void eliminar(Long id)         { repo.deleteById(id); }
    @Override public Libro buscar(Long id)          { return repo.findById(id).orElse(null); }
}