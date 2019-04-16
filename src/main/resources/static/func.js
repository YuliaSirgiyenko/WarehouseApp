function jsonVisOnClick(){
$.get('/get-all-owners', onAnswer);
}

function onAnswer(response){

    var tableOwners = document.getElementById('customers');

    var tr = document.createElement('tr');
    tableOwners.appendChild(tr);

    var th1 = document.createElement('th');
    tr.appendChild(th1);
    th1.innerText = "First Name";

    var th2 = document.createElement('th');
    tr.appendChild(th2);
    th2.innerText = "Last Name";

    var th3 = document.createElement('th');
    tr.appendChild(th3);
    th3.innerText = "Company";

    var ownersArr = JSON.parse(response);

    ownersArr.forEach(function(item) {
        var tr = document.createElement('tr');
        tableOwners.appendChild(tr);

        var td1 = document.createElement('td');
        tr.appendChild(td1);
        td1.innerText = item.firstName;

        var td2 = document.createElement('td');
        tr.appendChild(td2);
        td2.innerText = item.lastName;

        var td3 = document.createElement('td');
        tr.appendChild(td3);
        td3.innerText = item.company;
    });

}