package model;
/**
 * Represents a chemical reaction between two chemical elements.
 * <p>
 * A {@code ChemicalReaction} defines the participating elements,
 * the resulting product, the type of reaction, a textual description,
 * and safety-related hazard information.
 * </p>
 *
 * @author Lucas Fernandes
 */
public class ChemicalReaction {
    private String firstElement;   
    private String secondElement;  
    private String productName;
    private String reactionType;
    private String description;
    private String hazardLevel;
    private String hazardType;
    private String hazardInfo;
    /**
     * Default constructor for {@code ChemicalReaction}.
     * <p>
     * Creates an empty reaction instance. Attributes can be initialized
     * later if needed.
     * </p>
     */
    public ChemicalReaction() {
    }
    /**
     * Constructs a {@code ChemicalReaction} with all attributes initialized.
     *
     * @param firstElement  the symbol of the first reactant element
     * @param secondElement the symbol of the second reactant element
     * @param productName   the name of the reaction product
     * @param reactionType  the type of chemical reaction (e.g., synthesis, combustion)
     * @param description   a textual description of the reaction
     * @param hazardLevel   the hazard severity level of the reaction
     * @param hazardType    the type/category of hazard involved
     * @param hazardInfo    additional safety or hazard information
     */
    public ChemicalReaction(String firstElement, String secondElement, String productName, String reactionType, String description, String hazardLevel, String hazardType, String hazardInfo) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
        this.productName = productName;
        this.reactionType = reactionType;
        this.description = description;
        this.hazardLevel = hazardLevel;
        this.hazardType = hazardType;
        this.hazardInfo = hazardInfo;
    }
    /**
     * Returns the symbol of the first reactant element.
     *
     * @return the first element symbol
     */
    public String getFirstElement() {
        return firstElement;
    }
    /**
     * Returns the symbol of the second reactant element.
     *
     * @return the second element symbol
     */
    public String getSecondElement() {
        return secondElement;
    }
    /**
     * Returns the name of the product formed in this reaction.
     *
     * @return the product name
     */
    public String getProductName() {
        return productName;
    }
    /**
     * Returns the type of this chemical reaction.
     *
     * @return the reaction type
     */
    public String getReactionType() {
        return reactionType;
    }
    /**
     * Returns the textual description of this reaction.
     *
     * @return the reaction description
     */
    public String getDescription() {
        return description;
    }
    /**
     * Returns the hazard severity level of this reaction.
     *
     * @return the hazard level
     */
    public String getHazardLevel() {
        return hazardLevel;
    }
    /**
     * Returns the type or category of hazard associated with this reaction.
     *
     * @return the hazard type
     */
    public String getHazardType() {
        return hazardType;
    }

    /**
     * Returns additional safety or hazard-related information.
     *
     * @return detailed hazard information
     */
    public String getHazardInfo() {
        return hazardInfo;
    }
    /**
     * Returns a string representation of this chemical reaction.
     * <p>
     * The format includes reactants, product, reaction type,
     * description, and hazard information.
     * </p>
     *
     * @return a formatted string describing the reaction
     */  
    @Override
    public String toString() {
        return  firstElement + " + " + secondElement + " -> " + productName + ", Reaction Type: " + reactionType + ", Description: " + description + ", Hazard Level: " + hazardLevel + ", Hazard Type: " + hazardType + ", Hazard Info: " + hazardInfo + '\n';
    }   
}
