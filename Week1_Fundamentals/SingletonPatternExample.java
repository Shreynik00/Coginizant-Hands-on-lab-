package Week1_Fundamentals;
public class SingletonPatternExample {
   public static void main(String[] args) {
    Logger logger1 = Logger.getInstance();
    Logger logger2 = Logger.getInstance();
    System.out.println(logger1);
    System.out.println(logger2);
   } 
}
 class Logger
{
    private static Logger instance = new Logger();
    private Logger() {
       System.out.println("this is private contstrcutor Logger class");
    }
    public  static Logger getInstance()
    {
        return instance;
    }


}
