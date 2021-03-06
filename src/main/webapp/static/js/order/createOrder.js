$(function() {
  var stompClient = null;
  var contextPath = $('#contextPath').val();

  //sends notification about new order to admin
  $('.orderMessage').on('click', function(){
    connect('some message');
  });
  
  //Create web socket connection to the server, invoke sendName and disconnect functions
  function connect() {
    var socket = new SockJS(contextPath + '/spring-websocket');
    stompClient = Stomp.over(socket);
    stompClient.debug = null;
    stompClient.connect({}, function(frame) {
      if (socket.readyState === 1) {
        sendName();
        disconnect();
      }
    });
  }

  // web socket disconnect
  function disconnect() {
    if (stompClient != null) {
      stompClient.disconnect();
    }
  }

  //Sent message to the server about new order confirmation
  function sendName() {
    stompClient.send("/app/newOrderNotification", {}, JSON.stringify({
      'message': 'Attention new order'
    }));
  }
});