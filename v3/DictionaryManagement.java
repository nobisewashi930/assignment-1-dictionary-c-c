
import java.util.Scanner;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException; 
import java.io.IOException;

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
    
    /**
     * Thay doi du lieu tu dien
     * @return dict Dictionary
     */
    public Dictionary editFromCommandline(Dictionary dict){
        Scanner sc = new Scanner(System.in);        
        String word_target_edit="", new_word_explain_edit="", new_word_target_edit="";

        System.out.println("Ban muon thay doi tu tieng anh hay nghia hay ca hai");
        System.out.println("VUI LONG SU DUNG CAC LENH SAU:");
        System.out.println("1: Thay doi tu tieng anh");
        System.out.println("2: Thay doi nghia");
        System.out.println("3: Thay doi tu va nghia");
        
        char c = sc.next().charAt(0);
        sc.nextLine();

        switch (c) {
            case '1':
                System.out.println("Nhap chinh xac tu ban muon thay doi");
                word_target_edit = sc.nextLine();   
                System.out.println("Nhap tu moi"); 
                new_word_target_edit = sc.nextLine();            
                break;
            case '2':
                System.out.println("Nhap chinh xac tu ma co giai nghia ban muon thay doi");
                word_target_edit = sc.nextLine();               
                System.out.println("Nhap giai nghia moi"); 
                new_word_explain_edit = sc.nextLine();  
                break;
            case '3':
                System.out.println("Nhap chinh xac tu ban muon thay doi ca hai");
                word_target_edit = sc.nextLine();
                System.out.println("Nhap tu moi"); 
                new_word_target_edit = sc.nextLine();
                System.out.println("Nhap giai nghia moi"); 
                new_word_explain_edit = sc.nextLine();
                break;    
            default:
                System.out.println("Ban chon sai chuc nang");
                break;
        }
        
        Word Change = new Word();
        int n = dict.arWords.size();
        System.out.println(n);
        for(int i=0 ; i<n ; i ++)
        {
            if(dict.arWords.get(i).word_target.equals(word_target_edit))
            {                
                if(new_word_target_edit!="" && new_word_explain_edit!="")
                    Change = new Word(new_word_target_edit, new_word_explain_edit);

                else if(new_word_target_edit=="" && new_word_explain_edit!="")
                    Change = new Word(dict.arWords.get(i).word_target, new_word_explain_edit); 

                else if(new_word_target_edit!="" && new_word_explain_edit=="")
                    Change = new Word(new_word_target_edit,dict.arWords.get(i).word_explain);

                dict.arWords.set(i,Change);
            }
        }
            
        return dict;
    }

    /** 
    *Xoa tu khoi tu dien
    *@return dict Dictionary
    */
    public Dictionary deleteFromComandline(Dictionary dict){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap chinh xac tu tieng anh muon xoa");
        String word = sc.nextLine();
        int n = dict.arWords.size();
        for(int i = 0; i<n ;i++){
            // if(dict.arWords.get(i)==null)return dict;
            if(dict.arWords.get(i).word_target.equals(word))
            {
                dict.arWords.remove(i); 
                n--;  
            }
                 
        }
        if(dict.arWords.size()<n)
            System.out.println("Thao tac xoa khong thanh cong do ban nhap tu khong co trong tu dien");

        return dict;
    }

    public void dictionaryExportToFile(Dictionary dict){
        
        try {
            FileOutputStream outFile = new FileOutputStream("textfile.txt");
            BufferedOutputStream  stream = new BufferedOutputStream (outFile);

        int n = dict.arWords.size();
        for(int i = 0; i<n ;i++){
                String line = dict.arWords.get(i).word_target+"\t" + dict.arWords.get(i).word_explain;
                stream.write(line.getBytes());
                stream.write(System.lineSeparator().getBytes()) ;

            } 
            stream.close(); 

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}