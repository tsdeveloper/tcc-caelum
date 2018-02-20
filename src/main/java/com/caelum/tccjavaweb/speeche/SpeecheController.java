package com.caelum.tccjavaweb.speeche;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class SpeecheController {

    private final SpeecheRepository accountRepository;

    public SpeecheController(SpeecheRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

   
}
