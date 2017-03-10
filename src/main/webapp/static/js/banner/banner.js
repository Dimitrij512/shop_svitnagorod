$(function() {
  var contextPath = $('#contextPath').val();
  
  $(document).ready(function() {
      $('#banners').DataTable({
        language: {
          search: "Введіть назву:",
          searchPlaceholder: "пошук...",
          zeroRecords: "Згідно вашого запиту збігів не знайдено",
          paginate: {
            next: "Наступна",
            previous: "Поперденя"
          }
        },
        order: [1, 'asc'],
        columnDefs: [{
          targets: [0,3,4],
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
      deleteBanner($(this));
  });

  function deleteBanner(butObj) {
    var idWorkType = butObj.prop('id');
    $.ajax({
      type: 'DELETE',
      url: contextPath + '/admin/settingWebsite/banner/delete',
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