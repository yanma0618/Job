package OOD;

public class UserManager {
	private static UserManager instance=null;
	protected UserManager(){}
	public static UserManager getinstance(){
		if(instance == null){
			instance = new UserManager();
		}
		return instance;
	}
}
