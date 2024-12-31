jQuery(document).ready(function($) {
    "use strict";
	      
  
    // close quickview
	// Top product add class active.  Shopify issue
  	$( ".top-product-tab .product-tab-sw li" ).first().addClass( "active" );
  	$( ".top-product-tab .tab-content .tab-pane" ).first().addClass( "active in" );
    $(".quickview-close").on("click", function() {
        $('.quickview-wrapper').hide();
        $('.quickview-wrapper').removeClass('open');
        $('.quick-modal').removeClass('show');
    });
    // open Vertical menu 
    $(".js-vertical-menu").on("click", function() {
        $('.vertical-wrapper').slideToggle(200);
        $(this).toggleClass('active');
    });
    //menu change icon and dropdown
    $(".icon-mobile").on("click", function() {
        $(this).toggleClass('active');
    });
    //menu change icon and dropdown
    $(".js-menubar li .js-plus-icon").on("click", function() {
        $(this).toggleClass('minus');
        $(this).parent().find(".dropdown-menu").slideToggle(function() {
            $(this).next().stop(true).toggleClass('open', $(this).is(":visible"));
        });
    });

    $(".js-filter-menu li .js-plus-icon").on("click", function() {
        $(this).toggleClass('minus');
        $(this).parent().find(".filter-menu").slideToggle(function() {
            $(this).next().stop(true).toggleClass('open', $(this).is(":visible"));
        });
    });

    $(".filter .js-drop").on("click", function() {
        $(this).parent().find(".ion-ios-arrow-down").toggleClass('ion-ios-arrow-up');
        $(this).parent().find("ul").slideToggle(function() {
            $(this).next().stop(true).toggleClass('open', $(this).is(":visible"));
        });
        $(this).parent().find(".sidebar-product-list").slideToggle(function() {
            $(this).next().stop(true).toggleClass('open', $(this).is(":visible"));
        });
    });

    $(".checkout-page .js-drop").on("click", function() {
        $(this).toggleClass('active');

        $(this).parent().find(".filter-content").slideToggle(function() {
            $(this).next().stop(true).toggleClass('open', $(this).is(":visible"));
        });
    });
    // Product detail
    $(".js-close-tab").on("click", function() {
        $(this).removeClass('open')
        $('.detail-content').removeClass('active');
        $('.detail-tab').removeClass('open');

    });
    $('.js-tabs a').on("click", function() {
        $(".js-close-tab").addClass('open');
        $('.detail-tab').addClass('open');
        $('.detail-content').addClass('active');

    })
    if ($('.js-tabs > li').hasClass('active')) {
        $(".js-close-tab").addClass('open');
        $('.detail-tab').addClass('open');
        $('.detail-content').addClass('active');
    }

    // Product Grid
    $(".js-filter-menu li .js-plus-icon").on("click", function() {
        $(".js-filter-menu > li > a").toggleClass('active');
        $(this).toggleClass('minus');
        $(this).parent().find(".filter-menu").slideToggle(function() {
            $(this).next().stop(true).toggleClass('open', $(this).is(":visible"));
        });
    });
    // Open menu dropdown home 5
    $(".js-menubar li .icon-sub-menu").on("click", function() {

        $(this).toggleClass('up-icon');
        $(this).parent().find(".js-open-menu").slideToggle('fast', function() {
            $(this).next().stop(true).toggleClass('open', $(this).is(":visible"));
        });
    });
    // Open menu other page. Header-v2
    $(".js-menu").on("click", function() {
        $(this).toggleClass('active');
        $('.js-open-menu').toggleClass('open');
    });

	     // Caculator megamenu width
     // nomos_resizeMegamenu();
     // nomos_get_scrollbar_width();
    //  function nomos_resizeMegamenu() {
    //     var window_size = $('body').innerWidth();
    //     window_size += nomos_get_scrollbar_width();
    //     if (window_size > 1024) {
    //         if ($('#header .main-menu-wrapper').length > 0) {
    //             var container = $('#header .main-menu-wrapper');
    //             if (container != 'undefined') {
    //                 var container_width = 0;
    //                 container_width = container.innerWidth();
    //                 var container_offset = container.offset();
    //                 setTimeout(function() {
    //                     $('#header .navbar-nav .level1').each(function(index, element) {
    //                         $(element).children('.menu-level-1').css({ 'max-width': container_width + 'px' });
    //                         var sub_menu_width = $(element).children('.menu-level-1').outerWidth();
    //                         var item_width = $(element).outerWidth();
    //                         $(element).children('.menu-level-1').css({ 'left': '-' + (sub_menu_width / 2 - item_width / 2) + 'px' });
    //                         var container_left = container_offset.left;
    //                         var container_right = (container_left + container_width);
    //                         var item_left = $(element).offset().left;
    //                         var overflow_left = (sub_menu_width / 2 > (item_left - container_left));
    //                         var overflow_right = ((sub_menu_width / 2 + item_left) > container_right);
    //                         if (overflow_left) { var left = (item_left - container_left);
    //                             $(element).children('.menu-level-1').css({ 'left': -left + 'px' }) }
    //                         if (overflow_right && !overflow_left) { var left = (item_left - container_left);
    //                             left = left - (container_width - sub_menu_width);
    //                             $(element).children('.menu-level-1').css({ 'left': -left + 'px' }) }
    //                     })
    //                 }, 100)
    //             }
    //         }

    //         if ($('.page-right-content .main-menu-wrapper').length > 0) {
    //             var container = $('.page-right-content .main-menu-wrapper');
    //             if (container != 'undefined') {
    //                 var container_width = 0;
    //                 container_width = container.innerWidth();
    //                 var container_offset = container.offset();
    //                 setTimeout(function() {
    //                     $('.sidebar-menu-middle .navbar-nav .level1').each(function(index, element) {
    //                         $(element).children('.menu-level-1').css({ 'max-width': container_width + 'px' });
    //                         var sub_menu_width = $(element).children('.menu-level-1').outerWidth();
    //                         var item_width = $(element).outerWidth();
    //                         $(element).children('.menu-level-1').css({ 'left': '-' + (sub_menu_width / 2 - item_width / 2) + 'px' });
    //                         var container_left = container_offset.left;
    //                         var container_right = (container_left + container_width);
    //                         var item_left = $(element).offset().left;
    //                         var overflow_left = (sub_menu_width / 2 > (item_left - container_left));
    //                         var overflow_right = ((sub_menu_width / 2 + item_left) > container_right);
    //                         if (overflow_left) { var left = (item_left - container_left);
    //                             $(element).children('.menu-level-1').css({ 'left': -left + 'px' }) }
    //                         if (overflow_right && !overflow_left) { var left = (item_left - container_left);
    //                             left = left - (container_width - sub_menu_width);
    //                             $(element).children('.menu-level-1').css({ 'left': -left + 'px' }) }
    //                     })
    //                 }, 100)
    //             }
    //         }
    //     }
    // }
    function nomos_get_scrollbar_width() { 
        var $inner = $('<div style="width: 100%; height:200px;">test</div>'),
        $outer = $('<div style="width:200px; height:150px; position: absolute; top: 0; left: 0; visibility: hidden; overflow:hidden;"></div>').append($inner),
        inner = $inner[0],
        outer = $outer[0];
    $('body').append(outer); var width1 = inner.offsetWidth;
    $outer.css('overflow', 'scroll'); var width2 = outer.clientWidth;
    $outer.remove(); return (width1 - width2) }
  
    // Push menu home 5
    var menuLeft = $('.pushmenu-left');
    var menuHome6 = $('.menu-home5');
    var nav_list = $('.open-cart');
    var nav_click = $('.icon-pushmenu');
    nav_list.on("click", function(event) {
        event.stopPropagation();
        $(this).toggleClass('active');
        $('body').toggleClass('pushmenu-push-toright-cart');
        menuLeft.toggleClass('pushmenu-open');
        $(".container").toggleClass("canvas-container");
    });
    nav_click.on("click", function(event) {
        event.stopPropagation();
        $(this).toggleClass('active');
        $('body').toggleClass('pushmenu-push-toleft');
        menuHome6.toggleClass('pushmenu-open');
    });
    $(".wrappage").on("click", function() {
        $(this).removeClass('active');
        $('body').removeClass('pushmenu-push-toright-cart').removeClass('pushmenu-push-toleft');
        menuLeft.removeClass('pushmenu-open');
        menuHome6.removeClass('pushmenu-open');
    });
    $(".close-left").on("click", function() {
        $(this).removeClass('active');
        $('body').removeClass('pushmenu-push-toright-cart');
        menuLeft.removeClass('pushmenu-open');
    });
    $(".close-left").on("click", function() {
        $('body').removeClass('pushmenu-push-toleft');
        menuHome6.removeClass('pushmenu-open');
    });
    
  	$('.js-oneitem2').slick({
        dots: true,
        arrows: false,
      	slidesToShow: 1,
      slidesToScroll: 1
    })
    .on('beforeChange', function(event, slick, currentSlide, nextSlide){
      $('.js-oneitem2').slick('setPosition');
    });
  	   
    // Js product single slider
    $('.js-click-product').slick({
      	
        slidesToShow: 4,
        slidesToScroll: 1,
        asNavFor: '.js-product-slider',
        dots: false,
        focusOnSelect: true,
        infinite: true,
        arrows: false,
        vertical: true,
        responsive: [

            {
                breakpoint: 1367,
                settings: {
                    vertical: false
                }
            }
        ]
    });
    $('.js-product-slider').slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        arrows: false,
        asNavFor: '.js-click-product'
    });
  	
  
   $('.js-product-slider').on("mousedown mouseup", function() {
    $('.js-oneitem2').slick("slickGoTo", 1);
    
  })
   
    //SHOP LISTING FILTER
    // Price Slider
    if ($('.price-slider').length > 0) {
        $('.price-slider').slider({
            min: 100,
            max: 700,
            step: 10,
            value: [100, 400],


        });
    }
  	
    //SHOP GRID
    $(".view-mode > a").on("click", function() {
        $(this).addClass('active').siblings().removeClass('active');;

        if ($(this).hasClass('col2')) {
            $(".product-grid").addClass("product-grid-v2");
            $(".product-grid").removeClass("product-list");
        }
        if ($(this).hasClass('col')) {
            $(".product-grid").removeClass("product-grid-v2 product-list");
        }
        if ($(this).hasClass('list')) {
            $(".product-grid").addClass("product-list product-grid-v2");
        }
    });
    // Open zipcode
    $(".calculate").on('click', function() {
        $(this).next().slideToggle();
        $(this).toggleClass("active");
    });
    // Checkout : open login box
    $(".js-showlogin").on('click', function() {
        $(".js-openlogin").slideToggle();
        $(this).toggleClass("active");
    });
    // Checkout : open coupon
    $(".js-showcp").on('click', function() {
        $(".js-opencp").slideToggle();
        $(this).toggleClass("active");

    });
    //Open filter menu mobile
    $('.filter-collection-left > a').on('click', function(e) {
        $('.wrappage').addClass('show-filter');
      	e.stopPropagation()
    });
    $(document).on("click", function(e) {
      if ($(e.target).is(".filter-collection-left > a") === false) {
        $('.wrappage').removeClass("show-filter");
      }
    });
    $('.close-sidebar-collection').click(function() {
        $('.wrappage').removeClass('show-filter');
    });

    
    // Scroll to TOP
    $(window).scroll(function() {
        if ($(this).scrollTop() > 100) {
            $('.scroll_top').fadeIn().addClass("active");
        } else {
            $('.scroll_top').fadeOut().removeClass("active");
        }
    });

    $('.scroll_top').on('click', function() {
        $("html, body").animate({
            scrollTop: 0
        }, 600);
        return false;
    });
    
    // owl category
    $('.js-owl-cate').owlCarousel({
        margin: 30,
        autoplay: false,
        autoplayTimeout: 3000,
        loop: true,
        dots: false,
        nav: true,
        navText: ["<span class='fa fa-angle-left'></span>", "<span class='fa fa-angle-right'></span>"],
        responsive: {
            0: {
                items: 1
            },
            480: {
                items: 2
            },
            1024: {
                items: 3,

            },
            1200: {
                items: 4,
                nav: false,
                dots:true
            },
            1600: {
                items: 4,
                margin: 40,
                nav: false,
                dots:true
            }
        }
    });

   	$('.js-owl-pd-arrow').each( function() {
        var $carousel = $(this);
        $carousel.owlCarousel({
            dots : false,
            items : 5,
            loop : true,
            margin : 10,
            nav : true,
            navText: ["<span class='fa fa-angle-left'></span>", "<span class='fa fa-angle-right'></span>"],
          	responsive : {'0':{'items':1,'dots':false,'nav':true},'480':{'items':2},'1024':{'items':3},'1200':{'items':4}},
        });
    });
    $('.js-owl-team').owlCarousel({
        margin: 30,
        autoplay: false,
        autoplayTimeout: 3000,
        loop: true,
        dots: false,
        nav: true,
        navText: ["<span class='fa fa-angle-left'></span>", "<span class='fa fa-angle-right'></span>"],
        responsive: {
            0: {
                items: 1
            },
            480: {
                items: 2
            },
            1024: {
                items: 3
            },
            1200: {
                items: 4,
                margin: 40
            }
        }
    });
    $('.js-owl-cate2').owlCarousel({
        margin: 30,
        autoplay: false,
        autoplayTimeout: 3000,
        loop: true,
        dots: true,
        nav: false,
        responsive: {
            0: {
                items: 1
            },
            480: {
                items: 2
            },
            1024: {
                items: 3
            },
            1200: {
                items: 3
            },
            1600: {
                items: 3,
                margin: 40
            }
        }
    });


    // owl brand
    $('.js-owl-brand').owlCarousel({
        margin: 30,
        autoplay: false,
        autoplayTimeout: 3000,
        loop: true,
        dots: false,
        nav: true,
        navText: ["<span class='fa fa-angle-left'></span>", "<span class='fa fa-angle-right'></span>"],
        responsive: {
            0: {
                items: 1
            },
            480: {
                items: 3
            },
            1024: {
                items: 5
            },
            1200: {
                items: 7
            }
        }
    });
    $('.js-owl-brand2').owlCarousel({
        margin: 30,
        autoplay: false,
        autoplayTimeout: 3000,
        loop: true,
        dots: false,
        nav: true,
        navText: ["<span class='fa fa-angle-left'></span>", "<span class='fa fa-angle-right'></span>"],
        responsive: {
            0: {
                items: 1
            },
            480: {
                items: 3
            },
            1024: {
                items: 4
            },
            1200: {
                items: 6
            }
        }
    });
    $(".js-owl-brand2 .owl-nav > div").on("click", function() {
        $(this).addClass('active').siblings().removeClass('active');
    });
  
  	$('.js-base-owl').each( function() {
        var $carousel = $(this);
        $carousel.owlCarousel({
            dots : false,
            items : 15,
            loop : true,
            margin : 10,
            nav : true,
            navText: ["<span class='fa fa-angle-left'></span>", "<span class='fa fa-angle-right'></span>"],
          	responsive : {"0":{"items":1},"480":{"items":3},"1024":{"items":5},"1200":{"items":10}},
        });
    });
    // product carousel
    $('.js-owl-product').owlCarousel({
        margin: 30,
        autoplay: true,
        autoplayTimeout: 3000,
        loop: true,
        dots: false,
        nav: true,
        navText: ["<span class='fa fa-angle-left'></span>", "<span class='fa fa-angle-right'></span>"],
        responsive: {
            0: {
                items: 1
            },
            480: {
                items: 2
            },
            1024: {
                items: 2
            },
            1200: {
                items: 3
            }
        }
    });
  	   $('.base-js-owl-product').each( function() {
          var $carousel = $(this);
          $carousel.owlCarousel({
              dots : $carousel.data("dots"),
              autoplay:$carousel.data("autoplay"),
              items : $carousel.data("items"),
              loop : $carousel.data("loop"),
                slidespeed: $carousel.data("slidespeed"),
              margin : $carousel.data("margin"),
              nav : $carousel.data("nav"),
              navText: ["<span class='fa fa-angle-left'></span>", "<span class='fa fa-angle-right'></span>"],
              responsive : $carousel.data("responsive"),
          });
      });
    $('.js-owl-product2').owlCarousel({
        margin: 30,
        autoplay: false,
        autoplayTimeout: 3000,
        loop: true,
        dots: false,
        nav: true,
        navText: ["<span class='fa fa-angle-left'></span>", "<span class='fa fa-angle-right'></span>"],
        responsive: {
            0: {
                items: 1
            },
            480: {
                items: 2
            },
            1200: {
                items: 3
            },
            1600: {
                items: 3,
                margin: 40
            }
        }
    });
  	
    $(".js-owl-product2 .owl-nav > div").on("click", function() {
        $(this).addClass('active').siblings().removeClass('active');
    });
    $('.js-owl-blog').owlCarousel({

        margin: 30,
        autoplay: false,
        autoplayTimeout: 3000,
        loop: true,
        dots: true,
        nav: true,
        navText: ["<span class='fa fa-angle-left'></span>", "<span class='fa fa-angle-right'></span>"],
        responsive: {
            0: {
                items: 1
            },
            480: {
                items: 2
            },
            1200: {
                items: 3
            },
            1600: {
                items: 3,
                margin: 40
            }
        }
    });
    $(".js-owl-blog .owl-nav > div").on("click", function() {
        $(this).addClass('active').siblings().removeClass('active');
    });
    $(".js-quickview-slide  .slick-arrow").on("click", function() {
        $(this).addClass('active');
    });
    $('.js-owl-post').owlCarousel({
        nav: true,
        navText: ["<span class='fa fa-angle-left'></span>", "<span class='fa fa-angle-right'></span>"],
        items: 1,
        dots: false
    });
    $('.js-owl-quote').owlCarousel({
        nav: false,
        items: 1,
        dots: true,
        singleItem: true,
    });
    $('.js-oneitem').owlCarousel({
        nav: false,
        items: 1,
        dots: true,
        singleItem: true,
    });
    
    // Instagram carousel
    $('.js-owl-instagram').owlCarousel({
        margin: 0,
        autoplay: true,
        autoplayTimeout: 3000,
        loop: true,
        nav: false,
        navText: ["", ""],
        dots: false,
        responsive: {
            0: {
                items: 1
            },
            480: {
                items: 2
            },
            1000: {
                items: 5
            }
        }
    });


    $('.js-multiple-row').slick({
        dots: true,
        arrows: false,
        slidesPerRow: 3,
        rows: 2,
        responsive: [{
                breakpoint: 1025,
                settings: {
                    slidesPerRow: 3,
                }
            },
            {
                breakpoint: 813,
                settings: {
                    slidesPerRow: 2,
                }
            },
            {
                breakpoint: 480,
                settings: {
                    arrows: true,
                    prevArrow: '<span class="prev"><i class="fa fa-angle-left" aria-hidden="true"></i></span>',
                    nextArrow: '<span class="next"><i class="fa fa-angle-right" aria-hidden="true"></i></span>',
                    infinite: true,
                    dots: false,
                    slidesPerRow: 1,
                    rows: 1,
                }
            }
        ]
    });
    $('.js-multiple-row3').slick({
        dots: true,
        arrows: false,
        slidesPerRow: 2,
        rows: 2,
        responsive: [{
                breakpoint: 1025,
                settings: {
                    slidesPerRow: 2,
                }
            },
            {
                breakpoint: 813,
                settings: {
                    slidesPerRow: 1,
                }
            },
            {
                breakpoint: 480,
                settings: {
                    arrows: true,
                    prevArrow: '<span class="prev"><i class="fa fa-angle-left" aria-hidden="true"></i></span>',
                    nextArrow: '<span class="next"><i class="fa fa-angle-right" aria-hidden="true"></i></span>',
                    infinite: true,
                    dots: false,
                    slidesPerRow: 1,
                    rows: 1,
                }
            }
        ]
    });




    // js slick one item homepage 3

    // Slider collectiion full
    var $status = $('.pagingInfo');
    var $slickElement = $('.js-slider-collectionf');
    $slickElement.on('init reInit afterChange', function(event, slick, currentSlide, nextSlide) {
        //currentSlide is undefined on init -- set it to 0 in this case (currentSlide is 0 based)
        var i = (currentSlide ? currentSlide : 0) + 1;
        $status.text('0' + i);
    });
    $('.js-slider-collectionf').on('afterChange', function(event, slick, currentSlide) {
        $('.slick-active').append('<div class="pagingInfo"');
    });
    $('.js-slider-collectionf').slick({
        autoplay: true,
        dots: true,
        centerMode: true,
        infinite: true,
        centerMode: true,
        slidesToShow: 1,
        slidesToScroll: 1,
        arrows: false,
        appendDots: $('.post-fade'),
        dotsClass: 'custom_paging',
        customPaging: function(slider, i) {
            var thumb = $(slider.$slides[i]).data();
            return '<a class="dots"></a>';
        },

    });
	
    // Slider collectiion full
    var $status = $('.pagingInfo');
    var $slickElement = $('.js-slider-home4');
    $slickElement.on('init reInit afterChange', function(event, slick, currentSlide, nextSlide) {
        //currentSlide is undefined on init -- set it to 0 in this case (currentSlide is 0 based)
        var i = (currentSlide ? currentSlide : 0) + 1;
        $status.text('0' + i);
    });
    $('.js-slider-home4').on('afterChange', function(event, slick, currentSlide) {
        $('.slick-active').append('<div class="pagingInfo"');
    });
    $('.js-slider-home4').slick({
        autoplay: true,
        dots: true,
        infinite: true,
        slidesToShow: 1,
        slidesToScroll: 1,
        arrows: false,
        appendDots: $('.post-fade'),
        dotsClass: 'custom_paging',
        customPaging: function(slider, i) {
            var thumb = $(slider.$slides[i]).data();
            return '<a class="dots"></a>';
        },
    });
    // Slider collection detail
    $('.js-slider-collectiond').slick({
        autoplay: true,
        dots: true,
        infinite: true,
        slidesToShow: 1,
        slidesToScroll: 1,
        arrows: false,
        appendDots: $('.post-fade'),
        dotsClass: 'custom_paging',
        customPaging: function(slider, i) {
            var thumb = $(slider.$slides[i]).data();
            return '<a class="dots"></a>';
        },

    });
    //  Show more

    // slider home 3 and home 2
    $('.js-slider-3items').slick({
        autoplay: false,
        infinite: false,
        arrows: false,
        dots: true
    });
    // js blogpost
    $('.js-single-post').slick({
        autoplay: false,
        slidesToShow: 1,
        slidesToScroll: 1,
        infinite: true,
        arrows:false,
        dots: true
    });
    // js quickview
    $('.js-quickview-slide').slick({
        autoplay: false,
        slidesToShow: 1,
        slidesToScroll: 1,
        infinite: true,
        arrows: true,
        prevArrow: '<span class="prev"><i class="fa fa-angle-left" aria-hidden="true"></i></span>',
        nextArrow: '<span class="next"><i class="fa fa-angle-right" aria-hidden="true"></i></span>',
        dots: true
    });
    // slider home 1
 
    $( ".js-slider-home2" ).each(function() {
      $( this ).slick({
        autoplay: false,
        slidesToShow: 1,
        slidesToScroll: 1,
        infinite: true,
        arrows: true,
        prevArrow: '<span class="prev"><i class="fa fa-angle-left" aria-hidden="true"></i></span>',
        nextArrow: '<span class="next"><i class="fa fa-angle-right" aria-hidden="true"></i></span>'
    });
 });
      $('.js-slide-none').slick({
        dots: false,
        arrows: false,
        infinite: false,
        slidesToShow: 1,
        slidesToScroll: 1
    });

    // JS owl team Carousel 
    $('.js-owl-test').owlCarousel({
        items: 1,
        singleItem: true,
        nav: true,
        navText: ["<span class='fa fa-angle-left'></span>", "<span class='fa fa-angle-right'></span>"],
        dots: false,
    });
	// Cate v2
  	$( ".js-caegory-image" ).each(function() {
      $( this ).slick({
          autoplay: false,
          slidesToShow: 1,
          slidesToScroll: 1,
          infinite: false,
          arrows: false,
          dots:true
      });
    });
  	// JS owl team Carousel 
    
    // Scroll slide homepage 2

    $('.slide-scroll').on('click', function() {
        $('html, body').animate({ scrollTop: $('section#contenthome2').offset().top }, 'slow');
        return false;
    });
    var handleScrollTop = function(e) {
        e.preventDefault();
        $('html, body').animate({ scrollTop: 0 }, 250);
    };
    // Footer to top
    $('footer > .scroll-top').on('click', function(e) {
        handleScrollTop(e);
    });

    $('.backto.vow-top').on('click', function(e) {
        handleScrollTop(e);
    });
    // Read more
    $(function() {
        var $header = $('.entry-content');
        var $half = parseInt($(".img-cal").height()) / 2;
        var $window = $(window).on('resize', function() {
            var height = $header.height() - $half;
            $header.height(height);
        }).trigger('resize'); //on page load


    });
    $(function() {

        var $el, $ps, $up, $p, totalHeight;

        $(".entry-content .btn-show").click(function() {

            // IE 7 doesn't even get this far. I didn't feel like dicking with it.

            totalHeight = 0

            $el = $(this);
            $p = $el.parent();
            $up = $p.parent();
            $ps = $up.find(".e-text");

            // measure how tall inside should be by adding together heights of all inside paragraphs (except read-more paragraph)
            $ps.each(function() {
                totalHeight += $(this).outerHeight();
                // FAIL totalHeight += $(this).css("margin-bottom");
            });

            $up
                .css({
                    // Set height to prevent instant jumpdown when max height is removed
                    "height": $up.height(),
                    "max-height": 9999,
                    "margin-bottom": 30
                })
                .animate({
                    "height": totalHeight
                });

            // fade out read-more
            $up.removeClass('active');
            $p.fadeOut();

            // prevent jump-down
            return false;

        });

    });
/*******************************************************/   
  // Zenstore Custom
  /*******************************************************/  
  // sticky scroll
    if ($(".single-product-detail").hasClass("engoc-product-design-sticky")) {
    var s, o, i = $(".entry-summary"),
        n = i.find(".summary-inner"),
        r = i.width(),
        l = $(".product-images"),
        c = l.find(".shopify-product-gallery__wrapper a"),
        d = $(window).height(),
        u = l.outerHeight(),
        p = 130,
        h = 600,
        m = i.outerHeight(),
        f = $(window).scrollTop(),
        g = l.offset().top,
        v = i.offset().left + 15,
        w = g + u,
        b = f + p + m;
        i.css({ height: m }),
        $(window).resize(function() {
            d = $(window).height(),
                m = i.outerHeight(),
                u = l.outerHeight(),
                m < d - p ? i.addClass("in-viewport").removeClass("not-in-viewport") : i.removeClass("in-viewport").addClass("not-in-viewport"), f = $(window).scrollTop(),
                b = f + p + m,
                r = i.width(),
                v = i.offset().left + 15,
                g = l.offset().top,
                w = g + u, r > h && (v += o = (r - h) / 2),
                f + p >= g ? (i.addClass("block-sticked"),
                    n.css({ top: p, width: r, position: "fixed", transform: "translateY(-20px)" })) : (i.removeClass("block-sticked"),
                    n.css({ top: "auto", left: "auto", width: "auto", position: "relative", transform: "translateY(0px)" })),
                b > w ? i.addClass("hide-temporary") : i.removeClass("hide-temporary"), d = $(window).height(),
                c.each(function() { s = $(this).offset().top, f > s - d + 20 && ($(this).addClass("animate-images")) })
        }),
        $(window).scroll(function() {
            d = $(window).height(),
                c.each(function() { s = $(this).offset().top, f > s - d + 20 && ($(this).addClass("animate-images")) })

            f = $(window).scrollTop(),
                b = f + p + m,
                r = i.width(),
                v = i.offset().left + 15,
                g = l.offset().top,
                w = g + u, r > h && (v += o = (r - h) / 2),
                f + p >= g ? (i.addClass("block-sticked"),
                    n.css({ top: p, width: r, position: "fixed", transform: "translateY(-20px)" })) : (i.removeClass("block-sticked"),
                    n.css({ top: "auto", left: "auto", width: "auto", position: "relative", transform: "translateY(0px)" })),
                b > w ? i.addClass("hide-temporary") : i.removeClass("hide-temporary")

            d = $(window).height(),
                m = i.outerHeight(),
                u = l.outerHeight(),
                m < d - p ? i.addClass("in-viewport").removeClass("not-in-viewport") : i.removeClass("in-viewport").addClass("not-in-viewport"), d = $(window).height(),
                c.each(function() { s = $(this).offset().top, f > s - d + 20 && ($(this).addClass("animate-images")) }), d = $(window).height(),
                c.each(function() { s = $(this).offset().top, f > s - d + 20 && ($(this).addClass("animate-images")) })
        })
    }
  	
  	// Open Search popup
    $(".search-toggle").on("click", function() {
		$(".btn-search-close").removeClass('btn--hidden');
        $('.search-form-wrapper').addClass('search--open');
        $('body').addClass('search-opened');
    });
  	$(".btn-search-close").on("click", function() {
		$(this).addClass('btn--hidden');
        $('.search-form-wrapper').removeClass('search--open', 1000);
        $('body').removeClass('search-opened');
    });
      $(document).on('keyup',function(evt) {
        if (evt.keyCode == 27) {
           $('.btn-search-close').addClass('btn--hidden');
            $('.search-form-wrapper').removeClass('search--open', 1000);
            $('body').removeClass('search-opened');
        }
    });
  
  $('.base-js-single-product').each( function() {
    
    	$(this).slick({
        autoplay: false,
        slidesToShow: 1,
        slidesToScroll: 1,
        infinite: false,
		arrows: true,
        prevArrow: $('.prev2'),
        nextArrow: $('.next2')
    });
  });   

  // 	$('.base-js-multiple-row2').each( function() {
 	// var slick = $(this),
  // 	item =  $(this).data('item');
      
      $('.base-js-multiple-row2').slick({
        
        
        prevArrow: $('.prev3'),
        nextArrow: $('.next3'),
        slidesPerRow: 3,
        rows: 2,
        responsive: [{
                breakpoint: 1025,
                settings: {
                    slidesPerRow: 2,
                }
            },
            
            {
                breakpoint: 480,
                settings: {
                                      
                    arrows: true,
                    prevArrow: '<span class="prev"><i class="fa fa-angle-left" aria-hidden="true"></i></span>',
                    nextArrow: '<span class="next"><i class="fa fa-angle-right" aria-hidden="true"></i></span>',
                    
                    infinite: false,
                    dots: false,
                    slidesPerRow: 1,
                }
            }
        ]
    });
         // });
  
  
      $('.js-multiple-row2').each( function() {
    var slick = $(this),
    item =  $(this).data('item');
      
      $(this).slick({
        
        
        
        slidesPerRow: item,
        rows: 2,
        responsive: [{
                breakpoint: 1025,
                settings: {
                    slidesPerRow: 3,
                }
            },
            {
                breakpoint: 813,
                settings: {
                    slidesPerRow: 2,
                }
            },
            {
                breakpoint: 480,
                settings: {
                                      
                    arrows: true,
                    prevArrow: '<span class="prev"><i class="fa fa-angle-left" aria-hidden="true"></i></span>',
                    nextArrow: '<span class="next"><i class="fa fa-angle-right" aria-hidden="true"></i></span>',
                    
                    infinite: true,
                    dots: false,
                    slidesPerRow: 1,
                    rows: 1,
                }
            }
        ]
    });
         });
  
  $('.js-multiple-row-arrow').each( function() {
    var slick = $(this),
    item =  $(this).data('item');
      
      $(this).slick({
        slidesPerRow: 4,
        prevArrow: '<span class="prev"><i class="fa fa-angle-left" aria-hidden="true"></i></span>',
        nextArrow: '<span class="next"><i class="fa fa-angle-right" aria-hidden="true"></i></span>',
        rows: 2,
        responsive: [{
                breakpoint: 1025,
                settings: {
                    slidesPerRow: 3,
                }
            },
            {
                breakpoint: 813,
                settings: {
                    slidesPerRow: 2,
                }
            },
            {
                breakpoint: 480,
                settings: {
                                      
                    arrows: true,
                    prevArrow: '<span class="prev"><i class="fa fa-angle-left" aria-hidden="true"></i></span>',
                    nextArrow: '<span class="next"><i class="fa fa-angle-right" aria-hidden="true"></i></span>',
                    
                    infinite: true,
                    dots: false,
                    slidesPerRow: 1,
                }
            }
        ]
    });
         });
  	/*--
    Header Search
    ------------------------*/
//     var searchToggle = $('.search-toggle');
//     var searchContainer = $('.header-search-container');

//     searchToggle.on('click', function(){

//         if( !$(this).hasClass('active') ) {
//             $(this).addClass('active').find('i').removeClass('icon-magnifier').addClass('icon-close');
//             searchContainer.slideDown();
//         } else {
//             $(this).removeClass('active').find('i').removeClass('icon-close').addClass('icon-magnifier');
//             searchContainer.slideUp();
//         }

//     });
//   Close promo
  $('.js-promo').click(function() {
      $('.header-top-banner').addClass('br-promotion--close')
    });
// SHOPPING CART Quantity increment buttons

    var quantitiy = 0;
    $('.js-plus').on("click", function(e) {

        // Stop acting like a button
        e.preventDefault();
        // Get the field name
        var quantity = parseInt($('.js-number').val(), 10);

        // If is not undefined

        $('.js-number').val(quantity + 1);


        // Increment    
    });

    $('.js-minus').on("click", function(e) {
        // Stop acting like a button
        e.preventDefault();
        // Get the field name
        var quantity = parseInt($('.js-number').val(), 10);

        // If is not undefined

        // Increment
        if (quantity > 0) {
            $('.js-number').val(quantity - 1);
        }
    });
    // ---------slide  home 7-------------
  $('.slider-home7').slick({
    dots:false,
    infinite: true,
    autoplay:false,
    slidesToShow: 1,
    speed: 1000,
    fade: true,
    customPaging : function(slider, i) {
    var thumb = $(slider.$slides[i]).data();
    return '<a></a>';
    },
  });
  // ---------end-----------
  $('.js-instagram-v3-test').owlCarousel({
          margin: 0,
          autoplay: true,
          autoplayTimeout: 3000,
          loop: true,
          nav: false,
          navText: ["", ""],
          dots: false,
          responsive: {
            0: {
              items: 1
            },
            480: {
              items: 2
            },
            1000: {
              items: 6
            }
          }
        });
  $('.js-base-owl-2').each( function() {
        var $carousel = $(this);
        $carousel.owlCarousel({
            dots : false,
            items : 5,
            loop : true,
            margin : 30,
            nav : false,
            navText: ["<span class='fa fa-angle-left'></span>", "<span class='fa fa-angle-right'></span>"],
            responsive : {
                0:{items:1},480:{items:3},1024:{items:4},1200:{items:5}}
        });
    });
  $('.js-base-owl-3').each( function() {
        var $carousel = $(this);
        $carousel.owlCarousel({
            dots : false,
            items : 9,
            loop : true,
            margin : 30,
            nav : false,
            navText: ["<span class='fa fa-angle-left'></span>", "<span class='fa fa-angle-right'></span>"],
            responsive : {"0":{"items":1},"480":{"items":2},"1024":{"items":2},"1200":{"items":3}}
        });
    });
});