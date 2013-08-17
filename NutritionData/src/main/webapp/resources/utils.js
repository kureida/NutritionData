var iterator = 0;
var ingredientIterator = 0;
function sectionFood(k, f) {
    var j = 0;
    var output = "";
    output += "<tbody>";
    for (var i = 0; i < k.length; i++) {
        output += '<tr><td>' + k[i] + '</td>';
        if (k[i] == f[j] && i != k.length - 1) {
            j += 1;
            output += '<td>';
            while (f[j] != k[i + 1]) {
                output += f[j] + '<br>';
                j += 1;
            }
            output += '</td>';
        } else if (i == k.length - 1) {
            output += '<td>'
            j += 1;
            while (j < f.length) {
                output += f[j] + '<br>';
                j += 1;
            }
            output += '</td>';
        }
        output += '</tr>';
    }
    output += "</tbody>";
    foodTable.innerHTML += output;
}
function inputFocus(i) {
    if (i.value == i.defaultValue) {
        i.value = "";
        i.style.color = "#000";
    }
}
function inputBlur(i) {
    if (i.value == "") {
        i.value = i.defaultValue;
        i.style.color = "#888";
    }
}
function addFood() {
    iterator += 1;
    $('#addition').append('<div class="row">' +
        '<div class="col-6">Type of Food:</div><div class="col-6"><input onfocus="inputFocus(this)" onblur="inputBlur(this)" value="Leave blank if unknown" name="typeofFood' + iterator + '" type="text" style="color:#888;"></div></div>' +
        '<div class="row"><div class="col-6"><input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="name' + iterator + '" value="Name"  type="text" style="color:#888;"></div><div class="col-6"><input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="servingSize' + iterator + '" value="Serving Size (g)"  type="text" style="color:#888;"></div></div>' +
        '<div class="row"><div class="col-6"><input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="calories' + iterator + '" value="Calories"  type="text" style="color:#888;"></div><div class="col-6"><input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="fatCalories' + iterator + '" value="Fat Calories"  type="text" style="color:#888;"></div></div>' +
        '<div class="row"><div class="col-6"><input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="totalFatGrams' + iterator + '" value="Total Fat (g)"  type="text" style="color:#888;"></div><div class="col-6"><input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="totalFatPercentage' + iterator + '" value="Total Fat (%)"  type="text" style="color:#888;"></div></div>' +
        '<div class="row"><div class="col-6"><input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="satFatGrams' + iterator + '" value="Saturated Fat (g)"  type="text" style="color:#888;"></div><div class="col-6"><input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="satFatPercentage' + iterator + '" value="Saturated Fat (%)"  type="text" style="color:#888;"></div></div>' +
        '<div class="row"><div class="col-6"><input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="cholesterolMilligrams' + iterator + '" value="Cholesterol (mg)"  type="text" style="color:#888;"></div><div class="col-6"><input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="cholesterolPercentage' + iterator + '" value="Cholesterol (%)"  type="text" style="color:#888;"></div></div>' +
        '<div class="row"><div class="col-6"><input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="sodiumMilligrams' + iterator + '" value="Sodium (mg)"  type="text" style="color:#888;"></div><div class="col-6"><input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="sodiumPercentage' + iterator + '" value="Sodium (%)"  type="text" style="color:#888;"></div></div>' +
        '<div class="row"><div class="col-6"><input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="totalCarbsGrams' + iterator + '" value="Total Carbs (g)"  type="text" style="color:#888;"></div><div class="col-6"><input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="totalCarbsPercentage' + iterator + '" value="Total Carbs (%)"  type="text" style="color:#888;"></div></div>' +
        '<div class="row"><div class="col-6"><input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="fiberGrams' + iterator + '" value="Fiber (g)"  type="text" style="color:#888;"></div><div class="col-6"><input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="fiberPercentage' + iterator + '" value="Fiber (%)"  type="text" style="color:#888;"></div></div>' +
        '<div class="row"><div class="col-6"><input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="sugarGrams' + iterator + '" value="Sugar (g)"  type="text" style="color:#888;"></div><div class="col-6"><input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="proteinGrams' + iterator + '" value="Protein (g)"  type="text" style="color:#888;"></div></div><br>');
}


$(function () {
    $('#accordion > li').hover(
        function () {
            var $this = $(this);
            $this.stop().animate({'width': '480px'}, 500);
            $('.heading', $this).stop(true, true).fadeOut();
            $('.bgDescription', $this).stop(true, true).slideDown(500);
            $('.description', $this).stop(true, true).fadeIn();
        },
        function () {
            var $this = $(this);
            $this.stop().animate({'width': '115px'}, 1000);
            $('.heading', $this).stop(true, true).fadeIn();
            $('.description', $this).stop(true, true).fadeOut(500);
            $('.bgDescription', $this).stop(true, true).slideUp(700);
        }
    );
});

function addIngredient(){
    ingredientIterator+=1;
    $('#additionalIngredients').append('<br>Ingredient Name: <input type="text" name="foodName'+ingredientIterator+'"><br><br><input type="text" onfocus="inputFocus(this)" name="sSize'+ingredientIterator+'" onblur="inputBlur(this)" style="color:#888;" value="Enter Serving Size">   <select name="typeofWeight'+ingredientIterator+'"><option value="g" >grams</option><option value="oz">ounces</option></select><br>');
}
