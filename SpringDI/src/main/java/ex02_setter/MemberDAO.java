package ex02_setter;

public class MemberDAO {
	private MyDataSource myDataSource;
	
	//setter 주입
	public void setMyDataSource(MyDataSource myDataSource) {
		this.myDataSource = myDataSource;
	}
	
	//getter
	public MyDataSource getMyDataSource() {
		return myDataSource = myDataSource;
	}
	
	
}

//DAO가 만들어질때 DataSource 가 필요하고, DB가 필요하다
//구현 시, 반대가 된다