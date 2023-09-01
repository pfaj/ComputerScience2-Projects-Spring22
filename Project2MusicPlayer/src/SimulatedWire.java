public class SimulatedWire extends Wire{
    public SimulatedWire(int wireNum) {
        super(wireNum, 0.996);
    }

    @Override
    public double generateValue(int index, int wireLength) {
        if (index % (wireLength / 2) < wireLength / 4) {
            return 0.5;
        } else {
            return -0.5;
        }
    }


}
