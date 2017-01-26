import java.io.PrintWriter;

public class fileGeneratorCustom {
    public static void main(String[] args) {
        int numberOfNumbers = Integer.parseInt(args[0]);
        try{
            PrintWriter writer = new PrintWriter("fileGeneratorCustom.txt", "UTF-8");
            for (int i = 0; i < numberOfNumbers; i++) {
                writer.println(Integer.toString((int) (Math.random() * 1000000)));
            }
            writer.close();
        } catch (Exception e) {
           // do something
        }
    }
}
