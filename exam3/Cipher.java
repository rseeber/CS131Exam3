package exam3;

public class Cipher {
    //interval to use for the caeser cipher
    int interval;

    public Cipher(int interval){
        this.interval = interval;
    }

    public String caeserCipher(String input){
        //performs caeserCipher by using the rotN function, 
        //inputting the predetermined interval
        String output = rotN(input, interval);
        return output;
    }

    public String rot13(String input){
        //uses the rotN() function with a jump size of 13
        String output = rotN(input, 13);
        return output;
    }

    //performs the rot function, but you can input your own jump value
    public String rotN(String input, int jump){
       
        String output = "";
        for(int i = 0; i < input.length(); i++){
            char original = input.charAt(i);
            char c = (char)(original + jump);

            //don't shift c, if it isn't a letter
            if(original < 'A' || (original > 'Z' && original < 'a') || original > 'z'){
                c = original;
            }
            //if it's a letter, make sure we loop it around from Z back to A
            else{
                //Genesis's while loop, with updated conditions by River
                while((c > 'Z' && original <= 'Z') || (c > 'z')){
                    c -= 26;
                }
            }
            //appends c to the end of output
            output += c;
        }
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
