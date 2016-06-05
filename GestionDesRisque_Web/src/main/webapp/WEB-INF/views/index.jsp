<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">

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

  <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/moment/moment.min.js"></script>
    <script src="resources/js/chartjs/chart.min.js"></script>
    <script src="resources/js/progressbar/bootstrap-progressbar.min.js"></script>
    <script src="resources/js/icheck/icheck.min.js"></script>
    <script src="resources/js/custom.js"></script>
    <script src="resources/js/pace/pace.min.js"></script>
  <script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/chartJs.js"></script>
  <!--[if lt IE 9]>
        <script src="../assets/js/ie8-responsive-file-warning.js"></script>
        <![endif]-->

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

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

          <!-- sidebar menu -->
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
                    <li><a href="/GestionDesRisque_Web/alerte">Alerte</a>
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
                  <img src="resources/images/LogoTalan.jpg" alt="">${firstname } ${lastname }
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
			<div class="right_col" role="main">

				<div class="">
					<div class="page-title">


						<div class="title_right">
							<div
								class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">

							</div>
						</div>
					</div>
					<div class="clearfix"></div>

					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel" style="height: 595px;">
								<div class="x_title">
									<h2>
										Gestion Des Risques <small>Talan</small>
									</h2>
								</div>
								
								
								<div class="row tile_count">
            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
              <span class="count_top"><i class="fa fa-user"></i> Total Utlisateur</span>
              <div class="count">${TotalUser}</div>
             
            </div>
            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
              <span class="count_top"><i class="fa  fa-list-ul"></i> Total Processus</span>
              <div class="count">${TotalProc}</div>
         
            </div>
            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
              <span class="count_top"><i class="fa fa-ban"></i> Total Risque </span>
              <div class="count green">${TotalRisk}</div>
   
            </div>
            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
              <span class="count_top"><i class="fa  fa-check-square"></i> Total Action</span>
              <div class="count">${TotalAction}</div>
 
            </div>
         <br>
				<div class="col-md-6 col-sm-4">
                  <div class="x_title">
                    <h2>Action par Status<small>terminé/non terminé</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content"><iframe class="chartjs-hidden-iframe" style="width: 100%; display: block; border: 0px; height: 0px; margin: 0px; position: absolute; left: 0px; right: 0px; top: 0px; bottom: 0px;"></iframe>
                    <canvas id="canvasDoughnut" width="484" height="242" style="width: 484px; height: 242px;"></canvas>
                  </div>
                </div>				
				<div class="col-md-6 col-sm-4">
                  <div class="x_title">
                    <h2>Risque par processus<small></small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <select class="selectProcId" onchange="onchangeProc()" >
                        <option>select processus</option>
                        <c:forEach items="${procs}" var="proc">
                        <option value="${proc.procId}">${proc.processus}</option>
                        </c:forEach>
                        </select>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content"><iframe class="chartjs-hidden-iframe" style="width: 100%; display: block; border: 0px; height: 0px; margin: 0px; position: absolute; left: 0px; right: 0px; top: 0px; bottom: 0px;"></iframe>
                    <canvas id="mybarChart" width="484" height="242" style="width: 484px; height: 242px;"></canvas>
                  </div>
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
  <script>
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

   <script>
   
   
Chart.defaults.global.legend = {
	      enabled: false
	    };

// Doughnut chart
var x = getActionNT()  ; 
var y = getActionT() ;
var ctx = document.getElementById("canvasDoughnut");
var data = {
  labels: [
    "Action Non Termine",
	"Action  Termine"  
  ],
  datasets: [{
    data: [x ,y],
    backgroundColor: [
      "#26B99A",
      "#3498DB"
    ],
    hoverBackgroundColor: [
      "#36CAAB",
      "#49A9EA"
    ]

  }]
};

var canvasDoughnut = new Chart(ctx, {
  type: 'doughnut',
  tooltipFillColor: "rgba(51, 51, 51, 0.55)",
  data: data
});


// Bar chart
var ctx = document.getElementById("mybarChart");
var mybarChart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels: ["Extrem", "Fort", "Moyen", "Faible"],
    datasets: [{
      label: '# of Votes',
      backgroundColor: "#26B99A",
      data: [0, 0, 0, 0]
    }, {
      label: '# of Votes',
      backgroundColor: "#03586A",
      data: [0, 0, 0, 0]
    }, , {
        label: '# of Votes',
        backgroundColor: "#455C73",
        data: [0, 0, 0, 0]
      }, , {
          label: '# of Votes',
          backgroundColor: "#9B59B6",
          data: [0, 0, 0, 0]
        }
    ]
  },

  options: {
    scales: {
      yAxes: [{
        ticks: {
          beginAtZero: true
        }
      }]
    }
  }
});

function onchangeProc(){
	
	var id = $('.selectProcId').val(); 
	alert(id) ;
	 var x =  getRiskByProc(id)  ;
	 alert(x);
//Bar chart
var ctx = document.getElementById("mybarChart");
var mybarChart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels: ["Extrem", "Fort", "Moyen", "Faible"],
    datasets: [{
      label: '# risque',
      backgroundColor: ["#26B99A","#03586A","#9B59B6","#2A3F54"],
      data: x
    }
    ]
  },

  options: {
    scales: {
      yAxes: [{
        ticks: {
          beginAtZero: true
        }
      }]
    }
  }
});
}
   </script>

</body>

</html>
