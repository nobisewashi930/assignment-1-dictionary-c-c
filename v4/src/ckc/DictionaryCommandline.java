package ckc;
/**
 * ClassName: DictionaryCommandline
 * @author Kieu Chi Cong
 * @author Tran Manh Cuong
 * @version 6
 * 
 */
public class DictionaryCommandline{
    /**
     * Hien thi toan bo tu trong Dictionary
     * @param dict  Dictionary
     */
    public void showAllWords(Dictionary dict){
        int size = dict.arWords.size();
        System.out.printf("\n%-8s    | %-20s\t\t\t| Vietnamese\n\n","No","English");
        for(int i = 0; i < size; i++)
        {
            System.out.printf("%-8d    | %-20s\t\t\t| %s\n",i+1, dict.arWords.get(i).word_target, dict.arWords.get(i).word_explain);
        }

    }

    // tim kiem bang cach duyet list arWords trong Dictionary, ham nay goi sau hàm selectAll trong class ConfigConnection
    public String dictionarySearcher(Dictionary dict, String enWord){
        String result = "";
        for(int i =0 ;i< dict.arWords.size();i++)
        {
            if (dict.arWords.get(i).word_target.contains(enWord)) {

                result = dict.arWords.get(i).word_explain;
                break;
            }

        }
        return result;
    }
}