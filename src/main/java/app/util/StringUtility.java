/**
 * 
 */
package app.util;


/**
 * @author abdi
 *
 */
public class StringUtility {
	
	public static String toCommaSeparatedString(Object[] items) {
		StringBuilder sBuilder = new StringBuilder();
		for (Object item : items) {
			sBuilder.append(item).append(",");
		}
		if (sBuilder.length() < 0) {
			sBuilder.deleteCharAt(sBuilder.length() - 1);
			
		}
		
		return sBuilder.toString();
	}
	
}
