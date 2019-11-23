package com.mutants.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutants.entities.Human;
import com.mutants.entities.Mutant;
import com.mutants.entities.NotMutant;
import com.mutants.services.model.MutantStats;
import com.mutants.web.ForbiddenException;

import com.mutants.repositories.HumanRepository;
import com.mutants.repositories.MutantRepository;
import com.mutants.repositories.NotMutantRepository;
import com.mutants.services.model.MutantStats;

@Service
public class MutantsService {
	
	@Autowired
    HumanRepository humanRepository;
    @Autowired
    MutantRepository mutantRepository;
    @Autowired
    NotMutantRepository notMutantRepository;

    public static boolean isMutant(String[] dna) {


        boolean respuestaH = false;
        boolean respuestaV = false;
        boolean respuestaO = false;
        boolean respuestaIfFalse = false;
        int igualdadesH, sumaH = 0;
        int igualdadesV, sumaV = 0;
        int igualdadesO, sumaO = 0;
        int sumaTotal=0;

        for (int i = 0; i < dna.length; i++) {
            igualdadesH = 0;
            for (int j = 0; j < dna.length - 1; j++) {
                System.out.println("entra al segundo for" + dna[i].charAt(j) + " " + dna[i].charAt(j + 1));
                if ( dna[i].charAt(j) == dna[i].charAt(j + 1)) {

                    igualdadesH++;
                    System.out.println("entra al if " + igualdadesH);
                } else {
                    
                    igualdadesH = 0;
                }
                if (igualdadesH == 3) {

                    respuestaH = true;
                    sumaTotal += igualdadesH;
                }

                System.out.println("" + sumaH);
                if (sumaTotal == 6) {
                    return respuestaH;
                }

            }

        }
        for (int i = 0; i < dna.length; i++) {
            igualdadesV = 0;
            for (int j = 0; j < dna.length - 1; j++) {
                System.out.println("entra al segundo for");
                System.out.println("" + dna[j].charAt(i) + " " + dna[j + 1].charAt(i));
                if (dna[j].charAt(i) == dna[j + 1].charAt(i)) {

                    igualdadesV++;
                    System.out.println("entra al if " + igualdadesV);
                } else {
                    System.out.println("entra al else");
                    igualdadesV = 0;
                }

                if (igualdadesV == 3) {

                    respuestaV = true;
                    sumaTotal += igualdadesV;
                }

                System.out.println("" + sumaV);
                if (sumaTotal == 6) {
                    return respuestaV;
                }

            }
        }
        for (int i = 0; i < dna.length - 3; i++) {

            igualdadesO = 0;
            for (int j = 0; j < (dna.length - 1) - i; j++) {

                System.out.println("entra al segundo for");
                System.out.println("" + dna[j].charAt(j + i) + " " + dna[j + 1].charAt(j + 1 + i));
                if (dna[j].charAt(j + i) == dna[j + 1].charAt(j + 1 + i)) {
                    System.out.println("entra al if");
                    igualdadesO++;
                    System.out.println("" + igualdadesO);
                } else {
                    System.out.println("entra al else");
                    igualdadesO = 0;
                }

                if (igualdadesO == 3) {
                    System.out.println("aca llego");
                    respuestaO = true;
                    sumaTotal += igualdadesO;

                }

                if (sumaTotal == 6) {
                    return respuestaO;
                }

            }
        }
        for (int i = 1; i < dna.length - 3; i++) {

            igualdadesO = 0;
            for (int j = 0; j < (dna.length - 1) - i; j++) {
                System.out.println("entra al segundo for");
                System.out.println("" + dna[j + i].charAt(j) + " " + dna[j + 1 + i].charAt(j + 1));
                if (dna[j + i].charAt(j) == dna[j + 1 + i].charAt(j + 1)) {
                    System.out.println("entra al if");
                    igualdadesO++;
                    System.out.println("" + igualdadesO);
                } else {
                    System.out.println("entra al else");
                    igualdadesO = 0;
                }

                if (igualdadesO == 3) {
                    System.out.println("aca llego");
                    sumaTotal += igualdadesO;
                    respuestaO = true;
                    
                }

                if (sumaTotal == 6) {
                    return respuestaO;
                }

            }
        }

       
        return respuestaIfFalse;
    }
    
    public boolean saveAsMutant(Human human) throws ForbiddenException {
        Boolean alreadyExists = humanRepository.existsByDna(human.getDna());
        Boolean isMutant = isMutant(human.getDna());
        if (isMutant && !alreadyExists) {
            Mutant mutant = new Mutant(human);
            mutantRepository.save(mutant);

        } else if (!isMutant && !alreadyExists) {
            NotMutant notMutant = new NotMutant(human);
            notMutantRepository.save(notMutant);
        }
        return isMutant;
    }

    public MutantStats getMutantStats() {
//        long countNotMutants = notMutantRepository.count();
        long countMutants = mutantRepository.count();
//        long countHumans = countMutants + countNotMutants;
        long countHumans = humanRepository.count();

        return new MutantStats(countMutants, countHumans);
    }

    public void deleteAll() {
        humanRepository.deleteAll();
    }

}

