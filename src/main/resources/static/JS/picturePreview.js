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

function readURLCreate(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
        	$('#picturePreviewCreate').removeClass("d-none")
        	$('#picturePreviewCreate').addClass("d-block");
        	$('#picturePreviewCreate').addClass("previewImg");
            $('#picturePreviewCreate').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
}

$("#picture").change(function(){
    readURL(this);
});

$("#pictureCreate").change(function(){
    readURLCreate(this);
});