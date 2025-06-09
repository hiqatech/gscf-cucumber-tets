package Common;

import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Util {

    public static List<Map<String,String>> List1;
    public static List<Map<String,String>> List2;

    public static String matchingItem = "";
    public static List<String> whatIsNotMatching = new ArrayList<>();


    public static void setList1(List<Map<String, String>> data) {
        List1 = data;
        System.out.println("Setting List1");
        System.out.println("List1 = " + List1);
        System.out.println("--------------------------------------------------");
    }

    public static void setList2(List<Map<String, String>> data) {
        List2 = data;
        System.out.println("Setting List2");
        System.out.println("List2 = " + List2);
        System.out.println("--------------------------------------------------");
    }

    public static void compareLists(){
        int map1LineNumber = 0;
        int map2LineNumber = 0;

        System.out.println("Comparing Lists");
        System.out.println("-Comparing List1 to List2");

        for (Map map1 : List1) {
            System.out.println("Comparing Map1 Item" + map1LineNumber);
            List<String> listHeaders = new ArrayList<String>(map1.keySet());
            List<String> listValues1 = new ArrayList<String>(map1.values());
            for (Map map2 : List2) {
                System.out.println("- with Map2 Item" + map2LineNumber);
                List<String> listValues2 = new ArrayList<String>(map2.values());
                if(listValues1.getFirst().equals(listValues2.getFirst())) {
                    System.out.println("Match found " +
                            listHeaders.getFirst() + " " + listValues1.getFirst());
                    for(int i=1;i<listValues1.size();i++) {
                        if(listValues1.get(i).equals(listValues2.get(i)))
                        {System.out.println("Matching params found " +
                                listHeaders.get(i) + " " + listValues1.get(i));
                            matchingItem = "FOUND";}
                        else {
                            whatIsNotMatching.add("List1 Item " + listValues1.getFirst() + " foud in List2 but not matching on "
                                    + listHeaders.get(i) + " as "
                                    + listValues1.get(i) + " not equals " + listValues2.get(i));
                            System.out.println(whatIsNotMatching.getLast());
                        }
                    }

                }
                if(matchingItem.equals("FOUND")) break;
                map2LineNumber++;
            }
            if(!matchingItem.equals("FOUND")) {
                whatIsNotMatching.add("List 1 Item " + listValues1.getFirst() +  " not found in List2");
                System.out.println(whatIsNotMatching.getLast());
            }
            map2LineNumber = 0;
            map1LineNumber++;
            matchingItem = "";
            System.out.println("---");
        }

        map1LineNumber = 0;
        map2LineNumber = 0;

        System.out.println("-Comparing List2 to List1");

        for (Map map2 : List2) {
            System.out.println("Comparing Map2 Item" + map2LineNumber);
            List<String> listHeaders = new ArrayList<String>(map2.keySet());
            List<String> listValues1 = new ArrayList<String>(map2.values());
            for (Map map1 : List1) {
                System.out.println("- with Map1 Item" + map1LineNumber);
                List<String> listValues2 = new ArrayList<String>(map1.values());
                if(listValues1.get(0).equals(listValues2.get(0))) {
                    System.out.println("Match found " +
                            listHeaders.get(0) + " " + listValues1.get(0));
                    for(int i=1;i<listValues1.size();i++) {
                        if(listValues1.get(i).equals(listValues2.get(i)))
                            matchingItem = "FOUND";}
                }
                if(matchingItem.equals("FOUND")) break;
                map1LineNumber++;
            }
            if(!matchingItem.equals("FOUND")) {
                whatIsNotMatching.add("List2 Item" + listValues1.get(0) +  " not found in List1");
                System.out.println(whatIsNotMatching.getLast());
            }
            map1LineNumber = 0;
            map2LineNumber++;
            matchingItem = "";
            System.out.println("----------------------");
        }

        System.out.println("--------------------------------------------------");
    }

    public static void AssertLists() {
        System.out.println("Asserting Lists discrepancies");
        Assert.assertEquals(whatIsNotMatching.toString(),"");
    }
}
