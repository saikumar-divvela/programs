
/**
 * 	Saikumar Divvela
 */

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

class EMPMessageUtil {

	private static Map<String, ResourceBundle> resBundleMap = new HashMap<String, ResourceBundle>();

	private static String bundleName ="MessagesBundle";

	private static String className = "com.motorola.messaging.exception.EMPMessageUtil";
		

	public static  String getMessage(int code) {
		return getMessage(String.valueOf(code));
	}

	public static String getMessage(String messageKey) {
		return getMessage(messageKey, null, null);
	}

	public static String getMessage(String messageKey, Locale locale) {
		return getMessage(messageKey, locale, null);
	}
	
	public static String getMessage(String messageKey, Object[] paramValues) {
		return getMessage(messageKey, Locale.getDefault(), paramValues);
	}
	
	public static String getMessage(String messageKey, Locale locale, Object[] paramValues) {
		Locale tempLocale = (locale == null) ? Locale.getDefault() : locale;
		String localeName = tempLocale.toString();
		if (resBundleMap.get(localeName) == null) {
			synchronized (EMPMessageUtil.class) {
				if (resBundleMap.get(localeName) == null) {
					System.out.println("resource bundle is empty:"+locale);
					if (locale == null) {
						resBundleMap.put(localeName, ResourceBundle.getBundle(bundleName));
					} else {
						resBundleMap.put(localeName, ResourceBundle.getBundle(bundleName, locale));
					}
				}
			}
		}
		String message = null;
		try {
			message = resBundleMap.get(localeName).getString(messageKey);
		} catch (RuntimeException e) {
			message = "Error while getting message for key "+messageKey+" please contact system administrator !!!";
		}
		if (paramValues != null && paramValues.length > 0) {
			message = MessageFormat.format(message, paramValues);
		}
		return message;
	}
	
	public String formatMessage(String msg) {
		String message = msg;
		int index = message.indexOf(":");
		if (message.startsWith("java")) {
			message = (index != -1) ? message.substring(index + 1) : message;
			//index = message.indexOf(":");
			//message = (index != -1) ? message.substring(0, index) : message;
		}/*else{
			message = (index != -1) ? message.substring(index + 1) : message;
			index = message.indexOf(":");
		}*/
		return message;
	}
	
	/*public static void main(String[] args){
		System.out.println(MessageFetcher.getInstance().getMessage(100));
	}*/

}

class EMPException extends Exception {
	private int errorCode;

	public EMPException(int errorCode){
		this("", errorCode);
	}
	
	public EMPException(String errorMessage,int errorCode){
		super(errorMessage);
		this.errorCode = errorCode;
	}
	
	public EMPException(Throwable th, int errorCode){
		super(th);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	
	public String getMessage(){
		String errMsg = super.getMessage();
		return "dummy";
	}
}

public class TestException
{
		public static void main(String args[]){
			int y;
			String x = null;
			try{
				try
				{
					System.out.println(EMPMessageUtil.getMessage("EMP_DELETE",Locale.PRC));
				}
				catch (Exception exp)
				{
					exp.printStackTrace();
					System.out.println("mesage:"+exp.getMessage());
					throw new EMPException(exp	,123);
				}	
			} 	catch(EMPException exp){
					exp.printStackTrace();
					System.out.println("Outer  EMP mesage:"+exp.getMessage());	
			}

		}
}