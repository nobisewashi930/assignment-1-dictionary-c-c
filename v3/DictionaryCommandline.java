/**
 * ClassName: DictionaryCommandline
 * @author Kieu Chi Cong
 * @author Tran Manh Cuong
 * @version 1.0
 * 
 */
import java.util.Scanner;


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
    public Dictionary dictionaryBasic(DictionaryManagement management, Dictionary dict){
        System.out.println("*************C&C Dictionary*************");
        System.out.println("");
        System.out.println("VUI LONG SU DUNG CAC LENH DUOI DAY");
        System.out.println("0: Thoat ung dung");
        System.out.println("1: Them tu vao tu dien");
        System.out.println("2: Hien thi danh sach tu");
        
        Scanner reader = new Scanner(System.in);
        char c = reader.next().charAt(0);

        switch (c) {
            case '0':
                System.out.println("Dang thoat ung dung");
                return dict;
            case '1':
                dict = management.insertFromCommandline();  
                break;
            case '2':
            this.showAllWords(dict);  
                break;    
            default:
                break;
        }
        System.out.println("");
        dictionaryBasic( management,  dict);
        return dict;
    }

    /**
     * <div>v2: cai tien lan 1</div>
     * <div>goi ham chen insertFromFile()</div> 
     * <div>goi ham hien thi showAllWords()</div>
     * <div>goi ham tra tu dictionaryLookup()</div>
     * @param management
     * @param dict
     */
    public Dictionary dictionaryAdvanced(DictionaryManagement management, Dictionary dict){
        System.out.println("*************C&C Dictionary V2*************");
        System.out.println("");
        System.out.println("VUI LONG SU DUNG CAC LENH DUOI DAY");
        System.out.println("0: Thoat ung dung");
        System.out.println("1: Them tu vao tu dien bang file");
        System.out.println("2: Hien thi danh sach tu");
        System.out.println("3: Tim kiem tu");
        
        Scanner reader = new Scanner(System.in);
        char c = reader.next().charAt(0);

        switch (c) {
            case '0':
                System.out.println("Dang thoat ung dung");
                return dict;
            case '1':
                dict = management.insertFromFile();
                break;
            case '2':
            this.showAllWords(dict);  
                break;    
                case '3':
                management.dictionaryLookup(dict);
                break;   
            default:
                break;
        }
        System.out.println("");
        dictionaryAdvanced( management,  dict);
        return dict;
    }

    public void dictionarySearcher(Dictionary dict){
        System.out.println("Nhap tu muon serch");
        Scanner sc = new Scanner(System.in);
        String enWord = sc.nextLine();
        
        System.out.printf("Serching result for \"%s\"...\n",enWord);

        for(int i =0 ;i< dict.arWords.size();i++)
        {
            if (dict.arWords.get(i).word_target.contains(enWord)) {

                System.out.printf("%-8d    | %-20s\t\t\t| %s\n",i+1, dict.arWords.get(i).word_target, dict.arWords.get(i).word_explain);
            }
        }
    }
}