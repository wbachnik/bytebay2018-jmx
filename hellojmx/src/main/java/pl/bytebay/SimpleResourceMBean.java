package pl.bytebay;

import java.util.List;
import java.util.Map;

public interface SimpleResourceMBean {

    void doSomething();
    String sendMessage(String name, int value);
    int calculate(int a, int b);

    ComplexInfo getComplexInfo(); // non-standard class!
    String getName();
    Map<String, Integer> getMapping();
    List<String> getList();

    int getSize();
//    void setSize(int size);
//    int getSizeCopy(); // workaround for jconsole
}
