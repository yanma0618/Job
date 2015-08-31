package G;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Serialize_n_ary_tree {

	public static void main(String[] args) {
		MTreeNode root=new MTreeNode(0);
		root.children.add(new MTreeNode(1));
		root.children.add(new MTreeNode(2));
		root.children.get(0).children.add(new MTreeNode(3));
		root.children.get(0).children.add(new MTreeNode(4));
		root.children.get(0).children.get(0).children.add(new MTreeNode(5));
		serialize(root);
		print(root);
		System.out.println("after serizied");
		root=deserialize();
		print(root);
		
	}
	
	
	static void print(MTreeNode root){
		LinkedList<MTreeNode> q= new LinkedList<MTreeNode>();
		q.add(root);
		while(!q.isEmpty()){
			LinkedList<MTreeNode> p= new LinkedList<MTreeNode>();
			for(MTreeNode n:q){
				System.out.print(n.val+" ");
				if(n.children.size()>0){
					for(MTreeNode c:n.children){
						p.add(c);
					}
				}
			}
			System.out.println();
			q=p;
		}
		System.out.println();
	}
	
	static void serialize(MTreeNode root) {
		List<ByteBuffer> list = new ArrayList<ByteBuffer>();

		Queue<MTreeNode> queue = new LinkedList<MTreeNode>();
		queue.add(root);
		list.add(ByteBuffer.allocate(4).putInt(root.val));
		
		while (!queue.isEmpty()) {
			MTreeNode r = queue.poll();
			List<MTreeNode> child = r.children;
			if (child != null && child.size() > 0) {
				list.add(ByteBuffer.allocate(4).putInt(child.size()));
				for (MTreeNode n : child) {
					list.add(ByteBuffer.allocate(4).putInt(n.val));
					queue.add(n);
				}
			} else {
				list.add(ByteBuffer.allocate(4).putInt(0));
			}
		}
		
		write_file(list);

	}
	
	static List<Integer> readByte(){
		Path path=Paths.get("test.txt");
		List<Integer> ret = new ArrayList<Integer>();
		try {
			byte[] data= Files.readAllBytes(path);
			ByteBuffer buf=ByteBuffer.wrap(data);
			
			for(int i=0;i<buf.capacity();i+=4){
				ret.add(buf.getInt(i));
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	static MTreeNode deserialize(){
		List<Integer> list = readByte();
		Queue<MTreeNode> queue = new LinkedList<MTreeNode>();
		int index=0;
		MTreeNode root= new MTreeNode(list.get(index++));
		queue.add(root);
		while(!queue.isEmpty()){
			MTreeNode r= queue.poll();
			int size = list.get(index++);
			while(size>0){
				MTreeNode c= new MTreeNode(list.get(index++));
				r.children.add(c);
				queue.add(c);
				size--;
			}
		}
		return root;
		
	}
	
	
	static void write_file(List<ByteBuffer> buffer){
		FileOutputStream fop=null;
		File file;
		
		try{
			file = new File("test.txt");
			fop=new FileOutputStream(file);
			
			if(!file.exists()){
				file.createNewFile();
			}
			for(ByteBuffer b:buffer){
				System.out.print(b.getInt(0)+" ");
				fop.write(b.array());
			}
			
			fop.flush();
			fop.close();
			System.out.println("done");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	

}
