package glue;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import account.Account;
import io.cucumber.datatable.DataTable;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountSteps {

	Account accountDetails = null;

	@Given("^Account exists for Acc No\\. \"([^\"]*)\" with Name \"([^\"]*)\"$")
	public void accountExistsForAccNoWithName(String accountNumber, String accountHoldername) {

		accountDetails = new Account(accountNumber, accountHoldername);
	}

	@And("^deposits are made")
	public void deposits_are_made(DataTable dataTable) {

		List<List<String>> deposits = dataTable.asLists(String.class);

		for (List<String> entries : deposits) {

			accountDetails.deposits(entries.get(0), Double.parseDouble(entries.get(1)));
		}

	}

	@When("^withdrawls are made")
	public void withdrawls_are_made(DataTable dataTable) throws Exception {
		List<List<String>> withdrawls = dataTable.asLists(String.class);
		for (List<String> entries : withdrawls) {

			accountDetails.withDrawals(entries.get(0), Double.parseDouble(entries.get(1)));
		}
	}

	@Then("statement is produced")
	public void statement_is_produced() {

	}

	@Then("statement includes {string}")
	public void statement_includes(String transaction) {
		Assert.assertTrue(accountDetails.getStatementDetails().containsKey(transaction));
	}

}
