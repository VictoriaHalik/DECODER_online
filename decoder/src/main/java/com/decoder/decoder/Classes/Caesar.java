package com.decoder.decoder.Classes;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Component
@Data
public class Caesar implements ICipher {
    private String cipherName = "Caesar";
    private String strToWork = "";
    private StringBuilder result = new StringBuilder();
    private String keyIn;
    private int key;

    @Override
    public void encrypt()
    {
        for (int i = 0; i < strToWork.length(); ++i)
        {
            if(strToWork.charAt(i) == ' ' ){
                char ch = ' ';
                result.append(ch);
            }
            else if (Character.isUpperCase(strToWork.charAt(i)) && strToWork.charAt(i) != ' ') {
                char ch = (char)(((int)strToWork.charAt(i) + key - 65) % 26 + 65);
                result.append(ch);
            }
            else if (strToWork.charAt(i) != ' ') {
                char ch = (char)(((int)strToWork.charAt(i) + key - 97) % 26 + 97);
                result.append(ch);
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

    public String getKeyIn(){
        return this.keyIn;
    }

    public boolean getKey(Caesar caesar){     // converting key from String to int
        if (caesar.checkKey()){
            try {
               key =  Integer.parseInt(keyIn);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean checkKey(){   // key validation
        char buff;
        if (keyIn.charAt(0)=='0' && keyIn.length()!= 1 && keyIn.charAt(0) != '-')
            return false;
        for (int i = 1; i < keyIn.length(); ++i ){
            buff = keyIn.charAt(i);
            if(buff != '1'&& buff != '2'&& buff != '3'&& buff != '4'&& buff != '5'
                    && buff != '6' && buff != '7'&& buff != '8'&& buff != '9'&& buff != '0'){
                return false;
            }
        }
        return true;
    }

    public  String redirect(){
        return "redirect:/yourChoice/caesarInput";
    }

}
