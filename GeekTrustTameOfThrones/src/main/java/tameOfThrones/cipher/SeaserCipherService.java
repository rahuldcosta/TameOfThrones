package tameOfThrones.cipher;

import tameOfThrones.constants.enums.KingdomTypeCipherKey;
import tameOfThrones.exception.NotAlphabetException;

public class SeaserCipherService {

    public String decryptMessage(KingdomTypeCipherKey type, String text) throws NotAlphabetException {
        StringBuilder message = new StringBuilder(text);
        for (int i = 0; i < message.length(); i++) {
            if(message.charAt(i) == ' ')
                continue;
            if ((message.charAt(i) >= 'A' && message.charAt(i) <= 'Z')) {
                if (message.charAt(i) - type.getKey() < 'A')
                    message.setCharAt(i, (char) ('Z' + message.charAt(i) - '@' - type.getKey()));
                else
                    message.setCharAt(i, (char) (message.charAt(i) - type.getKey()));
            } else
                throw new NotAlphabetException("["+message.charAt(i) + "] Is not a alphabet");
        }
        return message.toString();
    }
}
