$(document).ready(function() {

   $('.table .editButton').on('click', function (event){
       event.preventDefault();

       var href = $(this).attr('href');
       $.get(href, function(user, status){
           $('#editId').val(user.id);
           $('#editName').val(user.name);
           $('#editPosition').val(user.position);
           $('#editDepartment').val(user.department);
           $('#editDate').val(user.updateOn.substr(0,10));
       });
       $('#editModal').modal();
   });

   $('.table .deleteButton').on('click', function(event){
       event.preventDefault();
       var href = $(this).attr('href');
       $('#deleteModal #deleteId').attr('href', href)
       $('#deleteModal').modal();
   });

   $('.addButton .selectDb').on('click', function(event){
       event.preventDefault();
   });

});