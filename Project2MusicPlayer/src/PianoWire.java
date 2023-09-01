public class PianoWire extends Wire{

    public PianoWire(int wireNum) {
        super(wireNum, 0.995);
    }

    @Override
    public double generateValue(int index, int wireLength) {
        double x = index / (Math.PI * wireLength / 2);
        return Math.sin(x) - 0.5;
    }
}
