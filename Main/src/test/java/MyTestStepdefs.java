import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;


//TODO Make a class for products, create a test that contains a list of products and tests if they are cheap enough to buy referencing from a price list (map)

public class MyTestStepdefs {

    private static int a;
    private static int b;
    private static int sum;
    private static Boolean outcome;

    @Given("A value of {int}")
    public void aValueOf(int a) {
        MyTestStepdefs.a = a;
    }

    @And("And a value of {int}")
    public void aValueOfB(int b) {
        MyTestStepdefs.b = b;
    }

    @When("I compare the value of a + b it should be {int}")
    public void iCompareTheValueOfABItShouldBeSum(int sum) {
        MyTestStepdefs.sum = sum;
    }


    @Then("We compare if sum was the desired output of {string}")
    public void weCompareIfSumWasTheDesiredOutputOfOutcome(String outcome) {
        MyTestStepdefs.outcome = Boolean.getBoolean(outcome);
        if(a + b == sum && MyTestStepdefs.outcome){
            assert true;
        }
    }

    @Given("I have the following table of names and initials")
    public void iHaveTheFollowingTableOfNamesAndInitials(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);
        for (List<String> columns : rows) {
            System.out.printf(columns.get(0) + " | " + columns.get(1) + "\n");
        }
    }

    @When("I search for a name by {string}")
    public void iSearchForANameBy(String arg0) {
        
    }

    @When("I search for a name by {string} <x> <y>")
    public void iSearchForANameByXY(String arg0) {
    }

    @Then("I should get the name Lachlan Brown")
    public void iShouldGetTheNameLachlanBrown() {

    }


    @When("I search for a name by {string} {string} {string}")
    public void iSearchForANameBy(String arg0, String arg1, String arg2) {
        System.out.printf("%s | %s | %s", arg0, arg1, arg2);
    }

    private static List<List<String>> clothesPrices;
    private static String itemToBuy;
    private static Double lowestPriceToBuy;

    @Given("I have the following table of clothes and prices")
    public void iHaveTheFollowingTableOfClothesAndPrices(DataTable table) {
        clothesPrices = table.asLists(String.class);
    }

    @When("I search for a item to buy {string}")
    public void iSearchForAItemToBuy(String arg0) {
        itemToBuy = arg0;
    }

    @And("If my lowest price {string} is less than the cost price")
    public void ifMyLowestPriceIsLessThanTheCostPrice(String arg0) {
        lowestPriceToBuy = Double.valueOf(arg0.substring(1));
    }

    @Then("I should be able to buy the item")
    public void iShouldBeAbleToBuyTheItem() {
        for (List<String> columns : clothesPrices) {
            if(columns.get(0).equals(itemToBuy)){
                System.out.printf("Item %s found! Looking up price... \n", itemToBuy);
                Double price = Double.valueOf(columns.get(1).substring(1));
                if(price < lowestPriceToBuy){
                    System.out.printf("Buying item %s for $%f", itemToBuy, lowestPriceToBuy);
                    assert true;
                }
            } else {
                System.out.printf("Item not found.");
            }
            assert false;
        }
    }
}
