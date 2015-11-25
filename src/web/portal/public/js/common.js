$(function() {
	function time(btn){
		var count = 60;
		var resend = setInterval(function(){
			count--;
			if (count > 0){
				btn.val(count+"秒");
			}else {
				clearInterval(resend);
				btn.val("重新发送").removeAttr('disabled').removeClass("disabled");
			}
		}, 1000);
		btn.attr('disabled',true).addClass("disabled");
	}
	$(".reg_time").click(function() {
		time($(this))
	})




	$(".submenu").hover(function(){
		$(this).find("dl").show();
	},function(){
		$(this).find("dl").hide();
	})

	$(".sidemenu ul li>a").click(function() {
		if($(this).next(".submenu").hasClass('active')){
			$(this).next(".submenu").removeClass('active').slideUp();;
		}else{
			$(".sidemenu .submenu").removeClass('active').slideUp();
			$(this).next(".submenu").addClass('active').slideDown();
		}
		
	});

	$('[data-toggle="modal"]').click(function() {
		var target = $(this).attr("data-target");
		$(target).fadeIn();
	});

	$('[data-miss="modal"]').click(function() {
		$(this).parents(".modal").fadeOut();
	});

	$(".tab_box").slide({mainCell:".bd ",effect:"fade"})

	$(".checklist .i-check").click(function() {
		if($(this).hasClass('on')){
			$(this).removeClass('on');
		}else{
			$(this).addClass('on');
		}
	});


	$(".checkBtn a").click(function() {
		$(this).siblings('a').removeClass('active')
		$(this).addClass('active');
	});

	$(document.body).on('click', '.datepicker', function(){
		$(this).datetimepicker({
			timepicker: false,
			lang: 'ch',
			format: 'Y-m-d',
			formatDate: 'Y-m-d'
		});
		$(this).datetimepicker('show')
	})

})