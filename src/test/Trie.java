package test;

import java.util.HashMap;





public class Trie {
	class TrieNode {
	    
	    

	    char c;
	    HashMap<Character, TrieNode> children=new HashMap<Character,TrieNode>();
	    boolean isLeaf;
	    // Initialize your data structure here.
	    public TrieNode(){}
	    
	    public TrieNode(char c){
	      this.c=c;
	      isLeaf=false;
	    }
	}

	
	
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        HashMap<Character, TrieNode> children=root.children;
        TrieNode node=null;

        for(int i=0;i<word.length();i++){
          char c=word.charAt(i);

          if(children.containsKey(c)){
            node=children.get(c);
          }else{
            node=new TrieNode(c);
            children.put(c,node);
          }
          children=node.children;
        }
        node.isLeaf=true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode res = searchNode(word);

        if(res!=null && res.isLeaf){
          return true;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return (searchNode(prefix)!=null)?true:false;
    }

    public TrieNode searchNode(String str){
      HashMap<Character, TrieNode> children=root.children;
      TrieNode res=null;
      for(int i=0;i<str.length();i++){
        char c = str.charAt(i);

        if(!children.containsKey(c)){
          return null;
        }

        res = children.get(c);
        children = res.children;
      }
      return res;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");