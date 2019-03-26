class Filter {

    main(storageName, radios) {
        window.onload = function() {
            // console.log(localStorage.getItem(storageName));
            if (localStorage.getItem(storageName) !== null) {
                var filter = localStorage.getItem(storageName);
                console.log(radios);
                for (var radio of radios) {
                    console.log("radio: " + radio.value);
                    console.log("filter: " + filter);
                    // radio.checked = false;
                    if (radio.value === filter) {
                        radio.checked = true;
                        localStorage.clear();
                    }
                }
            }
        };
        for (const radio of radios) {
            radio.onclick = function() {
                if (radio.checked === true) {
                    localStorage.setItem(storageName, radio.value);
                }
            };
        }
    }
}

function cleanUp(){
    var boxes = document.querySelectorAll(".detail-box");
    for (const box of boxes){
        var body = box.querySelector(".detail-body");
        if (body.innerText == ""){
            box.setAttribute("hidden", true);
        }
    }
}

// onchange handler for file input
function imageUrlHandler() {
    var imgUrl = document.querySelector("#imageUrl");
    var file = document.querySelector("input[type=file]").files[0];
    var reader = new FileReader();

    reader.onloadend = function() {
        imgUrl.value = reader.result;
    };

    if (file) {
        reader.readAsDataURL(file);
    } else {
        preview.src = "";
    }
}


const radios = document.querySelectorAll("input.sortBy");
const adminRadios = document.querySelectorAll("input.adminSortBy");

if (radios !== null) {
    const filter = new Filter();
    filter.main("filter", radios);
} 

if (adminRadios !== null) {
    const adminFilter = new Filter();
    adminFilter.main("adminFilter", adminRadios);
}

cleanUp();

