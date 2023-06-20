package Utilities;


	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;


	public class configReader {

		private static Properties prop;

		/**
		 * This method is used to load the properties from config.properties file
		 * @return it returns Properties prop object
		 */
		public static Properties init_prop() {

			prop = new Properties();
			try {
				FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
				prop.load(ip);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return prop;

		}
		public static String getBrowserType() {
			String browser = prop.getProperty("browser");
			//Loggerload.info("Get property BrowserType");
			if (browser != null)
				return browser;
			else
				throw new RuntimeException("browser not specified in the Configuration.properties file.");
		}
		public static String getApplicationUrl() {
			String url = prop.getProperty("url");
			if (url != null)
				return url;
			else
				throw new RuntimeException("url not specified in the Configuration.properties file.");
		}

		public static String getHomePage() {
			String homeurl = prop.getProperty("homepage");
			if (homeurl != null)
				return homeurl;
			else
				throw new RuntimeException("Homeurl not specified in the Configuration.properties file.");
		}
		// Register
		public static String registerPageURL() {
			String url = prop.getProperty("registerurl");
			if (url != null)
				return url;
			else
				throw new RuntimeException("url not specified in the Configuration.properties file.");
		}

		// Signin
		public static String getLoginPage() {
			String loginurl = prop.getProperty("loginpage");
			if (loginurl != null)
				return loginurl;
			else
				throw new RuntimeException("Homeurl not specified in the Configuration.properties file.");
		}
		//ExcelPath
		public static String getexcelfilepath() {
			String excelfilelpath = prop.getProperty("excelfilepath");
			if (excelfilelpath != null)
				return excelfilelpath;
			else
				throw new RuntimeException("Excel file path not specified in the Configuration.properties file.");
		}
		public static String tryEditorURL() {
			String tryeditorurl = prop.getProperty("tryeditorurl");
			if (tryeditorurl != null)
				return tryeditorurl;
			else
				throw new RuntimeException("tryeditorurl not specified in the Configuration.properties file.");
		}
		public static String geturl(String pagename) {
			String url = prop.getProperty(pagename);
			if (url != null)
				return url;
			else
				throw new RuntimeException(pagename + " url not specified in the Configuration.properties file.");
		}



	}


