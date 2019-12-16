//Registration cost preview and final view
var table_quantity = 0;
var sale_option_choice = 0;
var price_per_table, sale_option_price, max_table_quantity, min_table_quantity;
var registrationCost;

var table_error = document.getElementById('table_error');
table_error.style.display = "none";

price_per_table = parseFloat(document.getElementById("pricePerTable").value);
sale_option_price = parseFloat(document.getElementById("saleOptionPrice").value);
max_table_quantity = parseInt(document.getElementById("maxTablesPerEditor").value);
min_table_quantity = 0;


document.getElementById("saleOption").addEventListener("change", function (e) {
    if (e.target.checked == false) {
        sale_option_choice = 0;
    } else {
        sale_option_choice = sale_option_price;
    }
    registrationCost = table_quantity * price_per_table - parseInt(table_quantity / 4) * price_per_table + sale_option_choice;
    document.getElementById("costPreview").textContent = "Prévisualisation du coût de l'inscription : " + registrationCost.toString() + " €";
    document.getElementById("finalCost").textContent = "Coût de l'inscription : " + registrationCost.toString() + " €";
});

document.getElementById('tablesQuantity').addEventListener('input', function () {
    table_quantity = parseInt(this.value);

    if (table_quantity < min_table_quantity || table_quantity == NaN) {
        table_quantity = min_table_quantity;
    }
    registrationCost = table_quantity * price_per_table - parseInt(table_quantity / 4) * price_per_table + sale_option_choice;
    document.getElementById("costPreview").textContent = "Prévisualisation du coût de l'inscription : " + registrationCost.toString() + " €";
    document.getElementById("finalCost").textContent = "Coût de l'inscription : " + registrationCost.toString() + " €";

    if (table_quantity > min_table_quantity && table_quantity < max_table_quantity) {
        table_error.style.display = "none";
    }
    if (table_quantity <= min_table_quantity) {
        table_error.style.display = "block";
        table_error.textContent = "Vous devez réserver au moins une table.";
    }
    if (table_quantity > max_table_quantity) {
        table_error.style.display = "block";
        table_error.textContent = "Vous ne pouvez pas dépasser le nombre maximal autorisé.";
    }
});