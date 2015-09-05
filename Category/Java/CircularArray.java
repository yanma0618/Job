package Java;

import java.util.Iterator;

public class CircularArray<T> implements Iterable<T>{
	private T[] items;
	private int head=0;
	public CircularArray(int size){
		items=(T[]) new Object[size];
	}
	
	private int covert(int index){
		if(index<0)
			index=items.length+index;
		return (head+index)%items.length; 
	}
	public void rotate(int shiftright){
		head=covert(shiftright);
	}
	
	public T get(int i){
		if(i<0 || i> items.length-1){
			throw new java.lang.IndexOutOfBoundsException("index out of bound");
		}
		return items[covert(i)];
	}
	
	public void set(T value, int i){
		items[covert(i)] = value;
	}

	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new CircularArrayIterator<T>(this);
		
	}
	
	private class CircularArrayIterator<TI> implements Iterator<TI>{
		private int _current=-1;
		private TI[] _items;
		
		public CircularArrayIterator(CircularArray<TI> array){
			_items=array.items;
		}
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return _current<items.length-1;
		}

		public TI next() {
			// TODO Auto-generated method stub
			_current++;
			TI item=(TI) _items[covert(_current)];
			return item;
		}

		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
		
	}
}
