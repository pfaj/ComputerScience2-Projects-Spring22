public class SmartContact extends PhoneContact {

    private String cell;

    @Override
    public String toString() {
        String fmt = "SmartContact[cell=%s]";
        String str = String.format(fmt, cell);
        String parent = super.toString();
        str = str + "+" + parent;
        return str;
    }

    public SmartContact() {
        this.cell = "";
    }

    public SmartContact(String name, String home, String work, String cell) {
        super(name, home, work);
        this.cell = cell;
    }

    public SmartContact(String name, String cell) {
        this(name, "", "", cell);
    }

    public SmartContact(String name) {
        this(name, "");
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getCell() {
        return cell;
    }


    @Override
    public String getNumbers(boolean abbr) {

        String c = "(cell) ";

        if (abbr) {
            c = "(c) ";
        }

        String nums = super.getNumbers(abbr);
        if (!cell.equals("")) {
            c += cell;
            if (!nums.equals("")) {
                c += " ";
            }
            nums = c + nums;
        }

        return nums;
    }


    // amazingly, we do not need to override getInfo!
    // we'll demonstrate this in the tester

}
