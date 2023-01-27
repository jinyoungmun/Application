import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {

        BufferedReader engReader = new BufferedReader(new FileReader("C:\\untitled\\src\\main\\resources\\english.txt"));

        BufferedReader korReader = new BufferedReader(
                new InputStreamReader(new FileInputStream("C:\\untitled\\src\\main\\resources\\korean.txt"), "UTF-8")
        );

        List<String> engList = new ArrayList<>();
        List<String> korList = new ArrayList<>();

        String eng;
        while ((eng = engReader.readLine()) != null) {
            engList.add(eng+"\n");
        }
        engReader.close();

        String kor;
        while ((kor = korReader.readLine()) != null) {
            korList.add(kor+"\n");
        }
        korReader.close();

        File file = new File("C:\\untitled\\src\\main\\resources\\result.txt");
        FileOutputStream fos = new FileOutputStream(file);

        if(engList.size() == korList.size()){
            for(int i = 0 ; i < engList.size(); i++){
                fos.write(engList.get(i).getBytes());
                fos.write(korList.get(i).getBytes());
            }
            System.out.println("영어와 한글의 문장 수 동일");
            System.out.println("<-----결과 파일 생성 성공----->");
        }else {
            System.out.println("영어와 한글의 문장 수가 동일하지 않습니다.");
            System.out.println("<-----결과 파일 생성 실패----->");
        }
        fos.close();

    }
}
