package demo;

import demo.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Kontrolleri {

    @Autowired
    private CountryRepository maarepo;

    @GetMapping("/maat")
    public String maahaku(Model model) {
//        List<Country> maat = new ArrayList<>();
//        for(Country c : maarepo.findAll()) {
//            maat.add(c);
//        }
        model.addAttribute("maat", maarepo.findAll());
        return "maalista";
    }

}