$(function(){
    let currentIndex = 0;
    let nextIndex = 1;

    $('.view-image').eq(0).css({left:0});
    $('.view-image').eq(1).css({left:'-300px'});
    $('.view-image').eq(2).css({left:'-300px'});

    setInterval(function(){
        $('.view-image').eq(currentIndex).animate({
            left:'-300px'
        });
        $('.view-image').eq(nextIndex).css({
            left:'300px'
        }).animate({
            left:'0px'
        });

        currentIndex = nextIndex;
        nextIndex++;

        if(nextIndex > 2){
            nextIndex = 0;
        }
    }, 3000);

    let currentIndex2 = 0;
    let nextIndex2 = 1;

    setInterval(function(){
        $('.image2').eq(currentIndex).removeClass('jump in').addClass('out').delay(1000).queue(function(){
            $(this).removeClass('out').addClass('jump').dequeue();
        });
        $('.image2').eq(nextIndex).removeClass('jump out').addClass('in');

        currentIndex2 = nextIndex2;
        nextIndex2++;

        if(nextIndex2 > 2){
            nextIndex2 = 0;
        }
    }, 3000);
});