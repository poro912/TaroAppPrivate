package TaroSystem;

//implementation 'com.fasterxml.jackson.core:jackson-databind:2.12.5' // 사용 가능한 최신 버전으로 업데이트

public class JsonParser {
	public static MyDataObject readJsonFile(Context context, String fileName) {
		ObjectMapper objectMapper = new ObjectMapper();
		AssetManager assetManager = context.getAssets();

		try {
			// Assets 폴더에서 JSON 파일을 읽어와 InputStream으로 열기
			InputStream inputStream = assetManager.open(fileName);

			// JSON 파일을 읽어와 Java 객체로 변환
			MyDataObject dataObject = objectMapper.readValue(inputStream, MyDataObject.class);

			// 읽어온 데이터 사용
			return dataObject;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
