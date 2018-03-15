package pl.bytebay;

public class SimpleResourceMX implements SimpleResourceMXBean {

    private final String name;
    private int size;

    public SimpleResourceMX(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void doSomething()     {
        System.out.println("SimpleResourceMX.doSomething");
    }

    @Override
    public String sendMessage(String name, int value) {
        String message = String.format("Hello %s, your value is %d", name, value);
        System.out.println("SimpleResourceMX.sendMessage: " + message);
        return message;
    }

    @Override
    public int calculate(int a, int b) {
        System.out.println("SimpleResourceMX.calculate: a = [" + a + "], b = [" + b + "]");
        return a + b;
    }

    @Override
    public ComplexInfo getComplexInfo() {
        System.out.println("SimpleResourceMX.getComplexInfo");
        return new ComplexInfo(42, "Answer to the Ultimate Question of Life, the Universe, and Everything");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }
}
