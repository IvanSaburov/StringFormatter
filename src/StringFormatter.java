import java.util.*;

public class StringFormatter {

  public static void main (String[] args){

    String inputString = "сапог саше сарай арбуз аб болт бокс биржа";
    List<String> wordsList = new ArrayList<>(Arrays.asList(inputString.split(" ")));
    StringBuilder sb = new StringBuilder("[");
    HashMap<String, List<String>> wordsMap = new HashMap<>();
    for(String item : wordsList){
      String s = String.valueOf(item.charAt(0));
      if(!wordsMap.containsKey(s)){
        List<String> l = new ArrayList<>();
        l.add(item);
        wordsMap.put(s, l);
      }else{
        wordsMap.get(s).add(item);
        wordsMap.get(s).sort(new StringComparator());
      }
    }
    List<String> resultList = new ArrayList<>();
    for(String key : wordsMap.keySet()){
      resultList.add(key +"=["+String.join(",", wordsMap.get(key))+"]");
    }
    sb.append(String.join(", ", resultList)).append("]");
    System.out.println(sb.toString());
  }
}

