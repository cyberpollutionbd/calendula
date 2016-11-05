package es.usc.citius.servando.calendula.pharmacies.util;

import com.google.zxing.common.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by isaac@isaaccastro.eu on 3/11/16.
 */

public class Utils {

    public static String capitalizeNames(String name){
        StringBuilder capitalizedName = new StringBuilder();

        Pattern p = Pattern.compile(".*,\\s*(.*)");
        Matcher m = p.matcher(name);
        if (m.find()) {
            name = m.group(1)+" "+m.group(0).split(",")[0];
        }

        ArrayList<String> wordsNoCapitalize = new ArrayList<>();
        wordsNoCapitalize.add("de");
        wordsNoCapitalize.add("los");
        wordsNoCapitalize.add("del");
        wordsNoCapitalize.add("la");
        wordsNoCapitalize.add("y");

        String[] splitted = name.split(" ");
        for (String word:splitted){
            if (wordsNoCapitalize.contains(word.toLowerCase())){
                capitalizedName.append(word.toLowerCase().concat(" "));
            }
            else {
                String firstLetter = word.substring(0, 1).toUpperCase();
                String otherLetters = word.substring(1, word.length()).toLowerCase();
                capitalizedName.append(firstLetter.concat(otherLetters).concat(" "));
            }
        }

        return capitalizedName.toString();
    }

    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    public static String getDate(Date date){
        String strDate = "";

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");

        strDate = sdf.format(date);

        return strDate;
    }

}
