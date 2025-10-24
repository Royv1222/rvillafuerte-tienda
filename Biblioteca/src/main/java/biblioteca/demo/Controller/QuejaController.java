package biblioteca.demo.Controller;

import biblioteca.demo.domain.Queja;
import biblioteca.demo.Service.QuejaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/quejas")
public class QuejaController {

    private final QuejaService quejaService;

    @GetMapping("/nueva")
    public String nueva(Model model, @RequestParam(name="ok", required=false) String ok) {
        model.addAttribute("queja", new Queja());
        model.addAttribute("ok", ok != null);
        return "queja/form";
    }

    @PostMapping
    public String guardar(@ModelAttribute Queja queja) {
        // tipo debe ser uno de: QUEJA, SUGERENCIA, CONSULTA (según tu ENUM)
        quejaService.guardar(queja);
        return "redirect:/quejas/nueva?ok=1";
    }
}