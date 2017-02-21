var interval = 1000 * 60; // where X is your every X minutes

var url = 'https://tom.cologne.codefor.de/feinstaubwerte/service/sensordata/7.0/50.959';
var data;
var success;

var dataCall = function dataCall() {
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
	
dataCall();

setInterval(dataCall, interval);

