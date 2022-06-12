/**
 * Given a DNA sequence, detects if it is a potential gene.
 * Rules:
 * 1. Length must be multiple of 3;
 * 2. Has a start codon (ATG);
 * 3. Has a stop codon (TAA or TAG or TGA)
 * 4. Do not have intervening stop codons
 *
 * Based on: https://introcs.cs.princeton.edu/java/31datatype/PotentialGene.java.html
 */
public class GeneDetector {
    public static boolean isPotentialGene(String dna) {
        // Genes must be composed of codons (length is multiple of 3)
        if (dna.length() % 3 != 0) return false;

        // Starts with start codon.
        if (!dna.startsWith("ATG")) return false;

        // Ends with a stop codon
        if (dna.endsWith("TAA")) return true;
        if (dna.endsWith("TAG")) return true;
        if (dna.endsWith("TGA")) return true;

        // No intervening stop codons
        for (int i = 3; i < dna.length() - 3; i++) {
            if (i % 3 == 0) {
                String codon = dna.substring(i, i+3);
                if (codon.equals("TAA")) return false;
                if (codon.equals("TAG")) return false;
                if (codon.equals("TGA")) return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Usage: GeneDetector <seq>");
        }
        System.out.println(isPotentialGene(args[0]));
    }
}
