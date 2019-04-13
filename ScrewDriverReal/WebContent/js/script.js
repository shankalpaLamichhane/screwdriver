$(document).ready(function(){
    $(".btn").click(function(){
        $("nav ul").slideToggle(500);
    })
})

$(".sliding-link").click(function(e) {
    e.preventDefault();
    var aid = $(this).attr("href");
    $('html,body').animate({scrollTop: $(aid).offset().top},'slow');
});