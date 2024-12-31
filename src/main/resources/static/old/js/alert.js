function showMsg(text,position,status){
	var show	=	$('.show_msg').length
	if(show>0){
	  var show = $("#hint");
	  show.removeClass();
    if (status == 'successful'){
      show.addClass('show_succeed');
    }else {
      show.addClass('show_error');
    }
	}else{
		var str ="<div class ='show_msg'>";
		if (status == 'successful'){
			str += "<span class='show_succeed' id='hint'>"+text+"</span>";
	    }else {
	    	str += "<span class='show_error' id='hint'>"+text+"</span>";
	    }
		str +="</div>";
		$("body").append(str);
	}
	$("#hint").text(text);
	if(position=='bottom'){
		$(".show_msg").css('bottom','5%');
	}else if(position=='center'){
		$(".show_msg").css('top','');
		$(".show_msg").css('bottom','50%');
	}else{
		$(".show_msg").css('bottom','95%');
	}
	$('.show_msg').hide();
	$('.show_msg').fadeIn(1500);
	$('.show_msg').fadeOut(2000);
}
