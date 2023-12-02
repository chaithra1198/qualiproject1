package Utils;

public class wpsUtilsdemo {
	public static void main(String[] args) {
		String Projectpath=System.getProperty("user.dir");
		wpsUtils wps=new wpsUtils(Projectpath+"/src/main/java/com/qualiautopro/testdata/Testdata_wps.xlsx", "Login");
		wps.getRowcount();
		wps.getCelldataString(0, 0);
		wps.getCelldataNumber(1, 1);
	}
	

}
