package redistest;


import redistest.cache.Cache;
import redistest.dataprovider.DescriptionProvider;

public class NumberDescriptorImpl implements NumberDescriptor{

    private Cache cache;
    private DescriptionProvider descriptionProvider;

    public NumberDescriptorImpl(Cache cache, DescriptionProvider descriptionProvider) {
        this.cache = cache;
        this.descriptionProvider = descriptionProvider;
    }

    @Override
    public String getDescriptionForNumber(double number) {
        String description = cache.get(number);
        if (description != null) {
            System.out.println(String.format("Cache hit for %s", number));
        }
        else {
            System.out.println(String.format("Cache miss for %s", number));
            description = descriptionProvider.getDescriptionForNumber(number);
            cache.put(number, description);
        }

        return description;
    }
}
