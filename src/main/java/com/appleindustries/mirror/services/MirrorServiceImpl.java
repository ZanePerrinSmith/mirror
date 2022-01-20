package com.appleindustries.mirror.services;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

/**
 * @author zane
 */
@Service
public class MirrorServiceImpl implements MirrorService {
    private static final String SPACE = " ";
    private static final String PUNCTUATION = "\\p{Punct}";

    /**
     *
     * @param sentence from URL
     * @return sentence in with words in reverse order
     */
    @Override
    public String mirrorSentence(String sentence) {
        StringBuilder mirroredSentence = new StringBuilder();
        String[] sentenceArray = sentence.split(SPACE);

        for (int i = sentenceArray.length - 1; i >= 0; i--) {
            String word = prependPunctuation(sentenceArray[i]);
            mirroredSentence.append(word);
            mirroredSentence.append(SPACE);
        }
        return mirroredSentence.toString().trim();
    }

    private String prependPunctuation(String word) {
        String prependedWord = word;
        String lastCharacter = getLastCharacterOf(word);

        if (isPunctuation(lastCharacter)) {
            prependedWord = lastCharacter + word.substring(0, word.length() - 1);
        }
        return prependedWord;
    }

    private String getLastCharacterOf(String word) {
        return String.valueOf(word.charAt(word.length() - 1));
    }

    private boolean isPunctuation(String character) {
        return Pattern.matches(PUNCTUATION, character);
    }

}
