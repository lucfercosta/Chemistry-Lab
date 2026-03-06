package persistance.dao;
import model.ChemicalElement;
import persistance.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Data Access Object (DAO) responsible for retrieving
 * {@link ChemicalElement} data from the database.
 * <p>
 * The {@code ChemicalElementDAO} class communicates with the database
 * using {@link DatabaseConnection} and maps database records to
 * {@link ChemicalElement} objects.
 * </p>
 *
 * @author Lucas Fernandes
 */
public class ChemicalElementDAO {
    /**
     * Maps the current row of the given {@link ResultSet}
     * to a {@link ChemicalElement} object.
     *
     * @param resultSet the result set positioned at a valid row
     * @return a {@link ChemicalElement} populated with data from the result set
     * @throws SQLException if a database access error occurs
     */
    private ChemicalElement getElement(ResultSet resultSet) throws SQLException {
    return new ChemicalElement(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("symbol"), resultSet.getString("formula"), resultSet.getDouble("atomicWeight"));
    }
    /**
     * Retrieves all chemical elements from the database.
     * <p>
     * The elements are selected from the {@code PeriodicTable} table
     * and ordered by their id.
     * </p>
     *
     * @return a list containing all {@link ChemicalElement} objects
     *         retrieved from the database; returns an empty list if
     *         no elements are found or an error occurs
     */
    public List<ChemicalElement> getAllElements() {
        List<ChemicalElement> allElements = new ArrayList<>();
        String query = "SELECT * FROM PeriodicTable ORDER BY id";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                allElements.add(getElement(resultSet));
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return allElements;
    }  
}