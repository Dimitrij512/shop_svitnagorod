$(function() {
	 var contextPath = $('#contextPath').val();
	  
	  //Get the modal
	  var modal = document.getElementById('myModal');
	  
	  //Get the button that opens the modal
	  var btn = document.getElementById("myBtn");
	  
	  //Get the <span> element that closes the modal
	  var span = document.getElementsByClassName("close")[0];
	  
	  $(document).on('click', '.delete', function() {
		  deleteSuperCategory($(this));
	  });

	//When the user clicks the button, open the modal 
	  btn.onclick = function() {
	      modal.style.display = "block";
	  }
	  
	//When the user clicks on <span> (x), close the modal
	  span.onclick = function() {
	      modal.style.display = "none";
	  }
	  
	//When the user clicks anywhere outside of the modal, close it
	  window.onclick = function(event) {
	      if (event.target == modal) {
	          modal.style.display = "none";
	      }
	  }

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