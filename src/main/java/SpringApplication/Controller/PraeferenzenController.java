package SpringApplication.Controller;

import SpringApplication.model.Praeferenzen;
import SpringApplication.repositories.PraeferenzenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
@Controller
public class PraeferenzenController {
    private final PraeferenzenRepository praeferenzenRepository;

    @Autowired
    public PraeferenzenController(PraeferenzenRepository PraeferenzenRepository) {
        this.praeferenzenRepository = PraeferenzenRepository;
    }

    @GetMapping("/createPraef")
    public String showCreateBookingForm(Praeferenzen praef) {
        praeferenzenRepository.save(praef);
        return "praef";
    }

    @GetMapping(path = "/praef")
    public String getPraef(HttpServletRequest request, Model model) {

        model.addAttribute("praeferenzen", praeferenzenRepository.findAll());
        return "praef";
    }
}
