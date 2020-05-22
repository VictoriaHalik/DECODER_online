package com.decoder.decoder.Factory;

import com.decoder.decoder.Classes.Ascii;
import com.decoder.decoder.History.Conversion;
import com.decoder.decoder.Classes.ICipher;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AsciiFactory implements IFactory {

    @Override
    public ICipher createCipher(){
        return new Ascii();
    };

    @Override
    public Conversion createConversion(){
        return new Conversion();
    }
}
