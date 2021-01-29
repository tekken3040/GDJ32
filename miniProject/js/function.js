// 지도를 표시할 div
var container = document.getElementById('map');
// 초기값
var options = {
	center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	level: 3    // 지도의 확대 레벨
};

// 지도를 생성합니다.
var map;

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

let address = '서울시 금천구 가산디지털2로 115';

function updateCenterCoordinate(){
    if(navigator.geolocation){
        navigator.geolocation.getCurrentPosition(function(position){
            options.center = new kakao.maps.LatLng(position.coords.latitude, position.coords.longitude);
            map = new kakao.maps.Map(container, options);
        });
    }
    else{
        alert('Not Support!');
    }
}

let watchID;
function watchLocation() {
    if (navigator.geolocation) {
        watchID = navigator.geolocation.watchPosition(function(position){
            // 마커가 표시될 위치입니다 
            var markerPosition  = new kakao.maps.LatLng(position.coords.latitude, position.coords.longitude); 

            // 마커를 생성합니다
            var marker = new kakao.maps.Marker({
                position: markerPosition
            });
            // 마커 위치로 지도 중심 이동
            map.setCenter(markerPosition);
            // 기존 마커 삭제
            marker.setMap(null);
            // 마커가 지도 위에 표시되도록 설정합니다
            marker.setMap(map);
        });
    } 
    else { 
      alert('Not Support!');
    }
}

function watchLocationStop(){
    if(navigator.geolocation)
    {
        navigator.geolocation.clearWatch(watchID);
    }
}

function formSearch(){
    address = document.querySelector('.input-address').value;

    // 주소-좌표 변환 객체를 생성합니다
    geocoder.addressSearch(address, function(result, status){
        // 정상적으로 검색이 완료됐으면 
        if (status === kakao.maps.services.Status.OK) {
            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
            // 결과값으로 받은 위치를 마커로 표시합니다
            var marker = new kakao.maps.Marker({
                map: map,
                position: coords
            });
            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
            map.setCenter(coords);
        }
    });
}

map = new kakao.maps.Map(container, options);

updateCenterCoordinate();

document.querySelector('.button-search').addEventListener('click', function(){
    formSearch();
});

document.querySelector('.input-address').addEventListener('keypress',function(event){
    if(event.key == 'Enter')
    {
        formSearch();
    }
});

let watchStatus = false;

document.querySelector('.button-position').addEventListener('click', function(){
    if(!watchStatus)
    {
        this.setAttribute('class', 'button-position active');
        watchLocation();
        watchStatus = true;
    }
    else
    {
        this.setAttribute('class', 'button-position');
        watchLocationStop();
        watchStatus = false;
    }
});