let getUrl = function(flie) {
    let url = ''
    if (window.createObjectURL!=undefined) { // basic
        url = window.createObjectURL(flie) ;
    }else if (window.webkitURL!=undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(flie) ;
    }else if (window.URL!=undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(flie) ;
    }
    return url
}
$("#file1").change(() => {
    let url = getUrl($("#file1")[0].files[0])
    $('#img1').css("background-image","url(" + url + ")");
});