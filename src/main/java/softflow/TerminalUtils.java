package softflow;

public class TerminalUtils {
  public static void limparTerminal() {
    String os = System.getProperty("os.name").toLowerCase();
    try{
      if(os.contains("win")){
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      }else{
        new ProcessBuilder("clear").inheritIO().start().waitFor();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}