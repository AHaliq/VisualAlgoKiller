import java.util.*;
import java.lang.StringBuilder;
import util.*;
import bots.*;

public class VisualAlgoKiller {

  public static void main(String[] args) {
    P.nl();
    // document style length 30 chars
    P.l("==============================");
    P.l(" Welcome to VisualAlgoKiller! ");
    P.l("==============================");
    P.l("====                      ====");
    P.l("=        by: FSociety        =");
    P.nl();
    // greeter

    boolean repeat = false;
    do {

      int choice = P.getChoice(
          "  Select your topic type  ",
            "Linked List",
            "Recursion",
            "Sorting",
            "Hash Table", 
            "Binary Heap");
      int choice2 = 1;
      // request topic

      String requestMsg =
          "Select your question type ";
      switch(choice) {
        case 1:
          choice2 = P.getChoice(requestMsg,
            "Queue",
            "Singly Sum",
            "Stack");
        break;
        case 2:
          choice2 = P.getChoice(requestMsg,
            "TestFunction 1 param ",
            "TestFunction 2 param",
            "doSomethingCool");
        break;
        case 3:
          choice2 = P.getChoice(requestMsg,
            "How many X; this __ sort",
            "Sequence",
            "Quicksort");
        break;
        case 4:
          choice2 = P.getChoice(requestMsg,
            "Suppose... Yes/No",
            "Suppose... table sequence",
            "Consider... m=12");
        break;
        case 5:
          choice2 = P.getChoice(requestMsg,
            "What is the _ number of _");
        break;
      }
      // request question

      P.l("==============================");
      SolverWrapper.solver[choice - 1][choice2 - 1].solve();
      // execute solver based on user's choice

      P.bl();
      P.l("Solve another question? [y/n]");
      repeat = P.getNext().equalsIgnoreCase("y");
    }while(repeat);
  }
}
