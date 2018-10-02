/**
 * ClassName: DictionaryCommandline
 * @author Kieu Chi Cong
 * @author Tran Manh Cuong
 * @version 1.0
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
    /**
     * <div>v1: commandline so khai </div>
     * <div>goi ham chen insertFromCommandline()</div> 
     * <div>goi ham hien thi showAllWords()</div>
     * @param management
     * @param dict
     */
    public void dictionaryBasic(DictionaryManagement management, Dictionary dict){
        dict = management.insertFromCommandline();        
        this.showAllWords(dict);
    }

    /**
     * <div>v2: cai tien lan 1</div>
     * <div>goi ham chen insertFromFile()</div> 
     * <div>goi ham hien thi showAllWords()</div>
     * <div>goi ham tra tu dictionaryLookup()</div>
     * @param management
     * @param dict
     */
    public void dictionaryAdvanced(DictionaryManagement management, Dictionary dict){
        dict = management.insertFromFile();
        this.showAllWords(dict);
        management.dictionaryLookup(dict);
    }
}