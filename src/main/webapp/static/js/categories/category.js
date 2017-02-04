$(function() {
  var contextPath = $('#contextPath').val();

  $(document).ready(function() {
	    $('#categories').DataTable({
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
	        targets: [0,3],
	        orderable: false,
	      }, {
	        targets: [1,2],
	        searchable: true,
	      }],
	      bLengthChange: false,
	      info: true,
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