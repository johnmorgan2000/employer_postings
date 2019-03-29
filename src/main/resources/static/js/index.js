class Filter {

    main(storageName, radios) {
            if (localStorage.getItem(storageName) !== null) { 
                var filter = localStorage.getItem(storageName);
                for (var radio of radios) {
                    if (radio.value === filter) {
                        radio.checked = true;
                        localStorage.clear();
                    }
                }
            }
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
        var finalNum = Math.ceil(highNum * .10);
        finalNum *= 10;
    }
    else{
        finalNum = highNum;
    }
    return finalNum;
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

function listenForSearch() {
    const searchBar = document.querySelector(".searchBar");
    searchBar.addEventListener("input", function() {
        searchApplications();
    });
}

function searchApplications() {
    var searchInput = document
        .querySelector(".searchBar")
        .value.toLowerCase();
    var jobContainers = document.querySelectorAll(
        ".job-box-link"
    );
    for (const job of jobContainers) {
        var name = job.querySelector(".job-box-title").innerText.toLowerCase();
        var position = job.querySelector(".job-box-position").innerText.toLowerCase();
        if (name.includes(searchInput) || position.includes(searchInput)) {
            job.classList.remove("searched");
        } else {
            job.classList.add("searched");
        }
    }
}

// radio button checker
var userRadios = document.querySelectorAll("input.sortBy");
var adminRadios = document.querySelectorAll("input.adminSortBy");

if (userRadios.length !== 0) {
    adminRadios = null;
    const userFilter = new Filter();
    window.onload = function() {
        userFilter.main("filter", userRadios);
    }
    
} else {
    const adminFilter = new Filter();
    window.onload = function() {
        adminFilter.main("adminFilter", adminRadios);
    }
    
}

cleanUp();
topChartDisplay(viewElements, bars);
listenForSearch();


