package ca.uvic.seng330.ex9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.CSS;
import java.io.IOException;

public class TestCsvParser {

  CsvParser<ObservedWhale> parser;

  @Test
  public void testAllValidData() throws IOException {
    parser = new CsvParser<>(ObservedWhale.class, "observations.csv");
    Assertions.assertEquals(10, parser.parseToList().size());
  }

  @Test
  public void testOneInvalidDate() throws IOException {
    parser = new CsvParser<>(ObservedWhale.class, "invalidDate.csv");
    Assertions.assertEquals(9, parser.parseToList().size());
  }

  @Test
  public void testTwoInvalidWeights() throws IOException {
    parser = new CsvParser<>(ObservedWhale.class, "invalidWeight.csv");
    Assertions.assertEquals(8, parser.parseToList().size());
  }


}
