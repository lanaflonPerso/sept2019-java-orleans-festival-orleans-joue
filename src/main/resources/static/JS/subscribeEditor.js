//Animations
var current_fs, next_fs, previous_fs; //fieldsets
var left, opacity, scale; //fieldset properties which we will animate
var animating; //flag to prevent quick multi-click glitches

$(".next").click(function () {
    if (animating) return false;
    animating = true;

    current_fs = $(this).parent();
    next_fs = $(this).parent().next();

    //activate next step on progressbar using the index of next_fs
    $("#progressbar_1 li").eq($(".registrationState").index(next_fs)).addClass("active");
    $("#progressbar_2 li").eq($(".registrationState").index(next_fs)).addClass("active");

    //show the next fieldset
    next_fs.show();
    //hide the current fieldset with style
    current_fs.animate({
        opacity: 0
    }, {
        step: function (now, mx) {
            //as the opacity of current_fs reduces to 0 - stored in "now"
            //1. scale current_fs down to 80%
            scale = 1 - (1 - now) * 0.2;
            //2. bring next_fs from the right(50%)
            left = (now * 50) + "%";
            //3. increase opacity of next_fs to 1 as it moves in
            opacity = 1 - now;
            current_fs.css({
                'transform': 'scale(' + scale + ')',
                'position': 'absolute'
            });
            next_fs.css({
                'left': left,
                'opacity': opacity
            });
        },
        duration: 800,
        complete: function () {
            current_fs.hide();
            animating = false;
        },
        //this comes from the custom easing plugin
        easing: 'easeInOutBack'
    });
});

$(".previous").click(function () {
    if (animating) return false;
    animating = true;

    current_fs = $(this).parent();
    previous_fs = $(this).parent().prev();

    //de-activate current step on progressbar
    $("#progressbar_1 li").eq($(".registrationState").index(current_fs)).removeClass("active");
    $("#progressbar_2 li").eq($(".registrationState").index(current_fs)).removeClass("active");

    //show the previous fieldset
    previous_fs.show();
    //hide the current fieldset with style
    current_fs.animate({
        opacity: 0
    }, {
        step: function (now, mx) {
            //as the opacity of current_fs reduces to 0 - stored in "now"
            //1. scale previous_fs from 80% to 100%
            scale = 0.8 + (1 - now) * 0.2;
            //2. take current_fs to the right(50%) - from 0%
            left = ((1 - now) * 50) + "%";
            //3. increase opacity of previous_fs to 1 as it moves in
            opacity = 1 - now;
            current_fs.css({
                'left': left
            });
            previous_fs.css({
                'transform': 'scale(' + scale + ')',
                'opacity': opacity
            });
        },
        duration: 800,
        complete: function () {
            current_fs.hide();
            animating = false;
        },
        //this comes from the custom easing plugin
        easing: 'easeInOutBack'
    });
});

$(".submit").click(function () {
    return false;
});

//Abandon confirm message
function confirmation() {
    if (confirm("Êtes-vous sûr de vouloir annuler l'inscription ?")) {
        window.location.href = "/stopRegistration";
    }
}

//Registration cost preview and final view
var table_quantity = 0;
var sale_option_choice = 0;
var price_per_table, sale_option_price;
var registrationCost;

price_per_table = parseFloat(document.getElementById("pricePerTable").value);
sale_option_price = parseFloat(document.getElementById("saleOptionPrice").value);

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

document.getElementById('tablesQuantity').addEventListener('change', function () {
    table_quantity = this.value;
    registrationCost = table_quantity * price_per_table - parseInt(table_quantity / 4) * price_per_table + sale_option_choice;
    document.getElementById("costPreview").textContent = "Prévisualisation du coût de l'inscription : " + registrationCost.toString() + " €";
    document.getElementById("finalCost").textContent = "Coût de l'inscription : " + registrationCost.toString() + " €";
});