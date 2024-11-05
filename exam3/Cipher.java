package exam3;

public class Cipher {
    //interval to use for the caeser cipher
    int interval;

    public Cipher(int interval){
        this.interval = interval;
    }

    public String caeserCipher(String input){
        //TODO: implement
        String output = input;
        return output;
    }

    public String rot13(String input){
        //TODO: implement
        String output = input;
        return output;
    }

    //this isn't part of the project requirements, I'm just adding a little something extra because
    // he encouraged us to have fun with it.
    public String getChecksum(String msg, String passwd){
        //TODO: implement
        String checksum = msg + passwd;
        return checksum;
    }

    //again not required, just a little extra
    //checks whether the provided checksum matches a message-password combination
    public boolean verifyChecksum(String msg, String passwd){
        return true;
    }
}
