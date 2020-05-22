package com.decoder.decoder.Classes;

public interface ICipher {
    String cipherName = "";
    String strToWork = "";
    StringBuilder result = new StringBuilder();
    void encrypt();
    String redirect();

}
