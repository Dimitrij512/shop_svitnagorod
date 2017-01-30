$(function() {
  var contextPath = $('#contextPath').val();
  $(document).on('click', '.delete', function() {
    if (confirm('Do you really want to delete this superCategory?')) {
      deleteSuperCategory($(this));
    }
    return false;
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