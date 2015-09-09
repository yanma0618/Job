package Tree;

public class AvlTest {
	public static void main(String[] args){
		int[] arr ={1,2,3,4,5,6,7};
		
		AvlNode<AvlTypeImpl> rt=null;
		for(int n:arr){
			AvlTypeImpl tmp=new AvlTypeImpl(n);
			if(rt==null){
				rt =new AvlNode<AvlTypeImpl>(tmp);
			}else{
				rt=rt.insert(tmp, rt);
			}
		}
		rt.print(rt);
		rt.inorder(rt);
				
	}
}
