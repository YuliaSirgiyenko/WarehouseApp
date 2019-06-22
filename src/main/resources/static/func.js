function returnJsonAllOwnersOnClick(){
$.get('/get-all-owners', onAnswerAllOwners);
}

function onAnswerAllOwners (response){
    $('#newOwner').hide();
    $('#customers').empty();
    $('#customers').show();

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

function addOwnerOnClick(){
$('#customers').hide();
$('#newOwner').show();
$('#fname').val('');
$('#lname').val('');
$('#company').val('');
}

function submitNewOwnerOnClick(){

$.post(
  "/add-new-owner",
  {
    firstName : $('#fname').val(),
    lastName : $('#lname').val(),
    company : $('#company').val(),
  },
  onPostOwnerAnswer
);

function onPostOwnerAnswer(response)
{
    alert(response);
}

}