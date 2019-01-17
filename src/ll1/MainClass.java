package ll1;
import java.util.ArrayList;  
import java.util.TreeSet;  
public class MainClass {  
  
    public static void main(String[] args) throws Exception {  
        // // LL��1���ķ���������  
        ArrayList<String> gsArray = new ArrayList<String>();  
        // // Vn���ս������  
        //TreeSet<Character> nvSet = new TreeSet<Character>();  
        // // Vt�ս������  
        //TreeSet<Character> ntSet = new TreeSet<Character>();  
        Gs gs = new Gs();  
        initGs(gsArray);  
        //initNv(nvSet);
        //initNt(ntSet);
        gs.setGsArray(gsArray);  
        //getNvNt(gsArray, gs.getNvSet(), gs.getNtSet());  
        gs.getNvNt();  
        gs.initExpressionMaps();  
        gs.getFirst();  
        // ���ÿ�ʼ��  
        gs.setS('E');  
        gs.getFollow();  
        gs.getSelect();  
        // ����һ��������  
        Analyzer analyzer = new Analyzer();  
        analyzer.setStartChar('E');  
        analyzer.setLl1Gs(gs);  
        analyzer.setStr("i+i*i#");  
        analyzer.analyze();  
        gs.genAnalyzeTable();  
        System.out.println("");  
    }  
  
    /** 
     * ��ȡ���ս�������ս���� 
     *  
     * @param gsArray 
     * @param nvSet 
     * @param ntSet 
     */  
    private static void getNvNt(ArrayList<String> gsArray, TreeSet<Character> nvSet, TreeSet<Character> ntSet) {  
        for (String gsItem : gsArray) {  
            String[] nvNtItem = gsItem.split("->");  
            String charItemStr = nvNtItem[0];  
            char charItem = charItemStr.charAt(0);  
            // nv�����  
            nvSet.add(charItem);  
        }  
        for (String gsItem : gsArray) {  
            String[] nvNtItem = gsItem.split("->");  
            // nt���ұ�  
            String nvItemStr = nvNtItem[1];  
            // ����ÿһ����  
            for (int i = 0; i < nvItemStr.length(); i++) {  
                char charItem = nvItemStr.charAt(i);  
                if (!nvSet.contains(charItem)) {  
                    ntSet.add(charItem);  
                }  
            }  
        }  
  
    }  
  
    /** 
     * ��ʼ��LL(1)�ķ� 
     *  
     * @param gsArray 
     */  
    private static void initGs(ArrayList<String> gsArray) {  
        gsArray.add("E->TG");  
        gsArray.add("G->+TG");  
        gsArray.add("G->-TG");  
        gsArray.add("G->��");  
        gsArray.add("T->FS");  
        gsArray.add("S->*FS");	
        gsArray.add("S->/FS");
        gsArray.add("S->��");  
        gsArray.add("F->(E)");  
        gsArray.add("F->i");
    }
    
  
}  