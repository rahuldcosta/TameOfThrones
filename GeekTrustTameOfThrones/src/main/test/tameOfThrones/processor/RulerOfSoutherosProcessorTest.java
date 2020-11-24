package tameOfThrones.processor;

import org.junit.Assert;
import org.junit.Test;
import tameOfThrones.exception.NotAlphabetException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static tameOfThrones.constants.KingdomConstants.*;
import static tameOfThrones.constants.KingdomConstants.WHITESPACE;

public class RulerOfSoutherosProcessorTest {
    RulerOfSoutherosProcessor rulerOfSoutherosProcessor = new RulerOfSoutherosProcessor();
    String resultOutput = "";
    @Test
    public void testExecuteWithSample1() {
        try (BufferedReader br = new BufferedReader(new FileReader(new File(System.getProperty("user.dir") + "\\src\\resources\\sample1.txt")))) {
            String line;
            StringBuilder result = new StringBuilder(RULER_KINGDOM);
            Set<String> alliesKingdoms = new LinkedHashSet<>();
            while ((line = br.readLine()) != null) {
                String[] arguments = line.split(WHITESPACE);
                String encryptedMessage = String.join(WHITESPACE, Arrays.stream(arguments).skip(1).collect(Collectors.toList()));
                alliesKingdoms.add(rulerOfSoutherosProcessor.execute(arguments[0], encryptedMessage));
            }
            buildResponse(result, alliesKingdoms);
            if (checkNumberOfSupportingRulersEligibility(result))
                resultOutput = result.toString();
            else
                resultOutput = NEGATIVE_RESULT;
        } catch (NotAlphabetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(resultOutput, "SPACE AIR LAND ICE");
    }

    @Test
    public void testExecuteWithSample2() {

        try (BufferedReader br = new BufferedReader(new FileReader(new File(System.getProperty("user.dir") + "\\src\\resources\\sample2.txt")))) {
            String line;
            StringBuilder result = new StringBuilder(RULER_KINGDOM);
            Set<String> alliesKingdoms = new LinkedHashSet<>();
            while ((line = br.readLine()) != null) {
                String[] arguments = line.split(WHITESPACE);
                String encryptedMessage = String.join(WHITESPACE, Arrays.stream(arguments).skip(1).collect(Collectors.toList()));
                alliesKingdoms.add(rulerOfSoutherosProcessor.execute(arguments[0], encryptedMessage));
            }
            buildResponse(result, alliesKingdoms);
            if (checkNumberOfSupportingRulersEligibility(result))
                resultOutput = result.toString();
            else
                resultOutput = NEGATIVE_RESULT;
        } catch (NotAlphabetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(resultOutput, "SPACE LAND ICE FIRE");
    }

    @Test
    public void testExecuteWithSample3() {

        try (BufferedReader br = new BufferedReader(new FileReader(new File(System.getProperty("user.dir") + "\\src\\resources\\sample3.txt")))) {
            String line;
            StringBuilder result = new StringBuilder(RULER_KINGDOM);
            Set<String> alliesKingdoms = new LinkedHashSet<>();
            while ((line = br.readLine()) != null) {
                String[] arguments = line.split(WHITESPACE);
                String encryptedMessage = String.join(WHITESPACE, Arrays.stream(arguments).skip(1).collect(Collectors.toList()));
                alliesKingdoms.add(rulerOfSoutherosProcessor.execute(arguments[0], encryptedMessage));
            }
            buildResponse(result, alliesKingdoms);
            if (checkNumberOfSupportingRulersEligibility(result))
                resultOutput = result.toString();
            else
                resultOutput = NEGATIVE_RESULT;
        } catch (NotAlphabetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(resultOutput, "NONE");
    }

    @Test
    public void testExecuteWithDuplicateKingdoms() {

        try (BufferedReader br = new BufferedReader(new FileReader(new File(System.getProperty("user.dir") + "\\src\\resources\\sample4.txt")))) {
            String line;
            StringBuilder result = new StringBuilder(RULER_KINGDOM);
            Set<String> alliesKingdoms = new LinkedHashSet<>();
            while ((line = br.readLine()) != null) {
                String[] arguments = line.split(WHITESPACE);
                String encryptedMessage = String.join(WHITESPACE, Arrays.stream(arguments).skip(1).collect(Collectors.toList()));
                alliesKingdoms.add(rulerOfSoutherosProcessor.execute(arguments[0], encryptedMessage));
            }
            buildResponse(result, alliesKingdoms);
            if (checkNumberOfSupportingRulersEligibility(result))
                resultOutput = result.toString();
            else
                resultOutput = NEGATIVE_RESULT;
        } catch (NotAlphabetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(resultOutput, "NONE");
    }

    @Test
    public void testExecuteWithSpacesInMessage() {

        try (BufferedReader br = new BufferedReader(new FileReader(new File(System.getProperty("user.dir") + "\\src\\resources\\sample5.txt")))) {
            String line;
            StringBuilder result = new StringBuilder(RULER_KINGDOM);
            Set<String> alliesKingdoms = new LinkedHashSet<>();
            while ((line = br.readLine()) != null) {
                String[] arguments = line.split(WHITESPACE);
                String encryptedMessage = String.join(WHITESPACE, Arrays.stream(arguments).skip(1).collect(Collectors.toList()));
                alliesKingdoms.add(rulerOfSoutherosProcessor.execute(arguments[0], encryptedMessage));
            }
            buildResponse(result, alliesKingdoms);
            if (checkNumberOfSupportingRulersEligibility(result))
                resultOutput = result.toString();
            else
                resultOutput = NEGATIVE_RESULT;
        } catch (NotAlphabetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(resultOutput, "SPACE FIRE AIR WATER");
    }

    private static void buildResponse(StringBuilder result, Set<String> alliesKingdoms) {
        result.append(String.join(WHITESPACE, alliesKingdoms.stream().filter(kingdom -> !kingdom.isEmpty()).collect(Collectors.toCollection( LinkedHashSet::new ))));
    }

    public static boolean checkNumberOfSupportingRulersEligibility(StringBuilder result) {
        return result.toString().split(WHITESPACE).length >= 4;
    }
}
