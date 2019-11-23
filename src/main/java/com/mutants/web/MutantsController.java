package com.mutants.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mutants.entities.Human;
import com.mutants.services.MutantsService;
import com.mutants.services.model.MutantStats;

@RestController
public class MutantsController {
	
	@Autowired
	private MutantsService mutantsService;
    @PostMapping("/mutant")
    public Boolean create(@RequestBody Human proposedMutant) throws ForbiddenException {
    	Boolean isMutant = mutantsService.saveAsMutant(proposedMutant);

        if (!isMutant){
            throw new ForbiddenException("NOT A MUTANT");
        }
        return true;
    	
    	/*String[] dna = proposedMutant.getDna();
        boolean isMutant = mutantsService.isMutant(dna);
        if (isMutant){
            return MutantsService.isMutant(dna);
        }else{
            throw new ForbiddenException();
        }*/
    }
    
    @GetMapping("/stats")
    public MutantStats stats() {
        return mutantsService.getMutantStats();
    }

    @GetMapping("/reboot")
    public void reboot() {
        mutantsService.deleteAll();
    }

}
