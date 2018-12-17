package lk.ijse.jewelryshop.validation;

public class Validator {
    public static boolean nameValidation(String name){
        if(name.trim().isEmpty()){
            return false;
        }
        if(!name.matches("[A-z .]+")){
            return false;
        }
        return true;
    }
    public static boolean contactNoValidation(String number){
        if(number.trim().isEmpty()){
            return false;
        }
        if(!number.matches("[0-9]{10}")){
            return false;
        }
        return true;
    }
    public static boolean addressValidation(String adress){
        if(adress.trim().isEmpty()){
            return false;
        }
        if(!adress.matches("[A-z ,]+")){
            return false;
        }
        return true;
    }
    public static boolean isNotEmptyValidation(String text){
        if(!text.trim().isEmpty()){
            return true;
        }
        return false;
    }
    public static boolean doubleValueValidation(String value){
        if(value.trim().isEmpty()){
            return false;
        }
        if(!value.matches("\\d+(\\.\\d{2}|\\.\\d{1})?")){
            return false;
        }
        return true;
    }
    public static boolean intValueValidation(String value){
        if(value.trim().isEmpty()){
            return false;
        }
        if(!value.matches("[0-9]+")){
            return false;
        }
        return true;
    }
    public static boolean jewelryMakerIdValidation(String id){
        if(id.trim().isEmpty()){
            return false;
        }
        if(!id.matches("[J][M][A][K]+[0-9]{3}")){
            return false;
        }
        return true;
    }
    public static boolean metalBusinessmenIdValidation(String id){
        if(id.trim().isEmpty()){
            return false;
        }
        if(!id.matches("[M][E][T][B]+[0-9]{3}")){
            return false;
        }
        return true;
    }
    public static boolean jewelryIdValidation(String id){
        if(id.trim().isEmpty()){
            return false;
        }
        if(!id.matches("[J][E][W]+[0-9]{3}")){
            return false;
        }
        return true;
    }
    public static boolean hotelIdValidation(String id){
        if(id.trim().isEmpty()){
            return false;
        }
        if(!id.matches("[H]+[0-9]{3}")){
            return false;
        }
        return true;
    }
    public static boolean passportNoValidation(String id){
        if(id.trim().isEmpty()){
            return false;
        }
        if(!id.matches("[A-z]{1}[0-9]{8}")){
            return false;
        }
        return true;
    }
}
