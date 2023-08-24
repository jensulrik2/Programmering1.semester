import java.util.ArrayList;

public class Person {

    private String name;
    private int age;
    private final ArrayList<Gift> gifts = new ArrayList<>();

    public void addGift(Gift gift) {
        if (!gifts.contains(gift)) {
            gifts.add(gift);
        }
    }
    public void removeGift(Gift gift) {
        if (gifts.contains(gift)) {
            gifts.remove(gift);
        }
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int priceTotal(){
        int price = 0;
        for(int i = 0; i < gifts.size(); i++){
            price += gifts.get(i).getPrice();
        }

        return price;
    }



    @Override
    public String toString() {
        return "name='" + name + "\n" +
                ", age=" + age;

    }
}
