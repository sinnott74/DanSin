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
				var selected = $(this).hasClass('slide-active');
				$('#slidemenu').stop().animate({
					left : selected ? menuneg : '0px'
				});
				$('#navbar-height-col').stop().animate({
					left : selected ? slideneg : '0px'
				});
				$(pagewrapper).stop().animate({
					left : selected ? '0px' : slidewidth
				});
				$(navigationwrapper).stop().animate({
					left : selected ? '0px' : slidewidth
				});
				$(this).toggleClass('slide-active', !selected);
				$('#slidemenu').toggleClass('slide-active');
				$('#page-content, .navbar, body, .navbar-header').toggleClass(
						'slide-active');
			};

			$("#slide-nav").on("click", toggler, slideMenuAction);

//			$(document).mouseup(function(e) {
//				var container = $("#non-navbar");
//
//				if (!container.is(e.target)&&$('#slidemenu').hasClass('slide-active')) // if the target of the click isn't
//						// the container...
////						&& container.has(e.target).length === 0) // ... nor a
//				// descendant
//				// of the
//				// container
//				{
//					slideMenuAction(e);
//				}
//			});

		});