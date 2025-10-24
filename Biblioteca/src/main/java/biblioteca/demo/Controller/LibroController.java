package biblioteca.demo.Controller;

import biblioteca.demo.domain.Libro;
import biblioteca.demo.repository.CategoriaRepository;
import biblioteca.demo.Service.LibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/libros")
public class LibroController {

  private final LibroService libroService;
  private final CategoriaRepository categoriaRepo;

  @GetMapping
  public String listar(Model model) {
    model.addAttribute("lista", libroService.listar());
    return "libro/lista";
  }

  @GetMapping("/nuevo")
  public String nuevo(Model model) {
    model.addAttribute("libro", new Libro());
    model.addAttribute("categorias", categoriaRepo.findAll());
    return "libro/form";
  }

  // NUEVO: EDITAR (GET)
  @GetMapping("/editar/{id}")
  public String editar(@PathVariable Long id, Model model) {
    Libro l = libroService.buscar(id);
    if (l == null) return "redirect:/libros";
    model.addAttribute("libro", l);
    model.addAttribute("categorias", categoriaRepo.findAll());
    return "libro/form";
  }

  // Crear / Actualizar (reusa el mismo POST)
  @PostMapping
  public String guardar(@Valid @ModelAttribute("libro") Libro libro,
                        BindingResult br,
                        Model model) {
    if (br.hasErrors()) {
      model.addAttribute("categorias", categoriaRepo.findAll());
      return "libro/form";
    }
    if (libro.getDisponible() == null) libro.setDisponible(true);
    libroService.guardar(libro);
    return "redirect:/libros";
  }

  @GetMapping("/eliminar/{id}")
  public String eliminar(@PathVariable Long id) {
    libroService.eliminar(id);
    return "redirect:/libros";
  }
}