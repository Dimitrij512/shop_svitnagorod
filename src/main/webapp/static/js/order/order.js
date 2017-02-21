$(function() {
  var contextPath = $('#contextPath').val();
  var stompClient = null;
  
  connect();
  Notification.requestPermission();
  
  function connect() {
    var socket = new SockJS(contextPath + '/spring-websocket');
    stompClient = Stomp.over(socket);
    stompClient.debug = null;
    stompClient.connect({}, function(frame) {
      stompClient.subscribe('/adminNotification', function(orderNotification) {
        notifyMe(JSON.parse(orderNotification.body).notificationMessage);
      });
    });
  }
  
  //send notification for administrator
  function notifyMe(notificationMessage) {
    if (!("Notification" in window)) {
      alert("This browser does not support desktop notification");
    }
    else if (Notification.permission === "granted") {
      var notification = new Notification("Attention!", {
        tag : "ache-mail",
        body:  notificationMessage,
      });
    }
    else if (Notification.permission !== 'denied') {
      Notification.requestPermission(function (permission) {
        if (permission === "granted") {
          var notification = new Notification(notificationMessage);
        }
      });
    }
  }
});