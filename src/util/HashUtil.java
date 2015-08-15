import java.util.*;

public class HashUtil {
  public static int getHash(int key, int gen, int type, int m) {
    if(type == 1) return (key + gen) % m;
    else if(type == 2) return (key + gen * gen) % m;
    return (key + gen * (11 - key % 11)) % m;
  }
}
