var listSize = 0;
$(document).ready(function() {	
    $(function() {
        $('#btn-add-row').click(function() {
        	listSize++
            $('#mytable > tbody:last').append('<tr><input type="hidden" name="count">'
            		+ '<td><input type="text" name="kidName'+listSize+'"></td>'
            		+ '<td><input type="text" name="kinderName'+listSize+'" id="kinderName'+listSize+'"></td>'
            		+ '<td><input type="button" onClick="SchulCheck('+listSize+')" value="유치원검색"></td></tr>');
        });
        $('#btn-delete-row').click(function() {
        	if ($("input[name=count]").length >= 1)
        		listSize--
            $('#mytable > tbody:last > tr:last').remove();
        });
    });
});

function SchulCheck(listSize){
	
	url="/FORKI/content/MyPage/factor/SchulCheck2.do?num="+listSize;
	
	window.open(url,"post","toolbar=no ,width=500 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
}

function sendVal() {
	document.userinput.size.value = listSize;
}