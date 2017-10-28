<%-- 
    Document   : kategori
    Created on : Oct 25, 2017, 9:29:02 AM
    Author     : java-spring
--%>
<h2 class="alert alert-success">Kategori Pages</h2>
<hr/>
<button class="btn btn-success tambah" onclick="openKategori()">
    <span class="glyphicon glyphicon-plus-sign"></span>
    Tambah Kategori
</button>
<hr/>
<table class="table table-bordered table-hover table-striped" 
       id="tabel-kategori">
    <thead>
        <tr>
            <th>idkategori</th>
            <th>nama kategori</th>
            <th>deskripsi</th>
            <th>status</th>
            <th>opsi</th>
        </tr>
    </thead>
    <tbody>
        
    </tbody>
    <tfoot>
        <tr>
            <th>idkategori</th>
            <th>nama kategori</th>
            <th>deskripsi</th>
            <th>status</th>
            <th>opsi</th>
        </tr>
    </tfoot>
</table>

<!--modal update-->
<div class="modal fade" id="modalupdatekategori" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog" role="dialog">
        <div class="modal-content" role="document">
            <div class="modal-header">
                <button class="close" data-dismiss="modal">
                    <span aria-hidden="true">close</span>
                </button>
                <br/>
                <h4>Update Kategori</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="form-kategori-update">
                    <div class="form-group">
                        <label class="col-lg-3 control-label">Kategori Mobil :</label>
                        <div class="col-lg-5">
                            <input type="hidden" name="idkategori" id="id_idkategori"/>
                            <input type="text" class="form-control" name="name" id="name_kategori"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label">Deskripsi :</label>
                        <div class="col-lg-6">
                            <textarea class="form-control" name="deskripsi" id="deskripsi_kategori"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label">Ketersediaan :</label>
                        <div class="col-lg-5">
                            <select class="form-control" name="active" id="active_kategori">
                                <option value="">-Pilih Salah Satu-</option>
                                <option value="true">Tersedia</option>
                                <option value="false">Belum Tersedia</option>
                            </select>
                        </div>
                    </div>
                </form>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success upskategori">
                        <span class="glyphicon glyphicon-ok-circle"></span>
                        Yes, Update it !
                    </button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                        <span class="glyphicon glyphicon-circle-arrow-right"></span>
                        No, Cancel it !
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<!--modal update-->
 
<!--modal insert-->
<div class="modal fade" id="modalkategori" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog" role="dialog">
        <div class="modal-content" role="document">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">Close</span>
                </button>
                <h4>Insert Kategori</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="form-kategori">
                    <div class="form-group field">
                        <label class="col-lg-3 control-label">Kategori Mobil:</label>
                        <div class="col-lg-5">
                            <input type="text" class="form-control" 
                                   name="name" id="name_kategori" placeholder="Nama Kategori"/>
                            <label class="help-block message" style="color: crimson"></label>
                        </div>
                    </div>
                    <div class="form-group field">
                        <label class="col-lg-3 control-label">Deskripsi :</label>
                        <div class="col-lg-7">
                            <textarea class="form-control" name="deskripsi" 
                                      id="deskripsi_kategori" placeholder="Deskripsi Kategori"></textarea>
                                      <label class="help-block message" style="color: crimson"></label>
                        </div>
                    </div>
                    <div class="form-group field">
                        <label class="col-lg-3 control-label">Tersedia :</label>
                        <div class="col-lg-5">
                            <select class="form-control" name="active" id="active_kategori">
                                <option value="">-Pilih Salah Satu-</option>
                                <option value="true">Tersedia</option>
                                <option value="false">Belum Tersedia</option>
                            </select>
                            <label class="help-block message" style="color: crimson"></label>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer action">
                <button type="button" class="btn btn-success savedkategori">
                    <span class="glyphicon glyphicon-ok-circle"></span>
                    Yes, Save it !
                </button>
                <button type="button" class="btn btn-default" data-dismiss="modal">
                    <span class="glyphicon glyphicon-circle-arrow-right"></span>
                    No, Cancel it !
                </button>
            </div>
        </div>
    </div>
</div>
<!--modal insert-->