public class StringManipulator {
    public String trimAndConcat(String str1, String str2){
        String finishedString;

        str1 = str1.trim();
        str2 = str2.trim();
        finishedString = str1.concat(str2);

        return finishedString;
    }
    public Integer getIndexOrNull(String str, char letter){
        int index = str.indexOf(letter);
        if(index == -1){
            return null;
        }
        else{
            return index;
        }
    }
    public Integer getIndexOrNull(String mainString, String queriedString){
        int index = mainString.indexOf(queriedString);
        if(index == -1){
            return null;
        }
        else{
            return index;
        }
    }
    public String concatSubstring(String firstString, int startIndex, int endIndex, String secondString){
        String firstSubstring = firstString.substring(startIndex, endIndex);
        String finishedString = firstSubstring.concat(secondString);

        return finishedString;
    }
}