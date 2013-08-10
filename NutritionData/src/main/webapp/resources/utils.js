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
            j+=1;
            while (j < f.length) {
                output += f[j] + '<br>';
                j+=1;
            }
            output += '</td>';
        }
        output += '</tr>';
    }
    output += "</tbody>";
    foodTable.innerHTML +=output;
}