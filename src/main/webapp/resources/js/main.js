var prefix = "http://localhost:8080/";

var checkLetter = function(){
    var inputLetter = $("#inputLetter").val().trim().toLowerCase();
    if(inputLetter.length === 1){
        var request = {
            wordId: $("#wordId").val(),
            gameId: $("#gameId").val(),
            letter: inputLetter
        };
        console.log(request);

        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "/game/gameOneLetter",
            data : JSON.stringify(request),
            dataType : 'json',
            success : function(data) {
                // Code to display the response.
                console.log("****************" + data);
                data.forEach(function(item) {$("#col" + item).html(request.letter)});

                var table = document.getElementById("encryptedWord");
                var isWin = true;

                var row = table.rows[0];
                for(var j=0; j<row.cells.length; j++){
                    var cell = row.cells[j];
                    console.log(cell);
                    if(cell.innerText === '*'){
                        isWin = false;
                        break;
                    }
                }
                if(isWin){
                    $("#winResult").html("Result: you win");
                    document.getElementById("btnCheckLetter").disabled = true;
                }
            }
        }, this);

    }
    else if(inputLetter.length > 1){
        var request = {
            wordId: $("#wordId").val(),
            gameId: $("#gameId").val(),
            letter: inputLetter
        };
        console.log(request);

        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "/game/gameWholeWord",
            data : JSON.stringify(request),
            dataType : 'json',
            success : function(data) {
                // Code to display the response.
                console.log("****");
                console.log(data);
                if(data && data.isWin) {
                    for(var i = 0; i < data.wordFromDB.length; i++){
                        var c = data.wordFromDB.charAt(i);
                        $("#col" + i).html(c);
                    }
                    $("#winResult").html("Result: you win");

                }
                else if(data && !data.isWin) {
                    $("#winResult").html("Result: you lose \n" + data.wordFromDB);
                }
                document.getElementById("btnCheckLetter").disabled = true;
            }
        }, this);

    }
    document.getElementById("inputLetter").value = null;
}