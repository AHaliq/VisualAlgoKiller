import java.util.*;
import java.lang.StringBuilder;
import util.*;

public class VisualAlgoKiller {

  public static void main(String[] args) {
    P.nl();
    P.l("===========================");
    P.l("Welcome to VisualAlgoKiller");
    P.l("===========================");
    P.l("===                     ===");
    P.l("=       by:FSociety       =");
    P.nl();
    // greeter

    int choice = P.getChoice("Select your topic type",
    "Linked List", "Recursion", "Sorting", "Hash Table");
    int choice2 = 1;
    // request topic

    String requestMsg = "Select your question type";
    switch(choice) {
      case 1:
      choice2 = P.getChoice(requestMsg,
      "Queue", "Singly Sum", "Stack");
      break;
      case 2:
      choice2 = P.getChoice(requestMsg,
      "TestFunction 1 param ", "TestFunction 2 param", "doSomethingCool");
      break;
      case 3:
      choice2 = P.getChoice(requestMsg,
      "How many X; this version sort", "Sequence", "Quicksort");
      break;
      case 4:
      choice2 = P.getChoice(requestMsg,
      "Suppose... Yes/No", "Suppose... table sequence", "Consider... m=12");
      break;
    }
    // request question

    P.nl();
    P.l("===========================");
    solver[choice - 1][choice2 - 1].solve();
    // execute solver based on user's choice
  }

  // View ---------------------------------------------------------------------

  interface Solver {
    void solve();
  }

  private static Solver[][] solver = new Solver[][] {
    new Solver[] { // Linked List
      new Solver() { public void solve() { // Queue
        P.l("Type the queue from peek to tail");
        Vector<Integer> q = P.getIntVector();
        // populate queue

        P.l("Type in the operations.");
        P.l("1 X : q.enqueue(X);");
        P.l("2   : q.dequeue();");
        P.l("-1  : end");
        // request operation type

        int raw = P.getInt();
        while(raw != -1) {
          if(raw == 1) {
            q.add(P.getInt());
          }else if(raw == 2){
            if(q.size() == 0) {
              break;
              // escape on dequeue of an empty
            }else {
              q.remove(0);
            }
          }
          raw = P.getInt();
        }
        // carry out operations

        P.il("Answer : ");
        if(q.size() == 0) {
          P.l("No Answer");
        }else {
          P.l(q.firstElement().toString());
        }
      }},
      new Solver() { public void solve() { // Singly Sum
        P.l("Type the array in bold");
        Vector<Integer> ll = P.getIntVector();
        // populate ll

        int pos = 0;
        int sum = 0;
        boolean error = false;

        P.l("Copy and paste here the pseudocode after");
        P.l("'Node n = list.head...' including 'print sum;'");
        P.l("and press enter");
        String raw = P.getStrLine();
        while(!raw.equalsIgnoreCase("print sum;"))
        {
          if(!error) {
            switch(raw) {
              case "n = list.head;":
              pos = 0;
              break;
              case "sum += list.head.value;":
              sum += ll.get(0);
              break;
              case "n = list.tail;":
              pos = ll.size() - 1;
              break;
              case "sum += list.tail.value;":
              sum += ll.get(ll.size() - 1);
              break;
              case "sum += n.value;":
              if(pos == ll.size()) error = true;
              else sum += ll.get(pos);
              break;
              case "n = n.next;":
              if(pos == ll.size()) error = true;
              else pos++;
              break;
              case "sum += n.next.value;":
              if(pos >= ll.size() - 1) error = true;
              else sum += ll.get(pos + 1);
              break;
            }
          }
          raw = P.getStrLine();
        }
        P.il("Answer : ");
        P.l((error ? "No Answer" : sum).toString());
      }},
      new Solver() { public void solve() { // Stack
        P.l("Type the st from peek to end");
        Vector<Integer> st = P.getIntVector();
        // populate st

        P.l("Type in the operations -1 to end.");
        P.l("1 X : st.push(X);");
        P.l("2   : st.pop();");
        P.l("-1  : end");

        int raw = P.getInt();
        boolean error = false;
        while(raw != -1) {
          if(raw == 1) {
            st.add(0, P.getInt());
          }else if(raw == 2) {
            if(st.size() == 0) {
              error = true;
              break;
            }else {
              st.remove(0);
            }
          }
          raw = P.getInt();
        }
        if(st.size() == 0) error = true;
        P.il("Answer : ");
        P.l((error ? "No Answer" : st.get(0)).toString());
      }}
    },
    new Solver[] { // Recursion
      new Solver() { public void solve() { // Single Param Test Function
        P.l("What is the argument? testFunction(X)");
        P.il("X : ");
        // this is actually fibonacci
        int nth = P.getInt();
        double phin = Math.pow((1 + Math.sqrt(5)) / 2, nth);
        double ans = (phin - (Math.pow(-1, nth) / phin)) / Math.sqrt(5);
        P.il("Answer : " + ((int) ans));
      }},
      new Solver() { // Two Param Test Function
        public void solve() {
          P.l("What are the arguments? testFunction(X,Y)");
          P.il("X Y : ");
          int ans = testFunction(P.getInt(), P.getInt());
          P.il("Answer : " + ans);
        }
        private int testFunction(int n, int k) {
          if(k == 0 || k == n) return 1;
          return testFunction(n - 1, k - 1) + testFunction(n - 1, k);
        }
      },
       new Solver() { public void solve() { // doSomethingCool
        P.l("Copy and paste the doSomethingCool");
        P.l("method here and press enter");

        P.getStrLine();
        String raw = P.getStrLine();
        int lineCount = 0;
        boolean innerLinear = false;
        int outerType = 0;
        // 0: 1, 1: O(inf), 2: n*
        while(!raw.equalsIgnoreCase("}"))
        {
          lineCount++;
          if(lineCount == 4 || lineCount == 5) { // linear O() if + -
            String[] parts = raw.split("\\s+");
            if(parts[9].equalsIgnoreCase("j++)") ||
            parts[9].equalsIgnoreCase("k--)") ||
            parts[10].equalsIgnoreCase("+=") ||
            parts[10].equalsIgnoreCase("-=")) {
                 innerLinear = true;
            }
          }else if(lineCount == 6) {
            String[] parts = raw.split("\\s+");
            raw = parts[2];
            raw = raw.substring(16, raw.length() - 1);
            if(raw.length() == 1) { // multiply 1 if < 3 else infinite
              if(raw.equalsIgnoreCase("n")) outerType = 1;
              else outerType = Integer.parseInt(raw) < 3 ? 0 : 1;
            }else { // if - is linear outer multiply else multiply 1
              outerType = raw.charAt(1) == '-' ? 2 : 0;
            }
          }
          raw = P.getStrLine();
        }
        P.il("Answer : ");
        if(outerType == 1) P.l("Infinite Loop");
        else if(outerType == 2 && innerLinear) P.l("O(n^2)");
        else if(outerType == 2 && !innerLinear) P.l("O(n log n)");
        else if(outerType == 0 && innerLinear) P.l("O(n)");
        else if(outerType == 0 && !innerLinear) P.l("O(log n)");
      }}
    },
    new Solver[] { // Sorting
      new Solver() { // How many X sort
        public void solve() {
          P.l("Type in the array in question");
          Vector<Integer> arr = P.getIntVector();
          // populate array

          P.l("How many _____");
          P.l("1 : passes\n2 : swaps\n3 : comparisons");
          int option = P.getInt();

          P.l("... using this version of _____ sort");
          P.l("1 : bubble\n2 : insertion");

          int type = P.getInt();
          int ans = 0;

          if(type == 1) {
            if(option == 2) ans = bubbleSwap(arr);
            else ans = option == 1 ? bubblePC(arr)[0] : bubblePC(arr)[1];
          }else {
            if(option == 3) ans = insertionComparisons(arr);
            // no insertion passes OR swaps question
          }

          P.il("Answers : ");
          P.l(ans+"");
        }
        private int bubbleSwap(Vector<Integer> arr) {
          int swapCount = 0;
          for(int j = 0; j < arr.size(); j++) {
            for(int i = 0; i < arr.size() - 1; i++) {
              if(arr.get(i) > arr.get(i + 1)) {
                int temp = arr.get(i);
                arr.set(i, arr.get(i+1));
                arr.set(i + 1, temp);
                swapCount++;
              }
            }
          }
          return swapCount;
        }
        private int[] bubblePC(Vector<Integer> arr) {
          int[] count = {0, 0};
          int j = 0;
          boolean swapped ;
          do {
            swapped = false;
            j++;
            for(int i = 0; i < arr.size() - j; i++) {
              count[1]++;
              if(arr.get(i) > arr.get(i+1)) {
                int temp = arr.get(i);
                arr.set(i, arr.get(i+1));
                arr.set(i+1, temp);
                swapped = true;
              }
            }
            count[0]++;
          }while(swapped);
          return count;
        }
        private int insertionComparisons(Vector<Integer> arr) {
          int compCount = 0;
          for(int i = 1; i < arr.size(); i++) {
            int e = arr.get(i);
            int j = i;
            inner:while(j > 0) {
              compCount++;
              if(arr.get(j-1) > e) {
                arr.set(j, arr.get(j-1));
              }else {
                break inner;
              }
              j--;
            }
            arr.set(j, e);
          }
          return compCount;
        }
      },
      new Solver() { // sequence after passes
        public void solve() {
          P.l("Type in the array in question");
          Vector<Integer> arr = P.getIntVector();
          // populate array
          P.l("Type in the number of passes");
          int passes = P.getInt();
          // get pass amount
          P.l("...this version of ____ sort");
          P.l("1 : Bubble\n2 : Insertion\n3 : Selection");
          int type = P.getInt();
          // get sort type

          if(type == 1) arr = bubblePass(passes, arr);
          else if(type == 2) arr = insertionPass(passes, arr);
          else if(type == 3) arr = selectionPass(passes, arr);

          P.il("Answer : ");
          for(int i : arr) {
            P.il(i + " ");
          }
          P.nl();
        }
        private Vector<Integer> insertionPass(int pass, Vector<Integer> arr) {
          for(int i = 1; i <= pass; i++) {
            int e = arr.get(i);
            int j = i;
            while(j > 0) {
              if(arr.get(j - 1) > e) {
                arr.set(j, arr.get(j - 1));
              }else {
                break;
              }
              j--;
            }
            arr.set(j, e);
          }
          return arr;
        }
        private Vector<Integer> selectionPass(int pass, Vector<Integer> arr) {
          for(int i = 0; i < pass; i++) {
            int cur_min = i;
            for(int j = i + 1; j < arr.size(); j++) {
              if(arr.get(j) < arr.get(cur_min)) {
                cur_min = j;
              }
            }
            int temp = arr.get(i);
            arr.set(i, arr.get(cur_min));
            arr.set(cur_min, temp);
          }
          return arr;
        }
        private Vector<Integer> bubblePass(int pass, Vector<Integer> arr) {
          for(int j = 0; j < pass; j++) {
            for(int i = 0; i < arr.size() - j - 1; i++) {
              if(arr.get(i) > arr.get(i+1)) {
                int temp = arr.get(i);
                arr.set(i, arr.get(i+1));
                arr.set(i+1, temp);
              }
            }
          }
          return arr;
        }
      },
      new Solver() { public void solve() { // quicksort
        P.l("Type in the array in question");
        Vector<Integer> arr = P.getIntVector();
        // populate array

        Vector<Integer> results = new Vector<Integer>();
        // initialize possible integers that may be pivots

        for(int i = 0 ; i < arr.size(); i++) {
          boolean valid = true;
          for(int j = 0; j < arr.size(); j++) {
            if((j < i && arr.get(j) >= arr.get(i)) ||
            (j > i && arr.get(j) < arr.get(i)))
              valid = false;
              // if any on left is larger or right is smaller
              // its definitely not a pivot
          }
          if(valid && results.indexOf(arr.get(i)) == -1) {
            results.add(arr.get(i));
          }
          // dont add again if integer already exists
        }
        P.l("Answer : " + results.size());
      }}
    },
    new Solver[] { // Hashing
      new Solver() { public void solve() { // Suppose Yes No
        P.l("What type of probe?");
        P.l("1 : Linear\n2 : Quadratic\n3 : sec 11 - k % 11");
        int type = P.getInt();
        P.l("What is the hash table size");
        int m = P.getInt();
        P.l("Enter the keys to insert");
        Vector<Integer> arr = P.getIntVector();

        int[] res = new int[m];
        for(int i : arr) {
          int index = 0;
          int count = 0;
          do
          {
            if(type == 1) index = (i + count) % m;
            else if(type == 2) index = (i + count * count) % m;
            else if(type == 3) index = (i + count * (11 - i % 11)) % m;
            count++;
          }while(res[index] != 0);
          res[index] =i;
        }

        P.il("Answer : ");
        for(int i : res) {
          P.il(((i == 0) ? "NULL" : i)+" ");
        }
        P.nl();
      }},
      new Solver() { // Suppose Table
        public void solve() {
          P.l("What type of probe?");
          P.l("1 : Linear\n2 : Quadratic\n3 : sec 11 - k % 11");
          int type = P.getInt();
          int m = 13;
          P.l("What is the key of to delete");
          int key = P.getInt();
          P.l("Write the hash table from head to tail, let null be 0");
          Vector<Integer> ht = P.getIntVector();

          Vector<Integer> probes = new Vector<Integer>();

          int count = 0;
          probes.add(getHash(key, 0, type, m));
          while (ht.get(probes.lastElement()) != key) {
              count++;
              probes.add(getHash(key, count, type, m));
          }
          P.il("Answer : ");
          for(int i : probes) {
            P.il(i +" ");
          }
          P.nl();
        }
        /** TODO duplicated in m 12, find out how to share */
        private int getHash(int key, int gen, int type, int m) {
          if(type == 1) return (key + gen) % m;
          else if(type == 2) return (key + gen * gen) % m;
          return (key + gen * (11 - key % 11)) % m;
        }
      },
      new Solver() { // Consdier m 12
        public void solve() {
          // this solver is expecting a length 12 HT
          P.l("What type of probe?");
          P.l("1 : Linear\n2 : Quadratic\n3 : sec 11 - k % 11");
          int type = P.getInt();
          int m = 12;
          P.l("Write the list of keys");
          Vector<Integer> keys = P.getIntVector();
          P.l("Write the hash table from head to tail, let null be 0");
          Vector<Integer> ht = P.getIntVector();

          int sortCount = 0;
          int gen = 0;
          boolean impossible = false;
          boolean gensFirstTime = true;
          boolean[] sortFlag = new boolean[m];
          Vector<Vector<Integer>> sorted = new Vector<Vector<Integer>>();

          do {
            sorted.add(new Vector<Integer>());

            boolean didntFindMatchYet = false;
            boolean manageToSort = false;
            boolean[] markToSort = new boolean[m];
            for(int i = 0; i < keys.size(); i++) {

              if(!sortFlag[i]) {
                // go through all unsorted

                if(ht.get(getHash(keys.get(i), gen, type, m)) == keys.get(i)) {
                  // if current generation hash matches hashtable

                  boolean canSortIn = false;
                  if(gen == 0) {
                    canSortIn = true;
                    // can sort in if first generation
                  }else {

                    int prevGenOccupantInd =
                    keys.indexOf(ht.get(getHash(keys.get(i), gen - 1, type, m)));
                    // get occupant index in keys of previous generation hash

                    if(prevGenOccupantInd != -1 && sortFlag[prevGenOccupantInd]) {
                      canSortIn = true;
                    }
                    // if collision exist in previous generation
                    // "prev gen slot is occupied by an already sorted key"
                  }

                  if(canSortIn) {
                    sorted.lastElement().add(keys.get(i));
                    markToSort[i] = true;
                    manageToSort = true;
                    sortCount++;
                  }
                  // sort into latest group and update flag
                }
              }else {
                didntFindMatchYet = true;
                // indicating slot may exist in future generations
              }
            }

            for(int i = 0; i < markToSort.length; i++) {
              if(markToSort[i]) sortFlag[i] = true;
            }
            // flush sorted flag, if immediate set and no flush it may cause
            // non causal another attempt; without gen advance to not trigger

            if((gensFirstTime && !manageToSort && !didntFindMatchYet) || gen == 12) {
              impossible = true;
              break;
            }
            // if this is the first time entering the generation and yet no
            // slot + prev gen collision matchup exist for a non slotted

            gensFirstTime = false;
            // mark attempting another round of current generation hash

            if(!manageToSort || gen == 0) {
              if(gen > 0) sorted.remove(sorted.size() - 1);
              // remove empty group as algo will create a new one on next
              // iteration and this one yielded nothing
              gen++;
              gensFirstTime = true;
            }
            // go to next generation if current generation hash
            // has no slot and prev gen collision matchup with sorted
          } while (sortCount < keys.size());

          P.il("Answer : ");
          if(impossible) P.l(" you copied smth wrong, its impossible");
          else {
            for(Vector<Integer> arr : sorted) {
              P.il("[");
              for(int i : arr) {
                P.il(i + " ");
              }
              P.il("] ");
            }
            P.nl();
            P.l("values in boxes can be in any order");
            P.l("boxes however must be in order");
          }
        }
        private int getHash(int key, int gen, int type, int m) {
          if(type == 1) return (key + gen) % m;
          else if(type == 2) return (key + gen * gen) % m;
          return (key + gen * (11 - key % 11)) % m;
        }
      }
    }
  };

  // Model + Controller -------------------------------------------------------
}