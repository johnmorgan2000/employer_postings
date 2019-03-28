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
// Helps create the top chart display
const viewElements = document.querySelectorAll("p.job-views-bubble");
const bars = document.querySelectorAll(".chart-bar");


function topChartDisplay(viewElements, bars){
    var maxNum = getMaxForViewChart(viewElements);
    
    for (var i =0; i < viewElements.length; i++){
        var percentage = (parseInt(viewElements[i].innerText) * 100) / maxNum;
        bars[i].style.width = percentage + "%";
    }
}

function getMaxForViewChart(views){
    var highNum =0;
    var maxNum;
    
    for (var view of views){
        view = parseInt(view.innerText);
        if (view > highNum){
            highNum = view;
        }
    }

    if (highNum % 10 !== 0){
        var roundedUp = Math.ceil(highNum * .10);
        roundedUp *= 10;
    }
    return roundedUp;
}

// Hide empty detail boxes
function cleanUp(){
    var boxes = document.querySelectorAll(".detail-box");
    for (const box of boxes){
        var body = box.querySelector(".detail-body");
        if (body.innerText == ""){
            box.setAttribute("hidden", true);
        }
    }
}


// Onchange handler for file input
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
topChartDisplay(viewElements, bars);


