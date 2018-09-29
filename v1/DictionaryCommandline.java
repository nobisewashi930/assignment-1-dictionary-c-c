/**
 * ClassName: DictionaryCommandline
 * 
 * @author Kieu Chi Cong
 * @author Tran Manh Cuong
 * @version 1.0
 * 
 */
public class DictionaryCommandline {
    /**
     * Hien thi toan bo tu trong Dictionary
     * 
     * @param dict Dictionary
     */
    public void showAllWords(Dictionary dict) {
        int size = dict.arWords.size();
        System.out.printf("\nNo  |English\t\t\t\t|Vietnamese\n");
        for (int i = 0; i < size; i++) {
            System.out.printf("%d   |%s\t\t\t\t|%s\n", i + 1, dict.arWords.get(i).word_target,
                    dict.arWords.get(i).word_explain);
        }

    }

    /**
     * Goi ham chen insertFromCommandline() Goi ham hien thi showAllWords()
     * 
     * @param management
     * @param dict
     */
    public void dictionaryBasic(DictionaryManagement management, Dictionary dict) {

        dict = management.insertFromCommandline();
        this.showAllWords(dict);
    }
}