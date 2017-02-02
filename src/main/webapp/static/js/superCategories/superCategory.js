$(function() {
  var contextPath = $('#contextPath').val();

  $(document).on('click', '.delete', function() {
    deleteSuperCategory($(this));
  });

  //When the user clicks the button, open the modal   
  $(document).on('click', '.btnModal', function() {

    $('#myModal').css("display", "block");
  });

  //When the user clicks on <span> (x), close the modal 
  $(document).on('click', '.close', function() {

    $('#myModal').css("display", "none");
  });

  //When the user clicks anywhere outside of the modal, close it  
  $(window).click(function(event) {
    if (event.target.id == $('#myModal').attr('id')) {
      $('#myModal').css("display", "none");
    }
  });

  function deleteSuperCategory(butObj) {
    var idSuprCategory = butObj.prop('id');
    $.ajax({
      type: 'DELETE',
      url: contextPath + '/admin/settingWebsite/superCategory/delete',
      contentType: 'application/json',
      data: butObj.prop('id'),
      success: function() {
        butObj.closest('tr').remove();
      },
      error: function(jqXHR) {
        alert('Smth wrong... code: ' + jqXHR.status);
      },
    });
  };
});