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
      if (current!=null) {
        if(!current.getChildren().containsKey(curKey.charAt(0))){
        current.getChildren().put(curKey.charAt(0), new TrieMapNode());
      }}
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
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    if (findNode(root,curKey)!=null) {
      return findNode(root, curKey).getValue();
    }
    return null;
  }

  //Indirectly recursive method to meet definition of interface
  public boolean containsKey(String key) {
     return (containsKey(root, key));
  }

  //Recursive method
  //Note: arguments are only a suggestion, you may use your own if you devise a different recursive solution
  public boolean containsKey(TrieMapNode current, String curKey) {
    if (findNode(root,curKey)!=null) {
      if(findNode(root, curKey).getValue()==curKey){
      return true;
    }}
    return false;
}

  //Indirectly recursive method to meet definition of interface
  public ArrayList<String> getKeysForPrefix(String prefix) {
    if (getSubtreeKeys(findNode(root, prefix))==null){
    return new ArrayList<String>(); }
    return (getSubtreeKeys(findNode(root, prefix)));
}

  //Recursive helper function to find node that matches a prefix
  public TrieMapNode findNode(TrieMapNode current, String curKey){
    if(current==null){
      return null;
    }
    if ((curKey.length() == 0)) {
      return (current);
      }
    return findNode(current.getChildren().get((curKey.charAt(0))),curKey.substring(1));
  }

  //Recursive helper function to get all keys in a node's subtree
  public ArrayList<String> getSubtreeKeys(TrieMapNode current) {
    ArrayList<String> words = new ArrayList<String>();
    if (current != null) {
      //loop through to check all the subnodes until they arr at the end node
      for (Character s : current.getChildren().keySet()) {
        //here we add all the children node in each node
        words.addAll(getSubtreeKeys(current.getChildren().get(s)));
      }
      //
      if ((!words.contains(current.getValue()))&&current.getValue()!=null){
        words.add(current.getValue());
      }
      if (current.getChildren() == null) {
        return words;
      }
    }
      return words;
  }
  //Indirectly recursive method to meet definition of interface
  public void print(){
     print(root);
  }
  
  //Recursive method to print values in tree
  public void print(TrieMapNode current){
     for (String s : getSubtreeKeys(current)){
      System.out.println(s);
    }
  }
  
  public static void main(String[] args){
    //You can add some code in here to test out your TrieMap initially
    //The TrieMapTester includes a more detailed test
  }
}