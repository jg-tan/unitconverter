package com.example.joseph.converter;

/**
 * Created by Joseph on 16/03/2018.
 */

public class ConvertLength {
    public double convert(String unitConvFr, String unitConvTo, double input){
        double output = 0;
        String unitFrom = unitConvFr.toLowerCase();
        String unitTo = unitConvTo.toLowerCase();

        switch(unitFrom){
            case "kilometer" :
                switch(unitTo){
                    case "kilometer" :
                        output = input;
                        break;
                    case "meter" :
                        output = input*1000;
                        break;
                    case "milimeter" :
                        output = input*1000000;
                        break;
                    case "inch" :
                        output = input*39370.1;
                        break;
                    case "foot" :
                        output = input*3280.84;
                        break;
                    case "mile" :
                        output = input*.621371;
                        break;
                }
                break;
            case "meter" :
                switch(unitTo){
                    case "kilometer" :
                        output = input/1000;
                        break;
                    case "meter" :
                        output = input;
                        break;
                    case "milimeter" :
                        output = input*1000;
                        break;
                    case "inch" :
                        output = input*39.3701;
                        break;
                    case "foot" :
                        output = input*3.28084;
                        break;
                    case "mile" :
                        output = input*.000621371;
                        break;
                }
                break;
            case "milimeter" :
                switch(unitTo){
                    case "kilometer" :
                        output = input/1000000;
                        break;
                    case "meter" :
                        output = input/1000;
                        break;
                    case "milimeter" :
                        output = input;
                        break;
                    case "inch" :
                        output = input*.0393701;
                        break;
                    case "foot" :
                        output = input*.00328084;
                        break;
                    case "mile" :
                        output = input*.00000062137;
                        break;
                }
                break;
            case "inch" :
                switch(unitTo){
                    case "kilometer" :
                        output = input*.0000254;
                        break;
                    case "meter" :
                        output = input*.0254;
                        break;
                    case "milimeter" :
                        output = input*25.4;
                        break;
                    case "inch" :
                        output = input;
                        break;
                    case "foot" :
                        output = input*.083333;
                        break;
                    case "mile" :
                        output = input*.000015783;
                        break;
                }
                break;
            case "foot" :
                switch(unitTo){
                    case "kilometer" :
                        output = input*.0003048;
                        break;
                    case "meter" :
                        output = input*.3048;
                        break;
                    case "milimeter" :
                        output = input*304.8;
                        break;
                    case "inch" :
                        output = input*12;
                        break;
                    case "foot" :
                        output = input;
                        break;
                    case "mile" :
                        output = input*.000189394;
                        break;
                }
                break;
            case "mile" :
                switch(unitTo){
                    case "kilometer" :
                        output = input*1.60934;
                        break;
                    case "meter" :
                        output = input*1609.34;
                        break;
                    case "milimeter" :
                        output = input*1609340;
                        break;
                    case "inch" :
                        output = input*63360;
                        break;
                    case "foot" :
                        output = input*5280;
                        break;
                    case "mile" :
                        output = input;
                        break;
                }
                break;
        }

        return output;
    }
}


