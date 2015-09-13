package SL;

class Entry{
	String value;
	long time_stamp;

	public Entry(String value){
		this.value=value;
		this.time_stamp=System.currentTimeMillis();
	}
	
	public boolean isExpired(long expiration){
		return time_stamp+expiration < System.currentTimeMillis();
	}
	
}
