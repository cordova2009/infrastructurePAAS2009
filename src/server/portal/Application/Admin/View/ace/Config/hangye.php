<extend name="Public/base"/>

<block name="body">
    <!-- 数据列表 -->
    <div class="table-responsive">
        <div class="dataTables_wrapper">  
            <div class="row">
                <div class="col-sm-12">
                    <form class="search-form" action="">
                        <label>
                            <a href="/admin.php?s=/config/addhangye.html" class="btn btn-sm btn-primary"><i class="icon-plus"></i>新增</a>
                        </label>
                    </form>
                </div>
            </div>

            <include file="Think/lists_common"/>
            <include file="Public/page"/>
        </div>
    </div>
</block>