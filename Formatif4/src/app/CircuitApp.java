package app;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class CircuitApp {
    public static void main(String[] args) {
        String numero;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez le numéro du circuit (1, 2 ou 3) ou 'q' pour quitter: ");
            numero = scanner.nextLine();

            CircuitBuilder builder = new CircuitBuilder();
            if (!Objects.equals(numero, "q")) {
                try {
                    Composant circuit = builder.construireCircuit("circuit" + numero + ".json");
                    String typeCircuit;

                    if (circuit instanceof CircuitSerie) {
                        typeCircuit = "Circuit en série";
                    } else if (circuit instanceof CircuitParallele) {
                        typeCircuit = "Circuit en parallèle";
                    } else {
                        typeCircuit = "Composant unique";
                    }

                    System.out.println(typeCircuit + " - Résistance totale du circuit : " + circuit.calculerResistance() + " Ω\n");
                } catch (IOException e) {
                    System.err.println("Erreur lors de la lecture du fichier JSON : " + e.getMessage());
                }
            }
        }
        while (!Objects.equals(numero, "q"));
    }
}