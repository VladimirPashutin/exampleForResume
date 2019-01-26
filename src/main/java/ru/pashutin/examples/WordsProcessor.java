package ru.pashutin.examples;

import ru.pashutin.examples.dto.GroupOfWords;

import java.util.*;

/**
 * Тестовое задание для резюме
 * Входная строка разбивается на слова, слова группируются в группы по первой букве
 * Осуществляется вывод групп по условию и с сортировкой
 * @author Владимир Пашутин
 */
public class WordsProcessor {

  public Collection<GroupOfWords> processSourceString(String source) {
    return processArrayOfWords(source.split(" "));
  }

  public Collection<GroupOfWords> processArrayOfWords(String[] words) {
    Map<Character, GroupOfWords> groups = new TreeMap<>();
    for(String word : words) {
      GroupOfWords group = groups.get(word.charAt(0));
      if(group == null) {
        group = new GroupOfWords();
        groups.put(word.charAt(0), group);
        group.setKey(word.charAt(0));
      }
      group.getWords().add(word);
    }
    return groups.values();
  }

  public static void main(String[] args) {
    System.out.print("Обработка слов -");
    for(String word : args) { System.out.print(" " + word); }
    System.out.println();
    System.out.print("Результат обработки :[");
    boolean firstGroup = true;
    for(GroupOfWords group : new WordsProcessor().processArrayOfWords(args)) {
      if(group.getWords().size() > 1) {
        if(firstGroup) { firstGroup = false; }
        else { System.out.print(", "); }
        System.out.print(group.getKey() + "=[");
        boolean firstWord = true;
        for (String word : group.getWords()) {
          if(firstWord) { firstWord = false; }
          else { System.out.print(", "); }
          System.out.print(word);
        }
        System.out.print("]");
      }
    }
    System.out.print("]");
    System.out.println();
  }

}
