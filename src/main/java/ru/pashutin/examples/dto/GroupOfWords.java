package ru.pashutin.examples.dto;

import java.io.Serializable;
import java.util.*;

/**
 * Структура для хранения групп слов, ключом группы является первая буква слова,
 * слова хранятся в требуемом порядке сортировки - по убыванию оличества символов,
 * при равенстве количества символов по алфавиту
 * @author Владимир Пашутин
 */
public class GroupOfWords implements Serializable {
  protected Collection<String> words;
  protected Character key;

  public Collection<String> getWords() {
    if(words == null) { words = new TreeSet<>(new LengthComparator<>()); }
    return words;
  }

  public Character getKey() {
    return key;
  }

  public void setKey(Character key) {
    this.key = key;
  }

  @Override public boolean equals(Object o) {
    if(this == o) { return true; }
    if(!(o instanceof GroupOfWords)) { return false; }
    GroupOfWords that = (GroupOfWords)o;
    return Objects.equals(getKey(), that.getKey());
  }

  @Override public int hashCode() { return Objects.hash(getKey()); }

  protected static class LengthComparator<T extends String> implements Comparator<T> {

    @Override public int compare(String o1, String o2) {
      if(o1 == null || o2 == null) { return -1; }
      if(o1.length() == o2.length()) { return o1.compareTo(o2); }
      return o2.length() - o1.length();
    }

  }

}
