package ll1;
import java.util.ArrayList;  
import java.util.TreeSet;  
public class MainClass {  
  
    public static void main(String[] args) throws Exception {  
        // // LL（1）文法产生集合  
        ArrayList<String> gsArray = new ArrayList<String>();  
        // // Vn非终结符集合  
        //TreeSet<Character> nvSet = new TreeSet<Character>();  
        // // Vt终结符集合  
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
        // 设置开始符  
        gs.setS('E');  
        gs.getFollow();  
        gs.getSelect();  
        // 创建一个分析器  
        Analyzer analyzer = new Analyzer();  
        analyzer.setStartChar('E');  
        analyzer.setLl1Gs(gs);  
        analyzer.setStr("i+i*i#");  
        analyzer.analyze();  
        gs.genAnalyzeTable();  
        System.out.println("");  
    }  
  
    /** 
     * 获取非终结符集与终结符集 
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
            // nv在左边  
            nvSet.add(charItem);  
        }  
        for (String gsItem : gsArray) {  
            String[] nvNtItem = gsItem.split("->");  
            // nt在右边  
            String nvItemStr = nvNtItem[1];  
            // 遍历每一个字  
            for (int i = 0; i < nvItemStr.length(); i++) {  
                char charItem = nvItemStr.charAt(i);  
                if (!nvSet.contains(charItem)) {  
                    ntSet.add(charItem);  
                }  
            }  
        }  
  
    }  
  
    /** 
     * 初始化LL(1)文法 
     *  
     * @param gsArray 
     */  
    private static void initGs(ArrayList<String> gsArray) {  
        gsArray.add("E->TG");  
        gsArray.add("G->+TG");  
        gsArray.add("G->-TG");  
        gsArray.add("G->ε");  
        gsArray.add("T->FS");  
        gsArray.add("S->*FS");	
        gsArray.add("S->/FS");
        gsArray.add("S->ε");  
        gsArray.add("F->(E)");  
        gsArray.add("F->i");
    }
    
  
}  