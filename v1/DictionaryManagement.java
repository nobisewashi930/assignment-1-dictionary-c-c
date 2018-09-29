
import java.util.Scanner;
/**
 * <div>Quan li tu dien</div>
 * ClassName: DictionaryManagement
 * @author Kieu Chi Cong
 * @author Tran Manh Cuong
 * @version 1.0
 * 
 */
public class DictionaryManagement{
    public DictionaryManagement(){}
    
    /**
     * chèn dữ liệu vào từ command line
     * @return dict: Dictionary
     */
    public Dictionary insertFromCommandline(){
        Dictionary dict = new Dictionary();
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ban hay nhap so luong tu:");
        String engString, vieString;
        number = sc.nextInt();
        engString = sc.nextLine();

        for(int i = 0; i<number; i++){
            
            System.out.println("Nhap tu tieng anh:");
            engString = sc.nextLine();
            System.out.println("Nhap nghia tieng viet:");
            vieString = sc.nextLine();
            Word word = new Word(engString, vieString);
            
            dict.addWordToDictionary(word);
        }
        
        return dict;
        

    }
    
    
}