
public class AddressUSA {

    // first: what are the fields?
    private String addressLine1;
    private String addressLine2;
    private String cityName;
    private String stateName;
    private int zipCode;
    // next: try to print object - nothing meaningful prints
    // so: implement toString method, re-test
    public String toString(){
        String format = "AdrressUsa[addressLine1=%s, addressLine2=%s, cityName=%s, stateName=%s, zipCode=%d]";
        String str = String.format(format, addressLine1,addressLine2, cityName, stateName, zipCode);
        return str;
    }
    // observe: null objects... bad
    // so: implement default constructor, re-test
    public AddressUSA(){
        this("","","","",0);
    }

    // next: implement setters, trying both of these:
    //       - input variable names that match field names
    //       - input variable names that are different from field names
    // test: print values
    public void setAddressLine1(String addressLine1){
        this.addressLine1 = addressLine1;

    }
    public void setAddressLine2(String addressLine2){
        this.addressLine2 = addressLine2;
    }
    public void setCityName(String cityName){
        this.cityName = cityName;
    }
    public void setStateName(String stateName){
        this.stateName = stateName;
    }
    public void setZipCode(int zipCode){
        if(zipCode < 0){
            this.zipCode = 0;
        }
        else {
            this.zipCode = zipCode;
        }
    }
    // next: getters
    // test: ensure to call each getter and store value in variable
    //       (it's not enough to just print the call in-line!)
    public String getAddressLine1(){
        return addressLine1;
    }
    public String getAddressLine2(){
        return addressLine2;
    }
    public String getCityName(){
        return cityName;
    }
    public String getStateName(){
        return stateName;
    }
    public int getZipCode(){
        return zipCode;
    }

    // next: provide custom constructor that calls the setters
    //  and: re-write the default constructor to redirect to custom constructor
    //  and: add a convenience constructor with 1 address line
    // test: try constructing different objects
    public AddressUSA(String addressLine1, String addressLine2, String cityName, String stateName, int zipCode){
        setAddressLine1(addressLine1);
        setAddressLine2(addressLine2);
        setCityName(cityName);
        setStateName(stateName);
        setZipCode(zipCode);
    }

    // observe: can set weird data
    //          - blank first line but available second line
    //          - null lines
    //          - state not 2 letters, not upper case
    //          - zip is negative or above 5 digits
    // so: add rules and modify setters
    //     - force setting of line 1 and line 2 at same time
    //       and prevent null for either value
    //     - force state to be 2 chars, covert to upper-case
    //     - force zip between 0 and 99999
    // test: re-try setting weird values (or constructing with weird values)


    // observe: it would be helpful to have a method that returns
    //          address as a "normal" String.  How can addresses look?
    //     add: secondary getter


    // observe: the zip code can print out in a funny way
    //     add: secondary getter
    //     and: update the other secondary getter


    // lastly: show Eclipse's built-in functionality to automate much of this
    // beware: you will see exam problems where you build classes on paper

}
