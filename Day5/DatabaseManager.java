public class DatabaseManager {
    private static volatile DatabaseManager instance;

    private DatabaseManager() {
        System.out.println("Database Connection Initialized.");
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            synchronized (DatabaseManager.class) {
                if (instance == null) {
                    instance = new DatabaseManager();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from the Singleton instance!");
    }
}