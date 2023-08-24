public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("1",100,1997);
        Car car2 = new Car("2",250,2008);
        Car car3 = new Car("3",550,2020);
        Car car4 = new Car("4",85,1996);
        Car car5 = new Car("5",70,1990);
        Rental rental1 = new Rental(1,14,"21-04-2023");
        Rental rental2 = new Rental(2,28,"13-02-2023");

        rental1.addCar(car1);
        rental1.addCar(car2);
        rental1.addCar(car3);
        rental2.addCar(car4);
        rental2.addCar(car5);

        System.out.println("prisen på " + rental1.getDays() + " dagens udlejning " + rental1.getPrice() + " kr.");



    }






}