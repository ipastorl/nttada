package org.nttdata.javat1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The type Bbdd connection.
 */
public class BBDDConnection {
    private static Connection connection = null;

    /**
     * Establece una conexión a la BDD
     *
     * @return Connection connection
     */
    public static Connection getConnection(){
        try{
            if (connection == null){
                // configura la conexión con BD, user, password, timezone
                connection = DriverManager.getConnection("jdbc:mysql://localhost/playfield?user=programacion&password=programacion"
                        + "&userUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetime=false&serverTimezone=UTC");
                System.out.println("================== Conexión establecida ===================");

           }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return connection;
    }

    /**
     * Cierra la conexión a la base de datos
     */
    public static void closeConnection(){
        try{
            if (connection != null){
                connection.close();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}

