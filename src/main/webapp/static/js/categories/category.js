$(function() {
  var contextPath = $('#contextPath').val();
  $(document).on('click', '.delete', function() {
    if (confirm('Do you really want to delete this type of Work?')) {
      deleteWorkType($(this));
    }
    return false;
  });

  function deleteWorkType(butObj) {
	  var idWorkType = butObj.prop('id');
    $.ajax({
      type: 'DELETE',
      url: contextPath + '/admin/settingWebsite/categories/delete',
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