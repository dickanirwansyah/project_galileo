//function open modal kategori
function openKategori(){
    $("#modalkategori").modal('show');
    $("#form-kategori")[0].reset();
}

//function reload table kategori
function reloadKategori(){
    $("#tabel-kategori").DataTable().ajax.reload();
}

//function insert/saved kategori
function insertKategori(){
    
    var txtNama = $("#name_kategori").val();
    var txtDeskripsi = $("#deskripsi_kategori").val();
    var txtActive = $("#active_kategori").val();
    
    $.ajax({
        url: '/api/data/insert/kategoris',
        type: 'POST',
        data: JSON.stringify({name: txtNama, deskripsi: txtDeskripsi, active: txtActive}),
        contentType: 'application/json;charset=UTF-8',
        dataType: 'JSON',
        
        complete : function(){
            reloadKategori();
            $("#modalkategori").modal('hide');
        }
    });
}


//.class insert kategori & bootstrap validator
$(document).on('click', '.savedkategori', function (){
    
    var txtNama = $("#name_kategori").val();
    var txtDeskripsi = $("#deskripsi_kategori").val();
    var txtActive = $("#active_kategori").val();
    
    var validasi_nama = document.forms["form-kategori"]["name"].value;
    var validasi_deskripsi = document.forms["form-kategori"]["deskripsi"].value;
    var validasi_active = document.forms["form-kategori"]["active"].value;
    
    if(validasi_nama == ""){
        swal(
                'Error Message',
                'Name is empty',
                'error'
            )
        return false;
    }else if(validasi_deskripsi == ""){
        swal(
                'Error Message',
                'Deskripsi is empty',
                'error'
            )
        return false;
    }else if(validasi_active == ""){
        swal(
                'Error Message',
                'Ketersiedia is empty',
                'error'
            )
        return false;
    }else{
    
        $.ajax({
        url: '/api/data/insert/kategoris',
        type: 'POST',
        data: JSON.stringify({name: txtNama, deskripsi: txtDeskripsi, active: txtActive}),
        contentType: 'application/json;charset=UTF-8',
        dataType: 'JSON',
        
        complete : function(){
            reloadKategori();
            $("#modalkategori").modal('hide');
            swal(
                   'Success Message',
                   'Data submited successfully !',
                   'success'
                )
        }
    });
        
    }
    
});

//update kategori
$(document).on('click', '.updkat', function(){
    
   var idkategori = $(this).attr("data-id");
   
   $.ajax({
       url : '/api/data/getkategori/'+idkategori+'/show',
       method: 'GET',
       success : function(response){
           
           $('[name = "idkategori"]').val(response.idkategori);
           $('[name = "name"]').val(response.name);
           $('[name = "deskripsi"]').val(response.deskripsi);
           $('#active_kategori option[value="'+response.active+'"]').prop('selected', true);
           $("#modalupdatekategori").modal('show');
       }
   });
});

//update kategori
$(document).on('click', '.upskategori', function (){
   
    var txtIdkategori = $("#id_idkategori").val();
    var txtKategoriMobil = $("#name_kategori").val();
    var txtDeskripsi = $("#deskripsi_kategori").val();
    var txtKetersediaan = $("#active_kategori").val();
    
    var _validasikategori = document.forms["form-kategori-update"]["name"].value;
    var _validasiDeskripsi = document.forms["form-kategori-update"]["deskripsi"].value;
    var _validasiketersediaan = document.forms["form-kategori-update"]["active"].value;
    
    if(_validasikategori == ""){
        swal('Error Message', 'Name kategori still null please enter you kategori !', 'error');
    }else if(_validasiDeskripsi == ""){
        swal('Error Message', 'Deskripsi kategori still null please enter your deskripsi !', 'error')
    }else if(_validasiketersediaan == ""){
        swal('Error Message', 'Please choose one !', 'error');
    }else{
        
        $.ajax({
            url : '/api/data/update/kategori',
            type : 'PUT',
            data : JSON.stringify({
                idkategori: txtIdkategori, 
                name: txtKategoriMobil, 
                deskripsi: txtDeskripsi, 
                active: txtKetersediaan}),
            contentType : 'application/json;charset=UTF-8',
            dataType: 'JSON', 
            
            complete:function(){
                reloadKategori();
                $("#modalupdatekategori").modal('hide');
                swal('Congratulations !', 
                'your data has been update !', 
                'success');
            }
        });
    }
});

$(document).on('click', '.delkat', function (){
    
   var idkategori = $(this).attr("data-id");
   
   swal({
       title : 'Are you sure?',
       text : 'data will be delete if you clicked button ok',
       type: 'warning',
       showCancelButton : true,
       confirmButtonColor : '#DD6B55',
       confirmButtonText : 'OK, Delete it',
       cancelButtonText : 'NO, Cancel it'
   }).then(function(ifsukses){
      
      if(ifsukses){
          $.ajax({
              url : '/api/data/delete/'+idkategori+'/dropkategori',
              method : 'DELETE'
          }).success(function(){
              swal({
                  title : 'wait...',
                  text: 'your data will be delete in 3 seconds !',
                  showCancelButton: false,
                  timer: 3000,
                  onOpen:function(){
                    swal.showLoading();
                  }
              });
                reloadKategori();
          });
      }else{
          swal('your data cancel delete', 'data is safe', 'success');
      }
   
   });
    
});

//datatables kategori
$(document).ready(function (){
    
   var tabelkategori = $("#tabel-kategori");
   
   if(tabelkategori.length){
       
       tabelkategori.DataTable({
          
           lengthMenu: [[3, 5, 10, -1], ['Show 3', 'Show 5', 'Show 10', 'Show All']],
           pageLength: 5,
           
           ajax : {
               
               url : 'http://localhost:8080/api/data/list/kategoris',
               dataSrc: ''
           },
           columns: [
               {
                   data: 'idkategori'
               },
               {
                   data: 'name'
               },
               {
                   data: 'deskripsi'
               },
               {
                   data: 'active'
               },
               {
                   data: 'idkategori',
                   bSortable: false,
                   mRender:function(data, type, row){
                       
                       var str = '';
                       
                       str += '<button class="btn btn-success updkat" data-id="'+data+'">\n\
                       <span class="glyphicon glyphicon-pencil"></span></button> ';
                       
                       str += ' <button class="btn btn-warning delkat" data-id="'+data+'">\n\
                       <span class="glyphicon glyphicon-trash">\n\
                       </span></button>';
                       
                       return str;
                   }
               }
           ]
       });
   }
    
});