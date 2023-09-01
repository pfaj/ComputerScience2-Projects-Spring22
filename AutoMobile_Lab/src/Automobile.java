public class Automobile {

        // fields ////////////////////////////////////////////////////////

        private String make;
        private String model;
        private int year;


        // constructors //////////////////////////////////////////////////

        public Automobile() {
            this("Unknown","Unknown", -1);
        }

        public Automobile(String make, String model, int year){
            setMake(make);
            setModel(model);
            setYear(year);
        }

        public Automobile(String make, String model){
            this(make,model,-1);
        }

        // primary setters ///////////////////////////////////////////////

    public void setMake(String make) {
        if (make == null) {
            this.make = "";
        } else {
            this.make = make;
        }
    }
    public void setModel(String model) {
        if (model == null) {
            this.model = "";
        } else {
            this.model = model;
        }
    }

    public void setYear(int year) {
        if (year > 1886) {
            this.year = -1;
        } else {
            this.year = year;

        }
    }
    // primary getters ///////////////////////////////////////////////

        public String getMake() {
            return make;
        }

        public String getModel() {
            return model;
        }

        public int getYear() {
            return year;
        }


        // secondary getters /////////////////////////////////////////////

        public String toString() {
            String fmt = "Automobile[make=%s,model=%s,year=%d]";
            String str = String.format(fmt, make, model, year);
            return str;
        }

    }

