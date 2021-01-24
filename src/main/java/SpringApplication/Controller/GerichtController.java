package SpringApplication.Controller;

import SpringApplication.model.Praeferenzen;
import SpringApplication.repositories.GerichtRepository;
import SpringApplication.repositories.PraeferenzenRepository;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.StreamSupport;

@Controller
public class GerichtController {
    private final GerichtRepository gerichtRepository;

    @Autowired
    public GerichtController(GerichtRepository gerichtRepository) {
        this.gerichtRepository = gerichtRepository;
    }
    @GetMapping(path = "/Speisekarte")
    public String getSpeisekarte(Praeferenzen praeferenzen, Model model) {
        model.addAttribute("gerichte", gerichtRepository.findAll());
        return "speisekarte";
    }
}
