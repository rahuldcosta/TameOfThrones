package tameOfThrones.search;

import tameOfThrones.constants.enums.KingdomEmblem;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EmblemSearcher {


    public Boolean search(KingdomEmblem emblem, String message) {
        Map<Character, Integer> messageCharacterCounterMap = createCharacterCounterMap(message.toLowerCase());
        filterEmblemMatchingKeys(emblem, messageCharacterCounterMap);
        return areEmblemCharactersPresentInMessage(emblem, messageCharacterCounterMap);
    }

    private Boolean areEmblemCharactersPresentInMessage(KingdomEmblem emblem, Map<Character, Integer> messageCharacterCounterMap) {
        Boolean isFound = true;
        for (Map.Entry<Character, Integer> entry : createCharacterCounterMap(emblem.getEmblemType().toLowerCase()).entrySet()
        ) {
            if (!messageCharacterCounterMap.containsKey(entry.getKey()) || !(messageCharacterCounterMap.get(entry.getKey()) >= entry.getValue())) {
                isFound = false;
                break;
            }
        }
        return isFound;
    }

    private void filterEmblemMatchingKeys(KingdomEmblem emblem, Map<Character, Integer> messageCharacterCounterMap) {
        messageCharacterCounterMap.keySet().retainAll(
                emblem.getEmblemType().toLowerCase().chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.toList()));
    }

    private Map<Character, Integer> createCharacterCounterMap(String text) {
        Map<Character, Integer> textCharacterCounterMap = new HashMap<>();
        for (int characterCounter = 0; characterCounter < text.length(); characterCounter++) {
            if (textCharacterCounterMap.containsKey(text.charAt(characterCounter)))
                textCharacterCounterMap.put(text.charAt(characterCounter), textCharacterCounterMap.get(text.charAt(characterCounter)) + 1);
            else
                textCharacterCounterMap.put(text.charAt(characterCounter), 1);
        }
        return textCharacterCounterMap;
    }
}
