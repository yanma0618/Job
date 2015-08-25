package chapter3;

public class Cat extends Animal{
	public Cat(String n){
		super(n);
	}
	@Override
	public void shout(){
		System.out.println("miao");
	}
}
