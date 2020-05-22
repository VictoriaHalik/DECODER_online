package com.decoder.decoder.Classes;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MorseDictionary {
    private String[] info = new String[91];

    public MorseDictionary(){
        info[(int)'0'] = "-----";
        info[(int)'1'] = "•----";
        info[(int)'2'] = "••---";
        info[(int)'3'] = "•••--";
        info[(int)'4'] = "••••-";
        info[(int)'5'] = "•••••";
        info[(int)'6'] = "-••••";
        info[(int)'7'] = "--•••";
        info[(int)'8'] = "---••";
        info[(int)'9'] = "----•";
        info[(int)'A'] = "•-";
        info[(int)'B'] = "-•••";
        info[(int)'C'] = "-•-•";
        info[(int)'D'] = "-••";
        info[(int)'E'] = "•";
        info[(int)'F'] = "••-•";
        info[(int)'G'] = "--•";
        info[(int)'H'] = "••••";
        info[(int)'I'] = "••";
        info[(int)'J'] = "•---";
        info[(int)'K'] = "-•-";
        info[(int)'L'] = "•-••";
        info[(int)'M'] = "--";
        info[(int)'N'] = "-•";
        info[(int)'O'] = "---";
        info[(int)'P'] = "•--•";
        info[(int)'Q'] = "--•-";
        info[(int)'R'] = "•-•";
        info[(int)'S'] = "•••";
        info[(int)'T'] = "-";
        info[(int)'U'] = "••-";
        info[(int)'V'] = "•••-";
        info[(int)'W'] = "•--";
        info[(int)'X'] = "-••-";
        info[(int)'Y'] = "-•--";
        info[(int)'Z'] = "--••";
    }

    public String[] getInfo(){
        return this.info;
    }
}
