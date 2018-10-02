
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException; 
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
        number = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i<number; i++){            
            Word word = new Word();
            word = this.createWord();            
            dict.addWordToDictionary(word);
        }
        
        return dict;    
    }

    /**
     * Tao ra 1  {word} bang du lieu nguoi dung nhap
     * @return word Word
     */
    public Word createWord(){
        Scanner sc = new Scanner(System.in);
        String engString, vieString;
        System.out.println("Nhap tu tieng anh:");
        engString = sc.nextLine();
        System.out.println("Nhap nghia tieng viet:");
        vieString = sc.nextLine();
        Word word = new Word(engString, vieString);

        return word;
    }
    
    /**
     * Chen du lieu cho tu dien tu file su dung Scanner
     * @return dict Dictionary
     */
    public Dictionary insertFromFile(){
        File file = new File("dictionaries.txt");
        Dictionary dict = new Dictionary();        
        try {
            Scanner sc = new Scanner(file);            
            Word word ;    
            while(sc.hasNextLine()){
                String stringWord = sc.nextLine();

                //trong file co dinh dang: phan cach giua tu va giai nghia la dau tab
                Scanner s = new Scanner(stringWord).useDelimiter("s*\ts*");
                String target = s.next();
                String explain = s.next();
                word = new Word(target,explain);            
                dict.addWordToDictionary(word);        
            }            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }        
        finally{
            return dict;
        }        
    }

    /**
     * tim kiem tu trong tu dien
     * @param dict Dictionary
     * @return void
     */
    public void dictionaryLookup(Dictionary dict){
        String a = "";
        System.out.println("Ban hay nhap tu muon tra:");
        Scanner sc = new Scanner(System.in);
        a= sc.nextLine();
        int i;
        int n= dict.arWords.size();
        for(i=0 ; i<n ; i ++)
            if(dict.arWords.get(i).word_target.equals(a))
            {
                System.out.printf("%s :%s\n",a,dict.arWords.get(i).word_explain);
            }    
    }
    // public editFromCommandline(String word){

    // }
    // public deleteFromComandline(){

    // }
    
    
}