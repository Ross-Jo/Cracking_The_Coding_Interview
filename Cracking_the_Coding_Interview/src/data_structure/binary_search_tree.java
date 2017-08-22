package data_structure;

import java.util.NoSuchElementException;

class BST_node <Key extends Comparable<Key>, Value>{
	private Key ky;
	private Value val;
	private BST_node left, right;
	private int N; // num of nodes in its subtree including itself
	
	public BST_node(Key newKey, Value newValue, int newN){
		this.ky = newKey;
		this.val = newValue;
		this.N = newN;
		this.left = null;
		this.right = null;
	}
	
	public int getN() {return N;}
	public Key getKey() {return ky;}
	public Value getValue() {return val;}
	public BST_node getLeft() {return left;}
	public BST_node getRight() {return right;}
	
	public void setN(int newN){N=newN;}
	public void setKet(Key newKey){ky=newKey;}
	public void setValue(Value newValue){val=newValue;}
	public void setLeft(BST_node newLeft){left=newLeft;}
	public void setRight(BST_node newRight){right=newRight;}
}

class BST<Key extends Comparable<Key>, Value>{
	
	private BST_node root;
	public BST_node getRoot(){return root;}
	
	public int size(){return size(root);}
	public int size(BST_node x){
		if(x==null) return 0;
		else return x.getN();
	}
	
	public BST(Key newKey, Value newValue){
		BST_node root = new BST_node(newKey, newValue, 1);
	}
	
	public boolean isEmpty(){return(size()==0);}
	
	public boolean contains(Key k){return get(k)!=null;}
	
	public Value get(Key k){return get(root, k);}
	
	public Value get(BST_node x, Key k){
		if(x==null) return null; // k is not found
		
		int t = x.getKey().compareTo(k);
		
		if(t>0) return get(x.getLeft(), k); // if k is smaller, go to left
		else if(t<0) return get(x.getRight(), k);
		else return (Value) x.getValue();
	}
	
	public void put(Key k, Value v){
		root = put(root, k, v);
	}
	
	public BST_node put(BST_node x, Key k, Value v){
		if(x == null) return new BST_node(k,v,1);
		
		int t = x.getKey().compareTo(k);
		
		if(t>0) x.setLeft(put(x.getLeft(), k, v));
		else if(t<0) x.setRight(put(x.getRight(), k, v));
		else x.setValue(v); // update with v
		
		x.setN(1+size(x.getLeft())+size(x.getRight()));
		
		return x;
	}
	
	public Key min(){
		if(isEmpty()) return null;
		return (Key) min(root).getKey();
	}
	
	public BST_node min(BST_node x){
		if(x.getLeft()==null) return x;
		return min(x.getLeft());
	}
	
	public void deleteMin(){
		if(isEmpty()) throw new NoSuchElementException("underflow");
		root = deleteMin(root);
	}
	
	public BST_node deleteMin(BST_node x){
		if(x.getLeft()==null) return x.getRight();
		x.setLeft(deleteMin(x.getLeft()));
		x.setN(1+size(x.getLeft())+size(x.getRight()));
		return x;
	}
	
	public void delete(Key k) {root = delete(root, k);}
	public BST_node delete(BST_node x, Key k){
		if(x==null) return null;
		int t = x.getKey().compareTo(k);
		
		if(t>0) x.setLeft(delete(x.getLeft(), k));
		else if(t<0) x.setRight(delete(x.getRight(), k));
		else{
			if(x.getRight() == null) return x.getLeft();
			if(x.getLeft() == null) return x.getRight();
			BST_node target = x;
			x = min(target.getRight());
			x.setRight(deleteMin(target.getRight()));
			x.setLeft(target.getLeft());
		}
		x.setN(1+size(x.getLeft())+size(x.getRight()));
		return x;
	}
	
	public void inorder(BST_node x){
		if(x!=null){
			if(x.getLeft()!=null) inorder(x.getLeft());
			System.out.println("("+x.getKey()+""+x.getValue()+")");
			if(x.getRight()!=null) inorder(x.getRight());
		}
	}
}

public class binary_search_tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
