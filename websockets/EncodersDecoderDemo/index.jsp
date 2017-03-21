<%--
  Created by IntelliJ IDEA.
  User: srujant
  Date: 29/9/16
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>

<html>
<body>
<div>
    <form>
        <p>table:</p><input type="text" id="table">
        <p>method:</p><input type="text" id="method">
        <p>action:</p><input type="text" id="action">
        <p>pathParam:</p><input type="text" id="pathParam">
    </form>

</div>

<div>
    <button type="button" onclick="openSocket();">Open</button>
    <button type="button" onclick="getCount();">getDepInstances</button>
    <button type="button" onclick="closeSocket();">Close</button>
</div>

<div id="messages"></div>

<script type="text/javascript">

    var webSocket;


    function openSocket() {
        // Ensures only one connection is open at a time
        if (webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED) {
            writeResponse("WebSocket is already opened.");
            return;
        }
        // Create a new instance of the websocket
        webSocket = new WebSocket("ws://localhost:3030/DbServiceServer_war_exploded/echoServer_Db");
//        webSocket.binaryType = 'arraybuffer';

        webSocket.onopen = function (event) {
            if (event.data === undefined)
                return;
            parseData(event);
        };


        webSocket.onmessage = function (event) {
            parseData(event);
        };

        webSocket.onclose = function (event) {
            writeResponse("Connection closed");
        };
    }

    function getCount(){
        var table=document.getElementById("table").value;
        var method=document.getElementById("method").value;
        var action=document.getElementById("action").value;
        var pathParam=document.getElementById("pathParam").value;

        var request = {"table" :table, "method":method,"action" :action,"pathParam":pathParam};
        webSocket.send(JSON.stringify(request));
    }


    function parseData(event) {
        if (typeof  event.data === "string") {
            writeResponse(event.data)
        } else if (event.data instanceof ArrayBuffer) {
            writeResponse(arrayBuffer2str(event.data));
        } else {
            var reader = new FileReader();
            reader.onload = function (e) {
                writeResponse(e.target.result);
            }
            reader.onerror = function (e) {
                console.log("Failed to read contents of blob");
            }
            reader.readAsText(event.data);
        }
    }

    function arrayBuffer2str(buf) {
        return String.fromCharCode.apply(null, new Uint8Array(buf));
    }

    function send() {
        var text = document.getElementById("messageinput").value;
        webSocket.send(text);
    }


    function closeSocket() {
        webSocket.close();
    }

    function writeResponse(text) {
        messages.innerHTML += "<br/>" + text;
    }

</script>
</body>
</html>
