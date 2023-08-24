public class Opgave2
{
    public static void main(String[] args){
        /*
        200 undervisnings dage pr. år
        såååå antal madpakker smurt hen til nytår, er et halvt skole år?
        så 100 dage yo?
        2 madpakker pr. dag

        Skriv et program, der beregner hvor mange madpakker underviseren har smurt til nytår
        (det kan antages, at alle børn har fødselsdag i juli)
         */

        //laver en liste med alle børnenes aldre
        int[] alder = {6,6,8,15,16,18};
        int madpakker = 0;

    for(int i = 0; i < 6; i++){
        if(alder[i]<10){
            madpakker = madpakker + 400 * alder[i];
        }
    }
    System.out.println("Underviseren har smurt " + madpakker + " madpakker til sine børn som pt er under 10 år i deres levetid");

        int madpakker2 = 0;
    for(int i = 0; i < 6; i++){
        if(alder[i]>=10){
            madpakker2 = madpakker2 + 400 * (alder[i] - 10);
        }
    }
    System.out.println("børnene som er 10 eller mere, har selv smurt " + madpakker2 + " madpakker, siden de fyldte 10");



    }





}
