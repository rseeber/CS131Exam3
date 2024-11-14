package exam3;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Cipher cipher = new Cipher(3);
        String output;
        String passwd = "";
        String checksum = "";
        int doChecksum = -1;
        int encryption = -1;

        //get the protocol
        System.out.print("Pick an option:\n[1] Caeser Cipher\n[2] ROT13\n> ");
        int protocol = scnr.nextInt();
        scnr.nextLine();
        if(protocol == 1){
            //forward or backwards?
            System.out.print("Do you want to encrypt a message, or decrypt?\n[1] Encrypt\n[2] Decrypt\n > ");
            encryption = scnr.nextInt();
            
            //do checksum?
            System.out.print("Do checksum?\n[1] Yes\n[2] No\n> ");
            doChecksum = scnr.nextInt();
            scnr.nextLine();
        }
        
        //get message
        System.out.print("Paste input message:\n> ");
        String msg = scnr.nextLine();

        if (doChecksum == 1){
            //get password
            System.out.print("Paste shared secret (password)\n> ");
            passwd = scnr.nextLine();
            //get checksum if we're decrypting
            if(encryption == 2){
                System.out.print("Paste checksum from transmission\n> ");
                checksum = scnr.nextLine();
            }
        }

        scnr.close();

        //if protocol is caeser
        if(protocol == 1){
            if(encryption == 1){
                output = cipher.caeserCipher(msg);
                System.out.println("[Encrypted Message]:\n"+output);
                if(doChecksum == 1){
                    checksum = cipher.getChecksum(msg, passwd);
                    System.out.println("\n[Checksum]:\n"+checksum);
                }
            }
            else{
                output = cipher.undoCaeser(msg);
                boolean secure = true;
                if(doChecksum == 1){
                    secure = cipher.verifyChecksum(output, passwd, checksum);
                }
                if(secure){
                    System.out.println("\n[Decrypted Message]:\n" + output + "\n\n");
                    if(doChecksum == 1){
                        System.out.println("[Notice]:\nChecksum matches message + password combination. Your transmission is from who you think it's from.\n");
                    }
                }
                else{
                    System.out.println("CHECKSUM DOESN'T MATCH MESSAGE + PASSWORD COMBINATION. ABORTING\n");
                }
            }
        }
        //protocol is ROT13
        else{
            output = cipher.rot13(msg);
            System.out.println("\n[Decrypted Message]:\n" + output + "\n");;
        }
    }
}