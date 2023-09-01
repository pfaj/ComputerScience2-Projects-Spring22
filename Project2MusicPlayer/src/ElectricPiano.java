import java.util.ArrayList;

public class ElectricPiano extends Piano{

    private int numWires;
    private ArrayList<SimulatedWire> wires;

    public ElectricPiano(int numWires) {
        super(numWires);
    }

    public ElectricPiano() {
        super();
    }

    public void setWires(int numWires) {
        wires = new ArrayList<>();
        for (int i = 0; i <= numWires; i++) {
            addWire(new SimulatedWire(i));
        }
    }



}
