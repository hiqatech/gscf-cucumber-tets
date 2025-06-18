package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import java.util.List;
import java.util.Map;
import static Common.Util.*;

public class ListsSteps {

    @Given("I have the following items in the first list:")
    public void i_have_the_following_items_in_the_first_list(DataTable dataTable) {
        List<Map<String,String>> data = dataTable.asMaps();
        setList("1",data);
    }
    @Given("I have the following items in the second list:")
    public void i_have_the_following_items_in_the_second_list(DataTable dataTable) {
        List<Map<String,String>> data = dataTable.asMaps();
        setList("2",data);
    }
    @When("I compare both lists")
    public void i_compare_both_lists() {
        compareLists();
    }
    @Then("the lists should contain the same items with name, price, and category, regardless of order")
    public void the_lists_should_contain_the_same_items_with_name_price_and_category_regardless_of_order() {
        AssertLists();
    }
}
