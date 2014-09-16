$(document).ready(
		function() {
			$('#slide-nav.navbar .container').append(
					$('<div id="navbar-height-col"></div>'));
			var toggler = '.navbar-toggle';
			var pagewrapper = '#page-content';
			var navigationwrapper = '.navbar-header';
			var menuwidth = '100%';
			var slidewidth = '80%';
			var menuneg = '-100%';
			var slideneg = '-80%';

			var slideMenuAction = function(e) {
				var selected = $(toggler).hasClass('slide-active');
				$('#slidemenu').stop().animate({
					left : selected ? menuneg : '0px'
				});
				$('#navbar-height-col').stop().animate({
					left : selected ? slideneg : '0px'
				});
				$('#slidemenu').children().zIndex(100);
				//$(pagewrapper).children().zIndex(-100);
//				$(pagewrapper).stop().animate({
//					left : selected ? '0px' : slidewidth
//				});
//				$(navigationwrapper).stop().animate({
//					left : selected ? '0px' : slidewidth
//				});
				$(toggler).toggleClass('slide-active', !selected);
				$('#slidemenu').toggleClass('slide-active');
				$('#page-content, .navbar, body, .navbar-header').toggleClass(
						'slide-active');
				$(pagewrapper).fadeTo("fast", selected ? 1 : 0.5);
			};
			
			var closeMenuAction = function(e){
				if($(toggler).hasClass('slide-active')){
					slideMenuAction();
				}
			};

			$("#slide-nav").on("click", toggler, slideMenuAction);
			$(pagewrapper).on("click", closeMenuAction);

		});