package ca.uvic.seng330.ex9;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CsvParser<T> {

  private final InputStream inputStream;
  private final CsvMapper mapper = new CsvMapper();
  private final CsvSchema schema;
  private final Class<T> clazz;

  public CsvParser(Class<T> clazz, String filePath){
    this.inputStream = CsvParser.class.getClassLoader().getResourceAsStream(filePath);
    schema = mapper.schemaFor(clazz).withHeader();
    this.clazz = clazz;
  }

  public List<T> parseToList() throws IOException {
    List<T> results = new ArrayList<>();
    MappingIterator<T> it = mapper.readerFor(clazz).with(schema).readValues(inputStream);

    while (it.hasNextValue()){
      try{
        results.add(it.nextValue());
      } catch (Exception e){
        System.err.println("Warning line omitted from CSV: " + e.getMessage());
      }
    }

    return results;
  }


}
