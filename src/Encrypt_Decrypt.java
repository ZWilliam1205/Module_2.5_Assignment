import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
public class Encrypt_Decrypt {
    int shiftValue;

    public Encrypt_Decrypt(){}
    // This method is used to handle the user input for encryption.
    public void handleUser_Encrypt(){
        System.out.println("Please enter the shift value (a number from 0 to 25) that you want to encrypt your text by: ");
        Scanner scanner = new Scanner(System.in);
        shiftValue = scanner.nextInt();
        System.out.println("Please enter the texts that you want to encrypt: ");
        while(scanner.hasNext()){
            String text = scanner.nextLine();
            text = text.toLowerCase();
            String encryptedText = Encrypt(text);
            System.out.println(encryptedText);
        }
    }
    // This method is used to handle the user input for decryption.
    public void handleUser_Decrypt(){
        System.out.println("Please enter the key value (a number from 0 to 25) that your text was encrypted by: ");
        Scanner scanner = new Scanner(System.in);
        shiftValue = scanner.nextInt();
        System.out.println("Please enter the texts that you want to decrypt: ");
        while(scanner.hasNext()){
            String text = scanner.nextLine();
            text = text.toLowerCase();
            String decryptedText = Decrypt(text);
            System.out.println(decryptedText);
        }
    }
    // This method is used to encrypt texts.
    public String Encrypt(String text){

        int length = text.length();
        String encryptedText = "";

        for (int i = 0 ; i < length ; i++){
            char c = text.charAt(i);
            int asciiValue = (int) c ;
            if(asciiValue >= 97 && asciiValue < 123){
                asciiValue+=shiftValue;
                if(asciiValue > 122){
                    asciiValue-=26;
                }
                char castedChar = (char) asciiValue;
                encryptedText+= castedChar;
            }
            else{
                encryptedText+= c;
            }
        }
        return encryptedText;
    }
    // This method is used to decrypt texts.
    public String Decrypt(String text){

        int length = text.length();
        String decryptedText = "";

        for (int i = 0 ; i < length ; i++){
            char c = text.charAt(i);
            int asciiValue = (int) c;

            if(asciiValue >= 97 && asciiValue < 123){
                asciiValue-=shiftValue;
                if(asciiValue <= 96){
                    asciiValue+=26;
                }
                    char castedChar = (char) asciiValue;
                    decryptedText+= castedChar;
            }
            else{
                decryptedText+= c;
            }
        }
        return decryptedText;
    }
}
