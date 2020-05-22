package com.decoder.decoder.Factory;

import com.decoder.decoder.History.Conversion;
import com.decoder.decoder.Classes.ICipher;
import org.springframework.stereotype.Component;

@Component
public interface IFactory {
    ICipher createCipher();
    Conversion createConversion();
}
