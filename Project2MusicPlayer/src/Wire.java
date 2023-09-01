import java.util.LinkedList;
import java.util.Queue;
public class Wire {
    //fields
    private double decayRate;
    private Queue<Double> notes;


    //constructors
    public Wire(){
        this.decayRate = 0.996;
        this.notes = new LinkedList<>();
        int wireLength = calculateWireLength(0);
        buildWire(wireLength);
    }

    public Wire(int wireNum) {
        int wireLength = calculateWireLength(wireNum);
        buildWire(wireLength);
        this.decayRate = 0.996;
    }

    public Wire(int wireNum, double decayRate){
        this.decayRate = decayRate;
        this.notes = new LinkedList<>();
        int wireLength = calculateWireLength(wireNum);
        buildWire(wireLength);
    }


    //methods
    public int calculateWireLength(int wireNum){
        double length =  StdAudio.SAMPLE_RATE * Math.pow(2,(double)( 22 - wireNum ) / 12) / 440;
        return (int) length;
    }

    public void buildWire(int num){
        notes = new LinkedList<>();
        for(int i=0; i < num; i++){
            notes.add(0.0);
        }
    }

    public double generateValue(int index, int wireLength) {
        return (-0.5 + (Math.random() + 0.5));
    }

    public void strikeWire() {
        for (int i = 0; i < notes.size(); i++) {
            double val = notes.remove();
            double value = generateValue(i, notes.size());
            notes.add(value);
        }

    }

    public double sample() {
        double val = notes.remove();
        double nextVal = notes.peek();
        double avg = ((val + nextVal) / 2.0) * decayRate;
        notes.add(avg);
        return val;
    }


}
