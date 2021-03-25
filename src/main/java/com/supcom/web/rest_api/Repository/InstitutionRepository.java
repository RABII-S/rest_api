package com.supcom.web.rest_api.Repository;

import com.supcom.web.rest_api.model.Institution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long>{

}