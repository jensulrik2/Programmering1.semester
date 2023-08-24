package storage;

import application.model.Deltager;
import application.model.Hotel;
import application.model.Konference;

import java.util.ArrayList;


public class Storage {


        private static ArrayList<Deltager> deltager = new ArrayList<>();
        private static ArrayList<Konference> konferencer = new ArrayList<>();
        private static ArrayList<Hotel> hoteller = new ArrayList<>();

        // -------------------------------------------------------------------------

        public static ArrayList<Deltager> getDeltagere() {
            return new ArrayList<Deltager>(deltager);
        }

        public static void addDeltager(Deltager deltag) { deltager.add(deltag); }

        public static void removeDeltager(Deltager deltag) {
            deltager.remove(deltag);
        }

        // -------------------------------------------------------------------------

        public static ArrayList<Konference> getKonferencer() {
            return new ArrayList<Konference>(konferencer);
        }

        public static void addKonference(Konference konference) { konferencer.add(konference); }

        public static void removeKonference(Konference konference) { konferencer.remove(konference); }

        // -------------------------------------------------------------------------

        public static ArrayList<Hotel> getHoteller() {return new ArrayList<Hotel>(hoteller);}

        public static void addHotel(Hotel hotel) {
            hoteller.add(hotel);
        }

        public static void removeHotel(Hotel hotel) {
            hoteller.remove(hotel);
        }
    }


