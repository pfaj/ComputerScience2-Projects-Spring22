import java.util.ArrayList;

public class Harpsichord extends StringedInstrument{
    private int numWires;
    private ArrayList<HarpsichordWire> wires;

    public Harpsichord(int numWires) {
        if(0 <= numWires && numWires >= 60) {
            setWires(numWires);
        }else{
            setWires(48);
        }
    }

    public Harpsichord() {
        this(48);
    }

    public void setWires(int numWires) {
        wires = new ArrayList<>();
        for (int i = 0; i <= numWires; i++) {
            addWire(new HarpsichordWire(i));
        }
    }



}
