package com.decoder.decoder.History;

import com.decoder.decoder.Classes.Ascii;
import com.decoder.decoder.Classes.Caesar;
import com.decoder.decoder.Classes.Morse;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Data
@Component
public class Conversion implements IConversion {
    private String name = new String();
    private String originText = new String();

    private StringBuilder newText = new StringBuilder();
    private LocalTime time;

    public Conversion(){};

    @Override
    public void createConversion(Caesar cipher){
        name = cipher.getCipherName();
        originText = cipher.getStrToWork();
        newText = cipher.getResult();
        time = LocalTime.now();
        time = time.truncatedTo(ChronoUnit.SECONDS);
    }

    @Override
    public void createConversion(Morse cipher){
        name = cipher.getCipherName();
        originText = cipher.getStrToWork();
        newText = cipher.getResult();
        time = LocalTime.now();
        time = time.truncatedTo(ChronoUnit.SECONDS);
    }

    @Override
    public void createConversion(Ascii cipher){
        name = cipher.getCipherName();
        originText = cipher.getStrToWork();
        newText = cipher.getResult();
        time = LocalTime.now();
        time = time.truncatedTo(ChronoUnit.SECONDS);
    }

}
