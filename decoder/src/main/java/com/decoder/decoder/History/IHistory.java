package com.decoder.decoder.History;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface IHistory {
    void addConversion(IConversion conversion);
    ArrayList<IConversion> getHistoryList();

}