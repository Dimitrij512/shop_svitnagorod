$(function() {
  var contextPath = $('#contextPath').val();
  
  $(document).ready(function() {
	    $('#products').DataTable({
	      language: {
	        search: "Введіть назву проукта:",
	        searchPlaceholder: "пошук...",
	        zeroRecords: "Згідно вашого запиту збігів не знайдено",
	        paginate: {
	          next: "Наступна",
	          previous: "Попередня"
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
	      info: false,
	    });
	  });
  
  
  
  
  
  $(document).on('click', '.delete', function() {
    if (confirm('Ви дійсно бажаєте видалити даний продукт?')) {
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