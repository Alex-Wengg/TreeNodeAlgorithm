import java.util.ArrayList;
public class TrieMap implements TrieMapInterface {
  TrieMapNode root;
  int index = 0;

  public TrieMap() {
    root = new TrieMapNode();
  }

   public void put(String key, String value) {
    put(root, key, value);
  }

  public void put(TrieMapNode current, String curKey, String value) {
    if ((curKey.length() >= 1)) {
      if (current!=null) {
        if(!current.getChildren().containsKey(curKey.charAt(0))){
        current.getChildren().put(curKey.charAt(0), new TrieMapNode());
      }}
      put(current.getChildren().get(curKey.charAt(0)), curKey.substring(1), value);
    }
     if ((curKey.length() == 0)) {
      current.setValue(value);
     }
  }

  public String get(String key) {
    return (get(root, key));
  }
  public String get(TrieMapNode current, String curKey) {
     if (findNode(root,curKey)!=null) {
      return findNode(root, curKey).getValue();
    }
    return null;
  }

  public boolean containsKey(String key) {
     return (containsKey(root, key));
  }

   public boolean containsKey(TrieMapNode current, String curKey) {
    if (findNode(root,curKey)!=null) {
      if(findNode(root, curKey).getValue()==curKey){
      return true;
    }}
    return false;
}

   public ArrayList<String> getKeysForPrefix(String prefix) {
    if (getSubtreeKeys(findNode(root, prefix))==null){
    return new ArrayList<String>(); }
    return (getSubtreeKeys(findNode(root, prefix)));
}

   public TrieMapNode findNode(TrieMapNode current, String curKey){
    if(current==null){
      return null;
    }
    if ((curKey.length() == 0)) {
      return (current);
      }
    return findNode(current.getChildren().get((curKey.charAt(0))),curKey.substring(1));
  }

   public ArrayList<String> getSubtreeKeys(TrieMapNode current) {
    ArrayList<String> words = new ArrayList<String>();
    if (current != null) {
       for (Character s : current.getChildren().keySet()) {
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
   public void print(){
     print(root);
  }
  
   public void print(TrieMapNode current){
     for (String s : getSubtreeKeys(current)){
      System.out.println(s);
    }
  }
  
  public static void main(String[] args){

  }
}