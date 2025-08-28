package objectpooldesignpattern.threadsafe.src;

public class Main {
    public static void main(String[] args) {
        DBConnectionPoolManager poolManager = DBConnectionPoolManager.getInstance();

        DBConnection dbConnection1 = poolManager.getDBConnection();
        DBConnection dbConnection2 = poolManager.getDBConnection();
        DBConnection dbConnection3 = poolManager.getDBConnection();
        DBConnection dbConnection4 = poolManager.getDBConnection();
        DBConnection dbConnection5 = poolManager.getDBConnection();
        DBConnection dbConnection6 = poolManager.getDBConnection();
        DBConnection dbConnection7 = poolManager.getDBConnection();

        poolManager.releaseDBConnection(dbConnection1);
    }
}
