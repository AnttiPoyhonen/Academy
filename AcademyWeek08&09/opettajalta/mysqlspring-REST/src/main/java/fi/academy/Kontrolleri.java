package fi.academy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Kontrolleri {
    @Autowired
    JdbcTemplate jdbc;
    @Autowired
    private KieliDao kielidao;

    @RequestMapping("/maat")
    public String hae(Model model) {
        List<Country> countries =
                jdbc.query("select * from country order by name", //new Object[]{},
                (rs, index)->new Country(
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getString("localname"),
                        rs.getString("continent"),
                        rs.getDouble("surfacearea"),
                        rs.getShort("indepyear"),
                        rs.getInt("population")
                )
        );
        model.addAttribute("maat", countries);
        return "maalista";
    }

    @RequestMapping("/kielet")
    public String kielet(@RequestParam(value = "maa", required = false) String maa, Model model) {
        List<Language> kielet;
        if (maa == null || maa.isEmpty())
            kielet = kielidao.haeKaikki();
        else
            kielet = kielidao.haeKaikki(maa);
        model.addAttribute("kielet", kielet);
        return "kielilista";
    }

}
