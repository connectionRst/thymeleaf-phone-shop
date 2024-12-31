jQuery(document).ready(function( $ ) {
  $('.js-product-360').ThreeSixty({
    totalFrames: 25, // Total no. of image you have for 360 slider
    endFrame: 25, // end frame for the auto spin animation
    currentFrame: 1, // This the start frame for auto spin
    imgList: '.threesixty_images', // selector for image list
    progress: '.spinner', // selector to show the loading progress
    imgArray: ["asset/img/iphone-x-64gb-org-1.jpg","asset/img/iphone-x-64gb-org-2.jpg","asset/img/iphone-x-64gb-org-3.jpg","asset/img/iphone-x-64gb-org-4.jpg","asset/img/iphone-x-64gb-org-5.jpg","asset/img/iphone-x-64gb-org-6.jpg","asset/img/iphone-x-64gb-org-7.jpg","asset/img/iphone-x-64gb-org-8.jpg","asset/img/iphone-x-64gb-org-9.jpg","asset/img/iphone-x-64gb-org-10.jpg","asset/img/iphone-x-64gb-org-11.jpg","asset/img/iphone-x-64gb-org-12.jpg","asset/img/iphone-x-64gb-org-13.jpg","asset/img/iphone-x-64gb-org-14.jpg","asset/img/iphone-x-64gb-org-15.jpg","asset/img/iphone-x-64gb-org-16.jpg","asset/img/iphone-x-64gb-org-17.jpg","asset/img/iphone-x-64gb-org-18.jpg","asset/img/iphone-x-64gb-org-19.jpg","asset/img/iphone-x-64gb-org-20.jpg","asset/img/iphone-x-64gb-org-21.jpg","asset/img/iphone-x-64gb-org-22.jpg","asset/img/iphone-x-64gb-org-23.jpg","asset/img/iphone-x-64gb-org-24.jpg","asset/img/iphone-x-64gb-org-25.jpg","asset/img/iphone-x-64gb-org-26.jpg","asset/img/iphone-x-64gb-org-27.jpg","asset/img/iphone-x-64gb-org-28.jpg","asset/img/iphone-x-64gb-org-29.jpg","asset/img/iphone-x-64gb-org-30.jpg","asset/img/iphone-x-64gb-org-31.jpg","asset/img/iphone-x-64gb-org-32.jpg","asset/img/iphone-x-64gb-org-33.jpg","asset/img/iphone-x-64gb-org-34.jpg","asset/img/iphone-x-64gb-org-35.jpg","asset/img/iphone-x-64gb-org-36.jpg"], // path of the image ..s
    filePrefix: '', // file prefix if any
    ext: '.jpg', // extention for the ..s
    // responsive: true,
    navigation: true

  });   
});
