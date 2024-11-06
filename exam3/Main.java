package exam3;

class Main {
    public static void main(String[] args) {
        //creates a new cipher object, with jump value of 3
        Cipher cipher = new Cipher(3);
        //the message we're going to be encrypting
        String msg = "Hello, World";
        
        //print caeser cipher
        System.out.println(cipher.caeserCipher(msg));
        
        //print rot13
        System.out.println(cipher.rot13(msg));
        

        //extra stuff that isn't required
        //create a shared secret (a password)
        String passwd = "thisIsAPassword!-";
        //get the checksum for the message and password
        String checksum = cipher.getChecksum(msg, passwd);
        //print checksum
        System.out.println("Checksum: "+checksum);
    }   
}