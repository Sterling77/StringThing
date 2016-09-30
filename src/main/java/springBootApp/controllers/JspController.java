package springBootApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import java.util.ArrayList;

/**
 * Created by Letricia on 8/8/16.
 */
@Controller
public class JspController {


    @RequestMapping(value = "/")
    public String jspIndex() {
        return "index";
    }

    @RequestMapping(value = "/jspTest")
    public String jspTest() {

        return "test";
    }
//    @RequestMapping(value="/jspUserinput")
//    public String jspUserInput() {
//        return "userinput";

    @RequestMapping(value = "/stringThing")
    public String stringThing() {
        return "stringThing";
    }

    @RequestMapping(value = "/combobulateString")
    public String combobulateString(String sentence, ModelMap map) {
        map.addAttribute("sentence", sentence);
        // Count Words
        String[] words = sentence.split("\\s+");
        int wordCount = words.length;
        map.addAttribute("wordCount", wordCount);
        // Count chars
        char[] characters = sentence.toCharArray();
        int charCount = characters.length;
        map.addAttribute("charCount", charCount);
        // Reverse String
        StringBuilder reverseString = new StringBuilder();
        reverseString.append(sentence);
        reverseString.reverse();
        map.addAttribute("reverseString", reverseString);
        // Translate to Pig Latin
        String pigLatin = pigLatinTranslator(words);
        map.addAttribute("pigLatin", pigLatin);
        // Create Google links
        ArrayList<String> googleLinks = new ArrayList<>();
        for (String word : words) {
            googleLinks.add("https://www.google.com/webhp?#safe=off&hl=en&q=" + word);
        }
        map.addAttribute("googleLinks", googleLinks);
        return "stringThing";
    }

    private String pigLatinTranslator(String[] words) {
        String vowels = "aeiouAEIOU";
        String pigLatin = "";
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (vowels.contains("" + word.charAt(i))) {
                    String prefix = word.substring(0, i);
                    String suffix = word.substring(i);
                    word = suffix + prefix + "ay";
                    break;
                }
            }
            pigLatin += word + " ";
        }
        return pigLatin;
    }
}


//    public static int countWords(String s){
//        int wordCount = 0;
//        boolean word = false;
//        int endOfLine = s.length() -1;
//
//        for (int i = 0; i < s.length(); i++){
//            if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
//                word = true;
//            } else if (!Character.isLetter(s.charAt(i)) && word) {
//                wordCount++;
//                word = false;
//            } else if (Character.isLetter(s.charAt(i)) && i == endOfLine){
//                wordCount++;
//            }
//        }
//        return wordCount;
//    }
//        String userinput = "";{
//        int length = userinput.length();
//
//}
//
//    public static void main(String[] args) {
//        String input = "userinput";
//        StringBuilder input1 = new StringBuilder();
//        input1.append(input);
//        input1 = input1.reverse();
//        for (int i = 0; i < input1.length(); i++)
//            System.out.print(input1.charAt(i));
//    }
//}
//
//
//
//}
//    @RequestMapping(value="/jspUserinput/getSentence")
//    public String getSentence(String s,ModelMap map) {
//        char [] c= s.toCharArray();
//        int countChars = c.length;
//        map.addAttribute("countChars", countChars);
//        return "userinput";
//    }
