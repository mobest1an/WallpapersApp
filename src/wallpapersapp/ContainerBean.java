package wallpapersapp;

public class ContainerBean { //класс хранлище объекта менеджера базы данных (мб еще что-то добавится)

    private static String userName;
    
    private static DataBaseManager dbManager = new DataBaseManager();

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        ContainerBean.userName = userName;
    }

    public static DataBaseManager getDbManager() {
        return dbManager;
    }

    public static void setDbManager(DataBaseManager dbManager) {
        ContainerBean.dbManager = dbManager;
    }
}
