package com.masakir.nlp;

import java.util.Set;

import edu.cmu.lti.jawjaw.JAWJAW;
import edu.cmu.lti.jawjaw.pobj.POS;

/**
 * Created by masabon on 2015/08/29.
 */
public class JawJawCli {
    /**
     * run
     *
     * @param word
     * @param pos
     */
    private static void run(String word, POS pos) {
        // ファサードから日本語 WordNet にアクセス
        Set<String> hypernyms = JAWJAW.findHypernyms(word, pos);
        Set<String> hyponyms = JAWJAW.findHyponyms(word, pos);
        Set<String> consequents = JAWJAW.findEntailments(word, pos);
        Set<String> translations = JAWJAW.findTranslations(word, pos);
        Set<String> definitions = JAWJAW.findDefinitions(word, pos);

        // 結果表示（多義語はごっちゃになっています）
        System.out.println("hypernyms of " + word + " : \t" + hypernyms);
        System.out.println("hyponyms of " + word + " : \t" + hyponyms);
        System.out.println(word + " entails : \t\t" + consequents);
        System.out.println("translations of " + word + " : \t" + translations);
        System.out.println("definitions of " + word + " : \t" + definitions);
    }

    private static void printUsage() {
        System.out.println("com.masakir.nlp.JawJawCli -options");
        System.out.println(" -w | --word [word]");
        System.out.println("  検索するwordを指定");

        System.out.println(" -p | --pos [pos]");
        System.out.println("  a:形容詞, n:名詞, r:副詞 v:動詞 で品詞を指定");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // process args
        String word = null;
        POS pos = null;
        for (int i = 0; i < args.length; ++i) {
            if (args[i].equals("-w") || args[i].equals("--word")) {
                word = args[++i];
            }
            if (args[i].equals("-p") || args[i].equals("--pos")) {
                String a = args[++i];
                try {
                    pos = POS.valueOf(a);
                } catch (Exception e) {
                    System.err.println("! invalid argumement: " + a);
                    System.exit(1);
                }
            }
        }
        if (word == null || pos == null) {
            printUsage();
            System.exit(1);
        }
        run(word, pos);
    }
}