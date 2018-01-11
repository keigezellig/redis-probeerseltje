package redistest;


import redistest.cache.Cache;
import redistest.cache.CacheFactory;
import redistest.dataprovider.DescriptionProvider;

public class NumberDescriptorImpl implements NumberDescriptor{

    private Cache<Double, String> cache;
    private DescriptionProvider descriptionProvider;

    public NumberDescriptorImpl(DescriptionProvider descriptionProvider) {
        this.cache = CacheFactory.doubleCache();
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
