package fi.academy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestController
@RequestMapping(path="/companies")
public class CompanyController {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public Iterable<Company> haeYritykset() {
        return companyRepository.findAll();
    }

    @GetMapping("/username")
    public List<Company> haeYritysKayttajanNimella(@RequestParam(name = "name") String name) {
        // Käytetyn metodin toteutus tekniikalla, jota ei olla vielä käyty läpi
        return companyRepository.etsiYritysKayttajanNimella(name);
    }

    @GetMapping(path = "/{companyId}")
    public Company haeYritys(@PathVariable(name = "companyId") int id) {
        return companyRepository.findOne(id);
    }

    // curl --data "{\"name\": \"Hessu\", \"email\": \"goofy@disney.com\"}" -H "Content-type: application/json" "http://localhost:8080/companies/1"
    @PostMapping("/{companyid}")
    public ResponseEntity<Company> lisaaKayttaja(@PathVariable(name = "companyid") int id, @RequestBody User user) {
        Company c = companyRepository.findOne(id);
        if (c != null)
            c.addUser(user);
        else
            //return ResponseEntity.notFound().build();
            throw new IllegalArgumentException("Company hukassa, yritetty id: " + id);
        userRepository.save(user);
        return ResponseEntity.ok(c);
    }
}

@ControllerAdvice
class OmaExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(
            { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex,
                                                    WebRequest pyynto) {
        return handleExceptionInternal(ex, "Virhe: " + ex.getMessage(),
                new HttpHeaders(), HttpStatus.NOT_FOUND, pyynto);
    }
}
