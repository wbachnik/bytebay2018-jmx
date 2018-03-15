package pl.bytebay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SimpleResource implements SimpleResourceMBean {

    private final String name;
    private int size;
    private final Map<String, Integer> mapping = new HashMap<>();
    private final List<String> list = new ArrayList<>();

    public SimpleResource(String name, int size) {
        this.name = name;
        this.size = size;

        mapping.put("Ala", 10);
        mapping.put("Kota", 11);

        list.add("foo");
        list.add("bar");
        list.add("baz");
    }

    @Override
    public void doSomething()     {
        System.out.println("SimpleResource.doSomething");
    }

    @Override
    public String sendMessage(String name, int value) {
        String message = String.format("Hello %s, your value is %d", name, value);
        System.out.println("SimpleResource.sendMessage: " + message);
        return message;
    }

    @Override
    public int calculate(int a, int b) {
        System.out.println("SimpleResource.calculate: a = [" + a + "], b = [" + b + "]");
        return a + b;
    }

    @Override
    public ComplexInfo getComplexInfo() {
        System.out.println("SimpleResource.getComplexInfo");
        return new ComplexInfo(42, "Answer to the Ultimate Question of Life, the Universe, and Everything");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Map<String, Integer> getMapping() {
        return mapping;
    }

    @Override
    public List<String> getList() {
        return list;
    }

    @Override
    public int getSize() {
        return size;
    }

//    @Override
//    public void setSize(int size) {
//        System.out.println("SimpleResource.setSize: " + size);
//        this.size = size;
//    }
//    @Override
//    public int getSizeCopy() {
//        return size;
//    }

}
