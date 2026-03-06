package persistance;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Utility class responsible for providing database connections.
 * <p>
 * The {@code DatabaseConnection} class manages the configuration
 * required to connect to the application's MySQL database.
 * It exposes a static method to obtain a {@link Connection} instance.
 * </p>
 * <p>
 * This class cannot be instantiated.
 * </p>
 *
 * @author Lucas Fernandes
 */
public class DatabaseConnection {
    /** Database connection URL. */
    private static final String URL = "jdbc:mysql://192.168.122.42:3306/chemistryLab";
    /** Database username. */
    private static final String USER = "admin";
    /** Database password. */
    private static final String PASSWORD = "eQ2.ysU6p!404\"";
    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private DatabaseConnection() {
    }

    /**
     * Establishes and returns a connection to the configured database.
     *
     * @return a {@link Connection} object representing a connection
     *         to the database
     * @throws SQLException if a database access error occurs or the
     *         connection cannot be established
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
