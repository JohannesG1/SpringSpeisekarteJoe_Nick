package SpringApplication.Controller;

import SpringApplication.model.Gericht;
import SpringApplication.model.Praeferenzen;
import SpringApplication.repositories.GerichtRepository;
import SpringApplication.repositories.PraeferenzenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller
public class PraeferenzenController {
    private final PraeferenzenRepository praeferenzenRepository;
    private final GerichtRepository gerichtRepository;

    @Autowired
    public PraeferenzenController(PraeferenzenRepository PraeferenzenRepository, GerichtRepository gerichtRepository) {
        this.praeferenzenRepository = PraeferenzenRepository;
        this.gerichtRepository = gerichtRepository;
    }

    @PostMapping("/praef/addPraef")
    public String addPraef(@Valid Praeferenzen praeferenzen, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            praeferenzenRepository.save(praeferenzen);
        }
        model.addAttribute("bisherigePraeferenzen", praeferenzenRepository.findAll());
        return "praef";
    }
    @PostMapping("/praef/deletePraef")
    public String addPraef(BindingResult result, Model model) {
        praeferenzenRepository.deleteAll();
        model.addAttribute("bisherigePraeferenzen", praeferenzenRepository.findAll());
        return "praef";
    }

    @GetMapping(path = "/praef")
    public String showPraef(Praeferenzen praeferenzen, Model model) {
        model.addAttribute("bisherigePraeferenzen", praeferenzenRepository.allPraeferenzen());
        return "praef";
    }

    @GetMapping(path = "/praef/Speisekarte")
    public String getSpeisekarte(Praeferenzen praeferenzen, Model model) {
        this.gerichtRepository.allGerichte();
        Collection<Gericht> items = gerichtRepository.allGerichte().stream().filter(gericht -> {
            return praeferenzenRepository.allPraeferenzen()
                    .stream()
                    .anyMatch(preferenz -> gericht.getBeschreibung().contains(preferenz.getEingaben()));
        }).collect(Collectors.toList());
        model.addAttribute("gerichte", items);
        return "speisekarte";
    }
}
