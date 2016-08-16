
$(function() {
	$(".star_rating a").click(function() {
		$(this).parent().children("a").removeClass("on");
		$(this).addClass("on").prevAll("a").addClass("on");
		return false;
	});
});

jQuery(function() {
	jQuery('#camera_wrap').camera({
		thumbnails : false
	});
});