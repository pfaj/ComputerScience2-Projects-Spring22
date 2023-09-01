import java.util.ArrayList;

public class StringedInstrument {
    //fields
    private ArrayList<Wire> wires;

    //constructors
    public StringedInstrument() {
        wires = new ArrayList<>();
    }

    public StringedInstrument(int numWires) {
        this();
        setWires(numWires);
    }

    //setters
    public void addWire(Wire wire) {
        wires.add(wire);
    }

    public void setWires(int numWires) {
        wires = new ArrayList<>();
        for (int i = 0; i <= numWires; i++) {
            addWire(new Wire(i));
        }
    }

    //methods
    public void strikeWire(int wireNumber) {
        if (wireNumber >= 0 && wireNumber < wires.size()) {
            wires.get(wireNumber).strikeWire();
        }
    }

    public void play(){
        double sum = 0.0;
        for(Wire wire : wires){
            sum +=  wire.sample();
        }
        StdAudio.play(sum);

    }

}
