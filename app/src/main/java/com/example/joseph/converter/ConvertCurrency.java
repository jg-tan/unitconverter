package com.example.joseph.converter;

/**
 * Created by Joseph on 16/03/2018.
 */

public class ConvertCurrency {
    public double convert(String unitConvFr, String unitConvTo, double input){
        double output = 0;
        String unitFrom = unitConvFr.toLowerCase();
        String unitTo = unitConvTo.toLowerCase();

        switch(unitFrom){
            case "philippine peso" :
                switch(unitTo){
                    case "philippine peso" :
                        output = input;
                        break;
                    case "us dollar" :
                        output = input*.01923;
                        break;
                    case "japanese yen" :
                        output = input*2.0361109;
                        break;
                    case "euro" :
                        output = input*.0156209;
                        break;
                    case "south korean won" :
                        output = input*20.5409091;
                        break;
                }
                break;
            case "us dollar" :
                switch(unitTo){
                    case "philippine peso" :
                        output = input*52.02105;
                        break;
                    case "us dollar" :
                        output = input;
                        break;
                    case "japanese yen" :
                        output = input*105.892;
                        break;
                    case "euro" :
                        output = input*.81229;
                        break;
                    case "south korean won" :
                        output = input*1068.817;
                        break;
                }
                break;
            case "japanese yen" :
                switch(unitTo){
                    case "philippine peso" :
                        output = input*.4909791;
                        break;
                    case "us dollar" :
                        output = input*.00944;
                        break;
                    case "japanese yen" :
                        output = input;
                        break;
                    case "euro" :
                        output = input*.0076681;
                        break;
                    case "south korean won" :
                        output = input*10.0835248;
                        break;
                }
                break;
            case "euro" :
                switch(unitTo){
                    case "philippine peso" :
                        output = input*64.0296064;
                        break;
                    case "us dollar" :
                        output = input*1.23107;
                        break;
                    case "japanese yen" :
                        output = input*130.365;
                        break;
                    case "euro" :
                        output = input;
                        break;
                    case "south korean won" :
                        output = input*1315.1611361;
                        break;
                }
                break;
            case "south korean won" :
                switch(unitTo){
                    case "philippine peso" :
                        output = input*.0488899;
                        break;
                    case "us dollar" :
                        output = input*.00094;
                        break;
                    case "japanese yen" :
                        output = input*.0995385;
                        break;
                    case "euro" :
                        output = input*.0007605;
                        break;
                    case "south korean won" :
                        output = input;
                        break;
                }
                break;
        }

        return output;
    }
}



