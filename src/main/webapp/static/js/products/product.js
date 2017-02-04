$(function() {
  var contextPath = $('#contextPath').val();
  
  $(document).ready(function() {
	    $('#products').DataTable({
	      language: {
	        search: "Enter the name of category:",
	        searchPlaceholder: "search...",
	        zeroRecords: "According to the parameters matches found",
	        paginate: {
	          next: "Next",
	          previous: "Previos"
	        }
	      },
	      order: [1, 'asc'],
	      columnDefs: [{
	        targets: [0,2,5],
	        orderable: false,
	      }, {
	        targets: [1,3,4],
	        searchable: true,
	      }],
	      bLengthChange: false,
	      info: true,
	    });
	  });
  
  
  
  
  
  $(document).on('click', '.delete', function() {
    if (confirm('Do you really want to delete this product?')) {
      deleteProduct($(this));
    }
    return false;
  });

  function deleteProduct(butObj) {
	  var idWorkType = butObj.prop('id');
    $.ajax({
      type: 'DELETE',
      url: contextPath + '/admin/settingWebsite/products/delete',
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