$(function() {
  var contextPath = $('#contextPath').val();

  $(document).ready(function() {
	    $('#categories').DataTable({
	      language: {
	        search: "Введіть назву категорії:",
	        searchPlaceholder: "пошук...",
	        zeroRecords: "Незнайдено даних згідно ваших параметрів",
	        paginate: {
	          next: "Наступна",
	          previous: "Попередня"
	        }
	      },
	      order: [1, 'asc'],
	      columnDefs: [{
	        targets: [0,3],
	        orderable: false,
	      }, {
	        targets: [1,2],
	        searchable: true,
	      }],
	      bLengthChange: false,
	      info: false,
	    });
	  });

  $(document).on('click', '.delete', function() {
	  deleteCategory($(this));
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
  
  function deleteCategory(butObj) {
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