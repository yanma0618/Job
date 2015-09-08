package OOD;

public enum Suit {
	club(0), diamond(1), heard(2), spade(3);
	private int value;
	private Suit(int i){
		this.value=i;
	}
	public int getValue() {
		return value;
	}
	
	
}
