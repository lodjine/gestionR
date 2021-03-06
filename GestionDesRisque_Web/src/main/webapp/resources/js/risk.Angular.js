//Demo of Searching Sorting and Pagination of Table with AngularJS - Advance Example

var myApp = angular.module('riskApp', []);

//Not Necessary to Create Service, Same can be done in COntroller also as method like add() method
myApp.service('filteredListService', function () {

    this.searched = function (valLists, toSearch) {
        return _.filter(valLists,

        function (i) {
            /* Search Text in all 3 fields */
            return searchUtil(i, toSearch);
        });
    };

    this.paged = function (valLists, pageSize) {
        retVal = [];
        for (var i = 0; i < valLists.length; i++) {
            if (i % pageSize === 0) {
                retVal[Math.floor(i / pageSize)] = [valLists[i]];
            } else {
                retVal[Math.floor(i / pageSize)].push(valLists[i]);
            }
        }
        return retVal;
    };
  

});

//Inject Custom Service Created by us and Global service $filter. This is one way of specifying dependency Injection
var TableCtrl = myApp.controller('TableCtrl', function ($scope, $filter, filteredListService) {

    $scope.pageSize = 10;
  
    $scope.allItems = [];
    $scope.mesValList = [];
    $scope.vulValList = [];
    $scope.impValList = [];
    $scope.total = [];
    $scope.mesList = [];
    $scope.vulList = [];
    $scope.impList = [];
   
    
    $scope.getRisk = function(){
    	
    		$scope.allItems = getAllRisks($scope.ProcSelect.repeatSelect,$scope.typeSelect.repeatSelect) ;
    	
    	
    	$scope.filteredList = $scope.allItems;
        $scope.pagination();
        
        $scope.resetAll();
    }
    $scope.getRiskWithFilter = function(){
    	
    		$scope.allItems = getRisksss($scope.ProcSelect.repeatSelect,$scope.typeSelect.repeatSelect,$scope.revSelect.repeatSelect) ;
    	
    		
    	
    	
    	$scope.filteredList = $scope.allItems;
        $scope.pagination();
        $scope.resetAll();
    }
   
    $scope.MesureSelect = {
    	    repeatSelect: null,
    	    availableOptions: getMesure(),
    	   };
    $scope.vulSelect = {
    	    repeatSelect: null,
    	    availableOptions: getVul(),
    	   };
    $scope.impSelect = {
    	    repeatSelect: null,
    	    availableOptions: getImp(),
    	   };
    
    $scope.ProcSelect = {
    	    repeatSelect: null,
    	    availableOptions: getProc(),
    	   };
    
    $scope.reverse = false;

    $scope.resetAll = function () {
        $scope.filteredList = $scope.allItems;
        $scope.MesureId = 0;
        $scope.MesureLabel = '';
        $scope.MesureValue = '';
        $scope.VulId = 0;
        $scope.VulLabel = '';
        $scope.VulValue = '';
        $scope.ImpId = 0;
        $scope.ImpLabel = '';
        $scope.ImpValue = '';
        $scope.searchText = '';
        $scope.currentPage = 0;
        $scope.Header = ['', '', ''];
        $scope.MesureSelect = {
        	    repeatSelect: null,
        	    availableOptions: getMesure(),
        	   };
        $scope.vulSelect = {
        	    repeatSelect: null,
        	    availableOptions: getVul(),
        	   };
        $scope.impSelect = {
        	    repeatSelect: null,
        	    availableOptions: getImp(),
        	   };
    }

    $scope.add = function () {
    	var i = 0 ; 
    		if($scope.allItems.confId == 0){
          i=  saveRisk($scope.risqueLabel,$scope.allItems[0].confId);
           }else{
            	 i=  saveRisk($scope.risqueLabel,$scope.allItems[0].confId);
           }
          $scope.filteredList = $scope.allItems;
          $scope.pagination();
          $scope.resetAll();
    }
    $scope.addMesure = function () {
    	
    	UpdateConfWithNewObeject($scope.MesureLabel,$scope.allItems[0].confId,$scope.MesureValue,"Mesure") ;
    	 $scope.allItems = getDummyData();
    	 $scope.filteredList = $scope.allItems;
         $scope.pagination();
         $scope.resetAll();
    }
    $scope.addVul = function () {
    	UpdateConfWithNewObeject($scope.VulLabel,$scope.allItems[0].confId,$scope.VulValue,"Vul") ;
    	$scope.allItems = getDummyData();
   	 $scope.filteredList = $scope.allItems;
        $scope.pagination();
        $scope.resetAll();
    }
    $scope.addImp = function () {
    	UpdateConfWithNewObeject($scope.ImpLabel,$scope.allItems[0].confId,$scope.ImpValue,"impl") ;
    	$scope.allItems = getDummyData();
   	 $scope.filteredList = $scope.allItems;
        $scope.pagination();
        $scope.resetAll();
    }
    $scope.search = function () {
        $scope.filteredList = filteredListService.searched($scope.allItems, $scope.searchText);

        if ($scope.searchText == '') {
            $scope.filteredList = $scope.allItems;
        }
        $scope.pagination();
    }

    // Calculate Total Number of Pages based on Search Result
    $scope.pagination = function () {
    	if($scope.ProcSelect.repeatSelect != null){
    		
        $scope.ItemsByPage = filteredListService.paged($scope.filteredList, $scope.pageSize);
       
        
        
    }
    };

    $scope.setPage = function () {
        $scope.currentPage = this.n;
    };

    $scope.firstPage = function () {
        $scope.currentPage = 0;
    };

    $scope.lastPage = function () {
        $scope.currentPage = $scope.ItemsByPage.length - 1;
    };
    
    $scope.modifyMesure= function (index) {
    		
    	$scope.MesureId    = $scope.allItems[0].mesures[index].mesureId;
    	$scope.MesureLabel = $scope.allItems[0].mesures[index].mesureLabel;
        $scope.MesureValue = $scope.allItems[0].mesures[index].value;
        
    }
   
    $scope.modifyVul= function (index) {
		
    	$scope.VulId 	= $scope.allItems[0].vulnerabs[index].vulnId;
    	$scope.VulLabel = $scope.allItems[0].vulnerabs[index].vulnLabel;
        $scope.VulValue = $scope.allItems[0].vulnerabs[index].value;
        
    }
 $scope.modifyImp= function (index) {
		
    	$scope.ImpId 	= $scope.allItems[0].impacts[index].impactId;
    	$scope.ImpLabel = $scope.allItems[0].impacts[index].impactLabel;
        $scope.ImpValue = $scope.allItems[0].impacts[index].value;
        
    }
    
 $scope.updateMesure = function(){
 	
 	if($scope.MesureSelect.repeatSelect == null){
 		
 		updateMesure($scope.MesureId,$scope.MesureLabel,$scope.MesureValue) ; 
 		$scope.mesureValue = parseInt($scope.mesureValue) + parseInt($scope.MesureValue) ;
     	$scope.total = parseInt($scope.mesureValue) + parseInt($scope.vulnValue)+ parseInt($scope.impactsValue) ;
 		
 	}else{
 		for(var i =0 ; i<  $scope.MesureSelect.availableOptions.length; i++){
 			if( $scope.MesureSelect.availableOptions[i].mesureId == $scope.MesureSelect.repeatSelect ){
 				var mesv = $scope.MesureSelect.availableOptions[i].value ;
 			}
 		}
 		$scope.mesureValue = parseInt($scope.mesureValue) + parseInt(mesv) ;
     	$scope.total = parseInt($scope.mesureValue) + parseInt($scope.vulnValue)+ parseInt($scope.impactsValue) ;
 		UpdateConfWithOldObject($scope.allItems[0].confId,"Mesure",$scope.MesureSelect.repeatSelect) ; 
 	}
 	
 	$scope.allItems = getDummyData() ;
 	$scope.filteredList = $scope.allItems;
      
      $scope.pagination();
      $scope.resetAll();
 }
$scope.updateVul = function(){
 	
 	if($scope.vulSelect.repeatSelect == null){
 		updateVul($scope.VulId,$scope.VulLabel,$scope.VulValue) ; 
 		$scope.vulnValue = parseInt($scope.vulnValue) + parseInt($scope.VulValue) ;
     	$scope.total = parseInt($scope.mesureValue) + parseInt($scope.vulnValue)+ parseInt($scope.impactsValue) ;
 	}else{
 		for(var i =0 ; i<  $scope.vulSelect.availableOptions.length; i++){
 			if( $scope.vulSelect.availableOptions[i].vulnId == $scope.vulSelect.repeatSelect ){
 				var mesv = $scope.vulSelect.availableOptions[i].value ;
 			}
 		}
 		$scope.vulnValue = parseInt($scope.vulnValue) + parseInt(mesv) ;
     	$scope.total = parseInt($scope.mesureValue) + parseInt($scope.vulnValue)+ parseInt($scope.impactsValue) ;
 		UpdateConfWithOldObject($scope.allItems[0].confId,"Vul",$scope.vulSelect.repeatSelect) ; 
 	}
 	
 	$scope.allItems = getDummyData() ;
 	$scope.filteredList = $scope.allItems;
      
      $scope.pagination();
      $scope.resetAll();
 }
$scope.updateImp = function(){
	
	if($scope.impSelect.repeatSelect == null){
		updateImp($scope.ImpId,$scope.ImpLabel,$scope.ImpValue) ; 
		$scope.impactsValue = parseInt($scope.impactsValue) + parseInt($scope.ImpValue) ;
  	$scope.total = parseInt($scope.mesureValue) + parseInt($scope.vulnValue)+ parseInt($scope.impactsValue) ;
	}else{
		for(var i =0 ; i<  $scope.impSelect.availableOptions.length; i++){
			if( $scope.impSelect.availableOptions[i].impactId == $scope.impSelect.repeatSelect ){
				var mesv = $scope.impSelect.availableOptions[i].value ;
			}
		}
		$scope.impactsValue = parseInt($scope.impactsValue) + parseInt(mesv) ;
  	$scope.total = parseInt($scope.mesureValue) + parseInt($scope.vulnValue)+ parseInt($scope.impactsValue) ;
		UpdateConfWithOldObject($scope.allItems[0].confId,"Imp",$scope.impSelect.repeatSelect) ; 
	}
	
	$scope.allItems = getDummyData() ;
	$scope.filteredList = $scope.allItems;
   
   $scope.pagination();
   $scope.resetAll();
}
    
    $scope.deleteMesure= function(index){
    	 
    	deleteObject($scope.allItems[0].mesures[index].mesureId,"Mesure",$scope.allItems[0].confId);
    	$scope.allItems[0].mesures.splice(index, 1);
    	
    	var mesureValue = 0 ; 
        for (var i = 0 ; i<$scope.allItems[0].mesures.length ; i++){
        	mesureValue = mesureValue + $scope.allItems[0].mesures[i].value ;  
        	
        }
        var vulnValue = 0 ; 
        for (var i = 0 ; i<$scope.allItems[0].vulnerabs.length ; i++){
        	vulnValue = vulnValue + $scope.allItems[0].vulnerabs[i].value ;  
        	
        }
        var impactsValue = 0 ; 
        for (var i = 0 ; i<$scope.allItems[0].impacts.length ; i++){
        	impactsValue = impactsValue + $scope.allItems[0].impacts[i].value ;  
        	
        }
        
        $scope.mesureValue = mesureValue ;
        $scope.vulnValue = vulnValue ;
        $scope.impactsValue = impactsValue ;
        $scope.total = mesureValue + vulnValue + impactsValue ;
    	
    	
    	 $scope.filteredList = $scope.allItems;
         
         $scope.pagination();
         $scope.resetAll();
         
    }
    
    $scope.deleteVul= function(index){
    	deleteObject($scope.allItems[0].mesures[index].vulnId,"Vul",$scope.allItems[0].confId);
    	$scope.allItems[0].vulnerabs.splice(index, 1);
    	
    	var mesureValue = 0 ; 
        for (var i = 0 ; i<$scope.allItems[0].mesures.length ; i++){
        	mesureValue = mesureValue + $scope.allItems[0].mesures[i].value ;  
        	
        }
        var vulnValue = 0 ; 
        for (var i = 0 ; i<$scope.allItems[0].vulnerabs.length ; i++){
        	vulnValue = vulnValue + $scope.allItems[0].vulnerabs[i].value ;  
        	
        }
        var impactsValue = 0 ; 
        for (var i = 0 ; i<$scope.allItems[0].impacts.length ; i++){
        	impactsValue = impactsValue + $scope.allItems[0].impacts[i].value ;  
        	
        }
        
        $scope.mesureValue = mesureValue ;
        $scope.vulnValue = vulnValue ;
        $scope.impactsValue = impactsValue ;
        $scope.total = mesureValue + vulnValue + impactsValue ;
    	
    	
    	 $scope.filteredList = $scope.allItems;
         
         $scope.pagination();
         $scope.resetAll();
    }
    $scope.deleteImp= function(index){
    	deleteObject($scope.allItems[0].impacts[index].vulnId,"imp",$scope.allItems[0].impactId);
    	$scope.allItems[0].impacts.splice(index, 1);
    	
    	var mesureValue = 0 ; 
        for (var i = 0 ; i<$scope.allItems[0].mesures.length ; i++){
        	mesureValue = mesureValue + $scope.allItems[0].mesures[i].value ;  
        	
        }
        var vulnValue = 0 ; 
        for (var i = 0 ; i<$scope.allItems[0].vulnerabs.length ; i++){
        	vulnValue = vulnValue + $scope.allItems[0].vulnerabs[i].value ;  
        	
        }
        var impactsValue = 0 ; 
        for (var i = 0 ; i<$scope.allItems[0].impacts.length ; i++){
        	impactsValue = impactsValue + $scope.allItems[0].impacts[i].value ;  
        	
        }
        
        $scope.mesureValue = mesureValue ;
        $scope.vulnValue = vulnValue ;
        $scope.impactsValue = impactsValue ;
        $scope.total = mesureValue + vulnValue + impactsValue ;
    	
    	
    	 $scope.filteredList = $scope.allItems;
         
         $scope.pagination();
         $scope.resetAll();
    }
    
    
    
    $scope.mergeUser = function(){
    	$scope.add() ;
    }

    $scope.range = function (input, total) {
        var ret = [];
        if (!total) {
            total = input;
            input = 0;
        }
        for (var i = input; i < total; i++) {
            if (i != 0 && i != total - 1) {
                ret.push(i);
            }
        }
        return ret;
    };

    $scope.sort = function (sortBy) {
    $scope.resetAll();

        //$scope.columnToOrder = sortBy;

        //$Filter - Standard Service
        //$scope.filteredList = $filter('orderBy')($scope.filteredList, $scope.columnToOrder, $scope.reverse);

//        if ($scope.reverse) iconName = 'glyphicon glyphicon-chevron-up';
//        else iconName = 'glyphicon glyphicon-chevron-down';
//
//        if (sortBy === 'email') {
//            $scope.Header[0] = iconName;
//        } else if (sortBy === 'lastName') {
//            $scope.Header[1] = iconName;
//        } else {
//            $scope.Header[2] = iconName;
//        }
//
//        $scope.reverse = !$scope.reverse;

        $scope.pagination();
    };

    //By Default sort ny Name
    $scope.sort('id');

});

function searchUtil(item, toSearch) {
    /* Search Text in all 3 fields */
    return (item.id.toLowerCase().indexOf(toSearch.toLowerCase()) > -1 || item.label.toLowerCase().indexOf(toSearch.toLowerCase()) > -1 || item.value == toSearch) ? true : false;
}




function UpdateConfWithNewObeject(label,confId,value,type){
	var xd = 0 ;
	$.ajax({
	    url:'/GestionDesRisque_Web/updateConf/'+label+'/'+confId+'/'+value+'/'+type+'/',
	    dataType:'json',
	    type:'get',
	    async:false,
	    success: function(data) {
		      xd= data ; 
		    }
	});
	return xd ;
}
function UpdateConfWithOldObject(confId,type,id){
	var xd = 0 ;
	$.ajax({
	    url:'/GestionDesRisque_Web/updateConfWithOldObject/'+confId+'/'+type+'/'+id+'/',
	    dataType:'json',
	    type:'get',
	    async:false,
	    success: function(data) {
		      xd= data ; 
		    }
	});
	return xd ;
}


function deleteObject(id,type,confId){
	$.ajax({
	    url:'/GestionDesRisque_Web/deleteObject/'+id+'/'+type+'/'+confId+'/',
	    dataType:'json',
	    type:'get',
	    async:false
	
	});
}

function getMesure() {
	
	var xxx = "" ; 
	$.ajax({
	    url:'/GestionDesRisque_Web/SeekMesure',
	    dataType:'json',
	    type:'get',
	    async:false,
	    success: function(data) {
	      xxx= data ; 
	    }
	
	});
	
	 console.log(xxx);
	 
	return xxx ; 
 
}
function getVul() {
	
	var xxx = "" ; 
	$.ajax({
	    url:'/GestionDesRisque_Web/SeekVulnerabilite',
	    dataType:'json',
	    type:'get',
	    async:false,
	    success: function(data) {
	      xxx= data ; 
	    }
	
	});
	
	 console.log(xxx);
	 
	return xxx ; 
 
}
function getImp() {
	
	var xxx = "" ; 
	$.ajax({
	    url:'/GestionDesRisque_Web/SeekImpact',
	    dataType:'json',
	    type:'get',
	    async:false,
	    success: function(data) {
	      xxx= data ; 
	    }
	
	});
	
	 console.log(xxx);
	 
	return xxx ; 
 
}

function updateMesure(id,label,value){
	$.ajax({
	    url:'/GestionDesRisque_Web/updateMesure/'+id+'/'+label+'/'+value+'/',
	    dataType:'json',
	    type:'get',
	    async:false
	
	});
}
function updateVul(id,label,value){
	$.ajax({
	    url:'/GestionDesRisque_Web/updateVulnerabilite/'+id+'/'+label+'/'+value+'/',
	    dataType:'json',
	    type:'get',
	    async:false
	
	});
}function updateImp(id,label,value){
	$.ajax({
	    url:'/GestionDesRisque_Web/updateImpact/'+id+'/'+label+'/'+value+'/',
	    dataType:'json',
	    type:'get',
	    async:false
	
	});
}




function getProc() {
	
	var xxx = "" ; 
	$.ajax({
	    url:'/GestionDesRisque_Web/seekProcesForConf/',
	    dataType:'json',
	    type:'get',
	    async:false,
	    success: function(data) {
	      xxx= data ; 
	    }
	
	});
	
	 console.log(xxx);
	 
	return xxx ; 
 
}



function getAllConfs(x){
	var xxx = "" ; 
	$.ajax({
	    url:'/GestionDesRisque_Web/seekConfByProc/'+x+'/',
	    dataType:'json',
	    type:'get',
	    async:false,
	    success: function(data) {
	      xxx= data ; 
	    }
	
	});
	
	 console.log(xxx);
	 
	return xxx ;
}
function getAllDisps(x){
	var xxx = "" ; 
	$.ajax({
	    url:'/GestionDesRisque_Web/seekDispByProc/'+x+'/',
	    dataType:'json',
	    type:'get',
	    async:false,
	    success: function(data) {
	      xxx= data ; 
	    }
	
	});
	
	 console.log(xxx);
	 
	return xxx ;
}
function getAllIntgs(x){
	var xxx = "" ; 
	$.ajax({
	    url:'/GestionDesRisque_Web/seekIntByProc/'+x+'/',
	    dataType:'json',
	    type:'get',
	    async:false,
	    success: function(data) {
	      xxx= data ; 
	    }
	
	});
	
	 console.log(xxx);
	 
	return xxx ; 
}

function getAllConfsREV(x,y){
	var xxx = "" ; 
	$.ajax({
	    url:'/GestionDesRisque_Web/seekConfByProcRev/'+x+'/'+y+'/',
	    dataType:'json',
	    type:'get',
	    async:false,
	    success: function(data) {
	      xxx= data ; 
	    }
	
	});
	
	 console.log(xxx);
	 
	return xxx ;
}
function getAllDispsREV(x,y){
	var xxx = "" ; 
	$.ajax({
	    url:'/GestionDesRisque_Web/seekDispByProcRev/'+x+'/'+y+'/',
	    dataType:'json',
	    type:'get',
	    async:false,
	    success: function(data) {
	      xxx= data ; 
	    }
	
	});
	
	 console.log(xxx);
	 
	return xxx ;
}
function getAllIntgsREV(x,y){
	var xxx = "" ; 
	$.ajax({
	    url:'/GestionDesRisque_Web/seekIntByProcRev/'+x+'/'+y+'/',
	    dataType:'json',
	    type:'get',
	    async:false,
	    success: function(data) {
	      xxx= data ; 
	    }
	
	});
	
	 console.log(xxx);
	 
	return xxx ; 
}
function getAllRisks(x,y){
	
	var xxx = "" ; 
	$.ajax({
	    url:'/GestionDesRisque_Web/seekRisqueByProc/'+x+'/'+y+'/',
	    dataType:'json',
	    type:'get',
	    async:false,
	    success: function(data) {
	      xxx= data ; 
	    }
	
	});
	
	 console.log(xxx);
	 
	return xxx ; 
	
}

function getRisksss(x,y,z){
	var xxx = "" ; 
	$.ajax({
	    url:'/GestionDesRisque_Web/seekRisqueByProc/'+x+'/'+y+'/'+z+'/',
	    dataType:'json',
	    type:'get',
	    async:false,
	    success: function(data) {
	      xxx= data ; 
	    }
	
	});
	
	 console.log(xxx);
	 
	return xxx ; 	
}
