public class Kunde {


        private String lastName;
        private String firstName;

        public Kunde(String lastName, String firstName) {
            this.lastName = lastName;
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }



        @Override
        public String toString(){
            return lastName + " " + firstName;
        }
        public int compareTo(Kunde kunde) {
            return (this.getLastName()+this.getFirstName()).compareTo(kunde.getLastName()+kunde.getFirstName());
    }
}
