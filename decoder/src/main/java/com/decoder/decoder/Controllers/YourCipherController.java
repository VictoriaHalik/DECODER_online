package com.decoder.decoder.Controllers;

import com.decoder.decoder.Classes.ChoiceKeeper;
import com.decoder.decoder.Factory.AsciiFactory;
import com.decoder.decoder.Factory.CaesarFactory;
import com.decoder.decoder.Factory.IFactory;
import com.decoder.decoder.Factory.MorseFactory;
import com.decoder.decoder.Classes.*;
import com.decoder.decoder.History.IConversion;
import com.decoder.decoder.History.IHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping
public class YourCipherController {
    private ICipher cipher;
    private static IHistory History;
    private IFactory Factory;

    @Autowired
    ChoiceKeeper choiceKeeper;

    @Autowired
    IConversion conversion;

    @Autowired
    public YourCipherController(com.decoder.decoder.History.History history){
        YourCipherController.History = history;
    }

    ////////////////////////// Factory for the Cipher creating ///////////////////////////////

    public static IFactory createFactory(String choice){      // factory for creating cipher and conversion
        String direct = choice.toLowerCase();
        switch (direct) { 
            case "caesar":
                return new CaesarFactory();
            case "morse":
                return new MorseFactory();
            case "ascii":
                return new AsciiFactory();
            default:
                return null;
        }
    }

    ///////////////////////////////  Form for choosing  /////////////////////////////////////////

    @GetMapping("/yourChoice")
    public String showForm(Model choice){
        choice.addAttribute("choiceKeeper", choiceKeeper);
        return "yourChoice.html";
    }

    @PostMapping("/yourChoice")
    public String submitChoice(@ModelAttribute("choiceKeeper") ChoiceKeeper choiceKeeper){
        Factory = YourCipherController.createFactory(choiceKeeper.getChoice());
        if (Factory ==null)
            return "notFound.html";
        cipher = Factory.createCipher();
        return cipher.redirect();
    }

    //////////////////////////// Converting to Caesar Cipher ///////////////////////////////////////

    @GetMapping("/yourChoice/caesarInput")
    public String caesarInputForm(Model caesar){
        caesar.addAttribute("cipher", cipher);
        return "caesarInput.html";
    }

    @PostMapping("/yourChoice/caesarInput")
    public String submitCaesarInput(@ModelAttribute("caesar") Caesar cipher){
        if(cipher.getKey((cipher))){
            cipher.encrypt();
            conversion = Factory.createConversion();
            conversion.createConversion(cipher);
            History.addConversion(conversion);
            return "caesarResult.html";
        }
        else{
            return "redirect:/yourChoice/caesarInput";
        }
    }

    //////////////////////////// Converting to Morse Cipher ///////////////////////////////////////

    @GetMapping("/yourChoice/morseInput")
    public String morseInputForm(Model morse){
        morse.addAttribute("cipher", cipher);
        return "morseInput.html";
    }

    @PostMapping("/yourChoice/morseInput")
    public String submitMorseInput(@ModelAttribute("morse") Morse cipher){
        cipher.encrypt();
        conversion = Factory.createConversion();
        conversion.createConversion(cipher);
        History.addConversion(conversion);
        return "morseResult.html";
    }

    //////////////////////////// Converting to ASCII Code ///////////////////////////////////////

    @GetMapping("/yourChoice/asciiInput")
    public String asciiInputForm(Model ascii){
        ascii.addAttribute("cipher", cipher);
        return "asciiInput.html";
    }

    @PostMapping("/yourChoice/asciiInput")
    public String submitAsciiInput(@ModelAttribute("ascii") Ascii cipher){
        cipher.encrypt();
        conversion = Factory.createConversion();
        conversion.createConversion(cipher);
        History.addConversion(conversion);
        return "asciiResult.html";
    }

    ///////////////////////////////////// History /////////////////////////////////////////////

    @GetMapping("/yourChoice/history")
    public String historyForm(Model historyM){
        historyM.addAttribute("history", History.getHistoryList());
        return "history.html";
    }

}
