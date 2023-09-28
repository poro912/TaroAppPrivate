package TaroSystem;
// 싱글톤으로 작동
// 데이터를 모아놓는 공간
public class DataCenter {
	public static DataCenter instance;
	private static JsonParser json_instance;
	// 생성을 막아놓음
	private DataCenter(){}

	public DataCenter getInstance(){
		if (instance == null) {
			instance = new DataCenter();
		}
		return instance;
	}

	public void SaveResult(){

	}

	public void LoadResult(){

	}

	public void SaveAllResult(){

	}

	public void LoadAllResult(){

	}


}
