package persistance.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import persistance.DatabaseConnection;
import model.ChemicalReaction;
/**
 * Data Access Object (DAO) responsible for retrieving
 * {@link ChemicalReaction} data from the database.
 * <p>
 * The {@code ChemicalReactionDAO} class communicates with the database
 * using {@link DatabaseConnection} and maps database records to
 * {@link ChemicalReaction} objects.
 * </p>
 * <p>
 * Each reaction includes the participating elements, product, reaction type,
 * description, and hazard information.
 * </p>
 * 
 * @author Lucas Fernandes
 */
public class ChemicalReactionDAO { 
    /**
     * Retrieves all chemical reactions from the database.
     * <p>
     * The method joins the {@code ChemicalReaction} table with the
     * {@code PeriodicTable} to map element IDs to their symbols,
     * then creates {@link ChemicalReaction} objects for each record.
     * </p>
     *
     * @return a list containing all {@link ChemicalReaction} objects
     *         retrieved from the database; returns an empty list if
     *         no reactions are found or an error occurs
     */
    public List<ChemicalReaction> getAllReactions() {
        List<ChemicalReaction> validReactions = new ArrayList<>();
        String sql = """
            SELECT 
                cr.productName,
                cr.reactionType,
                cr.productInfo,
                cr.hazardLevel,
                cr.hazardType,
                cr.HazardInfo,
                e1.symbol AS firstElement,
                e2.symbol AS secondElement
            FROM ChemicalReaction cr
            JOIN PeriodicTable e1 ON cr.firstElement = e1.id
            JOIN PeriodicTable e2 ON cr.secondElement = e2.id
            """;
        
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                ChemicalReaction validReaction = new ChemicalReaction(
                resultSet.getString("firstElement"),
                resultSet.getString("secondElement"),
                resultSet.getString("productName"),
                resultSet.getString("reactionType"),
                resultSet.getString("productInfo"),
                resultSet.getString("hazardLevel"),
                resultSet.getString("hazardType"),
                resultSet.getString("hazardInfo")
                );
                
                validReactions.add(validReaction);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }        
        return validReactions;
    }     
}
