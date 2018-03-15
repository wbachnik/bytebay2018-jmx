package pl.bytebay;

public interface SimpleResourceMXBean {

    void doSomething();
    String sendMessage(String name, int value);
    int calculate(int a, int b);

    ComplexInfo getComplexInfo(); // non-standard class!
    String getName();
    int getSize();
    void setSize(int size);
}
