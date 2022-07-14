package osc.hello.singleton;

public class StatefulService {

//    private int price; // 프라이베이트니까 상태 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price;
        return price;
    }

//    public int getPrice() {
//        return price;
    }

