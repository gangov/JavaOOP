package aquarium.models.aquariums;

public class SaltwaterAquarium extends BaseAquarium {
    private static final int MAXIMUM_CAPACITY = 25;

    public SaltwaterAquarium(String name) {
        super(name, MAXIMUM_CAPACITY);
    }
}
