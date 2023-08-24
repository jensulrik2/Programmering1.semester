public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Jens",13);
        Gift gift1 = new Gift("Computer");
        Gift gift2 = new Gift("iPad");
        Gift gift3 = new Gift("Bibelen");
        gift1.setPrice(5000);
        gift2.setPrice(3000);
        gift3.setPrice(250);
        p1.addGift(gift1);
        p1.addGift(gift2);
        p1.addGift(gift3);
        Person p2 = new Person("Jørgen", 75);
        Person p3 = new Person("Maria",33);
        gift1.setPerson(p2);
        gift2.setPerson(p3);
        gift3.setPerson(p1);
        System.out.println(p1.toString() + " fik ialt for " + p1.priceTotal() + " kr");
        System.out.println(gift1.getPerson().toString());
    }
}