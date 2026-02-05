public class Main {
    public static void main(String[] args) {
        DatabaseManager db1 = DatabaseManager.getInstance();
        
        DatabaseManager db2 = DatabaseManager.getInstance();

        System.out.println(db1 == db2);
    }
}