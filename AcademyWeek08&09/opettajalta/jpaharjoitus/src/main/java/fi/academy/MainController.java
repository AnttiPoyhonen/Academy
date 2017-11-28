package fi.academy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/all")
    public Iterable<User> nimihaku(@RequestParam(required = false) String name) {
        if (name==null || name.isEmpty())
            return userRepository.findAll();
        return userRepository.findByName(name);
    }

    @GetMapping(path = "/email")
    public List<User> emailhaku(@RequestParam(required = false) String email) {
        return userRepository.findByEmailStartsWith(email);
    }

    @GetMapping(path="/emailcount")
    public Integer emaillkmhaku(@RequestParam(required = false) String email) {
        return userRepository.countDistinctByEmailEndingWith(email);
    }

    @GetMapping(path="/add") // Map ONLY GET Requests
    public String addNewUser (@RequestParam String name
            , @RequestParam String email) {

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

//    @GetMapping(path="/all")
//    public Iterable<User> getAllUsers() {
//        return userRepository.findAll();
//    }
}