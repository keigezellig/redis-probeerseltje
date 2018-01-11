package redistest.dataprovider;

public class DescriptionProvider {
    public String getDescriptionForNumber(double number) {
        System.out.println("Thinking thinking..");
        System.out.println("Thinking thinking..");
        System.out.println("Thinking thinking..");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Found description....");
        return String.format("Description for number %f", number);
    }
}
