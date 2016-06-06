
function getActionNT() {
	 var xxx = "" ; 
	 $.ajax({
	     url:'/GestionDesRisque_Web/getNTermineAction',
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
function getActionT() {
	 var xxx = "" ; 
	 $.ajax({
	     url:'/GestionDesRisque_Web/getTermineAction',
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

function getRiskByProc(id) {
	 var xxx = "" ; 
	 $.ajax({
	     url:'/GestionDesRisque_Web/getRisqueByProc/'+id+'/',
	     dataType:'json',
	     type:'get',
	     async:false,
	     success: function(data) {
	       xxx= data ; 
	     }
	 
	 });
	 
	 return xxx ; 
	 
	}


