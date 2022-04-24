import com.shedin.APIUtils;
import com.shedin.UIUtils;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class MainTest {
	public static final String URL = "https://gorest.co.in/";
	public static final String API_PATH = "public/v2/users";

	public static void main(String[] args) {
		assertNotNull(URL);
		UIUtils.openPage(URL);
		String response = APIUtils.sendGetRequest(URL + API_PATH);
		assertNotNull(response);
		System.out.println(response);
	}
}
