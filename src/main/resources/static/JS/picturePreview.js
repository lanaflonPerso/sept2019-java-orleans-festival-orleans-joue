function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
        	$('#picturePreview').removeClass("d-none")
        	$('#picturePreview').addClass("d-block");
        	$('#picturePreview').addClass("previewImg");
            $('#picturePreview').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
}

$("#picture").change(function(){
    readURL(this);
});