//Note: All of your TrieMapInterface method implementations must function recursively
//I have left the method signatures from my own solution, which may be useful hints in how to approach the problem
//You are free to change/remove/etc. any of the methods, as long as your class still supports the TrieMapInterface
import java.util.ArrayList;
public class TrieMap implements TrieMapInterface {
  TrieMapNode root;
  int index = 0;

  public TrieMap() {
    root = new TrieMapNode();
  }

  //Indirectly recursive method to meet definition of interface
  public void put(String key, String value) {
    put(root, key, value);
  }

  //Recursive method
  //Note: arguments are only a suggestion, you may use your own if you devise a different recursive solution
  public void put(TrieMapNode current, String curKey, String value) {
    if ((curKey.length() >= 1)) {
      if (!current.getChildren().containsKey(curKey.charAt(0))) {
        current.getChildren().put(curKey.charAt(0), new TrieMapNode());
      }
      put(current.getChildren().get(curKey.charAt(0)), curKey.substring(1), value);
    }
    //this is a issue with ==1
    if ((curKey.length() == 0)) {
      current.setValue(value);
      // System.out.println("["+value+"    "+curKey.charAt(0)   +"    " +current.getValue());
    }
  }

  //Indirectly recursive method to meet definition of interface
  public String get(String key) {
    return (get(root, key));
  }

  //Recursive method
  public String get(TrieMapNode current, String curKey) {
    //System.out.println(current.getValue());
    if (current.getValue() == curKey) {
      return curKey;
    }
    get(current.getChildren().get(curKey.charAt(index + 1)), curKey);
    return "";
  }

  //Indirectly recursive method to meet definition of interface
  public boolean containsKey(String key) {
    return (containsKey(root, key));
  }
  //System.out.println(current.getValue());

  //Recursive method
  //Note: arguments are only a suggestion, you may use your own if you devise a different recursive solution
  public boolean containsKey(TrieMapNode current, String curKey) {
    if (current.getValue() == curKey) {
      return true;
    } else if (current.getValue() == curKey) {

    }
    get(current.getChildren().get(curKey.charAt(index + 1)), curKey);
    return false;
}
  //Indirectly recursive method to meet definition of interface
  public ArrayList<String> getKeysForPrefix(String prefix){

    return new ArrayList<String>();
  }
  
  //Recursive helper function to find node that matches a prefix
  //Note: only a suggestion, you may solve the problem is any recursive manner
  public TrieMapNode findNode(TrieMapNode current, String curKey){

    System.out.println();

    return null;
  }
  
  //Recursive helper function to get all keys in a node's subtree
  //Note: only a suggestion, you may solve the problem is any recursive manner
  public ArrayList<String> getSubtreeKeys(TrieMapNode current){

    return new ArrayList<String>();
  }
  
  //Indirectly recursive method to meet definition of interface
  public void print(){
    
  }
  
  //Recursive method to print values in tree
  public void print(TrieMapNode current){
    
  }
  
  public static void main(String[] args){
    //You can add some code in here to test out your TrieMap initially
    //The TrieMapTester includes a more detailed test
  }
}