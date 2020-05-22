package com.decoder.decoder.Factory;

import com.decoder.decoder.Classes.*;
import com.decoder.decoder.History.Conversion;
import org.springframework.stereotype.Component;

@Component
public class MorseFactory implements IFactory {

    @Override
    public ICipher createCipher(){
        return new Morse();
    };

    @Override
    public Conversion createConversion(){
        return new Conversion();
    }

}
