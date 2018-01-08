package main;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/** 
* @author 娴ｆ粏锟斤拷 : pepper
* @version 閸掓稑缂撻弮鍫曟？閿涳拷2017楠烇拷8閺堬拷10閺冿拷 娑撳宕�1:32:26 
* @decription 缁槒顕╅弰锟� 閿涳拷
*/
public class MDataGernarator {
	//閼割亞褰崣椋庢晸閹达拷
	public static String getRandomString(int Minlength,int Maxlength) { //length鐞涖劎銇氶悽鐔稿灇鐎涙顑佹稉鑼畱闂�鍨
	    String base = "'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz1234567890";   
	    Random random = new Random();
	    int length = random.nextInt(Maxlength)%(Maxlength-Minlength+1) + Minlength;
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();   
	 } 
	public static String getRandomValue(String str,String sign){
		String[] ss=str.split(sign);
		Random random = new Random();
		return ss[random.nextInt(ss.length)];	
	}
	public static String getBirthday(int ageYear, int ageMonth, int ageDay) {
	    Calendar c = Calendar.getInstance();
	    c.add(Calendar.YEAR, -ageYear);
	    c.add(Calendar.MONTH, -ageMonth);
	    c.add(Calendar.DAY_OF_MONTH, -ageDay);
	    return String.format("%tF", c.getTime());
	}
	//出生日期字符串转化成Date对象
    public  static Date parse(String strDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(strDate);
    }

    //由出生日期获得年龄
    public  static int getAge(Date birthDay) throws Exception {
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthDay)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;
            }else{
                age--;
            }
        }
        return age;
    }
	
}
