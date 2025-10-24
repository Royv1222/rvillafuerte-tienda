package biblioteca.demo.Controller;

import biblioteca.demo.domain.Categoria;
import biblioteca.demo.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/categorias")
public class CategoriaController {

  private final CategoriaRepository repo;

  @GetMapping
  public String listar(Model model) {
    model.addAttribute("lista", repo.findAll());
    return "categoria/lista";
  }

  @GetMapping("/nueva")
  public String nueva(Model model) {
    model.addAttribute("categoria", new Categoria());
    return "categoria/form";
  }

  // NUEVO: EDITAR (GET)
  @GetMapping("/editar/{id}")
  public String editar(@PathVariable Long id, Model model) {
    Categoria c = repo.findById(id).orElse(null);
    if (c == null) return "redirect:/categorias";
    model.addAttribute("categoria", c);
    return "categoria/form";
  }

  @PostMapping
  public String guardar(@Valid @ModelAttribute("categoria") Categoria categoria,
                        BindingResult br) {
    if (br.hasErrors()) return "categoria/form";
    repo.save(categoria);
    return "redirect:/categorias";
  }

  @GetMapping("/eliminar/{id}")
  public String eliminar(@PathVariable Long id) {
    repo.deleteById(id);
    return "redirect:/categorias";
  }
}
