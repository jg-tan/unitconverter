package com.example.joseph.converter;

/**
 * Created by Joseph on 16/03/2018.
 */

public class Converter {

    double output = 0;

    ConvertLength convLen = new ConvertLength();
    ConvertWeight convWt = new ConvertWeight();
    ConvertCurrency convCur = new ConvertCurrency();


    public double convert(String selUnitFrom, String selUnitTo, double input){

        String selUnitTemp;
        String selUnitFr = selUnitFrom.toLowerCase();
        String type = "length";

        if(selUnitFr.equals("kilometer")||selUnitFr.equals("meter")||selUnitFr.equals("milimeter")||
                selUnitFr.equals("inch")||selUnitFr.equals("foot")||selUnitFr.equals("mile")){
            type = "length";
        }

        if(selUnitFr.equals("kilogram")||selUnitFr.equals("gram")||selUnitFr.equals("miligram")||
                selUnitFr.equals("ton")||selUnitFr.equals("pound")||selUnitFr.equals("ounce")){
            type = "weight";
        }

        if(selUnitFr.equals("south korean won")||selUnitFr.equals("japanese yen")||selUnitFr.equals("euro")||
                selUnitFr.equals("us dollar")||selUnitFr.equals("philippine peso")){
            type = "currency";
        }

        switch (type) {
            case "length":
                output = convLen.convert(selUnitFrom, selUnitTo, input);
                break;
            case "weight":
                output = convWt.convert(selUnitFrom, selUnitTo, input);
                break;
            case "currency":
                output = convCur.convert(selUnitFrom, selUnitTo, input);
                break;
        }

        return output;

    }

}
