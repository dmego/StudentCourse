package cn.dmego.utils;

public class StringUtil {

	/**
	 * String转Int
	 * 
	 * @param str
	 * @return
	 */
	public static int StringToInt(String str) {
		int result = 0;
		try {
			result = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			result = 0;
			// e.printStackTrace();
		}
		return result;
	}

}
