import java.util.*;

public class P {
  /** Scanner object used to take in input */
  private static Scanner sc = new Scanner(System.in);

  /**
   * Print out param and prepare next line
   * @param msg   argument
   */
  public static void l(String msg) {
    System.out.println(msg);
  }

  /**
   * Print out param in line
   * @param msg   argument
   */
  public static void il(String msg) {
    System.out.print(msg);
  }

  /**
   * Print out a blank new line
   */
  public static void nl() {
    System.out.println("");
  }

  /**
   * Prompt the user a header message and request user to make a selection
   * @param header    message
   * @param choices   variable length number of choices
   * @return  user integer input based on choice, choice will be snapped within
   * range of possible values if out of bounds
   */
  public static int getChoice(String header, String... choices) {
    StringBuilder border = new StringBuilder("+=");
    for(int i = 0; i < header.length(); i++) border.append("=");
    border.append("=+");
    P.l(border.toString());
    P.l("| " + header + " |");
    P.l(border.toString());
    // print header

    for(int i = 0; i < choices.length; i++) {
      P.l((i + 1) + ". " + choices[i]);
    }
    // print choices

    P.il("Choice : ");
    int choice = P.getInt();
    if(choice < 1) choice = 1;
    else if(choice > choices.length) choice = choices.length;
    // request and parse user input

    return choice;
  }

  /**
   * Get the next line of user input
   * @return user input
   */
  public static String getStrLine() {
    return sc.nextLine();
  }

  /**
   * Get the next string token
   * @return user input
   */
  public static String getStr() {
    return sc.next();
  }

  /**
   * Get the next integer token
   * @return user input
   */
  public static int getInt() {
    return sc.nextInt();
  }

  /**
   * Prompt the user the expected format of an array input and returns a Vector
   * of that array
   * @return  user input in the form of an Integer Vector
   */
  public static Vector<Integer> getIntVector() {
    P.l("Use -1 as delimiter");
    P.l("i.e: 1 2 3 4 -1");
    P.il("Arr : ");
    int raw;
    Vector<Integer> q = new Vector<Integer>();
    raw = P.getInt();
    while(raw != -1) {
      q.add(raw);
      raw = P.getInt();
    }
    P.nl();
    return q;
  }
}
