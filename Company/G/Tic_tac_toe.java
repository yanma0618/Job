package G;

public class Tic_tac_toe {
	static char[][] board=new char[3][3];
	static int count=0;
	// * people # computer
	public static void main(String[] args) {
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				board[i][j]=' ';
			}
		}
		build('*');
		
		System.out.println(count);
	}
	
	static void build(char c){
		boolean flag= false;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(board[i][j]==' '){
					flag=true;
					if(c=='*'){
						board[i][j]='#';
						build('#');
						board[i][j]=' ';
						
					}else{
						board[i][j]='*';
						build('*');
						board[i][j]=' ';
					}
				}
			}
		}
		if(!flag){
			count++;
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					System.out.print(board[i][j]+ " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
	}
	
	
	static boolean isWin(int i, int j, char c){
		return false;
	}

}
