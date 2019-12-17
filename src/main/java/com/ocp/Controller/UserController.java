package com.ocp.Controller;

import com.ocp.Dao.UserDao;
import com.ocp.Model.Personne;
import com.ocp.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserDao userDao;

    @GetMapping("/users")
    public List<User> getAllUsrs(){
        return userDao.findAll();
    }

    @PostMapping("/users")
    public Personne addUser(@Valid @RequestBody User user){
        return userDao.save(user);
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable(value = "id") String matricule){
        return userDao.findById(matricule);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable(value = "id") String matricule){
        userDao.deleteById(matricule);
    }

    @PutMapping(path = "/users/{id}",
            consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void updateUser(@PathVariable(value = "id") String id, @Valid @RequestBody User user1) {

        User user = userDao.getOne(id);
        user.setMatricule(user1.getMatricule());
        user.setEmail(user1.getEmail());
        user.setNom(user1.getNom());
        user.setPrenom(user1.getPrenom());
        user.setTel(user1.getTel());
        user.setService(user1.getService());
        user.setSite(user1.getSite());
        userDao.save(user);

    }
}
