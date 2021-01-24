package SpringApplication.Controller;

import SpringApplication.model.Praeferenzen;
import SpringApplication.repositories.PraeferenzenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class PraeferenzenController {
    private final PraeferenzenRepository praeferenzenRepository;

    @Autowired
    public PraeferenzenController(PraeferenzenRepository PraeferenzenRepository) {
        this.praeferenzenRepository = PraeferenzenRepository;
    }

    @PostMapping("/praef/addPraef")
    public String addPraef(@Valid Praeferenzen praeferenzen, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            praeferenzenRepository.save(praeferenzen);
        }
        model.addAttribute("bisherigePraeferenzen", praeferenzenRepository.findAll());
        return "praef";
    }

    @GetMapping(path = "/praef")
    public String showPraef(Praeferenzen praeferenzen, Model model) {
        model.addAttribute("bisherigePraeferenzen", praeferenzenRepository.findAll());
        return "praef";
    }
}
