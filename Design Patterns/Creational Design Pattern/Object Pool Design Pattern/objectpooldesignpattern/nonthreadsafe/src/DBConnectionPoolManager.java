package objectpooldesignpattern.nonthreadsafe.src;

import java.util.ArrayList;
import java.util.List;

public class DBConnectionPoolManager {

    List<DBConnection> availableConnections = new ArrayList<>();
    List<DBConnection> usedConnections = new ArrayList<>();

    int INITIAL_POOL_SIZE = 3;
    int MAX_POOL_SIZE = 6;

    public DBConnectionPoolManager() {
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            availableConnections.add(new DBConnection());
            System.out.println("Creating new DB Connection and adding to pool, free pool size: " + availableConnections.size());
        }
    }

    public DBConnection getDBConnection() {
        if(availableConnections.isEmpty() && usedConnections.size() < MAX_POOL_SIZE) {
            availableConnections.add(new DBConnection());
            System.out.println("Creating new DB Connection and adding to pool, free pool size: " + availableConnections.size());
        } else if (availableConnections.isEmpty() && usedConnections.size() >= MAX_POOL_SIZE) {
            System.out.println("Can not create new DB Connection as max limit reached");
            return null;
        }

        DBConnection dbConnection = availableConnections.removeLast();
        usedConnections.add(dbConnection);
        System.out.println("Adding DB Connection into used pool, size is: " + usedConnections.size());
        return dbConnection;
    }

    public void releaseDBConnection(DBConnection dbConnection) {
        if (dbConnection != null) {
            usedConnections.remove(dbConnection);
            System.out.println("Removing DB Connection from use pool size: " + usedConnections.size());

            availableConnections.add(dbConnection);
            System.out.println("Adding DB Connection into free pool, size: " + availableConnections.size());
        }
    }
}
