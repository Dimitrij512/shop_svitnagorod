$(function() {
  var contextPath = $('#contextPath').val();
  $(document).on('click', '.addTobakset', function() {
    addItemsToUserCart($(this).prop('id'));
    return false;
  });

  $(document).ready(function() {
    $(".numberProducts").change(function() {

      var idNumb = $(this).prop('id');
      var valueNumb = $(this).val();
      var price = $('#' + idNumb + 'price').val();
      var oldSumm = $('#' + idNumb + 'summ').val();
      var newSumm = price * valueNumb;

      $('#' + idNumb + 'summ').val(newSumm);
      var orderSumm = $('#orderSumm').val();
      orderSumm = (orderSumm - oldSumm) + newSumm;
      $('#orderSumm').val(orderSumm);

      setCountForProduct(idNumb, valueNumb);

    });
  });

  function setCountForProduct(product_id, count) {
    $.ajax({
      type: 'POST',
      url: contextPath + '/setCountProduct',
      contentType: 'application/json',
      data: JSON.stringify({
        "product_id": product_id,
        "count": count,
      }),

      success: function(data) {
        alert(data)
      },
      error: function(jqXHR) {
        alert('Smth wrong... code: ' + jqXHR.status);
      },
    });
  }

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
      deleteItem($(this));
  });

  function deleteItem(butObj) {
    $.ajax({
      type: 'DELETE',
      url: contextPath + '/deletFromBasket',
      contentType: 'application/json',
      data: JSON.stringify(butObj.prop('id')),
      success: function() {
        butObj.closest('tr').remove();
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