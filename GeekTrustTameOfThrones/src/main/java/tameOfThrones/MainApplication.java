package tameOfThrones;

import tameOfThrones.exception.NotAlphabetException;
import tameOfThrones.processor.RulerOfSoutherosProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static tameOfThrones.constants.KingdomConstants.*;

public class MainApplication {

    public static void main(String args[]) {
        try (BufferedReader br = new BufferedReader(new FileReader(new File(args[0])))) {
            String line;
            RulerOfSoutherosProcessor rulerOfSoutherosProcessor = new RulerOfSoutherosProcessor();
            StringBuilder result = new StringBuilder(RULER_KINGDOM);
            Set<String> alliesKingdoms = new LinkedHashSet<>();
            while ((line = br.readLine()) != null) {
                String[] arguments = line.split(WHITESPACE);
                String encryptedMessage = String.join(WHITESPACE, Arrays.stream(arguments).skip(1).collect(Collectors.toList()));
                alliesKingdoms.add(rulerOfSoutherosProcessor.execute(arguments[0], encryptedMessage));
            }
            buildResponse(result, alliesKingdoms);
            if (checkNumberOfSupportingRulersEligibility(result))
                System.out.println(result);
            else
                System.out.println(NEGATIVE_RESULT);
        } catch (NotAlphabetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void buildResponse(StringBuilder result, Set<String> alliesKingdoms) {
        result.append(String.join(WHITESPACE, alliesKingdoms.stream().filter(kingdom -> !kingdom.isEmpty()).collect(Collectors.toCollection( LinkedHashSet::new ))));
    }

    public static boolean checkNumberOfSupportingRulersEligibility(StringBuilder result) {
        return result.toString().split(WHITESPACE).length >= 4;
    }


}
