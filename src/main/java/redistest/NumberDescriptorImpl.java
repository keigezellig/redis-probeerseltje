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
        if (description == null) {
            description = descriptionProvider.getDescriptionForNumber(number);
            cache.put(number, description);
        }

        return description;
    }
}
