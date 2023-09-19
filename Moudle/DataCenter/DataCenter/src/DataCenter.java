public class DataCenter {
    static public DataCenter instance;

    private DataCenter()
    {

    }

    public static DataCenter getInstance()
    {
        if(instance == null)
        {
            instance = new DataCenter();
        }
        return instance;
    }
}
