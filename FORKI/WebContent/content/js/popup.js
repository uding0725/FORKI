function layer_open(el) {

	var temp = $('#' + el);
	var bg = temp.prev().hasClass('bg'); // dimmed 레이어를 감지하기 위한 boolean 변수

	if (bg) {
		$('.layer').fadeIn(); // 'bg' 클래스가 존재하면 레이어가 나타나고 배경은 dimmed 된다.
	} else {
		temp.fadeIn();
	}

	// 화면의 중앙에 레이어를 띄운다.
	if (temp.outerHeight() < $(document).height())
		temp.css('margin-top', '-' + temp.outerHeight() / 2 + 'px');
	else
		temp.css('top', '0px');
	if (temp.outerWidth() < $(document).width())
		temp.css('margin-left', '-' + temp.outerWidth() / 2 + 'px');
	else
		temp.css('left', '0px');

	temp.find('a.cbtn').click(function(e) {
		if (bg) {
			$('.layer').fadeOut(); // 'bg' 클래스가 존재하면 레이어를 사라지게 한다.
		} else {
			temp.fadeOut();
		}
		e.preventDefault();
	});

	$('.layer .bg').click(function(e) { // 배경을 클릭하면 레이어를 사라지게 하는 이벤트 핸들러
		$('.layer').fadeOut();
		e.preventDefault();
	});

}

function layer2_open(el) {

	var temp3 = $('#' + el);
	var bg3 = temp3.prev().hasClass('bg3'); // dimmed 레이어를 감지하기 위한 boolean 변수
	if (bg3) {
		$('.layer3').fadeIn(); // 'bg' 클래스가 존재하면 레이어가 나타나고 배경은 dimmed 된다.
	} else {
		temp3.fadeIn();
	}

	// 화면의 중앙에 레이어를 띄운다.
	if (temp3.outerHeight() < $(document).height())
		temp3.css('margin-top', '-' + temp3.outerHeight() / 2 + 'px');
	else
		temp3.css('top', '0px');
	if (temp3.outerWidth() < $(document).width())
		temp3.css('margin-left', '-' + temp3.outerWidth() / 2 + 'px');
	else
		temp3.css('left', '0px');

	temp3.find('a.cbtn3').click(function(e) {
		if (bg3) {
			$('.layer3').fadeOut(); // 'bg' 클래스가 존재하면 레이어를 사라지게 한다.
		} else {
			temp3.fadeOut();
		}
		e.preventDefault();
	});

	$('.layer3 .bg3').click(function(e) { // 배경을 클릭하면 레이어를 사라지게 하는 이벤트 핸들러
		$('.layer3').fadeOut();
		e.preventDefault();
	});

}