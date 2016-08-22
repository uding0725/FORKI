package action;

public class HealthCheckSuppot {
	public int convertValue(String value1) {
		int conValue = 0;
		if (value1 != null) {
			conValue = Integer.parseInt(value1);
		}
		return conValue;
	}
	
	public int convertValue(String value1, String value2) {
		int conValue = 0;
		if (value2 != null) {
			conValue = Integer.parseInt(value2);
			return conValue;
		} else if (value1 != null) {
			conValue = Integer.parseInt(value1);
		}
		return conValue;
	}
	
	public int convertValue(String value1, String value2, String value3) {
		int conValue = 0;
		if (value3 != null) {
			conValue = Integer.parseInt(value3);
			return conValue;
		} else if (value2 != null) {
			conValue = Integer.parseInt(value2);
			return conValue;
		} else if (value1 != null) {
			conValue = Integer.parseInt(value1);
		}
		return conValue;
	}
	
	public int convertValue(String value1, String value2, String value3, String value4) {
		int conValue = 0;
		if (value4 != null) {
			conValue = Integer.parseInt(value4);
			return conValue;
		} else if (value3 != null) {
			conValue = Integer.parseInt(value3);
			return conValue;
		} else if (value2 != null) {
			conValue = Integer.parseInt(value2);
			return conValue;
		} else if (value1 != null) {
			conValue = Integer.parseInt(value1);
		}
		return conValue;
	}
	public int convertValue(String value1, String value2, String value3, String value4, String value5) {
		int conValue = 0;
		if (value5 != null) {
			conValue = Integer.parseInt(value5);
			return conValue;
		} else if (value4 != null) {
			conValue = Integer.parseInt(value4);
			return conValue;
		} else if (value3 != null) {
			conValue = Integer.parseInt(value3);
			return conValue;
		} else if (value2 != null) {
			conValue = Integer.parseInt(value2);
			return conValue;
		} else if (value1 != null) {
			conValue = Integer.parseInt(value1);
		}
		return conValue;
	}
	
	public int convertValue(String value1, String value2, String value3, String value4, String value5, String value6) {
		int conValue = 0;
		if (value6 != null) {
			conValue = Integer.parseInt(value6);
			return conValue;
		} else if (value5 != null) {
			conValue = Integer.parseInt(value5);
			return conValue;
		} else if (value4 != null) {
			conValue = Integer.parseInt(value4);
			return conValue;
		} else if (value3 != null) {
			conValue = Integer.parseInt(value3);
			return conValue;
		} else if (value2 != null) {
			conValue = Integer.parseInt(value2);
			return conValue;
		} else if (value1 != null) {
			conValue = Integer.parseInt(value1);
		}
		return conValue;
	}
}
