<script>
    $(document).ready(function () {
        $(function () {
            if (${totalElements} > 0)
            {
                window.pagObj = $('#pagination').twbsPagination({
                    totalPages: ${totalPages},
                    visiblePages: ${visiblePage},
                    startPage: ${page},
                    first: '&laquo;',
                    prev: '',
                    next: '',
                    last: '&raquo;'
                }).on('page', function (event, page) {
                    var url = "${contextPath}/?page=" + page;
                    window.location.replace(url);
                });
            }
        });
    });
</script>
<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="header">
                        <h4 class="title">Quản lý bài viết</h4>
                        <p class="category">Danh sách bài viết </p>
                        <p class="pull-r">
                            <button type="submit" class="btn btn-info btn-fill pull-right">Tạo bài viết mới</button>
                        </p>


                    </div>
                    <div class="content table-responsive table-full-width">
                        <table class="table table-hover table-striped">
                            <thead>
                            <th>ID</th>
                            <th>Tiêu đề</th>
                            <th>Tác giả</th>
                            <th>Ngày tạo</th>
                            <th>Chỉnh sửa</th>
                            <th>Xóa </th>
                            </thead>
                            <tbody>
                            <#list articles as article>
                                <tr>
                                    <td>${article.id}</td>
                                    <td>${article.title}</td>
                                    <td>${article.author}</td>
                                    <td>${article.dateCreated?string('dd/MM/yyyy')}</td>
                                    <td><a href="${contextPath}/article/edit/${article.id}">Chỉnh sửa</a></td>
                                    <td><a href="${contextPath}/article/delete/${article.id}">Xóa</a></td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                    <div class="footer">
                        <div class="example pull-right">
                            <ul id="pagination" class="pagination super-page"></ul>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>