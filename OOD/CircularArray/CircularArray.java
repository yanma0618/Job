package CircularArray;

import java.util.Iterator;

public class CircularArray<T> implements Iterable<T>{
	private T[] items;
	private int head=0;
	
	public CircularArray(int size){
		items= (T[]) new Object[size];
	}
	
	private int convert(int index){
		if(index<0){
			index+=items.length;
		}
		return (head+index)%items.length;
	}
	
	public void rotate(int shiftlen){
		head = (head+items.length-shiftlen)%items.length;
//		head= convert(shiftlen);
	}
	
	public T get(int i){
		if(i<0 || i>items.length-1){
			System.out.println("out of bound");
		}
		return items[convert(i)];
	}
	
	public void set(int i ,T item){
		items[convert(i)]=item;
	}

	@Override
	public Iterator<T> iterator() {
		
		return new CircularArrayIterator<T>(this);
	}
	
	private class CircularArrayIterator<TI> implements Iterator<TI>{
		private int _current=-1;
		private TI[] _items;
		
		public CircularArrayIterator(CircularArray<TI> array){
			_items = array.items;
		}
		@Override
		public boolean hasNext() {
			
			return _current<items.length-1;
		}

		@Override
		public TI next() {
			_current++;
			TI item = (TI) _items[convert(_current)];
			return item;
		}
		
	}
}


