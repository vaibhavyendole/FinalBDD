package utility;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropReader {
	
	public String readPropData(String propToBeRead ) throws IOException
	{
		Properties prop = new Properties();
		String  pathOfConfig= System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
		FileInputStream fis = new FileInputStream(pathOfConfig);
		prop.load(fis);
		String Value = prop.getProperty(propToBeRead);
		
		System.out.println(Value);
		
		return Value;
	}
	
//	public static void main(String[] args) throws IOException
//	{
//		PropReader pr = new PropReader();
//		pr.readPropData("browser");
//	}
}
