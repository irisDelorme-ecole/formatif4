package app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * La classe CircuitBuilder permet de construire un circuit électronique à partir d'un fichier JSON.
 * Elle analyse les données JSON pour créer dynamiquement des composants tels que des résistances,
 * des circuits en série et des circuits en parallèle.
 */
public class CircuitBuilder {
    // Séparateur de fichier pour garantir la compatibilité multiplateforme
    private static final char fSep = File.separatorChar;

    // Chemin d'accès par défaut vers le répertoire des données
    private static final String pathIn = System.getProperty("user.dir") + fSep + "src" + fSep;

    /**
     * Construit un circuit électronique à partir d'un fichier JSON.
     *
     * @param nomFichier Le nom du fichier JSON contenant la définition du circuit.
     * @return Un objet Composant représentant le circuit complet.
     * @throws IOException Si une erreur survient lors de la lecture du fichier JSON.
     */
    public Composant construireCircuit(String nomFichier) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode racine = mapper.readTree(new File(nomFichier)).get("circuit");
        return lireComposant(racine);
    }

    /**
     * Méthode récursive permettant de lire et de créer un composant à partir d'un nœud JSON.
     *
     * @param node Le nœud JSON décrivant le composant.
     * @return Un objet Composant correspondant au nœud JSON.
     * @throws IllegalArgumentException Si le type du composant est inconnu.
     */
    private Composant lireComposant(JsonNode node) {
        String type = node.get("type").asText();
        // TODO: Compléter cette méthode
        return null;
    }
}
