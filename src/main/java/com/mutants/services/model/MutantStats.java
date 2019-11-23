package com.mutants.services.model;

public class MutantStats {
	


	    private long count_mutant_dna;
	    private long count_human_dna;
	    private Double ratio;

	    public MutantStats(long count_mutant_dna, long count_human_dna) {
	        this.count_mutant_dna = count_mutant_dna;
	        this.count_human_dna = count_human_dna;
	        if (count_human_dna > 0) {
	            this.ratio = Double.valueOf(count_mutant_dna) / Double.valueOf(count_human_dna);
	        }else{
	            this.ratio = 0.0;
	        }
	    }

	    public long getCount_mutant_dna() {
	        return count_mutant_dna;
	    }

	    public long getCount_human_dna() {
	        return count_human_dna;
	    }

	    public double getRatio() {
	        return ratio;
	    }
}
