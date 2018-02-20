package com.caelum.tccjavaweb.speeche;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeecheRepository extends JpaRepository<Speeche, Long> {
	Speeche findOneByEmail(String email);
}