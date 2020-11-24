package tameOfThrones.processor;

import tameOfThrones.cipher.SeaserCipherService;
import tameOfThrones.constants.enums.KingdomEmblem;
import tameOfThrones.constants.enums.KingdomTypeCipherKey;
import tameOfThrones.exception.NotAlphabetException;
import tameOfThrones.search.EmblemSearcher;

import static tameOfThrones.constants.KingdomConstants.*;

public class RulerOfSoutherosProcessor {


    private SeaserCipherService seaserCipherService;
    private EmblemSearcher emblemSearcher;

    public RulerOfSoutherosProcessor() {
        seaserCipherService = new SeaserCipherService();
        emblemSearcher = new EmblemSearcher();
    }

    public String execute(String kingdom, String message) throws NotAlphabetException {

        switch (kingdom) {
            case LAND:
                if (emblemSearcher.search(KingdomEmblem.LAND, seaserCipherService.decryptMessage(KingdomTypeCipherKey.LAND, message)))
                    return LAND;
                break;
            case WATER:
                if (emblemSearcher.search(KingdomEmblem.WATER, seaserCipherService.decryptMessage(KingdomTypeCipherKey.WATER, message)))
                    return WATER;
                break;
            case ICE:
                if (emblemSearcher.search(KingdomEmblem.ICE, seaserCipherService.decryptMessage(KingdomTypeCipherKey.ICE, message)))
                    return ICE;
                break;
            case AIR:
                if (emblemSearcher.search(KingdomEmblem.AIR, seaserCipherService.decryptMessage(KingdomTypeCipherKey.AIR, message)))
                    return AIR;
                break;
            case FIRE:
                if (emblemSearcher.search(KingdomEmblem.FIRE, seaserCipherService.decryptMessage(KingdomTypeCipherKey.FIRE, message)))
                    return FIRE;
                break;
        }
        return EMPTY_STRING;
    }

}
