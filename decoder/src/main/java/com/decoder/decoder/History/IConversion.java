package com.decoder.decoder.History;

import com.decoder.decoder.Classes.Ascii;
import com.decoder.decoder.Classes.Caesar;
import com.decoder.decoder.Classes.Morse;
import org.springframework.stereotype.Component;

@Component
public interface IConversion {

    void createConversion(Caesar cipher);

    void createConversion(Morse cipher);

    void createConversion(Ascii cipher);
}
