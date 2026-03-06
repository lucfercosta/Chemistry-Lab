package model;
import java.util.Objects;

/**
 * Represents a chemical element with its basic chemical properties.
 * <p>
 * A {@code ChemicalElement} contains identifying and descriptive
 * information such as id, name, symbol, formula, and atomic mass.
 * This class also provides implementations of {@link #equals(Object)},
 * {@link #hashCode()}, and {@link #toString()} for proper comparison
 * and representation.
 * </p>
 * 
 * @author Lucas Fernandes
 */
public class ChemicalElement {
    private int id;
    private String name;
    private String symbol;
    private String formula;
    private double atomicMass;
    /**
     * Constructs a {@code ChemicalElement} with all attributes initialized.
     *
     * @param id            the unique identifier of the element
     * @param name          the name of the chemical element
     * @param symbol        the chemical symbol of the element
     * @param formula       the chemical formula of the element
     * @param atomicWeight  the atomic mass (in g/mol) of the element
     */ 
    public ChemicalElement(int id, String name, String symbol, String formula, double atomicWeight) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.formula = formula;
        this.atomicMass = atomicWeight;
    } 
    /**
     * Default constructor for {@code ChemicalElement}.
     * <p>
     * Creates an empty element instance. Attributes can be set later
     * using setters (if available) or other initialization logic.
     * </p>
     */
    public ChemicalElement() {
    }
    /**
     * Returns the unique identifier of this element.
     *
     * @return the element id
     */
    public int getId() { 
        return id; 
    }    
    /**
     * Returns the name of this chemical element.
     *
     * @return the element name
     */   
    public String getName() { 
        return name; 
    }
    /**
     * Returns the chemical symbol of this element.
     *
     * @return the element symbol
     */
    public String getSymbol() { 
        return symbol; 
    }
    /**
     * Returns the chemical formula of this element.
     *
     * @return the element formula
     */
    public String getFormula() { 
        return formula; 
    }
    /**
     * Returns the atomic mass of this element in grams per mole (g/mol).
     *
     * @return the atomic mass
     */
    public double getAtomicMass() { 
        return atomicMass; 
    }
    /**
     * Returns a hash code value for this element.
     * <p>
     * The hash code is computed based on all attributes of the element.
     * </p>
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.id;
        hash = 61 * hash + Objects.hashCode(this.name);
        hash = 61 * hash + Objects.hashCode(this.symbol);
        hash = 61 * hash + Objects.hashCode(this.formula);
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.atomicMass) ^ (Double.doubleToLongBits(this.atomicMass) >>> 32));
        return hash;
    }
    /**
     * Compares this element to the specified object.
     * <p>
     * Two {@code ChemicalElement} objects are considered equal if
     * all their attributes (id, name, symbol, formula, and atomic mass)
     * are equal.
     * </p>
     *
     * @param obj the object to compare with
     * @return {@code true} if this object is equal to the specified object;
     *         {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ChemicalElement other = (ChemicalElement) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.atomicMass) != Double.doubleToLongBits(other.atomicMass)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.symbol, other.symbol)) {
            return false;
        }
        return Objects.equals(this.formula, other.formula);
    }
    /**
     * Returns a string representation of this chemical element.
     * <p>
     * The format includes id, name, symbol, and atomic mass.
     * </p>
     *
     * @return a formatted string representing the element
     */
    @Override
    public String toString() {
        return id + " - " + name + " (" + symbol + "), "  + atomicMass + "g/mol\n";
    }
}
