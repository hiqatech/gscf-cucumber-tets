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
    public static List<String> expectedMatching = new ArrayList<>();


    public static void setList1(List<Map<String, String>> data) {
        List1 = data;
        System.out.println("Setting List1");
        for (Map map : List1) {
            List<String> listHeaders = new ArrayList<String>(map.keySet());
            List<String> listValues1 = new ArrayList<String>(map.values());
            for (int i = 0; i < listHeaders.size(); i++) {
                System.out.print(listHeaders.get(i) +
                        " = " + listValues1.get(i) + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------");
    }

    public static void setList2(List<Map<String, String>> data) {
        List2 = data;
        System.out.println("Setting List2");
        for (Map map : List2) {
            List<String> listHeaders = new ArrayList<String>(map.keySet());
            List<String> listValues2 = new ArrayList<String>(map.values());
            for (int i = 0; i < listHeaders.size(); i++) {
            System.out.print(listHeaders.get(i) +
                    " = " + listValues2.get(i) + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------");
    }

    public static void compareLists() {
        int list1LineNumber = 0;
        int list2LineNumber = 0;

        System.out.println("Comparing Lists");
        System.out.println("------------------------");
        System.out.println("Comparing List1 to List2");

        for (Map map1 : List1) {
            List<String> listHeaders = new ArrayList<String>(map1.keySet());
            List<String> listValues1 = new ArrayList<String>(map1.values());
            System.out.println("Comparing List1 Item" + list1LineNumber + " " + listValues1.getFirst());
            for (Map map2 : List2) {
                List<String> listValues2 = new ArrayList<String>(map2.values());
                System.out.println("- with List2 Item" + list2LineNumber + " " + listValues2.getFirst());
                if (listValues1.getFirst().equals(listValues2.getFirst())) {
                    System.out.println("Match found " +
                            listHeaders.getFirst() + " " + listValues1.getFirst());
                    matchingItem = "FOUND";

                    for (int i = 1; i < listValues1.size(); i++) {
                        if (listValues1.get(i).equals(listValues2.get(i))) {
                            System.out.println("Matching params found " +
                                    listHeaders.get(i) + " " + listValues1.get(i));
                        } else {
                            whatIsNotMatching.add("List1 Item " + listValues1.getFirst() +
                                    " found in List2 but not matching on "
                                    + listHeaders.get(i) + " as "
                                    + listValues1.get(i) + " not equals " + listValues2.get(i));
                            System.out.println(whatIsNotMatching.getLast());
                        }
                    }
                }
                if (matchingItem.equals("FOUND")) break;
                else list2LineNumber++;
            }
            if (!matchingItem.equals("FOUND")) {
                whatIsNotMatching.add("List1 Item " + listValues1.getFirst() + " not found in List2");
                System.out.println(whatIsNotMatching.getLast());
            }
            list2LineNumber = 0;
            list1LineNumber++;
            matchingItem = "";
            System.out.println("------------------------");
        }

        list1LineNumber = 0;
        list2LineNumber = 0;

        System.out.println("------------------------");
        System.out.println("Comparing List2 to List1");

        for (Map map2 : List2) {
            List<String> listHeaders = new ArrayList<String>(map2.keySet());
            List<String> listValues2 = new ArrayList<String>(map2.values());
            System.out.println("Comparing List2 Item" + list2LineNumber + " " + listValues2.getFirst());
            for (Map map1 : List1) {
                List<String> listValues1 = new ArrayList<String>(map1.values());
                System.out.println("- with List1 Item" + list1LineNumber+ " " + listValues1.getFirst());
                if (listValues2.getFirst().equals(listValues1.getFirst())) {
                    matchingItem = "FOUND";
                }
                if (matchingItem.equals("FOUND")) break;
                else list1LineNumber++;
            }
            if (!matchingItem.equals("FOUND")) {
                whatIsNotMatching.add("List2 Item " + listValues2.getFirst() + " not found in List1");
                System.out.println(whatIsNotMatching.getLast());
            }
            list1LineNumber = 0;
            list2LineNumber++;
            matchingItem = "";
            System.out.println("-------------------------");
            System.out.println("--------------------------------------------------");
        }
    }

    public static void AssertLists() {
        System.out.println("Asserting Lists discrepancies");
        System.out.println("Discrepancies : ");
        for(String notMatching : whatIsNotMatching) {
            System.out.println(notMatching);
        }
        Assert.assertEquals(whatIsNotMatching.toString(), expectedMatching.toString());
    }
}
