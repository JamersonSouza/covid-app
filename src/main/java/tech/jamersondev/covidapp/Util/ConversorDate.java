package tech.jamersondev.covidapp.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversorDate {

    public static String converterDateParaDataHora(Date data){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        return dateFormat.format(data);
    }
    
}
