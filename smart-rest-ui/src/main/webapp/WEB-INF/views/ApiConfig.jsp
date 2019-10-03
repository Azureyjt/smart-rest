<body>
    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div class="container-fluid">
                <h3 class="page-title">Create New REST API Resource</h3>
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel">
                            <div class="panel-body">
                                <form action="<%=basePath%>api-config/" method="post">
                                    <div class="col-md-6">
                                        <h4>Resouse Base URI:</h4>
                                        <input class="form-control input-lg" type="text">
                                        <br>
                                        <h4>DB Table Name:</h4>
                                        <input class="form-control input-lg" type="text">
                                        <br>
                                        <h4>ID Column Name:</h4>
                                        <input class="form-control input-lg" type="text">
                                        <br>
                                        <br>
                                    </div>
                                    <div class="col-md-6">
                                        <h4>Attribute Mapping:</h4>
                                        <textarea class="form-control" rows="9"></textarea>
                                        <br>
                                        <br>
                                        <input type="submit" id="sub" value="Create" class="btn btn-primary"
                                               style="position: absolute;right: 18px;font-size: 15px"/>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END MAIN CONTENT -->
    </div>
</body>