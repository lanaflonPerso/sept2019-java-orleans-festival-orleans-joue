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
});
