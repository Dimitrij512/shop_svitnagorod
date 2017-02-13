$(function() {
  var contextPath = $('#contextPath').val();
  $(document).on('click', '.addTobakset', function() {
    addItemsToUserCart($(this).prop('id'));
    return false;
  });

  $(document).ready(function(){
    $(".numberProducts").change(function(){
      
      var idNumb = $(this).prop('id');
      var valueNumb = $(this).val();
      var price = $('#'+idNumb+'price').val();
      
      var oldSumm = $('#'+idNumb+'summ').val();
      
      var newSumm = price * valueNumb;
      
      $('#'+idNumb+'summ').val(newSumm);
      
      var orderSumm = $('#orderSumm').val();
      orderSumm = (orderSumm - oldSumm) + newSumm;
      $('#orderSumm').val(orderSumm);
      
    });
});
  
  function addItemsToUserCart(input) {
    $.ajax({
      type: 'POST',
      url: contextPath + '/addProductToBasket',
      contentType: 'application/json',
      data: JSON.stringify(input),
      success: function(data) {
        alert(data)
      },
      error: function(jqXHR) {
        alert('Smth wrong... code: ' + jqXHR.status);
      },
    });
  };
  $(document).on('click', '.delete', function() {
    if (confirm('Do you really want to delete this item?')) {
      deleteItem($(this));
    }
    return false;
  });

  function deleteItem(butObj) {
    $.ajax({
      type: 'DELETE',
      url: contextPath + '/deletFromBasket',
      contentType: 'application/json',
      data: JSON.stringify(butObj.prop('id')),
      success: function() {
        butObj.closest('div.product').remove();
      },
      error: function(jqXHR) {
        alert('Smth wrong... code: ' + jqXHR.status);
      },
    });
  };
  

  $(document).on('click', '.back-btn', function() {
	  window.history.back();
  });
  
});