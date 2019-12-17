jQuery(document).ready(function ($) {

    /*******************
    	main  navigation
    ********************/
    var contentSections = $('main section');

    //smooth scroll to the selected section
    $('.cd-main-nav a[href^="#"]').on('click', function (event) {
        event.preventDefault();
        var target = $(this.hash),
            topMargin = target.css('marginTop').replace('px', ''),
            headerHeight = $('header').height();
        $('body,html').animate({
            'scrollTop': parseInt(target.offset().top - headerHeight - topMargin)
        }, 200);
    });
    //update selected navigation element
    $(window).on('scroll', function () {
        updateNavigation();
    });

    function updateNavigation() {
        contentSections.each(function () {
            var actual = $(this),
                actualHeight = actual.height(),
                topMargin = actual.css('marginTop').replace('px', ''),
                actualAnchor = $('.cd-main-nav').find('a[href="#' + actual.attr('id') + '"]');

            if ((parseInt(actual.offset().top - $('.cd-main-nav').height() - topMargin) <= $(window).scrollTop()) && (parseInt(actual.offset().top + actualHeight - topMargin) > $(window).scrollTop() + 1)) {
                actualAnchor.addClass('selected');
            } else {
                actualAnchor.removeClass('selected');
            }
        });
    }

    $(document).click(function (event) {
        var clickover = $(event.target);
        var _opened = $(".navbar-collapse").hasClass("show");
        if (_opened === true && !clickover.hasClass("navbar-toggle")) {
            $("button.navbar-toggler").click();
        }
    });
    

/*    $(".toastCustom-trigger").click(function(e){ */

    $(".close-toastCustom").click(function(e){
      e.preventDefault();
      datatoastCustom = $(this).parent().attr("id");
      $("#" + datatoastCustom).fadeOut(400);
    });
});

window.onload = function(e) {
	e.preventDefault();

	if (hasSubscribe === "ok") {
		if (!$("#toastAlertOk").is(":visible")) {
			$("#toastAlertOk").fadeIn(400).delay(2000).fadeOut(400);
		}
	} else if (hasSubscribe === "ko") {
		if (!$(".toastKo").is(":visible")) {
			$(".toastKo").fadeIn(400).delay(2000).fadeOut(400);
		}
	} else if (hasSubscribe === "delete") {
		if (!$(".toastKo").is(":visible")) {
			$(".toastKo").text('Votre demande d\'inscription a bien été annulée.');
			$(".toastKo").fadeIn(400).delay(2000).fadeOut(400);
		}
	} else if (hasSubscribe === "update") {
		if (!$(".toastOk").is(":visible")) {
			$(".toastOk").text('Votre mise à jour a bien été prise en compte.');
			$(".toastOk").fadeIn(400).delay(2000).fadeOut(400);
		}
	}
};

