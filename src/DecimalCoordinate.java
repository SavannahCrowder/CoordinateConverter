public class DecimalCoordinate {
    double latitude;
    double longitude;

    public DecimalCoordinate() { //Default constructor which initializes each variable to 0.
        latitude = 0;
        longitude = 0;
    }

    //Overloaded constructor in the case that the latitude and longitude were provided in the same String.
//After the latitude and longitude are parsed, a check must be made to view if the Latitude is in the range of 0 to 60,
// and the Longitude in the range of 0 to 60. If both are in these ranges, the values can be set.
// If one of these values is not in their respective ranges, both values are to be set to 0,
// and a String should be printed to indicate user error.
//Typically latitudes range between -90 to 90 and longitudes between -180 to 180.
// For our purposes and since we are not including the cardinal direction, these ranges have been changed to 0-60.
    public DecimalCoordinate(String latAndLong) {
        String latStr = latAndLong.substring(0, latAndLong.indexOf(" "));
        String longStr = latAndLong.substring(latAndLong.indexOf(" ") + 1);

        double parsedLat = Double.parseDouble(latStr);
        double parsedLong = Double.parseDouble(longStr);


        if (parsedLat < 0 || parsedLat > 60) {
            System.out.println("Invalid latitude - must be between 0 and 60");
            this.latitude = 0;
            this.longitude = 0;
            return;
        } else if (parsedLong < 0 || parsedLong > 60) {
            System.out.println("Invalid longitude - must be between 0 and 60");
            this.latitude = 0;
            this.longitude = 0;
            return;
        }

        this.latitude = parsedLat;
        this.longitude = parsedLong;
    }

    public DecimalCoordinate(double latitude, double longitude) { //Overloaded constructor, where the parameters
        // are a String form of latitude and longitude. Sets the latitude and longitude given to the class variables.
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    //Sets latitude value.
    //The double provided must be checked to be in the range of 0 to 60,
    // if it is not, print an error message and set the latitude to 0.
    public void setLatitude(double latitude) { //The double provided must be checked to be in the range of 0 to 60,
        // if it is not, print an error message and set the latitude to 0.

        if (latitude < 0 || latitude > 60) {
            System.out.println("Invalid latitude: latitude must be from 0 to 60");
            this.latitude = 0;
            return;
        }

        this.latitude = latitude;
    }

    //Sets longitude value.
//The double provided must be checked to be in the range of 0 to 60,
// if it is not, print an error message and set the longitude to 0.
    public void setLongitude(double longitude) {
        if (longitude < 0 || latitude > 60){
            System.out.println("Invalid longitude: longitude must be from 0 to 60");
            this.longitude = 0;
            return;
        }
        this.longitude =longitude;
    }

    //Creates a String with both the Latitude and Longitude, seperated by a space. and returns. ex: "38.6578 12.5467"
    public String toString() {
        String str = String.format("%.4f %.4f", latitude, longitude);
        return str;
    }
}
