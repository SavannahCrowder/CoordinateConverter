public class DMSCoordinate {
    int degreesLat;
    int minutesLat;
    int secondsLat;

    int degreesLong;
    int minutesLong;
    int secondsLong;

    public DMSCoordinate() { //Default Constructor which initializes each value to 0.
        degreesLat = 0;
        minutesLat = 0;
        secondsLat = 0;

        degreesLong = 0;
        minutesLong = 0;
        secondsLong = 0;
    }
    //Overloaded constructor in the case that the Latitude and Longitude were not split before creating DMSCoordinate Object.
// The provided String must be split into a latitude and longitude String using substring().
// After being split, each is sent to setLatitude(String) or setLongitude(String).
    public DMSCoordinate(String latAndLong) {
        String latitude = latAndLong.substring(0, latAndLong.indexOf(" "));
        String longitude = latAndLong.substring(latAndLong.indexOf(" ")+1);

        setLatitude(latitude);
        setLongitude(longitude);
    }

    //Overloaded constructor, for the case that each degrees, minute, and second is seperate already.
    public DMSCoordinate(int degreesLat, int minutesLat, int secondsLat, int degreesLong, int minutesLong, int secondsLong) {
        this.degreesLat = degreesLat;
        this.minutesLat = minutesLat;
        this.secondsLat = secondsLat;

        this.degreesLong = degreesLong;
        this.minutesLong = minutesLong;
        this.secondsLong = secondsLong;
    }

    public int getDegreesLat() {
        return degreesLat;
    }

    public int getMinutesLat() {
        return minutesLat;
    }

    public int getSecondsLat() {
        return secondsLat;
    }

    public int getDegreesLong() {
        return degreesLong;
    }

    public int getMinutesLong() {
        return minutesLong;
    }

    public int getSecondsLong() {
        return secondsLong;
    }

    public String getLatitude() { //Converts latitude DMS to a readable format
        String str = degreesLat + "°" + minutesLat + "'" + secondsLat + "\"";
        return str;
    }

    public String getLongitude() { //Converts longitude DMS to a readable format
        String str = degreesLong + "°" + minutesLong + "'" + secondsLong + "\"";
        return str;
    }

    //Takes in a String and assigns the latitude class variables based upon their position in the String.
    //After each number is parsed, they must all be checked to be in the range of 0 to 60.
    // If any are not in this range of 0-60, all latitude values are set to 0, and a String is printed to indicate
    // an error has occurred. Given they are in this range, each value is set accordingly.
    public void setLatitude(String latitude) {
        String strDegrees = latitude.substring(0, latitude.indexOf("°"));
        String strMinutes = latitude.substring(latitude.indexOf("°")+1, latitude.indexOf("'"));
        String strSeconds = latitude.substring(latitude.indexOf("'")+1, latitude.indexOf("\""));

        int parsedDegrees = Integer.parseInt(strDegrees);
        int parsedMinutes = Integer.parseInt(strMinutes);
        int parsedSeconds = Integer.parseInt(strSeconds);


        if (parsedDegrees < 0 || parsedDegrees > 60 || parsedMinutes < 0 || parsedMinutes > 60 || parsedSeconds < 0 || parsedSeconds > 60) {
            this.degreesLat = 0;
            this.minutesLat = 0;
            this.secondsLat = 0;
            System.out.println("Error: Latitude values must be between 0 and 60");
            return;
        }
        this.degreesLat = parsedDegrees;
        this.minutesLat = parsedMinutes;
        this.secondsLat =parsedSeconds;
    }
    //Takes in a String and assigns the longitude class variables based upon their position in the String.
//After each number is parsed, they must all be checked to be in the range of 0 to 60.
// If any are not in this range of 0-60, all longitude values are set to 0, and a String is printed to indicate an
// error has occurred. Given they are in this range, each value is set accordingly.
    public void setLongitude(String longitude) {
        String strDegrees = longitude.substring(0, longitude.indexOf("°"));
        String strMinutes = longitude.substring(longitude.indexOf("°")+1, longitude.indexOf("'"));
        String strSeconds = longitude.substring(longitude.indexOf("'")+1, longitude.indexOf("\""));

        int parsedDegrees = Integer.parseInt(strDegrees);
        int parsedMinutes = Integer.parseInt(strMinutes);
        int parsedSeconds = Integer.parseInt(strSeconds);


        if (parsedDegrees < 0 || parsedDegrees > 60 || parsedMinutes < 0 || parsedMinutes > 60 || parsedSeconds < 0 || parsedSeconds > 60) {
            this.degreesLong = 0;
            this.minutesLong = 0;
            this.secondsLong = 0;
            System.out.println("Error: Longitude values must be between 0 and 60");
            return;
        }
        this.degreesLong = parsedDegrees;
        this.minutesLong = parsedMinutes;
        this.secondsLong =parsedSeconds;
    }

    //Converts both latitude and longitude to their String formats and appends them to eachother with a space in between
    // then returns full String. ex: "LATITUDE LONGITUDE"
    public String toString() {
        String str = getLatitude() + " " + getLongitude();
        return str;
    }
}
