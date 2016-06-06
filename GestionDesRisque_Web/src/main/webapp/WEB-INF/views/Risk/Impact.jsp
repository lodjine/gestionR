<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
  <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Meta, title, CSS, favicons, etc. -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Talan* | GR</title>

  <!-- Bootstrap core CSS -->

  <link href="resources/css/bootstrap.min.css" rel="stylesheet">

  <link href="resources/fonts/css/font-awesome.min.css" rel="stylesheet">
  <link href="resources/css/animate.min.css" rel="stylesheet">

  <!-- Custom styling plus plugins -->
  <link href="resources/css/custom.css" rel="stylesheet">
  <link href="resources/css/icheck/flat/green.css" rel="stylesheet">
  
  
  
  

  <link href="resources/js/datatables/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />
  <link href="resources/js/datatables/buttons.bootstrap.min.css" rel="stylesheet" type="text/css" />
  <link href="resources/js/datatables/fixedHeader.bootstrap.min.css" rel="stylesheet" type="text/css" />
  <link href="resources/js/datatables/responsive.bootstrap.min.css" rel="stylesheet" type="text/css" />
  <link href="resources/js/datatables/scroller.bootstrap.min.css" rel="stylesheet" type="text/css" />

  <script src="resources/js/jquery.min.js"></script>
   <script src="resources/js/angular.min.js"></script>
    
     <script src="resources/js/Impact.Angular.js"></script>



</head>


<body class="nav-md">

  <div class="container body">


    <div class="main_container">

      <div class="col-md-3 left_col">
        <div class="left_col scroll-view">

          <div class="navbar nav_title" style="border: 0;">
            <a href="index.html" class="site_title"><img src="resources/images/LogoTalan.jpg" height="40px" width="50px"> <span>&nbsp;&nbsp; TALAN</span></a>
          </div>
          <div class="clearfix"></div>


          

          <br />

                    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

            <div class="menu_section">
              <h3>General</h3>
              <ul class="nav side-menu">
                <li><a><i class="fa fa-home"></i> Processus <span class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu" style="display: none">
                    <li><a href="/GestionDesRisque_Web/MenuProces">Actifs</a>
                    </li>
                    <li><a href="/GestionDesRisque_Web/MenuSsProcess">Sub-Process</a>
                    </li>
                    <li><a href="/GestionDesRisque_Web/MenuActivite">Activities</a>
                    </li>
                    <li><a href="/GestionDesRisque_Web/MenuInformation">Informations</a>
                    </li>
                  </ul>
                </li>
                <li><a><i class="fa fa-edit"></i> Risque <span class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu" style="display: none">
                    <li><a href="form.html">Risque</a>
                    </li>
                   <li><a href="/GestionDesRisque_Web/showConfidentialiteMenu">Confidentialite</a>
                    </li>
                    <li><a href="/GestionDesRisque_Web/showintgMenu">Integrite</a>
                    </li>
                    <li><a href="/GestionDesRisque_Web/showdispMenu">Disponibilite</a>
                    </li>
                    <li><a href="/GestionDesRisque_Web/showMesureMenu">Mesure</a>
                    </li>
                    <li><a href="/GestionDesRisque_Web/showVulnerabiliteMenu">Vulnerabilite</a>
                    </li>
                     <li><a href="/GestionDesRisque_Web/showImpactMenu">Impact/Consequence</a>
                    </li>
                  
                  </ul>
                </li>
                <li><a><i class="fa fa-desktop"></i>Utilisateur<span class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu" style="display: none">
                    <li><a href="/GestionDesRisque_Web/MenuAdmin">Administrateur</a>
                    </li>
                    <li><a href="media_gallery.html">Responsable</a>
                    </li>
                    <li><a href="typography.html">Poste</a>
                    </li>
                  </ul>
                </li>
                <li><a><i class="fa fa-table"></i> Action <span class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu" style="display: none">
                    <li><a href="tables.html">Action</a>
                    </li>
                    <li><a href="tables_dynamic.html">Alerte</a>
                    </li>
                  </ul>
                </li>
              </ul>
            </div>
            

          </div>
          <!-- /sidebar menu -->

          <!-- /menu footer buttons -->
        
          <!-- /menu footer buttons -->
        </div>
      </div>

      <!-- top navigation -->
      <div class="top_nav">

        <div class="nav_menu">
          <nav class="" role="navigation">
            <div class="nav toggle">
              <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>

            <ul class="nav navbar-nav navbar-right">
              <li class="">
                <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                  <img src="resources/images/LogoTalan.jpg" alt="">John Doe
                  <span class=" fa fa-angle-down"></span>
                </a>
                <ul class="dropdown-menu dropdown-usermenu pull-right">
                  <li><a href="javascript:;">  Profile</a>
                  </li>
                 
                  <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                  </li>
                </ul>
              </li>

              <li role="presentation" class="dropdown">
                <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                  <i class="fa fa-envelope-o"></i>
                  <span class="badge bg-green">6</span>
                </a>
                <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
          
                </ul>
              </li>

            </ul>
          </nav>
        </div>

      </div>
      <!-- /top navigation -->

      <!-- page content -->
			<div class="right_col" role="main" style="height: auto;">

				<div class="" style="height: auto;">
					<div class="page-title">


						<div class="title_right" style="height: auto;">
							<div
								class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">

							</div>
						</div>
					</div>
					<div class="clearfix"></div>

					<div class="row"  style="height: auto;">
						<div class="col-md-12 col-sm-12 col-xs-12" style="height: auto;">
							<div class="x_panel" style="height: auto;">
								<div class="x_title">
									<h2>
										Gestion Des Risques <small>Talan</small>
									</h2>
								</div>
								
								        <div class="clearfix"></div>
             
              
				<h3 class="box-title" style="margin-top: 1%; margin-left: 2%">Impact/Consequence</h3>
				
		<br />

	<div ng-app="ImpactApp" style="height: auto;">
    <div ng-controller="TableCtrl">
        <div class="input-group">
            <input class="form-control" ng-model="searchText" placeholder="Search" type="search" ng-change="search()" /> <span class="input-group-addon">
      <span class="glyphicon glyphicon-search"></span>
</span>
        </div>
        <table class="table  table-hover data-table myTable">
            <thead>
                <tr>
                    <th class="id"> <a href="#" ng-click="sort('impactId',$event)">ID
                         <span class="{{Header[0]}}"></span>
                         </a>

                    </th>
                    <th class="Implabel"> <a ng-click="sort('impactLabel')" href="#"> Label
                         <span class="{{Header[1]}}"></span></a>
                    </th>
                    <th class="value"> <a ng-click="sort('value')" href="#"> Value
                     <span class="{{Header[2]}}"></span></a>
                    </th>
                     <th class="value"> <a ng-click="sort('value')" href="#"> Risque
                     <span class="{{Header[2]}}"></span></a>
                    </th>
                    <th class="value"> <a ng-click="sort('value')" href="#"> Type
                     <span class="{{Header[2]}}"></span></a>
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr ng-repeat="item in ItemsByPage[currentPage] | orderBy:columnToOrder:reverse">
                    <td>{{item.impactId}}</td>
                    <td>{{item.impactLabel}}</td>
                    <td>{{item.value}}</td>
                     <td>{{item.risque.risqueLabel}}</td>
                    <td>{{item.critere}}</td>
                    
                    <td><button type="button" ng-click="modifyUser($index)" class="btn btn-warning"><i class="fa fa-edit"></i></button>
                     <button type="button" ng-click="deleteUser($index)" class="btn btn-danger"><i class="fa fa-trash-o"></i></button>
                    </td>
                </tr>
            </tbody>
        </table>
        <ul class="pagination pagination-sm">
            <li ng-class="{active:0}"><a href="#" ng-click="firstPage()">First</a>

            </li>
            <li ng-repeat="n in range(ItemsByPage.length)"> <a href="#" ng-click="setPage()" ng-bind="n+1">1</a>

            </li>
            <li><a href="#" ng-click="lastPage()">Last</a>

            </li>
        </ul>
        <div class="row">
            <div class="col-xs-2">
                <input type="hidden" ng-model="impactId" class="form-control" placeholder="id" hidden="true">
            </div>
            <div class="col-xs-2">
                <input type="text" ng-model="impactLabel" class="form-control" placeholder="value">
            </div>
            <div class="col-xs-2">
                <input type="number" ng-model="value" class="form-control" placeholder="value">
            </div>
             <div class="col-xs-2">
                <select name="rSelect" class="select2"id="mSelect" ng-model="RiskSelect.repeatSelect" style="width: 100%">
                	 <option value="">Risk</option>
     				 <option ng-repeat="risk in RiskSelect.availableOptions" value="{{risk.risqueId}}">{{risk.risqueLabel}}</option>
   			   </select>
            </div>
            <div class="col-xs-2">
                <select name="tSelect" class="select2"id="mSelect" ng-model="typeSelect.repeatSelect" style="width: 100%">
                	 <option value="">Type</option>
     				 <option value="Confidentialite">Confidentialite </option>
     				 <option value="Disponibilite">Disponibilite</option>
     				 <option value="Integrite">Integrite</option>
   			   </select>
            </div>
            <div class="col-xs-1">
                <button ng-click="add()" type="button" class="btn btn-primary"> <span class="glyphicon glyphicon-plus"></span>
                <button ng-click="mergeUser()" type="button" class="btn btn-primary"> <span class="glyphicon glyphicon-edit"></span>
               

                </button>
            </div>
        </div>
    </div>
    <!-- Ends Controller -->
</div>

                 
                </div>
                
              
             
						</div>
						
							</div>
							
						</div>
						
						</div>
				
								
					   			
								
						
						 
			
			<!-- /page content -->

      <!-- footer content -->
      <footer>
        <div class="pull-right">
          Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
        </div>
        <div class="clearfix"></div>
      </footer>
      <!-- /footer content -->
    </div>
  </div>

  <div id="custom_notifications" class="custom-notifications dsp_none">
    <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
    </ul>
    <div class="clearfix"></div>
    <div id="notif-group" class="tabbed_notifications"></div>
  </div>

  <script src="resources/js/bootstrap.min.js"></script>

  <!-- bootstrap progress js -->
  <script src="resources/js/progressbar/bootstrap-progressbar.min.js"></script>
  <!-- icheck -->
  <script src="resources/js/icheck/icheck.min.js"></script>
  <!-- pace -->
  <script src="resources/js/pace/pace.min.js"></script>
  <script src="resources/js/custom.js"></script>
  <!-- form validation -->
  <script src="resources/js/validator/validator.js"></script>
  <script src="resources/js/datatables/jquery.dataTables.min.js"></script>
        <script src="resources/js/datatables/dataTables.bootstrap.js"></script>
        <script src="resources/js/datatables/dataTables.buttons.min.js"></script>
        <script src="resources/js/datatables/buttons.bootstrap.min.js"></script>
        <script src="resources/js/datatables/jszip.min.js"></script>
        <script src="resources/js/datatables/pdfmake.min.js"></script>
        <script src="resources/js/datatables/vfs_fonts.js"></script>
        <script src="resources/js/datatables/buttons.html5.min.js"></script>
        <script src="resources/js/datatables/buttons.print.min.js"></script>
        <script src="resources/js/datatables/dataTables.fixedHeader.min.js"></script>
        <script src="resources/js/datatables/dataTables.keyTable.min.js"></script>
        <script src="resources/js/datatables/dataTables.responsive.min.js"></script>
        <script src="resources/js/datatables/responsive.bootstrap.min.js"></script>
        <script src="resources/js/datatables/dataTables.scroller.min.js"></script>
  <script>
  $(document).ready(function() {
      $('#datatable').dataTable();
     });
		
  
  $('#boutonLoop')
  .click(
  		function() {

  			e = $('.byCodeClass').find(':selected').val();
  			if(e != ""){

  		$(".byCodeClass").before('<input type="hidden"  name="byCode" value='+e+'  />');

  			$('#seekbouton').trigger("click");
  			}
  			
  			

  		});
  
  	$('.select2').select2();
    // initialize the validator function
    validator.message['date'] = 'not a real date';

    // validate a field on "blur" event, a 'select' on 'change' event & a '.reuired' classed multifield on 'keyup':
    $('form')
      .on('blur', 'input[required], input.optional, select.required', validator.checkField)
      .on('change', 'select.required', validator.checkField)
      .on('keypress', 'input[required][pattern]', validator.keypress);

    $('.multi.required')
      .on('keyup blur', 'input', function() {
        validator.checkField.apply($(this).siblings().last()[0]);
      });

    // bind the validation to the form submit event
    //$('#send').click('submit');//.prop('disabled', true);

    $('form').submit(function(e) {
      e.preventDefault();
      var submit = true;
      // evaluate the form using generic validaing
      if (!validator.checkAll($(this))) {
        submit = false;
      }

      if (submit)
        this.submit();
      return false;
    });

    /* FOR DEMO ONLY */
    $('#vfields').change(function() {
      $('form').toggleClass('mode2');
    }).prop('checked', false);

    $('#alerts').change(function() {
      validator.defaults.alerts = (this.checked) ? false : true;
      if (this.checked)
        $('form .alert').remove();
    }).prop('checked', false);
  </script>

</body>

</html>
