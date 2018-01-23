package utils;

import models.Article;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by echavez on 1/22/18.
 */
public class TagsExtractor {

    private Article article;
    static String NPL_STOPWORDS_ES = "nl-es.txt";
    private String contentStrick;

    public TagsExtractor(Article article) {
        this.article = article;
    }

    public HashSet<String> loadStopWords(String language) {
        HashSet<String> finalSet = new HashSet<>();

        String stopwordsFile;
        if(language.equals("es")) {
            stopwordsFile = TagsExtractor.NPL_STOPWORDS_ES;
        } else {
            stopwordsFile = "nl-"+language+".txt";
        }

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(stopwordsFile).getFile());

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                finalSet.add(line);
            }
            return finalSet;

        } catch(IOException error) {
            error.printStackTrace();
        }
        return null;

    }

    public HashSet<String> processContent() {
        HashSet<String> tags = new HashSet<>();
        String stickContent = this.getStickContent();
        ArrayList<String> wordsInContent = new ArrayList<>();
        wordsInContent = this.getKeyWordsFromContent(stickContent);
        ArrayList<String> repeatedWord = this.getRepeatedWords(wordsInContent);
        return tags;
    }

    private ArrayList<String> getRepeatedWords(ArrayList<String> wordsInContent) {
        ArrayList<String> repeated = new ArrayList<>();
        for(String word : wordsInContent) {
            if(repeated.contains(word)) {

            }
        }
        return repeated;
    }

    public ArrayList<String> getKeyWordsFromContent(String content) {
        String[] splitted = content.split(" ");
        ArrayList<String> notDuplicated = new ArrayList<>();
        for(String word : splitted) {
            if(word.length() > 3) {
                notDuplicated.add(word.replaceAll("[^a-zA-Z]", ""));
            }
        }
        return new ArrayList<>(notDuplicated);
    }

    public String getStickContent() {
        String wholeText = this.article.getTitle() + "\n" + this.article.getContent();
        String doc = Jsoup.parse(wholeText).body().text();
        return doc;
    }


}
