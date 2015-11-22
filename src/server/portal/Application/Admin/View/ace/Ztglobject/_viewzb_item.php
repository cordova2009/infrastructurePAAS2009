    <?php if(isset($title_icon) && $title_icon):?>
        <div class="widget-header widget-header-small header-color-blue3">
            <h6 class="smaller">
                <?=$title_icon?>
            </h6>
        </div>
    <?php endif;?>
    <div class="widget-body">
        <div class="widget-main no-padding">
            <table class="table table-striped table-bordered table-hover">
                <tbody>
                <?php foreach($cloumn_data as $cloumn=>$th_title):?>
                <tr>
                    <th width="50%"><?=$th_title?></th>
                    <td>
                        <?php foreach(explode(',',$cloumn) as $index):?>
                        <?=$item[$index]?>
                        <?php endforeach;?>
                    </td>
                </tr>
                <?php endforeach;?>
                </tbody>
            </table>
        </div>
    </div>
</div>