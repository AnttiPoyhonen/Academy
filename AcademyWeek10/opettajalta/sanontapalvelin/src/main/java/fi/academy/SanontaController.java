package fi.academy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SanontaController {
    @Autowired
    SanontaRepository sanontaRepository;
    @GetMapping("/sanonnat")
    public Iterable<Sanonta> haesanonnat(Pageable pageable) {
        return sanontaRepository.findAll();
    }

    @DeleteMapping("/sanonnat/{id}")
    public ResponseEntity<String> poistasanonta(@PathVariable(name="id") int id) {
        sanontaRepository.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/sanonnat")
    public ResponseEntity luosanonta(@RequestBody Sanonta sanonta) throws URISyntaxException {
        sanonta.aloitaHistoria();
        sanontaRepository.save(sanonta);
        URI location = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(8080)
                .path("api/sanonnat/{id}")
                .buildAndExpand(sanonta.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/sanonnat/{id}")
    public ResponseEntity<Sanonta> muutasanontaa(@PathVariable(name = "id") int id, @RequestBody Sanonta sanonta) {
        if(!sanontaRepository.exists(id)) {
            return ResponseEntity.notFound().build();
        }
        sanonta.paivitaTiedot(sanonta);
        sanontaRepository.save(sanonta);
        return ResponseEntity.ok(sanonta);
    }

    @GetMapping("/sanonnat/{id}")
    public Sanonta haesanonta(@PathVariable(name = "id") int id) {
        return sanontaRepository.findOne(id);
    }

    @DeleteMapping("/sanonnat")
    public ResponseEntity poistakaikki() {
        sanontaRepository.deleteAll();
        return ResponseEntity.ok().build();
    }

    @GetMapping("reset")
    public ResponseEntity<Iterable<Sanonta>> alustaSanonnoilla() {
        sanontaRepository.deleteAll();
        Sanonta s = new Sanonta("The difference between stupidity and genius is that genius has its limits.", "Albert Einstein");
        sanontaRepository.save(s);
        sanontaRepository.save(new Sanonta("A common mistake that people make when trying to design something completely foolproof is to underestimate the ingenuity of complete fools.", "Douglas Adams"));
        sanontaRepository.save(new Sanonta("Do, or do not. There is no 'try'.", "Yoda"));
        sanontaRepository.save(new Sanonta("Make everything as simple as possible, but not simpler.", "Albert Einstein"));
        sanontaRepository.save(new Sanonta("Copy from one, it's plagiarism; copy from two, it's research.", "Wilson Mizner"));
        sanontaRepository.save(new Sanonta("People think computers will keep them from making mistakes. They're wrong. With computers you make mistakes faster.", "Adam Osborne"));
        sanontaRepository.save(new Sanonta("Any sufficiently advanced technology is indistinguishable from magic.", "Arthur C. Clarke"));
        sanontaRepository.save(new Sanonta("Poor is the pupil who does not surpass his master.", "Leonardo da Vinci"));
        URI location = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(8080)
                .path("api/sanonnat")
                .build()
                .toUri();

        return ResponseEntity.created(location).body(sanontaRepository.findAll());
    }

}
