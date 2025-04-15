/*let totalAmount = 0;

function addExpense() {
    // Get input values
    const date = document.getElementById("date").value;
    const description = document.getElementById("description").value;
    const amount = parseFloat(document.getElementById("amount").value);

    if (date && description && amount) {
        // Add the expense to the table
        const table = document.getElementById("expenseTable").getElementsByTagName("tbody")[0];
        const newRow = table.insertRow();

        newRow.innerHTML = `
            <td>${date}</td>
            <td>${description}</td>
            <td>$${amount.toFixed(2)}</td>
        `;

        // Update the total amount
        totalAmount += amount;
        document.getElementById("totalAmount").innerText = totalAmount.toFixed(2);

        // Clear input fields
        document.getElementById("date").value = '';
        document.getElementById("description").value = '';
        document.getElementById("amount").value = '';
    } else {
        alert("Please fill in all fields.");
    }
}*/
let totalAmount = 0; // Variable to hold the cumulative total

function addExpense() {
    // Get input values
    const date = document.getElementById("date").value;
    const description = document.getElementById("description").value;
    const amountInput = document.getElementById("amount").value;

    // Ensure amount is a valid number
    const amount = parseFloat(amountInput);

    if (date && description && !isNaN(amount) && amount > 0) { // Check for valid inputs
        // Add the expense to the table
        const table = document.getElementById("expenseTable").getElementsByTagName("tbody")[0];
        const newRow = table.insertRow();

        // Insert cells for date, description, and amount
        const dateCell = newRow.insertCell(0);
        const descriptionCell = newRow.insertCell(1);
        const amountCell = newRow.insertCell(2);

        // Fill in cells
        dateCell.innerText = date;
        descriptionCell.innerText = description;
        amountCell.innerText = `$${amount.toFixed(2)}`;

        // Update the total amount
        totalAmount += amount;
        document.getElementById("totalAmount").innerText = totalAmount.toFixed(2);

        // Clear input fields after adding the expense
        document.getElementById("date").value = '';
        document.getElementById("description").value = '';
        document.getElementById("amount").value = '';
    } else {
        alert("Please fill in all fields correctly.");
    }
}