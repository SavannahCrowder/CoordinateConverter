public class DMSConverter implements Converter{

    DMSCoordinate DMSObj; //The DMSCoordinate object to be converted.

    DecimalCoordinate convertedObj; //Once convert() is called, this convertedObj is set to the correct DecimalCoordinate.

    public DMSConverter() {
        this.DMSObj = new DMSCoordinate();
    }

    public DMSConverter(DMSCoordinate DMSObj) {
        this.DMSObj = DMSObj;
    }

    public DMSConverter(String latAndLong) {
        DMSObj = new DMSCoordinate(latAndLong);
    }

    public DecimalCoordinate getConvertedObj() {
        return convertedObj;
    }

    //Implements the convert() method from the Converter interface. Should take the DMSObj and convert that to a
    //DecimalCoordinate, once converted, set convertedObj to the new DecimalCoordinate. Remember all of the useful
    //getters included with the DMSCoordinate class.
    //When creating and setting the convertedObj, I would recommend to use the DecimalCoordinate(double, double) constructor.
    //A helpful graphic of the formula in action is in the GitHub README, and a link to an explanation is available in the README.
    public void convert() {
        //TODO Student
        double latDegrees = DMSObj.getDegreesLat();
        double latMinutes = DMSObj.getMinutesLat();
        double latSeconds = DMSObj.getSecondsLat();
        double longDegrees = DMSObj.getDegreesLong();
        double longMinutes = DMSObj.getMinutesLong();
        double longSeconds = DMSObj.getSecondsLong();

        double decimalLat = latDegrees + (latMinutes / 60) + (latSeconds / 3600);
        double decimalLong = longDegrees + (longMinutes / 60) + (longSeconds / 3600);

        decimalLat = Math.round(decimalLat * 10000.0) / 10000.0;
        decimalLong = Math.round(decimalLong * 10000.0) / 10000.0;

        convertedObj = new DecimalCoordinate(decimalLat, decimalLong); //This line will also be changed.
    }
}