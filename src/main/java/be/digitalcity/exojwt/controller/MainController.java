package be.digitalcity.exojwt.controller;


import be.digitalcity.exojwt.models.forms.UserForm;
import be.digitalcity.exojwt.services.UserService;
import be.digitalcity.exojwt.utils.JwtProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class MainController {

    private final AuthenticationManager authManager;
    private final UserService service;
    private final JwtProvider jwtProvider;

    public MainController(AuthenticationManager authManager, UserService service, JwtProvider jwtProvider) {
        this.authManager = authManager;
        this.service = service;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/user/register")
    public void register(@RequestBody UserForm form){
        service.register(form);
    }

    @PostMapping("/user/login")
    public String login(@RequestBody UserForm form){
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword()));
        return jwtProvider.createToken(auth);
    }

    @GetMapping("/random")
    public int random(){
        return new Random().nextInt(10);
    }


}
