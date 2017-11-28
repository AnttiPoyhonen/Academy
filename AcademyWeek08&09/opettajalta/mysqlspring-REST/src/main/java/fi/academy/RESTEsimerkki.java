package fi.academy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class RESTEsimerkki {
    private static Logger log = LoggerFactory.getLogger("RestController");
    @Autowired
    private KieliDao kielidao;

    @Autowired
    JdbcTemplate jdbcTemplate;
    private String nimi = "oletus";
    @RequestMapping(value="/esim", method = RequestMethod.GET)
    public String esimerkki() {
        return "Terve " + nimi;
    }

    @GetMapping("/restlhlo")
    public Language esimpost(String nimi) {
        log.info("jdbcTemplate: " + jdbcTemplate);
        Language l;
        l = kielidao.haeKaikki().get(0);
        return l;
    }
}
