import java.util.*;

public class P {

  // VARIABLES ================================================================
  // ==========================================================================

  /** Scanner object used to take in input */
  private static Scanner sc = new Scanner(System.in);
  // OBJECTS ------------------------------------------------------------------

  // METHODS ==================================================================
  // ==========================================================================
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

  // PRINT OUTPUT SIMPLE ------------------------------------------------------

  public static void bl() {
    P.l("------------------------------");
  }

  // PRINT OUTPUT STYLING -----------------------------------------------------

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

  // SIMPLE INPUT REQUEST -----------------------------------------------------

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

    P.nl();
    return choice;
  }

  /**
   * Prompt the user the expected format of an array input and returns a Vector
   * of that array
   * @return  user input in the form of an Integer Vector
   */
  public static Vector<Integer> getIntVector() {
    P.l("end with -1");
    P.l("i.e: 1 2 3 4 -1");
    P.il("Arr : ");
    // print message and instructions

    int raw;
    Vector<Integer> q = new Vector<Integer>();
    // prepare temp registers

    raw = P.getInt();
    while(raw != -1) {
      q.add(raw);
      raw = P.getInt();
    }
    // request till delimiter encountered

    return q;
  }

  /**
   * Returns a vector of lines of input
   */
  public static Vector<String> getLinesPasted() {
    Vector<String> lines = new Vector<String>();
    P.l("end with <enter>-1<enter>");
    do {
      lines.add(sc.nextLine());
    }while(!lines.lastElement().equalsIgnoreCase("-1"));
    if(lines.get(0).equalsIgnoreCase("")) lines.remove(0);
    lines.remove(lines.size() - 1);
    return lines;
  }

  public static Vector<Integer> getArrayFromLine() {
    P.l("numbers/NULL/, only. No []");

    Vector<Integer> arr = new Vector<Integer>();
    String str = P.getStrLine();
    if(str.equalsIgnoreCase("")) str = P.getStrLine();

    String[] parts = str.split("\\s+");
    if(parts.length == 1) parts = str.split(",");
    
    for(int i = 0; i < parts.length; i++) {
      String raw = parts[i].split(",")[0];
      raw = raw.equalsIgnoreCase("NULL") ? "0" : raw;
      arr.add(Integer.parseInt(raw));
    }
    return arr;
  }

  // COMPLEX COMPOUND ACTIONS -------------------------------------------------
}
