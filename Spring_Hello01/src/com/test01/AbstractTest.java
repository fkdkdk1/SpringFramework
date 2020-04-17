package com.test01;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class AbstractTest {
	
	public abstract String dayInfo();
	
	// singleton : 맨처음 만들 때 메모리에 적재되어 그 이후로 호출이 되면 새로 만들어지는게 아니라 메모리에 적재된 클라스가 응답된다. (예시 :  calendar클라스)
	public static AbstractTest getInstance() {
		
		GregorianCalendar cal = new GregorianCalendar();
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		switch(day) {
		case 1: return new Sunday();
		case 2: return new Monday();
		case 3: return new Tuesday();
		case 4: return new Wednesday();
		case 5: return new Thursday();
		case 6: return new Friday();
		case 7: return new Saturday();
		}
		
		return null;
	}
}
