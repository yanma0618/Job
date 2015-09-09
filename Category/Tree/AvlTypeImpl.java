package Tree;

public class AvlTypeImpl implements IAvlType<AvlTypeImpl>{
	int val;
	
	public AvlTypeImpl(int val){
		this.val=val;
	}
	
	
	@Override
	public int compareTo(AvlTypeImpl element) {
		
		return Integer.compare(val, element.val);
	}


	@Override
	public void print() {
		System.out.print(val+" ");
	}

}
