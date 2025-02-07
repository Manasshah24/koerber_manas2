package com.java9.features;
//private method inside an interface
//interface Foof{
//}
 interface Java8DBLogging
{
    default void logInfo(String message)
    {
        logDebug("This is LogInfo Message");
    }

    default void logWarn(String message)
    {
        logDebug("This is Log warning Message");
    }

    default void logError(String message)
    {
       logDebug("This is Log error Message");
    }

    private void logDebug(String message)
    {
        System.out.println(" Step1: Connect to DataBase");
        System.out.println(" Setp2: Log Debug Message");
        System.out.println("Setp3: Close the DataBase connection");
    }

}

public class A_PrivateMethodInsideInterface {
    public static void main(String[] args) {

    }
}
















