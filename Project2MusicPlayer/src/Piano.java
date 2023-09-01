import java.util.ArrayList;
public class Piano extends StringedInstrument{
    private int numWires;
    private ArrayList<PianoWire> wires;

    public Piano(int numWires) {
        if(0 <= numWires && numWires >= 88) {
            setWires(numWires);
        }else{
            setWires(36);
        }
    }

    public Piano() {
        this(36);
    }

    public void setWires(int numWires) {
        wires = new ArrayList<>();
        for (int i = 0; i <= numWires; i++) {
            addWire(new PianoWire(i));
        }
    }


}
