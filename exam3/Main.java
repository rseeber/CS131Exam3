package exam3;

import java.util.Scanner;

class Main {

    final static String JFK_SPEECH = 
    "We set sail on this new sea because there is new knowledge to be gained, and new rights to be won, "+
    "and they must be won and used for the progress of all people. For space science, like nuclear science "+
    "and all technology, has no conscience of its own. Whether it will become a force for good or ill "+
    "depends on man, and only if the United States occupies a position of pre-eminence can we help decide "+
    "whether this new ocean will be a sea of peace or a new terrifying theater of war. I do not say that "+
    "we should or will go unprotected against the hostile misuse of space any more than we go unprotected "+
    "against the hostile use of land or sea, but I do say that space can be explored and mastered without "+
    "feeding the fires of war, without repeating the mistakes that man has made in extending his writ "+
    "around this globe of ours. There is no strife, no prejudice, no national conflict in outer space as "+
    "yet. Its hazards are hostile to us all. Its conquest deserves the best of all mankind, and its "+
    "opportunity for peaceful cooperation may never come again. But why, some say, the Moon? Why choose "+
    "this as our goal? And they may well ask, why climb the highest mountain? Why, 35 years ago, fly the "+
    "Atlantic? Why does Rice play Texas? We choose to go to the Moon. We choose to go to the Moon... We "+
    "choose to go to the Moon in this decade and do the other things, not because they are easy, but "+
    "because they are hard; because that goal will serve to organize and measure the best of our energies "+
    "and skills, because that challenge is one that we are willing to accept, one we are unwilling to "+
    "postpone, and one we intend to win, and the others, too\n"+
    "\t(President Kennedy, 1962)";

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        //creates a new cipher object, with jump value of 3
        Cipher cipher = new Cipher(3);
        System.out.println("Pick message to encrypt:\n[1] \"Hello, World\"\n[2] JFK's 'We Choose To Go To The Moon' Speech\n");
        int pick = scnr.nextInt();
        scnr.close();
        
        //the message we're going to be encrypting
        String msg = "Hello, World";
        //if it's a 2, re-assign
        if(pick == 2){
            msg = JFK_SPEECH;
        }

        System.out.println("[This is orginal message]:\n" + msg);
        String passwd = "password1!";
        String checksum = cipher.getChecksum(msg, passwd);
        
        // Encrypt with Caeser
        msg = cipher.caeserCipher(msg);
        System.out.println("\n[Encrypted with caeser]:\n" + msg);

        //now decrypt and test checksum
        msg = cipher.undoCaeser(msg);
        boolean legit = cipher.verifyChecksum(msg, passwd, checksum);
        if(legit){
            System.out.println("\n[Checksum passes, the message is from who you think it's from.]");
        }
        else{
            System.out.println("\n[Checksum failed. No garuntee on the legitimacy of the message.]");
        }
        //print the decrypted message
        System.out.println("[Message]:\n" + msg);

        System.out.println("---------------------------------");

        //Encrypt with Rot13
        msg = cipher.rot13(msg);

        System.out.println("\n[Encrypted with ROT13]:\n" + msg);

        //Decrypt
        msg = cipher.rot13(msg);
        System.out.println("\n[Original Message]:\n" + msg);
    }
}