$(document).ready(function() {
	var listSize = 0;
    $(function() {
        $('#btn-add-row').click(function() {
        	listSize++
            $('#mytable > tbody:last').append('<tr><input type="hidden" name="count">'
            		+ '<td><input type="text" name="kidName'+listSize+'"></td>'
            		+ '<td><input type="text" name="kinderName'+listSize+'"></td>'
            		+ '<td><input type="button"inclick="#" value="유치원검색"></td></tr>');
        });
        $('#btn-delete-row').click(function() {
        	if ($("input[name=count]").length >= 1)
        		listSize--
            $('#mytable > tbody:last > tr:last').remove();
        });
    });
});