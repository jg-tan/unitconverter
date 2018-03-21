package com.example.joseph.converter;

/**
 * Created by Joseph on 16/03/2018.
 */

public class ConvertWeight {
    public double convert(String unitConvFr, String unitConvTo, double input){
        double output = 0;
        String unitFrom = unitConvFr.toLowerCase();
        String unitTo = unitConvTo.toLowerCase();

        switch(unitFrom){
            case "kilogram" :
                switch(unitTo){
                    case "kilogram" :
                        output = input;
                        break;
                    case "gram" :
                        output = input*1000;
                        break;
                    case "miligram" :
                        output = input*1000000;
                        break;
                    case "pound" :
                        output = input*2.20462;
                        break;
                    case "ton" :
                        output = input*.00110231;
                        break;
                    case "ounce" :
                        output = input*35.274;
                        break;
                }
                break;
            case "gram" :
                switch(unitTo){
                    case "kilogram" :
                        output = input/1000;
                        break;
                    case "gram" :
                        output = input;
                        break;
                    case "miligram" :
                        output = input*1000;
                        break;
                    case "pound" :
                        output = input*.00220462;
                        break;
                    case "ton" :
                        output = input*.0000011023;
                        break;
                    case "ounce" :
                        output = input*.035274;
                        break;
                }
                break;
            case "miligram" :
                switch(unitTo){
                    case "kilogram" :
                        output = input/1000000;
                        break;
                    case "gram" :
                        output = input/1000;
                        break;
                    case "miligram" :
                        output = input;
                        break;
                    case "pound" :
                        output = input*.0000022046;
                        break;
                    case "ton" :
                        output = input*.0000000011023;
                        break;
                    case "ounce" :
                        output = input*.000035274;
                        break;
                }
                break;
            case "pound" :
                switch(unitTo){
                    case "kilogram" :
                        output = input*.453592;
                        break;
                    case "gram" :
                        output = input*453.592;
                        break;
                    case "miligram" :
                        output = input*453592;
                        break;
                    case "pound" :
                        output = input;
                        break;
                    case "ton" :
                        output = input*.0005;
                        break;
                    case "ounce" :
                        output = input*16;
                        break;
                }
                break;
            case "ton" :
                switch(unitTo){
                    case "kilogram" :
                        output = input*907.185;
                        break;
                    case


                            "gram" :
                        output = input*907185;
                        break;
                    case "miligram" :
                        output = input*907185000;
                        break;
                    case "pound" :
                        output = input*2000;
                        break;
                    case "ton" :
                        output = input;
                        break;
                    case "ounce" :
                        output = input*32000;
                        break;
                }
                break;
            case "ounce" :
                switch(unitTo){
                    case "kilogram" :
                        output = input*.0283495;
                        break;
                    case "gram" :
                        output = input*28.3495;
                        break;
                    case "miligram" :
                        output = input*28349.5;
                        break;
                    case "pound" :
                        output = input*.0625;
                        break;
                    case "ton" :
                        output = input*0.00003125;
                        break;
                    case "ounce" :
                        output = input;
                        break;
                }
                break;
        }

        return output;
    }
}


