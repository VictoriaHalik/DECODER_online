package com.decoder.decoder.Classes;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Component
@Data
public class Morse implements ICipher {
    private String cipherName = "Morse";
    private String strToWork = "";
    private StringBuilder result = new StringBuilder();

    public void encrypt(){
        MorseDictionary dictionary = new MorseDictionary();
        // convert to uppercase
        String strToWorkUP = strToWork.toUpperCase();
        char buff;
        // convert to morse
        for (int i = 0; i < strToWorkUP.length(); ++i){
            buff = strToWorkUP.charAt(i);
            // to divide into words
            if (strToWorkUP.charAt(i) == ' '){
                result.append(" ");
            }
            // check on inappropriate chars
            else if(((int) strToWorkUP.charAt(i) > 48 && (int) strToWorkUP.charAt(i) < 57) ||
                    ((int) strToWorkUP.charAt(i) > 65 && (int) strToWorkUP.charAt(i) < 90)){
                result.append(dictionary.getInfo()[(int) buff]);
                result.append(' ');
            }
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
        return "redirect:/yourChoice/morseInput";
    }


}
