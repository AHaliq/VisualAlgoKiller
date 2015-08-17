import java.util.*;

public class SolverWrapper {

  public static Solver[][] solver = new Solver[][] {
    new Solver[] { // Linked List
      new Solver() { public void solve() { // Queue
        P.l("Type queue from peek to tail.");
        Vector<Integer> q = P.getIntVector();
        P.bl();
        // populate queue

        P.l("Copy paste the code here");
        Vector<String> lines = P.getLinesPasted();
        // get pseudocode

        for(String lns : lines) {
          if(lns.charAt(2) == 'e') {
            lns = lns.substring(10);
            lns = lns.substring(0, lns.length() - 2);
            q.add(Integer.parseInt(lns));
          }else {
            if(q.size() == 0) {
              break;
            }else {
              q.remove(0);
            }
          }
        }
        P.bl();
        // carry out operations

        P.il("Answer : ");
        if(q.size() == 0) {
          P.l("No Answer");
        }else {
          P.l(q.firstElement().toString());
        }
        // print answer
      }},
      new Solver() { public void solve() { // Singly Sum
        P.l("Paste the array in bold");
        Vector<Integer> ll = P.getArrayFromLine();
        P.bl();
        // populate ll

        P.l("Copy paste the code here");
        Vector<String> lines = P.getLinesPasted();
        lines.remove(lines.size() - 1);
        for(int i = 0; i < 3; i++) lines.remove(0);
        P.bl();
        // get pseudocode

        int pos = 0;
        int sum = 0;
        boolean error = false;
        loop:for(String lns : lines) {
          switch(lns) {
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
              if(pos == ll.size()) {
                error = true;
                break loop;
              } else sum += ll.get(pos);
            break;
            case "n = n.next;":
              if(pos == ll.size()) {
                error = true;
                break loop;
              } else pos++;
            break;
            case "sum += n.next.value;":
              if(pos >= ll.size() - 1) {
                error = true;
                break loop;
              } else sum += ll.get(pos + 1);
            break;
          }
        }
        // carry out operations

        P.il("Answer : ");
        P.l((error ? "No Answer" : sum).toString());
        // print answer
      }},
      new Solver() { public void solve() { // Stack
        P.l("Type the st from peek to end");
        Vector<Integer> st = P.getIntVector();
        P.bl();
        // populate st

        P.l("Copy paste the code here");
        Vector<String> lines = P.getLinesPasted();
        // get pseudocode

        for(String lns : lines) {
          if(lns.charAt(4) == 'u') {
            lns = lns.substring(8);
            lns = lns.substring(0, lns.length() - 2);
            st.add(0, Integer.parseInt(lns));
          }else {
            if(st.size() == 0) {
              break;
            }else {
              st.remove(0);
            }
          }
        }
        P.bl();
        // carry out operations

        P.l("Answer : " + (st.size() == 0 ? "No Answer" : st.get(0)));
        // print answer
      }}
    },
    new Solver[] { // Recursion
      new Solver() { public void solve() { // Single Param Test Function
        // this is actually fibonacci
        P.l("What is the argument\nin testFunction(X)");
        P.il("X : ");
        int nth = P.getInt();
        P.bl();
        // get argument

        double phin = Math.pow((1 + Math.sqrt(5)) / 2, nth);
        double ans = (phin - (Math.pow(-1, nth) / phin)) / Math.sqrt(5);
        // calculate fibonacci sequence at argument

        P.il("Answer : " + ((int) ans));
      }},
      new Solver() { // Two Param Test Function
        public void solve() {
          // couldnt find out the mathematical equivalent
          // so im just gonna brute force it
          P.l("What are the arguments?\ntestFunction(X,Y)");
          P.il("X Y : ");
          int ans = testFunction(P.getInt(), P.getInt());
          P.bl();
          // get args and process

          P.il("Answer : " + ans);
          // print answer
        }
        private int testFunction(int n, int k) {
          if(k == 0 || k == n) return 1;
          return testFunction(n - 1, k - 1) + testFunction(n - 1, k);
        }
      },
      new Solver() { public void solve() { // doSomethingCool
        P.l("Copy paste the code here");
        Vector<String> lines = P.getLinesPasted();
        P.bl();
        // get pseudocode

        lines.remove(lines.size() -1);
        String outerLine = lines.lastElement();
        lines.remove(lines.size() - 1);
        for(int i = 0; i < 3; i++) lines.remove(0);
        // isolate lines of interest

        boolean innerLinear = false;
        int outerType = 0;
        // 0: 1, 1: O(inf), 2: n, 3: log(n)

        for(String lns : lines) {
          String[] parts = lns.split("\\s+");
          if(parts[9].equalsIgnoreCase("j++)") ||
          parts[9].equalsIgnoreCase("k--)") ||
          parts[10].equalsIgnoreCase("+=") ||
          parts[10].equalsIgnoreCase("-=")) {
               innerLinear = true;
          }
        }
        // process inner loops

        String[] parts = outerLine.split("\\s+");
        outerLine = parts[2];
        outerLine = outerLine.substring(16, outerLine.length() - 1);
        if(outerLine.length() == 1) {
          if(outerLine.equalsIgnoreCase("n")) outerType =1;
          else outerType = Integer.parseInt(outerLine) < 3 ? 0 : 1;
        }else {
          outerType = outerLine.charAt(1) == '-' ? 2 : 3;
        }
        // process outer line

        P.il("Answer : ");
        if(outerType == 1) P.l("Infinite Loop");
        else if(outerType == 2 && innerLinear) P.l("O(n^2)");
        else if((outerType == 2 && !innerLinear) || (outerType == 3 && innerLinear)) P.l("O(n log n)");
        else if(outerType == 0 && innerLinear) P.l("O(n)");
        else if(outerType == 0 && !innerLinear) P.l("O(log n)");
        else if(outerType == 3 && !innerLinear) P.l("O(log^2 n)");
        // print answer
      }}
    },
    new Solver[] { // Sorting
      new Solver() { // How many X sort
        public void solve() {
          P.l("How many _____ is/are");
          P.l("1 : passes\n2 : swaps\n3 : comparisons");
          int option = P.getInt();
          P.bl();
          // get quantity type

          P.l("Paste the array here");
          Vector<Integer> arr = P.getArrayFromLine();
          P.bl();
          // populate array

          P.l("...version of _____ sort");
          P.l("1 : bubble\n2 : insertion");
          int type = P.getInt();
          P.bl();
          // get sort type

          int ans = 0;
          if(type == 1) {
            if(option == 2) ans = bubbleSwap(arr);
            else ans = option == 1 ? bubblePC(arr)[0] : bubblePC(arr)[1];
          }else {
            if(option == 3) ans = insertionComparisons(arr);
            // no insertion passes OR swaps question
          }
          // select appropriate method

          P.l("Answers : " + ans);
          // print answer
        }

        /** Method as given from question */
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

        /** Method as given from question */
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

        /** Method as given from question */
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
          P.l("Paste the array here");
          Vector<Integer> arr = P.getArrayFromLine();
          P.bl();
          // populate array

          P.l("Type in the number of passes");
          int passes = P.getInt();
          P.bl();
          // get pass amount

          P.l("...this version of ____ sort");
          P.l("1 : Bubble\n2 : Insertion\n3 : Selection");
          int type = P.getInt();
          P.bl();
          // get sort type

          if(type == 1) arr = bubblePass(passes, arr);
          else if(type == 2) arr = insertionPass(passes, arr);
          else if(type == 3) arr = selectionPass(passes, arr);
          // select method to process

          P.il("Answer : ");
          for(int i : arr) {
            P.il(i + " ");
          }
          P.nl();
          // print answer
        }

        /** method from question */
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

        /** method from question */
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

        /** method from question */
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
        P.l("Paste the array here");
        Vector<Integer> arr = P.getArrayFromLine();
        P.bl();
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
        // process array

        P.l("Answer : " + results.size());
        // print answer
      }}
    },
    new Solver[] { // Hashing
      new Solver() { public void solve() { // Suppose Yes No
        P.l("What type of probe?");
        P.l("1 : Linear\n2 : Quadratic\n3 : sec 11 - k % 11");
        int type = P.getInt();
        P.bl();
        // get probing type

        P.l("What is the hash table size");
        int m = P.getInt();
        P.bl();
        // get table size

        P.l("Paste the keys to insert");
        Vector<Integer> arr = P.getArrayFromLine();
        P.bl();
        // get keys

        P.l("Paste the results");
        Vector<Integer> resQ = P.getArrayFromLine();
        P.bl();
        // get results

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
        // calculate results from keys

        boolean correct = true;
        for(int i = 0 ; i < res.length; i ++) {
          if(res[i] != resQ.get(i)) {
            correct = false;
            break;
          }
        }
        // compare with results

        P.il("Answer : " + (correct ? "Yes" : "No"));
        P.nl();
        // print answer
      }},
      new Solver() { // Suppose Table
        public void solve() {
          P.l("What type of probe?");
          P.l("1 : Linear\n2 : Quadratic\n3 : sec 11 - k % 11");
          int type = P.getInt();
          P.bl();
          // get type

          int m = 13;

          P.l("What is the key of to delete");
          int key = P.getInt();
          P.bl();
          // get key

          P.l("Paste the table 2nd row");
          Vector<Integer> ht = P.getArrayFromLine();
          P.bl();
          // get keys

          Vector<Integer> probes = new Vector<Integer>();
          int count = 0;
          probes.add(HashUtil.getHash(key, 0, type, m));
          while (ht.get(probes.lastElement()) != key) {
              count++;
              probes.add(HashUtil.getHash(key, count, type, m));
          }
          // calculate probe sequence

          P.il("Answer : ");
          for(int i : probes) {
            P.il(i +" ");
          }
          P.nl();
          // print answer
        }
      },
      new Solver() { public void solve() { // Consdier m 12
        // this solver is expecting a length 12 HT
        P.l("What type of probe?");
        P.l("1 : Linear\n2 : Quadratic\n3 : sec 11 - k % 11");
        int type = P.getInt();
        // get probe type

        int m = 12;

        P.l("Paste the keys array (not table)");
        Vector<Integer> keys = P.getArrayFromLine();
        P.bl();
        // get keys

        P.l("Paste the table");
        Vector<Integer> ht = P.getArrayFromLine();
        P.bl();
        // get hash table

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

              if(ht.get(HashUtil.getHash(keys.get(i), gen, type, m)) ==
              keys.get(i)) {
                // if current generation hash matches hashtable

                boolean canSortIn = false;
                if(gen == 0) {
                  canSortIn = true;
                  // can sort in if first generation
                }else {

                  int prevGenOccupantInd =
                  keys.indexOf(ht.get(
                  HashUtil.getHash(keys.get(i), gen - 1, type, m)));
                  // get occupant index in keys of previous generation hash

                  if(prevGenOccupantInd != -1 && sortFlag[prevGenOccupantInd]) {
                    canSortIn = true;
                  }
                  // if collision exist in previous generation
                  // "prev gen slot is occupied by an already sorted key"
                }

                if(canSortIn) {
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
            if(markToSort[i]) {
              sorted.lastElement().add(keys.get(i));
              sortFlag[i] = true;
            }
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
        // generate potential sequences

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
        // print answer
      }}
    }
  };
}
