package SpringApplication.Controller;

import SpringApplication.model.Praeferenzen;
import SpringApplication.repositories.PraeferenzenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

public class PraeferenzenController {
    private final PraeferenzenRepository praeferenzenRepository;

    @Autowired
    public PraeferenzenController(PraeferenzenRepository PraeferenzenRepository) {
        this.praeferenzenRepository = PraeferenzenRepository;
    }

    @GetMapping(path = "/categories")
    public String getPraef(HttpServletRequest request, Model model) {
        praeferenzenRepository.save(Praeferenzen.newPraef(1, "Deutsch", "vegan"));
        praeferenzenRepository.save(Praeferenzen.newPraef(2, "Französisch", "vegetarisch"));
        praeferenzenRepository.save(Praeferenzen.newPraef(3, "Spanisch", "mit Fleisch"));
        praeferenzenRepository.save(Praeferenzen.newPraef(4, "Griechisch", "mit Fisch"));
        praeferenzenRepository.save(Praeferenzen.newPraef(5, "Türkisch", "Glutenfrei"));
        model.addAttribute("praefernezen", praeferenzenRepository.findAll());
        return "praeferenzen";
    }
    @GetMapping(path = "/categories/{id}")
    public String getCategories(@PathVariable("id") long id, Model model) {
        model.addAttribute("praeferenzen", null);
        return "praeferenzen";
    }
}
