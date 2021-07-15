package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.entity.User;
import com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.models.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.PageRequest;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UserRestController {
    
    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public List<User> users() {
        return userService.findAll();
    }

    @GetMapping("/users/page/{page}")
    public Page<User> users(@PathVariable int page) {
        return userService.findAll(PageRequest.of(page, 5));
    }

    @GetMapping("/users/{id}")
    public<T extends Number> ResponseEntity<?> getUser(@PathVariable T id) {

        User user = null;
        Map<String, Object> response = new HashMap<>();

        try {
            user = userService.findById((int) id.longValue()).orElse(null);
        } catch (DataAccessException error) {
            response.put("Error", error.getMessage()
                .concat("Ha habido un error al comunicarse con la BBDD: ")
                .concat(error.getMostSpecificCause().getMessage())
                );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if (user == null) {
            response.put("message", "El cliente con ID ".concat(id.toString().concat(" no existe.")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user, BindingResult result) {

        User newUser = null;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            newUser = userService.save(user);
        } catch (DataAccessException error) {
            response.put("Error", error.getMessage()
                .concat("\nHa habido un error al comunicarse con la BBDD: ")
                .concat(error.getMostSpecificCause().getMessage())
                );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("message", "El usuario ha sido registrado con éxito!");
        response.put("User", newUser);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public<T extends Number> ResponseEntity<?> updateUser(@Valid @RequestBody User user, @PathVariable T id, BindingResult result) {
        
        User actualUser = userService.findById((int) id.longValue()).orElse(null);
        
        User updatedUser = null;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if (actualUser == null) {
            response.put("message", "El cliente con ID ".concat(id.toString().concat(" no existe.")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {
            actualUser.setUsername(user.getUsername());
            actualUser.setPassword(user.getPassword());
            actualUser.setEmail(user.getEmail());
            actualUser.setName(user.getName());
            actualUser.setLastName(user.getLastName());
            actualUser.settrainer(user.gettrainer());
    
            updatedUser = userService.save(actualUser);
        } catch (DataAccessException error) {
            response.put("error", error.getMessage()
                .concat("\nHa habido un error al actualizar el usuario en la BBDD: ")
                .concat(error.getMostSpecificCause().getMessage())
                );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("message", "El usuario ha sido actualizado con éxito!");
        response.put("User", updatedUser);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{id}")
    public<T extends Number> ResponseEntity<?>  deleteUser(@PathVariable T id) {
        
        Map<String, Object> response = new HashMap<>();
        
        try {
            userService.delete((int) id.longValue());
        } catch (DataAccessException error) {
            response.put("Error", error.getMessage()
                .concat("\nHa habido un error al intentar borrar al usuario en la BBDD: ")
                .concat(error.getMostSpecificCause().getMessage())
                );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("message", "Cliente eliminado con éxito!");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);    
    }

    public UserRestController() {}
}
