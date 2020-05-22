package com.decoder.decoder.Classes;

import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class ChoiceKeeper {
    private String choice;

    public String getChoice(){
        return this.choice;
    }
}
