package aquarium.models.aquariums;

public class FreshwaterAquarium extends BaseAquarium {
    private static final int MAXIMUM_CAPACITY = 50;

    public FreshwaterAquarium(String name) {
        super(name, MAXIMUM_CAPACITY);
    }
}
