package com.decoder.decoder.History;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Data
@Component
public class History implements IHistory {
    private static int iterator = 0;
    private ArrayList<IConversion> historyList = new ArrayList<IConversion>();

    @Override
    public void addConversion(IConversion conversion){
        historyList.add(iterator, conversion);
        ++iterator;
    }

    @Override
    public ArrayList<IConversion> getHistoryList(){
        return  this.historyList;
    }
}


