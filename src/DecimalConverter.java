import java.lang.Math;
//This class converts DecimalCoordinate objects to DMSCoordinate objects.
// This class should be constructed with a DecimalCoordinate object. Once that object is set,
// convert() can be called to convert the decimalObj to a DMSCoordinate object and set it appropriately.
public class DecimalConverter implements Converter{

    DecimalCoordinate decimalObj; //The DecimalCoordinate object to be converted.

    DMSCoordinate convertedObj; //Once convert() is called, this convertedObj is set to the correct DMSCoordinate.


    public DecimalConverter() { //Default constructor to assign decimalObj to 0.
        this.decimalObj = new DecimalCoordinate();
    }

    public DecimalConverter(DecimalCoordinate decimalObj) { //Overloaded constructor which takes in a pre-existing DecimalCoordinate object and sets decimalObj equal to it.
        this.decimalObj = decimalObj;
    }//The DecimalCoordinate object to be converted.


    public DMSCoordinate getConvertedObj() { //Returns convertedObj.
        return convertedObj;
    }//Once convert() is called, this convertedObj is set to the correct DMSCoordinate.


    //Implements the convert() method from the Converter interface. Should take the decimalObj and convert that to a
    // DMSCoordinate, once converted, set convertedObj to the new DecimalCoordinate. The Math.floor() function will
    // come in handy! There is some more information in the Additional Info section of the README.
    // Math.floor() also returns a double, so to convert from double to int use the `(int)` cast before a double to
    // "cast" it to an int.
    //When creating and setting the convertedObj, I would recommend to
    // use the DMSCoordinate(int, int, int, int, int, int) constructor.
    // A helpful graphic of the formula in action is in the GitHub README, and a link to an explanation is available in the README.
    public void convert() {

        // Convert latitude in decimal to latitude degrees minutes and seconds
        int degreesLat = (int) Math.floor(decimalObj.getLatitude());
        double unroundedMinsLat = (decimalObj.getLatitude()-degreesLat) * 60;
        int minutesLat = (int) Math.floor(unroundedMinsLat);
        int secondsLat = (int) Math.floor((unroundedMinsLat - minutesLat) * 60);

        //Convert longitude in decimal to longitude degrees minutes and seconds
        int degreesLong = (int) Math.floor(decimalObj.getLongitude());
        double unroundedMinsLong = (decimalObj.getLongitude()-degreesLong) * 60;
        int minutesLong = (int) Math.floor(unroundedMinsLong);
        int secondsLong = (int) Math.floor((unroundedMinsLong - minutesLong) * 60);

        DMSCoordinate newDMSObj = new DMSCoordinate(degreesLat, minutesLat, secondsLat, degreesLong, minutesLong, secondsLong);

        convertedObj = newDMSObj;
    }
}
