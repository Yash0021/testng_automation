package dummy.constants;

//import java.nio.charset.Charset;

import org.apache.commons.lang3.RandomStringUtils;

public class InputParameters {
	public static final String firstName = "john";
	public static String lastName = "Doe";
	public static final String stateName = "California";
	public static final String cityName = "Silicon Valley";
	public static final String postalCode = "90001";
	public static final String emailAddress = "john.doe@joh.com";
	
	public static final String category = "men";
	
	public static final String registerPassword = "secure_password";
    public static final String randomString = RandomStringUtils.randomAlphanumeric(6).toLowerCase();
}
