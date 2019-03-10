package com.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.entity.Etablissement;

public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {

}
