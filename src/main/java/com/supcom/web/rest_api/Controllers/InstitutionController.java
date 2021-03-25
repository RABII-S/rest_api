package com.supcom.web.rest_api.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.relation.RelationNotFoundException;

import com.supcom.web.rest_api.Repository.InstitutionRepository;
import com.supcom.web.rest_api.model.Institution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class InstitutionController {
    @Autowired
    private InstitutionRepository institutionRepository;
    @GetMapping("/inst")
    public List<Institution> getAllinstitutions() {
        return institutionRepository.findAll();
    }

    @GetMapping("/inst/{id}")
    public ResponseEntity<Institution> getinstitutionById(@PathVariable(value = "id") Long institutionId)

            throws RelationNotFoundException {
        Institution institution = institutionRepository.findById(institutionId)
                .orElseThrow(() -> new RelationNotFoundException("institution not found for this id :: "+ institutionId));
        return ResponseEntity.ok().body(institution);
    }

    @PostMapping("/inst")
    public Institution createInstitution(@RequestBody Institution inst) { return institutionRepository.save(inst);
    }

    @PutMapping("/inst/{id}")
    public ResponseEntity<Institution> updateinstitution(@PathVariable(value = "id") Long institutionId,

                                              @RequestBody Institution inst) throws RelationNotFoundException { Institution institution = institutionRepository.findById(institutionId)

            .orElseThrow(() -> new RelationNotFoundException("institution not found for this id :: " + institutionId));


        institution.setLine(inst.getLine()); institution.setCurrent(inst.getCurrent()); institution.setName(inst.getName());institution.setService(inst.getService());

        final Institution updatedinstitution = institutionRepository.save(institution);
        return ResponseEntity.ok(updatedinstitution);

    }

    
    @DeleteMapping("/inst/{id}")
    public Map<String, Boolean> deleteinstitution(@PathVariable(value = "id") Long institutionId) throws RelationNotFoundException {

        Institution institutions = institutionRepository.findById(institutionId)

                .orElseThrow(() -> new RelationNotFoundException("institution not found for this id :: " + institutionId));

        institutionRepository.delete(institutions);
        Map<String, Boolean> response = new HashMap<>(); response.put("deleted", Boolean.TRUE);
        return response;

    }

}
