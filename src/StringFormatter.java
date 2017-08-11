import java.util.*;

public class StringFormatter {

  public static void main (String[] args){

    String inputString = "сапог саше сарай арбуз аб болт бокс биржа";
    SortedSet<String> wordsSet = new TreeSet<>(Arrays.asList(inputString.split(" ")));
    TreeMap<String, List<String>> wordsMap = new TreeMap<>();
    for(String item : wordsSet){
      String s = item.substring(0,1);
      if(!wordsMap.containsKey(item.substring(0,1))){
        List<String> l = new ArrayList<>();
        l.add(item);
        wordsMap.put(s, l);
      }else{
        wordsMap.get(s).add(item);
      }
    }
    wordsMap.forEach((k, v) -> v.sort(new StringComparator()));
    System.out.println(wordsMap.toString().replaceAll("\\{", "[").replaceAll("\\}","]"));
  }
}

