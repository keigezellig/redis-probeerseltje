package redistest;

public class RedisTest {

    public static void main(String[] args) {

        RedisCache cache = new RedisCache();
        cache.init();
        NumberDescriptor n = new NumberDescriptorImpl(cache, new DescriptionProvider());
        System.out.println(n.getDescriptionForNumber(1.33123));
        System.out.println(n.getDescriptionForNumber(1.33123));
        System.out.println(n.getDescriptionForNumber(1.33123));
        System.out.println(n.getDescriptionForNumber(1.33124));
        System.out.println(n.getDescriptionForNumber(1.33125));
        System.out.println(n.getDescriptionForNumber(1.33125));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(n.getDescriptionForNumber(1.33125));
        cache.destroy();


    }
}
