var interval = 1000 * 60 * 60; // where X is your every X minutes
var lonlat;

var url = 'https://tom.cologne.codefor.de/feinstaubwerte/service/sensordata/';
var data;
var success;

function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition, showError);
    } else {
        x.innerHTML = "Geolocation is not supported by this browser.";
    }
}

function showPosition(position) {
	lonlat = position.coords.longitude + "/" + position.coords.latitude;
	url = url + lonlat;
	dataCall();
    console.log(url);
}

function showError(error) {
    switch(error.code) {
        case error.PERMISSION_DENIED:
            x.innerHTML = "User denied the request for Geolocation."
            break;
        case error.POSITION_UNAVAILABLE:
            x.innerHTML = "Location information is unavailable."
            break;
        case error.TIMEOUT:
            x.innerHTML = "The request to get user location timed out."
            break;
        case error.UNKNOWN_ERROR:
            x.innerHTML = "An unknown error occurred."
            break;
    }
}

function dataCall() {
		
	$.ajax({
		  dataType: "json",
		  url: url,
		  data: data,
		  success: function(data) {
			  $( "span.p1" ).replaceWith( "<font size='12'>" + data.p1 + "</font> &#181;g / m&sup3;" );	  
			  $( "span.p2" ).replaceWith( "<font size='12'>" + data.p2 + "</font> &#181;g / m&sup3;" );	  

			  $( "span.distance" ).replaceWith( "Entfernung: " + data.distance + " m" );	  
			  $( "span.datum" ).replaceWith( "letzte Messung: " + data.datum );	  
			  $( "span.temperature" ).replaceWith( "Temperatur: " + data.temperature + "˚ C" );	  
			  $( "span.humidity" ).replaceWith( "Luftfeuchte: " + data.humidity + "%" );	  
		  }
		});
	};
	
getLocation();

// setInterval(dataCall, interval);

