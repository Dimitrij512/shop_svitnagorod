$(function() {
  var contextPath = $('#contextPath').val();
  

  $(document).ready(function() {
	    $('#superCategories').DataTable({
	      language: {
	        search: "Введіть назву категрії:",
	        searchPlaceholder: "пошук...",
	        zeroRecords: "Згідно ваших параметрів збігів не знайдено",
	        paginate: {
	          next: "Наступна",
	          previous: "Попередня"
	        }
	      },
	      order: [1, 'asc'],
	      columnDefs: [{
	        targets: [0,2],
	        orderable: false,
	      }, {
	        targets: [1],
	        searchable: true,
	      }],
	      bLengthChange: false,
	      info: false,
	    });
	  });
  
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

$(document).ready(function() {
  $('#newSupCategory').formValidation({
      framework: 'bootstrap',
      excluded: ':disabled',
      icon: {
          valid: 'glyphicon glyphicon-ok',
          invalid: 'glyphicon glyphicon-remove',
          validating: 'glyphicon glyphicon-refresh'
      },
      fields: {
          username: {
              validators: {
                  notEmpty: {
                      message: 'The username is required'
                  }
              }
          },
          password: {
              validators: {
                  notEmpty: {
                      message: 'The password is required'
                  }
              }
          }
      }
  });
});