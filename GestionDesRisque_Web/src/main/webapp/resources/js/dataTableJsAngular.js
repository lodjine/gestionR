//Demo of Searching Sorting and Pagination of Table with AngularJS - Advance Example

var myApp = angular.module('myApp', []);

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
  
    $scope.allItems = getDummyData();
   
    $scope.reverse = false;

    $scope.resetAll = function () {
        $scope.filteredList = $scope.allItems;
        $scope.email = '';
        $scope.lastName = '';
        $scope.firstName = '';
        $scope.searchText = '';
        $scope.currentPage = 0;
        $scope.Header = ['', '', ''];
    }

    $scope.add = function () {
    	var bool = false ;
    	
    	for(var i = 0 ; i<$scope.allItems.length ; i++) {
    				if ($scope.allItems[i].email == $scope.email){
    					bool = true ; 
    				}
    	}
    	if(bool == false){
      
            saveUser($scope.email,$scope.firstName,$scope.lastName);
            $scope.allItems=getDummyData() ;
         
    	}else{
    		updateUser($scope.email,$scope.firstName,$scope.lastName);
    	}
      
    	$scope.allItems=getDummyData() ;

       
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
        $scope.ItemsByPage = filteredListService.paged($scope.filteredList, $scope.pageSize);
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
    
    $scope.modifyUser= function (index) {
    	
    	$scope.email = $scope.allItems[index].email;
        $scope.firstName = $scope.allItems[index].firstName ;
        $scope.lastName =  $scope.allItems[index].lastName;
        
    }
    
    $scope.deleteUser = function(index){
    	
    	deleteUser($scope.allItems[index].email);
    	$scope.allItems.splice(index, 1);
    	
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
    $scope.sort('email');

});

function searchUtil(item, toSearch) {
    /* Search Text in all 3 fields */
    return (item.lastName.toLowerCase().indexOf(toSearch.toLowerCase()) > -1 || item.email.toLowerCase().indexOf(toSearch.toLowerCase()) > -1 || item.firstName == toSearch) ? true : false;
}

/*Get Dummy Data for Example*/
function getDummyData() {
	var xxx = "" ; 
	$.ajax({
	    url:'/GestionDesRisque_Web/SeekUsers',
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

function saveUser(email,firstName,lastName){
	$.ajax({
	    url:'/GestionDesRisque_Web/PersisteUser/'+email+'/'+firstName+'/'+lastName+'/',
	    dataType:'json',
	    type:'get',
	    async:false
	
	});
}
function updateUser(email,firstName,lastName){
	$.ajax({
	    url:'/GestionDesRisque_Web/updateUser/'+email+'/'+firstName+'/'+lastName+'/',
	    dataType:'json',
	    type:'get',
	    async:false
	
	});
}

function deleteUser(email){
	$.ajax({
	    url:'/GestionDesRisque_Web/deleteUser/'+email+'/',
	    dataType:'json',
	    type:'get',
	    async:false
	
	});
}
