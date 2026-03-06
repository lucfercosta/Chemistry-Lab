package engine;
import java.util.List;
import model.ChemicalElement;
import persistance.dao.ChemicalReactionDAO;
import model.ChemicalReaction;

/**
 * The {@code ReactionEngine} is responsible for validating chemical reactions
 * between two {@link ChemicalElement} objects.
 * <p>
 * It loads all valid {@link ChemicalReaction} instances from the
 * {@link ChemicalReactionDAO} and checks whether a reaction exists
 * between two given elements.
 * </p>
 * 
 * @author Lucas Fernandes
 */
public class ReactionEngine {
    private final ChemicalReactionDAO chemicalReactionDAO;
    private final List<ChemicalReaction> validChemicalReactions;
    /**
     * Constructs a new {@code ReactionEngine}.
     * <p>
     * Initializes the {@link ChemicalReactionDAO} and retrieves all
     * valid chemical reactions from the data source.
     * </p>
     */  
    public ReactionEngine() {
        chemicalReactionDAO = new ChemicalReactionDAO();
        validChemicalReactions = chemicalReactionDAO.getAllReactions();
    }
    
    /**
     * Checks whether a valid chemical reaction exists between two
     * {@link ChemicalElement} instances.
     * <p>
     * The order of the elements does not matter. If a matching reaction
     * is found in the list of valid reactions, it is returned.
     * Otherwise, {@code null} is returned.
     * </p>
     *
     * @param firstElement  the first chemical element
     * @param secondElement the second chemical element
     * @return the matching {@link ChemicalReaction} if the reaction is valid;
     *         {@code null} if no valid reaction exists
     */
    
    public ChemicalReaction isReactionValid(ChemicalElement firstElement, ChemicalElement secondElement) {
        String symbol1 = firstElement.getSymbol();
        String symbol2 = secondElement.getSymbol();

        for (ChemicalReaction reaction : validChemicalReactions) {
            if ((reaction.getFirstElement().equals(symbol1) && reaction.getSecondElement().equals(symbol2)) ||
                (reaction.getFirstElement().equals(symbol2) && reaction.getSecondElement().equals(symbol1))) {
                return reaction;
            }
        }

        return null;
    }

    /**
     * Returns a string representation of this {@code ReactionEngine},
     * including the list of all valid chemical reactions loaded
     * from the data source.
     *
     * @return a string containing the valid chemical reactions
     */
    @Override
    public String toString() {
        return "Valid Reactions: " + validChemicalReactions ;
    }
}
