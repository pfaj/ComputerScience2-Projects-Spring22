public class Clock extends Duration{

    private int seconds;

    public Clock(int hours, int minutes, int seconds){
        super(hours, minutes);
        setSeconds(seconds);
    }

    public void setSeconds(int seconds) {
        if(0 >= seconds && seconds <= 59) {
            this.seconds = seconds;
        }
    }
    public int getSeconds(){
        return seconds;
    }

    @Override
    public void setHours(int hours) {
        if(0 >= hours && hours <= 23) {
            super.setHours(hours) ;
        }
    }
}
