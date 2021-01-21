package SpringApplication.Controller;

import SpringApplication.model.Kategorie;
import SpringApplication.repositories.KategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;


@Controller
public class SpeisekartenKategorienController {

    private final KategorieRepository kategorieRepository;

    @Autowired
    public SpeisekartenKategorienController(KategorieRepository kategorieRepository) {
        this.kategorieRepository = kategorieRepository;
    }

    @GetMapping(path = "/categories")
    public String getCategories(HttpServletRequest request, Model model) {
        kategorieRepository.save(Kategorie.newKategorie(1, "Italienisch", "1"));
        kategorieRepository.save(Kategorie.newKategorie(2, "Französisch", "2"));
        kategorieRepository.save(Kategorie.newKategorie(3, "Spanisch", "3"));
        kategorieRepository.save(Kategorie.newKategorie(4, "Griechisch", "4"));
        kategorieRepository.save(Kategorie.newKategorie(5, "Türkisch", "5"));
        model.addAttribute("kategorien", kategorieRepository.findAll());
        return "kategorien";
    }
    @GetMapping(path = "/categories/{id}")
    public String getCategories(@PathVariable("id") long id, Model model) {
        model.addAttribute("kategorien", null);
        return "kategorien";
    }

}
