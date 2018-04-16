import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ReflectPermission;
import java.util.Properties;

public class ReflectTest {
	//1ͨ�������ļ��ͷ�ɫ���ı������Ϊ
	//2ͨ����ɫԽ�����ͼ�飬����java������Ϣֻ�ڱ����������ã�������������Ϣ��ʧ
	
	
	public static void main(String[] args) {
		Properties properties = getProperties();
		
		String className = properties.getProperty("class_name");
		String fieldName = properties.getProperty("field_name");
		try {
			Class cla = Class.forName(className);
			Field field = cla.getDeclaredField(fieldName);
			field.setAccessible(true);
			Object obj = cla.newInstance();
			field.set(obj, "hellos");
			System.out.println(obj);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	private static Properties getProperties() {
		Properties properties = new Properties();
		
		try {
			FileReader fileReader = new FileReader(new File("d:/config.txt"));
			properties.load(fileReader);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		
		return properties;
	}

}
