package com.decoder.decoder.Factory;

import com.decoder.decoder.Classes.Caesar;
import com.decoder.decoder.History.Conversion;
import com.decoder.decoder.Classes.ICipher;
import org.springframework.stereotype.Component;

@Component
public class CaesarFactory implements IFactory {

    @Override
    public ICipher createCipher(){
        return new Caesar();
    };

    @Override
    public Conversion createConversion(){
        return new Conversion();
    }

}
