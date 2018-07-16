package com.caelum.tccjavaweb.role;

import com.caelum.tccjavaweb.account.Account;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class RoleController {

//    private final RoleRepository roleRepository;

//    public RoleController(RoleRepository roleRepository) {
//        this.roleRepository = roleRepository;
//    }

//    @GetMapping("account/current")
//    @ResponseStatus(value = HttpStatus.OK)
//    @Secured({"ROLE_USER", "ROLE_ADMIN"})
//    public Account currentAccount(Principal principal) {
//        Assert.notNull(principal);
//        return roleRepository.findOneByEmail(principal.getName());
//    }
//
//    @GetMapping("account/{id}")
//    @ResponseStatus(value = HttpStatus.OK)
//    @Secured("ROLE_ADMIN")
//    public Account account(@PathVariable("id") Long id) {
//        return roleRepository.findOne(id);
//    }
}
