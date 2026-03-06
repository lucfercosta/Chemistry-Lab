package ui;

import engine.ReactionEngine;
import model.ChemicalElement;
import model.ChemicalReaction;
/**
 *
 * @author Lucas Fernandes
 */
public class ReactionController {

    private ChemicalElement firstElement;
    private ChemicalElement secondElement;
    private final ReactionEngine reactionEngine;

    public ReactionController() {
        this.reactionEngine = new ReactionEngine();
    }

    /** Adds an element to the reaction, up to 2 elements. */
    public void addElement(ChemicalElement element) {
        if (firstElement == null) {
            firstElement = element;
        } else if (secondElement == null) {
            secondElement = element;
        }
    }

    /** Returns whether a new element can still be added. */
    public boolean canAddMoreElements() {
        return !(firstElement != null && secondElement != null);
    }

    /** Returns true if both elements are present. */
    public boolean isReady() {
        return firstElement != null && secondElement != null;
    }

    /** Starts the reaction and resets elements. */
    public ChemicalReaction startReaction() {
        if (!isReady()) return null;

        ChemicalReaction reaction = reactionEngine.isReactionValid(firstElement, secondElement);
        firstElement = null;
        secondElement = null;
        return reaction;
    }

    /** Returns a string representation of the currently selected elements. */
    public String getCurrentReactionString() {
        if (firstElement == null) return "";
        String reaction = firstElement.getSymbol();
        if (secondElement != null) {
            reaction += " + " + secondElement.getSymbol();
        }
        return reaction;
    }

    /** Resets the current selection. */
    public void reset() {
        firstElement = null;
        secondElement = null;
    }
}