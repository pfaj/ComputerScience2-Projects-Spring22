public class PhoneContact {

    private String name;
    private String home;
    private String work;

    @Override
    public String toString() {
        String fmt = "PhoneContact[name=%s,home=%s,work=%s]";
        String str = String.format(fmt, name, home, work);
        return str;
    }

    public PhoneContact() {
        this("","","");
    }

    public PhoneContact(String name, String homeNum, String workNum) {
        setName(name);
        setHome(homeNum);
        setWork(workNum);
    }

    public PhoneContact(String name) {
        this(name, "", "");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHome(String num) {
        home = num;
    }

    public void setWork(String num) {
        work = num;
    }

    public String getName() {
        return name;
    }

    public String getHome() {
        return home;
    }

    public String getWork() {
        return work;
    }

    public String getNumbers(boolean abbr) {

        String h = "(home) ";
        String w = "(work) ";

        if (abbr) {
            h = "(h) ";
            w = "(w) ";
        }

        String nums = "";
        if (!home.equals("")) {
            nums += h + home;
        }
        if (!work.equals("")) {
            if (!nums.equals("")) {
                nums += " ";
            }
            nums += w + work;
        }

        return nums;
    }

    public String getInfo() {
        String info = name;
        String nums = getNumbers(false);
        if (!nums.equals("")) {
            info += " " + nums;
        }
        return info;
    }

}
