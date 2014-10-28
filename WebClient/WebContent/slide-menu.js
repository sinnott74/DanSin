$(document).ready(
		function() {
			var toggler = '.navbar-toggle';
			var pagewrapper = '#page-content';
			var menuneg = '-100%';

			var slideMenuAction = function(e) {
				var selected = $(toggler).hasClass('slide-active');
				$('#slidemenu').stop().animate({
					left : selected ? menuneg : '0px'
				});
				$('#slidemenu').children().zIndex(100);

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
			
//			$(pagewrapper).on("swiperight",function(){
//				  alert("You swiped right!");
//				});
//			
			
			var testPageWrapper = document.getElementById('page-content');
			var mc = new Hammer(testPageWrapper);
			mc.on("swiperight", function(ev) {
//				testPageWrapper.textContent = ev.type +" gesture detected.";
				slideMenuAction();
			});

		});