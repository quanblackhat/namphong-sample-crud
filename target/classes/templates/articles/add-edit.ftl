<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="header">
                        <h4 class="title">${title}</h4>
                    </div>
                    <div class="content">

                        <form action="<@spring.url '/article/save'/>" method="POST">
                            <@spring.bind "article"/>
                            <div class="row">
                                <div class="col-md-8">
                                    <div class="form-group">
                                        <label>Title</label>
                                        <input type="text" name="title" value="${article.title!''}" required class="form-control" placeholder="Title">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Author</label>
                                        <input type="text" name="author" value="author" class="form-control" placeholder="Author">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label>Header</label>
                                        <textarea rows="3" name="header" value="header" required
                                                  class="form-control" placeholder="Content"></textarea>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label>Content</label>
                                        <textarea rows="10" name="content" value="content"
                                                  required class="form-control" placeholder="Content"></textarea>
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-info btn-fill pull-right">Save</button>
                            <div class="clearfix"></div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>