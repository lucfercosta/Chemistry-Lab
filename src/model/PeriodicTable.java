package model;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import persistance.dao.ChemicalElementDAO;
/**
 * Represents a periodic table containing a collection of chemical elements.
 * <p>
 * The {@code PeriodicTable} class retrieves all available
 * {@link ChemicalElement} instances from the {@link ChemicalElementDAO}
 * and stores them in a list. It provides access to this collection and
 * overrides {@link #equals(Object)}, {@link #hashCode()}, and
 * {@link #toString()} for proper comparison and representation.
 * </p>
 * 
 * @author Lucas Fernandes
 */
public class PeriodicTable {
    /** Data access object used to retrieve chemical elements. */
    ChemicalElementDAO chemicalElement = new ChemicalElementDAO();
    /** List containing all chemical elements of the periodic table. */
    private List<ChemicalElement> periodicTable = new ArrayList<>();
    /**
     * Constructs a {@code PeriodicTable}.
     * <p>
     * Initializes the periodic table by retrieving all chemical elements
     * from the data source using {@link ChemicalElementDAO}.
     * </p>
     */
    public PeriodicTable() {
        this.periodicTable = chemicalElement.getAllElements();
    }
    /**
     * Returns the list of chemical elements in the periodic table.
     *
     * @return a list of {@link ChemicalElement} objects
     */
    public List<ChemicalElement> getPeriodicTable() {
        return periodicTable;
    }
    /**
     * Returns a hash code value for this periodic table.
     * <p>
     * The hash code is computed based on the list of chemical elements.
     * </p>
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(periodicTable);
    }
    /**
     * Compares this periodic table to the specified object.
     * <p>
     * Two {@code PeriodicTable} objects are considered equal if their
     * lists of chemical elements are equal.
     * </p>
     *
     * @param obj the object to compare with
     * @return {@code true} if this object is equal to the specified object;
     *         {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PeriodicTable other = (PeriodicTable) obj;
        return Objects.equals(periodicTable, other.periodicTable);
    }
    /**
     * Returns a string representation of this periodic table.
     * <p>
     * The string includes the name of the class followed by the list
     * of chemical elements it contains.
     * </p>
     *
     * @return a formatted string representing the periodic table
     */
    @Override
    public String toString() {
        return "PeriodicTable \n" +periodicTable + "\n";
    }
}