package com.decoder.decoder.Classes;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Ascii implements ICipher {
    private String cipherName = "ASCII";
    private StringBuilder result = new StringBuilder();
    private String strToWork = "";

    public void encrypt(){
        char buff;
        for (int i = 0; i < strToWork.length(); ++i){
            buff = strToWork.charAt(i);
            result.append(' ');
            result.append((int)buff);

        }
    }

    public String getCipherName(){
        return this.cipherName;
    }

    public String getStrToWork(){
        return this.strToWork;
    }

    public StringBuilder getResult(){
        return this.result;
    }

    public  String redirect(){
        return "redirect:/yourChoice/asciiInput";
    }


}
