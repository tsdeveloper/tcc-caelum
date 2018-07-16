package com.caelum.tccjavaweb.role;

import com.caelum.tccjavaweb.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}