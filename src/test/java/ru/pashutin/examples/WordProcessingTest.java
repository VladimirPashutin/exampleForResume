package ru.pashutin.examples;

import org.junit.Assert;
import org.junit.Test;
import ru.pashutin.examples.dto.GroupOfWords;

import java.util.Collection;

public class WordProcessingTest extends Assert {
  public static final String sourceOfWords1 = "сапог сарай арбуз болт бокс биржа";
  public static final String[] groupOfWords_1 = {"биржа", "бокс", "болт"};
  public static final String[] groupOfWords_2 = {"сапог", "сарай"};

  @Test public void processWords() {
    WordsProcessor processor = new WordsProcessor();
    Collection<GroupOfWords> groups = processor.processSourceString(sourceOfWords1);
    assertEquals(3, groups.size());
    assertEquals(Character.valueOf('а'), ((GroupOfWords)groups.toArray()[0]).getKey());
    assertEquals(Character.valueOf('б'), ((GroupOfWords)groups.toArray()[1]).getKey());
    assertEquals(Character.valueOf('с'), ((GroupOfWords)groups.toArray()[2]).getKey());
    assertEquals(1, ((GroupOfWords)groups.toArray()[0]).getWords().size());
    assertArrayEquals(groupOfWords_1, ((GroupOfWords)groups.toArray()[1]).getWords().toArray());
    assertArrayEquals(groupOfWords_2, ((GroupOfWords)groups.toArray()[2]).getWords().toArray());
  }

}
